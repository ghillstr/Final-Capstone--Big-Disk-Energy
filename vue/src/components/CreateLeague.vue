<template>
  <div>
    <a href="create" v-on:click.prevent="showHideForm">CREATE LEAGUE</a>

    <div class="form-group pt-3">
      <form v-on:submit.prevent v-show="showTheCreateForm === true">
        <!-- <div class="alert alert-danger" role="alert" v-if="invalidEntry">
          Ah ah ah! You didn't say the magic word!
        </div> -->
        <div class="form-element">
          <label for="leagueName">League Name:</label>
          <input
            type="text"
            class="form-control"
            placeholder="Enter a League Name"
            id="league-name"
            v-model="league.leagueName"
            required
          />
        </div>
        <div class="form-element">
          <label for="courseName">Course Name:</label>
          <input
            type="text"
            class="form-control"
            placeholder="Enter a Course Name"
            id="course-name"
            v-model="league.courseName"
            required
          />
        </div>
        <button
          type="submit"
          variant="success"
          class="button"
          v-on:click="createLeague(), resetForm(), makeToast('success')"
        >
          CREATE
        </button>
        <button class="button" v-on:click.prevent="resetForm()">CANCEL</button>
      </form>
    </div>
  </div>
</template>
<script>
import leagueService from "../services/LeagueService";
export default {
  name: "CreateLeague",
  data() {
    return {
      league: {
        username: this.$store.state.user.username,
        leagueName: "",
        courseName: "",
      },
      showTheCreateForm: false,
      showTheAnchor: true,
    };
  },
  methods: {
    createLeague() {
      leagueService
        .createLeague(this.league)
        .then((response) => {
          if (response.status == 201) {
            this.$store.commit("SET_LEAGUE", response.data.league);
            this.$router.push("/league");
          }
        })
        .catch((error) => {
          const response = error.response;
          if (response.status === 400) {
            this.invalidEntry = true;
          }
        });
    },
    resetForm() {
      this.league = {};
      this.showTheCreateForm = false;
    },
    showHideForm() {
      this.showTheCreateForm = true;
      this.showTheAnchor = false;
    },
    showHideAnchor() {
      this.showTheAnchor = false;
    },
    makeToast(variant = null) {
      this.toastCount++;
      this.$bvToast.toast(`League has been created!`, {
        title: "Successful Registration",
        autoHideDelay: 5000,
        variant: variant,
        solid: true,
      });
    },
  },
};
</script>
<style scoped>
.form-group {
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