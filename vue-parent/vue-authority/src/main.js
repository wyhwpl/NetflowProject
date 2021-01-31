// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import store from './store'
import ElementUI from 'element-ui'



import 'element-ui/lib/theme-chalk/index.css'

import './icons'
import moment from 'moment'

Vue.prototype.$moment = moment

Vue.config.productionTip = false

Vue.use(ElementUI)


axios.interceptors.request.use(
  config => {
    if (localStorage.getItem('Authorization')) {
      config.headers.Authorization = localStorage.getItem('Authorization')
    }

    return config
  },
  error => {
    return Promise.reject(error)
  }
)

axios.interceptors.response.use(
  response => {
    return response
  },
  error => {
    if (error.response) {
      switch (error.response.status) {
        case 401:
          localStorage.removeItem('Authorization')
          router.replace({'path': '/login', query: {redirect: router.currentRoute.fullPath}})
      }
    }
  }
)
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
