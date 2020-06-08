import React, {Component} from "react";
import "./JobTop.scss";
import {oneJob} from "../../../store/actionCreator";
import {addJobApply} from "./../../../api/jobApi";
import {connect} from "react-redux";
import {getQueryVariable} from "../../../util/commonUtil";
class JobTop extends Component{
  id = getQueryVariable("id");
  componentDidMount() {
    this.props.getOneJob(this.id);
  }
  talk =  ()=>{
    let user = JSON.parse(localStorage.getItem("user"));
    let userId = user.user_id;
    addJobApply(userId, this.id)
        .then((data)=>{
          console.log(data);
          if(data.success){
            alert("已向公司发送沟通请求！");
          }else{
            alert("您已经发送过这个请求了");
          }
        })
  };
  render(){
    // 需要的参数： 招聘状态，工作名称，工资，工作地点，工作年限，学历
    const jobDetail = this.props.data.jobDetail;
    return(
        <div className="jobTop">
          <div className="inner jobTop__content">
            <div className="jobTop__left">
              <div className="jobTop__left--zhaopin">
                <span>{jobDetail.job_state === 1 ? "招聘中" : "已结束"}</span>
              </div>
              <div className="jobTop__left--name">
                <span style={{color: "#fff", fontWeight: 800}}>{jobDetail.job_name}</span>
                <span style={{color: "#fc6c38", fontWeight: 800}}>{jobDetail.job_salary}</span>
              </div>
              <div className="jobTop__left--area">
                <span>{jobDetail.job_area}*{jobDetail.job_catname}*{jobDetail.job_edu}</span>
              </div>
            </div>
            <div className="jobTop__right">
              <div className="jobTop__right--btn" onClick={this.talk}>
                <span>立即沟通</span>
              </div>
              <div className="jobTop__right--resume">
                <span style={{paddingRight: '100px'}}>完善在线简历</span>
                <span><a href="#">上传附件简历</a></span>
              </div>
            </div>
          </div>
        </div>
    )
  }
}
const mapStateToProps = (state) =>{
  // 从state转到props
  return {
    data:{
      jobDetail: state.jobDetail
    }
  }
};
const mapDispatchToProps = (dispatch)=>({
  getOneJob(id) {
    oneJob(dispatch,id);
  }
});
export default connect(mapStateToProps, mapDispatchToProps)(JobTop);



