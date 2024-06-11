// let & const keywords
// function with default parameters & rest parameters
// arrow functions
// template literals e.g `Hello ${name}`
// destructuring
// spread operator

// destructuring
// reading data elements from array or object to variables

// const person = {
//   name: "John",
//   age: 30,
//   address: "chennai",
// };

// const myName = person.name;
// const myAge = person.age;

// or

// const { name: myName, age: myAge } = person;

// const { name: name, age: age } = person;
// or
// const { name, age, address = "universe" } = person;

const fruitsInventory = [
  { name: "apple", quantity: 2 },
  { name: "orange", quantity: 3 },
  { name: "banana", quantity: 5 },
  { name: "grapes", quantity: 1 },
  { name: "mango", quantity: 6 },
];

// const firstFruit = fruitsInventory[0];
// const secondFruit = fruitsInventory[1];
// const restFruits = fruitsInventory.slice(2);

const [firstFruit, secondFruit, ...restFruits] = fruitsInventory;
// console.log(firstFruit);
// console.log(secondFruit);
// console.log(restFruits);

//--------------------------------------------

// spread operator
const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6, 7];

const arr3 = arr1.concat(arr2);
console.log(arr3);

const arr4 = [...arr1, ...arr2];
console.log(arr4);

const arr5 = [...arr1, 10, ...arr2];
console.log(arr5);

const person = {
  name: "John",
  age: 30,
  address: "chennai",
};

const person1 = { ...person, age: 40 };
console.log(person1);
const person2 = { ...person, age: 40, address: "bangalore" };

const values = [10, 20, 30];

function sum(a, b, c) {
  return a + b + c;
}

console.log(sum(values[0], values[1], values[2]));
console.log(sum(...values));

//--------------------------------------------
