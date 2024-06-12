"use strict";

// arrow function is a new way to write function in ES6

// 2 ways to create function in JS
// 1. function declaration
// 2. function expression

// function expression

// regular function
// const getPrice = function (count) {
//   return count * 100;
// };

// arrow function
// const getPrice = (count, tax) => {
//   const price = count * 100;
//   const total = price + price * tax;
//   return total;
// };

// regular function vs arrow function

// why/where we need arrow function ?

// use-case-1 : for compact function-argument

// const numbers = [1, 3, 5, 7, 9, 2, 4, 6, 8, 10];
// numbers.sort((a, b) => a - b);
// console.log(numbers);

// use-case-2 : to capture 'this'

// console.log(this); // global scope owned by global-object

// function regularFunction() {
//   console.log(this);
// }
// regularFunction();

// const arrowFunction = () => {
//   console.log(this);
// };
// arrowFunction();

// regular function not capturing 'this' ( creator )
// arrow function capturing 'this' ( creator )

// function fnFactory() {
//   console.log(this);
//   //   return function () {
//   //     console.log(this);
//   //   };
//   return () => {
//     console.log(this);
//   };
// }

// const foo = { name: "foo" };

// const fn = fnFactory.call(foo);
// fn();

// Quiz

// const trainer = {
//   name: "Nag",
//   doTeach: function () {
//     console.log(this.name + " teaching .js");
//     //let self = this;
//     let askQues = (ques) => {
//       console.log(this.name + " anwering question " + ques);
//     };
//     console.log("teaching ends");
//     return askQues;
//   },
// };

// const askQues = trainer.doTeach();
// askQues("Q1");

// const tempTrainer = { name: "Ria" };
// askQues.call(tempTrainer, "Q2");

// Quiz

const invoice = {
  number: 123,
  process: function () {
    console.log("INV-" + this.number + " is processed partially");
    return () => {
      console.log("INV-" + this.number + " is processed completly");
    };
  },
};

// const complete = invoice.process();
// complete();
