<script setup>
import TheWelcome from "../components/TheWelcome.vue";
import CounterV1 from "../components/CounterV1.vue";
import CounterV2 from "../components/CounterV2.vue";
import CounterV3 from "../components/CounterV3.vue";
import CounterV4 from "../components/CounterV4.vue";
import CounterV5 from "../components/CounterV5.vue";

import { useUserStore } from "../stores/userStore";

const store = useUserStore();
</script>

<template>
  <main>
    <hr />
    {{ store.user }}
    <hr />
    <!-- <CounterV1 /> -->
    <!-- <CounterV2 /> -->
    <!-- <CounterV3 /> -->
    <!-- <CounterV4 /> -->
    <CounterV5 />
  </main>
</template>
