import React, {Component} from "react";
import {theJobList} from './../../../store/actionCreator'
import "./HotJob.scss";
import {connect} from "react-redux";
import JobCard from "./../../../components/JobCard";
class HotJob extends Component{
  componentDidMount() {
    this.props.reJobList();
  }
  state = {
    currentIndex : 0
  };
  render() {
    const hotJobList = this.props.data.hotJobList;
    const jobList = this.props.data.jobList.slice(0,13);

    return (
        <div className="HotJob">
          <div className="HotJob__inner inner">
            <div className="HotJob__title">
              <div className="box-title">
                热招职位
              </div>
            </div>
            <div className="HotJob__list">
              <ul>
                {
                  hotJobList.map((job,index)=>(
                      <li key={job.title}>
                        <span className={index === this.state.currentIndex ? "active" : null}
                               onClick={()=> {
                                 this.setState(()=>({
                                   currentIndex : index
                                 }))
                               }}>
                          {job.title}
                        </span>
                      </li>
                  ))
                }
              </ul>
            </div>
            <div className="HotJob__Content">
              <ul>
                {
                  jobList.map((job,index)=>(
                      <li><JobCard job={job}/></li>
                  ))
                }
              </ul>
            </div>
            <div className="HotJob__search">
              <a href="./job" className="btn">
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
      hotJobList: state.hotJobList,
      jobList: state.jobList
    }
  }
};
const mapDispatchToProps = (dispatch)=>({
    reJobList() {
      theJobList(dispatch)
    }
  });
export default connect(mapStateToProps, mapDispatchToProps)(HotJob);
