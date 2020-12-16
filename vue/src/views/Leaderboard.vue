<template>
  <div>
    <view-tee-times />
    <scores />
  </div>
</template>
<script>
import Scores from "../components/Scores.vue";
import ViewTeeTimes from "../components/ViewTeeTimes.vue";

export default {
  name: "leaderboard",
  components: {
    Scores,
    ViewTeeTimes,
  },
};
</script>