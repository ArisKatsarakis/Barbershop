<template>
  <div>
      <b-button  size="sm" @click="$bvModal.show(timeslot + barber)" class="newAppointment" variant="outline-secondary">
        <b-icon icon="plus" aria-hidden="true"></b-icon>
      </b-button>

    <add-new-appointment
        v-bind:set-date="set_Date"
        v-bind:set-time="timeslot"
        v-bind:set-barber="barber"
        @update-app="returnAppointment"
    />
    </div>
</template>

<script>
import addNewAppointment from "@/components/AddNewAppointment";
export default {
  name: "ButtoonAppointment",
  props: {
    timeslot: String,
    set_Date: String,
    barber: Number

  },
  components: {
    addNewAppointment
  },
  data(){
    return {
      clients:[]

    }

  },
  methods:{
    returnAppointment(app){
      this.$bvModal.hide(this.timeslot + this.barber);
      this.$emit('update-app',app)
    }
  }
}
</script>

<style scoped>
  .newAppointment {
    width: 150px;
  }
</style>