import React, {Component} from "react";
import face from "./../img/Iconfont/face.png";
import "./../main.scss";
import "./TopNav.scss";
class TopNav extends Component{

  state = {
    user: {}
  };

  clickActive = ()=> {};

  componentDidMount() {
    let user = localStorage.getItem("user");
    this.setState({
      user
    })
  }

  render(){
    let user = this.state.user;
    let userMsg;
    if(user) {
      userMsg = (
          <div className="topNav__right">
            <div className="topNav__right--userIn">
              <div className="user__signUp"><a href="./resume"><span>简历</span></a></div>
              <div className="user__signUp"><a href="./userCenter"><span>个人中心</span></a></div>
              <div className="user__face"><img src={face} alt=""/></div>
            </div>
          </div>
      )
    } else{
      userMsg = (
          <div className="topNav__right">
            <ul>
              <li><span>上传简历</span></li>
              <li><span>我要找工作</span></li>
              <li><span>我要招聘</span></li>
            </ul>
            <div className="topNav__right--user">
              <div className="user__signUp"><a href="./signUp"><span>注册</span></a></div>
              <div className="user__LogIn"><a href="./logIn"><span>登录</span></a></div>
            </div>
          </div>
      )
    }
    return(
        <div className="topNav">
          <div className="inner topNav__inner">
            <div className="topNav__left">
              <ul>
                <li><span><a href="./index">首页</a></span></li>
                <li><span><a href="./job">职位</a></span></li>
                <li><span><a href="./company">校园</a></span></li>
                <li><span><a href="./company">公司</a></span></li>
                <li><span>资讯</span></li>
              </ul>
            </div>
            {userMsg}
          </div>
        </div>
    )
  }
}
export default TopNav;


