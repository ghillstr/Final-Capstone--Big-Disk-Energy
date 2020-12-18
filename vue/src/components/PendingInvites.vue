<template>
  <div>
    <h5>PENDING INVITES</h5>
    <div
      class="pending-invites"
      v-for="(invite, index) in invites"
      v-bind:key="invite.username"
    >
      <p class="join">Join {{ invite.leagueName }}?</p>
      <b-form-radio-group>
        <b-form-radio v-model="invites.statusId" name="some-radios" value="2"
          >Accept</b-form-radio
        >
        <b-form-radio v-model="invites.statusId" name="some-radios" value="3"
          >Reject</b-form-radio
        >
      </b-form-radio-group>
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
          this.$router.go(0);
        }
      });
    },
  },
};
</script>

<style scoped>
.join {
  font-weight: bold;
  color: white;
}
</style>