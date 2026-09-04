## Singleton java class
- single = one , ton = object :: only one object/instance can able to create for class and reuse the same object referance again and again
 
- when class have 	
	- no data
	- fixed data
	- sharable data
  multiple object creation is waste of memory and cpu time.

### basic standard for singleton user-defined java class
1. restrict object creation from outside class using new operator
2. create one private static variable of same to hold single object reference
2. public static method , containing singleton logic to create only one instance for the class

#### To develop more perfect singleton java class additional factors to be consider
- protection from multithreaded environment
- protection from de-serialization
- protection from clonning
- protection from reflection api
- protection from custom class loader

