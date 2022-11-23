import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App.vue'
import store from './store';
import router from './router'

Vue.use(ElementUI)
Vue.config.productionTip = false

import axios from 'axios'
Vue.prototype.axios = axios

import qs from 'qs';
Vue.prototype.qs = qs;

new Vue({
  el: '#app',
  store,
  router,
  components: { App },
  template: '<App/>',
  render: h => h(App),
})