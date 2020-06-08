import React, {Component} from "react";
import "./CompanyDetail.scss";
import TopNav from "../../components/TopNav";
import CompanyMain from "./components/CompanyMain";
import CompanyTop from "./components/CompanyTop";

class CompanyDetail extends Component{
  render(){
    return(
        <div className="companyDetail">
          <TopNav/>
          <CompanyTop/>
          <div className="inner companyDetail__content">
            <CompanyMain/>
          </div>
        </div>
    )
  }
}
export default CompanyDetail;
