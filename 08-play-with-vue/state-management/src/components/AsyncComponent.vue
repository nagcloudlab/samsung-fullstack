<template>
  <div>
    <Suspense>
      <template #default>
        <AsyncHelloWorld />
      </template>
      <template #fallback>
        <div>Loading...</div>
      </template>
    </Suspense>
  </div>
</template>

<script>
import { defineAsyncComponent } from "vue";

const AsyncHelloWorld = defineAsyncComponent({
  // The factory function that dynamically imports the component
  loader: () => import("./Hello.vue"),
  // The delay before showing the fallback content
  delay: 5000,
  // The component to show if the load fails
  errorComponent: {
    template: "<div>Error loading component.</div>",
  },
  // The component to show while loading
  loadingComponent: {
    template: "<div>Loading...</div>",
  },
  // Time before the component times out and shows the error component
  timeout: 3000,
});

export default {
  components: {
    AsyncHelloWorld,
  },
};
</script>
