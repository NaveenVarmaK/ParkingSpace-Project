<template>
    <div class="container">
      <div class="table-wrapper-scroll-y my-custom-scrollbar">
        <table class="table table-bordered table-striped mb-0">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Carpark Name</th>
              <th scope="col">Postcode</th>
              <th scope="col">Description</th>
              <th scope="col">Easting</th>
              <th scope="col">Northing</th>
              <!-- <th scope="col">Action</th> -->
              <th scope="col">Maps</th>
              <th scope="col">Book</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="carpark in carparks" :key="carpark.id">
              <td>{{ carpark.id }}</td>
              <td>{{ carpark.carparkName }}</td>
              <td>{{ carpark.postcode }}</td>
              <td>{{ carpark.description }}</td>
              <td>{{ carpark.easting }}</td>
              <td>{{ carpark.northing }}</td>
              <!-- <td>
                <button type="button" class="btn btn-primary" @click="deleteCarpark(carpark.id)">Select</button>
              </td> -->
                <td>
                    <button type="Map-button" class="btn btn-secondary" @click="showMap(carpark.id)">Map</button>
                </td>
                <td>
                    <button type="Book-button" class="btn btn-success" @click="showBook(carpark.id)">Book</button>
                </td>
            </tr>
          </tbody>
        </table>
      </div>
      <p v-if="errorMessage" style="color: red;">{{ errorMessage }}</p>
    </div>
  </template>
  
  <script>
  import NewParkingSlot from '../services/NewParkingSlot.js';
  
  export default {
    name: 'NewParkingLocations',
    data() {
      return {
        carparks: [],
        loading: true,
        errored: false,
      };
    },
    methods: {
      async getCarparks() {
        try {
          this.loading = true;
          const response = await NewParkingSlot.getAll();
          console.log(response.data);
          this.carparks = response.data;
          this.loading = false;
        } catch (error) {
          console.error('Error fetching parking slots:', error);
          this.loading = false;
          this.errored = true;
        }
      },
    //   async deleteCarpark(carparkId) {
    //     const confirmDelete = window.confirm("Are you sure you want to delete this parking slot?");
    //     if (confirmDelete) {
    //       try {
    //         this.loading = true;
    //         await NewParkingSlot.delete(carparkId);
    //         this.carparks = this.carparks.filter((carpark) => carpark.id !== carparkId);
    //         this.loading = false;
    //       } catch (error) {
    //         console.error('Error deleting parking slot:', error);
    //         this.showErrorMessage('Parking Slot could not be deleted, it is associated with the booking');
    //         this.loading = false;
    //       }
    //     }
    //   },
      showErrorMessage(message) {
        window.alert(message);
      },
    },
    created() {
      this.getCarparks();
    },
  };
  </script>
  
  <style lang="scss">
  .container {
    margin: 20px;
  }
  
  .my-custom-scrollbar {
    position: relative;
    height: 500px;
    overflow: auto;
  }
  
  .table-wrapper-scroll-y {
    display: block;
  }
  
  .table-bordered {
    border: 1px solid #dee2e6;
  }
  
  .table-bordered th,
  .table-bordered td {
    border: 1px solid #dee2e6;
    padding: 0.75rem;
    vertical-align: top;
  }
  
  .table-bordered thead th,
  .table-bordered thead td {
    border-bottom-width: 2px;
  }
  
  .table-striped tbody tr:nth-of-type(odd) {
    background-color: rgba(0, 0, 0, 0.05);
  }
  
  </style>
  
            