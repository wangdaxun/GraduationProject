import React, {Component} from "react";
import "./HotCompany.scss";
import {connect} from "react-redux";
import CompanyCard from "./../../../components/CompanyCard";
import {theCompanyList} from "./../../../store/actionCreator";
class HotCompany extends Component{
  componentDidMount() {
    this.props.getCompanyList();
  }

  render() {
    const companyList = this.props.data.companyList;
    return (
        <div className="HotCompany">
          <div className="HotCompany__inner inner">
            <div className="HotCompany__title">
              <div className="box-title">
                热门企业
              </div>
            </div>
            <div className="HotCompany__Content">
              <ul>
                {
                  companyList.map((company,index)=>(
                      <li key={index}><CompanyCard company={company}/></li>
                  ))
                 }
              </ul>
            </div>
            <div className="HotCompany__search">
              <a href="./company" className="btn">
                  <span>查看更多</span>
              </a>
            </div>
          </div>
        </div>
    );
  }
}

const mapStateToProps = (state) =>{
  // 从state转到props
  return {
    data:{
      companyList: state.companyList
    }
  }
};
const mapDispatchToProps = (dispatch)=>{
  return {
    getCompanyList(){
      theCompanyList(dispatch)
    }
  }
};
export default connect(mapStateToProps, mapDispatchToProps)(HotCompany);
