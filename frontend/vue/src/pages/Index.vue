<template>
  <q-page>
    <div class="q-pa-md" style="max-width:500px; ">
   <q-form @submit="onSubmit"
      class="q-gutter-md">
          <q-input
        rounded outlined
        v-model="email"
        type="text"
        label="login"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please type something']"
      />
       <q-input
        rounded outlined
        v-model="password"
        type="password"
        label="password"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please type something']"
      />
      <div>
        <q-btn label="connect"  @click="onSubmit"  color="primary"/>
      </div>
    </q-form>
  </div>
 
 
  </q-page>
</template>

<script>
import Axios from 'axios'
import { exportFile } from 'quasar'

export default {
  data() {
    const email = ""
    const password = ""
    const redirect = ""
    return { 
       email,
       password,
       redirect
    }
  },

  methods:{
    
    //retrieve the list from the database
    onSubmit(){
      const article = 
               { 
               email: this.email,
               password: this.password,
               name:this.email,
               profile:this.email
               }
               console.log(article);
      Axios.post('http://localhost:9099/login', article)
         .then((response)=>{ 
                
                console.log(response.data);
                if (response.data=="admin") {
                  this.$router.push('/user'); 
                } else {
                  if (response.data=="manager") {
                     this.$router.push('/order'); 
                  } else {
                    this.$router.push('/sale'); 
                  }
                  
                }
                })
    },

  }
}
</script>

