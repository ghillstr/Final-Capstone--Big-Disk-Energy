<template>
  <div>
    <h4>SET A TEE TIME FOR YOUR LEAGUE</h4>
    <div class="all-forms">
      <b-button class="button" v-b-toggle.teetime-collapse
        >SET TEE-TIME</b-button
      >
      <b-collapse id="teetime-collapse">
        <div>
          <p>SELECT A LEAGUE</p>
          <b-form-select
            @change="inputLeagueUser"
            v-model="teetime.leagueName"
            name="leaguetime"
            text="Select a League"
          >
            <option v-for="league in leagues" v-bind:key="league.leagueName">
              {{ league.leagueName }}
            </option>
          </b-form-select>
        </div>

        <div>
          <p>SELECT A PLAYER</p>
          <b-form-select
            v-model="teetime.username"
            name="playertime"
            text="Select a Player"
          >
            <option v-for="user in users" v-bind:key="user.username">
              {{ user.username }}
            </option>
          </b-form-select>
        </div>

        <div class="time-date-form">
          <label for="datepicker">SELECT A DATE TO PLAY</label>
          <b-form-datepicker
            id="example-datepicker"
            v-model="teetime.date"
            class="mb-2"
          ></b-form-datepicker>
          <label for="datepicker">SELECT A TIME TO PLAY</label>
          <b-form-input type="time" v-model="teetime.startTime"></b-form-input>
        </div>
        <div>
          <button class="button" type="submit" @click="setTheTime()">
            SET TEE-TIME
          </button>
        </div>
      </b-collapse>
    </div>
  </div>
</template>
<script>
import LeagueService from "../services/LeagueService";
import scoreService from "../services/ScoreService";
export default {
  name: "SetTeeTime",
  data() {
    return {
      users: [],
      leagues: [],
      teetime: {
        leagueName: "",
        username: "",
        date: "",
        startTime: "",
      },
    };
  },
  created() {
    LeagueService.viewLeaguesByUsername(this.$store.state.user.username).then(
      (response) => {
        this.leagues = response.data;
      }
    );
  },
  methods: {
    inputLeagueUser() {
      scoreService.getUserByLeague(this.teetime.leagueName).then((response) => {
        this.users = response.data;
      });
    },

    setTheTime() {
      LeagueService.setTeeTime(this.teetime)
        .then((response) => {
          if (response.status == 201) {
            this.$store.commit("SET_TIME", response.data.teetime);
            this.makeToast();
            // this.resetForm();
          }
        })
        .catch((error) => {
          const response = error.response;
          if (response.status === 400) {
            this.invalidEntry = true;
          }
        });
    },
    makeToast() {
      this.$bvToast.toast(`Your tee time has been scheduled! `, {
        title: "SUCCESS!",
        autoHideDelay: 5000,
        variant: "success",
        solid: true,
      });
    },
  },
};
</script>
