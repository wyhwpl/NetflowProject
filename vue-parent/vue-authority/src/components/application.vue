<template>
  <div class="root">
    <div class="btn_operator">
      <el-button style="float: right" icon="el-icon-plus" @click="openAdd" size="small" type="primary" round>添加</el-button>
      <!--      <el-button style="float: right" icon="el-icon-plus" @click="openAdd" size="small" type="danger" round>添加</el-button>-->
      <el-dialog  :title='title' :visible.sync="addVisible" append-to-body>
        <app-edit v-if="addVisible" ref="editForm"></app-edit>
        <span slot="footer" class="dialog-footer">
          <el-button type="primary" @click="onSubmit">提交</el-button>
          <el-button @click="addVisible = false">取消</el-button>
        </span>
      </el-dialog>
    </div>
    <el-divider></el-divider>
    <div class="application_list">
      <el-row style="padding-left: 5%">
        <el-col :span="4" :offset="1" v-for="object in applications" style="margin-bottom: 10px" :key="object.id">
          <el-card>
            <div>
              <div>
                {{object.appName}}
              </div>
            </div>
            <div style="height: 100px" @click="entryApp(object.homeUrl)">
              <img :src="object.imageBase"  width="100%" height="100%" >
            </div>
            <div >
              <el-tooltip content="删除">
                <i class="el-icon-delete" @click="deleteApp(object.id)" size="middle"/>
              </el-tooltip>
              <el-tooltip content="编辑">
                <i class="el-icon-edit" @click="openEdit(object)"/>
              </el-tooltip>
              <el-tooltip content="详情">
                <i class="el-icon-view" @click="openSee(object)"/>
              </el-tooltip>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
  import utils from "../utils/utils";
  import appEdit from "@/components/appEdit"
    export default {
        name: "application",
        components: {
          appEdit
        },
        data() {
            return {
              addVisible: false,
              title: '',
              operator: true,
              applications: []
            }
        },
        created: function() {
            this.getAppList()
        },
        methods: {
            getAppList() {
                let that = this;
                let success = res => {
                    console.log("res :", res);
                    let tableData = res.data.data;
                    /*for (let i = 0; i < tableData.length; i++) {
                        tableData[i].createTime = that.getTime(tableData[i].createTime);
                    }*/
                    that.applications = tableData;
                }
                let failed = err => {
                    console.log("err :", err);
                }
                utils.axiosMethod({
                    method: 'Get',
                    url: `/netflow/authority/app/getAppList`,
                    data: {},
                    callback: success,
                    catch: failed
                })
            },
            deleteApp(id) {
                let that = this;
                this.$confirm("此操作将删除该应用, 是否继续?", "提示", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                })
                    .then(() => {
                        let success = res => {
                            console.log("res :", res);
                            that.getAppList();
                            that.$message("删除成功~");
                        }
                        let failed = err => {
                            console.log("err :", err);
                        }
                        utils.axiosMethod({
                            method: 'Get',
                            url: '/netflow/authority/app/delAppById?id='+id,
                            data: {},
                            callback: success,
                            catch: failed
                        })
                    })
                    .catch(() => {
                        this.$message({
                            type: "info",
                            message: "已取消删除"
                        });
                    });
            },
            openAdd() {
                this.addVisible = true
                this.title = '新增应用'
                this.operator = true
            },
            openEdit(row){
                this.addVisible = true
                this.title = '编辑应用'
                this.operator = false
                this.$nextTick(() => {
                    this.$refs.editForm.dataInit(row)
                })
            },
            entryApp(url){
              window.location = url
            },
            openSee(row){
                this.addVisible = true
                this.title = '应用详情'
                console.log(row)
                this.$nextTick(() => {
                    this.$refs.editForm.dataSee(row)
                })
            },
            onSubmit(){
                const appInfo = this.$refs.editForm.appInfo
                console.log(appInfo)
                let url = ''
                let errorMsg = ''
                if(this.operator){
                    url = '/netflow/authority/app/insertApp'
                    errorMsg = '新增应用失败'
                }else{
                    url = '/netflow/authority/user/updateApp'
                    errorMsg = '修改应用失败'
                }
                let success = (response) => {
                    if (response.status === 200) {
                        if (response.data.errorCode === '0') {
                            this.addVisible = false
                            this.getAppList()
                        } else {
                            alert(response.data.errorMsg)
                            this.addVisible = false

                        }
                    }
                }
                let failed = error => {
                    alert(errorMsg)
                    console.log(error)
                    this.addVisible = false
                }
                utils.axiosMethod({
                    method: 'POST',
                    url: url,
                    data: appInfo,
                    callback: success,
                    catch: failed
                })

            }
        }
    }
</script>

<style lang="scss" scoped>

  .root{
    padding-top: 1%;
    padding-left: 4%;
    height: 100%;

    .el-divider--horizontal{
      margin: 40px 0;
      background: 0 0;
      border-top: 1px solid #e8eaec;
    }
  }
</style>
