<template>
    <div style="background-color: #675765">
        <div class="home-helper">
            <el-row>
                <el-col :span="6" class="consumer">
                    <div class="helper-title">
                        <i class="el-icon-camera"/>
                        <span class="consumer-word">消费者保障</span>
                    </div>
                    <ul class="helper-contents">
                        <li><a>保障范围</a></li>
                        <li><a>退货退款流程</a></li>
                        <li><a>服务中心</a></li>
                        <li><a>更多特色服务</a></li>
                    </ul>
                </el-col>
                <el-col :span="6" class="new-user">
                    <div class="helper-title">
                        <i class="el-icon-camera"/>
                        <span class="new-user-word">新手上路</span>
                    </div>
                    <ul class="helper-contents">
                        <li><a>新手专区</a></li>
                        <li><a>消费警示</a></li>
                        <li><a>交易安全</a></li>
                        <li><a>24小时在线帮助</a></li>
                        <li><a>免费开店</a></li>
                    </ul>
                </el-col>
                <el-col :span="6" class="pay">
                    <div class="helper-title">
                        <i class="el-icon-camera"/>
                        <span class="pay-word">付款方式</span>
                    </div>
                    <ul class="helper-contents">
                        <li><a>快捷支付</a></li>
                        <li><a>信用卡</a></li>
                        <li><a>余额宝</a></li>
                        <li><a>猪猪付么</a></li>
                        <li><a>货到付款</a></li>
                    </ul>
                </el-col>
                <el-col :span="6" class="special-jb">
                    <div class="helper-title">
                        <i class="el-icon-camera"/>
                        <span class="special-word">京宝特色</span>
                    </div>
                    <ul class="helper-contents">
                        <li><a>手机京宝</a></li>
                        <li><a>哈哈/哈嘻</a></li>
                        <li><a>大众评审</a></li>
                    </ul>
                </el-col>
            </el-row>
        </div>
    </div>
</template>

<script>
    export default {
        name: "helper"
    }
</script>

<style>
    .home-helper {
        margin: 0 auto;
        width: 1190px;
        height: 180px;
        background-color: #f5f5f5;
    }
    .home-helper ul {
        list-style: none;
        position: absolute;
    }
    .home-helper li {
        display: inline-block;
        position: relative;
    }
    .home-helper .helper-title {
        width: 297.5px;
        height: 48px;
        /*background-color: blue;*/
    }
    .home-helper .helper-title i{
        display: inline-block;
        height: 48px;
        line-height: 48px;
        font-size: 34px;
        float: left;
        margin-left: 15px;
        color: darkgrey;
    }
    .home-helper .helper-title span{
        display: inline-block;
        height: 48px;
        line-height: 48px;
        font-size: 18px;
        margin-left: 10px;
        float: left;
    }
    .home-helper .helper-contents {
        width: 250px;
        margin-left: 5px;
        height: 42px;
        padding: 0 !important;
        /*background-color: #3a8ee6;*/
        margin-top: 0px;
        text-align: left;
    }
    .home-helper .helper-contents li {
        height: 21px;
        font-size: 10px;
        margin-left: 10px;
        color: darkgrey;

    }
    .home-helper .helper-contents li a {
        float: left;
        color: black;
        line-height: 30px;
        text-decoration: none;
        display: inline-block;
        margin-left: 10px;
        font-size: 10px;
    }
</style>

<style lang="scss">

    .home-helper div.el-row{
        width: 1190px;
        height: 180px;
        padding: 0px;
    }
    .home-helper div.el-col {
        margin-left: 0px;
        height: 180px;
        padding-top: 42px;
        /*background-color: blue;*/
    }

</style>
