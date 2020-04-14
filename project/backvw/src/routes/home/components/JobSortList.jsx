import React,{Component} from "react";
import store from "./../../../store";
import "./JobSortList.scss";
class JobSortList extends Component{
  constructor(props){
    super(props);
    this.state = store.getState();
    console.log(this.state);
  }
  render() {
    const jobSortList = this.state.jobSortList;
    return(
        <div className="JobList">
          {
            jobSortList.map((job)=>(
                <div className="JobList__Card">
                  <span className="Card__Title">{job.title}</span>
                  <ul>
                    {
                      job.sortName.map((name)=>(
                          <li className={"Card__SortName"}><span>{name}</span></li>
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
export default JobSortList;
