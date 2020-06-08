// 全局配置axios文件
import axios from "axios";
// Set config defaults when creating the instance
const instance = axios.create({
  baseURL: '/apis'
});

// Alter defaults after instance has been created
// instance.defaults.headers.common['Authorization'] = AUTH_TOKEN;
// 添加请求拦截器

instance.interceptors.request.use(function (config) {
  // 在发送请求之前做些什么
  config.headers['Content-Type'] = "application/x-www-form-urlencoded";
  return config;
}, function (error) {
  // 对请求错误做些什么
  return Promise.reject(error);
});

// 添加响应拦截器
instance.interceptors.response.use(function (response) {
  // 对响应数据做点什么
  return response.data;
}, function (error) {
  // 对响应错误做点什么
  return Promise.reject(error);
});
export default instance;
