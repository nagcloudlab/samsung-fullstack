
<script setup>
import { ref } from "vue";

const count = ref(0); // primitive value , string , simple object

const increment = () => {
  count.value++;
};

const decrement = () => {
  count.value--;
};
</script>

<template>
  <div class="card">
    <div class="card-header">CounterV2: Composition Api - ref()</div>
    <div class="card-body">
      <p>{{ count }}</p>
      <button @click="increment">Increment</button>
      <button @click="decrement">Decrement</button>
    </div>
  </div>
</template>