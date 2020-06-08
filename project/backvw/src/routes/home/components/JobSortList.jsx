import React,{Component} from "react";
import {connect} from "react-redux"
import "./JobSortList.scss";
class JobSortList extends Component{
  render() {
    const jobSortList = this.props.jobSortList;
    return(
        <div className="JobList">
          {
            jobSortList.map((job)=>(
                <div className="JobList__Card" key={job.title}>
                  <span className="Card__Title">{job.title}</span>
                  <ul>
                    {
                      job.sortName.map((name)=>(
                          <li key={name} className={"Card__SortName"}><span>{name}</span></li>
                      ))
                    }
                  </ul>
                  <i className="Card__rightArrow icon"></i>
                </div>
            ))
          }
        </div>
    )
  }
}
const mapStateToProps = (state) =>{
  // 从state转到props
  return {
    jobSortList: state.jobSortList
  }
};
const mapDispatchToProps = (dispatch)=>{
  return {

  }
};
export default connect(mapStateToProps, mapDispatchToProps)(JobSortList);
