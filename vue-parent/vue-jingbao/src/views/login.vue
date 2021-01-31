<template>
    <div class="login-page">
        <div class="login-header">
            <div class="logo">
                <a href="" title="京宝网">
                    <span>京宝网</span>
                    <span>jingbao.com</span>
                </a>
            </div>
        </div>
        <div class="content">
            <div class="login-content"></div>
            <div class="login-layout">
                <div class="login-box-wrapper">
                    <div class="login-box">
                        <div v-if="usePassword" class="login-view-password">
                            <div class="view-type-qrcode">
                                <i class="iconfont icon-qrcode" @click="usePassword = false"/>
                            </div>
                            <div class="login-content-layout">
                                <div class="login-password">
                                    <div class="login-switch-tab">
                                        <a :class="activeLeft" @click="changeTab(0)">
                                            密码登录
                                        </a>
                                        <a :class="activeRight" @click="changeTab(1)">
                                            短信登录
                                        </a>
                                    </div>
                                    <div class="login-error"></div>
                                    <el-form v-if="passwordLogin" ref="form"
                                             :model="userInfo"
                                             class="user-form"
                                             auto-complete="on"
                                             label-position="left">
                                        <el-form-item prop="username">
                                            <el-input
                                                    id="account"
                                                    ref="username"
                                                    v-model="userInfo.username"
                                                    placeholder="会员名/邮箱/手机号"
                                                    name="username"
                                                    type="text"
                                                    tabindex="1"
                                                    auto-complete="on">
                                                <span slot="prefix" class="svg-container">
                                                <svg-icon icon-class="user" />
                                                </span>
                                            </el-input>
                                        </el-form-item>
                                        <el-form-item prop="password">
                                            <el-input
                                                    id="psw"
                                                    :key="passwordType"
                                                    ref="password"
                                                    v-model="userInfo.password"
                                                    :type="passwordType"
                                                    placeholder="请输入登录密码"
                                                    name="password"
                                                    tabindex="2"
                                                    auto-complete="on"
                                                    @keyup.enter.native="doLogin(1)">
                                                <span slot="prefix" class="svg-container">
                                                    <svg-icon icon-class="password" />
                                                </span>
                                                <span slot="suffix" class="show-pwd" @click="showPwd">
                                                    <svg-icon :icon-class="passwordType === 'password' ? 'eye' : 'eye-open'"/>
                                                </span>
                                            </el-input>
                                        </el-form-item>
                                        <el-button
                                                id="login_btn"
                                                :loading="loading"
                                                type="primary"
                                                style="width: 100%;margin-bottom: 30px;"
                                                @click.native.prevent="doLogin(1)">
                                            登录
                                        </el-button>
                                        <div class="third-login">
                                            <a>微博登录</a>
                                            <a>支付宝登录</a>
                                        </div>
                                        <div class="login-links">
                                            <a>忘记密码</a>
                                            <a>忘记用户名</a>
                                            <a>免费注册</a>
                                        </div>
                                    </el-form>
                                    <el-form v-else ref="form"
                                             :model="phoneInfo"
                                             class="phone-form"
                                             auto-complete="on"
                                             label-position="left">
                                        <el-form-item prop="username">
                                            <el-input
                                                    id="phoneNumber"
                                                    ref="phoneNumber"
                                                    v-model="phoneInfo.phoneNumber"
                                                    placeholder="请输入手机号"
                                                    name="phoneNumber"
                                                    type="text"
                                                    tabindex="1"
                                                    auto-complete="on">
                                                <span slot="prefix" class="svg-container">
                                                <svg-icon icon-class="user" />
                                                </span>
                                            </el-input>
                                        </el-form-item>
                                        <el-form-item prop="verifyCode">
                                            <el-input
                                                    id="vc"
                                                    ref="verifyCode"
                                                    v-model="phoneInfo.verifyCode"
                                                    type="text"
                                                    placeholder="请输入验证码"
                                                    name="verifyCode"
                                                    tabindex="2"
                                                    auto-complete="on"
                                                    @keyup.enter.native="doLogin(2)">
                                                <span slot="prefix" class="svg-container">
                                                    <svg-icon icon-class="password" />
                                                </span>
                                                <span slot="suffix" class="send-verify" @click="showPwd">
                                                    <a>获取验证码</a>
                                                </span>
                                            </el-input>
                                        </el-form-item>
                                        <el-button
                                                id="login_btn_code"
                                                :loading="loading"
                                                type="primary"
                                                style="width: 100%;margin-bottom: 30px;"
                                                @click.native.prevent="doLogin(2)">
                                            登录
                                        </el-button>
                                        <div class="third-login">
                                            <a>微博登录</a>
                                            <a>支付宝登录</a>
                                        </div>
                                        <div class="login-links">
                                            <a>忘记密码</a>
                                            <a>忘记用户名</a>
                                            <a>免费注册</a>
                                        </div>
                                    </el-form>
                                </div>
                            </div>
                        </div>
                        <div v-else class="login-view-qrcode">
                            <div class="view-type-password">
                                <div class="qrcode-login-title">手机扫码, 安全登录</div>
                                <i class="iconfont icon-pc" @click="usePassword = true"/>
                            </div>
                            <div class="login-content-layout">
                                <div class="login-qrcode">
                                    <div class="qrcode-content">
                                        <div class="qrcode-img">
                                            <canvas></canvas>
                                            <div class="qrcode-error">
                                                <p>二维码已失效</p>
                                                <button class="refresh" type="button">刷新二维码</button>
                                            </div>
                                        </div>
                                        <div class="qrcode-desc">
                                            <i class="iconfont icon-scan" />
                                            <p>
                                                <span>打开</span>
                                                <a href="">手机京宝</a>
                                                |
                                                <a href="">手机玉兔</a>
                                                <br>
                                                <span>扫一扫登录</span>
                                            </p>
                                        </div>
                                    </div>
                                    <div class="qrcode-links">
                                        <a href="">密码登录</a>
                                        <a href="">免费注册</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import utils from "../utils/utils";
    import { mapMutations } from 'vuex'
    export default {
        name: "login",
        data() {
            const validateUsername = (rule, value, callback) => {
                if (value.length < 3) {
                    callback(new Error('Please enter the conrrect user name'))
                } else {
                    callback()
                }
            }
            const validatePassword = (rule, value, callback) => {
                if (value.length < 6) {
                    callback(new Error('The Password can not be less than 6 digits'))
                } else {
                    callback()
                }
            }
            const validatePhone = (rule, value, callback) => {
                if (value.length > 11 || value.length < 11) {
                    callback(new Error('The phoneNumber must be 11 digits'))
                } else {
                    callback()
                }
            }
            return {
                activeLeft: 'active-tab',
                activeRight: '',
                passwordLogin: true,
                usePassword: true,
                userInfo: {
                    username: '',
                    password: '',
                },
                userRules: {
                    username: [
                        { required: true, trigger: 'blur', validator: validateUsername }
                    ],
                    password: [
                        { required: true, trigger: 'blur', validator: validatePassword }
                    ]
                },
                phoneInfo: {
                    phoneNumber: '',
                    verifyCode: ''
                },
                phoneRules: {
                    phoneNumber: [
                        {required: true, trigger: 'blur', validator: validatePhone }
                    ]
                },
                loading: false,
                passwordType: 'password',
                redirect: undefined
            }
        },
        methods: {
            ...mapMutations(['changeLogin']),
            changeTab(index) {
                if(index === 0){
                    this.activeLeft = 'active-tab'
                    this.activeRight = ''
                    this.passwordLogin = true
                }else{
                    this.activeLeft = ''
                    this.activeRight = 'active-tab'
                    this.passwordLogin = false
                }
            },
            showPwd() {
                if(this.passwordType === 'password'){
                    this.passwordType = ''
                }else{
                    this.passwordType = 'password'
                }
                this.$nextTick(() => {
                    this.$refs.password.focus()
                })
            },
            doLogin(loginType) {
                let url = ''
                let submitData = null

                if(loginType === 1) {
                    url = '/netflow/authority/user/login'
                    submitData = this.userInfo
                }
                if(loginType === 2) {
                    url = '/netflow/authority/user/loginByPhone'
                    submitData = this.phoneInfo
                }

                console.log(url,' , ',submitData)

                this.loading = true
                let success = (response) => {
                    if (response.status === 200) {
                        if (response.data.errorCode === '0') {
                            this.token = '' + response.data.data
                            this.changeLogin({ Authorization: this.token })
                            let query = this.$router.query
                            let redirect = query === undefined ? '' : query.redirect
                            let to = redirect === null || redirect === '' ? '/' : redirect
                            this.$router.push(to)
                            // alert('登录成功')
                        } else {
                            alert('登录失败')
                        }
                    }
                }
                let failed = error => {
                    alert('登录失败')
                    this.loading = false
                    console.log(error)
                }
                utils.axiosMethod({
                    method: 'POST',
                    url: url,
                    data: submitData,
                    callback: success,
                    catch: failed
                })
            }
        }
    }
