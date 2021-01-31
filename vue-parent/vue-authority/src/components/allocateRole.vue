<template>
  <div class="editor">
    <el-tree :data="data"
             show-checkbox
             default-expand-all
             node-key="id"
             ref="roleT"
             highlight-current
             :props="defaultProps">

    </el-tree>
  </div>
</template>

<script>
    export default {
        name: 'allocateRole',
        data() {
            return {
                data: [
                    {
                        id: '01',
                        label: '统一权限管理系统',
                        type: 'app',
                        children: [
                            {
                                id: '001',
                                label: '权限系统管理员',
                                type: 'role'
                            },
                            {
                                id: '002',
                                label: '权限系统操作员',
                                type: 'role'
                            }
                        ]
                    },
                    {
                        id: '02',
                        label: '网上订餐系统',
                        type: 'app',
                        children: [
                            {
                                id: '011',
                                label: '订餐系统管理员',
                                type: 'role'
                            },
                            {
                                id: '012',
                                label: '订餐系统操作员',
                                type: 'role'
                            }
                        ]
                    },
                    {
                        id: '03',
                        label: '流量分析系统',
                        type: 'app',
                        children: [
                            {
                                id: '021',
                                label: '流量系统管理员',
                                type: 'role'
                            },
                            {
                                id: '022',
                                label: '流量系统操作员',
                                type: 'role'
                            }
                        ]
                    }
                ],
                defaultProps: {
                    label: 'label',
                    children: 'children',
                    type: 'type'

                },
                checkedKeys: []
            }
        },
        methods: {
            dataInit(data) {
                console.log('init:' + data)
                this.data = data
            },
            getCheckedKeys(){
                this.checkedKeys = this.$refs.roleT.getCheckedKeys(true)
                console.log("allocate : " + this.checkedKeys)
                return this.checkedKeys
            },
            getCheckedNodes() {
                let nodes  = this.$refs.roleT.getCheckedNodes(true)
                /*nodes.forEach(item => {
                    let type = item.type
                    console.log("type: "+type)
                })*/
                console.log("allocate : " , nodes)
            },
            setCheckedKeys(roleId) {
                console.log("roleId : "+ roleId)
                this.$refs.roleT.setCheckedKeys(roleId);
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
