<template>
    <div class="receive-address">
        <div class="receive-address-box">
            <div class="receive-box-title">
                收货地址
            </div>
            <span class="add-address-op">新增收货地址</span>
            <div class="address-form">
                <p>
                    <span>当前配送至</span>
                    <span>中国大陆</span>
                </p>
                <el-form label-position="right"
                         :model="addressInfo" :rules="addressRule" ref="addressForm"
                         label-width="100px" class="receive-content-info">

                    <el-form-item label="地址信息:" class="info-address" required>
                        <!--<el-input v-model="addressInfo.areaInfo"
                                  placeholder="请选择省份/城市/地区/街道"></el-input>-->
                        <el-cascader
                                :popper-class="cascaderStyle"
                                v-model="value"
                                :options="options"
                                @change="handleChange"></el-cascader>
                    </el-form-item>
                    <el-form-item label="详细地址:" class="info-detail-address" required>
                        <el-input type="textarea" v-model="addressInfo.detailInfo"
                                  placeholder="请输入详细地址信息，如道路、门牌号、小区、楼栋号、单元等信息"></el-input>
                    </el-form-item>
                    <el-form-item label="邮政编码" prop="yzCode" class="info-yzCode">
                        <el-input v-model="addressInfo.yzCode"
                                  placeholder="请填写邮编"></el-input>
                    </el-form-item>

                    <el-form-item label="收货人姓名" prop="person" required class="info-receive-person">
                        <el-input v-model="addressInfo.receivePerson"
                                  placeholder="长度不超过25个字符"></el-input>
                    </el-form-item>

                    <el-form-item label="手机号" prop="phone" class="info-phone" required>
                        <el-input v-model="addressInfo.phone"
                                  placeholder="电话号码、手机号必须填一项"></el-input>
                    </el-form-item>
                    <el-form-item class="info-default">
                        <el-checkbox v-model="addressInfo.isDefault">设置为默认收货地址</el-checkbox>
                    </el-form-item>

                    <el-form-item class="info-button">
                        <el-button type="primary">保存</el-button>
                    </el-form-item>

                </el-form>
            </div>
            <div class="address-introduction">
                <i class="el-icon-info"></i>
                <span>已经保存了5条地址，还能保存15条地址</span>
            </div>
            <el-table :header-cell-style="{background:'#ebecf0'}"
                    :data="addressData"
                    border
                    style="margin-top:20px;width: 100%;height: 330px">
                <el-table-column
                        prop="receivePerson"
                        label="收货人"
                        width="70">
                </el-table-column>
                <el-table-column
                        prop="areaInfo"
                        label="所在地区"
                        width="140">
                </el-table-column>
                <el-table-column
                        prop="detailInfo"
                        label="详细地址"
                        width="200px">
                </el-table-column>
                <el-table-column
                        prop="yzCode"
                        label="邮编"
                        width="70px">
                </el-table-column>
                <el-table-column
                        prop="phone"
                        label="电话/手机">
                </el-table-column>
                <el-table-column
                        prop="operate"
                        label="操作">
                    <span class="operate-span-1">修改</span>
                    <span class="operate-span-2">|</span>
                    <span class="operate-span-3">删除</span>
                </el-table-column>
                <el-table-column
                        prop="detailInfo"
                        label="">
                    <span class="set-default">设为默认</span>
                </el-table-column>
            </el-table>
        </div>
    </div>
</template>

