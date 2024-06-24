"use strict";

// function add(a, b) {
//   return a + b;
// }
// console.log(add(12, 13));

// function sayName() {
//   console.log(this);
//   console.log("Hello, im " + this.name);
// }

// sayName();

// funtion binding : function invocation with object
// if function depends on object,
// then we can bind that function with object

// by default, every function bound with window object
// in browser(non strict mode)

// in strict mode, this will be undefined

// 2 types of function binding

// 1. static binding
// 2. dynamic binding

// 1. static binding

function sayName() {
  console.log(this);
  console.log("Hello, im " + this.name);
}

const person1 = {
  name: "Riya",
  sayName: sayName,
};
// person1.sayName();

const person2 = {
  name: "Diya",
};
person2.sayName = sayName; // becoz object is extensible
// person2.sayName();

// 2. dynamic binding

//------------------------------------------------------------
// samnsung training department
//------------------------------------------------------------
function doSamsungTraining(sub, duration, mode) {
  console.log(this);
  console.log(
    `${this.name} is doing ${sub} training of ${duration} hours in ${mode} mode`
  );
}

// doTraining("JS", 2, "online");

//------------------------------------------------------------
// vendor trainer
//------------------------------------------------------------
const trainer = {
  name: "Nag",
};
Object.preventExtensions(trainer); // trainer object is not extensible

// when an object is not extensible, we can't add new properties to that object

// dynamic function binding

// way-1 : call() => binding + invocation
doSamsungTraining.call(trainer, "JS", 2, "online");

// way-2 : apply() => binding + invocation
doSamsungTraining.apply(trainer, ["JS", 2, "online"]);

// way-3 : bind() => binding
const newF = doSamsungTraining.bind(trainer, "JS");
newF(2, "online");
newF(3, "offline");

// summary

// if function only depends on input arguments then no need to bind with object
// if function depends on object then bind that function with object

class Person {
  constructor(name) {
    this.name = name;
  }
  sayName() {
    console.log(this);
    console.log("Hello, im " + this.name);
  }
}

const p1 = new Person("Riya");
p1.sayName(); // static binding
const p2 = new Person("Diya");
p2.sayName(); // static binding

const p = {
  name: "Nag",
  sayName: function () {
    // static binding
    console.log(this);
    console.log("im " + this.name);
  },
};

function sayNameForAll() {
  console.log(this);
  console.log("im " + this.name);
}

const p11 = {
  name: "Riya",
};

const p22 = {
  name: "Diya",
};

// static binding
// sayNameForAll(); // im ???

p11.sayName = sayNameForAll;
p22.sayName = sayNameForAll;
