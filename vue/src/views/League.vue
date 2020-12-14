<template>
  <div class="league">
    <h1>League Info</h1>
    <div class="buttons">
      <!-- <button class="button" @click="$router.push('/')">HOME</button>
        <button class="button" @click="$router.push('courseinfo')">COURSE INFO</button>-->
      <button class="button" @click="$router.push('leaderboard')">
        LEADERBOARD
      </button>
      <create-league />
      <scores />
    </div>
  </div>
</template>

<script>
import CreateLeague from "../components/CreateLeague.vue";
import Scores from "../components/Scores.vue";
export default {
  name: "league",
  components: {
    CreateLeague,
    Scores,
  },
};
</script>

<style>
</style>