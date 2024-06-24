import { createWebHistory, createRouter } from 'vue-router'

import HomeView from './components/HomeView.vue'
import ProductList from './components/ProductList.vue'
import CartTable from './components/CartTable.vue'

const routes = [
    { path: '/', redirect: '/home' },
    { path: '/home', component: HomeView },
    { path: '/products/:category', component: ProductList },
    { path: '/cart', component: CartTable },

]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

router.beforeEach((to, from, next) => {
    // console.log('to', to)
    // console.log('from', from)
    // next()
    if (to.path === '/cart') {
        let cart = JSON.parse(localStorage.getItem('cart'))
        if (!cart || cart.length === 0) {
            next('/home')
        } else {
            next()
        }
    } else {
        next()
    }
})

export default router