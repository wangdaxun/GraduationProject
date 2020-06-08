import React, {Component} from "react";
import CompanyCardExp from "./../../../components/CompanyCardExp";
import {connect} from "react-redux";
import "./CompanyList.scss";
import {theCompanyList} from "../../../store/actionCreator";
import CompanyCard from "../../../components/CompanyCard";
class CompanyList extends Component{
  componentDidMount() {
    this.props.getCompanyList();
  }
  render(){
    const companyList = this.props.data.companyList;
    return(
        <div className="companyList">
          <ul>
            <li>
              {
                companyList.map((company,index)=>(
                    <CompanyCardExp company={company} key={company}/>
                ))
              }
            </li>
          </ul>
        </div>
    )
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
export default connect(mapStateToProps, mapDispatchToProps)(CompanyList);
