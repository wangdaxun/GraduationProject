import React, {Component} from "react";
import JobCardExp from "./../../../components/JobCardExp";
import {connect} from "react-redux";
import {theCompanyList, theJobList} from "../../../store/actionCreator";

class JobList extends Component{
  componentWillMount() {
    this.props.getCompanyList();
    this.props.getJobList();
  }
  render(){
    console.log(this.props);
    const jobList = this.props.data.jobList;
    const companyList = this.props.data.companyList;
    // 这里个人的理解是不可以改变reducer里的值传到子组件，那样会后面的覆盖前面的
      jobList.forEach((job,jobIndex)=>{
        companyList.map((company,companyIndex)=>{
          if(job.company_id === company.company_id){
            job.company = company
          }
        })
      });
    return(
        <div className="jobList">
          <ul>
            {
              jobList.map((job,index)=>(
                  <li key={index}><JobCardExp job={job}/></li>
              ))
            }
            {/*<li><JobCardExp name={"我是鞠卫儿"}/></li>*/}
            {/*<li><JobCardExp/></li>*/}
            {/*<li><JobCardExp/></li>*/}
            {/*<li><JobCardExp/></li>*/}
            {/*<li><JobCardExp/></li>*/}
            {/*<li><JobCardExp/></li>*/}
          </ul>
        </div>
    )
  }
}
const mapStateToProps = (state) =>{
  // 从state转到props
  return {
    data:{
      jobList: state.jobList,
      companyList: state.companyList
    }
  }
};
const mapDispatchToProps = (dispatch)=>({
  getJobList() {
    theJobList(dispatch)
  },
  getCompanyList(){
    theCompanyList(dispatch)
  }

});
export default connect(mapStateToProps, mapDispatchToProps)(JobList);

