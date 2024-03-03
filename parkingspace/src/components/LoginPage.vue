<template>
    <div>
      <div id="id01" class="modal" ref="modal">
        <form class="modal-content animate" @submit.prevent="login" action="/action_page.php" method="post">
          <div class="imgcontainer">
            <span @click="closeModal" class="close" title="Close Modal">&times;</span>
            <img src="img_avatar2.png" alt="Avatar" class="avatar">
          </div>
  
          <div class="container">
            <label for="uname"><b>Username</b></label>
            <input type="text" v-model="username" placeholder="Enter Username" name="uname" required>
  
            <label for="psw"><b>Password</b></label>
            <input type="password" v-model="password" placeholder="Enter Password" name="psw" required>
              
            <button type="submit">Login</button>
            <label>
              <input type="checkbox" checked="checked" name="remember"> Remember me
            </label>
          </div>
  
          <div class="container" style="background-color:#f1f1f1">
            <button type="button" @click="closeModal" class="cancelbtn">Cancel</button>
            <span class="psw">Forgot <a href="#">password?</a></span>
          </div>
        </form>
      </div>
  
      <div>
        <input type="text" v-model="username" placeholder="Username">
        <input type="password" v-model="password" placeholder="Password">
        <button @click="openModal">Login</button>
        <p v-if="errorMessage" style="color: red;">{{ errorMessage }}</p>
      </div>
    </div>
  </template>
  
  <script>
  import AuthenticationServices from '@/services/AuthenticationServices';
  
  export default {
    data() {
      return {
        username: '',
        password: '',
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
      login() {
        AuthenticationServices.login(this.username, this.password)
        .then(() => {
          // Close the modal after successful login
          this.closeModal();
        })
        .catch(error => {
          // Handle login error
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
input[type="password"] {
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
      <form @submit.prevent="login">
        <h3>Sign In</h3>
        <div class="mb-3">
          <label>Email address</label>
          <input type="email" v-model="username" class="form-control form-control-lg" />
        </div>
        <div class="mb-3">
          <label>Password</label>
          <input type="password" v-model="password" class="form-control form-control-lg" />
        </div>
        <button type="submit" class="btn btn-dark btn-lg btn-block">Sign In</button>
        <p class="forgot-password text-right mt-2 mb-4">
          <router-link to="/forgot-password">Forgot password ?</router-link>
        </p>
        <div class="social-icons">
          <ul>
            <li><a href="#"><i class="fa fa-google"></i></a></li>
            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
          </ul>
        </div>
      </form>
      <p v-if="errorMessage" style="color: red;">{{ errorMessage }}</p>
    </div>
  </template>
  
  <script>
  import AuthenticationServices from '@/services/AuthenticationServices';
  
  export default {
    data() {
      return {
        username: '',
        password: '',
        errorMessage: ''
      };
    },
    methods: {
      login() {
        AuthenticationServices.login(this.username, this.password)
          .catch(error => {
            this.errorMessage = error.message;
          });
      }
    }
  };
  </script> -->
  

<!-- <template>
    <div>
      <input type="text" v-model="username" placeholder="Username">
      <input type="password" v-model="password" placeholder="Password">
      <button @click="login">Login</button>
      <p v-if="errorMessage" style="color: red;">{{ errorMessage }}</p>
    </div>
  </template>
  
  <script>
        import AuthenticationServices from '@/services/AuthenticationServices';

  export default {
    data() {
      return {
        username: '',
        password: '',
        errorMessage: ''
      };
    },
    methods: {
        
      login() {
        AuthenticationServices.login(this.username, this.password);
      }
    }
  };
  </script> -->
  