

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
          imagePath: "/Laptop.png",
          isAvailable: true,
          category: "electronics",
        },
        {
          id: 2,
          name: "Mobile",
          price: 50000.0,
          description: "This is a mobile",
          imagePath: "/Mobile.png",
          isAvailable: true,
          category: "electronics",
        },
      ],
      category: "",
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
  // mounted() {
  //   console.log("ProductList mounted");
  //   const category = this.$route.params.category;
  //   console.log(category);
  // },
  // updated() {
  //   console.log("ProductList updated");
  //   const category = this.$route.params.category;
  //   console.log(category);
  // },

  created() {
    this.$watch(
      () => this.$route.params.category,
      (newCat, oldcat) => {
        // react to route changes...
        this.category = newCat;
      }
    );
  },
  computed: {
    filteredProducts() {
      if (this.category) {
        return this.products.filter(
          (product) => product.category === this.category
        );
      }
      return this.products;
    },
  },
};
</script>

<template>
  <div class="card">
    <div class="card-body">
      <div class="list-group">
        <div v-for="product in filteredProducts" :key="product.id">
          <div class="list-group-item mt-2">
            <Product :product="product" @buy="(item) => $emit('buy', item)" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>