<template>
    <div class="pay-bind">
        <div class="pay-bind-box">
            <div class="box-title">支付宝绑定设置</div>
            <div class="box-content">
                <div class="box-content-detail">
                    <div class="detail-icon"><i class="el-icon-check"></i></div>
                    <div class="details-content">
                        <div class="content-account">
                            <span>已绑定支付宝账户：</span>
                            <span>1448458064@qq.com</span>
                        </div>
                        <div class="pay-link">
                            <a>进入支付宝</a>
                            <span>|</span>
                            <a>更换支付宝</a>
                        </div>
                    </div>
                </div>
                <ul class="box-content-account">
                    <li>
                        <span class="account-label-title">账户类型</span>
                        <span class="account-label-content">个人账户</span>
                    </li>
                    <li>
                        <span class="account-label-title">实名认证</span>
                        <span class="account-label-content">汪培林|3****************7 已认证</span>
                        <a>查看</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "payBind"
    }
</script>

<style>

    .pay-bind{
        width: 848px;
        height: 802px;
        /*background-color: #5daf34;*/
        margin-left: 0px;
        margin-top: 25px;
        border: 1px solid #c4d5e0;
    }
    .pay-bind-box {
        width: 848px;
        height: 295px;
    }
    .pay-bind-box .box-title{
        height: 30px;
        padding-left: 10px;
        text-align: left;
        font-size: 12px;
        font-weight: 700;
        color: #014D7F;
        line-height: 30px;
        background-color: #F3F8FE;
    }
    .pay-bind-box .box-content{
        padding: 15px 30px;
    }

    .pay-bind-box .box-content .box-content-detail{
        border: 1px solid #E1E1CA;
        background-color: #edfed0;
        font-size: 12px;
        padding-left: 40px;
        padding-top: 15px;
        height: 57px;


    }

    .pay-bind-box .box-content .box-content-detail .detail-icon{
        float: left;
        padding: 6px;

    }

    .pay-bind-box .box-content .box-content-detail .detail-icon i{
        display: block;
        height: 32px;
        width: 32px;
        background-color: #b5de70;
        line-height: 32px;
        font-size: 24px;
        color: white;
        border-radius: 50px
    }


    .pay-bind-box .box-content .box-content-detail .details-content{
        float: left;
        height: 44px;
        margin-left: 10px;
    }
    .pay-bind-box .box-content .box-content-detail .details-content .content-account{
        height: 22px;
        line-height: 22px;
    }
    .pay-bind-box .box-content .box-content-detail .details-content .content-account span:nth-child(1){
        font-size: 14px;
        font-weight: 700;
    }
    .pay-bind-box .box-content .box-content-detail .details-content .content-account span:nth-child(2){
        font-weight: 700;
        font-size: 14px;
        color: #F60;
    }
    .pay-bind-box .box-content .box-content-detail .details-content .pay-link{
        height: 22px;
        line-height: 22px;
        text-align: left;
    }
    .pay-bind-box .box-content .box-content-detail .details-content .pay-link a{
        margin-right: 5px;
        color: #3a8ee6;
        cursor: pointer;
    }
    .pay-bind-box .box-content .box-content-detail .details-content .pay-link span{
        margin-right: 5px;
    }
    .box-content .box-content-account{
        list-style: none;
        padding: 0;
        margin: 0;
    }
    .box-content .box-content-account li{
        height: 55px;
        border-bottom: 1px #ededed solid;
        margin-left: 20px;
    }
    .box-content .box-content-account li a{
        display: block;
        float: left;
        height: 55px;
        line-height: 55px;
        font-size: 12px;
        color: #3a8ee6;
    }
    .box-content .box-content-account li span{
        display: block;
        float: left;
        height: 55px;
        line-height: 55px;

    }
    .box-content .box-content-account li .account-label-title{
        font-size: 14px;
        width: 200px;
        text-align: left;

    }
    .box-content .box-content-account li .account-label-content{
        font-size: 12px;
        color: #999;
        width: 500px;
        text-align: left;
    }
</style>
