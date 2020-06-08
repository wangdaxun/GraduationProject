const defaultState = {
  jobSortList: [
    {
      title: "技术",
      sortName: ["Java","Vue","React","Spring"]
    },{
      title: "产品",
      sortName: ["产品经理","产品总监","数据产品经理"]
    },{
      title: "人事",
      sortName: ["人事/HR","行政","财务","培训"]
    },{
      title: "市场",
      sortName: ["市场营销","市场推广","品牌公关","策划经理"]
    },{
      title: "运营",
      sortName: ["新媒体运营","产品运营","网络推广"]
    },{
      title: "高级管理",
      sortName: ["总裁/总经理/CEO","分公司/代表处负责人"]
    },{
      title: "设计",
      sortName: ["UI设计师","平面设计师","交互设计师"]
    }
  ],
  // 写死的7个
  hotJobList: [
    {
      title: "IT*互联网",
      data: "IT"
    },{
      title: "金融",
      data: "money"
    },{
      title: "房地产",
      data: "house"
    },{
      title: "教育培训",
      data: "education"
    },{
      title: "娱乐传媒",
      data: "funny"
    },{
      title: "医疗健康",
      data: "health"
    },{
      title: "法律咨询",
      data: "low"
    }
  ],
  hotZhaopin: [{
    name: "前端开发工程师",
    salary: "15-20k"
  },{
    name: "JAVA工程师",
    salary: "17-20k"
  },{
    name: "人事管理",
    salary: "9-10k"
  },{
    name: "react工程师",
    salary: "20-25k"
  },{
    name: "法律代表",
    salary: "13-15k"
  },{
    name: "机器学习",
    salary: "30-35k"
  },
  ],
  jobList: [],
  jobDetail: {},
  companyList: [],
  companyDetail: {},
  userResume: {}
};
export default (state=defaultState,action)=>{
  if(action.type === "getJobList_FULFILLED"){
    const newState = JSON.parse(JSON.stringify(state));
    newState.jobList = action.payload;
    return newState;
  }
  if(action.type === "getOneJob_FULFILLED") {
    const newState = JSON.parse(JSON.stringify(state));
    newState.jobDetail = action.payload;
    return newState;
  }
  if(action.type === "getCompanyList_FULFILLED"){
    const newState = JSON.parse(JSON.stringify(state));
    newState.companyList = action.payload;
    return newState;
  }
  if(action.type === "getOneCompany_FULFILLED"){
    const newState = JSON.parse(JSON.stringify(state));
    newState.companyDetail = action.payload;
    return newState;
  }
  if(action.type === "getCompanyByJob_FULFILLED"){
    const newState = JSON.parse(JSON.stringify(state));
    newState.companyDetail = action.payload;
    return newState
  }
  if(action.type === "getUserResume_FULFILLED"){
    const newState = JSON.parse(JSON.stringify(state));
    newState.userResume = action.payload;
    return newState
  }
  return state;
}
