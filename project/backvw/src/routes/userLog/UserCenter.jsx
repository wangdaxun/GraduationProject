import React, {Component, createRef} from "react";
import "./UserCenter.scss";
import TopNav from "../../components/TopNav";
import face from "./../../img/Iconfont/face.png";
import {getUser, userSave} from "./../../api/userApi";
class UserCenter extends Component{
  state = {
    userBasic : {

    }
  };
  userName = createRef();
  email = createRef();
  realName = createRef();
  telephone = createRef();
  personal_profile = createRef();
  componentWillMount() {
    let user = JSON.parse(localStorage.getItem("user"));
    getUser(user.user_id)
        .then((data)=>{
          console.log(data);
          this.setState({
            userBasic: data
          });
        })
  }
  save = ()=> {
    let user = this.state.userBasic;
    let userId = JSON.parse(localStorage.getItem("user")).user_id;
    const user_logname = this.userName.current.value ? this.userName.current.value : user.user_logname ? user.user_logname : "";
    const email = this.email.current.value ? this.email.current.value : user.email ? user.email : "";
    const realName = this.realName.current.value ? this.realName.current.value : user.realName ? user.realName : "";
    const telephone = this.telephone.current.value ? this.telephone.current.value : user.telephone ? user.telephone : "";
    const personal_profile = this.personal_profile.current.value ? this.personal_profile.current.value : user.personal_profile ? user.personal_profile : "";
    userSave(user_logname,email,realName,telephone,personal_profile, userId)
        .then((data)=>{
          alert("更新成功！");
          window.location.reload();
        })
  };
  render(){
    let user = this.state.userBasic;
    return(
        <div className="userCenter">
          <TopNav/>
          <div className="userCenter__content">
            <div className="userCenter__main">
              <div className="content">
                <div className="content_main">
                  <ul>
                    <li>
                      <div className="user_img">
                        <div>
                          <img className="user_avator" src={face} alt=""/>
                        </div>
                        <div className="user_btn">
                          <button className="user_btn-bt">修改头像</button>
                        </div>
                      </div>
                    </li>
                    <li>
                      <div>用户名</div>
                      <input type="text" name="userName" ref={this.userName} placeholder={user.user_logname ? user.user_logname : "您还没有设置用户名"} />
                    </li>
                    <li>
                      <div>邮箱</div>
                      <input type="text" name="email" ref={this.email} placeholder={user.email ? user.email : "您还没有设置邮箱"}/>
                    </li>
                    <li>
                      <div>真实姓名</div>
                      <input type="text" name="name" ref={this.realName} placeholder={user.realName ? user.realName : "您还没有设置真实姓名"}/>
                    </li>
                    <li>
                      <div>电话</div>
                      <input type="text" name="phone" ref={this.telephone} placeholder={user.telephone ? user.telephone : "您还没有设置电话"}/>
                    </li>
                    <li>
                      <div>个人优势</div>
                      <textarea style={{height: "150px"}} ref={this.personal_profile} placeholder={user.personal_profile ? user.personal_profile : "您还没有设置个人优势"} name="phone">
                      </textarea>
                    </li>
                  </ul>
                  <button className="save" onClick={this.save}>保存</button>
                </div>
              </div>
            </div>
          </div>
        </div>
    )
  }
}
export default UserCenter;
