

<script>
export default {
  name: "CartBadge",
  // props: {
  //   cart: {
  //     type: Array,
  //     required: true,
  //   },
  // },
  inject: ["cart"],
};
</script>

<template>
  <div>
    <i class="fa fa-shopping-cart"></i> {{ Object.keys(cart).length }} item(s)
    cart
  </div>
</template>