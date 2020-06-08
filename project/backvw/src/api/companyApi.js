import axios from './../util/request';
export const getCompanyList = ()=>{
  return axios.post('/company/getCompanyList');
};
export const getOneCompany = (id)=>{
  return axios.post('/company/getOneCompany', 'companyId='+id);
};
