import Vue from 'vue'
import Router from 'vue-router'
import home from "../components/home";
import CoursePage from "../components/Course/CoursePage";

import DefaultPage from "../components/DefaultPage";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: home
    },
    {
      path:'/coursePage',
      name:'coursePage',
      component: CoursePage
    },
    {
      path:'/defaultPage',
      name:'defaultPage',
      component:DefaultPage
    }
  ]
})
