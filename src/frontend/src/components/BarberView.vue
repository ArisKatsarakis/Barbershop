<template>
<div>
  <b-container>
    <h1> Barbers</h1>
    <b-table :items="barbers">

    </b-table>
  </b-container>
</div>
</template>

<script>
export default {
  name: "BarberView",
  data() {
    return  {
      barbers: []
    }
  },methods: {

  },beforeMount() {
    let base = this.barbers;
    base.push(
        {
          name: "Mixalis",
          appointments: 10,
          EURO: 100
        }
    )
  }
}
</script>

<style scoped>

</style>