<template>
    <div class="account-page">
        <div class="account-head">
            <div class="account-head-logo">
                <a href="">我的京宝</a>
            </div>
            <div class="account-head-nav">
                <ul class="head-nav-tabs">
                    <li class="head-nav-tab">
                        <a href="">首页</a>
                        <i class="arrow-up el-icon-arrow-up"></i>
                    </li>
                    <li class="head-nav-tab" @mouseenter="showPane = true" @mouseleave="showPane = false">
                        <a href="">账号管理
                            <i class="el-icon-arrow-down"></i>
                        </a>
                        <i class="el-icon-arrow-up arrow-up-more" v-if="showPane"></i>
                        <div class="head-nav-tab-sub" v-if="showPane">
                            <div class="sub-op safe-setting">
                                <span class="sub-op-title">安全设置</span>
                                <ul class="sub-op-content">
                                    <li class="sub-op-con">
                                        <a href="">修改登录密码</a>
                                    </li>
                                    <li class="sub-op-con">
                                        <a href="">手机绑定</a>
                                    </li>
                                    <li class="sub-op-con">
                                        <a href="">密保问题设置</a>
                                    </li>
                                    <li class="sub-op-con">
                                        <a href="">其他</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="sub-op person-info-head">
                                <span class="sub-op-title">个人资料</span>
                                <ul class="sub-op-content">
                                    <li class="sub-op-con">
                                        <a href="">收获地址</a>
                                    </li>
                                    <li class="sub-op-con">
                                        <a href="">修改头像、昵称</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="sub-op account-bind">
                                <span class="sub-op-title">账号绑定</span>
                                <ul class="sub-op-content">
                                    <li class="sub-op-con">
                                        <a href="">支付宝绑定</a>
                                    </li>
                                    <li class="sub-op-con">
                                        <a href="">微博绑定</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </li>
                </ul>
                <div class="head-nav-search">
                    <el-input>
                        <el-button slot="append">搜索</el-button>
                    </el-input>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "accountHead",
        data() {
            return {
                showPane: false
            }
        }
    }
</script>

<style>

    .account-page {
        background-color: #675765;
    }
    .account-head {
        margin: 0 auto;
        width: 1190px;
        height: 60px;
    }
    .account-head ul{
        list-style: none;
    }
    .account-head a{
        text-decoration: none;

    }
    .account-head-logo {
        float: left;
        position: relative;
        overflow: hidden;
        width: 16%;
        height: 35px;
        height: 60px;
        line-height: 45px;
    }
    .account-head-logo a {
        font-size: 30px;
        color: white;
        font-weight: bold;
        width: 140px;
        height: 36px;
        display: inline-block;
        vertical-align: middle;
    }
    .account-head-nav {
        float: right;
        width: 82.4%;
        height: 100%;
    }
    .account-head-nav .head-nav-tabs {
        position: absolute;
        padding: 0px;
        margin-top: 10px;
    }
    .account-head-nav .head-nav-tab {
        position: relative;
        float: left;
        cursor: pointer;
        z-index: 1;
        height: 50px;
        font: 400 14px/36px tahoma;
        margin-right: 20px;
        margin-top: 0px;
    }

    .account-head-nav .head-nav-tab .head-nav-tab-sub{
        z-index: 102;
        position: absolute;
        width: 470px;
        left: -175px;
        top: 40px;
        background-color: white;
    }

    .head-nav-tab-sub .sub-op {
        float: left;
        width: 156px;
        padding: 10px 0;
    }
    .head-nav-tab-sub .sub-op ul{
        list-style: none;

    }

    .head-nav-tab-sub .sub-op .sub-op-title{
        font-size: 16px;
        display: block;
    }

    .head-nav-tab-sub .sub-op .sub-op-content{
        padding: 0px;
        margin: 0px;
    }

    .head-nav-tab-sub .sub-op .sub-op-con {
        color: #3C3C3C;
    }

    .head-nav-tab-sub .sub-op .sub-op-con a{
        color: #3C3C3C;
        font-size: 13px;

    }
    .head-nav-tab-sub .sub-op .sub-op-con a:hover{
        color: #675765;
    }
    .account-head-nav .head-nav-tab .arrow-up {
        border-style: solid;
        border-width: 6px;
        font-size: 0;
        height: 0;
        line-height: 0;
        position: absolute;
        width: 0;
        border-color: #675765 #675765 #fff;
        left: 50%;
        margin-left: -6px;
        box-shadow: 0 1px 0 #fff;
        bottom: 2px;
    }
    .account-head-nav .head-nav-tab .arrow-up-more {
        border-style: solid;
        border-width: 6px;
        font-size: 0;
        height: 0;
        line-height: 0;
        position: absolute;
        width: 0;
        border-color: #675765 #675765 #fff;
        left: 50%;
        margin-left: -6px;
        box-shadow: 0 1px 0 #fff;
        top: 28px;
        bottom: 2px;
    }
    .account-head-nav .head-nav-tab a {
        color: white;
        font-size: 14px;
        display: block;
        text-align: center;
        padding: 0 25px;
    }
    .account-head-nav .head-nav-search{
        width: 322px;
        float: right;
        background: #fff;
        height: 27px;
        margin-top: 15px;
        border-radius: 4px;
    }
</style>

<style lang="scss">

    .account-head-nav div.el-input{
        width: 322px;
        height: 27px !important;

    }
    .account-head-nav div.el-input input.el-input__inner{
        padding: 0px 5px;
    }
    .account-head-nav input.el-input__inner{
        height: 27px;
    }
    .account-head-nav button.el-button {
        height: 27px;
    }
</style>
