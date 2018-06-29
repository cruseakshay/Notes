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

**Java uses pass-by-value to copy primitives and references of objects into a method. That means changes to the primitive value or reference in the method are not carried to the calling method. That said, the data within an object can change, just not the original reference itself.**

A constructor can only call this() or super() on the first line of the constructor, but never both in the same constructor. If both constructors were allowed to be called, there would be two separate calls to super(), leading to duplicate initialization of parent constructors, since the other constructor referenced by this() would also call super() (or be chained to one that eventually calls super()).

If a class extends a parent class that does not include a no-argument constructor, the default no-argument constructor cannot be automatically inserted into the child class by the compiler. Instead, the developer must explicitly declare at least one constructor and explicitly define how the call to the parent constructor is made.

A method may contain at most one varargs parameter, and it must appear as the last argument in the list.

*A change made to the data within an object passed to a method is reflected in the calling method.*

## Questions from practice for revision

- What is the output of the following application?
    ```java
        package stocks;
        public class Bond {
            private static int price = 5;
            public boolean sell() {
                if(price<10) {
                    price++;
                    return true;
                } else if(price>=10) {
                    return false;
                }
            }
            public static void main(String[] cash) {
                new Bond().sell();
                new Bond().sell();
                new Bond().sell();
                System.out.print(price);
            }
        }
    ```
  - Option
    - 5
    - 6
    - 8
    - The code does not compile.
- What is true about the following program?
    ```java
        package figures;
        public class Dolls {
            public void nested() { nested(2,true); } // g1
            public int nested(int level, boolean height) { return nested(level); }
            public int nested(int level) { return level+1; }; // g2
            public static void main(String[] outOfTheBox) {
                System.out.print(new Dolls().nested());
            }
        }
    ```
  - Options:
    - It compiles successfully and prints 3 at runtime.
    - It does not compile because of line g1.
    - It does not compile because of line g2.
    - It does not compile for some other reason.

- Which of the following statements is not true?
  - An instance of one class may access an instance of another class’s attributes if it has a reference to the instance and the attributes are declared public.
  - An instance of one class may access package-private attributes in a parent class, provided the parent class is not in the same package.
  - Two instances of the same class may access each other’s private attributes.
  - An instance of one class may access an instance of another class’s attributes if both classes are located in the same package and marked protected.

- Given the following class, what should be inserted into the two blanks to ensure the class data is properly encapsulated?
    ```java
        package storage;
        public class Box {
            public String stuff;
                ____________String____________ () {
                return stuff;
            }
            public void setStuff(String stuff) {
                this.stuff = stuff;
            }
        }
    ```
  - Options:
    - public and getStuff
    - private and isStuff
    - public and setStuff
    - None of the above

- Given the following application, which diagram best represents the state of the mySkier, mySpeed, and myName variables in the main() method after the call to the slalom() method?
    ```java
    package slopes;
    public class Ski {
        private int age = 18;
        private static void slalom(Ski racer, int[] speed, String name) {
            racer.age = 18;
            name = "Wendy";
            speed = new int[1];
            speed[0] = 11;
            racer = null;
        }
        public static void main(String... mountain) {
            final Ski mySkier = new Ski();
            mySkier.age = 16;
            final int[] mySpeed = new int[1];
            final String myName = "Rosie";
            slalom(mySkier,mySpeed,myName);
        }
    }
    ```

- Due to which line code won't compile ?
    ```java
    package sports;
    public class Football {
        public static Long getScore(Long timeRemaining) {
            return 2*timeRemaining; // m1
        }
        public static void main(String[] refs) {
            final int startTime = 4;
            System.out.print(getScore(startTime)); // m2
        }
    }
    ```

- Imagine you are working with another team to build an application. You are developing code that uses a class that the other team has not finished writing yet. Which element of Java would best facilitate this development, allowing easy integration once the other team’s code is complete?
  - An abstract class
  - An interface
  - static methods
  - An access modifier
> For this problem, an interface is the best choice. If the two teams agree on a common interface, one developer can write code that uses the interface, while another developer writes code that implements the interface. Assuming neither team changes the interface, the code can be easily integrated once both teams are done.

