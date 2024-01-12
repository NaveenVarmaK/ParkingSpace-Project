<template>
  <div class="container">
      <div v-for="booking in bookings" :key="booking.id" class="border border-secondary rounded p-2 mb-2">
        <div class="top-row d-flex" style="min-width: 500px;">
          <div class="fw-bold pe-3">{{ booking.user.firstName }} {{ booking.user.lastName }}</div>
          <div class="text-muted">{{ booking.user.startTime }}, {{ booking.user.endTime }}, {{ booking.slot.street }}, {{ booking.slot.area }}</div>
        </div>
        <hr>
        <div v-if="booking.slot.status === 'Unbooked'" class="border border-secondary rounded p-2 mb-2">
          <div class="top-row d-flex">
            <div class="fw-bold pe-3">{{ booking.slot.city }}, {{ booking.slot.country }}</div>
            <div class="ms-4">
              <span class="">&#x2B24;</span> Booked
            </div>
          </div>
        </div>
        <div v-else class="border border-secondary rounded p-2 mb-2">
          <div class="top-row d-flex">
            <div class="fw-bold pe-3">{{ booking.slot.city }}, {{ booking.slot.country }}</div>
            <div class="ms-4">
              <span class="icon">&#x2B24;</span> Closed
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
          const response = await BookingServices.getAll();
          console.log(response.data);
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

  </style>
  