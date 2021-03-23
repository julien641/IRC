import React,{Component} from 'react';

class Logo extends Component<{websitelink : string,Logolink:string}>{

    render(){
        return(
            <a className="logoa" href = {this.props.websitelink}>
               <img className="logoimg" src= {this.props.Logolink} alt = "">
               </img>
               </a>)


    }


}
export default Logo