import React, {Component} from "react";
import "./JobCard.scss"
import zhifubao from "./../img/companyImg/zhifubao.jpg"
import {connect} from "react-redux";

class JobCard extends Component{
  render(){
    const job = this.props.job;
    // 需要的参数：公司图片，工作名称，地点，经验，学历
    return(
        <div className="JobCard">
          <div className="JobCard__img">
            <div className="JobCard__img--pic">
              <img src={job.job_pic} alt=""/>
            </div>
          </div>
          <div className="JobCard__text">
            <div className="JobCard__text--title">
              <a href={"./jobDetail?id="+job.job_id}><span>{job.job_name}</span></a>
            </div>
            <div className="JobCard__text--content">
              <span>
                {job.job_area}
                <span className="vlive"></span>
                {job.job_exper}
                <span className="vlive"></span>
                {job.job_edu}
              </span>
            </div>
            <div className="JobCard__text--price">
              {job.job_salary}
            </div>
          </div>
        </div>
    )
  }
}
const mapStateToProps = (state) =>{
  // 从state转到props
  return {
    jobList: state.jobList
  }
};
const mapDispatchToProps = (dispatch)=>{
  return {

  }
};
export default connect(mapStateToProps, mapDispatchToProps)(JobCard);
