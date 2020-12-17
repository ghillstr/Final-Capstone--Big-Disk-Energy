<template>
  <div>
    <h3>Pending Invites:</h3>
    <div
      class="pending-invites"
      v-for="invite in invites"
      v-bind:key="invite.username"
    >
      <p>{{ invite.leagueName }}</p>
      <b-form-group v-slot="{ ariaDescribedby }">
        <b-form-radio
          v-model="invites.statusId"
          :aria-describedby="ariaDescribedby"
          name="some-radios"
          value="2"
          >Accept</b-form-radio
        >
        <b-form-radio
          v-model="invites.statusId"
          :aria-describedby="ariaDescribedby"
          name="some-radios"
          value="3"
          >Reject</b-form-radio
        >
      </b-form-group>
      <button class="button" type="submit" @click="updateTheInvite()">
        SUBMIT
      </button>
    </div>
  </div>
</template>

<script>
import LeagueService from "../services/LeagueService";

export default {
  data() {
    return {
      invites: {
        statusId: "",
      },
    };
  },
  created() {
    LeagueService.getPendingInvitesByUsername(
      this.$store.state.user.username
    ).then((response) => {
      this.invites = response.data;
    });
  },

  methods: {
    updateTheInvite() {
      LeagueService.updateInvite(this.invites).then((response) => {
        this.$store.commit("UPDATE_INVITE", response.data.invites);
      });
    },
  },
};
</script>

<style scoped>
</style>