<script>
    import utils from "../../utils/utils";
    import areas from '../../utils/area'
    export default {
        name: "receiveAddress",
        data() {
            return{
                cascaderStyle: 'cascader-panel',
                addressInfo: {
                    areaInfo: '',
                    detailInfo: '',
                    yzCode: '',
                    receivePerson: '',
                    phone: '',
                    isDefault: false
                },
                addressRule: {},
                addressData: [
                    {
                        id: '0',
                        receivePerson: '汪培林',
                        areaInfo: '江西省 景德镇市 浮梁县 浮梁镇',
                        detailInfo: '033乡道世纪花园6栋一单元701',
                        yzCode: '000000',
                        phone: '17721571395',
                        isDefault: false
                    },
                    {
                        id: '1',
                        receivePerson: '汪培林',
                        areaInfo: '江西省 景德镇市 浮梁县 浮梁镇',
                        detailInfo: '033乡道世纪花园6栋一单元701',
                        yzCode: '000000',
                        phone: '17721571395',
                        isDefault: false
                    },
                    {
                        id: '2',
                        receivePerson: '汪培林',
                        areaInfo: '江西省 景德镇市 浮梁县 浮梁镇',
                        detailInfo: '033乡道世纪花园6栋一单元701',
                        yzCode: '000000',
                        phone: '17721571395',
                        isDefault: false
                    },
                    {
                        id: '3',
                        receivePerson: '汪培林',
                        areaInfo: '江西省 景德镇市 浮梁县 浮梁镇',
                        detailInfo: '033乡道世纪花园6栋一单元701',
                        yzCode: '000000',
                        phone: '17721571395',
                        isDefault: false
                    },
                    {
                        id: '4',
                        receivePerson: '汪培林',
                        areaInfo: '江西省 景德镇市 浮梁县 浮梁镇',
                        detailInfo: '033乡道世纪花园6栋一单元701',
                        yzCode: '000000',
                        phone: '17721571395',
                        isDefault: false
                    }
                ],
                value: [],
                options: [
                    {
                    value: '北京',
                    label: '北京',
                    children: [{
                        value: '北京市',
                        label: '北京市',
                        children: [{
                            value: '东城区',
                            label: '东城区',
                            children: [
                                {
                                    value: '',
                                    label: '暂不选择'
                                },
                                {
                                    value: '东华门街道',
                                    label: '东华门街道'
                                },
                                {
                                    value: '景山街道',
                                    label: '景山街道'
                                },
                                {
                                    value: '交道口街道',
                                    label: '交道口街道'
                                },
                                {
                                    value: '安定门街道',
                                    label: '安定门街道'
                                },
                                {
                                    value: '北新桥街道',
                                    label: '北新桥街道'
                                },
                                {
                                    value: '东四街道',
                                    label: '东四街道'
                                },
                                {
                                    value: '朝阳门街道',
                                    label: '朝阳门街道'
                                },
                                {
                                    value: '建国门街道',
                                    label: '建国门街道'
                                },
                                {
                                    value: '东直门街道',
                                    label: '东直门街道'
                                },
                                {
                                    value: '和平里街道',
                                    label: '和平里街道'
                                },
                                {
                                    value: '前门街道',
                                    label: '前门街道'
                                },
                                {
                                    value: '崇文门外街道',
                                    label: '崇文门外街道'
                                },
                                {
                                    value: '东花市街道',
                                    label: '东花市街道'
                                },
                                {
                                    value: '龙潭街道',
                                    label: '龙潭街道'
                                },
                                {
                                    value: '体育馆路街道',
                                    label: '体育馆路街道'
                                },
                                {
                                    value: '天坛街道',
                                    label: '天坛街道'
                                },
                                {
                                    value: '永安门外街道',
                                    label: '永安门外街道'
                                }
                            ]
                        }]
                    }]
                    }
                ]
            }
        },
        created() {
            let success = (response) => {
                if (response.status === 200) {
                    if (response.data.errorCode === '0') {
                        this.options = response.data.data
                    } else {
                        alert('获取地址失败')
                    }
                }
            }
            let failed = error => {
                alert('获取地址失败')
                this.loading = false
                console.log(error)
            }

            this.options = areas.area

        },
        methods: {
            handleChange(value){
                console.log(value)
            }
        }
    }
</script>

