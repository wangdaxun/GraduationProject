import axios from './../util/request';
const userLogIn = (email, password)=>{
  return axios.post('/user/login',
      "email="+email+"&password="+password)
};
const sendEmail = (email)=>{
  return axios.post('/user/sendYanzheng',
      "email="+email)
};
const userSignUp = (email,password,name,yanz)=>{
  return axios.post('/user/sign',
      "email="+email+"&password="+password+"&name="+name+"&yanz="+yanz)
};
const getUser = (userId)=>{
  return axios.post('/user/getUser',
        "userId="+userId
      )
};
const userSave = (logName, email, realName, telephone, personalPro, userId)=>{
  return axios.post('/user/saveUser',
        "logName="+logName+"&email="+email+"&realName="+realName+
        "&telephone="+telephone+"&personalPro="+personalPro+"&userId="+userId
      )
};
export {userLogIn,sendEmail,userSignUp,getUser,userSave};
