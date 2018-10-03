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
  
