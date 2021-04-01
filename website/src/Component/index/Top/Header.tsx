import React, { Component } from "react";
import HeaderLink from "./HeaderLink";
import HeaderLogin from "./HeaderLogin";

class Header extends Component {
  render() {
    return (
      <header className="header">
        <HeaderLink text="Download" websitelink="/download" />
        <HeaderLink text="Why IRC" websitelink="/Why-IRC" />
        <HeaderLink text="About" websitelink="/About" />
        <HeaderLogin />
      </header>
    );
  }
}
export default Header;
