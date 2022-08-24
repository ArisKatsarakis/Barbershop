<template>
    <b-form @submit="onSubmit">
      <b-form-group>
        <label for="username">Username</label>
        <b-form-input
            class="mb-2 me-sm-2 mb-sm-0"
            id="username"
            type="text"
            v-model="form.username"
            placeholder="Clients Name">

        </b-form-input>
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
        <b-form-timepicker
          id="time"
          v-model="form.time"
          value ='10:30'
        >

        </b-form-timepicker>
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

</template>

<script>
import  axios from 'axios';
export default {
  name: "AddNewAppointment",
  data() {
    return {
      form: {
        username: '',
        date: '',
        time: '',
        type: ''
      },
      types: [{ text: "Select one" , value:  null} , "Mousia", "Malli" , "Malli  + Mousia"]
    }
  },
  methods: {
    onSubmit(event){
      event.preventDefault();
      const data = JSON.stringify(this.form);
      alert(data);
      // const requestopts = {
      //   method: "POST",
      //   headers:{"Content-Type" : 'application-json' ,
      //   "Access-Control-Allow-Origin" : "*"},
      //   body: JSON.stringify(this.form)
      // };
      axios.post('api/v1/appointment',this.form)
      .then((res) => {
        alert(res);
      });
    }
  }

}
</script>

<style scoped>

</style>