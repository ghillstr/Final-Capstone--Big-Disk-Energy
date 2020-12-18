<template>
  <div>
    <h1 class="league-name">{{ $route.params.id }}</h1>
    <h4>Upcoming Tee Times</h4>
    <div class="tee-times" v-for="times in teetime" v-bind:key="times.username">
      <p>{{ times.date }} | {{ times.startTime }}</p>
    </div>
  </div>
</template>

<script>
import leagueService from "../services/LeagueService";

export default {
  data() {
    return {
      teetime: [],
    };
  },
  created() {
    leagueService
      .viewTeeTimesByLeagueName(
        this.$store.state.user.username,
        this.$route.params.id
      )
      .then((response) => {
        this.teetime = response.data;
      });
  },
};
</script>
<style scoped>
p {
  font-weight: bold;
}
</style>
