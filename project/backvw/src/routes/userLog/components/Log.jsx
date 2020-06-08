import React, {Component, createRef} from "react";
import {userLogIn} from "./../../../api/userApi";
import "./User.scss";

class Login extends Component{
  email = createRef();
  password = createRef();
  userLogIn = ()=>{
    const email = this.email.current.value;
    console.log(email);
    const password = this.password.current.value;
    userLogIn(email,password)
        .then((data)=>{
          if(data.msg.status === 200){
            alert(data.msg.message);
            localStorage.removeItem("user");
            localStorage.setItem("user", JSON.stringify(data.user));
            window.location.href = "/index";
          }else{
            alert(data.msg.message);
          }
        })
  };
  render(){
    return(
        <div className="User Log">
          <div className="Log__left">
            <span><a href="./index" className="a_hover">简单聘,让招聘更简单</a></span>
          </div>
          <div className="Log__right">
            <div className="Log__right--opi">
              <span>密码登录</span>
            </div>
            <div className="Log__right--in">
              <div><input type="text" className="in-email" ref={this.email} placeholder="邮箱"/></div>
              <div><input type="password" className="in-password" ref={this.password} placeholder="密码"/></div>
            </div>
            <div className="Log__right--log">
              <div className="log__btn" onClick={this.userLogIn}>登录</div>
            </div>
          </div>
        </div>
    )
  }
}
export default Login;
