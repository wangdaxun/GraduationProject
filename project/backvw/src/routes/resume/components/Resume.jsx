import React, {Component, createRef} from "react";
import "./Resume.scss";
import male from "./../../../img/Iconfont/male.svg";
import {connect} from "react-redux";
import female from "./../../../img/Iconfont/female.svg";
import {theUserResume} from "../../../store/actionCreator";
import {updateResumeProfile, updateResumeJob, updateResumeEdu, updateResumeExp} from "./../../../api/resumeApi";
class Resume extends Component{
  state = {
    youshiFlag : true,
    qiwangFlag : true,
    jiaoyuFlag : true,
    xiangmuFlag : true,
  };
  profileText = createRef();

  jobIntension = createRef();
  jobSalary = createRef();
  jobCurrent = createRef();

  school = createRef();
  eduPeriod = createRef();
  eduProfession = createRef();
  eduDegree = createRef();
  eduProfileText = createRef();

  expCompany = createRef();
  expPeriod = createRef();
  expName = createRef();
  expTitle = createRef();
  expDesc = createRef();

  componentDidMount() {
    let id = JSON.parse(localStorage.getItem("user")).user_id;
    this.props.getUserResume(id);
  }

  id = JSON.parse(localStorage.getItem("user")).user_id;
  saveProfile = ()=>{
    let profile = this.profileText.current.value ? this.profileText.current.value : this.profileText.current.placeholder;
    updateResumeProfile(this.id, profile)
        .then(()=>{
          window.location.reload();
        })
  };
  saveJob = ()=>{
    let jobIntension = this.jobIntension.current.value ? this.jobIntension.current.value : this.jobIntension.current.placeholder;
    let jobSalary = this.jobSalary.current.value ? this.jobSalary.current.value : this.jobSalary.current.placeholder;
    let jobCurrent = this.jobCurrent.current.value ? this.jobCurrent.current.value : this.jobCurrent.current.placeholder;
    updateResumeJob(this.id, jobIntension, jobSalary, jobCurrent)
        .then(()=>{
          window.location.reload();
        })
  };
  saveEdu = ()=>{
    let school = this.school.current.value ? this.school.current.value : this.school.current.placeholder;
    let eduPeriod = this.eduPeriod.current.value ? this.eduPeriod.current.value : this.eduPeriod.current.placeholder;
    let eduProfession = this.eduProfession.current.value ? this.eduProfession.current.value : this.eduProfession.current.placeholder;
    let eduDegree = this.eduDegree.current.value ? this.eduDegree.current.value : this.eduDegree.current.placeholder;
    let eduProfile = this.eduProfileText.current.value ? this.eduProfileText.current.value : this.eduProfileText.current.placeholder;
    updateResumeEdu(this.id, school, eduPeriod, eduProfession, eduDegree, eduProfile)
        .then(()=>{
          window.location.reload();
        })
  };
  saveExp = ()=>{
    let expCompany = this.expCompany.current.value ? this.expCompany.current.value : this.expCompany.current.placeholder;
    let expPeriod = this.expPeriod.current.value ? this.expPeriod.current.value : this.expPeriod.current.placeholder;
    let expName = this.expName.current.value? this.expName.current.value : this.expName.current.placeholder;
    let expTitle = this.expTitle.current.value ? this.expTitle.current.value : this.expTitle.current.placeholder;
    let expDesc = this.expDesc.current.value ? this.expDesc.current.value : this.expDesc.current.placeholder;
    updateResumeExp(this.id, expCompany, expPeriod, expName, expTitle, expDesc)
        .then(()=>{
          window.location.reload();
        })
  };
  render(){
    const resume = this.props.data.userResume;
    console.log(resume);
    return(
        <div className="resume">
          <div className="resume__top">
            <div className="resume__top--name">
              <span>{resume.realName}</span>
              <span className="resume__top--img"><img src={resume.gender === "男" ? male : female} alt=""/></span>
            </div>
            <div className="resume__top--edu">
              <span>20年应届生</span>
              <span className="vlive"></span>
              <span>{resume.resume_sf}学历</span>
              <br/>
              <span>13936597125</span>
              <span className="vlive"></span>
              <span>{resume.email}</span>
            </div>
          </div>
          <div className="resume__personal">
            <div className="resume__title">
              <span>个人优势</span>
              <span className="resume__add" onClick = {()=>{this.setState({youshiFlag: !this.state.youshiFlag})}}>修改</span>
            </div>
            <div className="resume__personal--content">
              {
                this.state.youshiFlag ?
                    <span>{resume.personal_profile}</span>
                    :
                    <div>
                      <textarea ref={this.profileText} type="text" autoComplete="off" spellCheck={false}  wrap="soft" placeholder={resume.personal_profile}></textarea>
                      <div><span className="resume__editSave" onClick={this.saveProfile}>保存</span></div>
                    </div>
              }
            </div>
          </div>
          <div className="resume__job">
            <div className="resume__title">
              <span>期望职位</span>
              <span className="resume__add" onClick = {()=>{this.setState({qiwangFlag: !this.state.qiwangFlag})}}>修改</span>
            </div>
            <div className="resume__job--content">
              {
                this.state.qiwangFlag ?
                    <div>
                      <span>{resume.job_intension}</span>
                      <span style={{color: "#fc6c38"}}>{resume.resume_salary}</span>
                      <span>{resume.current_loc}</span>
                    </div> :
                    <div>
                      <span>期望职位名</span><input type="text" ref={this.jobIntension} placeholder={resume.job_intension}/>
                      <span>期望工资</span><input type="text" ref={this.jobSalary} placeholder={resume.resume_salary}/>
                      <span>期望工作地点</span><input type="text" ref={this.jobCurrent} placeholder={resume.current_loc}/>
                      <div><span className="resume__editSave" onClick={this.saveJob}>保存</span></div>
                    </div>
              }
            </div>
          </div>
          <div className="resume__education">
            <div className="resume__title">
              <span>教育经历</span>
              <span className="resume__add" onClick = {()=>{this.setState({jiaoyuFlag: !this.state.jiaoyuFlag})}}>修改</span>
            </div>
            <div className="resume__education--content">
              {
                this.state.jiaoyuFlag ?
                  <div>
                    <div className="education__name">
                      <span className="education__name--stu">
                        {resume.graduate_school}
                      </span>
                            <span className="education__name--time">
                        {resume.project_period}
                      </span>
                    </div>
                    <div className="education__sch">
                      <div className="education__sch--class">
                        <span>{resume.profession}</span>
                        <span className="vlive"></span>
                        <span>{resume.education_degree}</span>
                      </div>
                      <div className="education__sch--text">
                        <span>
                          {resume.personal_profile}
                        </span>
                      </div>
                    </div>
                  </div> :
                  <div>
                    <div className="resume__editBlk">
                      <span>教育学校名</span><input type="text" ref={this.school} placeholder={resume.graduate_school}/>
                      <span>教育时间</span><input type="text" ref={this.eduPeriod} placeholder={resume.project_period}/>
                    </div>
                    <div className="resume__editBlk">
                      <span>学校专业名称</span><input type="text" ref={this.eduProfession} placeholder={resume.profession}/>
                      <span>学历</span><input type="text" ref={this.eduDegree} placeholder={resume.education_degree}/>
                    </div>
                    <div className="resume__editBlk">
                      <textarea type="text" autoComplete="off" spellCheck={false} ref={this.eduProfileText}  wrap="soft" placeholder={resume.personal_profile}></textarea>
                    </div>
                    <div><span className="resume__editSave" onClick={this.saveEdu}>保存</span></div>
                  </div>
              }
            </div>
          </div>
          <div className="resume__exp">
            <div className="resume__title">
              <span>项目经历</span>
              <span className="resume__add" onClick = {()=>{this.setState({xiangmuFlag: !this.state.xiangmuFlag})}}>修改</span>
            </div>
            <div className="resume__exp--content">
              {
                this.state.xiangmuFlag ?
                <div>
                  <div className="exp__name">
                    <span className="exp__name--title">
                      {resume.job_company}
                    </span>
                    <span className="exp__name--time">
                  {resume.project_period}
                </span>
                  </div>
                  <div className="exp__content">
                    <div className="exp__content--job">
                      {resume.project_name}
                    </div>
                    <div className="exp__content--jobExp">
                      <span>{resume.job_title}</span>
                      <span>{resume.job_desc}</span>
                    </div>
                  </div>
                </div>:
                <div>
                  <div className="resume__editBlk">
                    <span>项目公司名</span>
                    <input type="text" ref={this.expCompany} placeholder={resume.job_company}/>
                    <span>项目经历时间</span>
                    <input type="text" ref={this.expPeriod} placeholder={resume.project_period}/>
                  </div>
                  <div className="resume__editBlk">
                    <span>项目名称</span>
                    <input type="text" ref={this.expName} placeholder={resume.project_name}/>
                    <span>项目担当职责</span>
                    <input type="text" ref={this.expTitle} placeholder={resume.job_title}/>
                  </div>
                  <div className="resume__editBlk">
                    <textarea type="text" autoComplete="off" ref={this.expDesc} spellCheck={false}  wrap="soft" placeholder={resume.job_desc}></textarea>
                  </div>
                  <div>
                    <span className="resume__editSave" onClick={this.saveExp}>保存</span>
                  </div>
                </div>
              }
            </div>
          </div>
        </div>
    )
  }
}
const mapStateToProps = (state) =>{
  // 从state转到props
  return {
    data:{
      userResume: state.userResume
    }
  }
};
const mapDispatchToProps = (dispatch)=>{
  return {
    getUserResume(id){
      theUserResume(dispatch, id);
    }
  }
};
export default connect(mapStateToProps, mapDispatchToProps)(Resume);

