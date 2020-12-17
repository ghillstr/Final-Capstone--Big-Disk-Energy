<template>
  <div>
    <h3>Pending Invites:</h3>
    <div
      class="pending-invites"
      v-for="(invite, index) in invites"
      v-bind:key="invite.username"
    >
      <p>{{ invite.leagueName }}</p>

      <b-form-group>
        <b-form-radio
          v-model="invites[index].statusId"
          :aria-describedby="accept / reject"
          value="2"
          >Accept</b-form-radio
        >
        <b-form-radio
          v-model="invites[index].statusId"
          :aria-describedby="accept / reject"
          value="3"
          >Reject</b-form-radio
        >
      </b-form-group>
      <button class="button" type="submit" @click="updateTheInvite(invite)">
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
      invites: [],
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
    updateTheInvite(invite) {
      LeagueService.updateInvite(invite).then((response) => {
        if (response.status == 200) {
          this.invites = this.invites.filter((x) => {
            return x.leagueName != invite.leagueName;
          });
        }
      });
    },
  },
};
</script>

<style scoped>
</style>