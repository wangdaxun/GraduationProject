import React, {Component} from "react";
import TopNav from "../../components/TopNav";
import SerPosition from "../../components/SerPosition"
class Home extends Component{
  render(){
    return(
        <div>
          <TopNav/>
          <SerPosition/>
        </div>
    )
  }
}
export default Home;
