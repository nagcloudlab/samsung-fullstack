
<script setup>
import CountDisplay from "./CountDisplayV2.vue";
import CountButtons from "./CountButtonsV2.vue";
</script>

<template>
  <div class="card">
    <div class="card-header">CounterV5: pinia</div>
    <div class="card-body">
      <CountDisplay />
      <hr />
      <CountButtons />
    </div>
  </div>
</template>