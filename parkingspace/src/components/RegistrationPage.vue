<template>
  <div>
    <div id="id01" class="modal" ref="modal">
      <form class="modal-content animate" @submit.prevent="register">
        <div class="imgcontainer">
          <span @click="closeModal" class="close" title="Close Modal">&times;</span>
          <img src="img_avatar2.png" alt="Avatar" class="avatar">
        </div>

        <div class="container">
          <label for="name"><b>Name</b></label>
          <input type="text" v-model="name" placeholder="Enter Name" name="name" required>

          <label for="email"><b>Email</b></label>
          <input type="email" v-model="email" placeholder="Enter Email" name="email" required>

          <label for="psw"><b>Password</b></label>
          <input type="password" v-model="password" placeholder="Enter Password" name="password" required>

          <label for="role"><b>Role</b></label>
          <select v-model="role">
            <option value="ROLE_USER">User</option>
            <option value="ROLE_ADMIN">Admin</option>
          </select>
            
          <button type="submit">Register</button>
        </div>

        <div class="container" style="background-color:#f1f1f1">
          <button type="button" @click="closeModal" class="cancelbtn">Cancel</button>
          <!-- You can add other elements if needed -->
        </div>
      </form>
    </div>

    <div>
      <input type="text" v-model="name" placeholder="Name">
      <input type="email" v-model="email" placeholder="Email">
      <input type="password" v-model="password" placeholder="Password">
      <select v-model="role">
        <option value="ROLE_USER">User</option>
        <option value="ROLE_ADMIN">Admin</option>
      </select>
      <button @click="openModal">Register</button>
      <p v-if="errorMessage" style="color: red;">{{ errorMessage }}</p>
    </div>
  </div>
</template>

<script>
import RegistrationServices from '@/services/RegistrationServices';

export default {
  data() {
    return {
      name: '',
      email: '',
      password: '',
      role: 'ROLE_USER',
      errorMessage: ''
    };
  },
  methods: {
    openModal() {
      this.$refs.modal.style.display = 'block';
    },
    closeModal() {
      this.$refs.modal.style.display = 'none';
    },
    register() {
      const userData = {
        name: this.name,
        email: this.email,
        password: this.password,
        role: this.role
      };
      RegistrationServices.register(userData)
        .then(() => {
          // Close the modal after successful registration
          this.closeModal();
        })
        .catch(error => {
          // Handle registration error
          this.errorMessage = error.message;
        });
    }
  },
  mounted() {
    // Automatically open modal when component mounts
    this.openModal();
  }
};
</script>

<style scoped>
body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Full-width input fields */
input[type="text"],
input[type="password"],
input[type="email"]
{
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

/* Set a style for all buttons */
button {
  background-color: #5c6ac4;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
  text-align: center;
  margin-top: 30px; /* Adjust the margin as needed */
  position: relative;

}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
    position: relative;
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: absolute; /* Stay in place */
  z-index: 1; /* Sit on top */
  /* left: 50%;
  top: 50%;
    transform: translate(-50%, -50%); */
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: rgba(0, 0, 0, 0.4); /* Black with opacity */
}

/* Modal Content/Box */
.modal-content {
    top: 10%;
  left:25%;
  background-color: #fefefe;
  margin: 10% auto; /* 10% from the top and centered */
  border: 1px solid #888;
  width: 80%; /* Could be more or less, depending on screen size */
  max-width: 1000px; /* Added for better readability on larger screens */
  /* min-height: 300px; */
  position: absolute;
}

/* The Close Button (x) */
.close {
  position: absolute;
  right: 15px;
  top: 0;
  color: #000;
  font-size: 35px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: red;
  cursor: pointer;
}

/* Add Zoom Animation */
.animate {
  animation: animatezoom 0.6s;
}

@keyframes animatezoom {
  from {
    transform: scale(0);
  }
  to {
    transform: scale(1);
  }
}
</style>


<!-- <template>
    <div>
      <input type="text" v-model="name" placeholder="Name">
      <input type="email" v-model="email" placeholder="Email">
      <input type="password" v-model="password" placeholder="Password">
      <select v-model="role">
        <option value="ROLE_USER">User</option>
        <option value="ROLE_ADMIN">Admin</option>
      </select>
      <button @click="register">Register</button>
      <p v-if="errorMessage" style="color: red;">{{ errorMessage }}</p>
    </div>
  </template>
  
  <script>
  import RegistrationServices from '@/services/RegistrationServices';
  export default {
    data() {
      return {
        name: '',
        email: '',
        password: '',
        role: 'ROLE_USER',
        errorMessage: ''
      };
    },
    methods: {
       register() {
        console.log(this.name, this.email, this.password, this.role);
        const data = {
          name: this.name,
          email: this.email,
          password: this.password,
          roles: this.role
        }
        RegistrationServices.register(data);
      }
    }
  };
  </script> -->
  