<template>
  <div>

    <b-modal size="md"  v-bind:id="form.time + form.barberId" hide-footer>
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
            <option v-for="(client) in this.clients" :key="client.id">{{client.name}} {{client.sirName}}</option>
          </datalist>

        </b-form-group>
        <b-form-group v-if="showNew">
          <label for="newName">New Clients Name</label>
          <b-form-input
              class="mb-2 me-sm-2 mb-sm-0"
              id="newName"
              type="text"
              v-model="client.name"
              placeholder="Clients Name">
          </b-form-input>
          <label for="newlName">New Clients Last Name</label>
          <b-form-input
              class="mb-2 me-sm-2 mb-sm-0"
              id="newlName"
              type="text"
              v-model="client.sirName"
              placeholder="Clients Last Name">
          </b-form-input>

          <label for="newPhone">New Clients Phone</label>
          <b-form-input
              class="mb-2 me-sm-2 mb-sm-0"
              id="newPhone"
              type="text"
              v-model="client.number"
              placeholder="Clients Phone">
          </b-form-input>

        </b-form-group>

        <b-form-group>
          <label class="mb-2 me-sm-2 mb-sm-0" for="type">Type: </label>
          <b-form-select
              id="type"
              class="mb-2 me-sm-2 mb-sm-0"
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
          <b-button type="submit" variant="primary" >Add New</b-button>

      </b-form>


    </b-modal>
    <add-new-client
        v-bind:visible="showNew"
    hidden></add-new-client>
  </div>


</template>

<script>
import axios from "axios";
import addNewClient from "@/components/addNewClient";
export default {
  name: "AddNewAppointment",
  components: {
    addNewClient
  },
  props: {
    setTime: String,
    setDate: String,
    setBarber:Number,
    setSlot:String
  },data() {
    return {
      form: {
        username: '',
        date: new Date(this.setDate),
        time: this.setTime,
        type: '',
        barberId:this.setBarber,
        clientId: null
      },
      client: {
        name: null,
        sirName: null,
        number: null
      },
      types: [{ text: "Select one" , value:  null} , "Mousia", "Malli" , "Malli  + Mousia"],
      timeslot: this.setSlot,
      clients: [],
      showNew: false
    }
  },
  watch: {
    form: {
      deep: true,
      handler(old, new_name) {
        if (new_name.username == "Add New") {
          console.log('yes')
          this.showNew = true;
        }

      }
    }
  },
  methods: {
    async onSubmit(event) {
      event.preventDefault();
      let appForm = this.form
      console.log(appForm)

      if (this.form.username == 'Add New') {
        let clientJson = this.client;
        console.log(this.form)
        let newClient = this.createNewClient(clientJson);
        await newClient.then(function (response) {
            console.log(response);
            let  data = response.data;
            appForm.clientId = data.id;
            appForm.username = `${data.name} ${data.sirName}`;
        })
      }else {
        let allClients = this.clients;
        let client = allClients.find((o) => o.name == appForm.username.split(" ")[0] && o.sirName == appForm.username.split((' '))[1])
        appForm.clientId = client.id;
      }
      this.$emit('update-app', JSON.stringify(appForm));

      // console.log(data);
      //
    },createNewClient(response) {
      return axios.post("api/v1/client/add",response);
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