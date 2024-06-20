

<script setup>
import VotingItem from "./VotingItem.vue";
import VotingTable from "./VotingTable.vue";
import { ref } from "vue";

const items = ref([
  { name: "foo", likes: 0, dislikes: 0 },
  { name: "bar", likes: 0, dislikes: 0 },
  { name: "baz", likes: 0, dislikes: 0 },
]);

const handleVote = ({ item, type }) => {
  console.log("handlingVote..");
  const index = items.value.findIndex((i) => i.name === item);
  if (type === "like") {
    items.value[index].likes++;
  } else {
    items.value[index].dislikes++;
  }
};
</script>

<template>
  <div class="card">
    <div class="card-header">Voting Box</div>
    <div class="card-body">
      <div class="d-flex flex-wrap">
        <VotingItem item="foo" @vote="handleVote($event)" />
        <VotingItem item="bar" @vote="handleVote($event)" />
      </div>
      <VotingTable :items="items" />
    </div>
  </div>
</template>