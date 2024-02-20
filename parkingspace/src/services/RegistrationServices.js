import axios from "axios";

const API_URL = process.env.VUE_APP_BACKEND_URL + "/auth/addNewUser";

// #{
//     "id": 0,
//     "name": "string",
//     "email": "string",
//     "password": "string",
//     "roles": "string"
//   }

class RegistrationServices {
    register(data) {
        return axios.post(API_URL, {
        id: data.id,
        name: data.name,
        email: data.email,
        password : data.password,
        roles: "ROLE_USER",
        }
        ).then(response => {
            if (response.data) {
                alert("Registration successful");
            }
            return response.data;
            }
        ).catch(error => {
            console.log("error in registration")
            console.log(error)
            alert("Registration failed");
        }
        );

    }
    }

export default new RegistrationServices();