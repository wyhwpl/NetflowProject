<template>
  <div class="editor">
    <el-form ref="form"
             :model="resourceInfo"
             :rules="resourceRules"
             class="role-form"
             auto-complete="on"
              label-width="100px">
      <el-row>
        <el-col :span="12">
          <el-form-item label="应用资源名" prop="resourceName">
            <el-input class="inputE" v-model="resourceInfo.resourceName" placeholder="请输入应用资源名" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="应用资源类型" prop="resourceType">
            <el-radio-group v-model="resourceInfo.resourceType">
              <el-radio :label="menuType" :key="menuType" :disabled="!isAdd">菜单</el-radio>
              <el-radio :label="buttonType" :key="buttonType" :disabled="!isAdd">按钮</el-radio>
            </el-radio-group>
          </el-form-item>
        </el-col>
        <el-col :span="12" v-if="resourceInfo.resourceType == 0">
          <el-form-item label="父资源" prop="pid">
<!--            <el-input class="inputE" v-model="resourceInfo.pid" placeholder="请输入父资源" />-->
            <tree-select v-if="isAdd" :options="parents" placeholder="请选择父资源" v-model="resourceInfo.pid" @open="getResourceTree"></tree-select>
            <el-input v-else class="inputE" v-model="pName" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" v-if="resourceInfo.resourceType == 0">
          <el-form-item label="序列号" prop="seqId">
            <el-input class="inputE" v-model="resourceInfo.seqId" placeholder="请输入序列号" />
          </el-form-item>
        </el-col>
        <el-col :span="12" v-if="resourceInfo.resourceType == 0">
          <el-form-item label="路由" prop="routerUrl">
            <el-input class="inputE" v-model="resourceInfo.routerUrl" placeholder="请输入路由" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="图标" prop="iconClass">
            <el-input class="inputE" v-model="resourceInfo.iconClass" placeholder="请输入图标选择器" />
          </el-form-item>
        </el-col>
        <!--<el-col :span="12">
          <el-form-item label="选择的值" prop="selectValue">
            <el-input class="inputE" v-model="resourceInfo.pid"  />
          </el-form-item>
        </el-col>-->
      </el-row>
    </el-form>
  </div>
</template>

<script>
  import utils from "../utils/utils";
  import TreeSelect from '@riophae/vue-treeselect'
  import '@riophae/vue-treeselect/dist/vue-treeselect.css'
    export default {
        name: 'resourceEdit',
        components: {
          TreeSelect
        },
        data() {
            const validateResourceName = (rule, value, callback) => {
                if (value.length < 3) {
                    callback(new Error('Please enter the conrrect resource name'))
                } else {
                    callback()
                }
            }
            return {
                pName: '',
                isAdd: true,
                otherVisible: true,
                roleInfo: {
                    id: '',
                    roleName: '',
                    appId: ''
                },
                menuType: 0,
                buttonType: 1,
                resourceInfo: {
                    id: '',
                    resourceName: '',
                    resourceType: 0 ,
                    appId: '',
                    pid: '0',
                    seqId: 0,
                    routerUrl: '',
                    iconClass: ''
                },
                parents: [
                    /*{
                        id: '01',
                        label: '用户管理',
                        children: [
                            {
                                id: '011',
                                label: '用户管理',
                            },
                            {
                                id: '012',
                                label: '角色管理'
                            }
                        ]
                    },
                    {
                        id: '02',
                        label: '应用管理',
                        children: [
                            {
                                id: '021',
                                label: '应用管理'
                            },
                            {
                                id: '022',
                                label: '应用资源'
                            }
                        ]
                    }*/
                ],
                resourceRules: {
                    resourceName: [
                        { required: true, trigger: 'blur', validator: validateResourceName }
                    ]
                }
            }
        },
        methods: {
            openMenu(){
                console.log("open menu")
            },
            dataInit(data, appId) {
                console.log('init:' + data)
                this.resourceInfo = data
                if(appId != null){
                    this.resourceInfo.appId = appId
                    this.isAdd = true
                }else{
                    this.getResourceName(this.resourceInfo.pid)
                    this.isAdd = false

                }
                this.otherVisible = this.resourceInfo.resourceType == 0
            },
            getResourceTree(){
                let success = res => {
                    console.log("res :", res);
                    let tableData = res.data.data;
                    let object = {
                        id: '0',
                        label: '顶级父类',
                        children: []
                    }
                    object.children = tableData;
                    this.parents.push(object)
                }
                let failed = err => {
                    console.log("err :", err);
                }
                utils.axiosMethod({
                    method: 'POST',
                    url: '/netflow/authority/resource/getResourceTree',
                    data: {
                        appId: this.resourceInfo.appId,
                        resourceType: this.resourceInfo.resourceType
                    },
                    callback: success,
                    catch: failed
                })
            },
            getResourceName(id){
                if(id === '0'){
                    this.pName = '顶级分类'
                    return
                }
                let success = res => {
                    console.log("res :", res);
                    let tableData = res.data.data;
                    this.pName = tableData.resourceName
                }
                let failed = err => {
                    console.log("err :", err);
                }
                utils.axiosMethod({
                    method: 'GET',
                    url: '/netflow/authority/resource/getResourceById?id='+id,
                    data: {},
                    callback: success,
                    catch: failed
                })
            },
            getAppName(id){

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

  .editor{
    .el-col {
      height: 62px;
    }
    .inputE >>> input {
      color: black;
    }
  }

</style>
