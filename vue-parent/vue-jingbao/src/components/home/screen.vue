<template>
    <div style="background-color: #675765">
        <el-container class="home-screen">
            <el-aside style="width: 190px">
                <el-menu  class="el-menu-vertical-demo">
                    <el-menu-item v-for="topicSM in topicMarket" :key="topicSM.id">
                        <el-breadcrumb separator="/">
                            <el-breadcrumb-item  v-for="topicInfo in topicSM.topicSmall" :key="topicInfo.id">
                                {{topicInfo.topicTitle}}
                            </el-breadcrumb-item>
                        </el-breadcrumb>
                        <span class="icon-arrow">
                            <i class="el-icon-arrow-right"/>
                        </span>
                    </el-menu-item>
                </el-menu>
            </el-aside>
            <el-main>
                <div class="main-block f1">
                    <div class="col-left f1">
                        <div class="play-top">
                            <el-carousel :interval="5000" arrow="hover">
                                <el-carousel-item v-for="image in imagesTop" :key="image.index">
                                    <img class="top-img" :src="image.img"/>
                                </el-carousel-item>
                            </el-carousel>
                        </div>
                        <div class="play-bm">
                            <div class="play-bm-title">
                                <span class="title-logo" style="background-image: url('data:image/png;base64,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');"></span>
                                <span style="color: #675765;font-size: 10px;display: inline-block;width: 84px;height: 14px;float: left;line-height: 14px;margin-left: 5px;margin-top: 4px;">理想生活上玉兔</span>
                            </div>
                            <el-carousel :interval="5000" arrow="hover" indicator-position="none">
                                <el-carousel-item>
                                    <div class="ele-one">
                                        <a href="" class="ele-left-1">
                                            <img src="../../assets/tmp/mysn.jpg"/>
                                        </a>
                                        <a href="" class="ele-right-1">
                                            <img src="../../assets/tmp/lyl.jpg"/>
                                        </a>
                                    </div>
                                </el-carousel-item>
                                <!--<el-carousel-item>
                                    <div class="ele-one">
                                        <a href="" class="ele-left-2">
                                            <img src="../../assets/tmp/mysn.jpg"/>
                                        </a>
                                        <a href="" class="ele-right-2">
                                            <img src="../../assets/tmp/lyl.jpg"/>
                                        </a>
                                    </div>
                                </el-carousel-item>-->
                                <el-carousel-item>
                                    <div class="ele-one">
                                        <a href="" class="ele-left-3">
                                            <img src="../../assets/tmp/kqqxsy.jpg"/>
                                        </a>
                                        <a href="" class="ele-right-3">
                                            <img src="../../assets/tmp/xpbk.jpg"/>
                                        </a>
                                    </div>
                                </el-carousel-item>
                                <el-carousel-item>
                                    <div class="ele-one">
                                        <a href="" class="ele-left-4">
                                            <img src="../../assets/tmp/bx.jpg"/>
                                        </a>
                                        <a href="" class="ele-right-4">
                                            <img src="../../assets/tmp/xfhb.jpg"/>
                                        </a>
                                    </div>
                                </el-carousel-item>
                                <el-carousel-item>
                                    <div class="ele-one">
                                        <a href="" class="ele-left-5">
                                            <img src="../../assets/tmp/ym.jpg"/>
                                        </a>
                                        <a href="" class="ele-right-5">
                                            <img src="../../assets/tmp/zrt.jpg"/>
                                        </a>
                                    </div>
                                </el-carousel-item>
                                <el-carousel-item>
                                    <div class="ele-one">
                                        <a href="" class="ele-left-6">
                                            <img src="../../assets/tmp/yg.jpg"/>
                                        </a>
                                        <a href="" class="ele-right-6">
                                            <img src="../../assets/tmp/sn.jpg"/>
                                        </a>
                                    </div>
                                </el-carousel-item>
                            </el-carousel>
                        </div>
                    </div>
                    <div class="col-sub f1">
                        <div class="festival-top">
                            <a class="festival-top-a" href="">
                                <img src="../../assets/tmp/jfjs.jpg"/>
                            </a>
                        </div>
                        <div class="festival-bm">
                            <div style="width: 160px;height: 30px;line-height: 30px;text-align: left;font-size:10px">今日热卖</div>
                            <div class="festival-bm-img">
                                <a class="festival-bm-img-a">
                                    <img src="../../assets/tmp/jl.jpg"/>
                                </a>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="col-right f2">
                    <div class="login-detail">
                        <div class="member-login">
                            <div class="member-avatar">
                                <el-avatar  :src="avatarUrl"></el-avatar>
                            </div>
                            <span class="member-info">Hi!
                                <span v-if="!logined">你好</span>
                                <span v-else>{{userInfo.nickName}}</span>
                            </span>
                            <p class="member-tjb">
                                <a class="tjb-left">
                                    <span>淘金币抵钱</span>
                                </a>
                                <a class="tjb-right">
                                    <span>会员俱乐部</span>
                                </a>
                            </p>
                        </div>
                        <div class="member-btn">
                            <div v-if="!logined" class="member-btn-logout">
                                <a class="login-btn" @click="linkTo('/login')">登录</a>
                                <a class="reg-btn" href="">注册</a>
                                <a class="kd-btn" href="">开店</a>
                            </div>
                            <div v-else class="member-btn-order">
                                <a>
                                    <span>{{userInfo.orderInfo.toReceive}}</span>
                                    待收货
                                </a>
                                <a>
                                    <span>{{userInfo.orderInfo.toSend}}</span>
                                    待发货
                                </a>
                                <a>
                                    <span>{{userInfo.orderInfo.toPay}}</span>
                                    待付款
                                </a>
                                <a>
                                    <span>{{userInfo.orderInfo.toComment}}</span>
                                    待评价
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="business">
                        <a class="business-a">
                            <img src="../../assets/tmp/sy.jpg"/>
                        </a>
                    </div>
                    <div class="site-about">
                        <ul class="site-label-list">
                            <li class="site-label">
                                <a href="">公告</a>
                            </li>
                            <li class="site-label">
                                <a href="">规则</a>
                            </li>
                            <li class="site-label">
                                <a href="">论坛</a>
                            </li>
                            <li class="site-label">
                                <a href="">安全</a>
                            </li>
                            <li class="site-label">
                                <a href="">公益</a>
                            </li>
                        </ul>
                        <div class="site-content">
                            <a href="">
                                新增《京宝网汽配行业》
                            </a>
                        </div>
                    </div>
                    <div class="service-detail">
                        <el-row>
                            <el-col :span="6">
                                <a href="">
                                    <span class="el-icon-camera"></span>
                                    <p>照相</p>
                                </a>
                            </el-col>
                            <el-col :span="6">
                                <a href="">
                                    <span class="el-icon-s-promotion"></span>
                                    <p>地图</p>
                                </a>
                            </el-col>
                            <el-col :span="6">
                                <a href="">
                                    <span class="el-icon-s-cooperation"></span>
                                    <p>办公</p>
                                </a>
                            </el-col>
                            <el-col :span="6">
                                <a href="">
                                    <span class="el-icon-phone"></span>
                                    <p>电话</p>
                                </a>
                            </el-col>
                            <el-col :span="6">
                                <a href="">
                                    <span class="el-icon-trophy"></span>
                                    <p>运动</p>
                                </a>
                            </el-col>
                            <el-col :span="6">
                                <a href="">
                                    <span class="el-icon-chat-square"></span>
                                    <p>聊天</p>
                                </a>
                            </el-col>
                            <el-col :span="6">
                                <a href="">
                                    <span class="el-icon-shopping-cart-2"></span>
                                    <p>购物</p>
                                </a>
                            </el-col>
                            <el-col :span="6">
                                <a href="">
                                    <span class="el-icon-suitcase"></span>
                                    <p>急救</p>
                                </a>
                            </el-col>
                        </el-row>
                    </div>
                    <div class="al-more">
                        <div class="more-title">
                            <span class="title-left f1">
                                天宫APP
                            </span>
                            <a href="" class="title-right f2">更多<span class="el-icon-arrow-right"></span></a>
                        </div>
                        <ul class="more-apps">
                            <li class="more-app">
                                <a>
                                    <img src="data:image/webp;base64,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"/>
                                </a>
                            </li>
                            <li class="more-app">
                                <a>
                                    <img src="data:image/webp;base64,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"/>
                                </a>
                            </li>
                            <li class="more-app">
                                <a>
                                    <img src="data:image/webp;base64,UklGRgAEAABXRUJQVlA4WAoAAAAQAAAAOwAAOwAAQUxQSHwAAAABT6AmAJA2yoZrtiCCaYyIACzbn+8CTmvbjqq3UgMLnS7QODpgIXH4+fu5gAyn2+By/RcR/U8r/Z6p+o2N3f5N9eKsrAid+YTwcDNS+0QaAtKUkB4Z6cdfXUb6JaRHQJqeSMOM1PqE8HC2InRW/Jvqxdnd75mq39hYAQAAVlA4IF4DAACwEwCdASo8ADwAPok0l0elIqIhMBgO+KARCWwAyB3A2X4bfO/xa/GPrq9sHzTwNuv1AflX/gdMd+gHuA/aD1Afxz+y/tF7yPoW/xnpGdQB6AHSl/u96U7wAcIKpmpY+TN7h+qqM4ubmG0ibBoLmlceXOfIo1GB/JWlEudV+hsr7TReEdtF0wwDPiYyc+UbAImXs8SWeQZwifHtnxT/I9qz9KyhuRpgAP78Dxd8z1Vb9U2kwkidDgtf7DFdtwP4K0aa3/+e9SHl/j0Sg/7fSBX/9kENOfG2BdkMHdb9gsAzQuvoY/QPaf82UlHGNsmN+D5d6ek42ZH9CPwLH2rz7+rC8ZV9CgNcfWUipMaFt6E3ibUUc9EEs2+IvRDf+Jh9fgpQIvw+4KU26J84baTcd1Sxff6CXuuZ3jrGAL7kG4we1j9pNJd1HTUzuon8cCeH24QYKsFiHQMceVDAcM2ncC2PKGFAnmRyrP7gz9VbqLO1U4tR2Nrseb97L8ZlZbMI6/rtCYycK7HzliXWoFKZtQ0Q1lf04Z8xwfkgVJhRD7amTUS3k39GoKRZK7HseimRPn6IdciQ4Mayeb7NV7divHxrqBIeWuYoSx5Jl2JB7Legtf6lnz66P9prafB+Egk+CkPgMf/9mQEqrf12NYigDLeLumA606lzar3axkXDx3yVW0GUJMoIeHmKiDF9VUBXFAWDolXLOA4YFN6Ha5XyYYXejO2M5t4DRXVmt5jd14dLKgyuJny4sSriJxnWN12nBissK9y0f8yD0bRMy60iACxIen9YeRUw0RhKYoJQLc5EsyKhcnFus2LItQTQxL5laAHB1MCbyIe68FRH26JPslw3zvytP42IxDUn0HG9rr79c6YCACTppy/6zbVaOvHcN3NKeu46PX9I3n0kiYr8xK/Uh1m/WWvDB9zr15i3jMz3Sndcug57tORpKnFudPUMaBsl1fFqdu4CYxP2u9mQZqyderFI3v6inLvqbM+50mRzreYHnttgLcf/JY3d73OtUTLoPabMPDtk9n71p2Ne+dtPaiSQFQ3+Jd97McsJKIx4zpruD08IggE2KNnK+nU3yIRlu/i3TUVedAAnfpZoK/KeDelXSxzVB+LTqsT4XZaeUvjl4U6yqNXKw7VsWSAA"/>
                                </a>
                            </li>
                            <li class="more-app">
                                <a>
                                    <img src="data:image/webp;base64,UklGRqQDAABXRUJQVlA4WAoAAAAQAAAAOwAAOwAAQUxQSPUAAAANP8IwkiQlNO5O/qm+kUNEZOU3y2ej0cijtFv12k/4Wv0epElqtM2pFma1BFeSbZvOfn6xbdu6cZ7nP6MY9/ynIvqfeCiRfCkd0sHHOK4m872FF18z7oKfHkoXAtv+BQ8p0bbBWYxVUl3m4JZoeeAv52o9hqu/7YFCSNa7Z6Vhg0bIpgaRBKjkKsu7IIsGy6ATiykQpsIgDGsg1PBXxdRAZx7CoDusU6Bbj4siqNzpPBgF1e60Z1UZNPZItQaprAAKb7HC9dytJwXw9zZD3FmvnpXB214MJdwd1slUoiJ4urvREi+XPgsWMiENfMzjcnZS8QAAAABWUDggiAIAALAOAJ0BKjwAPAA+kTqZSKWjIqEqFm3IsBIJbAC/cex4AdjF0ntn4jfkB05XAOIDwz0AbZrzAebX6AN4U3j7+9sEDSBTQPH0+IFspyuO/2ZK4XPUzO6+339kMZIaBJUS5UgmlcUTBuV6UwzSj/w5LCaKd+mbcGZNd6VLdCt7IAD+/HZeMGsdWiNDdKJN0b/BtAHTNRITSE631R03AH/XQiwkylEIoEP+rn1doZJLPLeH+GHgh84VRfZxbdZiDAVr01Vd7nMtYUbu+7H3mcDMZkPvQ0+rqaYJ84/Z7XSGrYuxscTlhehX5Bz9Z+z+HrwzHmbgmdYw4KvURAh0nwfqTArl2/xEqQ/tdybFE8YLmMJpM81z4paFU9q5BiTFPNNhFhQ89joA4E9417j3KJv7R/CBw26TCBwwV9vKno5mW83nd8fT1jtulm2h116lSCXj89/ydD8/jRdaeH//eLA3waFSgUhwLz1bCzzwdYWMY4nwO5NoWREdQen5KIYOuexulT2mHgFKWGOnM9O/0nkWg2beGv8wW3T0hYIMh58y0gj8wI3bo1IdpgvBdzOCFrLxzS+TUjrOm890AOo8i7sZVOt7xQk3iEenBp0PbHWKn57OmALerOwD3Am5pn2L9K2KZH6qlD2/2voadVV7gr1Kq4FFSomulzZAVdp+VqtgLqB2HYbdcSoiCVSCI8J6Niequyk0mXyquvW96CyFOvdW4Cj0WEO32+0Ym73apRFsN9/I/F19f8hHpAdTBejxwoPXzKPav/1l1Ct0UXYgpQ0/gbohhREZb3/ak0EPpRKpTPIAjJNt0otORYk06G72M4eJ5/HGOJgXQexc98ZI40Q+iABnip/BlAAAAA=="/>
                                </a>
                            </li>
                            <li class="more-app">
                                <a>
                                    <img src="data:image/webp;base64,UklGRv4DAABXRUJQVlA4WAoAAAAQAAAAOwAAOwAAQUxQSOMAAAAN78GgbSRHN+3uvj9/tLssIiIHXCrDoN586CUiCBEdWgeEZns/R1BG8Zs/Wg8BV5Ikm1Zd89m2be9/W9aZ/xcR/U+evXQ84uuouGzXy/Ged04tiTLdj8Sjk96Ol3gXxVYp2x7zlCugPugsh9zjBSSM9nLM1ekiY/QbW2pIueWGnUGssMoiZyTiCKYiCIY+gq7Ov42LjuDWR+6wjiC3WcaRm42jFlKnyX5eQGqk0coHyBwHXHf1voHEucJ9OmsbqD9XeRouOwGqjxVexu1C0UTlaTTgza65jKVCFzWHzWKs8QQAAABWUDgg9AIAALAPAJ0BKjwAPAA+kTyZSSWjIiEoGA1QsBIJbADDbXj+q9R9gXrX5FfkBkB3Owxe2O8wH61/rd2OPQA/p/UAegp0oX7q+kA8AFdHLAqbf7H6DX6Onx24/uQrxlObsxjHGyn/nuF0mqenUC+qX43Bu9N15YzOYPZSwG+VHZVTC+nSmfwqNbeAAP7+kZhYZqlOXrxsY6fefb9yr199+Au8wKyYEwSOjgJpsuV3g389/fprYJBafOre0/tED0Qqb+lG9xlvmUTCgdzoq7h76y5xwH173AjWTmdij9jDg4k8MLa9v6xV/R+F9TlUrKyyQYexeTnxk28/HwUZH/+gfqVmgt0a0IYqsvzCQwYOHO1dqYMl8lqJ7JW078ewu/HbWp3vfTyolWdJ0TO2DA52PF0bf9OzjMvf/g37kt5xOcS+rN7ux8YY2lenykPTfuKW2ynCUh4S6DaEhEFPXu2D/z4PxhI7Vn/hLrVAa9Wlzh6Gb8ez2u8w0IG2LtTRU0FC4lhOuX2pioKBqzePKMRVmMdtdYVJRHCT3HPdPcWTDxKeYLxRuNtJz6AZsnElv3MN9D59rN/EW2rer4wnYLr8ugvbo/KMY7uCpG7QOKtI5w5+j5ZmzQRTALW2Cr3nN62g7GHB+ZkcdduInfCD3EstY5LgZ3OK0u+W4qFC0f+FXsVzlowJpLvzxZcqVBI9kaLM3FaMxcZKEmvkpItWrPYgn56Z9WrG9fyIQMnVWiNl4vCH9zrFPfDUIAt8+CwaCRpzKwJniUfplNQzQ/9bsHiunfzs20S8v1DFaiTbk72tu6IWLNLz3FdJfnLL5QMR69mtEqBsElXx6mktrVlox/D+2k4auLl7B/o0fx/1TSKpkahtv+mnPBqAj9tmiaWKjt1Ugqd96EutsGQ1+s5OPUbwgQf37GWMIsuawp+HLP/QICol+FGH4oOnm50wLne1jeqRP7aweBTGK02yq6NI8cY3G4XJIK2CPvUaY7U9TBi32Wva1zyL/v3AAA=="/>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </el-main>
        </el-container>
    </div>
