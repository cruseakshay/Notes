# Java Building Blocks

The package java.lang is imported into every Java class.

A valid .java file may define any number of classes or interfaces but have at most one public class. It can also not define any public classes.

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

- What is the result of compiling and executing the following class?
    ```java
        public class ParkRanger {
        int birds = 10;
        public static void main(String[] data) {
           int trees = 5;
           System.out.print(trees+birds);
        }
    }
    ```
    options:
    - It does not compile.
    - It compiles but throws an exception at runtime.
    - It compiles and outputs 5.
    - It compiles and outputs 15