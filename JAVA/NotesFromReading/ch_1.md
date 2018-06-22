# Java Building Blocks

The package java.lang is imported into every Java class.

A valid .java file may define any number of classes or interfaces but have at most one public class.

Java is object oriented, not procedural

Operator overloading is permitted in languages like C++, not Java

the JVM manages the location of objects in memory that can change and is transparent to the Java application.

local variables defined within methods cannot have access modifiers such as public/private.

Object-oriented programming is the technique of structuring data into objects, which may contain data and a set of actions that operate on the data.

Garbage collection can happen at any time while an application is running, especially if the available memory suddenly becomes low.

Java does not allow declaring different types as part of the same declaration. ex :- double num1, int num2 = 0;

A byte is smaller than a char.

The instance variables, constructor, and method names can appear in any order within a class declaration.

The finalize() method may not be called, such as if your program crashes. However, it is guaranteed to be called no more than once.

byte and short do not store values with decimal points.

Integer is the name of a class in Java. While it is bad practice to use the name of a class as your local variable name, this is legal. ex:- int Integer = 0;

It is not legal to use a reserved word as a variable name. All of the primitives including int are reserved words. ex:- Integer int = 0;(does not compile).

## Practice Questions before exam

- Given the following application, fill in the missing values in the table starting from the top and going downward.
    ```java
        package competition;
        public class Robot {
        static String weight = "A lot";
        /* default */ double ageMonths = 5, ageDays = 2;
        private static boolean success = true;
        public void main(String[] args) {
            final String retries = "1";
            // P1
        }
    }
    ```
    | Variable | Type Number of Variables Accessible at P1 |
    | --- | --- |
    | Class | _______ |
    | Instance | _______ |
    | Local | _______ |

    > ANS: 2, 2, 1
- example of: local scope overrides instance scope
    ```Java
        package sports;
        public class Bicycle {
            String color = "red";
            private void printColor(String color) {
                color = "purple";
                System.out.print(color);
            }
            public static void main(String[] rider) {
                new Bicycle().printColor("blue");
            }
        }
    ```
- Which is the first line to trigger a compiler error?
    ```java
        double d1 = 5f;    // p1
        double d2 = 5.0;   // p2
        float f1 = 5f;     // p3
        float f2 = 5.0;    // p4
    ```
- Which of the following can fill in the blanks to make this code compile?
    ```java
         ______ d = new ______ (1_000_000_.00);
    ```
  - Options:
    - double,
    - doubledouble,
    - DoubleDouble,
    - double
    - None of the above

