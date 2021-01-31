<template>
  <div class="root">
    <div class="search">
      <el-input placeholder="请输入用户名称" v-model="keyword" clearable class="input-with-select">
        <el-button @click="goSearch()" slot="append" icon="el-icon-search"></el-button>
      </el-input>
    </div>
    <div class="btn_operator">
      <el-button style="float: right" icon="el-icon-plus" @click="openAdd" size="small" type="primary" round>添加</el-button>
<!--      <el-button style="float: right" icon="el-icon-plus" @click="openAdd" size="small" type="danger" round>添加</el-button>-->
      <el-dialog  :title='title' :visible.sync="addVisible" append-to-body>
        <edit v-if="addVisible" ref="editForm"></edit>
        <span slot="footer" class="dialog-footer">
          <el-button type="primary" @click="onSubmit">提交</el-button>
          <el-button @click="addVisible = false">取消</el-button>
        </span>
      </el-dialog>
      <el-dialog  :title='roleTitle' :visible.sync="allocateVisible" append-to-body>
        <allocate-role v-if="allocateVisible" ref="allocateForm"></allocate-role>
        <span slot="footer" class="dialog-footer">
          <el-button type="primary" @click="onSubmitAllocate">提交</el-button>
          <el-button @click="allocateVisible = false">取消</el-button>
        </span>
      </el-dialog>
    </div>
    <el-table
      :data="tableData"
      style="width: 100%"
      :default-sort="{prop: 'createDate', order: 'descending'}"
    >
      <el-table-column prop="username" label="用户名" show-overflow-tooltip></el-table-column>
      <el-table-column prop="name" label="姓名" show-overflow-tooltip></el-table-column>
      <el-table-column prop="createPerson" label="创建者" show-overflow-tooltip></el-table-column>
      <el-table-column label="创建日期" prop="createTime" sortable>
        <!-- <template slot-scope="scope">{{ scope.row.createDate }}</template> -->
      </el-table-column>
      <!--<el-table-column prop="img_url" label="logo预览">
        <div slot-scope="scope" class="my-pic">
          <el-image
            @click="imgClick(scope.row.imgUrl)"
            fit="scale-down"
            style="width: 120px; height: 120px"
            :src="scope.row.imgUrl"
            :preview-src-list="srcList"
          ></el-image>
        </div>
      </el-table-column>-->
      <el-table-column label="操作">
        <div slot-scope="scope">
          <el-tooltip content="删除">
            <i class="el-icon-delete" @click="deleteUser(scope.row.id)" size="middle"/>
          </el-tooltip>
          <el-tooltip content="编辑">
            <i class="el-icon-edit" @click="searchById(scope.row.id)"/>
          </el-tooltip>
          <el-tooltip content="分配角色">
            <i class="el-icon-paperclip" @click="allocate(scope.row.id)"/>
          </el-tooltip>

          <!--<el-button @click="deleteUser(scope.row.id)" size="small" type="danger" round>删除</el-button>
          <el-button
            @click="searchById(scope.row.id)"
            size="small"
            type="primary"
            round
          >编辑</el-button>-->
        </div>
      </el-table-column>
    </el-table>
    <el-pagination
      class="pagination"
      background
      layout="prev, pager, next"
      :total="total"
      :page-size="pageSize"
      @current-change="pageChange"
      @prev-click="pageChange"
      @next-click="pageChange"
    ></el-pagination>
    <!--<el-upload class="upload template" :headers="headers" action="http://219.228.76.43:8886/admin/upload" :on-success="uploadSuccess">
      <el-button size="small" type="primary">上传logo</el-button>
      <div slot="tip" class="el-upload__tip">.png格式 尺寸200*200以内</div>
    </el-upload>-->
  </div>
</template>

