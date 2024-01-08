<template>
  <ul class="nav nav-tabs" style="align-items: center;">
    <li class="nav-item">
      <a class="nav-link" :class="{ active: activeTab === 'parking' }" href="#" @click="showParkingLocations">Parking Locations</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" :class="{ active: activeTab === 'createParking' }" href="#" @click="showCreateParkingSlots">Create Parking Slots</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" :class="{ active: activeTab === 'bookings' }" href="#" @click="showBookings">Bookings</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" :class="{ active: activeTab === 'Users' }" href="#" @click="showUsers">Users</a>
    </li>
    <div v-if="activeTab === 'parking'">
      <ParkingLocations />
    </div>
    <div v-else-if="activeTab === 'createParking'">
      <CreateParkingSlots />
    </div>
    <div v-else-if="activeTab === 'bookings'">
      <!-- Add your component for Bookings here -->
      <SlotBoookings />
    </div>
    <div v-else>
      <!-- Add your component for Users here -->
      <AppUsers />
    </div>
  </ul>
</template>

<script>
import ParkingLocations from './ParkingLocations.vue';
import CreateParkingSlots from './CreateParkingSlots.vue';
import SlotBoookings from './SlotBoookings.vue';
import AppUsers from './AppUsers.vue';

export default {
  name: 'MainNavigation',
  components: {
    ParkingLocations,
    CreateParkingSlots,
    SlotBoookings,
    AppUsers
  },
  data() {
    return {
      activeTab: 'parking', // Default active tab
    };
  },
  methods: {
    showParkingLocations() {
      this.activeTab = 'parking';
      // Your custom function logic here
      console.log('Parking Locations tab clicked!');
    },
    showCreateParkingSlots() {
      this.activeTab = 'createParking';
      // Your custom function logic here
      console.log('Create Parking Slots tab clicked!');
    },
    showBookings() {
      this.activeTab = 'bookings';
      // Your custom function logic here
      console.log('Bookings tab clicked!');
    },
    showUsers() {
      this.activeTab = 'Users';
      // Your custom function logic here
      console.log('Users tab clicked!');
    },
  },
};
</script>
<style lang="scss">

/* Add your styling here */
</style>






<!-- <template>
  <ul class="nav nav-tabs">
    <li class="nav-item">
      <a class="nav-link active" aria-current="page" href="#" ref="parkingLocations">Parking Locations</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#" tabindex="-1" aria-disabled="true" ref="rooms">Create Parking Slots</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#" tabindex="-1" aria-disabled="true" ref="rooms">Bookings</a>
    </li>
    <div v-if="activeTab === 'parking'">
      <ParkingLocations />
    </div>
    <div v-else>
      <CreateParkingSlots />
    </div>
  </ul>
</template>


<script>
import ParkingLocations from './ParkingLocations.vue'
import CreateParkingSlots from './CreateParkingSlots.vue';  

export default {
  name: 'MainNavigation',
  components: {
    ParkingLocations,
    CreateParkingSlots
  },
  data() {
    return {
      activeTab: 'parking', // Default active tab
    };
  },
  mounted() {
    // Access the first anchor tag using the ref
    const parkingLocationsNavLink = this.$refs.parkingLocations;
    const bookingsNavLink = this.$refs.rooms;

    // Attach a function to the onclick event
    parkingLocationsNavLink.addEventListener('click', this.showParkingLocations);
    bookingsNavLink.addEventListener('click', this.showBookings);
  },
  methods: {
    showParkingLocations() {
      this.activeTab = 'parking';
      // Your custom function logic here
      console.log('First anchor tag clicked!');
    },
    showBookings() {
      this.activeTab = 'bookings';
      // Your custom function logic here
      console.log('Second anchor tag clicked!');
    }

  }
}
</script> -->




<!-- <template>
    <ul class="nav nav-tabs">
      <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="#">Windows</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#" tabindex="-1" aria-disabled="true">Rooms</a>
      </li>
    </ul>
  </template>
  
  
  <script>
  export default {
    name: 'MainNavigation'
  }
  </script>
   -->