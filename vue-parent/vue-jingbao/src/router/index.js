import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const home = () => import('@/views/home')
const login = () => import('@/views/login')
const account = () => import("@/views/account")

const festival = () => import('@/components/home/festival')
const homeHead = () => import('@/components/home/homeHead')
const cup = () => import('@/components/home/cup')
const cupSearch = () => import('@/components/home/cupSearch')
const siteNav = () => import('@/components/home/siteNav')
const screen = () => import('@/components/home/screen')
const helper = () => import('@/components/home/helper')
const safeSetting = () => import('@/components/account/safeSetting')
const personInfo = () => import('@/components/account/personInfo')
const payBind = () => import('@/components/account/payBind')
const sinaBind = () => import('@/components/account/sinaBind')
const transaction = () => import('@/components/account/transaction')
const receiveAddress = () => import('@/components/account/receiveAddress')
const chatClient = () => import('@/components/account/chatClient')
const appGrant = () => import('@/components/account/appGrant')

const routes = [
  {
    path: '/',
    name: 'home',
    component: home,
    meta: {
      title: '京宝 - 正品低价、品质保证、配送及时、轻松购物',
      requireAuth: false
    }
  },
  {
    path: '/account',
    name: 'account',
    component: account,
    meta: {
      title: '京宝网 - 账号管理',
      requireAuth: true
    },
    children: [
      {
        path: 'safe',
        name: 'safeSetting',
        component: safeSetting,
        meta: {
          title: '京宝网 - 安全设置',
          requireAuth: true
        }
      },
      {
        path: 'person',
        name: 'personInfo',
        component: personInfo,
        meta: {
          title: '京宝网 - 个人资料',
          requireAuth: true
        }
      },
      {
        path: 'pay',
        name: 'payBind',
        component: payBind,
        meta: {
          title: '京宝网 - 支付宝绑定设置',
          requireAuth: true
        }
      },
      {
        path: 'sina',
        name: 'sinaBind',
        component: sinaBind,
        meta: {
          title: '京宝网 - 微博绑定设置',
          requireAuth: true
        }
      },
      {
        path: 'transaction',
        name: 'transaction',
        component: transaction,
        meta: {
          title: '京宝网 - 个人交易信息',
          requireAuth: true
        }
      },
      {
        path: 'receive',
        name: 'receiveAddress',
        component: receiveAddress,
        meta: {
          title: '京宝网 - 收货地址',
          requireAuth: true
        }
      },
      {
        path: 'chat',
        name: 'chatClient',
        component: chatClient,
        meta: {
          title: '京宝网 - 旺旺网页版设置',
          requireAuth: true
        }
      },
      {
        path: 'grant',
        name: 'appGrant',
        component: appGrant,
        meta: {
          title: '京宝网 - 应用授权',
          requireAuth: true
        }
      }
    ]
  },
  {
    path: '/home',
    name: 'home',
    component: home,
    meta: {
      title: '京宝 - 正品低价、品质保证、配送及时、轻松购物',
      requireAuth: false
    }
  },
  {
    path: '/login',
    name: 'login',
    component: login,
    meta: {
      title: '京宝 - 登录',
      requireAuth: false
    }
  },
  {
    path: '/screen',
    name: 'screen',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: screen
  },
  {
    path: '/head',
    name: 'homeHead',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: homeHead
  }
]

const router = new VueRouter({
  routes
})

router.beforeEach((to, from, next) => {
  let token = localStorage.getItem('Authorization')
  let logined = (!(token === null || token === ''))
  console.log(to.path,',',logined)
  if(to.meta.requireAuth){
    if (to.path === '/login') {
      if(logined) {
        next('/')
        document.title = '京宝 - 正品低价、品质保证、配送及时、轻松购物'
      } else {
        next()
        document.title = to.meta.title
      }
    } else {
      if(logined){
        document.title = to.meta.title
        next()
      }else{
        document.title = '登录'
        next({path: '/login',query: {redirect: to.fullPath}})
      }
    }
  }else {
    next()
  }
})

export default router
