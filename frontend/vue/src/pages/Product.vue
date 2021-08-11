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
        label="name of product"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please type something']"
      />
      <q-input rounded outlined
        type="text"
        v-model="category"
        label="category"
        lazy-rules
         :rules="[ val => val && val.length > 0 || 'Please type something']"
      />
      <q-input rounded outlined
        type="text"
        v-model="price"
        label="selling price"
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
      const category = ref(null)
      const id = ref(null)
      const price = ref(null)
      return {
        name,
        category,
        selected: ref([]),
        id,
        price,
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
          name: 'category',
          required: true,
          label: 'category',
          align: 'left',
          field:'category',
          sortable: true,
            headerClasses: 'bg-primary text-white',
        },
        {
          name: 'price',
          required: true,
          label: 'price',
          align: 'left',
          field:'price',
          sortable: true,
            headerClasses: 'bg-primary text-white',
        },
         {
          name: 'quantity',
          required: true,
          label: 'quantity',
          align: 'left',
          field:'quantity',
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
               category: this.category,
               name: this.name,
               price:this.price          
               }
               this.getLists()
              Axios.post('http://localhost:9099/addProduct', article)
                this.getLists()
            },
            onReset () {
              this.name ='',
              this.category='',
              this.price=''
            },
            //retrieve the list from the database
    getLists(){
      Axios.get('http://localhost:9099/products')
          .then((response)=>{ 
            this.posts=response.data
            console.log(response.data)

          })
    },
    charger(){
         this.id=this.selected[0].id
        this.name=this.selected[0].name
        this.category=this.selected[0].category
       this.price=this.selected[0].price
    },
    update(){
        const article = 
               { 
               category: this.category,
               name: this.name, 
               id: this.id,
               price:this.price           
               }
               this.getLists()
        Axios.put('http://localhost:9099/updateproduct', article)
         this.getLists()
         this.onReset()
    },
    deleted(){
        const article = 
               { 
               category: this.category,
               name: this.name, 
               id: this.id,
               price:this.price          
               }
                this.getLists()
        Axios.delete('http://localhost:9099/deleteproduct/'+this.id)
         this.getLists()
         this.onReset()
    }
      },
     
    }

</script>