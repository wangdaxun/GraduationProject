import React, {Component} from "react";
import "./JobMain.scss"
import {getQueryVariable} from './../../../util/commonUtil';
import {companyByJob, oneJob} from "../../../store/actionCreator";
import {connect} from "react-redux";
class JobMain extends Component{
  componentDidMount() {
    let id = getQueryVariable("id");
    this.props.getOneJob(id);
    this.props.getCompany(id);
  }

  render(){
    // 需要的参数：职位要求，职位职责
    const jobDetail = this.props.data.jobDetail;
    const companyDetail = this.props.data.companyDetail;
    let jobZhiwei = [];
    let jobZhize = [];
    if(jobDetail.job_zhiwei){
      jobZhiwei = jobDetail.job_zhiwei.split(";");
    }
    if(jobDetail.job_zhize){
      jobZhize = jobDetail.job_zhize.split(";");
    }
    return(
        <div className="jobMain">
          <div className="jobMain__zhiwei">
            <div className="jobMain__title">
              <span>职位描述</span>
            </div>
            <div className="jobMain__zhiwei--content">
              <span>职位要求：</span>
              {
                jobZhiwei.map((zhiwei,index)=>(
                    zhiwei ? <p key={index}>{zhiwei}</p>  : ""
                ))
              }
            </div>
          </div>
          <div className="jobMain__zhize">
            <div className="jobMain__title">
              <span>职位职责</span>
            </div>
            <div className="jobMain__zhize--content">
              <span>职位职责：</span>
              {
                jobZhize.map((zhize,index)=>(
                    zhize ?
                        <p key={index}>{zhize}</p> : ""
                ))
              }
            </div>
          </div>
          <div className="jobMain__company">
            <div className="jobMain__title">
              <span>公司介绍</span>
            </div>
            <div className="jobMain__company--content">
              <span>
                {companyDetail.company_desc}
              </span>
              <div style={{color: "#53cac3"}}><a href={"./companyDetail?id="+companyDetail.company_id}>查看全部</a></div>
            </div>
          </div>
          <div className="jobMain__area">
            <div className="jobMain__title">
              <span>工作地址</span>
            </div>
            <div className="jobMain__area--content">
              <span>{jobDetail.job_area}</span>
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
      jobDetail: state.jobDetail,
      companyDetail: state.companyDetail
    }
  }
};
const mapDispatchToProps = (dispatch)=>({
  getOneJob(id) {
    oneJob(dispatch,id);
  },
  getCompany(id) {
    companyByJob(dispatch,id);
  }
});
export default connect(mapStateToProps, mapDispatchToProps)(JobMain);

