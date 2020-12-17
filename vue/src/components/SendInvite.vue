<template>
  <div>
    <!-- <a href="create" v-on:click.prevent="showHideForm">CREATE LEAGUE</a> -->

    <!-- <form v-on:submit.prevent v-show="showTheCreateForm === true"> -->

    <h3>INVITE PLAYERS TO JOIN A LEAGUE</h3>
    <div>
      <div class="form-element">
        <label for="sendUsername">Username:</label>
        <select text="Select a User">
          <option v-for="users in user" v-bind:key="users.username">
            {{ users.username }}
          </option>
        </select>
      </div>
      <div class="form-element">
        <label for="sendLeague">League Name:</label>
        <select v-model="invite.username">
          <option v-for="league in leagues" v-bind:key="league.leagueName">
            {{ league.leagueName }}
          </option>
        </select>
      </div>
      <div>
        <button class="button" type="submit" @click="sendInvite()">
          INVITE PLAYER
        </button>
      </div>
    </div>
  </div>
</template>
<script>
import UserService from "../services/UserService";
import LeagueService from "../services/LeagueService";
export default {
  name: "CreateLeague",
  data() {
    return {
      user: [],
      leagues: [],
      invite: {
        username: "",
        leagueName: "",
        statusId: 1,
      },
    };
  },
  created() {
    UserService.findAll().then((response) => {
      this.user = response.data;
    });
    LeagueService.getAllLeagues().then((response) => {
      this.leagues = response.data;
    });
  },

  methods: {
    sendInvite() {
      LeagueService.invitePlayers(this.invite)
        .then((response) => {
          if (response.status == 201) {
            this.$store.commit("SEND_INVITE", response.data.invite);
          }
        })
        .catch((error) => {
          const response = error.response;
          if (response.status === 400) {
            this.invalidEntry = true;
          }
        });
    },
  },
};
</script>
<style scoped>
#form-group {
  margin-top: 20px;
}
a {
  background-color: white;
  color: #386641;
  border: 2px solid #386641;
  padding: 5px 53px 5px 53px;
}
a:hover {
  background-color: #a7c957;
  color: #bc4749;
  text-decoration: none;
}
</style>