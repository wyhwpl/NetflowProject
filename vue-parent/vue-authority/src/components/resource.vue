<template>
  <el-row style="height: 100%">
    <el-col :span="4" class="border-tree">
      <div style="height: 120px">
        <p class="font-style">应用程序列表</p>
      </div>
      <div class="tree-root" >
        <el-tree :data="trees" :props="defaultProps" @node-click="handleNodeClick"/>
      </div>
    </el-col>
    <el-col :span="20">
      <div class="root">
        <div class="search">
          <el-input placeholder="请输入资源名称" v-model="keyword" clearable class="input-with-select">
            <el-button @click="goSearch()" slot="append" icon="el-icon-search"></el-button>
          </el-input>
        </div>
        <div class="btn_operator">
          <el-button style="float: right" icon="el-icon-plus" @click="openAdd" size="small" type="primary" round>添加</el-button>
          <!--      <el-button style="float: right" icon="el-icon-plus" @click="openAdd" size="small" type="danger" round>添加</el-button>-->
          <el-dialog  :title='title' :visible.sync="addVisible" append-to-body>
            <resource-edit v-if="addVisible" ref="editForm"></resource-edit>
            <span slot="footer" class="dialog-footer">
          <el-button type="primary" @click="onSubmit">提交</el-button>
          <el-button @click="addVisible = false">取消</el-button>
        </span>
          </el-dialog>
        </div>
        <el-table
          :data="tableData"
          style="width: 100%"
          :default-sort="{prop: 'createDate', order: 'descending'}"
        >
          <el-table-column prop="resourceName" label="应用资源名" show-overflow-tooltip></el-table-column>
          <el-table-column prop="resourceType" label="资源类型" show-overflow-tooltip>
            <template slot-scope="scope">
              {{scope.row.resourceType === 0 ? '菜单': '按钮'}}
            </template>
          </el-table-column>
          <el-table-column prop="routerUrl" label="路由" show-overflow-tooltip></el-table-column>
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
                <i class="el-icon-delete" @click="deleteResource(scope.row.id)" size="middle"/>
              </el-tooltip>
              <el-tooltip content="编辑">
                <i class="el-icon-edit" @click="searchById(scope.row.id)"/>
              </el-tooltip>
              <!--<el-tooltip content="应用授权">
                <i class="el-icon-paperclip" @click="goAuthorize(scope.row.id)"/>
              </el-tooltip>-->
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
      </div>
    </el-col>
  </el-row>
</template>

<script>
    import utils from '../utils/utils'
    import resourceEdit from '@/components/resourceEdit'

    export default {
        name: 'resource',
        components: {
            resourceEdit
        },
        data() {
            return {
                title: '',
                addVisible: false,
                keyword:'',
                pageSize: 10,
                total: 0, // task总数
                srcList: [],
                tableData: [],
                node: {
                    id: '0',
                    label: '全部应用'
                },
                trees: [{
                    id: '0',
                    label: '全部应用',
                    children: [

                    ]
                }],
                defaultProps: {
                    children: 'children',
                    label: 'label'
                },
                operator: true
            };
        },
        created: function() {
            this.loadTree();
            this.getResourceList();
        },
        methods: {

            handleNodeClick(data) {
                // console.log(data);
                this.node.id = data.id
                this.node.label = data.label
                console.log(this.node)
                this.getResourceList()
            },
            openAdd() {
                if(this.node.id === '0'){
                    this.$message("添加应用资源之前请选择应用")
                    return 0
                }
                this.addVisible = true
                this.title = '新增资源'
                this.operator = true
            },
            loadTree() {
                let that = this;
                let success = res => {
                    console.log("res :", res);
                    let tableData = res.data.data;
                    that.trees[0].children = tableData;
                }
                let failed = err => {
                    console.log("err :", err);
                }
                utils.axiosMethod({
                    method: 'Get',
                    url: `/netflow/authority/app/getAppTree`,
                    data: {},
                    callback: success,
                    catch: failed
                })
            },
            getResourceList(page = 1, limit = 10) {
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
                    url: `/netflow/authority/resource/getResourceList?page=${page}&limit=${limit}&appId=${this.node.id}`,
                    data: {},
                    callback: success,
                    catch: failed
                })
            },
            deleteResource(id) {
                let that = this;
                this.$confirm("此操作将删除该资源以及所有子级资源, 是否继续?", "提示", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                })
                    .then(() => {
                        let success = res => {
                            console.log("res :", res);
                            that.getResourceList();
                            that.$message("删除成功~");
                        }
                        let failed = err => {
                            console.log("err :", err);
                        }
                        utils.axiosMethod({
                            method: 'Get',
                            url: '/netflow/authority/resource/delResourceById?id='+id,
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
                    const resourceData = res.data.data;
                    console.log("data :", resourceData);
                    this.title = '编辑资源'
                    this.addVisible = true
                    this.operator = false
                    this.$nextTick(() => {
                        this.$refs.editForm.dataInit(resourceData)
                    })

                }
                let failed = err => {
                    console.log("err :", err);
                }
                utils.axiosMethod({
                    method: 'Get',
                    url: '/netflow/authority/resource/getResourceById?id='+id,
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
                    this.getRoleList(page)
                }else{
                    this.goSearch(page)
                }
            },
            goSearch(pageNumber = 1, limit = 10) {
                let that = this;
                if (that.keyword.length < 1) {
                    that.getResourceList();
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
                    url: '/netflow/authority/resource/getResourceByKey',
                    data: {
                        rows: pageNumber,
                        limit: limit,
                        keyword: this.keyword,
                        appId: this.node.id
                    },
                    callback: success,
                    catch: failed
                })
            },
            goAuthorize() {

            },
            onSubmit() {
                let resourceF = this.$refs.editForm.resourceInfo
                let url = ''
                let errorMsg = ''
                console.log(resourceF)
                if(this.operator){
                    url = '/netflow/authority/resource/insertResource'
                    errorMsg = '新增角色失败'
                    resourceF.appId = this.node.id
                }else{
                    url = '/netflow/authority/resource/updateResource'
                    errorMsg = '修改角色失败'
                }
                let success = (response) => {
                    if (response.status === 200) {
                        if (response.data.errorCode === '0') {
                            this.addVisible = false
                            this.getResourceList()
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
                    data: resourceF,
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

  .font-style{
    margin-bottom: 0;
    font-size: 24px;
    min-height: 31px;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 124px;
    margin-top: 5px;
    color: #87878a;
    white-space: normal;
  }
</style>
<style lang="scss" scoped>

  .border-tree {
    border-right: 1px #e8eaec solid;
    height: 100%;
  }
</style>