</template>

<script>
    export default {
        name: "screen",
        data() {
            return {
                logined: false,
                imagesTop: [
                    {
                        img: require('../../assets/tmp/pl.jpg'),
                        index: 0
                    },
                    {
                        img: require('../../assets/tmp/kqqx.jpg'),
                        index: 1
                    },
                    {
                        img: require('../../assets/tmp/gjp.jpg'),
                        index: 2
                    },
                    {
                        img: require('../../assets/tmp/czth.jpg'),
                        index: 3
                    },
                    {
                        img: require('../../assets/tmp/dssj.jpg'),
                        index: 4
                    }
                ],
                imagesBm: [
                    {
                        img: require('../../assets/tmp/pl.jpg'),
                        index: 0
                    },
                    {
                        img: require('../../assets/tmp/kqqx.jpg'),
                        index: 1
                    },
                    {
                        img: require('../../assets/tmp/gjp.jpg'),
                        index: 2
                    },
                    {
                        img: require('../../assets/tmp/czth.jpg'),
                        index: 3
                    },
                    {
                        img: require('../../assets/tmp/dssj.jpg'),
                        index: 4
                    }
                ],
                avatarUrl: require('../../assets/tmp/avatar_50x50.jpg'),
                userInfo: {
                    username: 'wangpeilin',
                    nickName: '红林宝宝yo',
                    orderInfo: {
                        orderCount: 0,
                        toReceive: 0,
                        toSend: 0,
                        toPay: 0,
                        toComment: 3
                    }
                },
                topicMarket: [
                    {
                        id: '0',
                        topicSmall: [
                            {
                                id: '01',
                                topicUrl: '',
                                topicTitle: '女装'
                            },
                            {
                                id: '02',
                                topicUrl: '',
                                topicTitle: '内衣'
                            },
                            {
                                id: '03',
                                topicUrl: '',
                                topicTitle: '家居'
                            }
                        ]
                    },
                    {
                        id: '1',
                        topicSmall: [
                            {
                                id: '11',
                                topicUrl: '',
                                topicTitle: '女鞋'
                            },
                            {
                                id: '12',
                                topicUrl: '',
                                topicTitle: '男鞋'
                            },
                            {
                                id: '13',
                                topicUrl: '',
                                topicTitle: '箱包'
                            }
                        ]
                    }
                    ,
                    {
                        id: '2',
                        topicSmall: [
                            {
                                id: '21',
                                topicUrl: '',
                                topicTitle: '母婴'
                            },
                            {
                                id: '22',
                                topicUrl: '',
                                topicTitle: '童装'
                            },
                            {
                                id: '23',
                                topicUrl: '',
                                topicTitle: '玩具'
                            }
                        ]
                    },
                    {
                        id: '3',
                        topicSmall: [
                            {
                                id: '31',
                                topicUrl: '',
                                topicTitle: '男装'
                            },
                            {
                                id: '32',
                                topicUrl: '',
                                topicTitle: '运动户外'
                            }
                        ]
                    },
                    {
                        id: '4',
                        topicSmall: [
                            {
                                id: '41',
                                topicUrl: '',
                                topicTitle: '个护'
                            },
                            {
                                id: '42',
                                topicUrl: '',
                                topicTitle: '彩妆'
                            },
                            {
                                id: '43',
                                topicUrl: '',
                                topicTitle: '美妆'
                            }
                        ]
                    },
                    {
                        id: '5',
                        topicSmall: [
                            {
                                id: '51',
                                topicUrl: '',
                                topicTitle: '手机'
                            },
                            {
                                id: '52',
                                topicUrl: '',
                                topicTitle: '数码'
                            },
                            {
                                id: '53',
                                topicUrl: '',
                                topicTitle: '企业'
                            }
                        ]
                    },
                    {
                        id: '6',
                        topicSmall: [
                            {
                                id: '61',
                                topicUrl: '',
                                topicTitle: '大家电'
                            },
                            {
                                id: '62',
                                topicUrl: '',
                                topicTitle: '生活电器'
                            }
                        ]
                    },
                    {
                        id: '7',
                        topicSmall: [
                            {
                                id: '71',
                                topicUrl: '',
                                topicTitle: '零食'
                            },
                            {
                                id: '72',
                                topicUrl: '',
                                topicTitle: '生鲜'
                            },
                            {
                                id: '73',
                                topicUrl: '',
                                topicTitle: '茶酒'
                            }
                        ]
                    },
                    {
                        id: '8',
                        topicSmall: [
                            {
                                id: '81',
                                topicUrl: '',
                                topicTitle: '厨具'
                            },
                            {
                                id: '82',
                                topicUrl: '',
                                topicTitle: '收纳'
                            },
                            {
                                id: '83',
                                topicUrl: '',
                                topicTitle: '清洁'
                            }
                        ]
                    },
                    {
                        id: '9',
                        topicSmall: [
                            {
                                id: '91',
                                topicUrl: '',
                                topicTitle: '家纺'
                            },
                            {
                                id: '92',
                                topicUrl: '',
                                topicTitle: '家饰'
                            },
                            {
                                id: '93',
                                topicUrl: '',
                                topicTitle: '鲜花'
                            }
                        ]
                    },
                    {
                        id: '10',
                        topicSmall: [
                            {
                                id: '101',
                                topicUrl: '',
                                topicTitle: '图书音像'
                            },
                            {
                                id: '102',
                                topicUrl: '',
                                topicTitle: '文具'
                            }
                        ]
                    },
                    {
                        id: '11',
                        topicSmall: [
                            {
                                id: '111',
                                topicUrl: '',
                                topicTitle: '医药保健'
                            },
                            {
                                id: '112',
                                topicUrl: '',
                                topicTitle: '进口'
                            }
                        ]
                    },
                    {
                        id: '12',
                        topicSmall: [
                            {
                                id: '121',
                                topicUrl: '',
                                topicTitle: '汽车'
                            },
                            {
                                id: '122',
                                topicUrl: '',
                                topicTitle: '二手车'
                            },
                            {
                                id: '123',
                                topicUrl: '',
                                topicTitle: '用品'
                            }
                        ]
                    },
                    {
                        id: '13',
                        topicSmall: [
                            {
                                id: '131',
                                topicUrl: '',
                                topicTitle: '房产'
                            },
                            {
                                id: '132',
                                topicUrl: '',
                                topicTitle: '装修家具'
                            },
                            {
                                id: '133',
                                topicUrl: '',
                                topicTitle: '建材'
                            }
                        ]
                    },
                    {
                        id: '14',
                        topicSmall: [
                            {
                                id: '141',
                                topicUrl: '',
                                topicTitle: '手表'
                            },
                            {
                                id: '142',
                                topicUrl: '',
                                topicTitle: '眼镜'
                            },
                            {
                                id: '143',
                                topicUrl: '',
                                topicTitle: '珠宝饰品'
                            }
                        ]
                    }
                ]
            }
        },
        created() {
            let token = localStorage.getItem('Authorization')
            this.logined = (!(token === null || token === ''))
        },
        methods: {
            linkTo(path) {
                this.$router.push(path)
            }
        }
    }
