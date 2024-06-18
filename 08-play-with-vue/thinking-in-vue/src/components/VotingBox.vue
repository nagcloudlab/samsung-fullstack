
<script setup>
import VotingItem from "./VotingItem.vue";
import VotingTable from "./VotingTable.vue";
</script>

<script>
export default {
  name: "VotingBox",
  data() {
    return {
      items: [
        { name: "React", likes: 0, dislikes: 0 },
        { name: "Angular", likes: 0, dislikes: 0 },
        { name: "Vue", likes: 0, dislikes: 0 },
        { name: "Svelte", likes: 0, dislikes: 0 },
      ],
    };
  },
  methods: {
    handleLike(item) {
      const index = this.items.findIndex((i) => i.name === item.name);
      this.items[index].likes++;
    },
    handleDislike(item) {
      const index = this.items.findIndex((i) => i.name === item.name);
      this.items[index].dislikes++;
    },
  },
};
</script>

<template>
  <div class="card">
    <div class="card-header">Voting Box</div>
    <div class="card-body">
      <div class="d-flex flex-wrap">
        <VotingItem
          v-for="item in items"
          :key="item.name"
          :item="item"
          @like="handleLike($event)"
          @dislike="handleDislike($event)"
        />
      </div>
      <div>
        <VotingTable :items="items" />
      </div>
    </div>
  </div>
</template>