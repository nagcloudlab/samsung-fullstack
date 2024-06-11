// a function is an object
// a function is a first class citizen
// a function can be passed as an argument to another function
// a function can be returned by another function
// a function can be assigned to a variable

// A.how to create a function?

// 2 ways

// 1. function declaration

// console.log(add(12, 13));

// function add(n1, n2) {
//   return n1 + n2;
// }

// console.log(add(12, 13));

// function declaration are hoisted with function object

// 2. function expression

// console.log(add(12, 13));

// var add = function (n1, n2) {
//   return n1 + n2;
// };

// console.log(add(12, 13));

// function expression are not hoisted with function object,
// we can't call a function expression before it's declaration

// B.function parameters

// function f(a, b) {
//   console.log(a, b);
//   console.log(arguments[0]);
//   console.log(arguments[1]);
//   console.log(arguments[2]);
//   console.log(arguments[3]);
//   console.log(arguments[4]);
// }
// f(10, 20, 30, 40, 50);

// Ex. sum of given numbers

function sum() {
  var result = 0;
  for (var i = 0; i < arguments.length; i++) {
    result += arguments[i];
  }
  return result;
}

// console.log(sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
// console.log(sum(1, 2, 3, 4, 5));
// console.log(sum(1, 2, 3, 4));
// console.log(sum(1, 2, 3));
// console.log(sum(1, 2));
// console.log(sum(1));

// can we overload a function in javascript by params ? No

// function getFood() {
//   return "No Food";
// }

// function getFood(pay) {
//   if (arguments.length === 0) return "No Food";
//   return "Biryani";
// }

// console.log(getFood());

// function add(a, b) {
//   if (typeof a !== "number" || typeof b !== "number") {
//     throw new Error("Invalid arguments");
//   }
//   return a + b;
// }

// console.log(add(12, 13));
// console.log(add("hell", "world"));

// in Es6, funtion with default params

// function f(a = 1, b = 2) {
//   console.log(a, b);
// }
// f(undefined, 20);

// function with rest params

// function f(a, b, ...rest) {
//   console.log(a, b);
//   console.log(rest);
// }

// f(1, 2, 3, 4, 5, 6, 7, 8);

// C. How to return a value from a function?
// by default, a function returns undefined

// function f1() {
//   return 10;
//   //   return undefined;
// }
// console.log(f1());

// principle of function
// a function can be assigned to a variable
// a function is a first class citizen
// a function can be passed as an argument to another function
// a function can be returned by another function

// a function can be assigned to a variable
// function greet() {
//   console.log("Hello");
// }

// const sayHello = greet;
// sayHello();

// Function as an argument

function greet(f) {
  if (typeof f === "function") {
    console.log("😀😀😀😀😀😀");
    f();
    console.log("😀😀😀😀😀😀");
    return;
  }
  throw new Error("Invalid arguments");
}

function timeBasedGreet() {
  var hours = new Date().getHours();
  if (hours < 12) {
    console.log("Good Morning");
    return;
  }
  if (hours < 17) {
    console.log("Good Afternoon");
    return;
  }
  console.log("Good Evening");
}

// timeBasedGreet();

// greet(timeBasedGreet);

// ex2

const numbers = [1, 3, 5, 7, 9, 2, 4, 6, 8, 10];
// numbers.sort();
function compare(a, b) {
  return a - b;
}
numbers.sort(compare);

// console.log(numbers);

// Function as a return value

function teach() {
  console.log("teaching...");
  function learn() {
    console.log("learning...");
  }
  console.log("teaching ends");
  return learn;
}

// const learnFn = teach();
// learnFn();
// learnFn();

// Higher Order Function (HOF)

// a function that takes one or more functions as arguments
// or returns a function as a result is called HOF

function hello() {
  console.log("Hello");
}
function hi() {
  console.log("Hi");
}
function hey() {
  console.log("Hey");
}

// design issues
// code tangling
// code scattering

// solution : HOF

function withSmile(f) {
  return function () {
    f();
    console.log("😊😊😊😊😊😊");
  };
}

// hello();
// const helloWithSmile = withSmile(hello);
// helloWithSmile();
// withSmile(hi)();

// function closure

// -> closure is a function along with it's lexical scope
// -> a function can able to read/write parent-scope even after the parent function has completed

function teach(sub) {
  console.log(`teaching ${sub}`);
  let notes = `${sub}-notes`;
  let fun = "bla bla bla";
  function learn() {
    console.log("learning with " + notes);
  }
  //   learn();
  console.log("teaching ends");
  return learn;
}

const learnFn = teach("javascript");
learnFn();

// why/where we need closure ?

// -> to abstract public behav of any module
// -> while executing func async, to access parent-scope data
