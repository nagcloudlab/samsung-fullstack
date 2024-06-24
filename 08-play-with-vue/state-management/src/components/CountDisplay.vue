

<script setup>
defineProps({
  count: Number,
});
</script>

<template>
  <div class="card">
    <p class="card-body">{{ count }}</p>
  </div>
</template>