<template>
    <div class="account">
        <home-head></home-head>
        <account-head></account-head>
        <account-page></account-page>
    </div>
</template>

<script>
    import homeHead from "../components/home/homeHead";
    import accountHead from "../components/account/accountHead";
    import accountPage from "../components/account/accountPage";
    export default {
        name: "account",
        components: {
            homeHead,
            accountHead,
            accountPage
        }
    }
</script>

<style scoped>

</style>
