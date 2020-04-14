import React, {Component} from "react";
import "./../main.scss";
import "./SerPosition.scss";
class SerPosition extends Component{
  render() {
    return (
      <div className="SerPosition">
        <div className="inner SerPosition__inner">
          <div className="SerPosition__box">
            <div className="SerPosition__box--type">
              <span>职位类型</span>
              <i></i>
            </div>
            <form>
              <div className="SerPosition__box--form">
                  <div className="form__input"><input type="text" placeholder="搜索公司、职位"/></div>
                  <div className="form__search"><span>搜索</span></div>
              </div>
            </form>
          </div>
          <div className="SerPosition__hot">
            <span style={{color:'#999'}}>热门职位：</span>
            <ul>
              <li><span>Java</span></li>
              <li><span>React</span></li>
              <li><span>Vue</span></li>
              <li><span>SpringBoot</span></li>
              <li><span>产品经理</span></li>
              <li><span>算法工程师</span></li>
              <li><span>UI设计师</span></li>
            </ul>
          </div>
        </div>
      </div>
    );
  }

}
export default SerPosition;
