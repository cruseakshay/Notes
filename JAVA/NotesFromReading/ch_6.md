# Exceptions

- Points to consider:
  - Handling Exceptions
  - Differentiate among checked exceptions, unchecked exceptions, and Errors
  - Create a try-catch block and determine how exceptions alter normal program flow
  - Describe the advantages of Exception handling
  - Create and invoke a method that throws an exception
  - Recognize common exception classes (such as NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException             ClassCastException)

A try block must include either a catch or finally block, or both.

A try statement is not required to have a finally block, but if it does, there can be at most one. Furthermore, a try statement can have any number of catch blocks or none at all.

The correct order of blocks is try, catch, and finally.

A try statement requires a catch or a finally block. Without one of them, the code will not compile.

The class RuntimeException extends Exception, and both Exception and Error extend Throwable. Finally, like all Java classes, they all inherit from Object. Notice that Error does not extend Exception, even though we often refer to these generally as exceptions.

While Exception and RuntimeException are commonly caught in Java applications, it is recommended Error not be caught. An Error often indicates a failure of the JVM which cannot be recovered from.

- **List of unchecked exceptions**
  - RuntimeException
    - NullPointerException
    - ArithmeticException
  - ClassCastException
  - ArrayIndexOutOfBoundsException
  - IllegalArgumentException

- **List of checked exceptions**
  - Exception
  - IOException

![Class diagram for Exception](https://www.safaribooksonline.com/library/view/oca-ocp/9781119363392/images/c08uf004.jpg)

ClassCastException, ArrayIndexOutOfBoundsException, and IllegalArgumentException are unchecked exceptions and can be thrown at any time. IOException is a checked exception that must be handled or declared when used.

The *throws* keyword is used in method declarations, while the *throw* keyword is used to throw an exception to the surrounding process.

Unlike an if-then statement, which can take a single statement, a finally statement requires brackets {}.

All the exception classes belong to *java.lang* so no import is requiered.

If an exception matches multiple catch blocks, the first one that it encounters will be the only one executed.It is possible to write two consecutive catch blocks that can catch the same exception, with the first type being a subclass of the second.

A StackOverflowError occurs when a program recurses too deeply into an infinite loop. It is considered an error because the JVM often runs out of memory and cannot recover.

A NullPointerException occurs when an instance method or variable on a null reference is used.

A NoClassDefFoundError occurs when code available at compile time is not available at runtime.

A ClassCastException occurs when an object is cast to an incompatible reference type.

An IllegalArgumentException occurs when invalid parameters are sent to a method.

If both the catch and finally blocks throw an exception, the one from the finally block is propagated to the caller, with the one from the catch block being dropped,due to the fact that only one exception can be thrown to the caller.

## Questions from practice for revision

- What is the output of the following application?
    ```java
    package game;
    public class Baseball {
        public static void main(String... teams) {
            try {
                int score = 1;
                System.out.print(score++);
            } catch (Throwable t) {
                System.out.print(score++);
            } finally {
                System.out.print(score++);
            }
            System.out.print(score++);
        }
    }
    ```

- What is the output of the following application?
    ```java
    package system;
    public class Computer {
    public void compute() throws Exception {
        throw new RuntimeException("Error processing request");
    }
    public static void main(String[] bits) {
        try {
            new Computer().compute();
            System.out.print("Ping");
        } catch (NullPointerException e) {
            System.out.print("Pong");
            throw e;
        }
    }
    }
    ```
> The code does not compile due to the call to compute() in the main() method. Even though the compute() method only throws an unchecked exception, its method declaration includes the Exception class, which is a checked exception. For this reason, the checked exception must be handled or declared in the main() method in which it is called. *While there is a try-catch block* in the main() method, it is only for the unchecked NullPointerException. Since Exception is not a subclass of NullPointerException, the checked Exception is not properly handled or declared and the code does not compile, making Option C the correct answer.

- In the following application, the values of street and city have been omitted. Which one of the following is a possible output of   executing this class?
  1. 350 5th Ave - New York
  2. Posted:350 5th Ave - New York
  ```java
   package registration;
   public class Address {
        public String getAddress(String street, String city) {
            try {
                return street.toString() + " : " + city.toString();
            } finally {
                System.out.print("Posted:");
            }
        }
        public static void main(String[] form) {
            String street = // value omitted
            String city = // value omitted
            System.out.print(new Address().getAddress(street,city));
        }
    }
  ```
  