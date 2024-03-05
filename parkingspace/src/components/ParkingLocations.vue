<!-- <template>
  <div class="Parking-Slot">
    <div class="d-flex mb-2"></div>
    <div v-if="loading">Loading...</div>
    <div v-else>
      <div class="table-responsive">
        <table class="responsive-table">
          <thead>
            <tr class="table-header">
              <th class="col col-1">ID</th>
              <th class="col col-2">Area</th>
              <th class="col col-2">Street</th>
              <th class="col col-2">City</th>
              <th class="col col-2">Country</th>
              <th class="col col-1">Status</th>
              <th class="col col-1">Is Busy</th>
              <th class="col col-1">Action</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="slot in slots" :key="slot.id" class="table-row">
              <td class="col col-1">{{ slot.id }}</td>
              <td class="col col-2">{{ slot.area }}</td>
              <td class="col col-2">{{ slot.street }}</td>
              <td class="col col-2">{{ slot.city }}</td>
              <td class="col col-2">{{ slot.country }}</td>
              <td class="col col-1">{{ slot.status }}</td>
              <td class="col col-1">{{ slot.isBusy }}</td>
              <td class="col col-1">
                <button type="button" class="btn btn-danger" @click="deleteSlot(slot.id)">Delete</button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
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
    deleteSlot(slotId) {
      const confirmDelete = window.confirm("Are you sure you want to delete this parking slot?");
      if (confirmDelete) {
        this.performDelete(slotId);
      }
    },
    async performDelete(slotId) {
      try {
        this.loading = true;
        await ParkingSlot.delete(slotId);
        this.slots = this.slots.filter((slot) => slot.id !== slotId);
        this.loading = false;
      } catch (error) {
        console.error('Error deleting parking slot:', error);
        this.showErrorMessage('Parking Slot could not be deleted, it is associated with the booking');
        this.loading = false;
      }
    },
    showErrorMessage(message) {
      window.alert(message);
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

.table-responsive {
  position: absolute;
  top: 50%;
  left:50%;
  transform: translate(-50%, -50%);
  width: fit-content;
  margin: 0;
  padding: 0;
  list-style: none;
  border-collapse: collapse;
  background: white;
  overflow: hidden;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
  border-radius: 10px;
}


.responsive-table {
  width:fit-content;
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
</style> -->
