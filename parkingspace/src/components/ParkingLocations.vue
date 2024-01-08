<!-- <template>
  <div class="Parking-Slot">
    <h2>Parking Locations</h2>
    <div v-if="loading">Loading...</div>
    <div v-else>
      <ul class="responsive-table">
        <li class="table-header">
          <div class="col col-1">ID</div>
          <div class="col col-2">Area</div>
          <div class="col col-2">Street</div>
          <div class="col col-2">City</div>
          <div class="col col-2">Country</div>
          <div class="col col-2">Status</div>
          <div class="col col-2">Is Busy</div>
          <div class="col col-1">Action</div>
        </li>
        <li v-for="slot in slots" :key="slot.id" class="table-row">
          <div class="col col-1" data-label="ID">{{ slot.id }}</div>
          <div class="col col-2" data-label="Area">{{ slot.area }}</div>
          <div class="col col-2" data-label="Street">{{ slot.street }}</div>
          <div class="col col-2" data-label="City">{{ slot.city }}</div>
          <div class="col col-2" data-label="Country">{{ slot.country }}</div>
          <div class="col col-2" data-label="Status">{{ slot.status }}</div>
          <div class="col col-2" data-label="Is Busy">{{ slot.isBusy }}</div>
          <div class="col col-1" data-label="Action">
            <button @click="deleteSlot(slot.id)">Delete</button>
          </div>
        </li>
      </ul>
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
    };
  },
  methods: {
    async getSlots() {
      try {
        this.loading = true;
        const response = await ParkingSlot.getAll();
        console.log(response.data);
        this.slots = response.data;
        this.loading = false;
      } catch (error) {
        console.error('Error fetching parking slots:', error);
        this.loading = false;
        this.errored = true;
      }
    },
    async deleteSlot(slotId) {
      try {
        this.loading = true;
        await ParkingSlot.delete(slotId);
        this.slots = this.slots.filter((slot) => slot.id !== slotId);
        this.loading = false;
      } catch (error) {
        console.error('Error deleting parking slot:', error);
        this.loading = false;
      }
    },
  },
  created() {
    this.getSlots();
  },
};
</script>

<style lang="scss">
.container {
  margin: 20px;
}

.responsive-table {
  width: 100%;
  margin: 0;
  padding: 0;
  list-style: none;
  border-collapse: collapse;
  background: white;
  overflow: hidden;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
  border-radius: 10px;
}

.table-header {
  font-size: 16px;
  background: #5c6ac4;
  color: white;
  font-weight: bold;
  display: flex;
}

.table-row {
  font-size: 14px;
  border-bottom: 1px solid #e0e0e0;
  display: flex;
}

.col {
  padding: 10px;
  text-align: center;
}

.col-1 {
  flex: 1;
}

.col-2 {
  flex: 2;
}

@media only screen and (max-width: 767px) {
  .table-header,
  .table-row {
    flex-direction: column;
    align-items: center;
  }

  .col {
    width: 100%;
    box-sizing: border-box;
  }
}
</style> -->



<template>
  <div class="Parking-Slot">
    <div class="d-flex mb-2">
    </div>
    <h2>Parking Locations</h2>
    <div v-if="loading">Loading...</div>
    <div v-else>
      <table class="table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Area</th>
            <th>Street</th>
            <th>City</th>
            <th>Country</th>
            <th>Status</th>
            <th>Is Busy</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="slot in slots" :key="slot.id">
            <td>{{ slot.id }}</td>
            <td>{{ slot.area }}</td>
            <td>{{ slot.street }}</td>
            <td>{{ slot.city }}</td>
            <td>{{ slot.country }}</td>
            <td>{{ slot.status }}</td>
            <td>{{ slot.isBusy }}</td>
            <td>
              <button @click="deleteSlot(slot.id)">Delete</button>
            </td>
          </tr>
        </tbody>
      </table>
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
    };
  },
  methods: {
    async getSlots() {
      try {
        this.loading = true;
        const response = await ParkingSlot.getAll();
        console.log(response.data);
        this.slots = response.data;
        this.loading = false;
      } catch (error) {
        console.error('Error fetching parking slots:', error);
        this.loading = false;
        this.errored = true;
      }
    },
    async deleteSlot(slotId) {
      try {
        this.loading = true;
        await ParkingSlot.delete(slotId);
        this.slots = this.slots.filter((slot) => slot.id !== slotId);
        this.loading = false;
      } catch (error) {
        console.error('Error deleting parking slot:', error);
        this.loading = false;
      }
    },
  },
  created() {
    this.getSlots();
  },
};
</script>

<style lang="scss">
.container {
  margin: 20px;
}

.responsive-table {
  width: 100%;
  margin: 0;
  padding: 0;
  list-style: none;
  border-collapse: collapse;
  background: white;
  overflow: hidden;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
  border-radius: 10px;
}

.table-header {
  font-size: 16px;
  background: #5c6ac4;
  color: white;
  font-weight: bold;
}

.table-row {
  font-size: 14px;
  border-bottom: 1px solid #e0e0e0;
}

.col {
  padding: 10px;
  text-align: center;
}

.col-1 {
  flex: 1;
}

.col-2 {
  flex: 2;
}

.col-3 {
  flex: 1.5;
}

.col-4 {
  flex: 1;
}

@media only screen and (max-width: 767px) {
  .table-header,
  .table-row {
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .col {
    width: 100%;
    box-sizing: border-box;
  }
}
</style>

  