import React, {Component} from "react";
import "./JobLook.scss";

class JobLook extends Component{
  render(){
    return(
        <div className="jobLook">
          <div className="jobLook__title">
            <span>看过的职位</span>
          </div>
          <div className="jobLook__list">
            <ul>
              <li>
                <div className="jobLook__list--left">
                  <div className="name"><a href="#">Java高级工程师</a></div>
                  <div className="company">支付宝</div>
                </div>
                <div className="jobLook__list--right">
                  <span>10-15k</span>
                </div>
              </li>
              <li>
                <div className="jobLook__list--left">
                  <div className="name"><a href="#">Java高级工程师</a></div>
                  <div className="company">支付宝</div>
                </div>
                <div className="jobLook__list--right">
                  <span>10-15k</span>
                </div>
              </li>
              <li>
                <div className="jobLook__list--left">
                  <div className="name"><a href="#">Java高级工程师</a></div>
                  <div className="company">支付宝</div>
                </div>
                <div className="jobLook__list--right">
                  <span>10-15k</span>
                </div>
              </li>
            </ul>
          </div>
        </div>
    )
  }
}
export default JobLook;
