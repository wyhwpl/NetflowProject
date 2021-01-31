<template>
    <div class="transaction">
        <div class="transaction-box">
            <div class="transaction-box-title">
                <p class="transaction-box-title-left">个人交易信息</p>
                <p class="transaction-box-title-tip">*表示该项必填</p>
            </div>
            <div class="transaction-content">
                <el-form label-position="right" :model="tranInfo" :rules="tranRule" ref="tranForm" label-width="100px" class="transaction-content-info">

                    <el-form-item label="真实姓名:" class="info-real-name">
                        <span>{{tranInfo.realName}}</span>
                        <span>真实姓名不能修改</span>
                    </el-form-item>
                    <el-form-item label="登录邮箱地址:" class="info-email">
                        <span>{{tranInfo.email}}</span>
                    </el-form-item>

                    <el-form-item label="性别" prop="sex" required class="info-sex">
                        <el-radio-group v-model="tranInfo.sex">
                            <el-radio :label="0" >男</el-radio>
                            <el-radio :label="1">女</el-radio>
                            <el-radio :label="2">保密</el-radio>
                        </el-radio-group>
                        <span class="sex-tip">真实性别不能修改!</span>
                    </el-form-item>

                    <el-form-item label="个人所在地:" prop="currentAddress" class="info-current-address">
                        <v-distpicker class="dist-address" @province="onChangeProvinceC" @city="onChangeCityC" @area="onChangeAreaC"></v-distpicker>
                    </el-form-item>

                    <el-form-item label="详细地址:" prop="detailAddress" class="info-detail-address">
                        <el-input v-model="tranInfo.detailAddress"></el-input>
                        <span class="detail-address-tip">请填写真实有效的信息</span>
                    </el-form-item>

                    <el-form-item label="邮政编码" prop="yzCode" class="info-yzCode">
                        <el-input v-model="tranInfo.yzCode"></el-input>
                    </el-form-item>
                    <el-form-item label="手机号" prop="phone" class="info-phone">
                        <el-input v-model="tranInfo.phone"></el-input>
                    </el-form-item>
                    <el-form-item label="将手机号" prop="isCy"  class="info-isCy">
                        <el-radio-group v-model="tranInfo.isCy">
                            <el-radio :label="0" >作为交易联系方式</el-radio>
                            <el-radio :label="1">不作为交易联系方式</el-radio>
                        </el-radio-group>
                    </el-form-item>

                    <el-form-item class="info-button">
                        <el-button type="primary">确定</el-button>
                        <el-button type="primary">取消</el-button>
                    </el-form-item>

                </el-form>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "transaction",
        data(){
            return {
                sinaImgUrl: require('../../assets/tmp/default_avatar.gif'),
                tranInfo: {
                    realName: '汪培林',
                    email: '144****064@qq.com',
                    sex: '0',
                    birthday: '',
                    currentAddress: {
                        province: {
                            code: '',
                            value: ''
                        },
                        city: {
                            code: '',
                            value: ''
                        },
                        area: {
                            code: '',
                            value: ''
                        }
                    },
                    detailAddress: '',
                    yzCode: '',
                    phone: '',
                    isCy: 0
                },
                tranRule:[

                ]
            }
        },
        methods: {
            onChangeProvinceC(province){
                this.tranInfo.currentAddress.province = province
            },
            onChangeCityC(city){
                this.tranInfo.currentAddress.city = city
            },
            onChangeAreaC(area){
                this.tranInfo.currentAddress.area = area
            }
        }
    }
</script>


