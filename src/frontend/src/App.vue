<template>
<dash-board></dash-board>
</template>

<script>
import DashBoard from "@/components/DashBoard";
export default {
  name: 'App',
  components: {
    DashBoard,

  },
  data() {
    return {
      msg: "Test",
    }
  },
  mounted() {
    fetch("/api/v1/appointment")
    .then((response) => response.text())
    .then( (data) => {
      this.msg = data;
    });
  }
}
</script>

<style>

</style>
