<template>
    <div class="sina-bind">
        <div class="sina-bind-box">
            <div class="sina-box-title">微博绑定设置</div>
            <div class="sina-box-setting">
                <div class="sina-setting-tips">
                    <p>绑定微博帐号，可以方便地将您在淘宝中看到的内容分享给微博上的朋友们。</p>
                    <p>绑定成功，您还可以在微博上发现更多宝贝，快速购买哦！</p>
                    <p>当前状态：<span>已绑定</span></p>
                </div>
                <div class="sina-setting-info">
                    <div class="sina-info">
                        <p class="info-title">微博信息：</p>
                        <div class="sina-info-detail">
                            <a class="sina-info-avatar">
                                <img :src="sinaImgUrl"/>
                            </a>
                            <div class="sina-account">
                                <p>
                                    <span>帐号：</span>
                                    <span class="sina-account-value">177******95</span>
                                </p>
                                <p>
                                    <span>会员名：</span>
                                    <span class="sina-account-value">用户6176321354</span>
                                </p>
                                <a>解除绑定</a>
                            </div>
                        </div>
                    </div>
                    <div class="jb-info">
                        <p class="info-title">京宝信息：</p>
                        <div class="jb-info-detail">
                            <a class="jb-info-avatar">
                                <img :src="sinaImgUrl"/>
                            </a>
                            <div class="jb-account">
                                <p>
                                    <span>会员名：</span>
                                    <span class="jb-account-value">红林宝宝yo</span>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "sinaBind",
        data(){
            return {
                sinaImgUrl: require('../../assets/tmp/default_avatar.gif')
            }
        }
    }
</script>

<style>

    .sina-bind{
        width: 848px;
        height: 802px;
        /*background-color: #5daf34;*/
        margin-left: 0px;
        margin-top: 25px;
        border: 1px solid #c4d5e0;
    }
    .sina-bind-box {
        width: 848px;
        height: 295px;
    }
    .sina-bind-box .sina-box-title{
        height: 30px;
        padding-left: 10px;
        text-align: left;
        font-size: 12px;
        font-weight: 700;
        color: #014D7F;
        line-height: 30px;
        background-color: #F3F8FE;
    }
    .sina-bind-box .sina-box-setting{
        padding: 40px;
    }

    .sina-bind-box .sina-setting-tips p{
        margin: 0;
        text-align: left;
        font-size: 12px;
        color: #999;
    }
    .sina-bind-box .sina-setting-tips p:last-child{
        margin-top: 25px;
        color: #5daf34;
    }

    .sina-bind-box .sina-setting-info {
        padding-top: 50px;
    }
    .sina-bind-box .sina-setting-info .sina-info{
        float: left;
    }
    .sina-bind-box .sina-setting-info .sina-info .info-title{
        margin-top: 0px;
        margin-bottom: 15px;
        font-size: 14px;
        text-align: left;
        padding-left: 20px;
        color: #999;
    }
    .sina-bind-box .sina-setting-info .sina-info .sina-info-detail{
        height: 52px;
    }
    .sina-bind-box .sina-setting-info .sina-info .sina-info-avatar{
        display: block;
        float: left;
        width: 50px;
        height: 50px;
        border: 1px solid #b3e5fc;
    }
    .sina-bind-box .sina-setting-info .sina-info .sina-account{
        float: left;
        height: 52px;
        margin-left: 5px;
    }
    .sina-bind-box .sina-setting-info .sina-info .sina-account p{
        margin: 0px;
        text-align: left;
        height: 17px;
        font-size: 12px;
    }
    .sina-bind-box .sina-setting-info .sina-info .sina-account .sina-account-value{
        color: #5daf34;
    }
    .sina-bind-box .sina-setting-info .sina-info .sina-account a{
        display: block;
        text-align: left;
        height: 17px;
        font-size: 12px;
        color: #3a8ee6;
    }

    .sina-bind-box .sina-setting-info .jb-info {
        float: right;
    }
    .sina-bind-box .sina-setting-info .jb-info .info-title{
        margin-top: 0px;
        margin-bottom: 15px;
        font-size: 14px;
        text-align: left;
        padding-left: 20px;
        color: #999;

    }
    .sina-bind-box .sina-setting-info .jb-info .jb-info-detail{
        height: 52px;
    }
    .sina-bind-box .sina-setting-info .jb-info .jb-info-avatar{
        display: block;
        float: left;
        width: 50px;
        height: 50px;
        border: 1px solid #b3e5fc;
    }
    .sina-bind-box .sina-setting-info .jb-info .jb-account{
        float: left;
        height: 52px;
        margin-left: 5px;
    }
    .sina-bind-box .sina-setting-info .jb-info .jb-account p{
        margin: 0px;
        text-align: left;
        height: 17px;
        font-size: 12px;
    }
    .sina-bind-box .sina-setting-info .jb-info .jb-account .jb-account-value{
        color: #5daf34;
    }
</style>
