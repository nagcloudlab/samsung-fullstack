import 'bootstrap/dist/css/bootstrap.min.css'
import 'font-awesome/css/font-awesome.min.css'

import { createApp } from 'vue'
import App from './App.vue'

import Navbar from './components/Navbar.vue'
import ProductList from './components/ProductList.vue'

createApp(App)
    // .component('Navbar', Navbar)
    // .component("ProductList", ProductList)
    .mount('#app')
