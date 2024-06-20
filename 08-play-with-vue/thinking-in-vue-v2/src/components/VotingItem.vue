

<script setup>
defineProps({
  item: {
    type: String,
    default: "Item",
    // required: true,
    validator: (value) => value.trim().length > 0,
  },
});

const emitVote = defineEmits(["vote"]);

const handleVote = (item, type) => {
  console.log(type);
  emitVote("vote", { item, type });
};
</script>


<template>
  <div class="card-box">
    <div class="card">
      <div class="card-body">
        <div class="display-3">{{ item }}</div>
        <hr />
        <div class="d-flex justify-content-around">
          <button @click="handleVote(item, 'like')" class="btn btn-primary">
            Like
          </button>
          <button @click="handleVote(item, 'dislike')" class="btn btn-danger">
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