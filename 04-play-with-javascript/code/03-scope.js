// javascript's scope

// scope is stack-frame with given args and variables
// during the execution of a function

// by default, main function( we wont write )
// creates a global scope

// scope has 2 phase

// 1. creation phase / push phase

// -> hoisting
// any variable declared with 'var' keyword,
// will be hoisted to the top of the function
// and initialized with undefined

// 2. execution phase / pop phase

// // debugger;
// console.log(v);
// var v = 12; // hoisted to the top of the function
// console.log(v);

// every function call creates a new scope,
// which is child of in which scope function is defined

// var v = 12;
// function f1() {
//   console.log(v);
//   var v = 13;
// }
// f1(); // f1-scope -> global-scope

// Quiz

// var v = 12;
// function f1() {
//   function f2() {
//     console.log(v);
//   }
//   f2(); // f2-scope -> f1-scope
//   var v = 13;
// }
// f1(); // f1-scope -> global-scope

// we can re-declare a variable in the same scope
// var v = 12;
// var v = 13;

// no block-scope in javascript, only function-scope
// var v = 12;
// if (true) {
//   var v = 13;
// }
// console.log(v); // 13

// problems with var keyword

// 1. re-declaration allowed
// 2. no block-scope
// 3. hoisting

// solution: let and const keywords (es6)

// let v = 12;
// let v = 13; // error

// let v = 12;
// if (true) {
//   let v = 13;
// }
// console.log(v); // 12

// console.log(v); // error
// let v = 12;

// const v = 12;
// v = 13; // error

// Quiz

const trainer = {
  name: "Nag",
};

// trainer = {}; // error
// trainer = null; // error

trainer.name = "Nag N";
console.log(trainer.name);

// const means, we cant re-assign, but we can mutate

// Summary

// -> use 'let' for mutable reference
// -> use 'const' for immutable reference
// -> avoid 'var' keyword ( for better code)
