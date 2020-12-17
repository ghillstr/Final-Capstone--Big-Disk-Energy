<template>
  <div>
    <table>
      <thead>
        <th>PLAYERS</th>
        <th>TOTAL SCORE</th>
      </thead>
      <tbody class="leaderboard-table">
        <tr v-for="scores in score" v-bind:key="scores.username">
          <td class="score-user">{{ scores.username }}</td>
          <td class="score-total">{{ scores.scoreTotal }}</td>
        </tr>
      </tbody>
    </table>
    <button class="button" @click="$router.push('/league')">
      BACK TO LEAGUES
    </button>
  </div>
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
th {
  background: #a7c957;
}
table,
th,
td {
  border: solid 2px black;
  width: 300px;
  padding: 5px 5px 5px 5px;
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #386641;
}
.leaderboard-table {
  border: solid 2px black;
  font-size: 20px;
  background: white;
}
.score-user {
  text-align: left;
}
.score-total {
  text-align: right;
}
</style>