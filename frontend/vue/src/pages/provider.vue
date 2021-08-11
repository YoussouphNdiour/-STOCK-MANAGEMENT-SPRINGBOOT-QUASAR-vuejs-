<template>
  <div class="q-pa-md "   >
   <nav class="q-pa-md">
            <router-link class="btn btn-primary" to="/product">Products</router-link>
            <router-link class="btn btn-primary" to="/order">Orders</router-link>
            <router-link class="btn btn-primary" to="/provider">Providers</router-link>
        </nav>
    <q-form @submit="onSubmit"
      @reset="onReset"
      class="q-gutter-md">
      <q-input
        rounded outlined
        v-model="name"
        type="text"
        label="nom"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please type something']"
      />
      <q-input rounded outlined
        type="text"
        v-model="adress"
        label="adresse"
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
        v-model="telephone"
        label="telephone"
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
                <q-btn color="primary" @click="getLists" label="refresh"/>             
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
      const telephone = ref(null)
      const id = ref(null)
    const email = ref(null)
     const adress = ref(null)
      
      return {
        name,
        telephone,
        selected: ref([]),
        id,
        adress,
        email,
      //input variable in search
      searchinput: "",
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
          name: 'adress',
          required: true,
          label: 'adress',
          align: 'left',
          field:'adress',
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
          name: 'telephone',
          required: true,
          label: 'telephone',
          align: 'left',
          field:'telephone',
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
               telephone: this.telephone,
               name: this.name,
               email: this.email,
               adress: this.adress

               }
              
              Axios.post('http://localhost:9099/addProvider', article)
                this.getLists()
            },
            onReset () {
              this.name ='',
              this.category=''
            },
            //retrieve the list from the database
    getLists(){
      Axios.get('http://localhost:9099/Providers')
          .then((response)=>{ 
            this.posts=response.data
            console.log(response.data)

          })
    },
    charger(){
         this.id=this.selected[0].id
        this.name=this.selected[0].name
        this.telephone=this.selected[0].telephone
        this.email=this.selected[0].email
        this.adress=this.selected[0].adress
       
    },
    update(){
        const article = 
        { 
        telephone: this.telephone,
        name: this.name,
        telephone: this.telephone,
        email: this.email ,
        adress: this.adress,
        id: this.id         
        }
        Axios.put('http://localhost:9099/updateProvider', article)
        this.onReset()
    },
    deleted(){
        const article = 
               { 
               telephone: this.telephone,
        name: this.name,
        telephone: this.telephone,
        email: this.email ,
        adress: this.adress,
        id: this.id          
               }
                this.getLists()
        Axios.delete('http://localhost:9099/deleteProvider/'+this.id)
        this.onReset()
         this.getLists()
         
    },
    
      },
     
    }

</script>