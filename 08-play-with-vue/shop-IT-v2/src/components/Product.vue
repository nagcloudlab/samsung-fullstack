

<script>
import Review from "./Review.vue";
export default {
  name: "Product",
  components: {
    Review,
  },
  props: {
    product: {
      type: Object,
      required: true,
    },
  },
  inject: ["cart", "addToCart"],
  emits: ["buy"],
  data() {
    return {
      currentTab: 1,
      reviews: [
        {
          id: 1,
          name: "John",
          review: "Good product",
          rating: 4,
        },
        {
          id: 2,
          name: "Jane",
          review: "Bad product",
          rating: 2,
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
  computed: {
    isProductInCart() {
      return this.cart[this.product.id];
    },
  },
};
</script>

<template>
  <div class="row">
    <div class="col-4">
      <img :src="product.imagePath" alt="product.name" class="img-fluid" />
    </div>
    <div class="col-8">
      <h3>{{ product.name }}</h3>
      <h4>&#8377;{{ product.price }}</h4>
      <button
        :disabled="isProductInCart"
        class="btn btn-primary"
        @click="(e) => this.addToCart(product)"
      >
        Add to Cart
      </button>
      <ul class="nav nav-tabs mt-3">
        <li class="nav-item">
          <a
            @click="handleTabChange($event, 1)"
            :class="{ 'nav-link': true, active: isTabSelected(1) }"
            :style="{ cursor: 'pointer' }"
            >Description</a
          >
        </li>
        <li class="nav-item">
          <a
            @click="handleTabChange($event, 2)"
            :class="{ 'nav-link': true, active: isTabSelected(2) }"
            :style="{ cursor: 'pointer' }"
            >Sepcification</a
          >
        </li>
        <li class="nav-item">
          <a
            @click="handleTabChange($event, 3)"
            :class="{ 'nav-link': true, active: isTabSelected(3) }"
            :style="{ cursor: 'pointer' }"
            >Reviews</a
          >
        </li>
      </ul>
      <div v-if="isTabSelected(1)">{{ product.description }}</div>
      <div v-if="isTabSelected(2)">Not yet</div>
      <div v-if="isTabSelected(3)">
        <div v-for="review in reviews" :key="review.id">
          <Review :review="review" />
        </div>
      </div>
    </div>
  </div>
</template>