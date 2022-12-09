<template>
  <div>
    <b-container>
      <b-navbar type="dark" variant="dark" class="justify-content-center">
        <b-navbar-nav>
          <b-nav-item style="color:lightgreen;" href="/">Home</b-nav-item>
        </b-navbar-nav>
        <b-navbar-nav class="justify-content-end"  style="margin-left: 10px">
          <b-nav-item href="/clients">Clients</b-nav-item>

        </b-navbar-nav>
        <b-navbar-nav class="justify-content-end"  style="margin-left: 10px">
          <b-nav-item href="/barbers">Barbers</b-nav-item>

        </b-navbar-nav>
      </b-navbar>
    </b-container>
    <router-view>

    </router-view>

  </div>

</template>

<script>
export default {
  name: 'App',
  components: {

  },
  data() {
    return {
      msg: "Test",
    }
  },
  mounted() {
    console.log("Hello From Vue!")
  }
}
</script>

<style>

</style>
