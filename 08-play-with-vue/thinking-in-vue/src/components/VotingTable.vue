<script setup>
defineProps({
  items: {
    type: Array,
    required: true,
  },
});
</script>

<template>
  <div class="card">
    <div class="card-header">Voting Table</div>
    <div class="card-body">
      <table class="table">
        <thead>
          <tr>
            <th>Item</th>
            <th>Likes</th>
            <th>Dislikes</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in items" :key="item.name">
            <td>{{ item.name }}</td>
            <td>{{ item.likes }}</td>
            <td>{{ item.dislikes }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>