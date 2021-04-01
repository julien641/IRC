import React, { Component } from "react";
import Middle from "./Middle";
import './register.css'
class RegisterApp extends Component{
    render(){
        return(
             <div className= "register body">
        <div className="register logodiv">
      <Logo/>
      </div>
        <div className = "register OuterLoginbox">
        
        <Middle/>
        
        </div>
        <div className="register bottom"></div>
      </div>);
    }


}
export default RegisterApp;

function Logo(){
    return(< img  className="register logo" src= "img/irc.PNG" alt = "" width="300" height="200"/> );
}