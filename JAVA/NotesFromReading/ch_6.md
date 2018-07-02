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