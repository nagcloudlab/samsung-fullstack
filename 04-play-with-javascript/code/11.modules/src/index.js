
const greet = require('nagcloudlab-greet') // cjs
// const primaryItem = require('./hotel/menu') // cjs
// import primaryItem, { item1, item2 } from './hotel/menu' // esm
// import * as menu from './hotel/menu' // esm
// import mainItem, { item1 as a, item2 as b } from './hotel/menu';

const menu = require('./hotel/menu') // cjs

console.log(menu.default);
console.log(menu.item1);
console.log(menu.item2);