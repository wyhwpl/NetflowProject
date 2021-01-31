<template>

    <div class="safe-set">
        <div class="detail-info">
            <div class="base-info">
                <p class="base-info-title">您的基础信息</p>
                <ul class="base-info-contents">
                    <li class="base-info-content">
                        <span class="content-label content-label-username">会员名</span>
                        <span class="content-value">红林宝宝yo</span>
                    </li>
                    <li class="base-info-content">
                        <span class="content-label">登 录 邮 箱:</span>
                        <span class="content-value">1448458064@qq.com</span>
                        <a class="content-op">修改邮箱</a>
                    </li>
                    <li class="base-info-content">
                        <span class="content-label">绑 定 手 机:</span>
                        <span class="content-value">17721571395</span>
                        <a class="content-op">修改手机</a>
                    </li>
                </ul>
            </div>

            <el-divider></el-divider>
            <div class="safe-service">
                <p class="safe-service-title">您的安全服务</p>
                <div class="safe-level">
                    <span class="level-title">安全等级:</span>
                    <div class="level-progress">
                        <el-progress :percentage="percentage" :format="format"></el-progress>
                    </div>
                    <div class="level-info">
                        <i class="el-icon-lightning"></i>
                        <span>完成</span>
                        <a>密保设置</a>
                        <span> , 提升账户安全</span>
                    </div>
                </div>
                <ul class="safe-service-contents">
                    <li class="safe-service-content">
                        <div class="safe-service-state">
                            <span class="el-icon-check"></span>
                            <span>已完成</span>
                        </div>
                        <div class="safe-service-name">
                            身 份 认 证
                        </div>
                        <div class="safe-service-detail">
                            用于提升账号的安全性和信任级别。认证后的有卖家记录的账号不能修改认证信息。
                        </div>
                        <div class="safe-service-operate">
                            <a>查看</a>
                        </div>
                    </li>
                    <li class="safe-service-content">
                        <div class="safe-service-state">
                            <span class="el-icon-check"></span>
                            <span>已设置</span>
                        </div>
                        <div class="safe-service-name">
                            登 录 密 码
                        </div>
                        <div class="safe-service-detail">
                            安全性高的密码可以使账号更安全。建议您定期更换密码，且设置一个包含数字和字母，并长度超过6位以上的密码。
                        </div>
                        <div class="safe-service-operate">
                            <a>修改</a>
                        </div>
                    </li>
                    <li class="safe-service-content">
                        <div class="safe-service-state">
                            <span class="el-icon-s-opportunity"></span>
                            <span>未设置</span>
                        </div>
                        <div class="safe-service-name">
                            密 保 问 题
                        </div>
                        <div class="safe-service-detail">
                            是您找回登录密码的方式之一。建议您设置一个容易记住，且最不容易被他人获取的问题及答案，更有效保障您的密码安全。
                        </div>
                        <div class="safe-service-operate">
                            <a>设置</a>
                        </div>
                    </li>
                    <li class="safe-service-content">
                        <div class="safe-service-state">
                            <span class="el-icon-check"></span>
                            <span>已绑定</span>
                        </div>
                        <div class="safe-service-name">
                            绑 定 手 机
                        </div>
                        <div class="safe-service-detail">
                            绑定手机后，您即可享受淘宝丰富的手机服务，如手机找回密码等。
                        </div>
                        <div class="safe-service-operate">
                            <a>修改</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "safeSetting",
        data() {
            return {
                percentage: '66'
            }
        },
        methods: {
            format(percentage) {
                if(percentage<= 100/3){
                    return '弱'
                }else if(percentage <= 100/3*2){
                    return '中'
                }else{
                    return '强'
                }
            }
        }
    }
</script>

<style>

    .safe-set {
        width: 849px;
        height: 802px;
        /*background-color: #5daf34;*/
        margin-left: 0px;
        margin-top: 25px;
        border: 1px solid #c4d5e0;
    }
    .safe-set .detail-info{
        padding: 0 20px;
    }
    .base-info ul{
        list-style: none;
    }
    .base-info-title,.safe-service-title {
        padding-left: 20px;
        text-align: left;
        font-weight: bold;
        font-size: 12px;
    }
    .base-info-contents {
        margin-top: 0px;
    }
    .base-info .base-info-contents .base-info-content{
        height: 25px;
        line-height: 25px;
        text-align: left;
        font-size: 12px;
    }
    .base-info-content .content-label {
        display: inline-block;
        width: 80px;
    }
    .base-info-content a{
        display: inline-block;
        color: #3a8ee6;
        margin-left: 80px;
        cursor: pointer;
    }
    .base-info-content a:hover{
        color: red;
    }
    .safe-service a,.safe-service span{
        font-size: 12px;
    }
    .safe-service .safe-level{
        padding-left: 70px;
        text-align: left;
        margin-top: 20px;
        height: 28px;
    }
    .safe-service .safe-level .level-title{
        display: inline-block;
        float: left;
        height: 28px;
        line-height: 28px;

    }
    .safe-service .safe-level .level-progress{
        float: left;
        height: 28px;
        width: 250px;
        margin-left: 20px;
        line-height: 28px;
    }
    .safe-service .safe-level .level-info{
        float: left;
        height: 28px;
        line-height: 28px;
    }
    .safe-service .safe-level .level-info a{
        color: #3a8ee6;
        display: inline-block;
        margin-left: 5px;
        cursor: pointer;
    }

    .safe-service .safe-level .level-info span{
        display: inline-block;
        margin-left: 5px;
    }
    .safe-service .safe-level .level-info i{
        margin-right: 10px;
        font-size: 18px;
    }
    .safe-service .safe-service-contents{
        list-style: none;

    }
    .safe-service-contents .safe-service-content{
        height: 65px;
        border-bottom: 1px #c4d5e0 dashed;
    }
    .safe-service-contents .safe-service-content:nth-last-child(1){
        border: none;
    }
    .safe-service .safe-service-content span{
        font-size: 12px;
    }
    .safe-service .safe-service-content .safe-service-state{
        float: left;
        height: 65px;
        line-height: 65px;
    }
    .safe-service .safe-service-content .safe-service-state span{
        display: block;
        width: 104px;
        height: 20px;
        line-height: 20px;

    }
    .safe-service .safe-service-content .safe-service-state span:nth-child(1){
        margin-top: 10px;
    }
    .safe-service .safe-service-content .safe-service-name{
        float: left;
        width: 110px;
        font-size: 12px;
        height: 65px;
        line-height: 65px;
        text-align: left;
    }
    .safe-service .safe-service-content .safe-service-detail{
        float: left;
        font-size: 12px;
        width: 354px;
        height: 65px;
        line-height: 32.5px;
        /*word-break: break-all;*/
        text-align: left;
    }
    .safe-service .safe-service-content .safe-service-operate{
        float: left;
        height: 65px;
        width: 80px;

    }
    .safe-service .safe-service-content .safe-service-operate a{
        color: #3a8ee6;
        display: block;
        width: 80px;
        height: 65px;
        line-height: 65px;
        font-weight: bold;
    }
</style>
<style lang="scss">
    .safe-service div.el-progress__text {
        font-size: 12px!important;
        margin-left: 20px;
        color: red;
    }
    .safe-service div.el-progress {
        height: 28px;
        line-height: 28px;
    }
</style>
