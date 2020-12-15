<template>
  <table>
    <thead>
      <tr>
        <th> <td>{{$route.params.id}}</td></th>
      </tr>
    </thead>
    <tbody>
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
      <tr v-for="scores in score" v-bind:key="scores.username">
       
        <td>{{ scores.username }}</td>
        <td>{{ scores.scoreTotal }}</td>
>>>>>>> 734cfe0dff3d1ece5da06f9dc09afdd424d77bac
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
<<<<<<< HEAD
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
=======
      score: [],
    };
  },
  created() {
    scoreService.list(this.$route.params.id).then((response) => {
      this.score = response.data;
      console.log(response.data);
    });
>>>>>>> 734cfe0dff3d1ece5da06f9dc09afdd424d77bac
  },
  // methods: {
  //   getAllScoresByLeagueName(leagueName) {
  //     this.$router.push(`/leaderboard/${leagueName}`);
  //   },
  // },
};
</script>