</script>

<style>

    .logo {
        width: 1200px;
        height: 88px;
        margin: 0 auto;
        overflow: hidden;
    }

    .logo a {
        text-align: left;
        text-decoration: none;
        color: #675765;
    }

    .logo a span {
        display: block;
        color: #675765;
        font-weight: bold;
    }
    .logo a span:nth-child(1){
        font-size: 30px;
        margin-top: 10px;
    }
    .logo a span:nth-child(2){
        font-size: 18px;
    }
    .active-tab {
        border-bottom: 2px solid black;
    }

    .view-type-qrcode {
        position: static;
    }

    .view-type-qrcode i {
        position: absolute;
        top: 5px;
        right: 5px;
        font-size: 52px;
        /*clip: rect(0px 0px 0px 0px);*/
        color: #675765;
    }

    .view-type-password .qrcode-login-title {
        height: 18px;
        line-height: 18px;
        font-size: 16px;
        color: #3c3c3c;
        margin-top: 9px;
        padding-bottom: 8px;
        font-weight: 700;
        text-align: left;
    }

    .view-type-password i {
        position: absolute;
        top: 5px;
        right: 5px;
        font-size: 52px;
        /*clip: rect(0px 0px 0px 0px);*/
        color: #675765;
    }

    .qrcode-img {
        position: relative;
        margin: 20px auto;
        font-size: 14px;
        box-shadow: 0 0 8px #c6c4ce;
        opacity: 1;
        width: 140px;
        height: 140px;
    }

    .qrcode-error {
        background: hsla(0,0%,100%,.95);
        position: absolute;
        left: 0;
        top: 0;
        z-index: 9999;
        width: 100%;
        height: 100%;
    }

    .qrcode-error p {
        color: #3C3C3C;
        font-weight: 700;
        margin-top: 38px;
        margin-bottom: 8px;
        text-align: center;
    }

    .refresh {
        background-color: #675765;
        color: white;
        font-size: 12px;
        width: 110px;
        height: 34px;
        line-height: 34px;
        text-align: center;
        margin: 0 auto;
        display: block;
        cursor: pointer;
    }

    .qrcode-desc {
        overflow: hidden;
        margin: 0 auto;
        width: 188px;
    }

    .qrcode-desc i {
        font-size: 34px;
        color: #675765;
        float: left;
    }
    .qrcode-desc p {
        font-size: 12px;
        padding-left: 44px;
        margin: 0px;
        text-align: left;
    }

    .qrcode-desc p span{
        margin-right: 5px;
    }

    .qrcode-desc p a{
        text-decoration: none;
        cursor: pointer;
        color: #675765;
    }

    .qrcode-links {
        text-align: right;
        font-size: 12px;
    }
    .qrcode-links a {
        text-decoration: none;
        margin-left:  5px;
        color: #675765;
    }

    .login-page {
        width: 100%;
        height: 100%;
        background-color: white;
    }
    .login-header {
        padding: 0px;
        /*height: 88px;*/
        width: 100%;
    }
    .content {
        width: 100%;
        position: relative;
    }
    .login-content {
        position: absolute;
        z-index: 1;
        top: 0;
        left: 0;
        background-size: cover;
        background-repeat: no-repeat;
        background-position: 50%;
        width: 100%;
        height: 600px;
        background-image: url("../assets/tmp/login_page_bg.jpg");
    }
    .login-layout {
        width: 1200px;
        margin: 0 auto;
        overflow: hidden;
        position: relative;
        height: 600px;
        z-index: 2;
    }
    .login-box-wrapper {
        position: absolute;
        top: 120px;
        right: 60px;
        width: 350px;
        /*height: 350px;*/
    }
    .login-box {
        padding: 25px 25px 23px;
        color: #6c6c6c;
        background: #f5f5f5;
        position: relative;
        margin: 0 auto;
    }
    a:hover{
        cursor: pointer;
    }
    .login-view-password {
        margin-bottom: 0px;
    }
    .login-view-password .login-switch-tab {
        margin-bottom: 20px;
        margin-top: 4px;
        text-align: left;
    }
    .login-view-password .login-switch-tab a{
        height: 18px;
        line-height: 5px;
        font-size: 16px;
        color: #3c3c3c;
        margin: 9px 10px 0 0 !important;
        font-weight: 700;
        display: inline-block;
    }
    .login-view-password .third-login , .login-links{
        margin-bottom: 0px;
        margin-top: 16px;
        font-size: 12px;
    }
    .login-view-password .third-login {
        text-align: left;
    }
    .login-view-password .third-login a {
        margin-right: 10px;
    }
    .login-view-password .login-links {
        text-align: right;
    }
    .login-view-password .login-links a{
        margin-left: 10px;
    }
    .svg-container {
        width: 40px;
        height: 40px;
        background-color: #ccc;
        color: #fff;
        display: inline-block;
        margin-left: 0px;
    }
</style>
<style lang="scss">

    .login-view-password .user-form button.el-button {
        margin-bottom: 0px !important;
        background-color: #675765;
        font-size: 16px;
    }
    .login-view-password .phone-form button.el-button {
        margin-bottom: 0px !important;
        background-color: #675765;
        font-size: 16px;
    }
    .login-view-password .phone-form .send-verify a{
        font-size: 12px;
    }
    .login-view-password input.el-input__inner {
        border-radius: 0px;
        padding-left: 44px;
    }
    .login-view-password span.el-input__prefix {
        left: 0px;
    }
    .login-view-password span.el-input__prefix svg.svg-icon {
        font-size: 20px;
    }
</style>
