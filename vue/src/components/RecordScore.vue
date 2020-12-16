<template>
  <div>
<<<<<<< HEAD
    <form name="RecordScore">
      <div>
        <select text="Select a Player" v-model="score.username">
          <option v-for="post in posts" v-bind:key="post.username">
            {{ post.username }}
          </option>
        </select>
      </div>
      <div>
        <input
          v-model="score.scoreTotal"
          value="0"
          type="number"
          placeholder="Enter a score"
        />
      </div>
      <div>
        <!-- <router-link to:="{ name: 'score', params: { leagues.league: this.$store.state.user.username }}">SUBMIT SCORE</router-link> -->
        <button
          class="button"
          type="submit"
          v-on:click.prevent="recordScore, resetForm"
        >
          SUBMIT SCORE
        </button>
      </div>
    </form>
=======
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
>>>>>>> c4e20d8ac8faec02e511fcc7a8cd3db7a43268da
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
<<<<<<< HEAD
        leagueName: "",
=======
        leagueName: "this.$store.state.league.leagueName",
>>>>>>> c4e20d8ac8faec02e511fcc7a8cd3db7a43268da
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
    resetForm() {
      this.score.scoreTotal = 0;
    },
  },
};
</script>
<style>
</style>