// curl -X 'GET' \
//   'http://localhost:8084/api/carparks' \
//   -H 'accept: */*'

//   http://localhost:8084/api/carparks

// [
//     {
//       "id": 179,
//       "carparkName": "Barnard Castle Galgate (Morrisons)",
//       "postcode": "DL128EQ",
//       "description": "P&D",
//       "easting": "405101",
//       "northing": "516594"
//     },
//     {
//       "id": 180,
//       "carparkName": "Barnard Castle Queen Street (Hole in the Wall)",
//       "postcode": "DL128GB",
//       "description": "P&D",
//       "easting": "405124",
//       "northing": "516350"
//     },

import axios from 'axios';

const carparks = process.env.VUE_APP_BACKEND_URL + '/api/carparks';

class NewParkingSlot {
    getAll() {
        console.log("get all slots")
        console.log(carparks)
        console.log(process.env)
        return axios.get(carparks, { headers: {} });
    }

    get(id) {
        return axios.get(`${carparks}/${id}`);
    }

    create(data) {
        return axios.post(carparks, data);
    }

    update(id, data) {
        return axios.put(`${carparks}/${id}`, data);
    }

    delete(id) {
        return axios.delete(`${carparks}/${id}`);
    }
}

export default new NewParkingSlot();