<style>

    .transaction{
        width: 848px;
        height: 802px;
        /*background-color: #5daf34;*/
        margin-left: 0px;
        margin-top: 25px;
        border: 1px solid #c4d5e0;
    }
    .transaction-box {
        width: 848px;
    }
    .transaction-box .transaction-box-title{
        height: 30px;
        padding-left: 10px;

        background-color: #F3F8FE;
    }
    .transaction-box .transaction-box-title .transaction-box-title-left{
        float: left;
        text-align: left;
        font-size: 15px;
        font-weight: 700;
        color: #014D7F;
        line-height: 30px;
        height: 30px;
        width: 180px;
        margin: 0px;
    }
    .transaction-box .transaction-box-title .transaction-box-title-tip{
        float: right;
        text-align: right;
        font-size: 12px;
        line-height: 30px;
        height: 30px;
        width: 180px;
        margin: 0px;
        margin-right: 10px;
    }
    .transaction-box .transaction-content{
        padding: 15px 20px;
    }

    .transaction-content .sex-tip{
        display: block;
        height: 30px;
        float: left;
        line-height: 33px;
        font-size: 12px;
        color: red;
        margin-left: 10px;

    }

    .detail-address-tip {
        display: block;
        float: left;
        font-size: 12px;
        color: #999;
        height: 30px;
        line-height: 30px;
        margin-left: 10px;
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
    .transaction-content{

        div.el-form-item{
            margin-bottom: 10px;

        }

        label.el-form-item__label{
            font-size: 12px;
            display: inline-block;
            width: 72px;
            height: 30px;
            line-height: 45px;
            /*margin-top: 7px;*/
        }
        .info-real-name label.el-form-item__label{
            font-size: 12px;
            display: inline-block;
            width: 72px;
            height: 30px;
            line-height: 30px;
            /*margin-top: 7px;*/
        }
        .info-email label.el-form-item__label{
            font-size: 12px;
            display: inline-block;
            width: 72px;
            height: 30px;
            line-height: 30px;
            /*margin-top: 7px;*/
        }
        .info-sex label.el-form-item__label{
            font-size: 12px;
            display: inline-block;
            width: 72px;
            height: 30px;
            line-height: 30px;
            /*margin-top: 7px;*/
        }
        .info-current-address label.el-form-item__label{
            font-size: 12px;
            display: inline-block;
            width: 72px;
            height: 30px;
            line-height: 30px;
            /*margin-top: 7px;*/
        }
        .info-real-name div.el-form-item__content{
            text-align: left;
            height: 30px;
        }
        .info-real-name div.el-form-item__content span{
            font-size: 12px;
            display: block;
            float: left;
            height: 30px;
            line-height: 30px;
        }
        .info-real-name div.el-form-item__content span:last-child{
            margin-left: 10px;
            color: red;
        }

        .info-email div.el-form-item__content{
            text-align: left;
            height: 30px;
        }
        .info-email div.el-form-item__content span{
            font-size: 12px;
            display: block;
            float: left;
            height: 30px;
            line-height: 30px;
        }
        .info-sex div.el-form-item__content{
            text-align: left;
            height: 30px;
        }
        .info-sex div.el-radio-group{
            height: 30px;
            float: left;

        }
        .info-sex div.el-radio-group label.el-radio{
            display: block;
            float: left;
            height: 30px;
            line-height: 30px;
        }

        .info-sex div.el-radio-group span.el-radio__label{
            font-size: 12px;
        }

        .info-current-address div.el-form-item__content{
            text-align: left;
            height: 30px;
            line-height: 30px;
        }

        .info-detail-address div.el-form-item__content{
            /*height: 30px;*/
            /*padding: 0!important;*/
        }
        .info-detail-address div.el-input{
            text-align: left;
            float: left;
            width: 195px;
            height: 30px;
            padding: 0px!important;
        }

        .info-detail-address input.el-input__inner{
            width: 195px;
            padding-left: 5px;
            font-size: 12px;
            height: 30px;
            margin-top: -1px !important;
            padding: 0 !important;
        }

        .info-yzCode div.el-form-item__content{
            /*height: 30px;*/

        }
        .info-yzCode div.el-input{
            text-align: left;
            width: 90px;
            height: 30px;
        }
        .info-yzCode input.el-input__inner{
            width: 90px;
            padding-left: 5px;
            font-size: 12px;
            height: 30px;
            margin-top: -1px !important;
        }
        .info-phone div.el-form-item__content{
            /*height: 30px;*/

        }
        .info-phone div.el-input{
            text-align: left;
            width: 110px;
            height: 30px;
        }
        .info-phone input.el-input__inner{
            width: 110px;
            padding-left: 5px;
            font-size: 12px;
            height: 30px;
            margin-top: -1px !important;
        }

        .info-isCy div.el-form-item__content{
            text-align: left;
            height: 30px;
        }
        .info-isCy div.el-radio-group{
            height: 30px;

        }
        .info-isCy div.el-radio-group label.el-radio{
            display: block;
            height: 30px;
            float: left;
            line-height: 30px;
        }

        .info-button {
            margin-top: 20px;
        }
        .info-button div.el-form-item__content{
            text-align: left;

        }
        .info-button div.el-form-item__content button.el-button{
            height: 30px;
            line-height: 0px;

        }
    }
</style>
