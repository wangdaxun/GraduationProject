import React, {Component} from "react";
import "./CompanyCardExp.scss"
import zhifubao from "./../img/companyImg/zhifubao.jpg"
import {connect} from "react-redux";
class CompanyCardExp extends Component{
  render(){
    let company = {};
    if(this.props.company){
      company = this.props.company;
    }
    let random = Math.floor(Math.random() * this.props.data.hotZhaopin.length +1)-1;
    const hotJob = this.props.data.hotZhaopin[random];
    return(
        <div className="CompanyCardExp">
          <div className="CompanyCardExp__main">
            <div className="CompanyCardExp__img">
              <img src={company.company_img} alt=""/>
            </div>
            <div className="CompanyCardExp__text">
              <div className="CompanyCardExp__text--title">
                <a href={"./companyDetail?id="+company.company_id}><h4>{company.company_name}</h4></a>
              </div>
              <div className="CompanyCardExp__text--content">
              <span>
                {company.company_name}
                <span className="vlive"></span>
                {company.company_type}
              </span>
              </div>
            </div>
          </div>
          <div className="CompanyCardExp__bottom">
            <span>热招
              <span className="CompanyCardExp__bottom--job"><a href="#">{hotJob.name}</a></span>
              {hotJob.salary}
            </span>
          </div>
        </div>
    )
  }
}
const mapStateToProps = (state) =>{
  // 从state转到props
  return {
    data: {
      hotZhaopin: state.hotZhaopin
    }
  }
};
const mapDispatchToProps = (dispatch)=>{
  return {

  }
};
export default connect(mapStateToProps, mapDispatchToProps)(CompanyCardExp);
