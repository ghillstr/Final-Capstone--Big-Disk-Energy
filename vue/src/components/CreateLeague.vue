<template>
  <div>
    <a href="create" v-on:click.prevent="showHideForm" v>CREATE LEAGUE</a>

    <div class="form-group pt-3">
      <form
        v-on:submit.prevent="createLeague"
        v-show="showTheCreateForm === true"
      >
        <div class="form-element">
          <label for="leagueName">League Name:</label>
          <input
            type="text"
            class="form-control"
            placeholder="Enter a League Name"
            id="league-name"
          />
        </div>
        <div class="form-element">
          <label for="courseName">Course Name:</label>
          <input
            type="text"
            class="form-control"
            placeholder="Enter a Course Name"
            id="course-name"
          />
        </div>
        <button class="button" type="submit">CREATE</button>
        <button class="button" v-on:click.prevent="resetForm">CANCEL</button>
      </form>
    </div>
  </div>
</template>
<script>
export default {
  name: "CreateLeague",
  data() {
    return {
      newLeague: {
        leagueName: "",
        courseName: "",
      },
      showTheCreateForm: false,
      showTheAnchor: true,
    };
  },
  methods: {
    resetForm() {
      this.newLeague = {
        leagueName: "",
        courseName: "",
      };
      this.showTheCreateForm = false;
    },
    showHideForm() {
      this.showTheCreateForm = true;
      this.showTheAnchor = false;
    },
    showHideAnchor() {
      this.showTheAnchor = false;
    },
  },
};
</script>
<style scoped>
#form-group {
  margin-top: 20px;
}
a {
  background-color: white;
  color: #386641;
  border: 2px solid #386641;
  padding: 5px 53px 5px 53px;
}
a:hover {
  background-color: #a7c957;
  color: #bc4749;
  text-decoration: none;
}
</style>