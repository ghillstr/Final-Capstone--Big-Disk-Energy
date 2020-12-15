<template>
  <div class="league">
    <h1>League Info</h1>
    <div class="buttons">
      <!-- <button class="button" @click="$router.push('/')">HOME</button>
        <button class="button" @click="$router.push('courseinfo')">COURSE INFO</button>-->
      <button class="button" @click="navigate">LEADERBOARD</button>
      <button class="button" @click="scoresNav">RECORD SCORE</button>
      <create-league />
    </div>
  </div>
</template>

<script>
import CreateLeague from "../components/CreateLeague.vue";
export default {
  name: "league",
  components: {
    CreateLeague,
  },
  methods: {
    navigate() {
      this.$router.push({ name: "leaderboard", params: { id: "DA BUS" } });
    },
    scoresNav() {
      this.$router.push({ name: "score", params: {user: "DA BUS"}});
    }
  },
};
</script>

<style>
</style>