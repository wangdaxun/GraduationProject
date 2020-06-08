import React, {Component} from "react";
import TopNav from "../../components/TopNav";
import SerPosition from "../../components/SerPosition";
import CompanyList from "./components/CompanyList";
import "./CompanyIndex.scss"
class CompanyIndex extends Component{
  render(){
    return(
        <div className="companyIndex">
          <TopNav/>
          <SerPosition/>
          <div className="companyIndex__main inner">
            <CompanyList/>
          </div>
        </div>
    )
  }
}
export default CompanyIndex;
