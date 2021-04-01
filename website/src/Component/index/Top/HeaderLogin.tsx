import React, { Component } from "react";
import { Link } from "react-router-dom";
class HeaderLogin extends Component {
  render() {
    return (
      <Link to="/forms/login">
        <button className="loginbutton">Login</button>
      </Link>
    );
  }
}

export default HeaderLogin;
