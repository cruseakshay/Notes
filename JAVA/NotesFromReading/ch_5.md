# Class Design

Java class design is about code reusability, increased functionality,and standardization.

## Class

All classes inherit from a single class *java.lang.Object*.

*java.lang.Object* is the only class that doesn’t have any parent classes.

- Class Inheritance
  - Inheritance is the process by which the new child subclass automatically includes any public or protected primitives, objects, or methods defined in the parent class.
  - single inheritance
    - Java supports single inheritance, by which a class may inherit from only one direct parent class.
  - multiple levels of inheritance
    - Java also supports multiple levels of inheritance, by which one class may extend another class, which in turn extends another class.
    - You can extend a class any number of times.
  - Multiple inheritance
    - __By design, Java doesn’t support multiple inheritance in the language because studies have shown that multiple inheritance can lead to complex, often diffi cult-to-maintain code.__
    - Part of what makes multiple inheritance complicated is determining which parent to inherit values from in case of a conflict.
    - Consider: if you have an object or method defined in all of the parents, which one does the child inherit? (Ambiguity)

- Class definition:

![Java class definition](./img/class_def.png)

- Java allows only one public class per file, a Java file can have many classes but at most one public class.(NOTE: it may have no public class at all)
- There can be at most one public class or *interface* in a Java file.

## Applying Class Access Modifiers

- access modifiers
  - public
    - The public access modifi er applied to a class indicates that it can be referenced and used in any class.
  - private
  - protected
  - default
    - The default package private modifier, which is the lack of any access modifier,indicates the class can be accessed only by a subclass or class within the same package.

- _NOTE_
  - For the OCA exam, you should only be familiar with *public* and *default* package-level class access modifiers, because these are the only ones that can be applied to top-level classes within a Java file.
  - The *protected* and *private* modifiers can only be applied to inner classes, which are classes that are defined within other classes.

## Defining Constructors

Every class has at least one constructor.

In the case that no constructor is declared, the compiler will automatically insert a default no-argument constructor.

In Java, the first statement of every constructor is either a call to another constructor within the class, using this(), or a call to a constructor in the direct parent class, using super(). If a parent constructor takes arguments, the super constructor would also take arguments.

## for review exam

- All interface methods are implicitly public.
- Prior to Java 8 all interface methods would be assumed to be abstract.Since Java 8 now includes default and static methods and they are never abstract, one cannot assume the abstract modifier will be implicitly applied to all methods by the compiler.
- the rules for overriding a method allow a subclass to define a method with an exception that is a subclass of the exception in the parent method.
- private methods are always hidden in a subclass.
- static methods cannot be overridden, only hidden in subclass.
- variables may only be hidden in subclass, regardless of the access modifier.
- if a method takes the superclass of an object as a parameter, then any subclass references may be used without a cast. (polymorphic parameters)
- All objects extend java.lang.Object, so if a method takes that type, any valid object, including null, may be passed.
- an interface method that provides a body must be marked as default or static explicitly.
- Since Java 8, interfaces may also contain concrete methods in form of static or default methods.
- Both abstract classes and interfaces can be extended with the extends keyword.
- Only interfaces can contain default methods.
- Both abstract classes and interfaces can contain static methods.
- *interface doesn't inherit from java.lang.Object*.
- Interface variables are assumed to be public static final.
- Concrete classes are, by definition, not abstract.
- Concrete classes can be both final and not final.
- Abstract methods cannot contain a body.
- With hidden methods, the specific method used depends on where it is referenced.