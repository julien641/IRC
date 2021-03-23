import React,{Component} from 'react';
import Header from './Top/Header'
import Logo from './Top/Logo'
class Top extends Component {

render(){
    const isloggedin :Boolean = false;
    
    if(isloggedin){
    
       

    }else{
      

    }
    return ( 
        <div className ="Top">
             <Logo  Logolink={"img/irc.png"} websitelink = "/" />
             <Header/>
       
       </div>

    )


}


}

export default Top;
