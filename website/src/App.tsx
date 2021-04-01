import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Index from "./Component/index/Index";
import FormCountainer from "./Component/login/FormCountainer";

function App() {





  

  return (
    <div className="App">
      <Router>
        <Switch>
          <Route path="/" exact component={() => <Index />} />
          <Route
            path="/forms"
            
            component={() => <FormCountainer />}
          />
         
        </Switch>
      </Router>
    </div>
  );
}

export default App;
