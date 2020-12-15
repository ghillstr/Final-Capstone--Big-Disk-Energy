<template>
  <table>
    <thead>
      <tr>
        <th>SCORES</th>
      </tr>
    </thead>
    <tbody>
      <tr
        v-for="scores in score"
        v-bind:key="scores.leagueName"
        v-bind:="getAllScoresByLeagueName(score.leagueName)"
      >
        <!-- <td>{{ scoreleagueName }}</td> -->
        <td>{{ score.username }}</td>
        <td>{{ score.scoreTotal }}</td>
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
      score: {
        // leagueName: "",
        username: "",
        scoreTotal: 0,
      },
    };
  },
  created() {
    scoreService
      .getAllScoresByLeagueName(this.$route.params.leagueName)
      .then((response) => {
        this.$store.commit("GET_LEAGUE_SCORES", response.data);
      });
  },
  methods: {
    getAllScoresByLeagueName(leagueName) {
      this.$router.push(`/leaderboard/${leagueName}`).catch(() => {});
    },
  },
};
</script>