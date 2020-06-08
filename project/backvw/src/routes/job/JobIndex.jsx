import React, {Component} from "react";
import "./JobIndex.scss";
import TopNav from "../../components/TopNav";
import SerPosition from "../../components/SerPosition";
import JobList from "./components/JobList";
import JobLook from "./components/JobLook";

class JobIndex extends Component{
  render(){
    return(
        <div className="jobIndex">
          <TopNav/>
          <SerPosition/>
          <div className="jobIndex__main inner">
            <JobList/>
            <JobLook/>
          </div>
        </div>
    )
  }
}
export default JobIndex;
