


how to work with data

- store
- process => create, read, update, delete, search, sort, filter, ...

what we need data-structure for?

- primitive data-types

    - int, float, string, boolean, ...
    - custom data-types => class...

for multiple data elements

    - array

    you should write your own data-structure
    
    - dynamic array
    - linked-list

----------------------------------------------------------
ready to use data-structures from java community ( collections )
----------------------------------------------------------


java.util package

    - List
    - Set
    - Map
    - Queue
    - Stack
    - Deque
    - PriorityQueue
    - Vector
    - Hashtable
    - Properties
    - Arrays
    - Collections
    - ...


Types of collections
---------------------

1. List
   - index based
   - duplicate elements
   - ordered
2. Set
  - no index
  - no duplicate elements
  - ordered | unordered
3. Map
   - key-value pair
   - key is unique
   - value can be duplicate
   - key is used to access the value

----------------------------------------------------------

Collection classes

1. List

    - ArrayList ( dynamic array ) => not synchronized ( not thread-safe )
    - Vector ( dynamic array ) => synchronized ( thread-safe )
    - Stack extends Vector ( LIFO ) => synchronized ( thread-safe )
    - LinkedList ( doubly linked list ) => not synchronized ( not thread-safe )
    

2. Set

    - HashSet (hashtable) (unordered) => not synchronized ( not thread-safe )
    - LinkedHashSet (hashtable) ( ordered ) => not synchronized ( not thread-safe )
    - TreeSet (b-tree) ( sorted ) => not synchronized ( not thread-safe )

3. Map

    - HashMap (hashtable) (unordered) => not synchronized ( not thread-safe )
    - LinkedHashMap (hashtable) ( ordered ) => not synchronized ( not thread-safe )
    - TreeMap (b-tree) ( sorted ) => not synchronized ( not thread-safe )
    - Hashtable (hashtable) (unordered) => synchronized ( thread-safe )
    - Properties (hashtable) (unordered) => synchronized ( thread-safe )
   

4. Queue

    - PriorityQueue (heap) => not synchronized ( not thread-safe )
    - LinkedList (doubly linked list) => not synchronized ( not thread-safe )
    - ArrayDeque (dynamic array) => not synchronized ( not thread-safe )
    - BlockingQueue => synchronized ( thread-safe )

 
java.util.concurrent.*

  - BlockingQueue
  - BlockingDeque
  - ConcurrentMap
  - ConcurrentNavigableMap
  - CopyOnWriteArrayList
  - CopyOnWriteArraySet
  - LinkedBlockingQueue
  - LinkedBlockingDeque
  - LinkedTransferQueue


----------------------------------------------------------
recommended class  hierarchy for java modules
----------------------------------------------------------


- Top-level : interface  ( contract 
- Middle-level : abstract class ( partial implementation )
- Bottom-level : class ( full implementation )


----------------------------------------------------------
Collection Framework
----------------------------------------------------------

Interfaces

    - Collection
        - List
        - Set
        - Queue
    - Map

Abstract classes

    - AbstractCollection
    - AbstractList
    - AbstractSet
    - AbstractQueue
    - AbstractMap
    - AbstractSequentialList

Classes

    - ArrayList
    - Vector
    - Stack
    - LinkedList
    - HashSet
    - LinkedHashSet
    - TreeSet
    - HashMap
    - LinkedHashMap
    - TreeMap
    - Hashtable
    - Properties
    - PriorityQueue
    - ArrayDeque
    - BlockingQueue
    - BlockingDeque
    - ConcurrentMap
    - ConcurrentNavigableMap
    - CopyOnWriteArrayList
    - CopyOnWriteArraySet
    - LinkedBlockingQueue
    - LinkedBlockingDeque
    - LinkedTransferQueue
