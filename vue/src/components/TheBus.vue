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
    <div id="bus-div" class="col">
      <p>
        BUS FOR LIFE BABYYYYYYYYYY
        hjdskhfjkdshfjdshfdhsjfhdsjfdlfhdsjhfdshfjdshajfdsf shfj
        dfsahjfdhsjkfhdshfjdsl hjkdsla sdjakfhdjk wow we are so cool
        wowowowowwowo hi hi hi hi hi hi hi ckksfjkfsdlfdlkdsa jsdhjf
        hjdskhfjkdshfjdshfdhsjfhdsjfdlfhdsjhfdshfjdshajfdsf
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

.media m-3 {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}
#bus-div {
  background: white;
  outline: 2px;
  outline-style: ridge;
  outline-color: #386641;
  padding: 3px 3px 3px 3px;
  margin-top: 15px;
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  margin-bottom: 20px;
}

h2 {
  font-family: "Permanent Marker", cursive;
  color: #386641;
  text-shadow: -1px -1px 0 #a7c957, 1px -1px 0 #a7c957, -1px 1px 0 black,
    1px 1px 0 black;
  margin: 30px 0px 50px 0px;
}

h4 {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  margin-top: 10px;
}
</style>