</script>
<style>

    f1 {
        display: inline-block;
        float: left;
    }
    f2 {
        display: inline-block;
        float: right;
    }

    .home-screen {
        margin: 0 auto;
        width: 1190px;
        height: 522px;
        background-color: #f5f5f5;
    }
    .main-block {
        width: 690px;
        height: 512px;
        /*background-color: #675765;*/
        padding-top: 10px;
        padding-left: 10px;
        padding-bottom: 0px;
        padding-right: 0px;
    }
    .main-block .col-left {
        width: 520px;
        height: 512px;
    }
    .main-block .col-left .play-top {
        width: 520px;
        height: 280px;
        /*background-color: #5daf34;*/
    }
    .main-block .col-left .play-bm {
        width: 520px;
        margin-top: 2px;
        height: 230px;
        /*background-color: #5daf34;*/
    }
    .main-block .col-left .play-bm .play-bm-title{
        width: 100%;
        height: 18px;
    }
    .main-block .col-sub {
        margin-left: 10px;
        width: 160px;
        height: 512px;
    }
    .main-block .col-sub .festival-top {
        width: 160px;
        height: 280px;
        /*background-color: blue;*/
    }
    .main-block .col-sub .festival-bm {
        margin-top: 2px;
        width: 160px;
        height: 230px;
        /*background-color: blue;*/
    }
    .col-right {
        width: 290px;
        height: 522px;
        /*background-color: #e8eaec;*/
        overflow: hidden;
    }
    .col-right .login-detail {
        width: 290px;
        height: 137px;
        background-image: url("../../assets/tmp/login-bg.png");
        /*background-color: #AACDEC;*/
    }
    .col-right .business {
        width: 290px;
        height: 69px;
        margin-top: 1px;
        /*background-color: #AACDEC;*/
    }
    .business-a {
        width: 290px;
        height: 69px;
        display: inline-block;
        margin-left: 0px;
        float: left;
        color: black;
        text-decoration: none;
        font-size: 10px;
        line-height: 30px;
    }
    .business-a img{
        width: 290px;
        height: 69px;
        display: inline-block;
        margin-left: 0px;
    }
    .col-right .site-about {
        width: 290px;
        height: 77px;
        margin-top: -13px;
        background-color: white;
    }
    .col-right .service-detail {
        width: 290px;
        height: 155px;
        margin-top: 1px;
        /*background-color: #AACDEC;*/
    }
    .col-right .al-more {
        width: 290px;
        height: 77px;
        margin-top: 1px;
        background-color: white;
    }
    .title-logo {
        display: inline-block;
        width: 122px;
        height: 18px;
        float: left;
        margin-left: 5px;
    }
    .festival-top-a {
        display: inline-block;
        width: 160px;
        height: 280px;
        margin-left: 0px;
        float: left;
        color: black;
        line-height: 30px;
        text-decoration: none;
        font-size: 10px;
    }
    .festival-bm-img-a {
        display: inline-block;
        width: 160px;
        height: 200px;
        margin-left: 0px;
        float: left;
        color: black;
        line-height: 30px;
        text-decoration: none;
        font-size: 10px;
    }
    .member-login {
        width: 290px;
        height: 91px;
        padding-top: 5px;
    }

    .member-avatar {
        margin: 0 auto;
        width: 74px;
        height: 56px;
    }

    .member-avatar span{
        display: inline-block;
        margin: 0 auto;
        width: 56px;
        height: 56px;
    }

    .member-info {
        display: inline-block;
        width: 290px;
        height: 17px;
        line-height: 17px;
        font-size: 12px;
    }
    .member-tjb {
        width: 290px;
        height: 17px;
        text-align: center;
        margin-top: 0px;
    }
    .member-tjb a {
        background-color: #ffe4db;
        border-radius: 10px;
        line-height: 17px;
        width: 80px;
        color: #675765;
        font-size: 10px;
        text-decoration: none;
        float: left;
    }
    .tjb-left {
        display: inline-block;
        float: left;
        height: 17px;
        margin-left: 65px;
    }
    .tjb-right {
        display: inline-block;
        float: left;
        height: 17px;
    }

    .member-btn {
        width: 290px;
        height: 40px;
        margin-top: -5px;
    }

    .member-btn-logout {
        margin-top: 12px;
        height: 25px;
        width: 275px;
        margin-left: 5px;
    }
    .member-btn-logout a {
        background-color: #675765;
        color: white;
        width: 80px;
        height: 25px;
        line-height: 25px;
        border-radius: 5px;
        font-size: 14px;
        float: left;
        text-decoration: none;
        display: inline-block;
        margin-left: 10px;
    }

    .member-btn-order {
        margin-top: 8px;
        height: 25px;
        width: 275px;
        margin-left: 5px;
    }

    .member-btn-order a {
        color: black;
        width: 66px;
        text-align: center;
        font-size: 12px;
        float: left;
        text-decoration: none;
        margin-left: -1px;
    }

    .member-btn-order a:nth-child(1){
        margin-left: 10px;
    }

    .member-btn-order a span {
        display: block;
        height: 18px;
        font-size: 14px;
        color: #675765;
    }

    .site-about .site-label-list {
        list-style: none;
        height: 30px;
        padding: 0px !important;
        /*overflow: hidden;*/
    }
    .site-about .site-label {
        display: inline-block;
        width: 38px;
        height: 30px;
        padding: 0px;
        line-height: 30px;
        margin-left: 15px;
        padding: 0px !important;
    }
    /*.site-about .site-label:nth-child(0){
        margin-left: -10px;
    }*/
    .site-about .site-label a{
        display: inline-block;
        height: 30px;
        line-height: 30px;
        width: 30px;
        font-size: 14px;
        margin-left: 4px;
        font-weight: bold;
        float: left;
        color: black;
        text-decoration: none;
    }
    .site-about .site-label a:hover{
        cursor: pointer;
        color: #675765;
        border-bottom: 2px solid #675765;
    }

    .site-about .site-content {
        height: 47px;
        margin-top: -17px;
    }
    .site-about .site-content a {
        display: inline-block;
        height: 47px;
        line-height: 47px;
        text-align: center;
        width: 100%;
        float: left;
        color: black;
        text-decoration: none;
        margin-left: 10px;
        font-size: 10px;
    }

    .col-right .al-more .more-title {
        height: 30px;
        width: 100%;
    }
    .col-right .al-more .more-title .title-left {
        font-size: 14px;
        font-weight: bold;
        height: 30px;
        line-height: 30px;
        margin-left: 4px;
    }
    .col-right .al-more .more-title .title-right {
        height: 30px;
        line-height: 30px;
        margin-right: 10px;
        color: black;
        text-decoration: none;
        margin-left: 10px;
        font-size: 10px;
    }
    .col-right .al-more .more-apps {
        list-style: none;
        height: 44px;
        margin-top: -10px;
        margin-left: -20px;
        position: absolute;
    }

    .col-right .al-more .more-apps .more-app {
        width: 32px;
        height: 32px;
        display: inline-block;
        margin-left: 15px;
        position: relative;
        margin-top: 8px;

    }
    .col-right .al-more .more-apps .more-app a {
        width: 32px;
        height: 32px;
        display: inline-block;
        line-height: 32px;
        margin-left: 0px;
        float: left;
        color: black;
        text-decoration: none;
        font-size: 10px;
    }
    .col-right .al-more .more-apps .more-app a img {
        width: 32px;
        height: 32px;
    }

