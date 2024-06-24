
<script setup>
import { useTodosStore } from "../stores/todosStore";
import { onMounted } from "vue";
import { vHighlight } from "../directives/vHighlight";
const todosStore = useTodosStore();

onMounted(() => {
  todosStore.fetchTodos();
});
</script>

<template>
  <div class="container">
    <hr />
    <h1>Todos</h1>
    <ul class="list-group">
      <li
        class="list-group-item"
        v-for="todo in todosStore.todos"
        :key="todo.id"
        v-highlight="'#DEF'"
      >
        <input
          type="checkbox"
          :checked="todo.completed"
          @change="todosStore.toggleTodo(todo.id)"
        />
        <span :class="{ completed: todo.completed }">{{ todo.title }}</span>
      </li>
    </ul>
  </div>
</template>


