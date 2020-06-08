import React, {Component} from "react";
import "./CompanyMain.scss";
import {getQueryVariable} from './../../../util/commonUtil';
import {oneCompany} from './../../../store/actionCreator';
import {connect} from "react-redux";

class CompanyMain extends Component{
  componentDidMount() {
    let id = getQueryVariable("id");
    this.props.getOneCompany(id);
  }

  render(){
    const companyDetail = this.props.data.companyDetail;
    let companyImg = [];
    if(companyDetail.company_envir){
      companyImg = companyDetail.company_envir.split(";");
    }
    return(
        <div className="companyMain">
          <div className="companyMain__jianjie">
            <div className="companyMain__title">
              <span>公司简介</span>
            </div>
            <div className="companyMain__jianjie--content">
              <span>
                {companyDetail.company_desc}
              </span>
            </div>
          </div>
          <div className="companyMain__huanjing">
            <div className="companyMain__title">
              <span>公司环境</span>
            </div>
            <div className="companyMain__huanjing--content">
              {
                companyImg.map((img,index)=>(
                    img ? <div className="companyMain__huanjing--img" key={index}><img src={img} alt=""/></div> : ""
                ))
              }
            </div>
          </div>
          <div className="companyMain__area">
            <div className="companyMain__title">
              <span>公司地址</span>
            </div>
            <div className="companyMain__area--content">
              {companyDetail.company_area}
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
      companyDetail: state.companyDetail
    }
  }
};
const mapDispatchToProps = (dispatch)=>({
  getOneCompany(id) {
    oneCompany(dispatch,id);
  }
});
export default connect(mapStateToProps, mapDispatchToProps)(CompanyMain);
