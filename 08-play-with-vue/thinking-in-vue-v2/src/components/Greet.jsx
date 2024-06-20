import { defineComponent } from 'vue';

export default defineComponent({
    name: 'Greet',
    setup() {
        return () => (
            <div class="my-component">
                <h1>Hello, Vue 3!</h1>
                <p>This is a JSX example.</p>
            </div>
        );
    }
});
