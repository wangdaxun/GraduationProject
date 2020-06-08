import React, {Component} from "react";
import TopNav from "../../components/TopNav";
import "./JobDetail.scss"
import JobTop from "./components/JobTop";
import JobMain from "./components/JobMain";
import JobRight from "./components/JobRight";
class JobDetail extends Component{
  render(){
    return(
        <div className="jobDetail">
          <TopNav/>
          <JobTop/>
          <div className="jobDetail__content">
            <JobMain/>
            <JobRight/>
          </div>
        </div>
    )
  }
}
export default JobDetail;
