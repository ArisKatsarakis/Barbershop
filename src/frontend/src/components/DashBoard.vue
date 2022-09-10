<template>
  <b-container>

    <b-row>
      <b-col>
        <b-list-group v-for="(n,i) in timeslots.length" :key="i">
          <b-list-group-item  v-if="appointments[i] != null" button>
            <p>{{appointments[i].username}}</p>
            <b-button   variant="info" v-b-toggle="appointments[i].username"> Info </b-button>
            <b-collapse  v-bind:id="appointments[i].username" class="mt-2">
              <b-card>
                <p class="card-header"> Date: {{appointments[i].date}}</p>
                <p class="card-body">
                   Hour: {{appointments[i].time}}
                  Type: {{appointments[i].type}}</p>

              </b-card>
            </b-collapse>
          </b-list-group-item>
          <b-list-group-item  v-else button>
            <ButtoonAppointment
                v-bind:timeslot='timeslots[i]'
            />
          </b-list-group-item>
        </b-list-group>

      </b-col>

      <b-col>
        <b-button v-on:click="getAppointments()"> Show Appointments</b-button>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
      </b-col>

    </b-row>
    <b-row>
    <b-col>
      <h2>Mixalis:</h2>
        <b-row v-for="i in timeslots" :key="i" >
          <b-col class="col-lg-5"  v-if="i!=0">
          <ButtoonAppointment
              v-bind:timeslot='i.toString()'
          />
        </b-col>
          <b-col class="col-lg-5"  v-else>
            <b-card>
              <p class="card-header"> Date: {{i}}</p>
              <p class="card-body">Type: {{i}}</p>

            </b-card>
          </b-col>

    </b-row>
    </b-col>
    <b-col>
      <h2>Andreas:</h2>
      <b-row v-for="i in timeslots_andreas" :key="i" >
        <b-col class="col-lg-5" >
          <ButtoonAppointment
              v-bind:timeslot='i.toString()'
          />
        </b-col>
      </b-row>
    </b-col>
    </b-row>
  </b-container>

</template>

<script>
import ButtoonAppointment from "@/components/ButtoonAppointment";
export default {
  name: "DashBoard",
  components: {
    ButtoonAppointment
  },
  data() {
    return {
      appointments: [],
      timeslots: [
          "10:00:00",
        "11:00:00",
        "12:00:00",
        "13:00:00",
      ],
      timeslots_andreas: [
        "10:00:00",
        "11:00:00",
        "12:00:00",
        "13:00:00",
      ]
    }
  },
  methods: {
      getAppointments() {
        fetch("/api/v1/appointment")
          .then((response) => response.json())
          .then((data) => {
            console.log(data);
            this.appointments = data;
            console.log(this.appointments);
          });


    }
  },
  created() {

  }

}
</script>

<style scoped>

</style>
