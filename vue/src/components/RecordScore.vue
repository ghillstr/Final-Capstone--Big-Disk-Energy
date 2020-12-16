<template>
  <div>
    <h3>Record Scores for a League</h3>
    <div>
      <select name="recordscore" text="Select a Player">
        <option v-for="post in post" v-bind:key="post.username">
          {{ post.username }}
        </option>
      </select>
    </div>
    <div>
      <form>
        <input type="text" placeholder="Enter a score" />
      </form>
    </div>
    <div>
      <button class="button" type="submit" @click="recordScore(), resetForm()">
        SUBMIT SCORE
      </button>
    </div>
  </div>
</template>

<script>
import scoreService from "../services/ScoreService";
export default {
  name: "recordscore",
  data() {
    return {
      post: [],
      score: {
        leagueName: "this.$store.state.league.leagueName",
        username: "",
        scoreTotal: 0,
      },
    };
  },
  created() {
    scoreService.getUserByLeague(this.$route.params.user).then((response) => {
      this.post = response.data;
      console.log(response.data);
    });
  },
  methods: {
    recordScore() {
      scoreService
        .recordScore(this.score)
        .then((response) => {
          if (response.status == 201) {
            this.$store.commit("SET_SCORES", response.data.score);
            this.$router.push("/score");
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