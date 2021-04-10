import React, { Component } from "react";
import "./Login.css";

import { arrayform } from "../../interface";
import { Route, Switch } from "react-router-dom";
import Cookies from "universal-cookie";
import AppForm from "./AppForm";
import logo from "./img/irc.png";

interface Iprops {
  auth: boolean;
}

class FormCountainer extends Component<Iprops> {
  render() {
    return (
      <div className="body">
        <div className="logodiv">
          <img className="logo" src={logo} alt="IRC" width="300" height="200" />
        </div>
        <div className="OuterLoginbox">
          <Switch>
          <Route
            path="/forms/login"
            component={() => <AppForm form={this.props.auth?wrongroute():logindata()} class="login" />}
          />
          <Route
            path="/forms/register"
            component={() => <AppForm form={this.props.auth?wrongroute():signupdata()} class="login" />}
          />
          <Route
            component={() => <AppForm form={wrongroute()} class="login" />}
          />
          </Switch>
        </div>
        <div className="bottom"></div>
      </div>
    );
  }
}

function signupdata(): arrayform {
  return {
    form: [
      {
        type: "text",
        placeholder: "Username",
        id: "username",
        name: "username",
        label: "Username:",
        send: true,
        required: true,
      },
      {
        type: "email",
        placeholder: "Email",
        id: "email",
        name: "email",
        label: "Email:",
        send: true,
        required: true,
      },
      {
        type: "password",
        placeholder: "Password",
        id: "password",
        name: "password",
        label: "Password:",
        send: true,
        required: true,
      },
      {
        type: "password",
        placeholder: "Retype password",
        id: "Retype_password",
        name: "Retype_password",
        label: "Retype password:",
        send: false,
        required: true,
      },
    ],
    button: { type: "submit", value: "Submit" },
    link: { label: "", to: "" },
    class: "login",
    header: "Register",
    method: "post",
    url: "http://localhost:8080/api/signup",

    datachecking: function (appform: AppForm) {
      return appform.state.input[2].value === appform.state.input[3].value;
    },
    datahandling: function (data: any, appform: AppForm) {
      console.log(data);
      new Cookies().set("login", { token: data.token, type: data.type });
      window.location.href = "/";
    },

    error: function (error: any, appform: AppForm) {
      console.log("error");

      appform.setState({ error: "Invalid Login" });
    },
  };
}

function wrongroute(): arrayform {
  return {
    form: [],
    class: "login",
    header: "Unauthorized",
    method: "",
    url: "",
    button: { type: "", value: "" },
    link: { label: "", to: "" },
    datachecking: function (appform: AppForm) {
      return true;
    },
    datahandling: function (data: any, appform: AppForm) {},

    error: function (error: any, appform: AppForm) {},
  };
}

function logindata(): arrayform {
  return {
    form: [
      {
        type: "text",
        placeholder: "Username",
        id: "username",
        name: "username",
        label: "Username:",
        send: true,
        required: true,
      },
      {
        type: "password",
        placeholder: "Password",
        id: "password",
        name: "password",
        label: "Password:",
        send: true,
        required: true,
      },
    ],
    button: { type: "submit", value: "Submit" },
    link: { label: "Create an account", to: "/forms/register" },

    class: "login",
    header: "Sign In",
    method: "post",
    url: "http://localhost:8080/api/signin",
    datahandling: function (data: any, appform: AppForm) {
      console.log(data);
      new Cookies().set("login", { token: data.token, type: data.type });
      window.location.href = "/";
    },
    datachecking: function (appform: AppForm) {
      return true;
    },
    error: function (error: any, appform: AppForm) {
      console.log("error");
      /* @ts-ignore */
      appform.setState({ error: "Invalid Login" });
    },
  };
}

export default FormCountainer;
