
<script setup>
import { reactive } from "vue";
import CountDisplay from "./CountDisplay.vue";
import CountButtons from "./CountButtons.vue";

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
    <div class="card-header">CounterV4: parent & child</div>
    <div class="card-body">
      <CountDisplay :count="state.count" />
      <hr />
      <CountButtons
        :count="state.count"
        @increment="increment"
        @decrement="decrement"
      />
    </div>
  </div>
</template>