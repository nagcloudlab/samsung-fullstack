

<script>
export default {
  name: "Review",
  props: {
    review: {
      type: Object,
      required: true,
    },
  },
  computed: {
    starRating() {
      let stars = "";
      for (let i = 0; i < this.review.rating; i++) {
        stars += "⭐";
      }
      return stars;
    },
  },
};
</script>

<template>
  <div class="card mt-2">
    <div class="card-body">
      <h5 class="card-title">{{ review.name }}</h5>
      <p class="card-text">Rating: {{ starRating }}</p>
      <p class="card-text">{{ review.review }}</p>
    </div>
  </div>
</template>