<style>
    .receive-address{
        width: 848px;
        /*background-color: #5daf34;*/
        margin-left: 0px;
        margin-top: 25px;
    }
    .receive-address-box {
        width: 848px;
    }
    .receive-address-box .receive-box-title{
        height: 30px;
        padding-left: 10px;
        text-align: left;
        font-size: 14px;
        font-weight: 700;
        color: #014D7F;
        line-height: 30px;
        background-color: #F3F8FE;
    }
    .receive-address-box .add-address-op{
        margin-top: 30px;
        margin-bottom: 30px;
        display: block;
        text-align: left;
        height: 30px;
        font-size: 12px;
        color: #675765;
    }

    .receive-address-box .address-form{
        width: 450px;
    }
    .receive-address-box .address-form p{
        height: 30px;
        margin-left: 10px;
        text-align: left;
        background-color: #f2f2f2;
        font-size: 12px;
    }
    .receive-address-box .address-form p span:nth-child(1){
        display: inline-block;
        height: 30px;
        line-height: 30px;
        color: #9b9b9b;
        margin-left: 20px;
    }
    .receive-address-box .address-form p span:last-child{
        display: inline-block;
        height: 30px;
        line-height: 30px;
        margin-left: 20px;
    }

    .receive-address-box .address-introduction{
        height: 42px;
        border-radius: 3px;
        background-color: #e3f2fd;
        padding-left: 10px;
        text-align: left;
    }
    .receive-address-box .address-introduction i{
        font-size: 20px;
        display: block;
        float: left;
        height: 42px;
        line-height: 42px;
    }
    .receive-address-box .address-introduction span{
        font-size: 12px;
        display: block;
        height: 42px;
        float: left;
        line-height: 42px;
        margin-left: 5px;
    }
    .receive-address-box .operate-span-1:hover{
        color: red;
        cursor: pointer;
    }
    .receive-address-box .operate-span-3:hover{
        color: red;
        cursor: pointer;
    }
    .receive-address-box .set-default:hover{
        color: red;
        cursor: pointer;
    }



</style>
<style lang="scss">
    .receive-address{

        div.el-form-item{
            margin-bottom: 10px;
        }

        div.info-address{
            margin-bottom: 20px;
        }

        label.el-form-item__label {
            font-size: 12px;
            display: inline-block;
            width: 72px;
            height: 30px;
            line-height: 45px;
        }
        .info-address div.el-input{
            height: 30px;
            padding: 0 !important;

        }
        .info-address input.el-input__inner{
            height: 30px;
            width: 332px;
            font-size: 12px;
            padding-left: 10px;
            margin-left: -20px;
        }
        .info-address div.el-cascader i.is-reverse{
            line-height: 30px;
        }

        .info-detail-address div.el-textarea{
            height: 48px;
            padding: 0 !important;

        }
        .info-detail-address textarea.el-textarea__inner{
            height: 48px;
            width: 332px;
            font-size: 12px;
            padding-left: 10px;
        }

        .info-yzCode div.el-input{
            height: 30px;
            padding: 0 !important;

        }
        .info-yzCode input.el-input__inner{
            height: 30px;
            width: 332px;
            font-size: 12px;
            padding-left: 10px;
            margin-left: -20px;
        }

        .info-receive-person div.el-input{
            height: 30px;
            padding: 0 !important;

        }
        .info-receive-person input.el-input__inner{
            height: 30px;
            width: 332px;
            font-size: 12px;
            padding-left: 10px;
            margin-left: -20px;
        }

        .info-phone div.el-input{
            height: 30px;
            padding: 0 !important;

        }
        .info-phone input.el-input__inner{
            height: 30px;
            width: 332px;
            font-size: 12px;
            padding-left: 10px;
            margin-left: -20px;
        }
        .info-default div.el-form-item__content{
            text-align: left;
        }
        .info-button div.el-form-item__content{
            text-align: left;

        }
        .info-button button.el-button{
            height: 30px;
            display: inline-block;
            line-height: 0px;
        }
        div.el-table{
            font-size: 12px;
        }
        div.el-table div.cell{
            text-align: center;
        }
        div.el-table div.cell .operate-span-1{
            display: inline-block;
            margin-right: 5px;
        }
        div.el-table div.cell .operate-span-2{
            display: inline-block;
        }
        div.el-table div.cell .operate-span-3{
            display: inline-block;
            margin-left: 5px;
        }
        div.el-table__header-wrapper table.el-table__header{
            background-color: #ebecf0 !important;
        }
    }

    .cascader-panel{
        top: 315px !important;
        span.el-cascader-node__label {
            font-size: 12px;
        }


    }
</style>
