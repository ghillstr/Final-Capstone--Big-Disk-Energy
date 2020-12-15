
<template>
  <div>
    <div>
      <h4>Search for a course and add a pin</h4>
      <label>
        <gmap-autocomplete
          input
          type="text"
          value="Disc Golf Course"
        ></gmap-autocomplete>
        <button class="button" @click="addMarker">Add</button>
      </label>
      <br />
    </div>
    <br />
    <gmap-map
      ref="gmap"
      :center="center"
      :zoom="12"
      style="width: 100%; height: 400px"
    >
      <gmap-marker
        :key="index"
        v-for="(m, index) in markers"
        :position="m.position"
        @click="(center = m.position), openInfoWindowTemplate(index)"
      ></gmap-marker>
      <gmap-info-window
        :options="infoOptions"
        :postion="infoWindowPos"
        :opened="infoWinOpen"
        @closeclick="infoWinOpen = false"
        ><div v-html="infoContent"></div
      ></gmap-info-window>
    </gmap-map>
  </div>
</template>

<script>
export default {
  name: "GoogleMap",
  data() {
    return {
      center: { lat: 0, lng: 0 },
      markers: [],
      places: [],
      currentPlace: null,
      infoContent: "",
      infoWindowPos: {
        lat: 0,
        lng: 0,
      },
      infoWindow: false,
      currentMidx: null,
      infoOptions: {
        pixelOffset: {
          width: 0,
          height: -35,
        },
      },
    };
  },

  mounted() {
    this.geolocate();
  },

  methods: {
    setPlace(place) {
      this.currentPlace = place;
    },
    addMarker() {
      if (this.currentPlace) {
        const marker = {
          lat: this.currentPlace.geometry.location.lat(),
          lng: this.currentPlace.geometry.location.lng(),
        };
        this.markers.push({ position: marker });
        this.places.push(this.currentPlace);
        this.center = marker;
        this.currentPlace = null;
      }
    },
    geolocate: function () {
      navigator.geolocation.getCurrentPosition((position) => {
        this.center = {
          lat: position.coords.latitude,
          lng: position.coords.longitude,
        };
      });
    },
    toggleInfoWindow: function (marker, idx) {
      this.infoWindowPos = marker.position;
      this.infoContent = this.getInfoWindowContent(marker);

      if (this.currentMidx == idx) {
        this.infoWinOpen = !this.infoWinOpen;
      } else {
        this.infoWinOpen = true;
        this.currentMidx = idx;
      }
    },
    getInfoWindowContent: function (marker) {
      return `<div class="">
          <div>
            <div>
              <div class="m-2"><span style="font-weight: bold;">Device Name: </span>
                ${marker.name}
              </div>
            </div>
            <div class="m-2"><span style="font-weight: bold;">Location:  </span>
              ${marker.location}
              <br>
            </div>
          </div>
        </div>`;
    },
  },
};
</script>
