import React, {Component} from "react";
import TopNav from "../../components/TopNav";
import SerPosition from "../../components/SerPosition";
import JobSortList from "./components/JobSortList";
class Home extends Component{
  render(){
    return(
        <div>
          <TopNav/>
          <SerPosition/>
          <JobSortList/>
        </div>
    )
  }
}
export default Home;
