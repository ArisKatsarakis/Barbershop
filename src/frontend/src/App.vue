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
    console.log("Hello From Vue!")
  }
}
</script>

<style>

</style>
