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
- static methods are not allowed to call instance methods.
- instance initializer

```java
{
    System.out.println(rope1.length);
}
```

- static final variables must be set exactly once, and it must be in the declaration line or in a static initialization block.
- you can only do a static import on static members.
- Java is pass-by-value.
- this() may only be called as the first line of a constructor.
- *this.variableName* can be called from any instance method to refer to an instance variable. It cannot be called from a static method because there is no instance of the class to refer to.
- The default constructor is only written by the compiler if no user-defined constructors were provided.
- *this()* can only be called from a constructor in the same class.
- Java prefers autoboxing to varargs. (while promoting the variable. eg. int --> Integer rather than int --> int..)
- return keyword is required inside braces for lambda bodies.
- a variable used in the parameter list of the lambda expression can not be redefined in the lambda body. example:

```java
caller((e) -> {String e = ""; "poof"}); // not valid as e is redefined.
```