<template>
  <div class="league">
    <h1>League Info</h1>
    <div v-for="leagues in league" v-bind:key="leagues.username">
      <p>{{ leagues.leagueName }}</p>
    </div>
    <div class="buttons">
      <button class="button" @click="navigate">LEADERBOARD</button>
      <create-league />
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

  methods: {
    created() {
      leagueService
        .viewLeaguesByUsername(this.$store.state.user.username)
        .then((response) => {
          this.league = response.data;
          console.log(response.data);
        });
    },
    navigate() {
      this.$router.push({ name: "leaderboard", params: { id: "DA BUS" } });
    },
  },
};
</script>

<style>
</style>