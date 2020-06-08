import React, {Component} from "react";
import "./CompanyCard.scss"
import {connect} from "react-redux";
class CompanyCard extends Component{
  render(){
    const company = this.props.company;
    return(
        <div className="CompanyCard">
          <div className="CompanyCard__img">
            <img src={company.company_img} alt=""/>
          </div>
          <div className="CompanyCard__text">
            <div className="CompanyCard__text--title">
              <a href={"./companyDetail?id="+company.company_id}><h4>{company.company_name}</h4></a>
            </div>
            <div className="CompanyCard__text--content">
              <span>
                {company.company_shangshi}
                <span className="vlive"></span>
                {company.company_type}
              </span>
            </div>
          </div>
          <div className="CompanyCard__btn">
            <a href="">
              <span className="CompanyCard__btn--num">1000个</span>热招职位
            </a>
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
const mapDispatchToProps = (dispatch)=>{
  return {

  }
};
export default connect(mapStateToProps, mapDispatchToProps)(CompanyCard);
