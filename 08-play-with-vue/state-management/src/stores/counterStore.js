

import {
    defineStore
} from 'pinia'

export const useCounterStore = defineStore("counter", {
    state: () => ({
        count: 10
    }),
    actions: {
        increment(payload = 1) {
            console.log(payload);
            this.count += payload
        },
        decrement() {
            this.count--
        }
    },
    getters: {
        doubleCount() {
            return this.count * 2
        }
    }

})