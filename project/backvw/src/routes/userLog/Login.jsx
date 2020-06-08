import React, {Component} from "react";
import Log from "./components/Log"
import "./Login.scss";

class Login extends Component{
  render(){
    return(
        <div className="Login">
          <Log/>
        </div>
    )
  }
}
export default Login;
