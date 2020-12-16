<template>
  <div>
    <!-- <a href="create" v-on:click.prevent="showHideForm">CREATE LEAGUE</a> -->

    <div>
      <!-- <form v-on:submit.prevent v-show="showTheCreateForm === true"> -->
      <h3>INVITE PLAYERS TO JOIN A LEAGUE</h3>
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
        <select>
          <option v-for="league in leagues" v-bind:key="league.leagueName">
            {{ league.leagueName }}
          </option>
        </select>
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
    };
  },
  created() {
    UserService.findAll().then((response) => {
      this.user = response.data;
      console.log(response.data);
    });
    LeagueService.getAllLeagues().then((response) => {
      this.leagues = response.data;
    });
  },
  //   league: {
  //     username: this.$store.state.user.username,
  //     leagueName: "",
  //     courseName: "",
  //   },
  //   showTheCreateForm: false,
  //   showTheAnchor: true,
  // };

  //   methods: {
  //     createLeague() {
  //       leagueService
  //         .createLeague(this.league)
  //         .then((response) => {
  //           if (response.status == 201) {
  //             this.$store.commit("SET_LEAGUE", response.data.league);
  //             this.$router.push("/league");
  //           }
  //         })
  //         .catch((error) => {
  //           const response = error.response;
  //           if (response.status === 400) {
  //             this.invalidEntry = true;
  //           }
  //         });
  //     },
  //     resetForm() {
  //       this.league = {};
  //       this.showTheCreateForm = false;
  //     },
  //     showHideForm() {
  //       this.showTheCreateForm = true;
  //       this.showTheAnchor = false;
  //     },
  //     showHideAnchor() {
  //       this.showTheAnchor = false;
  //     },
  //     makeToast(variant = null) {
  //       this.toastCount++;
  //       this.$bvToast.toast(`The score has been set!`, {
  //         title: "Updated Leaderboard",
  //         autoHideDelay: 5000,
  //         variant: variant,
  //         solid: true,
  //       });
  //     },
  //   },
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