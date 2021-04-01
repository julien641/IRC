import React, { Component } from "react";

class Description extends Component {
  render() {
    return (
      <div className="descrCountainer">
        <h1 className="Descrtitle">Internet Relay Chat</h1>
        <p className="DescrParagraph">
          This is my personal project to create a internet relay chat. The goal
          of this project is to have a server owner host the server I created
          and customize the different roles, permissions, channel and many other
          features. Then a user using my client will be able to chat, play games
          and many other features with other connected clients.
        </p>
      </div>
    );
  }
}
export default Description;
