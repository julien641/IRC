import React,{Component} from 'react';

class HeaderLink extends Component<{ websitelink:string, text:string}>{



    render(){


        return(
            <a className="headerlink "  href = {this.props.websitelink}>
                   <span> {this.props.text}</span>
            </a>
           )
    }


}



export default HeaderLink