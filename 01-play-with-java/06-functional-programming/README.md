


style of programming
-----------------------

- imperative
    
-> solving any problem by telling the computer what to do step by step

problem:

    - intention & implementation mixed together
    - code is not reusable

- declarative

-> solving any problem by telling the computer what to do, not how to do

    - intention & implementation separated
    - code is reusable

how to write code in declarative style?

- by primitive params
- by object params
- by function params (functional programming)


--------------------------------------------


java is on object-oriented programming language

    - data & functions are grouped together as objects
    - any function over object => method

--------------------------------------------

// till java 1.7,

Predicate predicate=new Predicate() {
    @Override
    public boolean test(Apple apple) {
    return "red".equals(apple.color());
    }
}

// from 1.8

// Function in Java aka Lambda Expression

Predicate predicate= (Apple apple) -> {
return "red".equals(apple.color());
}

--------------------------------------------
Function in other language
--------------------------------------------

// Javascript
function isRed(apple) {
    return "red" === apple.color;
}

// python
def is_red(apple):
    return "red" == apple.color

// scala
def isRed(apple:Apple):Boolean = {
    "red" == apple.color
}

--------------------------------------------