# Class Design

- All interface methods are implicitly public.
- Prior to Java 8 all interface methods would be assumed to be abstract.Since Java 8 now includes default and static
methods and they are never abstract, one cannot assume the abstract modifier will be implicitly applied to all methods by the compiler.
- the rules for overriding a method allow a subclass to define a method with an exception that is a subclass of the exception in the parent method.
- private methods are always hidden in a subclass.
- static methods cannot be overridden, only hidden in subclass.
- variables may only be hidden in subclass, regardless of the access modifier.