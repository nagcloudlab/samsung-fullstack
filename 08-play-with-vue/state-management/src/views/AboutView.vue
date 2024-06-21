
<script setup>
import { useCounterStore } from "../stores/counterStore";
const store = useCounterStore();
</script>

<template>
  <div class="container">
    <hr />
    <button @click="store.increment(1)" style="font-size: 30px">
      {{ store.count }}
    </button>
  </div>
</template>

<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
  }
}
</style>