</style>
<style lang="scss">

    .home-screen aside.el-aside {
        overflow: hidden;
    }

    .home-screen ul.el-menu {
        padding-top: 6px;
        padding-bottom: 3px;
        border-right: 1px solid #675765;
        overflow: hidden;
    }

    .home-screen li.el-menu-item {
        height: 34px;
        padding: 0px 0px 0px 10px !important;
        width: 190px;

    }
    .home-screen li.el-menu-item:hover {
        color: red;
        cursor: pointer;
    }
    .home-screen li.el-menu-item span.el-breadcrumb__inner {
        color: inherit;
    }
    .home-screen li.el-menu-item span.el-breadcrumb__separator {
        color: inherit;
    }
    .home-screen li.el-menu-item span.icon-arrow i {
        display: inline-block;
        width: 10px;
        font-size: 10px;
        float: right;
        line-height: 34px;
        /*margin-right: 0px;*/
    }
    .home-screen div.el-breadcrumb {
        height: 34px;
        display: inline-block;
        float: left;
    }
    .home-screen div.el-breadcrumb span{
        display: inline-block;
        height: 34px;
        line-height: 34px;
    }
    .home-screen main.el-main {
        /*padding-top: 0px;
        padding-left: 0px;
        padding-bottom: 0px;
        padding-right: 0px;*/
        padding: 0px;
    }
    .home-screen .play-top div.el-carousel {
        height: 280px;
        overflow: hidden;
    }
    .home-screen .play-bm div.el-carousel {
        height: 201px;
        overflow: hidden;
        background-color: white;
        border-top: 2px solid #675765;
    }
    .home-screen .play-top div.el-carousel .top-img {
        width: 520px;
        height: 280px;
    }
    .home-screen .play-bm div.el-carousel .ele-one {
        width: 520px;
        height: 201px;
    }
    .home-screen .play-bm div.el-carousel .ele-one a {
        float: left;
        color: black;
        line-height: 30px;
        text-decoration: none;
        display: inline-block;
        font-size: 10px;
    }
    .home-screen .play-bm div.el-carousel .ele-one .ele-left-1{
        width: 250px;
        height: 155px;
        margin-top: 15px;
        margin-left: 10px;
    }
    .home-screen .play-bm div.el-carousel .ele-one .ele-right-1{
        width: 250px;
        height: 155px;
        margin-top: 15px;
        margin-left: 2px;
    }
    .home-screen .play-bm div.el-carousel .ele-one .ele-left-2{
        width: 250px;
        height: 155px;
        margin-top: 15px;
        margin-left: 10px;
    }
    .home-screen .play-bm div.el-carousel .ele-one .ele-right-2{
        width: 250px;
        height: 155px;
        margin-top: 15px;
        margin-left: 2px;
    }
    .home-screen .play-bm div.el-carousel .ele-one .ele-left-3{
        width: 250px;
        height: 155px;
        margin-top: 30px;
        margin-left: 6px;
    }
    .home-screen .play-bm div.el-carousel .ele-one .ele-right-3{
        width: 250px;
        height: 155px;
        margin-top: 30px;
        margin-left: 6px;
    }
    .home-screen .play-bm div.el-carousel .ele-one .ele-left-4{
        width: 250px;
        height: 155px;
        margin-top: 15px;
        margin-left: 10px;
    }
    .home-screen .play-bm div.el-carousel .ele-one .ele-right-4{
        width: 250px;
        height: 155px;
        margin-top: 15px;
        margin-left: 3px;
    }
    .home-screen .play-bm div.el-carousel .ele-one .ele-left-5{
        width: 250px;
        height: 155px;
        margin-top: 15px;
        margin-left: 10px;
    }
    .home-screen .play-bm div.el-carousel .ele-one .ele-right-5{
        width: 250px;
        height: 155px;
        margin-top: 15px;
        margin-left: 3px;
    }
    .home-screen .play-bm div.el-carousel .ele-one .ele-left-6{
        width: 250px;
        height: 155px;
        margin-top: 15px;
        margin-left: 10px;
    }
    .home-screen .play-bm div.el-carousel .ele-one .ele-right-6{
        width: 250px;
        height: 155px;
        margin-top: 15px;
        margin-left: 3px;
    }

    .home-screen .play-bm div.el-carousel__container {
        height: 201px;
    }

    .home-screen .service-detail div.el-row {
        width: 290px;
        height: 155px;
        background-color: white;
    }
    .home-screen .service-detail div.el-col {
        height: 77px;
        padding: 0px;
    }

    .home-screen .service-detail div.el-col:nth-child(1) {
        border-right: 1px solid #f5f5f5;
    }
    .home-screen .service-detail div.el-col:nth-child(2) {
        border-right: 1px solid #f5f5f5;
    }
    .home-screen .service-detail div.el-col:nth-child(3) {
        border-right: 1px solid #f5f5f5;
    }
    .home-screen .service-detail div.el-col:nth-child(5) {
        border-top: 1px solid #f5f5f5;
        border-right: 1px solid #f5f5f5;
    }
    .home-screen .service-detail div.el-col:nth-child(6) {
        border-top: 1px solid #f5f5f5;
        border-right: 1px solid #f5f5f5;
    }
    .home-screen .service-detail div.el-col:nth-child(7) {
        border-top: 1px solid #f5f5f5;
        border-right: 1px solid #f5f5f5;
    }
    .home-screen .service-detail div.el-col:nth-child(8) {
        border-top: 1px solid #f5f5f5;
    }

    .home-screen .service-detail div.el-col a {
        display: inline-block;
        height: 64px;
        width: 100%;
        margin-left: 0px;
        padding-top: 16px;
        float: left;
        color: black;
        line-height: 30px;
        text-decoration: none;
        font-size: 10px;
    }
    .home-screen .service-detail div.el-col a span {
        display: inline-block;
        height: 24px;
        font-size: 24px;
        line-height: 24px;
    }
    .home-screen .service-detail div.el-col a p {
        height: 24px;
        line-height: 24px;
        font-size: 12px;
        margin-top: -5px;
    }


</style>
