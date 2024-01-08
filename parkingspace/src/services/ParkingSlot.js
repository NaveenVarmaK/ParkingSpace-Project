import axios from 'axios';

const API_URL = process.env.VUE_APP_BACKEND_URL + '/api/slots';

class ParkingSlot {
  getAll() {
    console.log("get all slots")
    console.log(API_URL)
    // console.log(PROXY_TARGET)
    // print all the environment variables
    console.log(process.env)
    // console.log(SPRINGBOOT_PORT)
    
    return axios.get(API_URL, { headers: {} });
  }

  get(id) {
    return axios.get(`${API_URL}/${id}`);
  }

  create(data) {
    return axios.post(API_URL, data);
  }

  update(id, data) {
    return axios.put(`${API_URL}/${id}`, data);
  }

  delete(id) {
    return axios.delete(`${API_URL}/${id}`);
  }
}
export default new ParkingSlot();

