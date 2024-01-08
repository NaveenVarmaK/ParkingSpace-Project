
<template>
  <div class="Parking-Slot">
    <div>
      <h3>Create New Parking Location</h3>
      <form @submit.prevent="createSlot" class="container">
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
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  margin-top: 20px;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

/* Clear floats after the columns */
.row::after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .col-25,
  .col-75,
  input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}
</style>

// <!-- <template>
//   <div class="Parking-Slot">
//     <div>
//       <h3>Create New Parking Location</h3>
//       <form @submit.prevent="createSlot">
//         <div>
//           <label for="area">Area:</label>
//           <input v-model="newSlot.area" type="text" id="area" required />
//         </div>
//         <div>
//           <label for="street">Street:</label>
//           <input v-model="newSlot.street" type="text" id="street" required />
//         </div>
//         <div>
//           <label for="city">City:</label>
//           <input v-model="newSlot.city" type="text" id="city" required />
//         </div>
//         <div>
//           <label for="country">Country:</label>
//           <input v-model="newSlot.country" type="text" id="country" required />
//         </div>
//         <div>
//           <label for="status">Status:</label>
//           <input v-model="newSlot.status" type="text" id="status" required />
//         </div>
//         <div>
//           <label for="isBusy">Is Busy:</label>
//           <input v-model="newSlot.isBusy" type="checkbox" id="isBusy" />
//         </div>
//         <button type="submit">Create</button>
//       </form>
//       <p v-if="errorCreating" class="error">{{ errorCreating }}</p>
//     </div>
//   </div>
// </template>

// <script>
// import ParkingSlot from '../services/ParkingSlot.js';

// export default {
//   name: 'ParkingLocations',
//   data() {
//     return {
//       slots: [],
//       loading: true,
//       errored: false,
//       newSlot: {
//         area: '',
//         street: '',
//         city: '',
//         country: '',
//         status: '',
//         isBusy: false,
//       },
//       errorCreating: null,
//     };
//   },
//   methods: {
//     async getSlots() {
//       // Existing code
//     },
//     async createSlot() {
//       try {
//         this.loading = true;
//         const response = await ParkingSlot.create(this.newSlot);
//         console.log(response.data);
//         this.slots.push(response.data);
//         this.loading = false;
//         // Reset the form fields after successful creation
//         this.newSlot = {
//           area: '',
//           street: '',
//           city: '',
//           country: '',
//           status: '',
//           isBusy: false,
//         };
//       } catch (error) {
//         console.error('Error creating parking slot:', error);
//         this.errorCreating = 'Error creating parking slot. Please try again.';
//         this.loading = false;
//       }
//     },
//   },
//   created() {
//     this.getSlots();
//   },
// };
// </script>

// <style>
// .error {
//   color: red;
//   margin-top: 10px;
// }
// </style> -->





// <!-- <template>
//     <div class="Parking-Slot">
//       <div class="d-flex mb-2">
//         <button @click="goToCreateForm">Create Parking Location</button>
//       </div>
//       <div v-if="creating">
//         <h3>Create New Parking Location</h3>
//         <form @submit.prevent="createSlot">
//           <div>
//             <label for="area">Area:</label>
//             <input v-model="newSlot.area" type="text" id="area" required />
//           </div>
//           <div>
//             <label for="street">Street:</label>
//             <input v-model="newSlot.street" type="text" id="street" required />
//           </div>
//           <div>
//             <label for="city">City:</label>
//             <input v-model="newSlot.city" type="text" id="city" required />
//           </div>
//           <div>
//             <label for="country">Country:</label>
//             <input v-model="newSlot.country" type="text" id="country" required />
//           </div>
//           <div>
//             <label for="status">Status:</label>
//             <input v-model="newSlot.status" type="text" id="status" required />
//           </div>
//           <div>
//             <label for="isBusy">Is Busy:</label>
//             <input v-model="newSlot.isBusy" type="checkbox" id="isBusy" />
//           </div>
//           <button type="submit">Create</button>
//         </form>
//         <p v-if="errorCreating" class="error">{{ errorCreating }}</p>
//       </div>
//       <div v-else>
//       </div>
//     </div>
//   </template>
  
//   <script>
//   import ParkingSlot from '../services/ParkingSlot.js';
  
//   export default {
//     name: 'ParkingLocations',
//     data() {
//       return {
//         slots: [],
//         loading: true,
//         errored: false,
//         creating: false,
//         newSlot: {
//           area: '',
//           street: '',
//           city: '',
//           country: '',
//           status: '',
//           isBusy: false,
//         },
//         errorCreating: null,
//       };
//     },
//     methods: {
//       async getSlots() {
//         // Existing code
//       },
//       async createSlot() {
//         try {
//           this.loading = true;
//           const response = await ParkingSlot.create(this.newSlot);
//           console.log(response.data);
//           this.slots.push(response.data);
//           this.creating = false;
//           this.loading = false;
//           // Reset the form fields after successful creation
//           this.newSlot = {
//             area: '',
//             street: '',
//             city: '',
//             country: '',
//             status: '',
//             isBusy: false,
//           };
//         } catch (error) {
//           console.error('Error creating parking slot:', error);
//           this.errorCreating = 'Error creating parking slot. Please try again.';
//           this.loading = false;
//         }
//       },
//       goToCreateForm() {
//         this.creating = true;
//         this.errorCreating = null;
//       },
//     },
//     created() {
//       this.getSlots();
//     },
//   };
//   </script>
  
//   <style>
//   .error {
//     color: red;
//     margin-top: 10px;
//   }
//   /* Add your styling here */
//   </style> -->