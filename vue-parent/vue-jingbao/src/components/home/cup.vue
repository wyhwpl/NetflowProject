<template>
    <div style="background-color: #675765">
        <div class="home-cup">
            <a href="" class="cup-logo f1">
                <img src="@/assets/tmp/logo.gif"/>
            </a>
            <cup-search class="search"></cup-search>
        </div>
    </div>
</template>

<script>
    import cupSearch from "./cupSearch";
    export default {
        name: "cup",
        components: {
            cupSearch
        }
    }
</script>

<style>

    .f1 {
        float: left;
        display: inline-block;
        margin-top: -1.5px;
        margin-left: 0px;
    }

    .home-cup {
        margin: 0 auto;
        width: 1190px;
        height: 140px;
        background-color: white;
    }

    .cup-logo {
        height: 140px;
        width: 190px;
        /*padding: 10px 0px 10px 15px;*/
    }

    .search{
        margin-top: 2%;
        margin-left: 7%;
    }
</style>
<style scoped>

</style>
