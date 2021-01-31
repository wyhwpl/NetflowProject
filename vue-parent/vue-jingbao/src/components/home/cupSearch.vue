<template>
    <div class="cup-search">
        <div class="tab">
            <el-row class="tab-list" :gutter="20">
                <el-col :class="firstName" :span="8" @click.native="handleClick(0)">
                    <span :class="firstSpan">
                        宝贝
                    </span>
                </el-col>
                <el-col :class="secondName" :span="8" @click.native="handleClick(1)">
                    <span :class="secondSpan">
                        玉兔
                    </span>
                </el-col>
                <el-col :class="thirdName" :span="8" @click.native="handleClick(2)">
                    <span :class="thirdSpan">
                        店铺
                    </span>
                </el-col>
            </el-row>
            <el-input prefix-icon="el-icon-search" placeholder="番茄丁"
                      v-model="keyword" clearable class="search-input" >
                <span v-if="isShow" class="camera" slot="suffix">
                    <i class="el-icon-camera"/>
                </span>
                <el-button @click="" slot="append">搜索</el-button>
            </el-input>
            <div class="search-hots" v-if="isShow">
                <a href="">新款连衣裙</a>
                <a href="">四件套</a>
                <a href="">潮流T恤</a>
                <a href="">时尚女鞋</a>
                <a href="">短裤</a>
                <a href="">半身裙</a>
                <a href="">男士外套</a>
                <a href="">墙纸</a>
                <a href="">行车记录仪</a>
                <a href="">新款男鞋</a>
                <a href="">耳机</a>
                <a href="">时尚女包</a>
                <a href="">沙发</a>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "cupSearch",
        data() {
            return {
                keyword: '',
                firstName: 'col-active',
                secondName: '',
                thirdName: '',
                firstSpan: 'span-active',
                secondSpan: 'col-no',
                thirdSpan: 'col-no',
                isShow: true
            }
        },
        methods: {
            handleClick(index) {
                console.log("start change")
                this.firstName = ''
                this.secondName = ''
                this.thirdName = ''
                this.firstSpan = 'col-no'
                this.secondSpan = 'col-no'
                this.thirdSpan = 'col-no'
                if(index == 0) {
                    this.firstName = 'col-active'
                    this.firstSpan = 'span-active'
                    this.isShow = true
                }
                if(index == 1) {
                    this.secondName = 'col-active'
                    this.secondSpan = 'span-active'
                    this.isShow = false
                }
                if(index == 2) {
                    this.thirdName = 'col-active'
                    this.thirdSpan = 'span-active'
                    this.isShow = false
                }
            }
        }
    }
</script>

<style>
    .cup-search{
        width: 60%;
        display: inline-block;
        float: left;
    }
    .tab{
        background-color: white;
        /*margin-top: -10px;*/
    }
    .search-hots{
        height: 30px;
    }
    .cup-search a {
        float: left;
        color: black;
        line-height: 30px;
        text-decoration: none;
        display: inline-block;
        margin-left: 10px;
        font-size: 10px;
    }

    .camera {
        display: inline-block;
        width: 100%;
        height: 100%;
        line-height: 45px;
    }
    .tab-list {
        width: 25%;
        padding-left: 4%;
        height: 30px;
    }

    .el-col{
        padding: 0px;
        /*width: 100%;*/
        height: 100%;
    }

    .el-col:hover{
        cursor: pointer;
    }

    .el-col .col-no {
        width: 100%;
        height: 100%;
        display: inline-block;
        line-height: 30px;
        color: #675765;
        font-size: 10px;
    }

    .el-col .col-no:hover {
        background-color: #b3e5fc;
    }

    .col-active {
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
        background-color: #675765;
    }

    .span-active {
        width: 100%;
        height: 100%;
        display: inline-block;
        line-height: 30px;
        font-size: 10px;
        color: white;
    }

    /*.cup-search .camera{
        font-size: 20px;
    }*/

    /*.search-input {
        border: 2px solid red;
    }*/
    /*.el-tab-pane {
        width: 100%;
        height: 100%;
    }*/
</style>

<style lang="scss">

    .cup-search input.el-input__inner{
        border-top-left-radius: 20px;
        border-bottom-left-radius: 20px;
        border-top: 2px solid #675765;
        border-left: 2px solid #675765;
        border-bottom: 2px solid #675765;
    }
    .cup-search div.el-input-group__append{
        border-top-right-radius: 20px;
        border-bottom-right-radius: 20px;
        border-top: 2px solid #675765;
        border-right: 2px solid #675765;
        border-bottom: 2px solid #675765;
        background-color: #675765;
        color: white;
    }
    .cup-search button.el-button {
        font-size: 20px;
    }

    /*.cup-search i{
        font-size: 20px;
    }*/

    .cup-search span.el-input__suffix-inner i {
        font-size: 20px;
    }

    .cup-search span.el-input__prefix i {
        font-size: 16px;
    }


</style>
