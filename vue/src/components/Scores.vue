<template>
  <table>
    <thead>
      <tr>
        <th> <td>{{$route.params.id}}</td></th>
      </tr>
    </thead>
    <tbody>
      <tr
        v-for="scores in score"
        v-bind:key="scores.leagueName"
        v-bind:="getAllScoresByLeagueName(score.leagueName)"
      >
        <td>{{ scores.username }}</td>
        <td>{{ scores.scoreTotal }}</td>

      </tr>
    </tbody>
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