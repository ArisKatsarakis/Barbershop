<template>
  <b-container>
    <b-row>
      <b-col>
        <b-list-group v-for="app in appointments" :key="app.id">
          <b-list-group-item button>{{app.username}} Hour: {{app.time}}
            <b-button   variant="info" v-b-toggle="app.username"> Info </b-button>
            <b-collapse  v-bind:id="app.username" class="mt-2">
              <b-card>
                <p class="card-header"> Date: {{app.date}}</p>
                <p class="card-body">Type: {{app.type}}</p>

              </b-card>
            </b-collapse>
          </b-list-group-item>

        </b-list-group>
      </b-col>
      <b-col>
        <b-button v-on:click="getAppointments()"> Show Appointments</b-button>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <add-new-appointment/>
      </b-col>

    </b-row>
  </b-container>

</template>

<script>
import addNewAppointment from "@/components/AddNewAppointment";
export default {
  name: "DashBoard",
  components: {
    addNewAppointment
  },
  data() {
    return {
      appointments: []
    }
  },
  // mounted() {
  //   fetch("/api/v1/appointment")
  //   .then((response) => response.json())
  //   .then((data) => {
  //     this.appointments = data;
  //   });
  // },
  methods: {
      getAppointments() {
        fetch("/api/v1/appointment")
          .then((response) => response.json())
          .then((data) => {
            this.appointments = data;
          });

    }
  }

}
</script>

<style scoped>

</style>
