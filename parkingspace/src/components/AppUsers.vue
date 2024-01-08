<template>
    <div class="container bootstrap snippets bootdey">
      <div class="header">
        <h3 class="text-muted prj-name">
          <span class="fa fa-users fa-2x"></span>
          Users
        </h3>
      </div>
  
      <div class="jumbotron" style="min-height: 400px; height: auto; min-width: 500px;">
        <ul class="list-group">
          <li v-for="user in users" :key="user.id" class="list-group-item user-item text-left">
            <!-- <img class="img-circle img-user img-thumbnail" :src="getUserImage(user)" alt="User Image"> -->
            <h3>
              <a href="#">{{ user.firstName }} {{ user.lastName }}</a><br>
            </h3>
            <p>
              Car Number: {{ user.carNumber }}<br>
              <!-- Start Time: {{ user.startTime }}<br>
              End Time: {{ user.endTime }} -->
            </p>
          </li>
        </ul>
      </div>
    </div>
  </template>

  <script>
    import UserServices from '../services/UserServices.js';

    export default {
        name: 'AppUsers',
        data() {
            return {
                users: [],
                loading: false,
                errored: false,
            };
        },
        methods: {
            async getUsers() {
                try {
                    this.loading = true;
                    const response = await UserServices.getAll();
                    console.log(response.data);
                    this.users = response.data;
                    this.loading = false;
                } catch (error) {
                    console.error('Error fetching users:', error);
                    this.loading = false;
                    this.errored = true;
                }
            },
        },
        created() {
            this.getUsers();
        },  
    }
</script>