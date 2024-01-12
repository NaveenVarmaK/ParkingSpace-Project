<template>
  <div class="Parking-Slot">
    <div>
      <!-- <h3>Create New Parking Location</h3> -->
      <form @submit.prevent="createSlot" class="container" style="max-width: 750px;">
        <div class="row">
          <div class="col-25">
            <label for="area">Area:</label>
          </div>
          <div class="col-75">
            <input v-model="newSlot.area" type="text" id="area" required />
          </div>
        </div>
        <div class="row">
          <div class="col-25">
            <label for="street">Street:</label>
          </div>
          <div class="col-75">
            <input v-model="newSlot.street" type="text" id="street" required />
          </div>
        </div>
        <div class="row">
          <div class="col-25">
            <label for="city">City:</label>
          </div>
          <div class="col-75">
            <input v-model="newSlot.city" type="text" id="city" required />
          </div>
        </div>
        <div class="row">
          <div class="col-25">
            <label for="country">Country:</label>
          </div>
          <div class="col-75">
            <input v-model="newSlot.country" type="text" id="country" required />
          </div>
        </div>
        <div class="row">
          <div class="col-25">
            <label for="status">Status:</label>
          </div>
          <div class="col-75">
            <input v-model="newSlot.status" type="text" id="status" required />
          </div>
        </div>
        <div class="row">
          <div class="col-25">
            <label for="isBusy">Is Busy:</label>
          </div>
          <div class="col-75">
            <input v-model="newSlot.isBusy" type="checkbox" id="isBusy" />
          </div>
        </div>
        <br />
        <div class="row">
          <input type="submit" value="Create" class="submit" />
        </div>
      </form>
      <p v-if="errorCreating" class="error">{{ errorCreating }}</p>
    </div>
  </div>
</template>

<script>
import ParkingSlot from '../services/ParkingSlot.js';

export default {
  name: 'ParkingLocations',
  data() {
    return {
      slots: [],
      loading: true,
      errored: false,
      newSlot: {
        area: '',
        street: '',
        city: '',
        country: '',
        status: '',
        isBusy: false,
      },
      errorCreating: null,
    };
  },
  methods: {
    async getSlots() {
      // Existing code
    },
    async createSlot() {
      try {
        this.loading = true;
        const response = await ParkingSlot.create(this.newSlot);
        console.log(response.data);
        this.slots.push(response.data);
        this.loading = false;
        // Reset the form fields after successful creation
        this.newSlot = {
          area: '',
          street: '',
          city: '',
          country: '',
          status: '',
          isBusy: false,
        };
      } catch (error) {
        console.error('Error creating parking slot:', error);
        this.errorCreating = 'Error creating parking slot. Please try again.';
        this.loading = false;
      }
    },
  },
  created() {
    this.getSlots();
  },
};
</script>

<style>
.error {
  color: red;
  margin-top: 10px;
}

.container {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  border-radius: 5px;
  background-color: white;
  padding: 20px;
}

.row {
  display: flex;
  margin-bottom: 5px;
}

.col-25 {
  flex: 25%;
  margin-top: 6px;
}

.col-75 {
  flex: 75%;
  margin-top: 6px;
}

.submit {
  width: 100%;
  background-color: #5c6ac4;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.submit:hover {
  background-color: #45a049;
}
</style>
