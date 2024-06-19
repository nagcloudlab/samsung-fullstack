

<script>
import Product from "./Product.vue";

export default {
  name: "ProductList",
  components: {
    Product,
  },
  emits: ["buy"],
  data() {
    return {
      currentTab: 1,
      products: [
        {
          id: 1,
          name: "Laptop",
          price: 100000.0,
          description: "This is a laptop",
          imagePath: "Laptop.png",
          isAvailable: true,
        },
        {
          id: 2,
          name: "Mobile",
          price: 50000.0,
          description: "This is a mobile",
          imagePath: "Mobile.png",
          isAvailable: true,
        },
      ],
    };
  },
  methods: {
    handleTabChange(event, tabIndex) {
      event.preventDefault();
      this.currentTab = tabIndex;
    },
    isTabSelected(tabIndex) {
      return this.currentTab === tabIndex;
    },
  },
};
</script>

<template>
  <div class="card">
    <div class="card-body">
      <div class="list-group">
        <div v-for="product in products" :key="product.id">
          <div class="list-group-item mt-2">
            <Product :product="product" @buy="(item) => $emit('buy', item)" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>