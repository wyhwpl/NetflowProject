<template>
    <div class="app-grant">
        <div class="app-grant-title">
            <span>您已授权的应用({{grantedNum}})</span>
        </div>
        <div class="app-list-view-empty">
            您还没有已授权的应用
        </div>
    </div>
</template>

<script>
    export default {
        name: "appGrant",
        data() {
            return {
                grantedNum: 0
            }
        }
    }
</script>

<style>
    .app-grant{
        width: 848px;
        height: 740px;
        background-color: #f9fafa;
        margin-left: 0px;
        margin-top: 25px;
    }
    .app-grant .app-grant-title{
        height: 30px;
        line-height: 30px;
        text-align: left;
        padding-left: 30px;
        padding-top: 20px;
    }
    .app-grant .app-grant-title span{
        font-size: 14px;
        font-weight: 500;
    }
    .app-grant .app-list-view-empty{
        height: 200px;
        text-align: center;
        font-size: 12px;
        color: #333;
        background: url('../../assets/tmp/empty_app.png') no-repeat 50%;
        background-size: 100px;
        padding-top: 120px;
        line-height: 200px;
    }

</style>
