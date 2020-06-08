import React, {Component} from "react";
import zfb from "./../../../img/companyImg/zhifubao.jpg";
import "./CompanyTop.scss";
import {oneCompany} from "../../../store/actionCreator";
import {connect} from "react-redux";
import {getQueryVariable} from "../../../util/commonUtil";
class CompanyTop extends Component{
  componentDidMount() {
    let id = getQueryVariable("id");
    this.props.getOneCompany(id);
  }
  render(){
    const companyDetail = this.props.data.companyDetail;
    return(
        <div className="companyTop">
          <div className="inner companyTop__content">
            <div className="companyTop__left">
              <div className="companyTop__left--img">
                <img src={companyDetail.company_img} alt=""/>
              </div>
              <div className="companyTop__left--main">
                <div className="companyTop__title"><span>{companyDetail.company_name}</span></div>
                <div className="companyTop__desc">{companyDetail.company_shangshi}*{companyDetail.company_size}*{companyDetail.company_type}</div>
              </div>
            </div>
            <div className="companyTop__right">
              <div className="companyTop__right--zhao">
                <span style={{fontSize: "36px"}}>{companyDetail.company_viewnum}</span>
                <span>在招职位</span>
              </div>
              <div className="companyTop__right--resume">
                <span style={{paddingRight: '100px'}}><a href="/resume">完善在线简历</a></span>
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
      companyDetail: state.companyDetail
    }
  }
};
const mapDispatchToProps = (dispatch)=>({
  getOneCompany(id) {
    oneCompany(dispatch,id);
  }
});
export default connect(mapStateToProps, mapDispatchToProps)(CompanyTop);

