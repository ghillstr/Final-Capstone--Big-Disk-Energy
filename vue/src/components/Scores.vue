<template>
  <table>
    <thead>
      <tr>
        <th> <td>{{$route.params.id}}</td></th>
      </tr>
    </thead>
    <tbody>
<<<<<<< HEAD
=======
<<<<<<< HEAD
      <tr
        v-for="scores in score"
        v-bind:key="scores.leagueName"
        v-bind:="getAllScoresByLeagueName(score.leagueName)"
      >
        <!-- <td>{{ scoreleagueName }}</td> -->
        <td>{{ score.username }}</td>
        <td>{{ score.scoreTotal }}</td>
=======
>>>>>>> 737ed446a9ce2a248b72f2e18607ebe80b446cc9
      <tr v-for="scores in score" v-bind:key="scores.username">
       
        <td>{{ scores.username }}</td>
        <td>{{ scores.scoreTotal }}</td>
<<<<<<< HEAD
=======
>>>>>>> 734cfe0dff3d1ece5da06f9dc09afdd424d77bac
>>>>>>> 737ed446a9ce2a248b72f2e18607ebe80b446cc9
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