
<script>
export default {
  name: "Navbar",
  props: {
    title: {
      type: String,
      required: true,
    },
  },
};
</script>

<template>
  <div class="display-1">{{ title }}</div>
</template>