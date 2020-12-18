<template>
  <div id="app">
    <vue-confirm-dialog></vue-confirm-dialog>
    <nav
      class="navbar sticky-top navbar-expand-sm bg-dark justify-content-center"
    >
      <router-link v-bind:to="{ name: 'home' }">HOME</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'courseinfo' }">COURSES</router-link
      >&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'league' }">LEAGUES</router-link>
      <span class="pipe" v-if="rolePermission()">&nbsp;|&nbsp;</span>

      <router-link v-if="rolePermission()" v-bind:to="{ name: 'leagueadmin' }"
        >ADMIN</router-link
      >
      &nbsp;|&nbsp;
      <span class="rules" v-on:click="handleClick">
        OFFICAL DISC GOLF RULES</span
      >&nbsp;|&nbsp;<router-link v-bind:to="{ name: 'about-us' }"
        >ABOUT US</router-link
      >
      &nbsp;|&nbsp;
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >LOGOUT</router-link
      >
    </nav>
    <div class="usertag">
      <span class="usertag">Player: {{ this.$store.state.user.username }}</span>
      <span class="usertag" v-if="rolePermission()">
        - {{ this.$store.state.user.authorities[0].name }}
      </span>
    </div>
    <div class="container">
      <img
        src="@/assets/logo_transparent.png"
        id="BDE-logo"
        alt="BIG DISC ENERGY logo"
      />

      <div class="router">
        <router-view />
      </div>
    </div>
    <Footer />
  </div>
</template>
<script>
import Footer from "./components/Footer.vue";
export default {
  components: {
    Footer,
  },
  methods: {
    handleClick() {
      this.$confirm({
        message: `Would you like to be redirected to PDGA?`,
        button: {
          no: "No",
          yes: "Yes",
        },
        /**
         * Callback Function
         * @param {Boolean} confirm
         */
        callback: (confirm) => {
          if (confirm == true) {
            location = "https://www.pdga.com/rules";
          }
        },
      });
    },
    rolePermission() {
      if (
        this.$store.state.user &&
        this.$store.state.user.authorities &&
        this.$store.state.user.authorities[0].name != "ROLE_USER"
      ) {
        return true;
      }
      return false;
    },
  },
};
</script>
<style>
@import url("https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap");

#app {
  color: white;
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  background: rgb(106, 153, 78);
  background: linear-gradient(
    180deg,
    rgba(106, 153, 78, 1) 0%,
    rgba(167, 201, 87, 1) 55%,
    rgba(242, 232, 207, 1) 100%
  );
  text-align: center;
  width: 100%;
  height: 100%;
}
nav a,
span {
  color: white;
  text-decoration: underline;
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
nav a.router-link-exact-active {
  text-decoration-line: overline;
  text-decoration-color: #a7c957;
  color: #a7c957;
  font-weight: bolder;
}
nav a:hover {
  color: #bc4749;
}
span.rules:hover {
  color: #bc4749;
  cursor: pointer;
}
h1 {
  font-size: 70px;
  font-family: "Permanent Marker", cursive;
  color: #386641;
  text-shadow: -1px -1px 0 #a7c957, 1px -1px 0 #a7c957, -1px 1px 0 black,
    1px 1px 0 black;
}
h2,
h3,
h4,
h5 {
  color: #386641;

  font-weight: bold;
  text-decoration: underline overline;
  text-underline-position: under;
  text-decoration-color: #386641;
}
p,
label {
  color: #386641;
}
.container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}
#BDE-logo {
  width: 200px;
  height: 200px;
  display: flex;
  justify-content: left;
}
.account {
  font-size: larger;
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  font-weight: bolder;
  color: #bc4749;
}
.account:hover {
  color: white;
}
.button {
  background-color: white;
  color: #386641;
  border: 2px solid #386641;
  margin: 10px;
}
.button:hover {
  background-color: #a7c957;
  color: #bc4749;
}
span.pipe {
  text-decoration: none;
}
.usertag {
  color: white;
  text-decoration: none;
  font-style: italic;
}
</style>