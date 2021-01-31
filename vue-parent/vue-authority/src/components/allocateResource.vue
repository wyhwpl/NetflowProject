<template>
  <div class="editor">
    <el-tabs v-model="activeName" type="card">
      <el-tab-pane label="菜单" name="menu">
        <el-tree :data="dataMenu"
                 show-checkbox
                 default-expand-all
                 node-key="id"
                 ref="resourceMenu"
                 highlight-current
                 :props="defaultProps"
                 :check-strictly="checkStrictly">

        </el-tree>
      </el-tab-pane>
      <el-tab-pane label="按钮" name="button">
        <el-tree :data="dataButton"
                 show-checkbox
                 default-expand-all
                 node-key="id"
                 ref="resourceButton"
                 highlight-current
                 :props="defaultProps">

        </el-tree>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
  import utils from "../utils/utils";
    export default {
        name: 'allocateResource',
        data() {
            return {
                checkStrictly: true,
                activeName: 'menu',
                dataMenu: [

                ],
                dataButton: [

                ],
                defaultProps: {
                    label: 'label',
                    children: 'children',
                    type: 'type'

                },
                checkedKeys: [],
                resourceType: 0
            }
        },
        methods: {
            dataInit(appId) {
                console.log('appId:' + appId)
                this.getResourceTree(appId,0)
                this.getResourceTree(appId,1)

            },
            getCheckedKeys(){
                this.checkedKeys = this.$refs.resourceMenu.getCheckedKeys(true)
                console.log("allocate : " + this.checkedKeys)
                return this.checkedKeys
            },
            getCheckedNodes() {
                let nodes  = this.$refs.resourceMenu.getCheckedNodes()
                /*nodes.forEach(item => {
                    let type = item.type
                    console.log("type: "+type)
                })*/
                console.log("allocate : " , nodes)
                let nodeArray = []
                nodes.forEach(item => {
                    nodeArray.push(item.id)
                })
                console.log("nodeArray:" + nodeArray)
                return nodeArray
            },
            setCheckedKeys(roleId) {
                console.log("roleId : "+ roleId)
                this.$refs.resourceMenu.setCheckedKeys(roleId);
            },
            getButtonCheckedKeys(){
                this.checkedKeys = this.$refs.resourceButton.getCheckedKeys(true)
                console.log("allocate : " + this.checkedKeys)
                return this.checkedKeys
            },
            getButtonCheckedNodes() {
                let nodes  = this.$refs.resourceButton.getCheckedNodes()
                console.log("allocate : " , nodes)
                let nodeArray = []
                nodes.forEach(item => {
                    nodeArray.push(item.id)
                })
                console.log("nodeArrayB:" + nodeArray)
                return nodeArray
            },
            setButtonCheckedKeys(roleId) {
                console.log("roleId : "+ roleId)
                this.$refs.resourceButton.setCheckedKeys(roleId);
            },
            getResourceTree(appId,resourceType){
                let success = res => {
                    console.log("res :", res);
                    let tableData = res.data.data;
                    if(resourceType === 0){
                        this.dataMenu = tableData
                    }else{
                        this.dataButton = tableData
                    }
                }
                let failed = err => {
                    console.log("err :", err);
                }
                utils.axiosMethod({
                    method: 'POST',
                    url: '/netflow/authority/resource/getResourceTree',
                    data: {
                        appId: appId,
                        resourceType: resourceType
                    },
                    callback: success,
                    catch: failed
                })
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
