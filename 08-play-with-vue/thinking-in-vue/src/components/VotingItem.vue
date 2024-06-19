
<script>
export default {
  name: "VotingItem",
  props: {
    item: {
      type: Object,
      required: true,
    },
  },
  emits: ["like", "dislike"],
  methods: {
    handleLike(item) {
      // emit an event to the parent component
      this.$emit("like", item);
    },
    handleDislike(item) {
      this.$emit("dislike", item);
    },
  },
};
</script>

<template>
  <div class="card-box">
    <div class="card">
      <div class="card-body">
        <div class="display-3">{{ item.name }}</div>
        <hr />
        <div class="d-flex justify-content-around">
          <button @click="handleLike(item)" class="btn btn-primary">
            Like
          </button>
          <button @click="handleDislike(item)" class="btn btn-danger">
            Dislike
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.card-box {
  margin: 10px;
  width: 300px;
}
</style>