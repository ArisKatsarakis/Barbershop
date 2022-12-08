<template>
  <b-container class="bv-example-row">
    <b-row align-h="between" class="shadow" style="margin-bottom: 10px;">
      <b-col align-self="start" cols="4">
        <label for="example-datepicker">Choose a date</label>
        <b-form-datepicker @input="getDate()" id="example-datepicker" v-model="calendarDate"  class="mb-2" value-as-date></b-form-datepicker>
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
        <b-table   :items="items"  :fields="fields" class="table-bordered" caption-top>
          <template #table-caption>
            <h1>
              Date: {{`${calendarDate.toLocaleDateString()}`}}
            </h1>
          </template>
          <template #cell(Mixalis)="data">
              <button-appointment
                  v-if="!data.value.name"
                  @update-app="addNewAppointment"
                  v-bind:barber=1
                  v-bind:timeslot="items[data.index].Hours"
                  v-bind:set-Date="value.toString()"

              >

              </button-appointment>
              <div v-else style="text-align: center">

                <appointment-container
                  v-bind:username="data.value.name"
                  v-bind:time="items[data.index].Hours"
                  v-bind:date="data.date"
                  v-bind:barber="'Mixalis'"
                  v-bind:type="data.value.type"
                  v-bind:id="parseInt(data.value.apointid)"
                  @on-delete="deleteAppointmentById"
                >

                </appointment-container>
              </div>

          </template>
          <template #cell(Andreas)="data">
            <button-appointment style="text-align: center"
                v-if="!data.value.name"
                v-bind:timeslot ="items[data.index].Hours"
                v-bind:set_Date="value.toString()"
                v-bind:barber=2
                                @update-app="addNewAppointment"

            >

            </button-appointment>
            <div v-else  style="text-align: center">
              <appointment-container
                  v-bind:username="data.value.name"
                  v-bind:time="items[data.index].Hours"
                  v-bind:date="data.date"
                  v-bind:barber="'Andreas'"
                  v-bind:type="data.value.type"
                  v-bind:id="parseInt(data.value.apointid)"
                  @on-delete="deleteAppointmentById"
              >

              </appointment-container>
            </div>

          </template>

        </b-table>
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
  components:{
    buttonAppointment,
    AppointmentContainer
  },
  data() {
    return {
        calendarDate: null,
        items: [
          { Hours: '09:30', Mixalis: {name: null, type: null,}, Andreas: {name: null, type: null} },
          { Hours: '10:00',  },
          { Hours: '10:30',  },
          { Hours: '11:00',  },
          { Hours: '11:30', },
          { Hours: '12:00',  },
          { Hours: '12:30', },
          { Hours: '13:00',  },
          { Hours: '13:30',  },
          { Hours: '14:00',  },
          { Hours: '17:00',  },
          { Hours: '17:30',  },
          { Hours: '18:00',  },
          { Hours: '18:30',  },
          { Hours: '19:00',  },
          { Hours: '19:30',  },
          { Hours: '20:00',   },
          { Hours: '20:30',  },
          { Hours: '21:00',  },

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
      value: null,


    }
  },
  methods: {
    async addNewAppointment(Appointment){
      console.log(JSON.parse(Appointment));
      Appointment = JSON.parse(Appointment);
      axios.post('api/v1/appointment',Appointment)
      .then((res) => {
        console.log(res);
        let fetchNew = this.fetchByDateApiCall(Appointment.date);
         fetchNew.then(response => this.renderTheTable(response));
      });
    },
   async deleteAppointmentById(id) {
      let deleteApicall = this.deleteApicall(id);
      await deleteApicall.then( function (response) {
        alert("This RV has been deleted");
        console.log(response.data.date.toString());

      })
     let dateString = this.value.getFullYear().toString() + "-" + (this.value.toLocaleString("default",{month: "2-digit"}) ) + "-" + this.value.toLocaleString("default",{day: "2-digit"})
     let fetchDates = this.fetchByDateApiCall( dateString);
     fetchDates.then(response => {
       this.renderTheTable(response);
     })
    },
    deleteApicall(id){
      return axios.delete("/api/v1/appointment/delete/"+ id.toString());
    },
    async getAppointmentsByDate(dateString) {
      const body = {
        date: dateString
      }
      let appointments;
      await axios.post('/api/v1/appointment/date', body)
          .then(response => response.data)
          .then(data => {
            console.log(data);
            appointments = data;
            this.cleanItems();
            for (let index in this.items) {
              for (let dataKey in appointments) {
                if (appointments[dataKey].time == this.items[index].Hours + ":00") {
                  if (appointments[dataKey].barberId == 1) {
                    this.items[index].Mixalis.name = appointments[dataKey].username;
                    this.items[index].Mixalis.type = appointments[dataKey].type;
                    this.items[index].Mixalis.appointid = appointments[dataKey].id;
                  } else if (appointments[dataKey].barberId == 2) {
                    this.items[index].Andreas.name = appointments[dataKey].username;
                    this.items[index].Andreas.type = appointments[dataKey].type;
                    this.items[index].Mixalis.appointid = appointments[dataKey].id;
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
    async today() {
      this.value = new Date();
      this.calendarDate = this.value;
      let dateString = this.value.getFullYear().toString() + "-" + (this.value.toLocaleString("default",{month: "2-digit"}) ) + "-" + this.value.toLocaleString("default",{day: "2-digit"})
      let fetchDates = this.fetchByDateApiCall(dateString);
      await fetchDates.then(response => {
        this.renderTheTable(response);
      })
    },
    async next() {
      let new_date = this.value;
      new_date.setDate(new_date.getDate() + 1);
      this.value = new_date;
      this.calendarDate.setDate(new_date.getDate())
      console.log(this.calendarDate);
      let dateString = this.value.getFullYear().toString() + "-" + (this.value.toLocaleString("default",{month: "2-digit"}) ) + "-" + this.value.toLocaleString("default",{day: "2-digit"})
      let fetchDates = this.fetchByDateApiCall(dateString);
      await fetchDates.then(response => {
        this.renderTheTable(response);
      })
    },
    async prev() {
      this.value.setDate(this.value.getDate() - 1);
      this.calendarDate.setDate(this.value.getDate())
      console.log(this.calendarDate);
      let dateString = this.value.getFullYear().toString() + "-" + (this.value.toLocaleString("default",{month: "2-digit"}) ) + "-" + this.value.toLocaleString("default",{day: "2-digit"})
      let fetchDates = this.fetchByDateApiCall(dateString);
      await fetchDates.then(response => {
        this.renderTheTable(response);
      })
    },
    getDate(){
      console.log(this.calendarDate);
      this.value = new Date(this.calendarDate);
      this.getAppointmentsByDate(this.calendarDate);
    },
    cleanItems(){

      for (let i = 0; i < this.items.length; i++) {
        this.items[i].Mixalis = { name: null , type:null , apointid:null};
        this.items[i].Andreas = { name: null , type:null , apointid:null};
      }
    },
    fetchByDateApiCall(dateString){
      const body = {
        date:dateString
      }
      return axios.post('/api/v1/appointment/date', body).then(response => response.data)

    },
    renderTheTable(response){
      let appointments = response;
      this.cleanItems();
      for (let index in this.items) {
        for (let dataKey in appointments) {
          if (appointments[dataKey].time == this.items[index].Hours + ":00") {
            if (appointments[dataKey].barberId === 1) {
              this.items[index].Mixalis.name = appointments[dataKey].username;
              this.items[index].Mixalis.type = appointments[dataKey].type;
              this.items[index].Mixalis.apointid = appointments[dataKey].id;
            } else if (appointments[dataKey].barberId === 2) {
              this.items[index].Andreas.name = appointments[dataKey].username;
              this.items[index].Andreas.type = appointments[dataKey].type;
              this.items[index].Andreas.apointid = appointments[dataKey].id;

            }
          }
        }
      }

    }

  },
  async beforeMount(){
    this.value=new Date();
    this.calendarDate = this.value;
    let dateString = this.value.getFullYear().toString() + "-" + (this.value.toLocaleString("default",{month: "2-digit"}) ) + "-" + this.value.toLocaleString("default",{day: "2-digit"})
    let fetchDates = this.fetchByDateApiCall( dateString);
    await fetchDates.then(response => {
      this.renderTheTable(response);
    })

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