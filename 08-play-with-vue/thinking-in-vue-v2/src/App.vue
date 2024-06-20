<script setup>
import VotingBox from "./components/VotingBox.vue";
import Modal from "./components/Modal.vue";
// import Greet from "./components/Greet.jsx";
import { ref } from "vue";
const showModal = ref(false);
</script>

<template>
  <div class="container">
    <h1 class="display-1">Voting App</h1>
    <hr />
    <button id="show-modal" @click="showModal = true">Show Modal</button>
    <Teleport to="body">
      <!-- use the modal component, pass in the prop -->
      <modal :show="showModal" @close="showModal = false">
        <template #header>
          <h3>Custom Header</h3>
        </template>
      </modal>
    </Teleport>
    <hr />
    <!-- <Greet /> -->
    <VotingBox />
  </div>
</template>
