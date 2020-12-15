<template>
  <div>
        <div>
            <select name="recordscore" v-model="selectedUser" text="Select a Player">
            <option v-for="posts in post" v-bind:key="posts.username">{{ post.username }}</option>
            </select>
        </div>
        <div>
            <form> 
                <input type="text" placeholder="Enter a score">
            </form>
        </div>
        <div>
            <button class="button" type="submit">SUBMIT SCORE</button>
        </div>
   </div>     
</template>

<script>
import scoreService from "../services/ScoreService";
export default {
    name: "recordscore",
    data() {
        return {
            post: [],
        };
    },
    created() {
        scoreService.getUserByLeague(this.$route.params.scoreid).then((response) => {
      this.post = response.data;
      console.log(response.data);
        });
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
    }
    }
}
</script>

<style>

</style>