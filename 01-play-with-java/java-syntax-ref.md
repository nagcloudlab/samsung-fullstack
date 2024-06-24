## java language syntax

---

1. project

---

myproject  
|
|
|--- p1 ( .java / .class )
|
|--- p2
| |
| |--- p21
|

---

2. Java File

---

## Foo.java

| // package declaration ( 1 )
| // import statements ( n )
| // public type Foo ( type => interface / class / enum / annotation / record ) ( 1)
| // default type(s) ( interface / class / enum / annotation / record ) ( n )
|

---

---

3. package declaration

---

why package declaration?

- to organize the classes
- to avoid name conflicts

package declaration syntax

```java
package p1.p2.p3;
```

recommended guidlines for package declaration

```java
package companytype.companyname.projectname.modulename;
package com.samsung.foo.bar;
```

---

3. import statements

---

project structure
|
| - p1 ( A.java & B.java )
|
| - p2 ( C.java & D.java,E.java )
| |- p21 ( E.java & F.java )

```java
// A.java
package p1;
import p2.*;
import p2.p21.*;
public class A {
  B b;
  C c;
  D d;
  p21.E e;
}
```

syntax

```java
import packagename.*;
import packagename.typename;
```

static import

```java
import static packagename.typename.staticmember;
```

---

## object oriented concepts

---

what is an object ?

- info/data/properties/attributes ( state )
- actions/behaviour/methods ( behaviour )
- identity ( unique )

what is a class ?

- blueprint/template for objects
- class is a user defined data type
- class is a reference type

---

object concepts

- interface / abstration
- implementation / encapsulation
- inheritance
- polymorphism

---

object principles

- Single Responsibility Principle
- Open/Closed Principle
- Liskov Substitution Principle
- Interface Segregation Principle
- Dependency Inversion Principle

---

object patterns

- creational
- structural
- behavioural

---

java is an object oriented programming language

---

6. interface type

---

what is an interface ?

- interface is a reference type
- interface is a contract

interface syntax

```java
________  interface InterfaceName [extends Interface1, Interface2, ...] {
[public]  // data => constants
[      ]  // behaviour => abstract methods
}
```

imp-note: can't create object of an interface

---

6. class type

---

what is a class ?

- class is a reference type
- class is a user defined data type
- class is a blueprint/template for objects

class syntax

```
__________ _____________ class ClassName [extends SuperClass]
                                         [implements Interface1, Interface2, ...] {
[public]   [asbtract]
[      ]   [final]       // state variables
           [strictfp]    // constructor(s)
                         // behaviour => methods
________________________
[private]   [static]     // inner types
[protected]
[         ]
[public]
                          }
```

---

6. enum type

---

what is an enum ?

- enum is a reference type
- enum is a special class
- enum is a collection of constants

e.g days of the week, months of the year, colors

```
  enum EnumName {
    constant1, constant2, constant3, ...
  }
```

---

6. annotation type

---

what is an annotation ?

- annotation is a reference type
- annotation is a special interface
- annotation is a metadata

- to describe the java programming elements ( classes, methods, variables, packages )
  to provide the additional info to the compiler, runtime, tools

annotation syntax

```
  @interface AnnotationName {
    // data => constants
  }
```

---

7. record type

---

what is a record ?

- record is a reference type
- record is a special class
- record is a data carrier

record syntax

```
  record RecordName ( type1 var1, type2 var2, ... ) {
    // state variables
    // constructor
    // behaviour => methods
  }
```

---

8. variables

---

what is a variable ?

- variable is a container to store the data
- variable is a reference to the memory location
- variable is a name of the memory location

variable syntax

```
  type varname;
  type varname = value;
```

2 types of variables based on the data type

1. primitive type ( byte, short, int, long, float, double, char, boolean )
2. reference type ( class, interface, enum, annotation, record )

3 types of variables based on the scope

1. local variable ( method level )
2. instance variable ( class level )
3. static/class variable ( class level )

```
  _______    _______ type varname= [value/instance];
  [public]   [static]
  [private]  [final]
  [protected][transient]
  []         [volatile]

    local variable
  ----------------------
  -Nil-      [final]
```

---

---

8. methods

---

what is a method ?

- method is a block of code
- method is a collection of statements
- method is a reusable code
- method is a behaviour of an object

method syntax

```
  _____ ______ ReturnType methodName ( [Type1 var1, Type2 var2, ...] ) {
      - Arithmetic, Logical, Relational, Bitwise, Assignment, Ternary, Unary
      - Control Flow ( if, if-else, switch, while, do-while, for, for-each )
      - Looping ( break, continue, return )
      - Exception Handling ( try-catch, throw, throws, finally )
      - Object Creation ( new )
      - Object Manipulation ( ., [], instanceof, cast )
      - Object Comparison ( ==, equals, hashCode )
      [return value;]
  }
```

Return Types

- void
- primitive type
- reference type

Method Modifiers

- abstract => this must be implemented by the subclass
- native => implemented in the non-java language
- strictfp => floating point calculations are platform independent
- synchronized => thread safe
- final => can't be overridden
- static => class level method

Access Modifiers

- public
- private
- protected
- default

---

Java Naming Conventions

---

1. package name => lowercase
2. type name => PascalCase
3. var/method name => camel-case
4. constans => upper case

---
