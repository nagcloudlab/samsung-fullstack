


Process
-------

=> whole execution of a program is called process
=> own address space (memory)

Thread
------

=> A thread is a single sequence stream within in a process
=> A process can contain multiple threads
=> A thread is also called a lightweight process
=> All threads of a process share its virtual address space and system resources
=> Each thread has its own stack, registers, program counter, and state
=> A thread shares data and code section with other threads of a process
=> A thread can be in any one of the states: running, ready and blocked

Thread vs Process
-----------------

=> Threads are used for small tasks, whereas processes are used for more ‘heavyweight’ tasks – basically the execution of applications
=> Threads within the same process share the same data, whereas different processes do not


how to bring many threads in a program?

=> step-1: create instance of java.lang.Thread class 
=> step-2: assign the work via runnable interface
=> step-3: start the thread by calling start() method
         

------------------------------------------------------------

Multithreading advance concepts in Java

    => executor framework ( java 1.5 )
    => callable tass with future ( java 1.5 )
    => locks ( java 1.5 )
    => semaphores ( java 1.5 )
    => countdown latches ( java 1.5 )
    => cyclic barriers ( java 1.5 )
    => concurrent collections ( java 1.5 )
    => fork join framework ( java 1.7 )
    => completaable future ( java 1.8 )
    

------------------------------------------------------------