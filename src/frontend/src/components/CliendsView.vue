<template>
  <b-container>
   <b-table :items="this.clients">

   </b-table>
  <add-new-client>

  </add-new-client>
  </b-container>
</template>
<script>
import axios from "axios";
import addNewClient from "@/components/addNewClient";
export default {
  name: "CliendsView",
  components: {
    addNewClient
  },

  data() {
    return {
      clients:[
      ]
    }
  },methods: {
    addNewClient() {
      let newClients = this.clients;
      const config = {
        "name": "Kostis",
        "sirName": "Manousakis",
        'number': "69845433355"
      }
      axios.post("api/v1/client/add",config).then(function (response) {
        newClients.push(response.data);
      })
    }

  },async beforeMount() {
    let newClients = this.clients;
    axios.get("api/v1/client").then(function (response) {
      response.data.forEach(client => newClients.push(client))
    })
  }

}
</script>

<style scoped>

</style>