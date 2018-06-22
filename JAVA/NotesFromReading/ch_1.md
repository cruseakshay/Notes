# Java Building Blocks

The package java.lang is imported into every Java class.

A valid .java file may define any number of classes or interfaces but have at most one public class.

Java is object oriented, not procedural

Operator overloading is permitted in languages like C++, not Java

the JVM manages the location of objects in memory that can change and is transparent to the Java application.

local variables defined within methods cannot have access modifiers such as public/private.

Object-oriented programming is the technique of structuring data into objects, which may contain data and a set of actions that operate on the data.

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