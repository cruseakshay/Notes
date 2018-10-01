# Design Patterns and Principles

## Designing an Interface

  An interface is an abstract data type which defines list of `public abstract` methods that any class implementing the interface must provide. An interface may also include constant `public static final` variables, `default` methods, and `static` methods.  
  An interface may extend another interface, and in doing so it inherits all of the abstract methods.
  The compiler automatically adds `public` to all interface methods and `abstract` to all non-static and non-default methods, if the developer does not provide them.