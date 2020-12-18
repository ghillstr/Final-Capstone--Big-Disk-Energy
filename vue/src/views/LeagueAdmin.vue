<template>
  <div class="leagueAdmin">
    <h1>Admin</h1>
    <div>
      <create-league />
      <send-invite />
      <set-tee-times />
      <record-score />
    </div>
  </div>
</template>
<script>
import CreateLeague from "../components/CreateLeague.vue";
import SendInvite from "../components/SendInvite.vue";
import RecordScore from "../components/RecordScore.vue";
import SetTeeTimes from "../components/SetTeeTimes.vue";
export default {
  name: "league-admin",
  components: {
    CreateLeague,
    SendInvite,
    RecordScore,
    SetTeeTimes,
  },
};
</script>