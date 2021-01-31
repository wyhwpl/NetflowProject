<template>
    <div>
        <!--<el-row class="home-head">
            <el-col :span="5" :offset="1" style="height: 35px">
                <div>
                    <el-row style="height: 35px" :gutter="5">
                        <el-col v-if="!logined" :span="7" style="height: 35px;">
                            <div>
                                <span style="color: red">亲，请登录</span>
                            </div>
                        </el-col>
                        <el-col v-if="!logined" :span="10" style="height: 35px">
                            <div>
                                <span>免费注册</span>
                            </div>
                        </el-col>
                        <el-col  v-else :span="10" style="height: 35px">
                            <div  >
                                <div class="span-show" @mouseenter="showUser = true">
                                    <span>汪培林</span>
                                    <i class="el-icon-arrow-down"></i>
                                </div>
                                <div class="user-bd-panel hover-show" v-if="showUser" @mouseleave="showUser = false">
                                    <div class="user-wrapper">
                                        <a href="">
                                            <img :src="avatarUrl"/>
                                        </a>
                                    </div>
                                    <div class="user-info">
                                        <p class="user-operate">
                                            <a href="">账号管理</a>
                                            <span>|</span>
                                            <a href="">退出</a>
                                        </p>
                                        <p class="j-score">淘气值: 585</p>
                                        <p class="level-info">普通会员</p>
                                    </div>
                                    <a class="user-privilege" href="">查看你的专属权益</a>
                                </div>
                            </div>
                        </el-col>
                        <el-col :span="7" style="height: 35px">
                            <div>
                                <span>手机逛京宝</span>
                            </div>
                        </el-col>
                    </el-row>
                </div>
            </el-col>
            <el-col :span="14" :offset="3" style="height: 35px">
                <div>
                    <el-row style="height: 35px" :gutter="5">
                        <el-col :span="3" style="height: 35px">
                            <div class="span-show"  @mouseenter="showJB = true">
                                <span>我的京宝</span>
                                <i class="el-icon-arrow-down"></i>
                            </div>
                            <div class="hover-show" v-if="showJB"  @mouseleave="showJB = false">
                                <div>
                                    <span>已买到的宝贝</span>
                                </div>
                                <div>
                                    <span>我的足迹</span>
                                </div>
                            </div>
                        </el-col>
                        <el-col :span="3" style="height: 35px">
                            <div class="span-show">
                                <i class="el-icon-shopping-cart-2"></i>
                                <span>购物车</span>
                                <i class="el-icon-arrow-down"></i>
                            </div>
                        </el-col>
                        <el-col :span="3" style="height: 35px">
                            <div class="span-show"  @mouseenter="showSC = true">
                                <i class="el-icon-star-on"></i>
                                <span>收藏夹</span>
                                <i class="el-icon-arrow-down"></i>
                            </div>
                            <div class="hover-show" v-if="showSC" @mouseleave="showSC = false">
                                <div>
                                    <span>收藏的宝贝</span>
                                </div>
                                <div>
                                    <span>收藏的店铺</span>
                                </div>
                            </div>
                        </el-col>
                        <el-col :span="3" style="height: 35px">
                            <div>
                                <span>商品分类</span>
                            </div>
                        </el-col>
                        <el-col :span="2" style="height: 35px">
                            <div>
                                <span>免费开店</span>
                            </div>
                        </el-col>
                        <el-col :span="1" style="height: 35px">
                            <span>|</span>
                        </el-col>
                        <el-col :span="3" style="height: 35px">
                            <div class="span-show"  @mouseenter="showMJ = true" >
                                <span>卖家中心</span>
                                <i class="el-icon-arrow-down"></i>
                            </div>
                            <div class="hover-show" v-if="showMJ" @mouseleave="showMJ = false">
                                <div>
                                    <span>免费开店</span>
                                </div>
                                <div>
                                    <span>已卖出的宝贝</span>
                                </div>
                                <div>
                                    <span>出售中的宝贝</span>
                                </div>
                                <div>
                                    <span>卖家服务市场</span>
                                </div>
                                <div>
                                    <span>卖家培训中心</span>
                                </div>
                                <div>
                                    <span>体检中心</span>
                                </div>
                                <div>
                                    <span>问商友</span>
                                </div>
                            </div>
                        </el-col>
                        <el-col :span="3" style="height: 35px">
                            <div class="span-show"  @mouseenter="showKF = true">
                                <span>联系客服</span>
                                <i class="el-icon-arrow-down"></i>
                            </div>
                            <div class="hover-show" v-if="showKF" @mouseleave="showKF = false">
                                <div>
                                    <span>消费者客服</span>
                                </div>
                                <div>
                                    <span>卖家客服</span>
                                </div>
                            </div>
                        </el-col>
                        <el-col :span="3" style="height: 35px">
                            <div class="span-show">
                                <span>网站导航</span>
                                <i class="el-icon-arrow-down"></i>
                            </div>
                        </el-col>
                    </el-row>
                </div>
            </el-col>

        </el-row>-->
        <div class="home-head">
            <ul class="head-left">
                <li class="login-nav" @mouseleave="showUser = false">
                    <div class="nav-menu-hd-n">
                        <div v-if="!logined" class="nav-sign">
                            <span style="color: red" @click="linkTo('/login')">亲，请登录</span>
                            <span class="nav-tab">免费注册</span>
                        </div>
                        <div v-else class="nav-user" @mouseenter="showUser = true">
                            <span class="nav-tab">{{userInfo.nickName}}</span>
                            <i class="el-icon-arrow-down"></i>
                        </div>
                    </div>
                    <div class="nav-menu-hd-y">
                        <div class="user-nav-content user-bd-panel hover-show" v-if="showUser">
                            <div class="user-wrapper">
                                <a href="">
                                    <img :src="avatarUrl"/>
                                </a>
                            </div>
                            <div class="user-info">
                                <p class="user-operate">
                                    <a @click="linkTo('/account/safe?i='+Math.random())">账号管理</a>
                                    <span>|</span>
                                    <a @click="logout">退出</a>
                                </p>
                                <p class="j-score">淘气值: {{userInfo.jScore}}</p>
                                <p class="level-info">{{userInfo.memberType}}</p>
                            </div>
                            <a class="user-privilege" href="">查看你的专属权益</a>
                        </div>
                    </div>
                </li>
                <li class="mobile-nav">
                    <div class="nav-menu-hd">
                        <span class="nav-tab" href=""><span>手机逛京宝</span></span>
                    </div>
                </li>
            </ul>
            <ul class="head-right ">
                <li  class="nav-li" v-if="!isHome">
                    <div class="nav-menu-hd span-show" >
                        <span class="nav-tab">京宝网首页</span>
                        <i class="el-icon-arrow-down"></i>
                    </div>

                </li>
                <li  class="nav-li" @mouseenter="showJB = true"   @mouseleave="showJB = false">
                    <div class="nav-menu-hd span-show" >
                        <span class="nav-tab">我的京宝</span>
                        <i class="el-icon-arrow-down"></i>
                    </div>
                    <div class="nav-menu-hd-h hover-show" v-if="showJB">
                        <div>
                            <span class="nav-tab">已买到的宝贝</span>
                        </div>
                        <div>
                            <span class="nav-tab">我的足迹</span>
                        </div>
                    </div>
                </li>
                <li class="nav-li" @mouseenter="showCart = true" @mouseleave="showCart = false">
                    <div class="nav-menu-hd span-show">
                        <i class="el-icon-shopping-cart-2"></i>
                        <span class="nav-tab">购物车<span class="nav-tab" v-if="logined">{{cartInfo.recentList.length}}</span></span>
                        <i class="el-icon-arrow-down"></i>
                    </div>
                    <div class="nav-menu-hd-h hover-show"  v-if="showCart">
                        <div class="cart-panel">
                            <div class="mini-cart-hd" v-if="cartInfo.recentList.length !== 0">
                                最近加入的宝贝：
                            </div>
                            <ul class="mini-cart-main" v-for="recent in cartInfo.recentList" :key=recent.goodId
                                v-if="cartInfo.recentList.length !== 0">
                                <li>
                                    <div class="mini-cart-img">
                                        <a>
                                            <img :src="avatarUrl"/>
                                        </a>
                                    </div>
                                    <div class="mini-cart-count">
                                        {{recent.count}}
                                    </div>
                                    <div class="mini-cart-title">
                                        <a :href="recent.goodUrl">{{recent.title}}</a>
                                    </div>
                                    <div class="mini-cart-del">
                                        <a>删除</a>
                                    </div>
                                    <div class="mini-cart-info">
                                        <span>{{recent.info}}</span>
                                    </div>
                                </li>
                            </ul>
                            <div class="mini-cart-ft">
                                <p>
                                    <span v-if="cartInfo.recentList.length === 0">您购物车里还没有任何宝贝</span>
                                    <a class="cart-nav-btn">查看我的购物车</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="nav-li" @mouseenter="showSC = true" @mouseleave="showSC = false">
                    <div class="nav-menu-hd span-show">
                        <i class="el-icon-star-on"></i>
                        <span class="nav-tab">收藏夹</span>
                        <i class="el-icon-arrow-down"></i>
                    </div>
                    <div class="nav-menu-hd-h hover-show" v-if="showSC">
                        <div>
                            <span class="nav-tab">收藏的宝贝</span>
                        </div>
                        <div>
                            <span class="nav-tab">收藏的店铺</span>
                        </div>
                    </div>
                </li>
                <li class="nav-li">
                    <div class="nav-menu-hd">
                        <span class="nav-tab">商品分类</span>
                    </div>
                </li>
                <li class="nav-li">
                    <div class="nav-menu-hd">
                        <span class="nav-tab">免费开店</span>
                    </div>
                </li>
                <li class="nav-li">
                    <span>|</span>
                </li>
                <li class="nav-li" @mouseenter="showMJ = true" @mouseleave="showMJ = false">
                    <div class="nav-menu-hd span-show">
                        <span class="nav-tab">卖家中心</span>
                        <i class="el-icon-arrow-down"></i>
                    </div>
                    <div class="nav-menu-hd-h hover-show" v-if="showMJ">
                        <div>
                            <span class="nav-tab">免费开店</span>
                        </div>
                        <div>
                            <span class="nav-tab">已卖出的宝贝</span>
                        </div>
                        <div>
                            <span class="nav-tab">出售中的宝贝</span>
                        </div>
                        <div>
                            <span class="nav-tab">卖家服务市场</span>
                        </div>
                        <div>
                            <span class="nav-tab">卖家培训中心</span>
                        </div>
                        <div>
                            <span class="nav-tab">体检中心</span>
                        </div>
                        <div>
                            <span class="nav-tab">问商友</span>
                        </div>
                    </div>
                </li>
                <li class="nav-li" @mouseenter="showKF = true" @mouseleave="showKF = false">
                    <div class="nav-menu-hd span-show">
                        <span class="nav-tab">联系客服</span>
                        <i class="el-icon-arrow-down"></i>
                    </div>
                    <div class="nav-menu-hd-h hover-show" v-if="showKF">
                        <div>
                            <span class="nav-tab">消费者客服</span>
                        </div>
                        <div>
                            <span class="nav-tab">卖家客服</span>
                        </div>
                    </div>
                </li>
                <li class="nav-li">
                    <div class="nav-menu-hd span-show">
                        <span class="nav-tab">网站导航</span>
                        <i class="el-icon-arrow-down"></i>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</template>

