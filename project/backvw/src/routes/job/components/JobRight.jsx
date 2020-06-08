import React, {Component} from "react";
import "./JobRight.scss";
import {companyByJob, oneJob} from "../../../store/actionCreator";
import {getQueryVariable} from "../../../util/commonUtil";
import {connect} from "react-redux";
class JobRight extends Component{
  componentDidMount() {
    let id = getQueryVariable("id");
    this.props.getCompany(id);
  }
  render(){
    const companyDetail = this.props.data.companyDetail;
    return(
        <div className="jobRight">
          <div className="jobRight__top">公司基本信息</div>
          <div className="jobRight__title">
            <img src={companyDetail.company_img} alt=""/>
            <span>{companyDetail.company_name}</span>
          </div>
          <div className="jobRight__content">
            <span>{companyDetail.company_shangshi}</span>
            <span>{companyDetail.company_size}</span>
            <span>{companyDetail.company_type}</span>
          </div>
        </div>
    )
  }
}
const mapStateToProps = (state) =>{
  // 从state转到props
  return {
    data:{
      companyDetail: state.companyDetail
    }
  }
};
const mapDispatchToProps = (dispatch)=>({
  getCompany(id) {
    companyByJob(dispatch,id);
  }
});
export default connect(mapStateToProps, mapDispatchToProps)(JobRight);

