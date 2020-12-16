<template>
  <div>
            <form name="RecordScore">
        <div>
            <select text="Select a Player" v-model="score.username">
            <option v-for="post in post" v-bind:key="post.username" >{{ post.username }}</option>
            </select>
        </div>
        <div>
             
                <input v-model="score.scoreTotal" type="number" placeholder="Enter a score">
        </div>
        <div>
            <!-- <router-link to:="{ name: 'score', params: { leagues.league: this.$store.state.user.username }}">SUBMIT SCORE</router-link> -->
            <button class="button" type="submit" v-on:click.prevent="recordScore()">SUBMIT SCORE</button>
        </div>
            </form>
   </div>     
</template>

<script>
import scoreService from "../services/ScoreService";
export default {
    name: "RecordScore",
    data() {
        return {
            post: [],
            score: {
                leagueName: this.$store.state.league.leagueName,
                username: "",
                scoreTotal: 0,

            }
        };
    },
    created() {
        scoreService.getUserByLeague(this.$route.params.league).then((response) => {
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
    }
    }
}
</script>

<style>

</style>