<script>
    import utils from "../../utils/utils";
    export default {
        name: "homeHead",
        data(){
            return {
                isHome: true,
                showUser: false,
                showJB: false,
                showCart: false,
                showSC: false,
                showMJ: false,
                showKF: false,
                showNAV: false,
                logined: false,
                avatarUrl: require('../../assets/tmp/avatar_50x50.jpg'),
                userInfo: {
                    username: 'wangpeilin',
                    nickName: '红林宝宝yo',
                    jScore: 485,
                    memberType: '普通会员'
                },
                cartInfo: {
                    recentAdd: 1,
                    recentList: [
                        /*{
                            goodId: '0',
                            imgUrl: this.avatarUrl,
                            count: '￥59.00',
                            title: '韩夫人吸尘器家用小型大吸力吸猫毛手持式电脑地毯强力除螨大功率',
                            goodUrl: '',
                            info: '颜色分类:天蓝色'
                        },
                        {
                            goodId: '1',
                            imgUrl: this.avatarUrl,
                            count: '￥59.00',
                            title: '吸尘器地毯强力除螨大功率',
                            goodUrl: '',
                            info: '颜色分类:天蓝色'
                        }*/
                    ]
                }
            }
        },
        created() {
            let token = localStorage.getItem('Authorization')
            this.logined = (!(token === null || token === ''))
            this.isHome = this.$route.path === '/'
        },
        methods: {
            logout(){
                localStorage.removeItem('Authorization')
                this.$router.go(0)
            },
            linkTo(path){
                this.$router.push(path)
            }
        }
    }
