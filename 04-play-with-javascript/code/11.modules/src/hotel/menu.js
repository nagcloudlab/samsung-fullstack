


const primaryItem = {
    name: "biryani",
    price: 200
}

// module.exports = primaryItem; /// cjs
export default primaryItem; /// esm


const item1 = {
    name: "item-1",
    price: 200
}

const item2 = {
    name: "item-2",
    price: 200
}

export { item1, item2 }; // named export