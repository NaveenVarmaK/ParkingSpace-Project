import axios from 'axios';

// const BOOKING_URL = 'http://localhost:8084/api/bookings';

// const BOOKING_URL = 'http://localhost:${SPRINGBOOT_PORT}/api/bookings';

const BOOKING_URL = process.env.VUE_APP_BACKEND_URL + '/api/bookings';

class BookingSlot {
  getAll() {
    console.log("get all bookings")
    return axios.get(BOOKING_URL, { headers: {} });
  }

  get(id) {
    return axios.get(`${BOOKING_URL}/${id}`);
  }

  create(data) {
    return axios.post(BOOKING_URL, data);
  }

  update(id, data) {
    return axios.put(`${BOOKING_URL}/${id}`, data);
  }

  delete(id) {
    return axios.delete(`${BOOKING_URL}/${id}`);
  }
}
export default new BookingSlot();