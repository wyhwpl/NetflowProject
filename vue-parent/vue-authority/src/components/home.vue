<template>
  <el-container class="dashboard-editor-container">
    <!--顶部-->
    <el-header style="border-bottom: 1px solid gray;" class="head">
      <el-row style="margin: 10px 15px">
        <el-col :span="1">
          <!--收缩条-->
          <div class="title-name">
            <a href="#" @click="changeCollapse" style="font-size: 25px;color:#909399;"><i
              :class="collpaseIcon"></i></a>
          </div>
        </el-col>
        <el-col :span="4">
          <div class="title-name">
            <a href="home.vue"></a>
            统一权限管理系统
          </div>
        </el-col>
        <el-col :span="2" :offset="17">
          <el-button @click="logout" type="info" icon="el-icon-switch-button" circle></el-button>
<!--          <el-button @click="logout">退出登录</el-button>-->
        </el-col>
      </el-row>
    </el-header>
    <!--中央区域-->
    <el-main>
      <el-container>
        <!--左侧导航栏-->
        <el-aside :style="{width:collpaseWidth}">
          <!--default-active代表导航栏默认选中哪个index, :collapse决定导航栏是否展开，为boolean类型
          :router决定导航栏是否开启路由模式，即在菜单item上设置路由是否生效，值为boolean类型-->

          <el-menu
            default-active="1"
            class="el-menu-vertical-demo"
            :collapse="isCollapse"
            :router="true">
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-user-solid"></i>
                <span>用户管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item>
                  <router-link to="/user">
                    <span> 用户管理</span>
                  </router-link>
                </el-menu-item>
                <el-menu-item>
                  <router-link to="/role">
                    <span>角色管理</span>
                  </router-link>
                </el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="2">
              <template slot="title">
                <i class="el-icon-menu"></i>
                <span>应用管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item>
                  <router-link to="/application">
                    <span>应用管理</span>
                  </router-link>
                </el-menu-item>
                <el-menu-item>
                  <router-link to="/resource">
                    <span>应用资源</span>
                  </router-link>
                </el-menu-item>
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
        </el-aside>
        <!--主内容显示区域-->
        <el-main>
          <!--路由渲染-->
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-main>
    <!--底部-->
    <el-footer style="border-top: 1px solid gray"></el-footer>
  </el-container>
</template>

<script>
    // 这一大段JS就是为了做收缩/展开导航栏而用的！
    import { mapMutations } from 'vuex'
    export default {
        name: "home",
        data: function () {
            return {
                isCollapse: false, // 决定左侧导航栏是否展开
            }
        },
        computed: {
            collpaseIcon: function () { // 左侧导航栏是否展开状态的图标
                // 如果是展开状态就图标向右，否则图标向左
                return this.isCollapse ? 'el-icon-s-fold' : 'el-icon-s-unfold';
            },
            collpaseWidth: function () { // 左侧导航栏是否展开状态的宽度
                // 如果是展开状态就导航栏宽度为65px，否则200px
                return this.isCollapse ? '0px' : '200px';
            }
        },
        methods: {
            ...mapMutations(['changeLogin']),
            changeCollapse: function () { // 更改左侧导航栏展示状态
                this.isCollapse = !this.isCollapse;
            },
            logout: function () {
                localStorage.removeItem('Authorization')
                this.$router.push('/login')
            }
        }
    }
</script>
<style lang="scss">

  .title-name{
    margin-bottom: 0;
    font-size: 24px;
    min-height: 31px;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 31px;
    margin-top: 5px;
    color: #87878a;
    white-space: normal;
  }
  .dashboard-editor-container{
    .el-header{
      background-color: #2c3e50;
    }
    .el-main{
      /*background-color: deepskyblue;*/
    }
    .el-footer{
      background-color: #2c3e50;
    }

  }
  .head {
    .el-col{
      height: 40px;
    }
  }
</style>
<style lang="scss" scoped>
  /*整体显示区域布局样式*/
  .el-container {
    height: 100%;
  }

  .router-link-active {     //点击时去掉下划线
    text-decoration: none;
  }

  a {
    text-decoration: none; //去掉原有链接文字下划线
    color: black;
  }

  .el-header, .el-main {
    padding: 0;
  }

  /*左边导航栏具体样式*/
  .el-menu-vertical-demo.el-menu {
    text-align: left;
    height: 100%;
    padding: 0 0 0 0px;
  }

  el-container > .el-menu-vertical-demo.el-menu {
    padding: 0;
  }

  .el-submenu .el-menu-item, .el-menu-item {
    min-width: 50px;
  }

  .el-menu-item {
    padding: 0;
    /*border-bottom: black solid 0.5px;*/
    /*background-color: #2c3e50*/
  }

  .dashboard-editor-container {
    /*padding: 32px;*/
    /*background-color: rgb(240, 245, 245);*/
    height: 100%;
    width: 100%;
    position: fixed;
    left: 0px;
    right: 0px;
    top: 0px;
    bottom: 0px;
  }
</style>
