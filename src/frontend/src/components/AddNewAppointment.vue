<template>
  <div>

    <b-modal size="md"  v-bind:id="form.time + form.barberId" >
      <b-form @submit="onSubmit">
        <b-form-group>
          <label for="username">Username</label>
          <b-form-input
              class="mb-2 me-sm-2 mb-sm-0"
              id="username"
              type="text"
              v-model="form.username"
              list="client-list"
              placeholder="Clients Name">

          </b-form-input>
          <datalist id="client-list">
            <option>Add  New</option>
            <option v-for="(client) in this.clients" :key="client.id">  {{client.name}} {{client.sirName}}</option>
          </datalist>

        </b-form-group>
        <b-form-group>
          <label class="mr-sm-2" for="type">Type: </label>

          <b-form-select
              id="type"
              class="mb-2 mr-sm-2 mb-sm-0"
              :options="types"
              :value="null"
              v-model="form.type"
          ></b-form-select>
        </b-form-group>
        <b-form-group>
          <label class="sm-2" for="time">Time Slot</label>
          <b-time
              v-bind:value="setTime"

          >


          </b-time>
          <p>Your time slot is {{form.time}}</p>
        </b-form-group>
        <b-form-group>
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
          <b-button type="submit" variant="primary">Submit</b-button>

      </b-form>


    </b-modal>

  </div>


</template>

<script>
import axios from "axios";

export default {
  name: "AddNewAppointment",
  props: {
    setTime: String,
    setDate: String,
    setBarber:Number,
    setSlot:String
  },
  data() {
    return {
      form: {
        username: '',
        date: this.setDate,
        time: this.setTime,
        type: '',
        barberId:this.setBarber
      },
      types: [{ text: "Select one" , value:  null} , "Mousia", "Malli" , "Malli  + Mousia"],
      timeslot: this.setSlot,
      clients: []
    }
  },
  methods: {
    onSubmit(event){
      event.preventDefault();
      this.$emit('update-app', JSON.stringify(this.form));

      // console.log(data);
      //
    }
  },beforeMount() {
    let newClients = this.clients;
    axios.get("api/v1/client").then(
        function (response) {
          response.data.forEach( resData => newClients.push(resData));
        }
    )
  }

}
</script>

<style scoped>

</style>