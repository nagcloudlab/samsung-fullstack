
// todo = {id,title,completed}
class Todo {
    static nextId = 1;
    constructor(title) {
        this.id = Todo.nextId++;
        this.title = title;
        this.completed = false;
    }
}

class TodosService {

    todos = [];

    addTodo(title) {
        const todo = new Todo(title);
        // this.todos.push(todo); // mutates the array
        // this.todos=this.todos.concat(todo); // creates a new array
        this.todos = [...this.todos, todo]; // creates a new array
    }

    editTodo(id, title) {
        // mutates the array
        // const todo = this.todos.find(todo => todo.id === id);
        // if (todo) {
        // todo.title = title;

        // creates a new array
        this.todos = this.todos.map(todo => {
            if (todo.id === id) {
                return { ...todo, title };
            }
            return todo;
        });
    }

    deleteTodo(id) {

        // mutates the array
        // const index = this.todos.findIndex(todo => todo.id === id);
        // if (index !== -1) {
        //     this.todos.splice(index, 1);
        // }

        // creates a new array
        this.todos = this.todos.filter(todo => todo.id !== id);
    }

    completeTodo(id) {

        // mutates the array
        // const todo = this.todos.find(todo => todo.id === id);
        // if (todo) {
        // todo.completed = !todo.completed;
        // }

        // creates a new array
        this.todos = this.todos.map(todo => {
            if (todo.id === id) {
                return { ...todo, completed: !todo.completed };
            }
            return todo;
        });
    }

    completeAll() {

        // toggle the state of all todos
        const areAllCompleted = this.todos.every(todo => todo.completed);

        // mutates the array
        // this.todos.forEach(todo => todo.completed = !areAllCompleted);

        // creates a new array
        this.todos = this.todos.map(todo => ({ ...todo, completed: !areAllCompleted }));

    }

    clearCompleted() {
        // mutates the array

        // creates a new array
        this.todos = this.todos.filter(todo => !todo.completed);

    }
    viewTodos(filterFlag = 'all') {
        console.table(this.todos.filter(TODO_FILTERS[filterFlag]));
    }

}

const TODO_FILTERS = {
    all: (todo) => true,
    active: (todo) => !todo.completed,
    completed: (todo) => todo.completed
}

const todosService = new TodosService();
todosService.addTodo('foo');
todosService.addTodo('bar');
todosService.addTodo('bim');
todosService.editTodo(3, 'baz');
todosService.deleteTodo(2);
todosService.viewTodos("completed");