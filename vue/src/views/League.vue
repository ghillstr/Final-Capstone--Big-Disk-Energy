<template>
  <div class="league">
    <h1>League Info</h1>
    <pending-invites />
    <div class="leaderboards-sec">
      <h4>MY LEAGUES</h4>
      <div class="leaderboards-buttons">
        <div v-for="leagues in league" v-bind:key="leagues.username">
          <router-link
            class="anchor"
            v-bind:to="{
              name: 'leaderboard',
              params: { id: leagues.leagueName },
            }"
          >
            {{ leagues.leagueName }}
          </router-link>
        </div>
      </div>
      <!-- <button class="button" @click="navigate">LEADERBOARD</button> -->
    </div>
  </div>
</template>

<script>
import PendingInvites from "../components/PendingInvites.vue";
import leagueService from "../services/LeagueService";
export default {
  name: "league",
  components: {
    PendingInvites,
  },
  data() {
    return {
      league: [],
    };
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
      this.$router.push({ name: "score", params: { leagueName: "DA BUS" } });
    },
  },
};
</script>

<style scoped>
.button {
  height: 35px;
  width: 235px;
  justify-content: center;
}
.anchor:hover {
  text-decoration: none;
  text-align: center;
  color: #bc4749;
  font-style: italic;
}

.leaderboards-sec {
  margin-top: 10px;
}
.leaderboards-buttons {
  justify-content: center;
  background-color: white;
  outline: solid 2px;
  outline-color: #386641;
  margin-top: 15px;
  margin-bottom: 15px;
  padding-top: 5px;
}
.anchor {
  color: #386641;
  text-transform: uppercase;
  background-color: none;
  outline: none;
  text-decoration: none;
  font-size: 20px;
  font-weight: bold;
}
</style>