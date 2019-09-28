# 2SI4 Labs written and solved in JAVA
2SI4 labs comprised of Data abstraction; algorithm analysis; recursion; lists; stacks; queues; trees; searching; hashing; sorting; sets; relations; functions; modular arithmetic; graph theory and algorithms.


                    Lab 1 and 2:


The range of integers that can be represented in Java using a primitive data type is only from −263 to 263 − 1. What if we need to manipulate integer values beyond this range?

In this assignment I wrote a HugeInteger class which was able to represent arbitrarily large integer numbers. This class implemented arithmetic operations on integers such as addition, subtraction, multiplication, division and comparison. I had to implement this class without using Java predefined classes, unless specified otherwise.

Additionally, I had to measure experimentally the running times of the operations implemented in my HugeInteger class and compare them with the measured running times of the corresponding operations provided by java.math.BigInteger class.


                    Lab 3:


In this lab you will implement the Set abstract data type using binary search trees. We will consider sets of integers where each integer will be stored in a tree node. Therefore, the number of nodes in the binary search tree must be equal to the size of the set.

You will have to write a Java class BSTSet for this purpose. To implement the tree nodes you must use the Java class TNode provided in this lab. Additionally, you may need to implement Java classes MyStack and/or MyQueue to perform non-recursive tree traversals of a BSTSet. You are not permitted to use any predefined Java methods or classes from Java API, other than for input and output, unless specified otherwise. You must also write a test class TestBSTSet. Please compute the asymptotic run time and space complexity of all methods


                    Lab 4:


In this lab you will implement a hash table with linear probing and perform simulations to observe its performance. The hash table will store integers. The hash function to be used is h(x) = x%M (the remainder after dividing x by M), where M is the size of the hash table. The set of possible keys x is the set of positive integers representable by the int data type. You must write a Java classes HashTableLin, HashTableQuad and a class TestHashTable for testing and for measuring its performance.

Classes HashTableLin and HashTableQuad implement hash tables where collisions are resolved with linear and quadratic probing respectively. Each class must contain a field named table, of type Integer[], which is a reference to the array which stores the keys. There must be other fields in each class to store the size of the table, the number of keys stored in the table and the maximum load factor allowed. All fields in the classes must be private. Pay attention to update these fields when performing hash table operations (when necessary).


                    Lab 5:


In this lab you will write a Java class MaxHeap implementing MAX binary heaps, the heapsort algorithm, and a test class TestMaxHeap. The heaps will store objects of type Integer and must be implemented using an array. Each heap may contain items with equal integer value. Then, the value in any tree node must be larger than or equal to the values in any of its descendants.

Class MaxHeap must contain a field of type Integer[], which is a reference to the array which stores the items (references to objects of type Integer). There must be other fields to store the size of the array (the amount of memory allocated) and the size of the heap (number of items stored). All fields must be private. Pay attention to update accordingly these fields when performing the heap operations (when necessary).
