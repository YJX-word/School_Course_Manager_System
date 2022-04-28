import axios from "axios";
// 可以axios的请求包装成一个函数，通过函数来调用
export function respose(config){
  let createAxios=axios.create({
    // baseURL:"http://10.157.35.126:8000",
    baseURL:"http://localhost:8000",
    // baseURL:"http://192.168.183.131:8080",
    timeout:5000
  })
  return createAxios(config);//因为axios请求本来就时一个promise类型的实例,可以使用then和catch来放回数据
}

export function respose1(config){
  let createAxios=axios.create({
    baseURL:"http://localhost:8000",
    // baseURL:"http://192.168.183.131:8080",
    timeout:5000
  })
  return new Promise((resolve,reject)=>{
    createAxios(config).then(err=>{
      resolve(err);
    }).catch(ero=>{
      reject(ero);
    })
  })
}
export function Postrequstion(config){
  let createPost=axios.create({
    method:"post",
    baseURL:"http://localhost:8000",
    // baseURL:"http://192.168.183.131:8080",
    timeout:5000,
    headers: { "content-type": "application/x-www-form-urlencoded" }
  })
  return createPost(config)
}
