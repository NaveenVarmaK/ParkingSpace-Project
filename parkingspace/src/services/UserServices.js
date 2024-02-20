import axios from 'axios';

const USERS = process.env.VUE_APP_BACKEND_URL + '/api/users';

class UserServices {
  getAll() {
    console.log("get all slots")
    // return axios.get(USERS, { headers: {} });
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

  // newUser() {
//     curl -X 'POST' \
//   'http://localhost:8084/auth/addNewUser' \
//   -H 'accept: */*' \
//   -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzcmkiLCJpYXQiOjE3MDgzNjQ3MzIsImV4cCI6MTcwODM2NjUzMn0.bPX9B1h4IhXBdUwoIeJBesMJypvz404teTKJWlaIywM' \
//   -H 'Content-Type: application/json' \
//   -d '{
//   "id": 0,
//   "name": "sri3",
//   "email": "sri3@gmail.com",
//   "password": "12345",
//   "roles": "ROLE_USER"
// }'

  //   return axios.post(`${USERS}/addNewUser`, {
  //     id: 0,
  //     name: "",
  //     email: "",
  //     password: "",
  //     roles: "ROLE_USER"
  //   });
  // }

  // login(){
//     curl -X 'POST' \
//   'http://localhost:8084/auth/generateToken' \
//   -H 'accept: */*' \
//   -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzcmkiLCJpYXQiOjE3MDgzNjQ3MzIsImV4cCI6MTcwODM2NjUzMn0.bPX9B1h4IhXBdUwoIeJBesMJypvz404teTKJWlaIywM' \
//   -H 'Content-Type: application/json' \
//   -d '{
//   "username": "sri3",
//   "password": "12345"
// }'  

  //   return axios.post(`${USERS}/generateToken`, {
  //     username: "",
  //     password: ""
  //   }).then(response => {
  //     if (response.data.token) {
  //       localStorage.setItem("token", response.data);
  //       // or response.body
  //     }}).catch(error => {
  //       alert("Invalid credentials");
  //       console.log(error);
  //     });

  // }

  // checkUserAuth(){
  // //   curl -X 'GET' \
  // // 'http://localhost:8084/auth/welcome' \
  // // -H 'accept: */*' \
  // // -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzcmkzIiwiaWF0IjoxNzA4MzY1MDAxLCJleHAiOjE3MDgzNjY4MDF9.hfbMikk0ZlqDOiLvPtVSFc2Pe0svPxNFqyPWK9uAdOQ'

  //   return axios.get(`${USERS}/welcome`, { headers: {
  //     'Authorization': 'Bearer ' + localStorage.getItem('token')
  //   }});
  // }


}
export default new UserServices();

