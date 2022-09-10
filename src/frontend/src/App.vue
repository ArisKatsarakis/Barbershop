<template>


  <AppointmentTable>

  </AppointmentTable>
</template>

<script>
import AppointmentTable from "@/components/AppointmentTable";
export default {
  name: 'App',
  components: {
    AppointmentTable

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
