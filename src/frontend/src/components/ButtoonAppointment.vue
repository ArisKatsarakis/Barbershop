<template>
  <div>
      <b-button  size="sm" @click="$bvModal.show(timeslot + barber)" class="newAppointment" variant="outline-secondary">
        <b-icon icon="plus" aria-hidden="true"></b-icon>
      </b-button>
      <b-modal size="md"  v-bind:id="timeslot + barber" >
        <b-form>
          <b-form-group>
            <b-form-input
                class="mb-2 me-sm-2 mb-sm-0"
                id="username"
                type="text"
                v-model="form.username"
                placeholder="Clients Name">

            </b-form-input>
            <label class="mr-sm-2" for="type">Type: </label>

            <b-form-select
                id="type"
                class="mb-2 me-sm-2 mb-sm-0"
                :options="types"
                :value="null"
                v-model="form.type"
            ></b-form-select>
            <label class="sm-2" for="time">Time Slot</label>
            <b-time
                v-bind:value="timeslot"

            >


            </b-time>
            <p>Your time slot is {{form.time}}</p>
            <label for="apdate">Date of Appointment:</label>
            <b-form-datepicker
                id="apdate"
                v-model="form.date"
            >

            </b-form-datepicker>

          </b-form-group>
          <p> Data before Submiting username: {{form.username}}
            Date: {{form.date}}
            Time-Slot: {{form.time}}
            Type of haircut: {{form.type}}
          </p>

        </b-form>
        <template #modal-footer="{close}">
          <b-button type="submit" variant="primary" @click="onSubmit();close();">Submit</b-button>
          <b-button type="close" variant="danger" @click="close()">Cancel</b-button>
        </template>
      </b-modal>
    </div>
</template>

<script>
export default {
  name: "ButtoonAppointment",
  props: {
    timeslot: String,
    set_Date: String,
    barber: String

  },
  components: {
  },
  data(){
    return {
       form:{
         username: null,
         time: this.timeslot,
         type: null,
         date: new Date(this.set_Date)
       },
      types: [{ text: "Select one" , value:  null} , "Mousia", "Malli" , "Malli  + Mousia"]


    }

  },
  methods:{
    onSubmit(){
      this.form.date = this.form.date.toISOString().split("T")[0]
      this.$emit('update-app', JSON.stringify(this.form));

    }
  }
}
</script>

<style scoped>
  .newAppointment {
    width: 150px;
  }
</style>