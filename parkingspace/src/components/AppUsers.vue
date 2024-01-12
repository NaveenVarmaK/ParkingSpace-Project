
<template>
    <div class="container bootstrap snippets bootdey">
      <div class="header">
        <h3 class="text-muted prj-name">
          <span class="fa fa-users fa-2x" ></span>
        </h3>
      </div>
  
      <div class="jumbotron">
        <ul class="list-group">
          <li v-for="user in users" :key="user.id" class="list-group-item user-item text-left" style="position:relative;display: flex;">
            <h3>
              <a href="#">{{ user.firstName }} {{ user.lastName }}</a><br>
            </h3>
            <ul style="position: relative; align-items: baseline;">
            <p>
              ID: {{ user.id }}<br>
              Car No: {{ user.carNumber }}<br>
            </p>
          </ul>
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

<style>
.jumbotron {
  position: absolute;
  min-width: 400px;
  top:50%;
  left:50%;
  transform: translate(-50%, -50%);
}

</style>