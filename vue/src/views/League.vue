<template>
  <div class="league">
    <h1>League Info</h1>
    <div v-for="leagues in league" v-bind:key="leagues.username">
      <router-link
        v-bind:to="{ name: 'leaderboard', params: { id: leagues.leagueName } }"
      >
        {{ leagues.leagueName }}
      </router-link>
      <!-- <button class="button" @click="navigate">LEADERBOARD</button> -->
    </div>
    <create-league />
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
    //   this.$router.push({ name: "leaderboard", params: { id: "DA BUS" } });
    // },
  },
};
</script>

<style>
</style>