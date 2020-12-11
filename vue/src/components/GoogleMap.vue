
<template>
  <div class="row">
    <div class="col-sm-">
      <form class="map-input">
        <div>
          <div>
            <div class="form-group">
              <input
                type="text"
                placeholder="Enter your address"
                v-model="adress"
                id="autocomplete"
              />
              <i
                class="fas fa-map-marker-alt"
                @click="locatorButtonPressed"
              ></i>
            </div>
          </div>
          <div class="field">
            <div class="two fields">
              <div class="field">
                <select v-model="keyword">
                  <option value="disc+golf+courses">Disc Golf Courses</option>
                </select>
              </div>
              <div class="field">
                <select v-model="radius">
                  <option value="5">5 KM</option>
                  <option value="10">10 KM</option>
                  <option value="15">15 KM</option>
                  <option value="20">20 KM</option>
                </select>
              </div>
            </div>
          </div>

          <button class="button" @click="findCoursesButtonPressed">
            Find Disc Golf Courses
          </button>
        </div>
      </form>
      <div class="container">
        <div class="container">
          <div v-for="place in places" :key="place.id">
            <div class="content">
              <div class="place-name">{{ place.name }}</div>
              <div>{{ place.vicinity }}</div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md" ref="map"></div>
  </div>
</template>
<script>
import axios from "axios";

export default {
  name: "google-map",
  data() {
    return {
      lat: 0,
      lng: 0,
      keyword: "",
      radius: "",
      places: [],
    };
  },
  mounted() {
    new google.maps.places.Autocomplete(
      document.getElementById("autocomplete")
    );
  },
  // computed: {
  //     coordinates() {
  //       return `${this.lat}, ${this.lng}`;
  //     }
  // },
  methods: {
    locatorButtonPressed() {
      // navigator.geolocation.getCurrentPosition(
      //   position => {
      //     this.lat = position.coords.latitude;
      //     this.lng = position.coords.longitude;
      //   },
      // );
    },
    findCoursesButtonPressed() {
      const URL = `https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=${
        this.lat
      },${this.lng}&radius=${this.radius * 1000}&keyword=${
        this.keyword
      }&key=AIzaSyCCyrduegSWX3B-qkVek8emISje8SDvv6E`;
      axios
        .get(URL)
        .then((response) => {
          this.places = response.data.results;
          this.addLocationsToGoogleMaps();
        })
        .catch((error) => {
          console.log(error.message);
        });
    },
    addLocationsToGoogleMaps() {
      var map = new google.maps.Map(this.$refs["map"], {
        zoom: 15,
        center: new google.maps.LatLng(this.lat, this.lng),
        mapTypeId: google.maps.MapTypeId.ROADMAP,
      });
      var infowindow = new google.maps.InfoWindow();
      this.places.forEach((place) => {
        const lat = place.geometry.location.lat;
        const lng = place.geometry.location.lng;
        let marker = new google.maps.Marker({
          position: new google.maps.LatLng(lat, lng),
          map: map,
        });
        google.maps.event.addListener(marker, "click", () => {
          infowindow.setContent(
            `<div class="place-name">${place.name}</div><p>${place.vicinity}</p>`
          );
          infowindow.open(map, marker);
        });
      });
    },
  },
};
</script>


