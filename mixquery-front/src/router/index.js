import Vue from 'vue'
import Router from 'vue-router'
import MyComponent from '../components/my-component';
import GraphManage from '../components/graph-manage';


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/graph',
      name: 'MyComponent',
      component: MyComponent
    },
    {
      path: '/',
      name: 'GraphManage',
      component: GraphManage
    }
  ]
})