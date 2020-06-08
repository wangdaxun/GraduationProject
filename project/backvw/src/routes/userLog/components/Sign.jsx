import React, {Component,createRef} from "react";
import {sendEmail,userSignUp} from './../../../api/userApi'
import "./User.scss";
class Sign extends Component{
  state = {
    yzValue : "发送验证码",
    click : true
  };
  email = createRef();
  password = createRef();
  repassword = createRef();
  yzBtn = createRef();
  yanz = createRef();
  name = createRef();
  sendEmail = ()=>{
    const email = this.email.current.value;
    if(!email){
      alert("输入的内容不能为空！");
      return;
    }
    if(!this.state.click){
      alert("请过段时间再发送！");
      return;
    }
    const reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
    if(!reg.test(email)){
      alert("输入的内容不符合邮箱格式！");
      return;
    }
    sendEmail(email)
        .then((data)=>{
          console.log(data);
          if(data.status !== 200){
            alert(data.message);
          }else{
            alert("已发送！");
            let countDown = 60;
            this.setState({
              yzValue: countDown+"s内不能发送",
              click: false
            });
            this.timer = setInterval(() => {
              countDown--;
              this.setState({
                yzValue: countDown+"s内不能发送",
                click:false
              });
              if (countDown === 0) {
                clearInterval(this.timer);
                //this.vertificationText = '重新发送';
                this.setState({
                  yzValue: "重新发送",
                  click:true
                });
                //this.vertificationDisabled = false
              }
            }, 1000);
          }
        });
  };
  userSignUp =()=>{
    const email = this.email.current.value;
    const name = this.name.current.value;
    const password = this.password.current.value;
    console.log(password);
    const repassword = this.repassword.current.value;
    const yanz = this.yanz.current.value;
    if(! (email || password || repassword || yanz || name)){
      alert("输入的内容不能为空");
      return;
    }
    if(password !== repassword){
      alert("两次输入的密码不一致");
      return;
    }
    const reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
    if(!reg.test(email)){
      alert("输入的内容不符合邮箱格式！");
      return;
    }
    userSignUp(email, password, name, yanz)
        .then((data)=>{
          console.log(data);
          if(data.status === 200){
            alert("注册成功!");
            window.location.href = "./login";
          }else{
            alert(data.message);
          }
        })

  };
  render(){
    return(
        <div className="User Sign">
          <div className="Sign__left">
            <span><a href="./index" className="a_hover">简单聘,让招聘更简单</a></span>
          </div>
          <div className="Sign__right">
            <div className="Sign__right--opi">
              <span>通过邮箱注册</span>
            </div>
            <div className="Sign__right--in">
              <div><input type="text" className="in-email" ref={this.email} placeholder="邮箱"/></div>
              <div><input type="password" className="in-password" ref={this.password} placeholder="密码"/></div>
              <div><input type="password" className="in-password" ref={this.repassword} placeholder="确认密码"/></div>
              <div><input type="name" className="in-name" ref={this.name} placeholder="真实姓名"/></div>
              <div style={{position:"relative"}}>
                <input type="text" className="in-password" ref={this.yanz} placeholder="验证码"/>
                <button className="yanzheng" ref={this.yzBtn} onClick={this.sendEmail}>{this.state.yzValue}</button>
              </div>
            </div>
            <div className="Sign__right--log">
              <div className="log__btn" onClick={this.userSignUp}>注册</div>
            </div>
          </div>
        </div>
    )
  }
}
export default Sign;
