<template>
  <div class="container" style="position: absolute; max-width: 550px;">
    <div v-for="booking in bookings" :key="booking.id" class="border border-secondary rounded p-2 mb-2">
      <div class="top-row d-flex">
        <div class="fw-bold pe-3">{{ booking.user.firstName }} {{ booking.user.lastName }}</div>
        <div class="text-muted">{{ booking.user.startTime }}, {{ booking.user.endTime }}</div>
      </div>
      <hr>
      <div class="border border-secondary rounded p-2 mb-2">
        <div class="top-row d-flex">
          <div class="fw-bold pe-3">{{ booking.slot.carparkName }}</div>
          <div class="text-muted">{{ booking.slot.postcode }}, {{ booking.slot.description }}</div>
        </div>
        <div class="top-row d-flex">
          <div class="fw-bold pe-3">{{ booking.slot.easting }}, {{ booking.slot.northing }}</div>
          <div class="ms-4">
            <span class="icon" style="color: #5c6ac4;">&#x2B24;</span> Available
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import BookingServices from '../services/BookingServices.js';

export default {
  data() {
    return {
      bookings: [],
      loading: false,
      errored: false,
    };
  },
  methods: {
    async getBookings() {
      try {
        this.loading = true;
        const response = await BookingServices.getAll(); // Use BookingServices here
        this.bookings = response.data;
        this.loading = false;
      } catch (error) {
        console.error('Error fetching bookings:', error);
        this.loading = false;
        this.errored = true;
      }
    },
  },
  created() {
    this.getBookings();
  },
};
</script>

<style>
/* Your styles here */
</style>
