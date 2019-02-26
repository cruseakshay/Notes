# Advanced Class Design

Contents to learn in this chapter:

## Reviewing OCA Concepts

Review following from OCA book:

**Access modifiers** \
public, protected, and private and default access.

**Overloading and Overriding** \
overloading and overriding happen only when the method name is the same. \
overriding occurs only when the method signature is the same. \
The method signature is the method name and the parameter list. \
For overloading, the method parameters must vary by type and/or number.

- When multiple overloaded methods are present, Java looks for the closest match first. It tries to find the following:
  1. Exact match by type
  2. Matching a superclass type
  3. Converting to a larger primitive type
  4. Converting to an autoboxed type
  5. Varargs
  
- For overriding, the overridden method has a few rules:
  1. The access modifier must be the same or more accessible.
  2. The return type must be the same or a more restrictive type, also known as covariant return types.
  3. If any checked exceptions are thrown, only the same exceptions or subclasses of those exceptions are allowed to be thrown.

*The methods must not be static. (If they are, the method is hidden and not overridden.)* \

**Abstract Classes** \
An abstract class may contain any number of methods including zero. \
The methods can be abstract or concrete. \
Abstract methods may not appear in a class that is not abstract. \
The first concrete subclass of an abstract class is required to implement all abstract methods that were not implemented by a superclass.

**Static and Final** \
final prevents a variable from changing or a method from being overridden. \
static makes a variable shared at the class level and uses the class name to refer to a method.\
static and final are allowed to be added on the class level too. \
Using final on a class means that it cannot be subclassed. As with methods,a class cannot be both abstract and final.

**Imports** \
figure out is how to get static methods used to compile.\
And import all the Classes referenced from another packages.(Consider use of wildcards also)

**Using instanceof** \
In *a instanceof B*, the expression returns true. \
if the reference to which a points is an instance of class B, a subclass of B (directly or indirectly), or a class that implements the B interface (directly or indirectly).

All Java classes inherit from Object, which means that *x instanceof Object* is usually true, except for one case where it is false. \
If the literal null or a variable reference pointing to null is used to check instanceof, the result is false. null is not an Object.

The compilation check only applies when instanceof is called on a class.\
When checking whether an object is an instanceof an interface, Java waits until runtime to do the check.\
The reason is that a subclass could implement that interface and the compiler wouldn’t know it.

**Understanding Virtual Method Invocation** \
Based on the object at runtime overriden methods from respective subclasses are called, this technique is called as Virtual Method Invocation.

**Annotating Overridden Methods** \
In Java, when you see code that begins with an @ symbol, it is an annotation.\
An annotation is extra information about the program, and it is a type of metadata.\
It can be used by the compiler or even at runtime.

The @Override annotation is used to express that the programmer, intend for this method to override one in a superclass or implement one from an interface.

@Override is allowed only when referencing a method.

- when you see @Override show up on the exam, you must check carefully that the method is doing one of three things:
  1. Implementing a method from an interface
  2. Overriding a superclass method of a class shown in the example
  3. Overriding a method declared in Object class, such as *hashCode*, *equals*, or *toString*. (Special case of 2)

**Coding *equals*, *hashCode*, and *toString*** \
All classes in Java inherit from java.lang.Object, either directly or indirectly.\
For custom implementation it is common to override *equals()*, *hashCode()*, and *toString()* methods.

- toString() \
  Java automatically calls the toString() method if you try to print out an object.\
  some classes supply a human readable implementation of toString() and others do not.\
  Reflection is a technique used in Java to look at information about the class at runtime.

- equals() \
  Remember that Java uses == to compare primitives and for checking if two variables refer to the same object. \
  Checking if two objects are equivalent uses the equals() method, or at least it does if the developer implementing the method overrides equals().
  two objects that return true for equals() objects must return the same hash code.

- *The Contract for equals() Methods*: Rules for equals() method.
  - The equals() method implements an equivalence relation on non‐null object references:
    1. It is reflexive: For any non‐null reference value x, x.equals(x) should return true.
    2. It is symmetric: For any non‐null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns            true.
    3. It is transitive: For any non‐null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then          x.equals(z) should return true.
    4. It is consistent: For any non‐null reference values x and y, multiple invocations of x.equals(y) consistently return true or            consistently return false, provided no information used in equals comparisons on the objects is modified.
    5. For any non‐null reference value x, x.equals(null) should return false.
