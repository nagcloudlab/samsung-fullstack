

<script>
export default {
  name: "CartTable",
  // props: {
  //   cart: {
  //     type: Array,
  //     required: true,
  //   },
  // },
  inject: ["cart", "removeFromCart", "manageQty"],
  methods: {
    remove(id) {
      this.removeFromCart(id);
    },
    handleQtyChange(productId, qty) {
      this.manageQty(productId, qty);
    },
  },
};
</script>

<template>
  <div class="card">
    <div class="card-body">
      <table class="table table-bordered">
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Qty</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(cartLine, productId, index) in cart" :key="index">
            <td>{{ productId }}</td>
            <td>{{ cartLine.product.name }}</td>
            <td>{{ cartLine.product.price }}</td>
            <td>
              <div class="d-flex justify-content-around">
                <button
                  class="btn btn-danger"
                  @click="handleQtyChange(productId, -1)"
                >
                  -
                </button>
                <span>{{ cartLine.qty }}</span>
                <button
                  class="btn btn-primary"
                  @click="handleQtyChange(productId, 1)"
                >
                  +
                </button>
              </div>
            </td>
            <td>
              <button class="btn btn-danger" @click="remove(productId)">
                Remove
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>