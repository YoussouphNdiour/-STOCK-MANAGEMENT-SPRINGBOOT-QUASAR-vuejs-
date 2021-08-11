<template>
  <div class="q-pa-md" >

    <q-form
      @submit="addproduct"
      @reset="onReset"
      @delete="deleted"
      class="q-gutter-md"
    >
      <q-input
        rounded outlined
        v-model="quantity"
        type="number"
        label="Quantité"
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
     

    <q-select behavior="dialog" rounded outlined v-model="idProduct" :options="options" label="produit " />
    

      <div>
        <q-btn label="add product" @click="addproduct"  color="primary"/>
        <q-btn label="delete product"  @click="deleted"  color="primary"/>
        <q-btn label="Reset" type="reset" color="primary" flat class="q-ml-sm" />
      </div>
    </q-form>
<q-table
      title="Treats"
      :rows="posts"
      :columns="columns"
      row-key="id"
      class="col"
      selection="single"
      v-model:selected="selected" 
    />
    <div>
      <q-btn label="invoices" @click="onSubmit"  color="primary"/>
      <div> price_total: {{ JSON.stringify(selected) }}

        {{price_total1}}
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
      const date = ref(null)
      const quantity = ref(null)
      const identifiant = ref(0)
      const idinvoices = ref(0)
      const price_total = ref(0)
       const price_total1 = ref(0)
      return {
        name,
        idProduct: ref(null),
        options: [],
        product: [],
        tab: [],
        tab1:[],
        tab2:[],
        category,
        posts:[],
        idinvoices,
        id,
        price,
        price_total1,
        identifiant,
        date,
        quantity,
        selected:ref([]),
        price_total,
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
          name: 'quantity',
          required: true,
          label: 'quantity',
          align: 'left',
          field:'quantity',
          sortable: true,
            headerClasses: 'bg-primary text-white',
          
        },
         {
          name: 'price_unit',
          required: true,
          label: 'price unit',
          align: 'left',
          field:'price_unit',
          sortable: true,
          headerClasses: 'bg-primary text-white',
      
        },
        {
          name: 'price_total',
          required: true,
          label: 'price_total',
          align: 'left',
          field:'price_total',
          sortable: true,
            headerClasses: 'bg-primary text-white',
       
        },
        
        ],
      }
  }, 
  mounted(){
    this.products()
      },
  methods:{
            addproduct () {
                this.product = this.idProduct.split(" ",5)
                console.log(this.product);
                this.price_total1 += parseInt(this.quantity) * parseInt(this.product[3])
              this.tab.push({
                name: this.product[2],
                quantity: this.quantity,
                price_unit: this.product[3],
                price_total: parseInt(this.quantity) * parseInt(this.product[3]),
                date: this.date,
                id: this.product[0]
              })
              this.tab2.push({
                 id: this.product[0],
                 quantity: this.product[4] - this.quantity,
                 price: this.product[3],
                 name: this.product[2],
                 category:this.product[1]
              })
              this.tab1.push({
                idProduct:this.product[1],
                name:this.product[2],
                quantity:this.quantity,
                idinvoices:this.idinvoices++
              })
               this.getLists()
            },
            onReset () {
              name.value = null
              quantity.value = null
              date.value=null
            },
             products(){
                Axios.get('http://localhost:9099/products')
                .then((response)=>{ 
                  response.data.forEach(element => {
                    this.options.push(element.id +' '+ element.category +' '+element.name+ ' '+element.price+' '+element.quantity)
                  });   
                  console.log("options",this.options)
                })
                    },
           //retrieve the list from the database
            getLists(){
              this.posts=this.tab
            },
            deleted(){
              console.log(this.selected[0].id);
              delete this.tab[this.selected[0].id]
              console.log(this.tab);
              this.getLists()
              this.selected=[]
            },
            onSubmit(){
              const article = {
                name: this.tab[0].name,
                iduser: this.date,
                price_total: this.price_total1,
                date: this.date,
                id:this.tab[0].id
              }
            
              console.log(this.tab2);
              Axios.post('http://localhost:9099/addSale', article) 
              for (const iterator of this.tab1) {
             Axios.post('http://localhost:9099/addSaleHistory', iterator) 
              }
              for (const iterator of this.tab2) {
             Axios.put('http://localhost:9099/updateproduct', iterator) 
              }
              
            },
      },
     
    }

</script>