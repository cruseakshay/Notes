# Exceptions

- Points to consider:
  - Handling Exceptions
  - Differentiate among checked exceptions, unchecked exceptions, and Errors
  - Create a try-catch block and determine how exceptions alter normal program flow
  - Describe the advantages of Exception handling
  - Create and invoke a method that throws an exception
  - Recognize common exception classes (such as NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException             ClassCastException)

A try block must include either a catch or finally block, or both.

The correct order of blocks is try, catch, and finally.

The class RuntimeException extends Exception, and both Exception and Error extend Throwable. Finally, like all Java classes, they all inherit from Object. Notice that Error does not extend Exception, even though we often refer to these generally as exceptions.

While Exception and RuntimeException are commonly caught in Java applications, it is recommended Error not be caught. An Error often indicates a failure of the JVM which cannot be recovered from. 

- **List of unchecked exceptions**
  - ClassCastException
  - ArrayIndexOutOfBoundsException
  - IllegalArgumentException

- **List of checked exceptions**
  - IOException

ClassCastException, ArrayIndexOutOfBoundsException, and IllegalArgumentException are unchecked exceptions and can be thrown at any time. IOException is a checked exception that must be handled or declared when used.

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
