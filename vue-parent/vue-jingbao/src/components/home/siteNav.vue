<template>
    <div style="background-color: #675765">
        <div class="home-nav">
            <div class="left-tab f1">
                <span>主题市场</span>
            </div>
            <div class="right-tab f1">
                <a href="">玉兔</a>
                <a href="">聚划算</a>
                <a href="">玉兔超市</a>
                <a href="">|</a>
                <a href="">司法拍卖</a>
                <a href="">京宝心选</a>
                <a href="">|</a>
                <a href="">佩奇旅行</a>
                <a href="">智能生活</a>
                <a href="">景德易购</a>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "siteNav"
    }
</script>

<style>
    .f1 {
        float: left;
        display: inline;
    }
    .f2 {
        float: right;
        display: inline;
    }

    .right-tab a {
        font-size: 16px;
        display: inline-block;
        margin-left: 20px;
        color: white;
        float: left;
        line-height: 30px;
        text-decoration: none;
    }

    .right-tab a:hover {
        cursor: pointer;
        color: red;
    }

    /*.home-nav a {
        float: left;
    }*/

    .home-nav {
        margin: 0 auto;
        width: 1190px;
        height: 30px;
        /*background-color: #673a4a;*/
    }
    .left-tab {
        width: 190px;
        height: 100%;
        background-color: #673a4a;
    }
    .right-tab{
        height: 100%;
        background-color: #67625a;
        width: 1000px;
        /*background-color: #673a4a;*/
    }
    .left-tab span {
        color: white;
        line-height: 30px;
    }
</style>

<style scoped>

</style>
