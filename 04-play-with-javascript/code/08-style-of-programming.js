// style of programming

// 1. imperative style

// solving a problem with step-by-step approach
// intention & implementation are mixed

// 2. declarative style

//  by behvaiour paramerization

//--------------------------------------------

const fruitsInventory = [
  { name: "apple", quantity: 2 },
  { name: "orange", quantity: 3 },
  { name: "banana", quantity: 5 },
  { name: "grapes", quantity: 1 },
  { name: "mango", quantity: 6 },
];

function filterFruits(fruits, callback) {
  const filteredFruits = [];
  for (let i = 0; i < fruits.length; i++) {
    if (callback(fruits[i])) {
      filteredFruits.push(fruits[i]);
    }
  }
  return filteredFruits;
}

// req-1: filter apples

let result = filterFruits(fruitsInventory, (fruit) => fruit.name === "apple");
console.log(result);
result = filterFruits(fruitsInventory, (fruit) => fruit.quantity > 2);
console.log(result);
