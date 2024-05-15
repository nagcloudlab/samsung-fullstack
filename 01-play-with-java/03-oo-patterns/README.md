




design patterns

=> solutions to common problems in OOP design


1. Creational patterns

    - Singleton
    - Factory
    - Abstract Factory
    - Builder
    - Prototype

2. Structural patterns
    
    - Adapter
    - Bridge
    - Composite
    - Decorator
    - Facade
    - Flyweight
    - Proxy

3. Behavioral patterns

    - Chain of Responsibility
    - Command
    - Interpreter
    - Iterator
    - Mediator
    - Memento
    - Observer
    - State
    - Strategy
    - Template Method
    - Visitor



Observer pattern
----------------
    
- one-to-many dependency between objects
- when one object changes its state, all its dependents are notified and updated automatically

- main-object : subject
- sub-objects : observers

- example: Smart Home System

main-object / subject : Door

    - open()
    - close()

sub-objects / observers : Light, Fan

    - on()
    - off()

problem: how to notify sub-objects when main-object changes its state ?
solution: Observer pattern

how to implement Observer pattern ?

    - define a common interface for all sub-objects
    - main-object should have a list of sub-objects
    - main-object should notify all sub-objects when its state changes


Builder pattern
---------------

by default, we create objects using constructors

    - constructor-args are mandatory
    - constructor-args are fixed

problem: how to create objects with optional-args and variable-args ?
solution: Builder pattern

how to implement Builder pattern ?

    - define a static inner class inside main-class
    - define all optional-args and variable-args as instance-variables
    - define a private constructor with mandatory-args
    - define a public static method to create builder-object
    - define setter-methods for all optional-args and variable-args
    - define a build() method to create main-object


Proxy pattern
-------------

- proxy means an object that controls access to another object


design issues
   - code scattering ( duplicating )
   - code tangling ( tight coupling )

solution: Proxy pattern

i.e isolate cross-cutting concerns from main-object

how to implement Proxy pattern ?

    - define a common interface for main-object and proxy-object
    - main-object should implement the common interface
    - proxy-object should implement the common interface
    - proxy-object should have a reference to main-object
    - proxy-object should control access to main-object



Strategy pattern
----------------


- strategy means a plan of action
- strategy pattern means a family of algorithms
- strategy pattern is used to define a family of algorithms, encapsulate each one of them and make them interchangeable



problem: how to support multiple algorithms for a given functionality ?
solution: Strategy pattern

how to implement Strategy pattern ?

    - define a common interface for all algorithms
    - define a separate class for each algorithm
    - main-object should have a reference to the common interface
    - main-object should delegate the algorithm to the common interface


E.g Music Player's Playlist

- FIFO
- LIFO
- Random