- hashCode() \
  Whenever you override equals(), you are also expected to override hashCode(). \
  The hash code is used when storing the object as a key in a map. \
  A hash code is a number that puts instances of a class into a finite number of categories.\
  *what do you do if you have a primitive and need the hash code?* Ans. you can just use a primitive number as is or divide to get a        smaller int.\
  Remember that all of the instance variables don’t need to be used in a hashCode() method. It is common not to include boolean and char   variables in the hash code.

- *contract for hashCode() Method*:
  1. Within the same program, the result of hashCode() must not change. This means that you shouldn’t include variables that change in figuring out the hash code.
  2. If equals() returns true when called with two objects, calling hashCode() on each of those objects must return the same result. This means hashCode() can use a subset of the variables that equals() uses.
  3. If equals() returns false when called with two objects, calling hashCode() on each of those objects does not have to return a different result. This means hashCode() results do not need to be unique when called on unequal objects.

**Working with Enums** \
An enumeration is like a fixed set of constants. An enum is a class that represents an enumeration in JAVA. it provides *type-safe* checking. \
Enumerations show up whenever you have a set of items whose types are known at compile time. \
To create an enum, use the enum keyword instead of the class keyword. Then list all of the valid types for that enum.\
Behind the scenes, an enum is a type of class that mainly contains static members. \
Since an enum is like a set of constants, use the uppercase letter convention that you used for constants. \
Enums may be used in switch statements. You can’t compare an int and enum value directly anyway. \
Methos in enum: <enum_name>.values(), <enum_name>.ordinal(), <enum_name>.valueOf(). \
The values in an enum are all that are allowed. You cannot add more at runtime by extending the enum. \
Enum can have Constructors, Fields, and Methods. The constructor is private because it can only be called from within the enum . \
The first time that we ask for any of the enum values, Java constructs all of the enum values. After that, Java just returns the already constructed enum values. \
Enums are also allowed to have only a private constructor. \
If enum have Constructors, Fields, or Methods other than just values then ; is must after value declaration. \
If the enum has an abstract method. This means that each and every enum value is required to implement this method. If we forget one, we get a compiler error. \
If we don’t want each and every enum value to have a method, we can create a default implementation and override it only for the special cases.

**Creating Nested Classes** \
A nested class is a class that is defined within another class.
A nested class that is not static is called an inner class.

- There are four of types of nested classes:
  1. inner class or member inner class
  2. local inner class
  3. anonymous inner class
  4. static nested class

**Member Inner Classes** \
  A member inner class is defined at the member level of a class (the same level as the methods, instance variables and constructors). \

- Properties:
  - Can be declared public, private, or protected or use default access.
  - Can extend any class and implement interfaces.
  - Can be abstract or final.
  - Cannot declare static fields or methods.
  - Can access members of the outer class including private members.

**Local Inner Classes** \
  A local inner class is a nested class defined within a method. \
  Like local variables, a local inner class declaration does not exist until the method is invoked, and it goes out of scope when the method returns. \

  Starting in Java SE 8, a local class can access local variables and parameters of the enclosing block that are final or effectively final. A variable or parameter whose value is never changed after it is initialized is effectively final.
  
- properties:
  - They do not have an access specifier.
  - They cannot be declared static and cannot declare s tatic fields or methods.
  - They have access to all fields and methods of the enclosing class.
  - They do not have access to local variables of a method unless those variables are *final or effectively final*.

If the code could still compile with the keyword final inserted before the local variable, the variable is effectively final.

**Anonymous Inner Classes** \
An anonymous inner class is a local inner class that does not have a name. It is declared and instantiated all in one statement using the new keyword. Anonymous inner classes are required to extend an existing class or implement an existing interface. They are useful when you have a short implementation that will not be used anywhere else. \
But what if we want to implement both an interface and extend a class? You can’t with an anonymous inner class, unless the class to extend is java.lang.Object. Object is a special class, so it doesn’t count in the rule.

**Static Nested Classes** \
A static nested class is a static class defined at the member level. It can be instantiated without an object of the
enclosing class, so it can’t access the instance variables without an explicit object of the enclosing class. \
The enclosing class can refer to the fields and methods of the static nested class.\
Importing a static nested class is interesting. You can import it using a regular import And since it is static, alternatively you can use a static import.
