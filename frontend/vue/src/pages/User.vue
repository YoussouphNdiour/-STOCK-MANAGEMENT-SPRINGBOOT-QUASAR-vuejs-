<template>
  <div class="q-pa-md "   >
    <q-form @submit="onSubmit"
      @reset="onReset"
      class="q-gutter-md">
      <q-input
        rounded outlined
        v-model="name"
        type="text"
        label="name of user"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please type something']"
      />
      <q-input rounded outlined
        type="text"
        v-model="email"
        label="email"
        lazy-rules
         :rules="[ val => val && val.length > 0 || 'Please type something']"
      />
      <q-input rounded outlined
        type="text"
        v-model="password"
        label="password"
        lazy-rules
         :rules="[ val => val && val.length > 0 || 'Please type something']"
      />
       <q-input rounded outlined
        type="text"
        v-model="profile"
        label="profile"
        lazy-rules
         :rules="[ val => val && val.length > 0 || 'Please type something']"
      />
      <div>
        <q-btn label="envoyer" @click="onSubmit"  color="primary"/>
        <q-btn label="modifier" @click="update"  color="primary"/>
        <q-btn label="supprimer" @click="deleted"  color="primary"/>
        <q-btn label="annuler" @click="onReset" type="reset" color="primary" flat class="q-ml-sm" />
      </div>
    </q-form>
     <div class="q-pa-md">
   
         
    <q-table
      title="Treats"
      :rows="posts"
      :columns="columns"
      row-key="id"
      class="col"
      selection="single"
      v-model:selected="selected" 
      
    /> 
    <div class="q-mt-md">
        <q-btn label="charger" @click="charger"  color="primary"/>
<q-btn color="primary"
     @click="getLists"
        label="refresh"/>             
    </div>    
  </div>
  </div>
</template>
<script>
import { useQuasar } from 'quasar'
import { ref } from 'vue'
import Axios from 'axios'
export default {
  data () {
      const $q = useQuasar()
      const name = ref(null)
      const email = ref(null)
      const id = ref(null)
      const password = ref(null)
      const profile = ref(null)
      return {
        name,
        email,
        selected: ref([]),
        id,
        password,
        profile,
      //table column
        columns:[
          {
          name: 'id',
          required: true,
          label: 'id',
          align: 'left',
          field:'id',
          sortable: true,
          headerClasses: 'bg-dark text-white',
        },
          {
          name: 'name',
          required: true,
          label: 'name',
          align: 'left',
          field:'name',
          sortable: true,
            headerClasses: 'bg-primary text-white',
        },
         {
          name: 'email',
          required: true,
          label: 'email',
          align: 'left',
          field:'email',
          sortable: true,
            headerClasses: 'bg-primary text-white',
        },
        {
          name: 'password',
          required: true,
          label: 'password',
          align: 'left',
          field:'password',
          sortable: true,
            headerClasses: 'bg-primary text-white',
        },
         {
          name: 'profile',
          required: true,
          label: 'profile',
          align: 'left',
          field:'profile',
          sortable: true,
            headerClasses: 'bg-primary text-white',
        },
        ],
        posts:[]
      }
  }, 
  mounted(){
this.getLists()
  },
  methods:{
            onSubmit () {
               const article = 
               { 
               email: this.email,
               name: this.name,
               password:this.password,
               profile:this.profile          
               }
               this.getLists()
              Axios.post('http://localhost:9099/addUser', article)
                this.getLists()
                this.onReset()
            },
            onReset () {
              this.name ='',
              this.email='',
              this.password='',
              this.profile=''
            },
            //retrieve the list from the database
    getLists(){
      Axios.get('http://localhost:9099/Users')
          .then((response)=>{ 
            this.posts=response.data
            console.log(response.data)

          })
    },
    charger(){
         this.id=this.selected[0].id
        this.name=this.selected[0].name
        this.email=this.selected[0].email
       this.password=this.selected[0].password
       this.profile=this.selected[0].profile
    },
    update(){
        const article = 
               { 
                  id: this.id,
               email: this.email,
               name: this.name, 
               profile: this.profile,
               password:this.password           
               }
               this.getLists()
        Axios.put('http://localhost:9099/updateUser', article)
         this.getLists()
         
    },
    deleted(){
        const article = 
               { 
               email: this.email,
               name: this.name, 
               profile: this.profile,
               password:this.password          
               }
                this.getLists()
        Axios.delete('http://localhost:9099/deleteUser/'+this.id)
         this.getLists()
         this.onReset()
    }
      },
     
    }

</script>