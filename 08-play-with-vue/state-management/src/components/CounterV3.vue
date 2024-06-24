
<script setup>
import { reactive } from "vue";

// to make every property of the object reactive
const state = reactive({
  count: 0,
});

const increment = () => {
  state.count++;
};

const decrement = () => {
  state.count--;
};
</script>

<template>
  <div class="card">
    <div class="card-header">CounterV3: Composition Api - reactive()</div>
    <div class="card-body">
      <p>{{ state.count }}</p>
      <button @click="increment">Increment</button>
      <button @click="decrement">Decrement</button>
    </div>
  </div>
</template>