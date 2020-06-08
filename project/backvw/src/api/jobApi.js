import axios from './../util/request';

export const getJobList = ()=> {
  return axios.post('/job/getJobList');
};
export const getOneJob = (id)=>{
  return axios.post('/job/getOneJob', 'jobId='+id)
};
export const getCompanyByJob = (id)=>{
  return axios.post('/job/getCompanyByJob', 'jobId='+id)
};
export const  addJobApply = (userId, jobId)=>{
  return axios.post('/job/addJobApply', 'userId='+userId+'&jobId='+jobId)
};
