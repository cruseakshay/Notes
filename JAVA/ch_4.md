# Methods and Encapsulation

- Only the access modifier or optional specifiers are allowed before the return type.
- optional specifiers are allowed in any order.
- default access does not require a modifier
- Java is case sensitive.
- labels are not allowed for methods.
- *null* requires a reference object as the return type. *void* is not a reference object since it is a marker for no return type.
- a void method is allowed to have a return statement as long as it doesn’t try to return a value.
- two vararg parameters are not allowed in the same method.

```java
public int howMany(boolean b, boolean... b2){
    return b2.length;
}
```

for above code valid call would be:

```java
howMany(true); //valid
howMany(true, true); //valid
howMany(true, true, true); //valid
howMany(true, new boolean[]{true}); //valid
howMany(true, new boolean[]{true, true}); //valid
```

- package private means default.
- if two classes are in different packages, means private access and default (package private) access will not compile.
- if the property is of type boolean and getters must begin with is for booleans. (get/is/set)
- Java allows calling a static method through an instance variable.
