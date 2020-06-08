import {getJobList,getOneJob,getCompanyByJob} from './../api/jobApi';
import {getCompanyList,getOneCompany} from './../api/companyApi';
import {getUserResume} from "./../api/resumeApi";
export const theJobList = async (dispatch)=>{
    dispatch({
      type: 'getJobList',
      payload: getJobList()
    })
};
export const oneJob = async (dispatch, id)=>{
  dispatch({
    type: 'getOneJob',
    payload: getOneJob(id)
  })
};
export const companyByJob = async (dispatch, id)=>{
  dispatch({
    type: 'getCompanyByJob',
    payload: getCompanyByJob(id)
  })
};
export const theCompanyList = async (dispatch)=>{
    dispatch({
      type: 'getCompanyList',
      payload: getCompanyList()
    })
};
export const oneCompany = async (dispatch, id)=>{
    dispatch({
      type: 'getOneCompany',
      payload: getOneCompany(id)
    })
};
export const theUserResume = async (dispatch, id)=>{
  dispatch({
    type: 'getUserResume',
    payload: getUserResume(id)
  })
};

