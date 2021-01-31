import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import VDistpicker from 'v-distpicker'

import '@/icons'
import '@/assets/icon/iconfont.css'

Vue.config.productionTip = false

Vue.use(ElementUI)
Vue.component('v-distpicker', VDistpicker)
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

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
