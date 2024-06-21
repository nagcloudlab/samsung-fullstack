

import {
    defineStore
} from 'pinia'

export const useUserStore = defineStore("user", {
    state: () => ({
        user: {
            name: "John Doe",
            email: "john@mail.com",
        }
    }),
    actions: {

    },
    getters: {
    }

})