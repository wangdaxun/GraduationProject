import React, {Component} from "react";
import "./index.scss";
import TopNav from "../../components/TopNav";
import SerPosition from "../../components/SerPosition";
import JobSortList from "./components/JobSortList";
import HotCompany from "./components/HotCompany";
import HotJob from "./components/HotJob";
class Home extends Component{
  render(){
    return(
        <div className={"home"}>
          <TopNav/>
          <SerPosition/>
          <div className={"home__mid"}>
            <div className={"inner mid__inner"}>
              <JobSortList/>
              <div className={"home__mid--pic"}>
                {/*这里是要定死四个图片*/}
                <div className={"pic pic__first"}>
                  <div><a href="./companyDetail?id=2"><img src="/img/homeImg/cahk.jpg"/></a></div>
                  <div><a href="./companyDetail?id=3"><img src="/img/homeImg/adidas.jpg"/></a></div>
                </div>
                <div className={"pic pic__second"}>
                  <div><a href="./companyDetail?id=5"><img src="/img/homeImg/nike.jpeg"/></a></div>
                  <div><a href="./companyDetail?id=4"><img src="/img/homeImg/apple.jpg"/></a></div>
                </div>
              </div>
            </div>
          </div>
          <div className={"home__company"}>
            <HotCompany/>
          </div>
          <div className={"home__job"}>
            <HotJob/>
          </div>
        </div>
    )
  }
}
export default Home;
