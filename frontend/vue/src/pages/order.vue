<template>
  <div class="q-pa-md">
<nav class="q-pa-md">
            <router-link class="btn btn-primary" to="/product">Produits</router-link>
            <router-link class="btn btn-primary" to="/order">Commande</router-link>
            <router-link class="btn btn-primary" to="/provider">fournisseur</router-link>
        </nav>
    <q-form
      @submit="onSubmit"
      @reset="onReset"
      class="q-gutter-md"
    >
      <q-input
        rounded outlined
        v-model="quantity"
        type="text"
        label="Quantity"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please type something']"
      />
      <q-input
        rounded outlined
        v-model="date"
        type="date"
        label="date"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please type something']"
      />

      <q-input rounded outlined
        
        type="text"
        v-model="price"
        label="Buying price"
        lazy-rules
         :rules="[ val => val && val.length > 0 || 'Please type something']"
      />

      <q-select rounded outlined 
       v-model="idProvider" :options="options" label="founisseur " />
    <q-select rounded outlined 
           :rules="[ val => val && val.length < 15 || 'Please type something']"

    v-model="idProduct" :options="option" label="produit " />
    

      <div>
        <q-btn label="insert" @click="onSubmit"  color="primary"/>
        <q-btn label="modify" @click="update"  color="primary"/>
        <q-btn label="delete" @click="deleted"  color="primary"/>
        <q-btn label="reset" @click="onReset" type="reset" color="primary" flat class="q-ml-sm" />
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
      const quantity = ref(null)
      const price = ref(null)
      const iduser = ref(null)
      const idProduct = ref(null)
      const idProvider = ref(null)
      const date = ref(null)
      return {
        maxlength: [v => v.length < 15 || "Sorry you have exceeded the max length of input"],
        name,
        quantity,
        iduser,
        date,
        price,
        idProvider,
        idProduct,
        options: [],
        option:[],
        selected: ref([]),
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
          name: 'idProduct',
          required: true,
          label: 'Product',
          align: 'left',
          field:'idProduct',
          sortable: true,
            headerClasses: 'bg-primary text-white',
         style:"maxlength=12"
        },
         {
          name: 'quantity',
          required: true,
          label: 'Quantity',
          align: 'left',
          field:'quantity',
          sortable: true,
            headerClasses: 'bg-primary text-white',
          
        },
         {
          name: 'price',
          required: true,
          label: 'Buying Price',
          align: 'left',
          field:'price',
          sortable: true,
          headerClasses: 'bg-primary text-white',
      
        },
        {
          name: 'idProvider',
          required: true,
          label: 'Provider',
          align: 'left',
          field:'idProvider',
          sortable: true,
            headerClasses: 'bg-primary text-white',
       
        },
         {
          name: 'date',
          required: true,
          label: 'Date',
          align: 'left',
          field:'date',
          sortable: true,
            headerClasses: 'bg-primary text-white',
       
        }
        ],
        posts:[]
      
      }
  }, 
  mounted(){
          this.provider()
          this.product()
          this.getLists()
      },
  methods:{

            onSubmit () {
              
               const article = 
               { 
               price: this.price, 
               quantity: this.quantity,
               idProvider: this.idProvider,
               iduser: this.price,
               idProduct: this.idProduct ,
               date: this.date,
               name:this.date
               }
              Axios.post('http://localhost:9099/addOrder', article)
              
             var product = this.idProduct.split(" ",5)
              console.log('name',this.idProduct)
              console.log('id',product[0])
              console.log('category',product[1])
              console.log('name',product[2])
              console.log('price',product[3])
               console.log('quantity', product[4])
          let somme = parseInt(product[4]) + parseInt(this.quantity)
              console.log('somme', somme)
              console.log('product[4]', product[4])
              const article1 = 
               { 
               quantity: somme,
               id: product[0],
               category: product[1],
               price: product[3],
               name: product[2]
               }
                Axios.put('http://localhost:9099/updateproduct', article1)
              this.getLists()
            },
            onReset () {
              quantity.value = null
              price.value = null
              idProvider.value = null
              date.value=null
              idProduct.value=null
            },
            provider(){
                Axios.get('http://localhost:9099/Providers')
                .then((response)=>{ 
                  response.data.forEach(element => {
                    this.options.push(element.id +' '+ element.name)
                  });   
                  console.log("options",this.options)
                })
            },
            product(){
                Axios.get('http://localhost:9099/products')
                .then((response)=>{ 
                  response.data.forEach(element => {
                    this.option.push(element.id +' '+ element.category +' '+element.name+ ' '+element.price+' '+element.quantity)
                  });   
                  console.log("options",this.options)
                })
                    },
            //retrieve the list from the database
            getLists(){
              Axios.get('http://localhost:9099/Orders')
                  .then((response)=>{ 
                    this.posts=response.data
                    console.log(response.data)

                  })
            },
            charger(){
                this.id=this.selected[0].id
                this.quantity=this.selected[0].quantity
                this.price=this.selected[0].price
                this.idProvider=this.selected[0].idProvider
                this.idProduct=this.selected[0].idProduct
                this.date=this.selected[0].date
            },
            update(){
                const article = 
                { 
                quantity: this.quantity,
                price: this.price,
                idProvider: this.idProvider,
                idProduct: this.idProduct ,
                iduser: this.price,
                id: this.id,
                date:this.date         
                }
                Axios.put('http://localhost:9099/updateOrder', article)
                this.onReset()
            },
            deleted(){
              const article = 
              { 
              quantity: this.quantity,
              price: this.price,
              idProvider: this.idProvider,
              idProduct: this.idProduct ,
              iduser: this.price,
              id: this.id,
              date:this.date         
          
              }
              this.getLists()
              Axios.delete('http://localhost:9099/deleteOrder/'+this.id)
              this.getLists()
              this.onReset()
            }
      },
    }
</script>