import "./App.css";
import "./Top.css";
import "./Second.css";
import React, { Component, useState } from "react";
import { NavLink } from "react-router-dom";
import Cookies from "universal-cookie";
interface IState {}
interface IProps {
  auth: boolean;
}

class Index extends Component<IProps, IState> {
  render() {
    let topright:JSX.Element;
    if (!this.props.auth) {
      topright = (
        <>
          <HeaderLogin link="/forms/login" label="Login" />
          <HeaderLogin link="/forms/register" label="Sign Up" />
        </>
      );
    } else {
      topright = (
        <>
          <HeaderLogin link="/forms/login" label="Profile" />
          <LogOut />
        </>
      );
    }

    return (
      <div>
        <div className="Top">
          <Logo
            Logolink="img/irc_default.png"
            hoverlogolink="img/irc.png"
            websitelink="/"
          />
          <header className="header">
            <HeaderLink text="Download" websitelink="/download" />
            <Headerhref text="GitHub" websitelink="https://github.com/julien641/IRC" />
            <HeaderLink text="Why IRC" websitelink="/Why-IRC" />
            <HeaderLink text="About" websitelink="/About" />
            {topright}
          </header>
        </div>
        <div className="Second">
          <div className="Inner">
            <div className="descrCountainer">
              <h1 className="Descrtitle">Internet Relay Chat</h1>
              <p className="DescrParagraph">
                This is my personal project to create a internet relay chat. The
                goal of this project is to have a server owner host the server I
                created and customize the different roles, permissions, channel
                and many other features. Then a user using my client will be
                able to chat, play games and many other features with other
                connected clients.
              </p>
            </div>
           
              <img
                className="ApplicationImg"
                alt="ApplicationImg"
                src="img/main.PNG"
              ></img>
          
          </div>
        </div>
      </div>
    );
  }
}
export default Index;
function LogOut() {
  return (
    <button onClick={logingout} className="loginbutton">
      Logout
    </button>
  );
}
function logingout() {
  const cookies = new Cookies();
  cookies.remove("login");
  window.location.href = "/";
}
function HeaderLink(props: { text: string; websitelink: string }) {
  return (
    <NavLink className="headerlink" to={props.websitelink}>
      <span> {props.text}</span>
    </NavLink>
  );
}
function Headerhref(props: { text: string; websitelink: string }) {
  return (
    <a className="headerlink" href={props.websitelink}>
      <span> {props.text}</span>
    </a>
  );
}

function HeaderLogin(props: { link: string; label: string }) {
  return (
    <NavLink to={props.link}>
      <button className="loginbutton">{props.label}</button>
    </NavLink>
  );
}

function Logo(props: {
  Logolink: string;
  hoverlogolink: string;
  websitelink: string;
}) {
  const [logo, setlogo] = useState(props.hoverlogolink);

  return (
    <NavLink className="logo" to={props.websitelink}>
      <img
        onMouseOver={(e) => setlogo(props.Logolink)}
        onMouseOut={(e) => setlogo(props.hoverlogolink)}
        className="logoimg"
        src={logo}
        alt=""
      ></img>
    </NavLink>
  );
}
