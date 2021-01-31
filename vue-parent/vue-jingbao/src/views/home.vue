<template>
  <div class="home">
    <home-head></home-head>
    <festival></festival>
    <cup></cup>
    <site-nav class="site-nav"></site-nav>
    <screen></screen>
    <helper></helper>
  </div>

</template>

<script>
// @ is an alias to /src

import festival from "../components/home/festival";
import homeHead from "../components/home/homeHead";
import cup from "../components/home/cup";
import siteNav from "../components/home/siteNav";
import screen from "../components/home/screen";
import helper from "../components/home/helper";

export default {
  name: 'home',
  components: {
    festival,
    homeHead,
    cup,
    siteNav,
    screen,
    helper
  },
  data(){
    return {

    }
  }
}
</script>

<style>

  body > .el-container {
    margin-bottom: 40px;
  }




</style>

<style lang="scss">
  .home {
    z-index: 10000;
    width: 100%;
  }


</style>
<style lang="scss" scoped>


</style>
