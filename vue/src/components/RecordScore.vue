<template>
  <div>
    <h4>RECORD SCORES FOR A LEAGUE</h4>
    <b-button class="button" v-b-toggle.record-collapse>RECORD</b-button>
    <b-collapse id="record-collapse">
      <div>
        <b-form-select
          @change="inputLeagueUser"
          v-model="score.leagueName"
          name="recordscore"
          text="Select a League"
          ><option value="" disabled selected hidden>SELECT A LEAGUE</option>
          <option v-for="league in leagues" v-bind:key="league.username">
            {{ league.leagueName }}
          </option>
        </b-form-select>
      </div>
      <div>
        <b-form-select
          v-model="score.username"
          name="recordscore"
          text="Select a Player"
        >
          <option value="" disabled selected hidden>SELECT A PLAYER</option>
          <option v-for="posts in post" v-bind:key="posts.username">
            {{ posts.username }}
          </option>
        </b-form-select>
      </div>

      <div>
        <b-form-input
          v-model="score.scoreTotal"
          type="number"
          placeholder="Enter a score"
        >
        </b-form-input>
      </div>
      <div>
        <button class="button" type="submit" @click="recordScore()">
          SUBMIT SCORE
        </button>
      </div>
    </b-collapse>
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
        scoreTotal: "",
      },
      showRecordScoreForm: false,
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
            this.resetForm();
          }
        })
        .catch((error) => {
          const response = error.response;
          if (response.status === 400) {
            this.invalidEntry = true;
          }
        });
    },
    showHideForm() {
      this.showRecordScoreForm = true;
    },
    resetForm() {
      this.score.scoreTotal = "";
    },
  },
};
</script>

<style scoped>
</style>