<script>
    import utils from '../utils/utils'
    import edit from '@/components/edit'
    import allocateRole from '@/components/allocateRole'
    export default {
        name: 'user',
        components: {
            edit,
            allocateRole
        },
        data() {
            return {
                title: '',
                roleTitle: '分配角色',
                allocateVisible: false,
                addVisible: false,
                keyword:'',
                pageSize: 10,
                total: 0, // task总数
                srcList: [],
                tableData: [],
                headers:{
                    token:localStorage.getItem('token')
                },
                roleTree: [],
                selectedUser: '',
                operator: true
            };
        },
        created: function() {
            this.getUserList()
            this.getRoleTree()
        },
        methods: {

            openAdd() {
                this.addVisible = true
                this.title = '新增用户'
                this.operator = true
            },
            getRoleTree(){
                let that = this;
                let success = res => {
                    const treeData = res.data.data;
                    console.log("tree-data :", treeData);
                    this.roleTree = treeData
                }
                let failed = err => {
                    console.log("err :", err);
                }
                utils.axiosMethod({
                    method: 'Get',
                    url: '/netflow/authority/role/getRoleTree',
                    data: {},
                    callback: success,
                    catch: failed
                })
            },
            getUserList(page = 1, limit = 10) {
                let that = this;
                let success = res => {
                    console.log("res :", res);
                    that.total = res.data.data.total;
                    let tableData = res.data.data.data;
                    for (let i = 0; i < tableData.length; i++) {
                        tableData[i].createTime = that.getTime(tableData[i].createTime);
                    }
                    that.tableData = tableData;
                }
                let failed = err => {
                    console.log("err :", err);
                }
                utils.axiosMethod({
                    method: 'Get',
                    url: `/netflow/authority/user/getUserList?page=${page}&limit=${limit}`,
                    data: {},
                    callback: success,
                    catch: failed
                })
            },
            allocate(id) {
                this.allocateVisible = true
                this.selectedUser = id
                this.$nextTick(() => {
                    this.$refs.allocateForm.dataInit(this.roleTree)
                    // this.$refs.allocateForm.setCheckedKeys(['0','1'])
                })

                let that = this;
                let success = res => {
                    const userData = res.data.data;
                    console.log("data :", userData);
                    that.$refs.allocateForm.setCheckedKeys(userData)

                }
                let failed = err => {
                    console.log("err :", err);
                }
                utils.axiosMethod({
                    method: 'Get',
                    url: '/netflow/authority/role/getRoleIdByUser?userId='+id,
                    data: {},
                    callback: success,
                    catch: failed
                })
            },
            deleteUser(id) {
                let that = this;
                this.$confirm("此操作将删除该用户, 是否继续?", "提示", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                })
                    .then(() => {
                        let success = res => {
                            console.log("res :", res);
                            that.getUserList();
                            that.$message("删除成功~");
                        }
                        let failed = err => {
                            console.log("err :", err);
                        }
                        utils.axiosMethod({
                            method: 'Get',
                            url: '/netflow/authority/user/delUserById?id='+id,
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
            searchById(id) {
                let that = this;
                let success = res => {
                    const userData = res.data.data;
                    console.log("data :", userData);
                    this.addVisible = true
                    this.operator = false
                    this.$nextTick(() => {
                        console.log( 'birth:'+userData.birthday)
                        userData.birthday = this.formatTime(userData.birthday)
                        this.$refs.editForm.dataInit(userData)
                    })

                }
                let failed = err => {
                    console.log("err :", err);
                }
                utils.axiosMethod({
                    method: 'Get',
                    url: '/netflow/authority/user/getUserById?id='+id,
                    data: {},
                    callback: success,
                    catch: failed
                })
            },
            formatTime(d){
                const date = new Date(d)
                let Y = date.getFullYear() + "-";
                let M =
                    (date.getMonth() + 1 < 10
                        ? "0" + (date.getMonth() + 1)
                        : date.getMonth() + 1) + "-";
                let D = this.change(date.getDate())
                let result =  Y + M + D
                console.log(result)
                return result
            },
            getTime(timestamp) {
                /*let that = this;
                timestamp = parseInt(timestamp);
                var date = new Date(timestamp); //时间戳为10位需*1000，时间戳为13位的话不需乘1000
                let Y = date.getFullYear() + "-";
                let M =
                    (date.getMonth() + 1 < 10
                        ? "0" + (date.getMonth() + 1)
                        : date.getMonth() + 1) + "-";
                let D = that.change(date.getDate()) + " ";
                let h = that.change(date.getHours()) + ":";
                let m = that.change(date.getMinutes()) + ":";
                let s = that.change(date.getSeconds());
                return Y + M + D + h + m + s;*/
                return timestamp
            },
            change(t) {
                if (t < 10) {
                    return "0" + t;
                } else {
                    return t;
                }
            },
            pageChange(page) {
                console.log("page :", page);
                if(this.keyword.length < 1){
                    this.getUserList(page)
                }else{
                    this.goSearch(page)
                }
            },
            goSearch(pageNumber = 1, limit = 10) {
                let that = this;
                if (that.keyword.length < 1) {
                    that.getUserList();
                    return 0;
                }
                let success = res => {
                    console.log("res :", res);
                    that.total = res.data.data.total;
                    let tableData = res.data.data.data;
                    for (let i = 0; i < tableData.length; i++) {
                        tableData[i].createTime = that.getTime(tableData[i].createTime);
                    }
                    that.tableData = tableData;
                }
                let failed = err => {
                    console.log("err :", err);
                }
                console.log(pageNumber)
                utils.axiosMethod({
                    method: 'POST',
                    url: '/netflow/authority/user/getUserByKey',
                    data: {
                        rows: pageNumber,
                        limit: limit,
                        keyword: this.keyword
                    },
                    callback: success,
                    catch: failed
                })
            },
            onSubmit() {
                let userF = this.$refs.editForm.userInfo
                let url = ''
                let errorMsg = ''
                console.log(userF)
                if(this.operator){
                    url = '/netflow/authority/user/insertUser'
                    errorMsg = '新增用户失败'
                }else{
                    url = '/netflow/authority/user/updateUser'
                    errorMsg = '修改用户失败'
                }
                let success = (response) => {
                    if (response.status === 200) {
                        if (response.data.errorCode === '0') {
                            this.addVisible = false
                            this.getUserList()
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
                    data: userF,
                    callback: success,
                    catch: failed
                })
            },
            onSubmitAllocate() {
                let checkedKeys = this.$refs.allocateForm.getCheckedKeys()
                console.log("checked : : "+checkedKeys)

                let success = (response) => {
                    if (response.status === 200) {
                        if (response.data.errorCode === '0') {
                            this.allocateVisible = false
                            this.getUserList()
                        } else {
                            alert(response.data.errorMsg)
                            this.allocateVisible = false

                        }
                    }
                }
                let failed = error => {
                    alert("分配角色失败")
                    console.log(error)
                    this.allocateVisible = false
                }
                utils.axiosMethod({
                    method: 'POST',
                    url: '/netflow/authority/role/allocateRole',
                    data: {
                        userId: this.selectedUser,
                        roleIds: checkedKeys
                    },
                    callback: success,
                    catch: failed
                })
            }
        }
    };
</script>

<style lang="scss">

  .my-pic {
    width: 48px;
    height: 27px;
  }
  .pagination {
    margin-top: 20px;
    margin-right: 50px;
    float: right;
  }
  .search {
    width: 50%;
    float: left;
    /* margin-left: 50%; */
  }
  .btn_operator{
    width: 40%;
    float: right;
    padding-right: 10%;
    .el-button{
      margin-right: 10px;
    }
    .el-dialog{
      width: 700px;
      height: 600px;
      margin: 0 auto;
    }
  }
  .root{
    padding-top: 1%;
    padding-left: 4%;
  }
</style>
<style lang="scss" scoped>

</style>
