"use strict";

function Person(name, age) {
    this.name = name;
    this.age = age;
    setInterval(() => {
        this.age++
        console.log(this.name, this.age);
    }, 1000);
}


const person1 = new Person('Riya', 9);
