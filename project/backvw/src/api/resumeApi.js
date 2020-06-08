import axios from "./../util/request";
export const getUserResume =(id)=>{
  return axios.post('/resume/getUserResume', 'userId='+id);
};
export const updateResumeProfile =(id, profile)=>{
  return axios.post('/resume/updateResumeProfile', 'userId='+id+'&profile='+profile);
};
export const updateResumeJob = (id, intension, salary, currentLoc)=>{
  return axios.post('/resume/updateResumeJob', 'userId='+id+'&intension='+intension+'&salary='+salary+'&currentLoc='+currentLoc);
};
export const updateResumeEdu = (id, school, period, profession, degree, profile)=> {
  return axios.post('/resume/updateResumeEdu', 'userId='+id+'&school='+school+'&period='+period+
      '&profession='+profession+'&degree='+degree+'&profile='+profile
  )
};
export const updateResumeExp = (id, company, period, name, title, desc)=> {
  return axios.post('/resume/updateResumeExp', 'userId='+id+'&company='+company+'&period='+period+'&name='+name+'&title='+title
  +'&desc='+desc);
};
