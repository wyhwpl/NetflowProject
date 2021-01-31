<template>
    <div class="content">
        <el-container class="account-content">
            <el-aside class="content-aside" style="width: 139px">
                <el-menu
                        default-active="2"
                        class="el-menu-vertical-demo">
                    <el-menu-item-group class="content-menu-group">
                        <template slot="title">
                            <span class="content-title">账号管理</span>
                        </template>
                        <el-menu-item class="content-menu-item" ><router-link to="/account/safe">安全设置</router-link></el-menu-item>
                        <el-menu-item class="content-menu-item"><router-link to="/account/person">个人资料</router-link></el-menu-item>
                        <el-menu-item class="content-menu-item"><router-link to="/account/person">个人成长信息</router-link></el-menu-item>
                        <el-menu-item class="content-menu-item"><router-link to="/account/pay">支付宝绑定设置</router-link></el-menu-item>
                        <el-menu-item class="content-menu-item"><router-link to="/account/sina">微博绑定设置</router-link></el-menu-item>
                        <el-menu-item class="content-menu-item"><router-link to="/account/transaction">个人交易信息</router-link></el-menu-item>
                        <el-menu-item class="content-menu-item"><router-link to="/account/receive">收货地址</router-link></el-menu-item>
                        <el-menu-item class="content-menu-item"><router-link to="/account/chat">旺旺网页版设置</router-link></el-menu-item>
                        <el-menu-item class="content-menu-item"><router-link to="/account/grant">应用授权</router-link></el-menu-item>
                    </el-menu-item-group>
                </el-menu>
            </el-aside>
            <el-main class="content-main">
                <router-view></router-view>
            </el-main>
        </el-container>
    </div>
</template>

<script>
    export default {
        name: "accountPage"
    }
</script>

<style>
    .content{
        background-color: white;
    }
    .account-content{
        width: 990px;
        height: 990px;
        margin: 0 auto;
    }
    .account-content .el-menu-vertical-demo{
        border: none;
    }
    .content-main {
        /*background-color: #3a8ee6;*/
        padding: 0px;
    }

    .content-menu-group{
        margin-top: 25px;
    }
    .content-aside .content-title{
        text-align: left;
    }
    .content-menu-item{
        height: 30px;
        font-size: 12px;
        line-height: 30px;
        text-align: left;
        padding: 0px !important;
    }
    .content-menu-item a {
        text-decoration: none;
        color: #3C3C3C;
    }
</style>
<style lang="scss">
    .account-content div.el-menu-item-group__title{
        padding: 0 !important;
        font-size: 15px;
    }
    .account-content div.el-menu-item-group__title span{
        display: block;
        margin-left: 0px;
    }

</style>
