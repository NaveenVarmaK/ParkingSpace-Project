<template>
  <ul class="nav nav-tabs" style="align-items: center;" >
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
      <SlotBoookings />
    </div>
    <div v-else>
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
      console.log('Parking Locations tab clicked!');
    },
    showCreateParkingSlots() {
      this.activeTab = 'createParking';
      console.log('Create Parking Slots tab clicked!');
    },
    showBookings() {
      this.activeTab = 'bookings';
      console.log('Bookings tab clicked!');
    },
    showUsers() {
      this.activeTab = 'Users';
      console.log('Users tab clicked!');
    },
  },
};
</script>
<style lang="scss">

</style>
