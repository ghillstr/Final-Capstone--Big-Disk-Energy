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
          >Accept</b-form-radio
        >
        <b-form-radio
          v-model="invites.statusId"
          :aria-describedby="ariaDescribedby"
          name="some-radios"
          >Reject</b-form-radio
        >
      </b-form-group>
      <button class="button" type="submit" @click="updateInvite()">
        SUBMIT
      </button>
    </div>
  </div>
</template>

<script>
import leagueService from "../services/LeagueService";

export default {
  data() {
    return {
      invites: {
        statusId: "",
      },
    };
  },
  created() {
    leagueService
      .getPendingInvitesByUsername(this.$store.state.user.username)
      .then((response) => {
        this.invites = response.data;
      });
  },
};
</script>

<style scoped>
</style>