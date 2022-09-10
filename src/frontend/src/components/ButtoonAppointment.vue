<template>
  <div>
      <b-button  size="sm" @click="$bvModal.show(timeslot + barber)" class="newAppointment" variant="outline-secondary">
        <b-icon icon="plus" aria-hidden="true"></b-icon>
      </b-button>
      <b-modal size="md"  v-bind:id="timeslot + barber" >
        <add-new-appointment
          v-bind:set-date="set_Date"
          v-bind:set-time="timeslot"
        />
      </b-modal>
    </div>
</template>

<script>
import addNewAppointment from "@/components/AddNewAppointment";
export default {
  name: "ButtoonAppointment",
  props: {
    timeslot: String,
    set_Date: Date,
    barber: String

  },
  components: {
    addNewAppointment
  },
  data(){
    return {
    }

  }
}
</script>

<style scoped>
  .newAppointment {
    width: 150px;
  }
</style>