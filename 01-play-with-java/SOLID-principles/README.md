

On 'Billing component' class

design issues
============================

- tight coupling b/w dependent & dependency components
    => cause : we can't this project with new features easily
- unit-testing is not possible
    => cause : dev / bug fix become slow

performance 
============================

- on every request, it creates a new instance of dependency component
    => cause : memory issues , appln will not respond quickly


why these issues?
============================

- we are creating an instance of dependency component inside the dependent component


how to resolve these issues?
============================

- use good design patterns
    e.g 'Factory pattern'


issues with Factory pattern
============================

- dependency component is tightly coupled with the factory class
- performance issue: on every request, it creates a new instance of dependency component


how to resolve these issues?
============================

- Inversion of Control principle
  - Don't create / lookup dependency component inside the dependent component,
    inject by external entity 

how to implement Inversion of Control principle?

- using 'Dependency Injection' design pattern

- 2 types of Dependency Injection
    - Constructor Injection -> required dependency
    - Setter Injection -> optional dependency
  

------------------------
SOLID Principles
------------------------

- SOLID is a set of 5 design principles

S - Single Responsibility Principle
O - Open for extension / Closed for modification Principle
L - Liskov Substitution Principle
I - Interface Segregation Principle
D - Dependency Inversion Principle

- SOLID principles are used to design loosely coupled, maintainable, scalable, and testable software applications

