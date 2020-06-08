import React, {Component} from "react";
import "./JobCardExp.scss"
import {connect} from "react-redux";
import {oneCompany} from "../store/actionCreator";
import JobCard from "./JobCard";
class JobCardExp extends Component{
  componentDidMount() {
    let companyId;
    if(this.props.job){
      companyId = this.props.job.company_id;
    }

  }

  render(){
    // 需要的参数：工作名，工作地点，工资，经验，学历，联系人
    const job = this.props.job;
    console.log(job);
    let companyDetail = {
    };
    if(job.company){
      companyDetail = job.company;
    }
    return(
        <div className="JobCardExp">
          <div className="JobCardExp__content">
            <div className="JobCardExp__text">
              <div className="JobCardExp__text--title">
                <a href={"./jobDetail?id="+job.job_id}><span>{job.job_name}</span><span className="thePri">{"["+job.job_area+"]"}</span></a>
              </div>
              <div className="JobCardExp__text--content">
              <span className="JobCardExp__text--price">
                {job.job_salary}
              </span>
                <span className="vlive"></span>
                <span>{job.job_exper}</span>
                <span className="vlive"></span>
                <span>{job.job_edu}</span>
                <span className="theName"><a href="#">{job.job_lianxiren}</a></span>
              </div>
            </div>
            <div className="JobCardExp__company">
              <div className="JobCardExp__company--content">
                <div className="JobCardExp__company--title">
                  <a href={"./companyDetail?id="+companyDetail.company_id}><span>{companyDetail.company_name}</span></a>
                </div>
                <div className="JobCardExp__company--intro">
                  <span>{companyDetail.company_type}</span>
                  <span className="vlive"></span>
                  <span>{companyDetail.company_shangshi}</span>
                  <span className="vlive"></span>
                  <span>{companyDetail.company_size}</span>
                </div>
              </div>
              <div className="JobCardExp__img">
                <div className="JobCardExp__img--pic">
                  <img src={companyDetail.company_img} alt=""/>
                </div>
              </div>
            </div>
          </div>
          <div className="JobCardExp__bottom">
            <div className="JobCardExp__bottom--job">
              <ul>
                <li><span>JavaScript</span></li>
                <li><span>Webpack</span></li>
                <li><span>React</span></li>
                <li><span>前端开发工程师</span></li>
              </ul>
            </div>
            <div className="JobCardExp__bottom--company">
              <ul>
                <li>全勤奖,</li>
                <li>五险一金,</li>
                <li>员工旅游,</li>
                <li>零食下午茶,</li>
              </ul>
            </div>
          </div>
        </div>
    )
  }
}
const mapStateToProps = (state) =>{
  // 从state转到props
  return {

  }
};
const mapDispatchToProps = (dispatch)=>({
});
export default connect(mapStateToProps, mapDispatchToProps)(JobCardExp);
