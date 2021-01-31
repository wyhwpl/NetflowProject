<template>
    <div class="person-info">
        <ul class="person-info-title">
            <li><a>个人资料</a></li>

        </ul>
        <ul class="person-info-tabs">
            <li :class="{active: baseInfo == 1}" @click="baseInfo=1"><a>基本资料</a></li>
            <li :class="{active: baseInfo == 2}" @click="baseInfo=2"><a>头像照片</a></li>
        </ul>
        <div v-if="baseInfo === 1" class="person-info-content base-content">
            <div class="base-content-title">
                <span>亲爱的</span>
                <span class="title-username">红林宝宝yo</span>
                <span>，填写真实的资料，有助于好友找到你哦</span>
            </div>
            <el-form label-position="left" :model="infoPerson" :rules="personRule" ref="personForm" label-width="100px" class="base-content-info">
                <el-form-item label="当前头像:" prop="name" class="info-avatar">
                    <span class="info-avatar-content" @mouseenter="avatarOp = true" @mouseleave="avatarOp = false">
                        <a class="avatar-content">
                            <img :src="infoPerson.imgUrl">
                        </a>
                        <a v-if="avatarOp" class="avatar-operate">编辑头像</a>
                    </span>
                </el-form-item>

                <el-form-item label="昵称" required class="info-nick-name">
                    <el-input v-model="infoPerson.nickName"></el-input>
                </el-form-item>
                <el-form-item label="真实姓名" class="info-real-name">
                    <el-input v-model="infoPerson.realName"></el-input>
                </el-form-item>

                <el-form-item label="性别" prop="sex" required="" class="info-sex">
                    <el-radio-group v-model="infoPerson.sex">
                        <el-radio :label="0" >男</el-radio>
                        <el-radio :label="1">女</el-radio>
                    </el-radio-group>
                </el-form-item>

                <el-form-item label="居住地址:" prop="currentAddress" class="info-current-address">
                    <v-distpicker class="dist-address" @province="onChangeProvinceC" @city="onChangeCityC" @area="onChangeAreaC"></v-distpicker>
                </el-form-item>

                <el-form-item label="家乡:" prop="fromAddress" class="info-from-address">
                    <v-distpicker class="dist-address" @province="onChangeProvinceF" @city="onChangeCityF" @area="onChangeAreaF"></v-distpicker>
                </el-form-item>

                <el-divider></el-divider>

                <el-form-item class="info-button">
                    <el-button type="primary">保存</el-button>
                </el-form-item>

            </el-form>

        </div>
        <div v-else class="person-info-content">
            <div class="error-pane">暂不支持此功能</div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "personInfo",
        data(){
            return {
                baseInfo: 1,
                avatarOp: false,
                infoPerson: {
                    imgUrl: require('../../assets/tmp/avatar.jpg'),
                    nickName: '32号SayGoodbye',
                    realName: '汪培林',
                    sex: 0,
                    currentAddress: {
                        province:{
                            code: '',
                            value: ''
                        },
                        city:{
                            code: '',
                            value: ''
                        },
                        area:{
                            code: '',
                            value: ''
                        }
                    },
                    fromAddress: {
                        province:{
                            code: '',
                            value: ''
                        },
                        city:{
                            code: '',
                            value: ''
                        },
                        area:{
                            code: '',
                            value: ''
                        }
                    }
                },
                personRule: {
                    nickName: [
                        { required: true,message: '请输入昵称', trigger: 'blur'}
                    ],
                    sex: [
                        { required: true, message: '请选择性别' ,trigger: 'change'}
                    ]
                }
            }
        },
        methods: {
            onChangeProvinceC(province){
                this.infoPerson.currentAddress.province = province
            },
            onChangeCityC(city){
                this.infoPerson.currentAddress.city = city
            },
            onChangeAreaC(area){
                this.infoPerson.currentAddress.area = area
            },
            onChangeProvinceF(province){
                this.infoPerson.fromAddress.province = province
            },
            onChangeCityF(city){
                this.infoPerson.fromAddress.city = city
            },
            onChangeAreaF(area){
                this.infoPerson.fromAddress.area = area
            }
        }
    }
</script>

