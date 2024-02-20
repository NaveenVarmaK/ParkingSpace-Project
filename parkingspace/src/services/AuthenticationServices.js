import axios from 'axios';

const API_URL = process.env.VUE_APP_BACKEND_URL + '/auth/generateToken';
const API_URL_LOGIN = process.env.VUE_APP_BACKEND_URL + '/auth/user/userProfile';


// #{
//     "username": "string",
//     "password": "string"
//   }
class AuthenticationService {
  login(username, password) {
    return axios.post(API_URL, {
      username,
      password
    }).then(response => {
        if (response.data) {
            localStorage.setItem('token', JSON.stringify(response.data));
        }
        alert("Login successful");
        return response.data;
        }
    ).catch(error => {
        console.log("error in login")
        console.log(error)
        alert("Invalid credentials");
    }
    );
  }

  isLogin2(){
//     curl -X 'GET' \
//   'http://localhost:8084/auth/user/userProfile' \
//   -H 'accept: */*' \
//   -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzcmk1IiwiaWF0IjoxNzA4NDE0NzY1LCJleHAiOjE3MDg0MTY1NjV9.W-lmH9hWU7awVpzhaCjePG6wjSbCSyBwCaVxeaMbxDg'

axios.get("http://localhost:8084/auth/user/userProfile", {
    headers: {
    'Authorization': 'Bearer ' + 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzcmk1IiwiaWF0IjoxNzA4NDE0NzY1LCJleHAiOjE3MDg0MTY1NjV9.W-lmH9hWU7awVpzhaCjePG6wjSbCSyBwCaVxeaMbxDg',
    'accept': '*/*'
    }

})
    .then(response => {
        if (response.data) {
            console.log(response.data);
            return true;
        }
        console.log(response.data);
        return false;
        }
    ).catch(error => {
        console.log("error in login")
        // remove token from local storage
        localStorage.removeItem('token');
        console.log(error)
        return false;
    }
    );
  }

  isLogin(){
    // eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzcmk1IiwiaW…1NjV9.W-lmH9hWU7awVpzhaCjePG6wjSbCSyBwCaVxeaMbxDg
    // console.log("login is", localStorage.getItem('token'));
    // replace "" in bearer token
    const token = localStorage.getItem('token').replace(/"/g, '').replace(/^"|"$/g, '');
    console.log("token1 is", token);
    const headers = {
        'Authorization': 'Bearer ' + token
    }
    console.log("headers is", headers);
    axios.get(API_URL_LOGIN, {
      headers: {
        'Authorization': 'Bearer ' + token,
        'Content-Type': 'application/json',
        'accept': '*/*'
      }
    }).then(response => {
        if (response.data) {
            console.log(response.data);

            return true;
        }
        console.log(response.data);
        return false;
        }
    ).catch(error => {
        console.log("error in login")
        console.log(error)
        return false;
    }
    );
  }
}



export default new AuthenticationService();