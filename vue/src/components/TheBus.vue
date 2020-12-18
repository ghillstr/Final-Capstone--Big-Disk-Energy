<template>
  <div class="container">
    <h2>The Developers</h2>
    <div id="bios" class="row">
      <div class="col">
        <img src="@/assets/Bob.png" id="bob" />
        <h4>Bob</h4>
      </div>
      <div class="col">
        <img src="@/assets/George.png" id="george" />
        <h4>George</h4>
      </div>
      <div class="col">
        <img src="@/assets/Kelsey.png" id="kelsey" />
        <h4>Kelsey</h4>
      </div>
      <div class="col">
        <img src="@/assets/Shane.png" id="shane" />
        <h4>Shane</h4>
      </div>
      <div class="col">
        <img src="@/assets/Becky.png" id="becky" />
        <h4>Becky</h4>
      </div>
    </div>
    <div id="bus-div" class="row">
      <p>
        The Struggle Bus Software, LLC team is dedicated to bringing quality
        products and amazing solutions to the table. They are all hard-working,
        creative people who support each other no matter what! You really
        couldn't ask for a better group of awesomeness!
      </p>
    </div>
  </div>
</template>


<script>
export default {
  name: "TheBus",
};
</script>

<style scoped>
#bob {
  height: 150px;
  width: 150px;
}

#george {
  height: 150px;
  width: 150px;
}

#kelsey {
  height: 150px;
  width: 150px;
}

#shane {
  height: 150px;
  width: 150px;
}

#becky {
  height: 150px;
  width: 150px;
}

#bus-div {
  background: white;
  outline: 2px;
  outline-style: ridge;
  outline-color: #386641;
  padding: 3px 3px 3px 3px;
  margin-top: 15px;
  margin-bottom: 20px;
}

h2 {
  font-family: "Permanent Marker", cursive;
  color: #386641;
  text-shadow: -1px -1px 0 #a7c957, 1px -1px 0 #a7c957, -1px 1px 0 black,
    1px 1px 0 black;
  margin: 30px 0px 50px 0px;
  text-decoration: none;
}

h4 {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  margin-top: 10px;
}
</style>