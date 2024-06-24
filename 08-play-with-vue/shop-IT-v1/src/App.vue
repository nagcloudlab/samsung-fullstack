<script>
export default {
  name: "App",
  data() {
    return {
      title: "shop-IT-v1",
      currentTab: 1, // state
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
  <div class="container">
    <div class="display-1">{{ title }}</div>
    <hr />
    <div class="list-group">
      <div v-for="product in products" :key="product.id">
        <div class="list-group-item mt-2">
          <div class="row">
            <div class="col-4">
              <img
                :src="product.imagePath"
                alt="product.name"
                class="img-fluid"
              />
            </div>
            <div class="col-8">
              <h3>{{ product.name }}</h3>
              <h4>&#8377;{{ product.price }}</h4>
              <button :disabled="!product.isAvailable" class="btn btn-primary">
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
              <div v-if="isTabSelected(3)">None yet</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
