<template>
<b-container>
  <b-button id="show-btn" @click="$bvModal.show('bv-modal-example')"> Add Client</b-button>

  <b-modal id="bv-modal-example" hide-footer>
    <template #modal-title>
      New Client
    </template>
    <b-form @submit="addNewClient">
      <b-form-group
          id="inputGroupName"
          label="First Name"
          label-for="inputFirstName"
          description="Client's First Name"
      >
        <b-form-input
            id="inputFirstName"
            v-model="form.name"
            type="text"
            placeholder="Enter First Name"
            required
        ></b-form-input>
      </b-form-group>

      <b-form-group
        id="inputGroupLName"
        label="Last Name"
        label-for="inputLastName"
      >
        <b-form-input
        id="inputLastName"
        v-model="form.sirName"
        placeholder="Enter Last Name"
        type="text"
        required
        >

        </b-form-input>
      </b-form-group>
      <b-form-group
        id="inputGroupTelephone"
        label="Telephone Number:"
        label-for="inputTelephone"
      >
        <b-form-input
          id="inputTelphone"
          v-model="form.number"
          type="tel"
          placeholder="Type Client's Number"
          required
        >

        </b-form-input>

      </b-form-group>
        <b-button class="mt-3" block @click="$bvModal.hide('bv-modal-example')">Close</b-button>
        <b-button class="mt-3"  type="submit" block @click="$bvModal.hide('bv-modal-example') ">Submit Client</b-button>
    </b-form>



  </b-modal>
</b-container>
</template>

<script>
import axios from "axios";
export default {
  name: "addNewClient",
  data() {
    return {
      form: {
        name: null,
        sirName: null,
        number: null,
      }
    }
  },methods: {
    addNewClient() {
      let json = this.form;
      axios.post("api/v1/client/add",json).then( function (response) {
        console.log(response);
      })

    }
  }
}
</script>

<style scoped>

</style>