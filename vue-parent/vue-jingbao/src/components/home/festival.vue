<template>
    <div style="background-color: #5d675d">
        <div class="home-banner">
            <a href="" class="jb-logo f1">
                <img src="@/assets/tmp/jb-logo.png">
            </a>

            <div class="f1 banner-list">
                <el-row style="width: 100%;" :gutter="15">
                    <el-col :span="5" >
                        <div class="banner banner-kt">
                            <div class="desc-wrapper">
                                <h4 class="title">心选年礼</h4>
                                <p class="subtitle">抢大额神券</p>
                            </div>
                        </div>
                    </el-col>
                    <el-col :span="5">
                        <div class="banner banner-blue">
                            <div class="desc-wrapper">
                                <h4 class="title">打牌女装</h4>
                                <p class="subtitle">打牌不只5折</p>
                            </div>
                            <div class="img-outer">
                                <img src=""/>
                            </div>
                        </div>
                    </el-col>
                    <el-col :span="5">
                        <div class="banner banner-green">
                            <div class="desc-wrapper">
                                <h4 class="title">厨卫焕新</h4>
                                <p class="subtitle">每满300减30</p>
                            </div>
                        </div>
                    </el-col>
                    <el-col :span="5">
                        <div class="banner banner-pink">
                            <div class="desc-wrapper">
                                <h4 class="title">灵感家居</h4>
                                <p class="subtitle">满减折上折</p>
                            </div>
                        </div>
                    </el-col>
                    <el-col :span="4">
                        <div class="banner banner-zs">
                            <div class="desc-wrapper">
                                <h4 class="title">健康自营</h4>
                                <p class="subtitle">1元抢百元券</p>
                            </div>
                        </div>
                    </el-col>
                </el-row>
            </div>

        </div>
    </div>
</template>

<script>
    export default {
        name: "festival"
    }
</script>

<style>

    .banner {
        display: inline-block;
        margin-top: 13px;
        height: 75px;
        width: 209px;
        /*position: relative;*/

    }

    .home-banner {
        margin: 0 auto;
        width: 1250px;
        height: 100px;
    }

    .jb-logo {
        height: 80px;
        width: 80px;
        padding: 10px 0px 10px 15px;
    }

    .f1 {
        float: left;
        display: inline;
    }

    .desc-wrapper {
        margin-top: -20px;
        margin-left: 18px;
    }

    .title {
        margin-top: 40px;
        height: 25px;
        line-height: 25px;
        font-size: 20px;
        color: #fff;
        width: 90px;
        overflow: hidden;
        /*background-color: blue;*/
    }

    .subtitle {
        margin-top: -30px;
        line-height: 20px;
        height: 16px;
        font-size: 14px;
        color: #fff;
        width: 90px;
        overflow: hidden;
        /*background-color: #3a8ee6;*/
    }

    .banner-list {
        margin-left: 10px;
    }
    .banner-kt {
        background-image: url("../../assets/tmp/kt.png");
    }
    .banner-blue {
        background-image: url("../../assets/tmp/banner-blue.png");
    }
    .banner-green {
        background-image: url("../../assets/tmp/banner-green.png");
    }
    .banner-pink {
        background-image: url("../../assets/tmp/banner-pink.png");
    }
    .banner-zs {
        background-image: url("../../assets/tmp/banner-zs.png");
    }


</style>

<style scoped>

</style>
