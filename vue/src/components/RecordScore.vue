<template>
  <div>
    <div>
      <b-dropdown text="Select a Player">
        <b-dropdown-item href="#">An item</b-dropdown-item>
        <b-dropdown-item href="#">Another item</b-dropdown-item>
      </b-dropdown>
    </div>
  </div>
</template>

<script>
import scoreService from "../services/ScoreService";
export default {
  name: "RecordScore",
  data() {
    return {
      post: {
        username: this.$store.state.user.username,
        leagueName: "",
        scoreTotal: "",
      },
    };
  },
  methods: {
    recordScore() {
      scoreService
        .recordScore(this.post)
        .then((response) => {
          if (response.status == 201) {
            this.$store.commit("SET_SCORE", response.data.post);
            this.$router.push("/score");
          }
        })
        .catch((error) => {
          const response = error.response;
          if (response.status === 400) {
            this.invalidEntry = true;
          }
        });
    },
  },
};
</script>

<style>
</style>