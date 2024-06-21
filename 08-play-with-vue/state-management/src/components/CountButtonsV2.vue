



<script setup>
import { useCounterStore } from "../stores/counterStore";
const store = useCounterStore();
</script>

<template>
  <div class="card">
    <p class="card-body">
      <!-- <button :disabled="store.count === 5" @click="store.count++">
        Increment
      </button>
      <button :disabled="store.count === 0" @click="store.count--">
        Decrement
      </button> -->

      <button :disabled="store.count > 50" @click="store.increment(1)">
        Increment
      </button>
      <button :disabled="store.count > 50" @click="store.increment(10)">
        Increment by 10
      </button>
      <button :disabled="store.count === 0" @click="store.decrement">
        Decrement
      </button>
    </p>
  </div>
</template>