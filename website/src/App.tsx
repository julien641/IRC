import React, { Component } from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Cookies from "universal-cookie";
import Index from "./Component/index/Index";
import FormCountainer from "./Component/login/FormCountainer";
interface IState {
  auth: boolean;
}
interface IProps {}

class App extends Component<IProps, IState> {
  constructor(props: IProps) {
    super(props);
    this.state = { auth: false };
  
    this.checkToken = this.checkToken.bind(this);
    this.processToken = this.processToken.bind(this);
    this.catchTokenerror = this.catchTokenerror.bind(this);
  }
  checkToken(token: any) {
    fetch("http://localhost:8080/api/test/user", {
      method: "get",
      headers: {
        "Content-type": "application/x-www-form-urlencoded",
        Authorization: token.type + " " + token.token,
      },
    })
      .then((res) => {
        console.log(res);
        if (res.status === 200) {
          return res;
        } else {
          throw res;
        }
      })
      .then(this.processToken)
      .catch(this.catchTokenerror);
  }
  catchTokenerror() {
    this.setState((state, props) => {
      return { auth: false };
    });
  }

  processToken(data: any) {
    if (this.state.auth == false) {
      this.setState((state, props) => {
        return { auth: true };
      });
    }
  }
  componentDidMount() {
    const cookies = new Cookies();
    let token = cookies.get("login");
    if (token != undefined) {
      console.log("found token");
      this.checkToken(token);
    } else {
      
    }
  }

  render() {
    return (
      <div className="App">
        <Router>
          <Switch>
            <Route path="/forms">
              <FormCountainer auth={this.state.auth} />
            </Route>
            <Route>
              <Index auth={this.state.auth} />
            </Route>
          </Switch>
        </Router>
      </div>
    );
  }
}
export default App;
