<template>
  <div class="league">
    <h1>League Info</h1>
    <div>
      <create-league />
    </div>
    <div class="leaderboards-sec">
      <h2>Your League Leaderboards</h2>
      <div
        class="leaderboards-buttons"
        v-for="leagues in league"
        v-bind:key="leagues.username"
      >
        <router-link
          class="anchor"
          tag="span"
          v-bind:to="{
            name: 'leaderboard',
            params: { id: leagues.leagueName },
          }"
        >
          <button class="button">{{ leagues.leagueName }}</button>
        </router-link>
          <button class="button" @click="scoresNav">RECORD SCORE</button>
      </div>
      <!-- <button class="button" @click="navigate">LEADERBOARD</button> -->
    </div>
  </div>
</template>

<script>
import CreateLeague from "../components/CreateLeague.vue";
import leagueService from "../services/LeagueService";
export default {
  name: "league",
  data() {
    return {
      league: [],
    };
  },
  components: {
    CreateLeague,
  },
  created() {
    leagueService
      .viewLeaguesByUsername(this.$store.state.user.username)
      .then((response) => {
        this.league = response.data;
        console.log(response.data);
      });
  },
  methods: {
    // navigate() {
    //   this.$router.push({ name: "leaderboard", params: { id: "hi" } });
    // },
    scoresNav() {
      this.$router.push({ name: "score", params: {leagueName: "DA BUS"}});
    }
  },
};
</script>

<style scoped>
.league {
  display: flexbox;
  justify-items: center;
}
.button {
  display: flex;
  flex-wrap: wrap;
  height: 35px;
  width: 235px;
  justify-content: center;
}
.anchor:hover {
  text-decoration: none;
  text-align: center;
}
.leaderboards-sec {
  display: flexbox;
  justify-self: center;
}
.leaderboards-buttons {
  display: flex;
  justify-content: center;
}
</style>