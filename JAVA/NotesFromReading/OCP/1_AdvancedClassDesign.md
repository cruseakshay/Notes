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

*The methods must not be static. (If they are, the method is hidden and not overridden.)*

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