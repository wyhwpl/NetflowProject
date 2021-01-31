import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

// const HelloWorld = () => import('@/components/HelloWorld')
const login = () => import('@/components/login')
const home = () => import('@/components/home')
const user = () => import('@/components/user')
const role = () => import('@/components/role')
const application = () => import('@/components/application')
const resource = () => import('@/components/resource')
const edit = () => import('@/components/edit')

const router = new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: home,
      meta: {
        title: '统一权限管理系统'
      },
      children: [
        {
          path: '/user',
          name: 'user',
          component: user,
          meta: {
            title: '用户管理'
          }
        },
        {
          path: '/role',
          name: 'role',
          component: role,
          meta: {
            title: '角色管理'
          }
        },
        {
          path: '/application',
          name: 'application',
          component: application,
          meta: {
            title: '应用管理'
          }
        },
        {
          path: '/resource',
          name: 'resource',
          component: resource,
          meta: {
            title: '应用资源'
          }
        }
      ]
    },
    {
      path: '/login',
      name: 'login',
      component: login,
      meta: {
        title: '登录'
      }
    },
    {
      path: '/test',
      name: 'edit',
      component: edit,
      meta: {
        title: '编辑'
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  if (to.path === '/login') {
    if (to.meta.title) {
      document.title = to.meta.title
    }
    console.log('to-login')
    next()
  } else {
    let token = localStorage.getItem('Authorization')
    if (token === null || token === '') {
      document.title = '登录'
      console.log('no token to-login')
      next('/login')
    } else {
      if (to.meta.title) {
        document.title = to.meta.title
      }
      console.log(token)
      console.log('to next')
      next()
    }
  }
})

export default router