<style>

    .person-info {
        width: 849px;
        height: 802px;
        /*background-color: #5daf34;*/
        margin-left: 0px;
        margin-top: 25px;
        /*border: 1px solid #c4d5e0;*/
    }
    .person-info ul{
        list-style: none;
    }
    .person-info .person-info-title{
        padding: 0px;
        height: 25px;
        margin: 0;
        position: relative;
        z-index: 100;
    }
    .person-info .person-info-title li{
        height: 25px;
        text-align: left;
        width: 74px;
        margin-left: 10px;
        border-top: 1px #c4d5e0 solid;
        border-left: 1px #c4d5e0 solid;
        border-right: 1px #c4d5e0 solid;
        position: relative;
        z-index: 102;
        background-color: #fff;

    }
    .person-info .person-info-title li a{
        font-size: 12px;
        font-weight: 700;
        display: block;
        width: 74px;
        height: 24px;
        line-height: 23px;
        text-align: center;
    }
    .person-info .person-info-tabs {
        height: 36px;
        margin: 0;
        padding: 0 0 0 10px;
        border-top: 1px #c4d5e0 solid;
        border-left: 1px #c4d5e0 solid;
        border-right: 1px #c4d5e0 solid;
        z-index: 1;
        position: relative;
    }
    .person-info .person-info-tabs li{
        float: left;
        height: 25px;
        margin-top: 5px;
        width: 68px;
        padding-left: 1px;
        padding-right: 1px;
    }
    .person-info .person-info-tabs li:hover{
        cursor: pointer;
    }
    .person-info .person-info-tabs .active{
        font-weight: 700;
        width: 72px;
    }
    .person-info .person-info-tabs li a{
        font-size: 12px;
        display: block;
        height: 25px;
        line-height: 25px;
    }
    .person-info .person-info-tabs li:hover{
        border: 1px solid #c4d5e0;
    }
    .person-info-content {
        height: 500px;
        border: 1px solid #c4d5e0;
    }
    .person-info-content .base-content-title{
        margin-top: 30px;
        padding-left: 50px;
        text-align: left;
        margin-bottom: 20px;
    }
    .person-info-content .base-content-title span{
        font-size: 15px;
    }
    .person-info-content .base-content-title .title-username{
        margin-left: 5px;
        font-weight: bold;
    }
    .person-info-content .base-content-info {
        padding-left: 50px;
        padding-right: 50px;
    }
    .person-info-content .info-avatar .info-avatar-content{
        display: block;
        width: 80px;
        height: 80px;
        border: 3px solid #e6e6e6;
    }
    .person-info-content .info-avatar .info-avatar-content .avatar-content{
        width: 80px;
        height: 80px;
        display: block;
    }
    .person-info-content .info-avatar .info-avatar-content .avatar-operate{
        background: #000 10px 6px;
        position: relative;
        bottom: 21px;
        left: 0;
        width: 100%;
        height: 21px;
        line-height: 21px;
        text-align: center;
        color: #e1d7ca;
        opacity: .7;
        display: block;
        z-index: 102;
        font-size: 12px;
    }
    .person-info-content .info-avatar .info-avatar-content .avatar-operate:hover{
        cursor: pointer;
    }
    .person-info-content .error-pane {
        margin-top: 30px;
        margin-left: 20px;
        width: 770px;
        height: 450px;
        line-height: 450px;
        background-color: #c4d5e0;
    }

</style>
<style scoped>
    .dist-address >>> select{
        height: 30px;
        padding: 0px 0px 0px 5px;
        font-size: 12px;
    }
</style>

<style lang="scss">

    .base-content {

        div.el-form-item{
            margin-bottom: 10px;

        }

        label.el-form-item__label {
            font-size: 12px;
            display: inline-block;
            width: 72px;
            height: 26px;
            line-height: 26px;
            margin-top: 7px;
        }
        input.el-input__inner{
            height: 30px;
        }

        .info-avatar div.el-form-item__content{
            text-align: left;
        }

        .info-nick-name div.el-input{
            text-align: left;
        }
        .info-nick-name input.el-input__inner{
            width: 332px;
            padding-left: 5px;
            font-size: 12px;
        }
        .info-real-name div.el-input{
            text-align: left;
        }

        .info-real-name input.el-input__inner{
            width: 148px;
            padding-left: 5px;
            font-size: 12px;
        }
        .info-sex div.el-form-item__content{
            text-align: left;
            font-size: 12px;
        }
        .info-current-address div.el-form-item__content{
            text-align: left;
        }
        .info-from-address div.el-form-item__content{
            text-align: left;
        }


        .info-button div.el-form-item__content{
            text-align: left;
        }
        .info-button div.el-form-item__content button.el-button{
            height: 30px;
            line-height: 30px;
            display: block;
            padding: 0px;
            margin: 0px;
            width: 55px;
        }
        .info-button div.el-form-item__content button.el-button span{
            display: inline-block;
            height: 30px;
            line-height: 30px;
        }
    }

</style>
