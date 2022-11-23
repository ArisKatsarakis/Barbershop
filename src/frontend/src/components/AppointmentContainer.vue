<template>
  <div>
    <b-card
        v-bind:title="$props.time"
        class="col-sm-12"
    >
      <b-card-body>
        <b-container>
          <b-row>
            <span style="background-color: black; color: whitesmoke"> Name: {{ $props.username }}</span>
          </b-row>
          <b-row>
            <span style="background-color: greenyellow; color: whitesmoke"> Type: {{ $props.type }}</span>
          </b-row>
          <b-button class="col-sm-12 btn-danger" @click="deleteAppointmentById($props.id)">
            <b-icon icon="trash-fill"></b-icon>
          </b-button>
        </b-container>

      </b-card-body>

    </b-card>
  </div>
</template>

<script>

export default {
  name: "AppointmentContainer",
  props: {
    username: null,
    date: null,
    time: null,
    barber: null,
    type: null,
    id: null

  },
  methods:{
    deleteAppointmentById(id){
      this.$emit('on-delete',id)

    }
  }

}
</script>

<style scoped>

</style>