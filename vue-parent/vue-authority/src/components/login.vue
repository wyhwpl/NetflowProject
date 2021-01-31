<template>
  <div class="login">
    <el-form ref="form"
             :model="loginInfo"
             :rules="loginRules"
             class="login-form"
             auto-complete="on"
             label-position="left">
      <div class="title-container">
        <h2 class="login-title">统一权限管理系统</h2>
      </div>
      <el-form-item prop="username">
        <span class="svg-container">
          <svg-icon icon-class="user" />
        </span>
        <el-input
          id="account"
          ref="username"
          v-model="loginInfo.username"
          placeholder="Username"
          name="username"
          type="text"
          tabindex="1"
          auto-complete="on"/>
      </el-form-item>
      <el-form-item prop="password">
        <span class="svg-container">
          <svg-icon icon-class="password" />
        </span>
        <el-input
          id="psw"
          :key="passwordType"
          ref="password"
          v-model="loginInfo.password"
          :type="passwordType"
          placeholder="Password"
          name="password"
          tabindex="2"
          auto-complete="on"
          @keyup.enter.native="doLogin"/>
        <span class="show-pwd" @click="showPwd">
          <svg-icon :icon-class="passwordType === 'password' ? 'eye' : 'eye-open'"/>
        </span>
      </el-form-item>
      <el-button
        id="login_btn"
        :loading="loading"
        type="primary"
        style="width: 100%;margin-bottom: 30px;"
        @click.native.prevent="doLogin">
        立即登录
      </el-button>
      <svg-icon icon-class="password" />
    </el-form>
  </div>
  <!--<div class="login">
    <el-form ref="form" :model="loginInfo"  label-width="0px" class="login-form">
        <h2 class="login-title">统一权限管理系统</h2>
        <el-form-item  prop="username" class="item">
          <label for="username">用户名</label>
          <el-input v-model="loginInfo.username" class="user"></el-input>
        </el-form-item>
        <el-form-item  prop="password" class="item">
          <label for="password">密码</label>
          <el-input type="password" v-model="loginInfo.password" class="passwd" ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="doLogin" class="login-button">立即登录</el-button>
        </el-form-item>

    </el-form>
  </div>-->
</template>

<script>

import utils from '../utils/utils'
import { mapMutations } from 'vuex'
import SvgIcon from './SvgIcon';
export default {
  name: 'login',
  components: {
    SvgIcon
  },
  data () {
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
    return {
      loginInfo: {
        username: '',
        password: ''
      },
      loginRules: {
          username: [
              { required: true, trigger: 'blur', validator: validateUsername }
          ],
          password: [
              { required: true, trigger: 'blur', validator: validatePassword }
          ]
      },
      loading: false,
      passwordType: 'password',
      redirect: undefined
    }
  },
  /*watch: {
    $route: {
        handler: function (route) {
            this.redirect = route.query && route.query.redirect
        },
        immediate: true
    }
  },*/
  methods: {
    ...mapMutations(['changeLogin']),
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
    doLogin() {
      this.loading = true
      let success = (response) => {
        if (response.status === 200) {
          if (response.data.errorCode === '0') {
            this.token = '' + response.data.data
            this.changeLogin({ Authorization: this.token })
            this.$router.push('/user')
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
        url: '/netflow/authority/user/login',
        data: this.loginInfo,
        callback: success,
        catch: failed
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss">

  $bg: #283443;
  $light_gray: #fff;
  $cursor: #fff;

  @supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
    .login .el-input input {
      color: $cursor;
    }
  }

  /* reset element-ui css */
  .login {
    .el-input {
      display: inline-block;
      height: 47px;
      width: 85%;

      input {
        background: transparent;
        border: 0px;
        -webkit-appearance: none;
        border-radius: 0px;
        padding: 12px 5px 12px 15px;
        color: $light_gray;
        height: 47px;
        caret-color: $cursor;

        &:-webkit-autofill {
          box-shadow: 0 0 0px 1000px $bg inset !important;
          -webkit-text-fill-color: $cursor !important;
        }
      }
    }

    .el-form-item {
      border: 1px solid rgba(255, 255, 255, 0.1);
      background: rgba(0, 0, 0, 0.1);
      border-radius: 5px;
      color: #454545;
    }
  }
</style>
<style lang="scss" scoped>
/*.login-form {
  width: 350px;
  margin: 160px auto; !* 上下间距160px，左右自动居中 *!
  background-color: rgba(255, 255, 255,0.6); !* 透明背景色 *!
  padding: 30px;
  border-radius: 20px; !* 圆角 *!
}

label {
  float: left;
  !*display: inline;*!
  width: 80px;
  margin-left: 20px;
}

.item {
  margin-bottom: 20px;
}

.user, .passwd, .login-button {
  height: 30px;
}
.user, .passwd {
  !*width: 150px;*!
}

.login {
  position: fixed;
  width: 100%;
  height: 100%;
  background: url("../assets/login.jpeg") no-repeat;
  top: 0px;
  bottom: 0px;
  left: 0px;
  right: 0px;
}

.login-title {
  color: #303133;
  text-align: center;
}*/

$bg: #2d3a4b;
$dark_gray: #889aa4;
$light_gray: #eee;

.login {
  height: 100%;
  width: 100%;
  position: fixed;
  background-color: $bg;
  /*overflow: hidden;*/
  top: 0px;
  bottom: 0px;
  left: 0px;
  right: 0px;

  .login-form {
    position: relative;
    width: 520px;
    max-width: 100%;
    padding: 160px 35px 0;
    margin: 0 auto;
    overflow: hidden;
  }

  .tips {
    font-size: 14px;
    color: #fff;
    margin-bottom: 10px;

    span {
      &:first-of-type {
        margin-right: 16px;
      }
    }
  }

  .svg-container {
    padding: 6px 5px 6px 15px;
    color: $dark_gray;
    vertical-align: middle;
    width: 30px;
    display: inline-block;
  }

  .title-container {
    position: relative;

    .login-title {
      font-size: 26px;
      color: $light_gray;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: bold;
    }
  }

  .show-pwd {
    position: absolute;
    right: 10px;
    top: 7px;
    font-size: 16px;
    color: $dark_gray;
    cursor: pointer;
    user-select: none;
  }
}
</style>
