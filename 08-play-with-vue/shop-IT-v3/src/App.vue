<script>
import Navbar from "./components/Navbar.vue";
import CartBadge from "./components/CartBadge.vue";
import ProductList from "./components/ProductList.vue";
import CartTable from "./components/CartTable.vue";
import { computed } from "vue";
export default {
  name: "App",
  components: {
    Navbar,
    CartBadge,
    ProductList,
    CartTable,
  },
  data() {
    return {
      title: "Shop IT",
      cart: {},
    };
  },
  provide() {
    return {
      cart: computed(() => this.cart),
      addToCart: this.addToCart,
      removeFromCart: this.removeFromCart,
      manageQty: this.manageQty,
    };
  },
  methods: {
    addToCart(product) {
      const isCartLineExists = this.cart[product.id];
      if (isCartLineExists) {
        this.cart[product.id] = {
          product,
          qty: this.cart[product.id].qty + 1,
        };
      } else {
        this.cart[product.id] = {
          product,
          qty: 1,
        };
      }
    },
    removeFromCart(id) {
      console.log(typeof id);
      delete this.cart[id];
    },
    manageQty(productId, qty) {
      this.cart[productId].qty += qty;
      if (this.cart[productId].qty === 0) {
        delete this.cart[productId];
      }
    },
    toggleCart() {
      this.isCartOpen = !this.isCartOpen;
    },
  },
};
</script>
<template>
  <div class="container">
    <Navbar :title="title" />
    <hr />
    <CartBadge />
    <hr />
    <ul class="nav nav-pills">
      <li class="nav-item">
        <a class="nav-link" href="/">Home</a>
      </li>
      <li class="nav-item">
        <RouterLink
          class="nav-link"
          activeClass="active"
          to="/products/electronics"
          >Electronic</RouterLink
        >
      </li>
      <li class="nav-item">
        <RouterLink class="nav-link" activeClass="active" to="/products/others"
          >Others</RouterLink
        >
      </li>
      <li class="nav-item">
        <RouterLink class="nav-link" activeClass="active" to="/cart"
          >Cart</RouterLink
        >
      </li>
    </ul>
    <hr />
    <router-view />
  </div>
</template>
