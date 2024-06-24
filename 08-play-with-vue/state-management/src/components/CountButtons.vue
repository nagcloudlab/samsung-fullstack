



<script setup>
const emit = defineEmits(["increment", "decrement"]);
defineProps({
  count: Number,
});
const increment = () => {
  emit("increment");
};

const decrement = () => {
  emit("decrement");
};
</script>

<template>
  <div class="card">
    <p class="card-body">
      <button :disabled="count === 5" @click="increment">Increment</button>
      <button :disabled="count === 0" @click="decrement">Decrement</button>
    </p>
  </div>
</template>