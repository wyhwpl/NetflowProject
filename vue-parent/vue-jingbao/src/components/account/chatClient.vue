<template>
    <div class="chat-client">
        <div class="chat-client-box-title">天宫旺旺网页版设置</div>
        <div class="chat-client-set-tips" v-if="open">
            <p>
                天宫旺旺网页版本是为那些没有安装
                <a>天宫旺旺客户端</a>
                的用户提供的交流工具。无需下载和安装，
                <br/>
                使你和卖家(朋友)可以自由沟通交流，即时收到交易的提醒~！
            </p>
        </div>
        <div class="chat-client-tool-toggle">
            <a v-if="open" class="toggle-tool" @click="open=false">收起/展开</a>
            <a v-else class="toggle-tool-open" @click="open=true">收起/展开</a>
        </div>
        <el-form label-position="right"
                 :model="chatInfo"  ref="chatForm"
                 label-width="100px" class="chat-client-info">

            <el-form-item label="登录设置:" prop="startUp" class="info-start">
                <el-radio-group v-model="chatInfo.startUp">
                    <el-radio :label="0" >登录京宝时启动</el-radio>
                    <el-radio :label="1">登录京宝时不启动</el-radio>
                </el-radio-group>
            </el-form-item>

            <p>注意：如果你安装了天宫旺旺客户端，将优先使用客户端，不启动天宫旺旺网页版</p>
            <el-form-item class="info-button">
                <el-button type="primary">确定</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "chatClient",
        data() {
            return {
                open: true,
                chatInfo: {
                    startUp: 0
                }
            }
        }
    }
</script>

<style>

    .chat-client{
        /*width: 848px;*/
        height: 802px;
        /*background-color: #5daf34;*/
        margin-left: 0px;
        margin-top: 25px;
        border: 1px solid #c4d5e0;
        padding: 10px;
    }

    .chat-client .chat-client-box-title{
        height: 30px;
        padding-left: 10px;
        text-align: left;
        font-size: 14px;
        font-weight: 700;
        color: #014d7f;
        line-height: 30px;
        background-color: #F3F8FE;
        width: 818px;
        border-radius: 3px;
    }
    .chat-client .chat-client-set-tips{
        height: 50px;
        padding: 12px 36px 15px;
        text-align: left;
        font-size: 14px;
        font-weight: 700;
        color: #014d7f;
        line-height: 30px;
        background-color: rgb(255,250,230);
        border: 1px solid rgb(255,232,179);
        width: 754px;
        border-radius: 3px;
        margin-top: 10px;
    }
    .chat-client .chat-client-set-tips p{
        margin: 0;
        font-size: 12px;
        color: #3C3C3C;
        line-height: 25px;
    }
    .chat-client .chat-client-set-tips p a{
        color: #3a8ee6;
        cursor: pointer;
    }
    .chat-client .chat-client-set-tips p a:hover{
        color: red;
    }
    .chat-client .chat-client-tool-toggle a{
        display: block;
        width: 685px;
        height: 20px;
        margin: 0 auto;
        text-indent: -999px;
        outline: 0;
        background: url('../../assets/tmp/toggle_bg.gif') no-repeat 0 -80px;
    }

    .chat-client .toggle-tool:hover{
        background: url('../../assets/tmp/toggle_bg.gif') no-repeat 0 -120px;
    }

    .chat-client .chat-client-tool-toggle .toggle-tool-open{
        background: url('../../assets/tmp/toggle_bg.gif') no-repeat 0 0;
    }
    .chat-client .chat-client-tool-toggle .toggle-tool-open:hover{
        background: url('../../assets/tmp/toggle_bg.gif') no-repeat 0 -40px;
    }


</style>

<style lang="scss">
    .chat-client {
        form.el-form{
            margin-top: 20px;
        }
        form.el-form p{
            text-align: left;
            font-size: 12px;
            color: red;
            padding-left: 20px;
        }
        label.el-form-item__label{
            font-size: 14px;
            color: #014D7F;
            font-weight: bold;
            vertical-align: middle;
        }
        .info-start div.el-form-item__content{
            text-align: left;
            padding-left: 20px;
        }

        .info-button div.el-form-item__content{
            text-align: left;
            margin-left: 20px !important;
        }
        .info-button button.el-button{
            height: 30px;
            line-height: 0px;
            display: inline-block;
        }
    }
</style>
