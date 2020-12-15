<template>
  <table class="leaderboard-table">
    <thead>
      <tr>
        <th class="league-name">{{ $route.params.id }}</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="scores in score" v-bind:key="scores.username">
        <td>{{ scores.username }}</td>
        <td>{{ scores.scoreTotal }}</td>
      </tr>
    </tbody>
    <p>hello</p>
  </table>
</template>

 <script>
import scoreService from "../services/ScoreService.js";

export default {
  name: "scores",

  data() {
    return {
      score: [],
    };
  },
  created() {
    scoreService.list(this.$route.params.id).then((response) => {
      this.score = response.data;
      console.log(response.data);
    });
  },
  // methods: {
  //   getAllScoresByLeagueName(leagueName) {
  //     this.$router.push(`/leaderboard/${leagueName}`);
  //   },
  // },
};
</script>
<style scoped>
.leaderboard-table {
  border-collapse: 2px black;
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: white;
  font-size: 20px;
}
.league-name {
  font-family: "Permanent Marker", cursive;
  color: #386641;
  text-shadow: -1px -1px 0 #a7c957, 1px -1px 0 #a7c957, -1px 1px 0 black,
    1px 1px 0 black;
  font-size: 30px;
}
</style>