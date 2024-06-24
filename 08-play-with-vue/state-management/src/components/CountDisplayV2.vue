

<script setup>
import { useCounterStore } from "../stores/counterStore";
import { vHighlight } from "../directives/vHighlight";

const store = useCounterStore();
</script>

<template>
  <div class="card">
    <p v-highlight class="card-body">
      {{ store.count }} , {{ store.doubleCount }}
    </p>
  </div>
</template>