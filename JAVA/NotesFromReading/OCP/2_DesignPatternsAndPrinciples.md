# Design Patterns and Principles

## Designing an Interface

  An interface is an abstract data type which defines list of `public abstract` methods that any class implementing the interface must provide. An interface may also include constant `public static final` variables, `default` methods, and `static` methods.  
  An interface may extend another interface, and in doing so it inherits all of the abstract methods.
  The compiler automatically adds `public` to all interface methods and `abstract` to all non-static and non-default methods, if the developer does not provide them.  
  Remember that an `interface` cannot extend a `class`, nor can a `class` extend an `interface`.  
  *marker interfaces* that have neither methods nor class members, traditionally.  

  A *functional interface* as an interface that contains a single abstract method.  
  A *lambda expression* is a block of code that gets passed around, like an anonymous method.  

### Defining a Functional Interface

  It is a good practice to mark a functional interface with the `@FunctionalInterface` annotation for clarity.  
  If a class marked with the `@FunctionalInterface` annotation contains more than one abstract method, or no abstract methods at all, then the compiler will detect this error and not compile.  
  
  Lambda expressions rely on the notion of deferred execution. Deferred execution means that code is specified now but runs later. Even though the execution is deferred, the compiler will still validate that the code syntax is properly formed.  

### Understanding Lambda Syntax

  The arrow operator −> separates the parameter from the body.  
  The body has one or more lines of code, including braces `{}`, a semicolon `;`, and a `return` statement.  
  The parentheses () can be omitted in a lambda expression if there is *exactly one input parameter* and the type is not explicitly stated in the expression. This means that expressions that have zero or more than one input parameter will still require parentheses.  
  When using {} in the body of the lambda expression, you must use the `return` statement if the functional interface method
  that lambda implements returns a value. Alternatively, a return statement is optional when the return type of the method is void.  
  The data types for the input parameters of a lambda expression are optional. When one parameter has a data type listed, though, all parameters must provide a data type.  
  Java doesn’t allow us to re‐declare a local variable used in input parameter list of lambda expression.

### Applying the Predicate Interface