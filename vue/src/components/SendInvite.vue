<template>
  <div>
    <!-- <a href="create" v-on:click.prevent="showHideForm">CREATE LEAGUE</a> -->

    <!-- <form v-on:submit.prevent v-show="showTheCreateForm === true"> -->

    <h4>INVITE PLAYERS TO JOIN A LEAGUE</h4>
    <div>
      <b-button class="button" v-b-toggle.invite-collapse>
        INVITE PLAYER
      </b-button>
      <b-collapse id="invite-collapse">
        <div>
          <b-form-select v-model="invite.username">
            <option value="" disabled selected hidden>SELECT A PLAYER</option>
            <option v-for="users in user" v-bind:key="users.username">
              {{ users.username }}
            </option>
          </b-form-select>
        </div>
        <div class="form-element">
          <b-form-select v-model="invite.leagueName">
            <option value="" disabled selected hidden>SELECT A LEAGUE</option>
            <option v-for="league in leagues" v-bind:key="league.leagueName">
              {{ league.leagueName }}
            </option>
          </b-form-select>
        </div>
        <div>
          <button class="button" type="submit" @click="sendInvite()">
            SUBMIT INVITE
          </button>
        </div>
      </b-collapse>
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
        leagueName: "",
        username: "",
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
      LeagueService.invitePlayers(this.invite).then((response) => {
        this.$store.commit("SEND_INVITE", response.data.invite);
      });
    },
    refreshForm() {
      $("#creatives")
        .selectpicker("refresh")
        .empty()
        .append(output)
        .selectpicker("refresh")
        .trigger("change");
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