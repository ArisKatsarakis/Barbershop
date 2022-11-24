<template>
  <b-container class="bv-example-row">
    <b-row align-h="between" class="shadow" style="margin-bottom: 10px;">
      <b-col align-self="start" cols="4">
        <label for="example-datepicker">Choose a date</label>
        <b-form-datepicker @input="getDate()" id="example-datepicker" v-model="calendarDate"
                           class="mb-2"></b-form-datepicker>
      </b-col>
      <b-col cols="4">

        <b-button variant="outline-primary" class="arrow" @click="prev">
          <b-icon-arrow-left font-scale="1">
          </b-icon-arrow-left>
        </b-button>

        <b-button variant="outline-primary" id="today" @click="today">Today</b-button>
        <b-button class="arrow" variant="outline-primary" @click="next">
          <b-icon-arrow-right font-scale="1">

          </b-icon-arrow-right>

        </b-button>

      </b-col>

    </b-row>
    <b-row>
      <b-col>
        <b-table :items="items" :fields="fields" class="table-bordered">
          <template #table-caption>Date: {{ value }}</template>
          <template #cell(Mixalis)="data">
            <button-appointment
                v-if="!data.value.name"
                @update-app="addNewAppointment"
                v-bind:barber="'Mixalis'"
                v-bind:timeslot="items[data.index].Hours"
                v-bind:set_Date="calendarDate"
            >

            </button-appointment>
            <div v-else style="text-align: center">

              <appointment-container
                  v-bind:username="data.value.name"
                  v-bind:time="items[data.index].Hours"
                  v-bind:date="data.date"
                  v-bind:barber="'Mixalis'"
                  v-bind:type="data.value.type"
                  v-bind:id="parseInt(data.value.id)"
                  @on-delete="deleteAppointmentById"
              >

              </appointment-container>
            </div>

          </template>
          <template #cell(Andreas)="data">
            <button-appointment style="text-align: center"
                                v-if="!data.value.name"
                                v-bind:timeslot="items[data.index].Hours"
                                v-bind:set_Date="calendarDate"
                                v-bind:barber="'Andreas'"
                                @update-app="addNewAppointment"
            >

            </button-appointment>
            <div v-else style="text-align: center">
              <appointment-container
                  v-bind:username="data.value.name"
                  v-bind:time="items[data.index].Hours"
                  v-bind:date="data.date"
                  v-bind:barber="'Andreas'"
                  v-bind:type="data.value.type"
                  v-bind:id="parseInt(data.value.id)"
                  @on-delete="deleteAppointmentById"
              >

              </appointment-container>
            </div>

          </template>

        </b-table>
      </b-col>
    </b-row>
    <b-row align-h="end">
      <b-col cols="4">
        <b-button @click="get" variant="secondary">
          Show Appointments
        </b-button>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import buttonAppointment from "@/components/ButtoonAppointment";
import AppointmentContainer from "@/components/AppointmentContainer";
import axios from "axios";

export default {
  name: "AppointmentTable",
  components: {
    buttonAppointment,
    AppointmentContainer
  },
  data() {
    return {
      items: [
        {Hours: '09:30',},
        {Hours: '10:00',},
        {Hours: '10:30',},
        {Hours: '11:00',},
        {Hours: '11:30',},
        {Hours: '12:00',},
        {Hours: '12:30',},
        {Hours: '13:00',},
        {Hours: '13:30',},
        {Hours: '14:00',},
        {Hours: '17:00',},
        {Hours: '17:30',},
        {Hours: '18:00',},
        {Hours: '18:30',},
        {Hours: '19:00',},
        {Hours: '19:30',},
        {Hours: '20:00',},
        {Hours: '20:30',},
        {Hours: '21:00',},

      ],
      fields: [
        {
          key: 'Hours'
        },
        {
          key: 'Mixalis'
        },
        {
          key: 'Andreas'
        }
      ],
      calendarDate: "2022-11-24",



    }
  },
  methods:{
    renderTheTable: function (response){
      let appointments = response;
      this.cleanItems();
      for (let index in this.items) {
        for (let dataKey in appointments) {
          if (appointments[dataKey].time == this.items[index].Hours + ":00") {
            if (this.items[index].Mixalis.name == null) {
              this.items[index].Mixalis.name = appointments[dataKey].username;
              this.items[index].Mixalis.type = appointments[dataKey].type;
              this.items[index].Mixalis.id = appointments[dataKey].id;
            } else if (this.items[index].Andreas.name == null) {
              this.items[index].Andreas.name = appointments[dataKey].username;
              this.items[index].Andreas.type = appointments[dataKey].type;
              this.items[index].Andreas.id = appointments[dataKey].id;

            }
          }
        }
      }
    },
  },
  beforeCreate: function () {
    const config = {
      date: "2022-11-24"
    };
    axios.post("api/v1/appointment/date",config)
        .then(function (response){
          console.log(response.data);
          this.renderTheTable(response.data);
        })
  }
}
</script>

<style scoped>

.arrow {
  margin-top: 25px;
}

#today {
  margin-top: 25px;
}


</style>