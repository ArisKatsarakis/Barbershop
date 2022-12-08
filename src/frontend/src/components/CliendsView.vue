<template>
  <b-container>
   <b-table :items="this.clients" :fields="this.fields">
      <template #cell(Actions)="row">
        <b-button class="btn-danger btn-sm" @click="deleteClient(row.item.id);">
          <b-icon-x-lg></b-icon-x-lg>
        </b-button>
        <b-button class="btn-success btn-sm">
          <b-icon-pencil-fill> </b-icon-pencil-fill>
        </b-button>
        <b-button class="btn-info btn-sm" v-b-tooltip.bottom title="Show Client Info" @click="getClientInfo(row.item.id)">
          <b-icon-person-badge>
          </b-icon-person-badge>
        </b-button>
      </template>
   </b-table>
  <add-new-client>

  </add-new-client>
    <b-table :items="this.info"  :fields="this.infoFields">
    </b-table>
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
      fields: ['id','name', "sirName","Actions"],
      clients:[
      ],
      info:[],
      infoFields: ['id','username','type','date']
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
    },deleteClient(id) {
        console.log(id);
        let clients = this.clients;
        axios.delete('api/v1/client/delete/'+id).then(function (response) {
          console.log(response);
          let delClient = clients.find((o) => o.id == response.id);
          clients.splice(clients.indexOf(delClient),1);
        })
    },getClientInfo(id){
      this.info = [];
      let info = this.info;
      axios.get("api/v1/appoitnment/client/" + id).then( function (response) {
        console.log(response)
        for (let x in response.data) {
          // console.log(x)
          info.push(response.data[x])
        }
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