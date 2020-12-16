<template>
  <div>
    <h3>Record Scores for a League</h3>
    <div>
      <select
        @change="inputLeagueUser"
        v-model="score.leagueName"
        name="recordscore"
        text="Select a League"
      >
        <option v-for="league in leagues" v-bind:key="league.username">
          {{ league.leagueName }}
        </option>
      </select>
    </div>
    <div>
      <select
        v-model="score.username"
        name="recordscore"
        text="Select a Player"
      >
        <option v-for="posts in post" v-bind:key="posts.username">
          {{ posts.username }}
        </option>
      </select>
    </div>
    <div>
      <form>
        <input
          v-model="score.scoreTotal"
          type="text"
          placeholder="Enter a score"
        />
      </form>
    </div>
    <div>
      <button class="button" type="submit" @click="recordScore()">
        SUBMIT SCORE
      </button>
    </div>
  </div>
</template>

<script>
import scoreService from "../services/ScoreService";
import LeagueService from "../services/LeagueService";

export default {
  name: "recordscore",
  data() {
    return {
      leagues: [],
      post: [],
      score: {
        leagueName: "",
        username: "",
        scoreTotal: 0,
      },
    };
  },
  created() {
    LeagueService.viewLeaguesByUsername(this.$store.state.user.username).then(
      (response) => {
        this.leagues = response.data;
      }
    );
  },
  methods: {
    inputLeagueUser() {
      scoreService.getUserByLeague(this.score.leagueName).then((response) => {
        this.post = response.data;
        console.log(response.data);
      });
    },
    recordScore() {
      scoreService
        .recordScore(this.score)
        .then((response) => {
          if (response.status == 201) {
            this.$store.commit("SET_SCORES", response.data.score);
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
      this.score.scoreTotal = 0;
    },
  },
};
</script>

<style>
</style>