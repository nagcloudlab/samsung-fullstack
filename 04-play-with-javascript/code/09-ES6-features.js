// let & const keywords
// function with default parameters & rest parameters
// arrow functions
// template literals e.g `Hello ${name}`
// destructuring
// spread operator
// classes
// iterable objects
// for of loop => to iterate iterable objects
// Symbol
// enhanced object literals

//--------------------------------------------
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
// console.log(arr3);

const arr4 = [...arr1, ...arr2];
// console.log(arr4);

const arr5 = [...arr1, 10, ...arr2];
// console.log(arr5);

const person = {
  name: "John",
  age: 30,
  address: "chennai",
};

const person1 = { ...person, age: 40 };
// console.log(person1);
const person2 = { ...person, age: 40, address: "bangalore" };

const values = [10, 20, 30];

function sum(a, b, c) {
  return a + b + c;
}

// console.log(sum(values[0], values[1], values[2]));
// console.log(sum(...values));

//--------------------------------------------

// classes

// befor ES6

// function Person(name, age) {
//   this.name = name;
//   this.age = age;
// }
// Person.prototype.sayHello = function () {
//   console.log(`Hello ${this.name}`);
// };

// const person3 = new Person("John", 30);

// from ES6

// const person3 = new Person("John", 30); // error

class Person {
  static staticProperty = 100;
  static staticMethod() {
    console.log("Person:: staticMethod");
  }
  constructor(name, age) {
    this.name = name;
    this.age = age;
    console.log("Person:: constructor");
  }
  sayHello() {
    console.log(`Hello ${this.name}`);
  }
}

// const person3 = new Person("John", 30);

class Employee extends Person {
  constructor(name, age, salary) {
    super(name, age);
    this.salary = salary;
    console.log("Employee:: constructor");
  }
  work() {
    console.log(`${this.name} is working`);
  }
  askForBonus() {
    return this.salary * 0.2;
  }
}

// const emp = new Employee("John", 30, 5000);

class Boss extends Employee {
  work() {
    console.log(`${this.name} is managing`);
  }
  askForBonus() {
    return this.salary * 0.5 + super.askForBonus();
  }
}

// const boss = new Boss("John", 30, 5000);
// console.log(boss.askForBonus());

//--------------------------------------------

// a objetc which has many data elements => data structure
// reading elements from data structure => iteration/looping
// a object having iteration logic => iterator
// data structure having iterator => iterable

// --------------------------------------------

// iterable objects
// e.g array, set, map, string

const str = "hello";

for (let ch of str) {
  // console.log(ch);
}

const arr = [10, 20, 30];

for (let num of arr) {
  // console.log(num);
}

const myBox = {
  data: [10, 20, 30, 50, 60],
  [Symbol.iterator]: function () {
    let index = 0;
    return {
      next: () => {
        if (index < this.data.length) {
          return { value: this.data[index++], done: false };
        } else {
          return { done: true };
        }
      },
    };
  },
};

for (let num of myBox) {
  // console.log(num);
}
let numbers = [...myBox];
let [n1, n2, n3, n4, n5] = myBox;

// what is symbol ?
// unique value in javascript runtime
// why we need symbol ?
// to create unique property names in object

// built-in symbols
// Symbol.iterator
// Symbol.toStringTag
// Symbol.species
// Symbol.hasInstance

// if an object has Symbol.iterator property,
// then it is iterable object

// iterable objects are spreadable
// iterable objects are destructurable
// iterable objects are loopable using for of loop

// --------------------------------------------

// const config = new Object();
// config.url = "http://localhost";
// config.method = "GET";
// config.timeout = 3000;

// // or

// const config1 = {
//   url: "http://localhost",
//   method: "GET",
//   timeout: 3000,
// };

// enhanced object literals

const url = "http://localhost";
const method = "GET";
const timeout = 3000;

const beforeES6 = {
  url: url,
  method: method,
  timeout: timeout,
  onSucess: function () {
    console.log("success");
  },
  3: "value",
};

const afterES6 = {
  url,
  method,
  timeout,
  onSucess() {
    console.log("success");
  },
  [1 + 2]: "value",
};

const addressType = "home"; // home or office

const person11 = {
  name: "John",
  age: 30,
  address: {
    [addressType + "-address"]: "chennai",
  },
};

//--------------------------------------------

// generator functions

// normal function vs generator function

function normalFunction() {
  console.log("line1");
  console.log("line2");
  console.log("line3");
  return "done";
}

// normalFunction();

function* generatorFunction() {
  console.log("line1");
  yield "need some to continue line-2";
  console.log("line2");
  yield "need some to continue line-3";
  console.log("line3");
  return "done";
}

// e.g

function* sum() {
  // need x, y, z value
  console.log("sum intialized");
  const x = yield "enter x";
  console.log("x received");
  const y = yield "enter y";
  console.log("y received");
  const z = yield "enter z";
  console.log("z received");
  return x + y + z;
}

const sumItr = sum();
sumItr.next();
setTimeout(() => {
  sumItr.next(10);
  setTimeout(() => {
    sumItr.next(20);
    setTimeout(() => {
      const r = sumItr.next(30);
      console.log(r);
    }, 2000);
  }, 2000);
}, 2000);

// --------------------------------------------

// subclassing built-in objects
class MyString extends String {
  constructor(str) {
    super(str);
  }
  reverse() {
    return this.split("").reverse().join("");
  }
}

//--------------------------------------------

const smile = "😊";
console.log(smile.length);

//--------------------------------------------

// Modules : how to share code between files
// Asynchronous programming : callbacks, promises, async/await

// --------------------------------------------
