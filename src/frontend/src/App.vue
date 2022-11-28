<template>
  <div>
    <b-container>
      <b-navbar type="dark" variant="dark">
        <b-navbar-nav>
          <b-nav-item href="/">Home</b-nav-item>
        </b-navbar-nav>
        <b-navbar-nav class="justify-content-end align-content-end" >
          <b-nav-item-dropdown text="Tables" right >
            <b-dropdown-item href="/clients">Clients</b-dropdown-item>
            <b-dropdown-item href="#">Settings</b-dropdown-item>
          </b-nav-item-dropdown>
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
