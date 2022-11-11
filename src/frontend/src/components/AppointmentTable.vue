<template>
  <b-container class="bv-example-row">
    <b-row align-h="between" class="shadow" style="margin-bottom: 10px;">
      <b-col align-self="start" cols="4">
        <label for="example-datepicker">Choose a date</label>
        <b-form-datepicker @input="getDate()" id="example-datepicker" v-model="calendarDate" v-bind:value="value" class="mb-2"></b-form-datepicker>
      </b-col>
      <b-col cols="4">

          <b-button variant="outline-primary" class="arrow" @click="prev">
            <b-icon-arrow-left font-scale="1" >
            </b-icon-arrow-left>
          </b-button>

          <b-button variant="outline-primary" id="today" @click="today">Today</b-button>
            <b-button class="arrow" variant="outline-primary" @click="next">
              <b-icon-arrow-right font-scale="1" >

              </b-icon-arrow-right>

          </b-button>

      </b-col>

    </b-row>
    <b-row>
      <b-col>
        <b-table   :items="items"  :fields="fields" class="table-bordered" >
          <template #table-caption>Date: {{value}}</template>
          <template #cell(Mixalis)="data">
              <buttoon-appointment style="text-align: center"
                v-if="! data.value.name"
                v-bind:timeslot ="items[data.index].Hours"
                                   v-bind:barber="'Mixalis'"
                                   v-bind:set_Date="value"

              >

              </buttoon-appointment>
              <div v-else style="text-align: center">
                <span style="background-color: black; color: whitesmoke" > Name: {{ data.value.name }}</span>
                <span style="background-color: greenyellow; color: whitesmoke"> Type: {{ data.value.type }}</span>
              </div>

          </template>
          <template #cell(Andreas)="data">
            <buttoon-appointment style="text-align: center"
                v-if="! data.value.name"
                v-bind:timeslot ="items[data.index].Hours"
                v-bind:set_Date="value"
                v-bind:barber="'Andreas'"
            >

            </buttoon-appointment>
            <div v-else  style="text-align: center">
              <span style="background-color: black; color: whitesmoke" > Name: {{ data.value.name }}</span>
              <span style="background-color: greenyellow; color: whitesmoke"> Type: {{ data.value.type }}</span>
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
import buttoonAppointment from "@/components/ButtoonAppointment";
import axios from "axios";
export default {
  name: "AppointmentTable",
  components:{
    buttoonAppointment
  },
  data() {
    return {
        calendarDate: null,
        items: [
          { Hours: '09:30', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
          { Hours: '10:00', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
          { Hours: '10:30', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
          { Hours: '11:00', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
          { Hours: '11:30', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
          { Hours: '12:00', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
          { Hours: '12:30', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
          { Hours: '13:00', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
          { Hours: '13:30', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
          { Hours: '14:00', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
          { Hours: '17:00', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
          { Hours: '17:30', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
          { Hours: '18:00', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
          { Hours: '18:30', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
          { Hours: '19:00', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
          { Hours: '19:30', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
          { Hours: '20:00', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
          { Hours: '20:30', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
          { Hours: '21:00', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },

        ],
      fields: [
        {
          key:'Hours'
        },
        {
          key:'Mixalis'
        },
        {
          key:'Andreas'
        }
      ],
      value: null


    }
  },
  methods: {
    getAppointmentsByDate(dateString) {
      const body = {
        date: dateString
      }
      let appointments;
      axios.post('http://localhost:8080/api/v1/appointment/date',body)
          .then(response => response.data)
          .then(data => {
            console.log(data);
            appointments = data;
            this.cleanItems();
            for (let index in this.items) {
              for (let dataKey in appointments) {
                if (appointments[dataKey].time == this.items[index].Hours + ":00"){
                  if(this.items[index].Mixalis.name == null){
                    this.items[index].Mixalis.name = appointments[dataKey].username;
                    this.items[index].Mixalis.type = appointments[dataKey].type;
                  }else if(this.items[index].Andreas.name == null){
                    this.items[index].Andreas.name = appointments[dataKey].username;
                    this.items[index].Andreas.type = appointments[dataKey].type;
                  }
                }
              }
            }

          })

    },
    get(){
       var appointments;

      fetch("/api/v1/appointment")
          .then((response) => response.json())
          .then((data) => {
            // console.log(data);
            appointments = data;
            this.cleanItems();
            for (let index in this.items) {
              for (let dataKey in appointments) {
                console.log(appointments[dataKey]);
                if (appointments[dataKey].time == this.items[index].Hours + ":00"){
                    if(this.items[index].Mixalis.name == null){
                        console.log('Hooray');
                        this.items[index].Mixalis.name = appointments[dataKey].username;
                        this.items[index].Mixalis.type = appointments[dataKey].type;
                    }else if(this.items[index].Andreas.name == null){
                      console.log('Hooray');
                      this.items[index].Andreas.name = appointments[dataKey].username;
                      this.items[index].Andreas.type = appointments[dataKey].type;
                    }
                }
              }
            }


          });
    },
    today(){
      this.value=new Date();
      this.calendarDate = this.value;
    },
    next(){
      var new_date = this.value;
      console.log(new_date)
      new_date.setDate(new_date.getDate() + 1);
      this.value = new_date;
    },
    prev(){

      this.value.setDate( this.value.getDate() -1 );
      console.log(this.value);
    },
    getDate(){
      // console.log(this.calendarDate);
      this.value = new Date(this.calendarDate);
      this.getAppointmentsByDate(this.calendarDate);
    },
    cleanItems(){
      this.items = [
        { Hours: '09:30', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
        { Hours: '10:00', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
        { Hours: '10:30', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
        { Hours: '11:00', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
        { Hours: '11:30', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
        { Hours: '12:00', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
        { Hours: '12:30', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
        { Hours: '13:00', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
        { Hours: '13:30', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
        { Hours: '14:00', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
        { Hours: '17:00', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
        { Hours: '17:30', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
        { Hours: '18:00', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
        { Hours: '18:30', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
        { Hours: '19:00', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
        { Hours: '19:30', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
        { Hours: '20:00', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
        { Hours: '20:30', Mixalis: {name:  null, type: null}, Andreas: {name: null, type: null} },
        { Hours: '21:00', Mixalis: {name: null, type: null}, Andreas: {name: null, type: null} },
      ]
    }


  }
}
</script>

<style scoped>

.arrow{
  margin-top: 25px;
}
#today{
  margin-top: 25px;
}


</style>