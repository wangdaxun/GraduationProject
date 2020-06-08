import React, {Component} from "react";
import "./ResumeIndex.scss";
import TopNav from "../../components/TopNav";
import Resume from "./components/Resume"

class ResumeIndex extends Component{
  render(){
    return(
        <div className="resumeIndex">
          <TopNav/>
          <div className="resumeIndex__content">
            <Resume/>
          </div>
        </div>
    )
  }
}
export default ResumeIndex;
