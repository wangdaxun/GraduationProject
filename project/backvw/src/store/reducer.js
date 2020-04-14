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
    }
  ]
};
export default (state=defaultState,action)=>{
  return state;
}
