
<script setup>
import { ref, onMounted } from 'vue'
const todos = ref([])
const fetchTodos = async () => {
  const response = await fetch('http://localhost:8080/api/todos')
  todos.value = await response.json()
}
onMounted(fetchTodos)
const addNewTodo = async (title) => {
  const newTodo = { title }
  const response = await fetch('http://localhost:8080/api/todos', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(newTodo)
  })
  const savedTodo = await response.json()
  todos.value.push(savedTodo)
}
const handleNewTodo = async (e) => {
  if (e.key !== 'Enter') return
  await addNewTodo(e.target.value)
  e.target.value = ''
}

const deleteTodo = async (id) => {
  await fetch(`http://localhost:8080/api/todos/${id}`, {
    method: 'DELETE'
  })
  todos.value = todos.value.filter((todo) => todo.id !== id)
}
</script>

<template>
  <div>
    <h1>Todos</h1>
    <input type="text" placeholder="Add todo" @keyup="handleNewTodo" />
    <hr />
    <ul>
      <li v-for="todo in todos" :key="todo.id">
        <div>
          <input type="checkbox" :checked="todo.completed" />
          <span>{{ todo.title }}</span>
          <button @click="deleteTodo(todo.id)">Delete</button>
        </div>
      </li>
    </ul>
    <hr />
  </div>
</template>