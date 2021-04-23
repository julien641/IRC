import React, { Component, useEffect, useState } from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import { getTokenSourceMapRange } from "typescript";
import Cookies from "universal-cookie";
import Index from "./Component/index/Index";
import FormCountainer from "./Component/login/FormCountainer";
interface IState {
  auth: boolean;
}
interface IProps {}
function Apphook() {
  const [auth, setauth] = useState(false);
  useEffect(() => {
    const cookies = new Cookies();
    let token = cookies.get("login");
    if (token !== undefined) {
      checkToken(token, auth, setauth);
    }else{
      getToken();

    }
  }, []);
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route path="/forms">
            <FormCountainer auth={auth} />
          </Route>
          <Route>
            <Index auth={auth} />
          </Route>
        </Switch>
      </Router>
    </div>
  );
}
function getToken(){


  
}


function checkToken(token: any, auth: boolean, setauth: any) {
  fetch("http://192.155.88.98:8080/Internet-relay-Chat-Main-Server-0.0.1-SNAPSHOT/api/test/user", {
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
    .then((data) => {
      if (auth === false) {
        setauth(true);
      }
    })
    .catch(() => {
      setauth(false);
    });
}

class App extends Component<IProps, IState> {
  constructor(props: IProps) {
    super(props);
    this.state = { auth: false };
    this.checkToken = this.checkToken.bind(this);
    this.processToken = this.processToken.bind(this);
    this.catchTokenerror = this.catchTokenerror.bind(this);
  }
  checkToken(token: any) {
    fetch("http://192.155.88.98:8080/Internet-relay-Chat-Main-Server-0.0.1-SNAPSHOT/api/test/user", {
      method: "get",
      headers: {
        "Content-type": "application/x-www-form-urlencoded",
        Authorization: token.type + " " + token.token,
        
      },
    })
      .then((res) => {
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
