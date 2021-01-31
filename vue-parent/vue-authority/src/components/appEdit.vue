<template>
  <div class="editor">
    <el-form ref="form"
             :model="appInfo"
             :rules="appRules"
             class="app-form"
             auto-complete="on"
              label-width="100px">
      <el-row>
        <el-col :span="12">
          <el-form-item label="应用名" prop="appName">
            <el-input class="inputE" v-model="appInfo.appName" placeholder="请输入应用名" :readonly="!ifSee" />
          </el-form-item>
          <el-form-item label="入口地址" prop="homeUrl">
            <el-input class="inputE" v-model="appInfo.homeUrl" placeholder="请输入入口地址" :readonly="!ifSee"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item v-if="ifSee" label="上传头像">
            <el-upload
              class="avatar-uploader"
              action="xxx"
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
              :on-change="flagOnchange"
              :before-upload="beforeAvatarUpload"
            >
              <img
                v-if="imageUrl"
                :src="imageUrl"
                class="avatar"
                style="display:block;width: 80px; height: 80px"
              />
              <i v-else class="el-icon-plus plus-name" style="display:block;width: 80px; height: 80px;border: 1px darkcyan dashed"></i>
            </el-upload>
          </el-form-item>
          <el-form-item v-else label="">
            <img
              :src="imageUrl"
              class="avatar"
              style="display:block;width: 80px; height: 80px"
            />
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>

<script>
    export default {
        name: 'appEdit',
        data() {
            const validateAppName = (rule, value, callback) => {
                if (value.length < 1) {
                    callback(new Error('Please enter the conrrect app name'))
                } else {
                    callback()
                }
            }
            return {
                imageUrl: '',
                ifSee: true,
                appInfo: {
                    id: '',
                    appName: '',
                    homeUrl: '',
                    imageBase: ''
                },
                appRules: {
                    appName: [
                        { required: true, trigger: 'blur', validator: validateAppName }
                    ]
                }
            }
        },
        methods: {
            dataInit(data) {
                console.log('init:' + data)
                this.appInfo = data
                this.imageUrl = this.appInfo.imageBase
                this.ifSee = true;
            },
            dataSee(data) {
                console.log('see:' + data)
                this.appInfo = data
                this.imageUrl = this.appInfo.imageBase
                this.ifSee = false
            },
            handleAvatarSuccess(res, file) {
                this.imageUrl = URL.createObjectURL(file.raw);
            },
            beforeAvatarUpload(file) {
                const ispng = file.type === "image/png";
                const isJPG = file.type === "image/jpeg";
                const isLt2M = file.size / 1024 / 1024 < 2;

                if (!ispng && !isJPG) {
                    this.$message.error("上传头像图片只能是 JPG或PNG 格式!");
                }
                if (!isLt2M) {
                    this.$message.error("上传头像图片大小不能超过 2MB!");
                }
                return isJPG && isLt2M && isJPG;
            },
            flagOnchange(file, fileList) {
                var _this = this;
                var event = event || window.event;
                var file = event.target.files[0];
                var reader = new FileReader();
                //转base64
                reader.onload = function(e) {
                    _this.imageUrl = e.target.result; //将图片路径赋值给src
                    _this.appInfo.imageBase = e.target.result;
                };
                reader.readAsDataURL(file);
            },
            onSubmit(){
                console.log(this.appInfo.imageBase)
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

  .plus-name {
    background-color: #e8eaec;
    border: 1px #e8eaec dashed;
  }

  .plus-name::before{
    margin-bottom: 0;
    font-size: 24px;
    min-height: 31px;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 75px;
    margin-top: 5px;
    color: #87878a;
    white-space: normal;
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
