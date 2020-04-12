import React, {Component} from "react";
import "./../main.scss";
import "./TopNav.scss";
class TopNav extends Component{

  clickActive = ()=> {};

  componentDidMount() {

  }

  render(){
    return(
        <div className="topNav">
          <div className="inner topNav__inner">
            <div className="topNav__left">
              <ul>
                <li><span>首页</span></li>
                <li><span>职位</span></li>
                <li><span>校园</span></li>
                <li><span>公司</span></li>
                <li><span>资讯</span></li>
              </ul>
            </div>
            <div className="topNav__right">
              <ul>
                <li><span>上传简历</span></li>
                <li><span>我要找工作</span></li>
                <li><span>我要招聘</span></li>
              </ul>
              <div className="topNav__right--user">
                <div className="user__signUp"><span>注册</span></div>
                <div className="user__LogIn"><span>登录</span></div>
              </div>
            </div>
          </div>
        </div>
    )
  }
}
export default TopNav;


