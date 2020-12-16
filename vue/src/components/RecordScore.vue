<template>
  <div>
    <h3>Record Scores for a League</h3>
    <div>
<<<<<<< HEAD
      <select name="recordscore" text="Select a Player">
        <option v-for="posts in post" v-bind:key="posts.username">
          {{ posts.username }}
=======
      <select
        v-model="score.username"
        name="recordscore"
        text="Select a Player"
      >
        <option v-for="post in posts" v-bind:key="post.username">
          {{ post.username }}
>>>>>>> 19edeb2e612e4fe66eff29bf255b3415ffeae03f
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
      <button class="button" type="submit" @click="recordScore, resetForm">
        SUBMIT SCORE
      </button>
    </div>
  </div>
</template>
<script>
import scoreService from "../services/ScoreService";
export default {
  name: "RecordScore",
  data() {
    return {
      posts: [],
      score: {
        leagueName: "",
        username: "",
        scoreTotal: 0,
      },
    };
  },
  created() {
    scoreService
      .getUserByLeague(this.$route.params.leagueName)
      .then((response) => {
        this.posts = response.data;
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
          }
        })
        .catch((error) => {
          const response = error.response;
          if (response.status === 400) {
            this.invalidEntry = true;
          }
        });
    },
    // resetForm() {
    //   this.score.scoreTotal = 0;
    // },
  },
};
</script>
<style>
</style>