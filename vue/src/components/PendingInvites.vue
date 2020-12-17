<template>
  <div>
    <h3>Pending Invites:</h3>
    <div
      class="pending-invites"
      v-for="(invite, index) in invites"
      v-bind:key="invite.username"
    >
      <p>{{ invite.leagueName }}</p>
      <!-- <div>
        <b-form-select
          @change="updateInvite"
          v-model="invites.statusId"
          name="inviteStatusId"
        >
          <option value="2">Accept</option>
          <option value="3">Reject</option>
        </b-form-select>
        <button class="button" type="submit" @click="updateTheInvite()">
          SUBMIT
        </button>
      </div> -->

      <!-- <div class="btn-group" role="group" aria-label="Basic example">
        <button
          type="button"
          class="btn btn-secondary"
          @click="updateTheInvite()"
        >
          Accept
        </button>
        <button
          type="button"
          class="btn btn-secondary"
          @click="updateTheInvite()"
        >
          Reject
        </button>
      </div> -->

      <b-form-group v-slot="{ ariaDescribedby }">
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

      <!-- <b-form-checkbox
        id="checkbox-1"
        v-model="invites.statusId"
        name="checkbox-1"
        value="2"
        unchecked-value="3"
      >
        Accept Invitation
      </b-form-checkbox>

      <button class="button" type="submit" @click="updateTheInvite()">
        SUBMIT
      </button> -->
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