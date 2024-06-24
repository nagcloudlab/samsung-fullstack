

import {
    defineStore
} from 'pinia'

export const useTodosStore = defineStore("user", {
    state: () => ({
        todos: []
    }),
    actions: {
        async fetchTodos() {
            // fetch todos from the server
            if (this.todos.length === 10) return
            const response = await fetch("https://jsonplaceholder.typicode.com/todos?_limit=10")
            const todos = await response.json()
            this.todos = todos
        }
    },

})