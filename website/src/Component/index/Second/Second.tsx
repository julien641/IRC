import React, { Component } from "react";
import "./Second.css";
import ApplicationImg from "./ApplicationImg";
import Description from "./Description";

class Second extends Component {
  render() {
    return (
      <div className="Second">
        <div className="Inner">
          <Description />
          <ApplicationImg />
        </div>
      </div>
    );
  }
}

export default Second;