</script>

<style>

    .f1 {
        display: inline-block;
        float: left;
    }
    .f2 {
        display: inline-block;
        float: right;
    }
    .home-head span, .home-head i {
        font-size: 12px;
        text-align: center;
        line-height: 35px;
    }

    .home-head i {
        display: inline-block;
        margin-left: 5px;
        margin-right: 5px;
    }

    .home-head {
        margin: 0 auto;
        width: 1190px;
        height: 35px;
        background: #f5f5f5;
    }

    .home-head ul {
        list-style: none;
        padding: 0px !important;
        margin: 0px;
    }

    .home-head li {
        display: inline-block;
        /*float: left;*/
    }

    .home-head .head-left {
        margin-left: 20px;
        width: 280px;
        float: left;
    }

    .nav-sign span {
        margin-right: 10px;
    }

    .home-head .head-left .login-nav .nav-menu-hd-n {
        z-index: 102;
        position: relative;
        padding: 0px 6px;
        height: 35px;
        line-height: 35px;
    }

    .home-head .head-left .login-nav .nav-menu-hd-n a {
        text-decoration: none;
        font-size: 12px;
    }

    .nav-menu-hd a , .nav-menu-hd-n a {
        float: left;
        margin-right: 7px;
        font-size: 12px;
    }

    .home-head .head-left .login-nav .nav-user {
        text-align: center;
    }

    .home-head .head-left .login-nav .nav-user a{
        display: inline-block;
        max-width: 98px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }

    .home-head .head-left .mobile-nav .nav-menu-hd {
        z-index: 102;
        position: relative;
        padding: 0 6px;
        height: 35px;
        line-height: 35px;
    }

    .home-head .head-left .login-nav .nav-menu-hd-y {
        z-index: 101;
        position: absolute;
        margin-top: -1px;
    }

    .home-head .head-right .nav-menu-hd {
        z-index: 102;
        position: relative;
        height: 35px;
        line-height: 35px;
        text-align: center;
        /*width: 84px;*/
    }

    .home-head .head-right .nav-menu-hd-h {
        z-index: 101;
        position: absolute;
        margin-top: -1px;
    }

    .head-right .cart-panel {
        width: 296px;
        line-height: 20px;
        min-height: 20px;
        background-color: #fff;
        position: absolute;
        left: 0;
        top: 0;
        padding: 8px;
        border: 1px solid #eee;
    }
    .head-right .cart-panel .mini-cart-hd {
        padding: 10px 0;
        font-size: 12px;
        font-weight: bold;
        text-align: left;
    }

    .head-right .cart-panel .mini-cart-main {
        list-style: none;
        padding: 0px;
        border-bottom: 1px solid #eee;
        overflow: hidden;
    }
    .head-right .cart-panel .mini-cart-main li {
        margin-bottom: 10px;
        height: 40px;
        overflow: hidden;
        width: 100%;
    }

    .head-right .cart-panel .mini-cart-img {
        float: left;
        margin-right: 10px;
        width: 40px;
        height: 40px;
        display: inline-block;
        overflow: hidden;
        text-align: center;
    }

    .head-right .cart-panel .mini-cart-img a {
        display: inline;
        position: static;
        line-height: 1.5;
        color: #3C3C3C;
        text-decoration: none;
        cursor: pointer;
    }

    .head-right .cart-panel .mini-cart-img a img {
        vertical-align: middle;
    }

    .head-right .cart-panel .mini-cart-count {
        float: right;
        font-weight: bold;
        font-size: 12px;
    }

    .head-right .cart-panel .mini-cart-title {
        height: 20px;
        overflow: hidden;
        text-align: left;
    }

    .head-right .cart-panel .mini-cart-title a {
        width: 156px;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
        float: left;
        color: #3C3C3C;
        cursor: pointer;
        text-decoration: none;
        font-size: 12px;
    }

    .head-right .cart-panel .mini-cart-del {
        float: right;
    }

    .head-right .cart-panel .mini-cart-del a {
        font-size: 12px;
    }

    .head-right .cart-panel .mini-cart-info {
        height: 20px;
        overflow: hidden;
        color: #9c9c9c;
        text-align: left;
        line-height: 10px;
    }
    .head-right .cart-panel .mini-cart-info span {
        display: inline-block;
        height: 20px;
        line-height: 20px;
    }


    .head-right .cart-panel .mini-cart-ft {
        text-align: right;
    }

    .head-right .cart-panel .mini-cart-ft p{
        margin-top: 10px;
        padding: 0px;
        font-size: 12px;
    }

    .head-right .cart-panel .mini-cart-ft .cart-nav-btn {
        display: inline-block;
        vertical-align: middle;
        padding: 0 10px;
        height: 25px;
        line-height: 25px;
        color: #fff;
        background-color: #675765;
        border-radius: 2px;
    }

    .home-head .head-left li {
        margin-right: 10px;
    }

    .home-head .head-right {
        margin-right: 20px;
        width: 800px;
        float: right;
    }

    .home-head .head-right .nav-li {
        margin-left: 10px;
        max-width: 100px;

    }

    .home-head .head-right .nav-li:nth-last-child(1){
        margin-right: 10px;
    }

    .home-head .nav-tab:hover{
        color: red;
        cursor: pointer;
    }

    .home-head .span-show:hover{
        color: red;
        cursor: pointer;
        background-color: white;
    }

    .home-head .hover-show {
        background-color: white;
        position: relative;
        z-index: 1001;
    }

    .user-nav-content {
        z-index: 1001;
        position: relative;
        margin-top: -1px;
    }

    .user-bd-panel {
        width: 248px;
        line-height: normal;
        position: relative;
        left: 0;
        top: 0;
        padding: 8px;
        border: 1px solid #eee;
        background-color: #fff;
    }
    .user-wrapper {
        float: left;
        margin-left: 9px;
        margin-right: 10px;
        width: 62px;
        height: 62px;
        padding: 9px;
        box-sizing: content-box;
    }
    .user-wrapper a{
        color: #3C3C3C;
        display: block;
        overflow: hidden;
        border: 3px solid #fff;
        border-radius: 50%;
        cursor: pointer;
        text-decoration: none;
    }
    .user-wrapper a img {
        display: block;
        width: 56px;
        height: 56px;
    }
    .user-info {
        height: 80px;
        overflow: hidden;
    }
    .user-info p {
        height: 20px;
        line-height: 20px;
        margin: 0px;
        padding: 0px;
    }
    .user-info .user-operate {
        text-align: right;
    }
    .user-info a{
        text-decoration: none;
        cursor: pointer;
        color: #3C3C3C;
        font-size: 12px;
        display: inline-block;
        height: 20px;
        line-height: 20px;
        margin-top: 0px;
        margin-left: 5px;
    }
    .user-info a:hover{
        color: red;
    }
    .user-info span {
        color: #3C3C3C;
        font-size: 12px;
        display: inline-block;
        height: 20px;
        line-height: 20px;
        margin-top: 0px;
        margin-left: 5px;
    }
    .j-score {
        margin-top: 5px !important;
        font-size: 12px;
        text-align: left;
    }
    .level-info {
        font-size: 12px;
        text-align: left;
    }
    .user-privilege {
        display: block;
        text-align: center;
        border: 1px solid #ffe8de;
        background-color: #FFF0E8;
        padding: 4px 0px;
        text-decoration: none;
        color: #3C3C3C;
    }
    .head-right .nav-li:nth-child(1){
        margin-left: 40px;
    }
</style>
<style scoped>

</style>
