<template>
  <!-- <div> -->
  <ul class="nav nav-tabs">
    <li class="nav-item">
      <a class="nav-link" :class="{ active: activeTab === 'login' }" href="#" @click="showLoginPage" :style="{ color: activeTab === 'login' ? ' #5c6ac4' : 'white' }">Login</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" :class="{ active: activeTab === 'registration' }" href="#" @click="showRegistration" :style="{ color: activeTab === 'registration' ? ' #5c6ac4' : 'white' }">Registration</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" :class="{ active: activeTab === 'parking' }" href="#" @click="showNewParkingLocations" :style="{ color: activeTab === 'parking' ? ' #5c6ac4' : 'white' }">Parking Locations</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" :class="{ active: activeTab === 'createParking' }" href="#" @click="showCreateParkingSlots" :style="{ color: activeTab === 'createParking' ? ' #5c6ac4' : 'white' }">Create Parking Slots</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" :class="{ active: activeTab === 'bookings' }" href="#" @click="showBookings" :style="{ color: activeTab === 'bookings' ? ' #5c6ac4' : 'white' }">Bookings</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" :class="{ active: activeTab === 'Users' }" href="#" @click="showUsers" :style="{ color: activeTab === 'Users' ? ' #5c6ac4' : 'white' }">Users</a>
    </li>
    <div v-if="activeTab === 'login'">
      <LoginPage />
    </div>
    <div v-else-if="activeTab === 'registration'">
      <RegistrationPage />
    </div>
    <div v-if="activeTab === 'parking'">
      <NewParkingLocations />
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
import NewParkingLocations from './NewParkingLocations.vue';
import CreateParkingSlots from './CreateParkingSlots.vue';
import SlotBoookings from './SlotBoookings.vue';
import AppUsers from './AppUsers.vue';
import LoginPage from './LoginPage.vue';
import RegistrationPage from './RegistrationPage.vue';
import AuthenticationService from '../services/AuthenticationServices.js';

export default {
  name: 'MainNavigation',
  components: {
    NewParkingLocations,
    CreateParkingSlots,
    SlotBoookings,
    AppUsers,
    LoginPage,
    RegistrationPage
    },
  data() {
    return {
      activeTab: 'login', // Default active tab
      // activeTab: 'parking', // Default active tab
      loggedIn: AuthenticationService.isLogin(),
    };
  },
  methods: {
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
    showLoginPage() {
      this.activeTab = 'login';
      console.log('Login tab clicked!');
    },
    showRegistration() {
      this.activeTab = 'registration';
      console.log('Registration tab clicked!');
    },
    showNewParkingLocations() {
      this.activeTab = 'parking';
      console.log('New Parking Locations tab clicked!');
    },
  },
};
</script>
<style lang="scss">

</style>
