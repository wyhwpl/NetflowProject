<template>
  <div class="editor">
    <el-form ref="form"
             :model="userInfo"
             :rules="userRules"
             class="user-form"
             auto-complete="on"
              label-width="100px">
      <el-row>
        <el-col :span="12">
          <el-form-item label="用户名" prop="username">
            <el-input class="inputE" v-model="userInfo.username" placeholder="请输入用户" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="用户密码" prop="password">
            <el-input class="inputE" v-model="userInfo.password" placeholder="请输入用户密码" type="password"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="手机号码" prop="phone">
            <el-input class="inputE" v-model="userInfo.phone" placeholder="请输入手机号码" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="邮箱" prop="email">
            <el-input class="inputE" v-model="userInfo.email" placeholder="请输入邮箱" maxlength="50" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="姓名" prop="name">
            <el-input class="inputE" v-model="userInfo.name" placeholder="请输入姓名" maxlength="50" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="身份证号码" prop="idCard">
            <el-input class="inputE" v-model="userInfo.idCard" placeholder="请输入身份证号码" maxlength="18" />
          </el-form-item>
        </el-col>
        <!--<el-col :span="12">
          <el-form-item label="用户性别">
            <el-select v-model="form.sex" placeholder="请选择">
              <el-option v-for="dict in sexOptions" :key="dict.dictValue" :label="dict.dictLabel" :value="dict.dictValue"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="状态">
            <el-radio-group v-model="form.status">
              <el-radio v-for="dict in statusOptions" :key="dict.dictValue" :label="dict.dictValue">{{dict.dictLabel}}</el-radio>
            </el-radio-group>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="岗位">
            <el-select v-model="form.postIds" multiple placeholder="请选择">
              <el-option v-for="item in postOptions" :key="item.postId" :label="item.postName" :value="item.postId" :disabled="item.status == 1"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="角色">
            <el-select v-model="form.roleIds" multiple placeholder="请选择">
              <el-option v-for="item in roleOptions" :key="item.roleId" :label="item.roleName" :value="item.roleId" :disabled="item.status == 1"></el-option>
            </el-select>
          </el-form-item>
        </el-col>-->
        <el-col :span="12">
          <el-form-item label="出生日期">
            <el-input class="inputE" v-model="userInfo.birthday" placeholder="请选择出生日期" type="date" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>

<script>
    export default {
        name: 'edit',
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
                    callback(new Error('The Password must more than 5 digits'))
                } else {
                    callback()
                }
            }
            const validatePhone = (rule, value, callback) => {
                if (value.length > 11 || value.length < 11) {
                    callback(new Error('The phone must have 11 digits'))
                } else {
                    callback()
                }
            }
            return {
                userInfo: {
                    id: '',
                    username: '',
                    password: '',
                    phone: '',
                    name: '',
                    idCard: '',
                    email: '',
                    birthday: null
                },
                userRules: {
                    username: [
                        { required: true, trigger: 'blur', validator: validateUsername }
                    ],
                    password: [
                        { required: true, trigger: 'blur', validator: validatePassword }
                    ],
                    phone: [
                        { required: true, trigger: 'blur', validator: validatePhone }
                    ]
                }
            }
        },
        methods: {
            dataInit(data) {
                console.log('init:' + data)
                this.userInfo = data
            }
        }
    }
</script>

<style lang="scss">
  $bg: #283443;
  $light_gray: #fff;
  $cursor: #fff;

  @supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
    .editor .el-input input {
      color: $cursor;
    }
  }

  /* reset element-ui css */
  /*.editor {
    .el-input {
      !*display: inline-block;
      height: 47px;
      width: 85%;*!

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
      background: rgba(180, 180, 180, 0.95);
      border-radius: 5px;
      !*color: #454545;*!
    }
    .el-col {
      padding-left: 10px;
    }
  }*/

</style>

<style lang="scss" scoped>

  $bg: #2d3a4b;
  $dark_gray: #889aa4;
  $light_gray: #eee;

  .editor {
    /*height: 100%;
    width: 100%;
    position: fixed;
    background-color: $bg;
    overflow: hidden;
    top: 0px;
    bottom: 0px;
    left: 0px;
    right: 0px;*/
    display: flex;
    flex-direction: column;
    justify-content: space-around;


  /*.user-form {
    position: relative;
    width: 750px;
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
  }*/
  }

  .inputE >>> input {
    color: black;
  }

</style>
