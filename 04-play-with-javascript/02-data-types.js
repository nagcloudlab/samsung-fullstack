"use strict";

// built-in data types

// primitive data types ==> values
// reference data types ==> objects

// 1. primitive data types ( values )

// a. string
var myName = "John";
var myCompany = "samsung";
var dynamicString = `Hello, ${myName}!`;
var multiLineString = `
    Hello, ${myName}!
    How are you?
`;

// b. number
var myAge = 30;
var mySalary = 30000.5;

// c. boolean
var isMarried = false;
var isEmployed = true;

// d. undefined
var myCar;

// e. null
var myPhone = null;

// udefined vs null
// undefined ==> variable declared but not assigned
// null ==> variable declared and assigned with null value

// f. symbol ( later )

// 2. reference data types ( objects )

// a. Object
var config = new Object();
// -> by default, objects are extensible, configurable, and writable
// extensible ==> can add new properties
config.url = "http://www.example.com";
config.method = "GET";
config.timeout = 3000;
// configurable ==> can delete properties
delete config.timeout;
// writable ==> can change the value of properties
config.method = "POST";

// can change the default behavior of objects

// 1. preventExtensions
// Object.preventExtensions(config);
// config.port = 8080; // error

// 2. seal
// Object.seal(config);
// config.port = 8080; // error
// delete config.method; // error

// 3. freeze
// Object.freeze(config);
// config.port = 8080; // error
// delete config.method; // error
// config.method = "POST"; // error

// literal notation ( preferred )
// var config = new Object();
var config = {
  url: "http://www.example.com",
  method: "GET",
  timeout: 3000,
};

// b. Array

var colors = new Array(); // same as ArrayList in Java
colors[0] = "red";
colors[1] = "green";
colors[2] = "blue";

// literal notation
var colors = ["red", "green", "blue"];

// c. Function
var add = new Function("a", "b", "return a + b;");

// literal notation

function add(a, b) {
  return a + b;
}

// d. Date
var today = new Date();
var birthday = new Date("1990-01-01");

// e. RegExp
var adharPattern = new RegExp("^\\d{4}-\\d{4}-\\d{4}$");
var adharNumber = "1234-5678-9012";
// console.log(adharPattern.test(adharNumber));

// literal notation
var adharPattern = /^\d{4}-\d{4}-\d{4}$/;

// f. Error
// most common error types
// 1. SyntaxError
// 2. ReferenceError
// 3. TypeError
// 4. RangeError
// 5. EvalError
// 6. URIError

// throw new Error("Something went wrong!");

// g. Math
// console.log(Math.PI);

// h. JSON

// JSON ==> JavaScript Object Notation

// 1. JSON.stringify
var person = {
  name: "John",
  age: 30,
  isMarried: false,
};
var personJSON = JSON.stringify(person);

// 2. JSON.parse
var personObject = JSON.parse(personJSON);

//...

// var v = "hello";
// v = 12;
// v = true;
// v = null;

// How to define custom data types ( object types) in JavaScript?

// Person ==> name, age, isMarried, sayHello

// 1. Object Constructor
// -> pascal case naming convention e.g. Person, Employee, Customer
function Person(name, age, isMarried) {
  this.name = name;
  this.age = age;
  this.isMarried = isMarried;
}
Person.prototype.sayHello = function () {
  console.log(`Hello, ${this.name}!`);
};

// create object
var person1 = new Person("John", 30, false);
var person2 = new Person("Jane", 25, true);

// 2. Class ( ES6 ) - 2015

class Employee {
  constructor(name, age, isMarried) {
    this.name = name;
    this.age = age;
    this.isMarried = isMarried;
  }
  sayHello() {
    console.log(`Hello, ${this.name}!`);
  }
}

// create object
var employee1 = new Employee("John", 30, false);
var employee2 = new Employee("Jane", 25, true);

// 3. Factory Function
function createPerson(name, age, isMarried) {
  return {
    name: name,
    age: age,
    isMarried: isMarried,
    sayHello: function () {
      console.log(`Hello, ${this.name}!`);
    },
  };
}

// create object
var person1 = createPerson("John", 30, false);
var person2 = createPerson("Jane", 25, true);

// how to access properties of an object?

const p = {
  name: "John",
  age: 30,
  isMarried: false,
};

// 1. dot notation
console.log(p.name);
// 2. bracket notation
console.log(p["name"]);

let prpertyName = "name";
console.log(p[prpertyName]);

const obj = {
  1: "one",
  2: "two",
  "home-address": "chennai",
  "home address": "chennai",
};

// console.log(obj.1); // error
console.log(obj[1]);
console.log(obj["1"]);
console.log(obj["home-address"]);
console.log(obj["home address"]);
