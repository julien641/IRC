

import React,{Component} from 'react';

interface IProps{
    websitelink : string,Logolink:string,hoverlogolink:string
}
interface IState{
    logo:string
}




class Logo extends Component<IProps,IState>{

    constructor(props:IProps){
        super(props);
        this.state ={logo:this.props.hoverlogolink};
    }
    
  
    render(){
       
        return(
            <a className="logo" href = {this.props.websitelink}>
                <img onMouseOver={e => onMouseOver(this)} onMouseOut={ e => onMouseout(this)} className="logoimg" src= {this.state.logo} alt = "">
               </img>
               </a>)


    }


}

function onMouseOver(logo:Logo){
    logo.setState({ logo:logo.props.Logolink})

}
function onMouseout(logo:Logo){
    logo.setState({logo:logo.props.hoverlogolink})

}

export default Logo