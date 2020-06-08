import React, {Component} from "react";
import Sign from "./components/Sign"
import "./SignUp.scss";

class SignUp extends Component{
  render(){
    return(
        <div className="SignUp">
          <Sign/>
        </div>
    )
  }
}
export default SignUp;
