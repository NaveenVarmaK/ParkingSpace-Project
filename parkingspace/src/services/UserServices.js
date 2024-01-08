import axios from 'axios';

const USERS = process.env.VUE_APP_BACKEND_URL + '/api/users';

class UserServices {
  getAll() {
    console.log("get all slots")
    return axios.get(USERS, { headers: {} });
  }

  get(id) {
    return axios.get(`${USERS}/${id}`);
  }

  create(data) {
    return axios.post(USERS, data);
  }

  update(id, data) {
    return axios.put(`${USERS}/${id}`, data);
  }

  delete(id) {
    return axios.delete(`${USERS}/${id}`);
  }
}
export default new UserServices();

