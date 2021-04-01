import React,{Component} from 'react';
import Header from './Header'
import Logo from './Logo'
import './Top.css';
class Top extends Component {

render(){
    //const isloggedin :Boolean = false;

    return ( 
        <div className ="Top">
             <Logo  Logolink="img/irc_default.png" hoverlogolink ="img/irc.png" websitelink = "/" />
             <Header/>
       </div>

    )


}


}

export default Top;
