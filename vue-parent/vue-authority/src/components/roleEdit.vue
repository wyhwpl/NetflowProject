<template>
  <div class="editor">
    <el-form ref="form"
             :model="roleInfo"
             :rules="roleRules"
             class="role-form"
             auto-complete="on"
              label-width="100px">
      <el-row>
        <el-col :span="12">
          <el-form-item label="角色名" prop="roleName">
            <el-input class="inputE" v-model="roleInfo.roleName" placeholder="请输入角色" />
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>

<script>
    export default {
        name: 'roleEdit',
        data() {
            const validateRoleName = (rule, value, callback) => {
                if (value.length < 3) {
                    callback(new Error('Please enter the conrrect role name'))
                } else {
                    callback()
                }
            }
            return {
                roleInfo: {
                    id: '',
                    roleName: '',
                    appId: ''
                },
                userRules: {
                    roleName: [
                        { required: true, trigger: 'blur', validator: validateRoleName }
                    ]
                }
            }
        },
        methods: {
            dataInit(data) {
                console.log('init:' + data)
                this.roleInfo = data
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

  }

  .inputE >>> input {
    color: black;
  }

</style>
