# Core JAVA APIs

Points to consider

- Object Equality
- Object Reference Equality

Exmaple:
    String s = "Hello"; // string object in *String pool*

    String t = new String("Hello"); // string object in *heap*

    // s and t objects have same contents so

    // "Hello".equals(s), "Hello".equals(t), t.equals(s) all returns true. (*Object Equality*)

    // ("Hello" == s) return true (*Object Reference Equality*)

- Immutable means the state of an object cannot change once it is created
- Immutable objects can be garbage collected just like mutable objects.
- String is immutable. StringBuilder can be mutated with methods like append().
- method chaining
- Java does not allow you to compare String and StringBuilder using ==.
- length() is simply a count of the number of characters in a String.
- charAt() returns the character at that index. Remember that indexes are zero based. (associated error StringIndexOutOfBoundsException)
- substring() has two forms:
  - The first takes the index to start with and the index to stop immediately before.
  - The second takes just the index to start with and goes to the end of the String.
- A String concatenated with any other type gives a String.
- Java does not allow the indexes to be specified in reverse order and the code throws a StringIndexOutOfBoundsException.
- you cannot assign a String to a StringBuilder. like StringBuilder s = "Hello"; (does not compile).
- it is legal to leave out the size for later dimensions of a multidimensional array, the first one is required. like int[][] arr = new int[2][];
- Arrays define a property called length. It is not a method, so parentheses are not allowed.
- The ArrayList class defines a method called size().
- An array is not able to change size and can have multiple dimensions.
- Both an array and ArrayList are ordered and have indexes. Neither is immutable. The elements can change in value.
- An array does not override equals() and so uses object equality.
- ArrayList does override equals() and defines it as the same elements in the same order.
- An array must be sorted for binarySearch() to return a meaningful result.
- Converting from an array to an ArrayList uses Arrays.asList(names).
- Remember that numbers sort before letters and strings sort alphabetically.
- The rule when an item isn’t found is to negate that index and subtract 1. (Binary Search)
- Integer.valueOf("6") returns an Integer.
- Integer.parseInt("6") returns an int.
- LocalDate does not have a public constructor.
  - so new LocalDate(2014, 6, 21) is not valid.
  - But LocalDate.of(2014, 6, 21) is valid.
- dates are immutable.
- Period does not allow chaining.Only the last Period method called counts.

## Notes from OCA-OCP practice

- Points to consider
  - Manipulate data using the StringBuilder class and its methods
  - Create and manipulate Strings
  - Create and manipulate calendar data using classes from java.time.LocalDateTime,  java.time.LocalDate, java.time.LocalTime, -  java.time.format.DateTimeFormatter, java.time.Period 
  - Declare and use an ArrayList of a given type
  - Write a simple Lambda expression that consumes a Lambda Predicate expression

- StringBuilder does not support multiple threads.
- StringBuffer supports multiple threads.
- Both String and StringBuilder support languages and encodings.
- The primary reason to use StringBuilder over String is, String often creates a new object each time you call certain methods on the object like concat(). StringBuilder optimizes operations like append() because it is mutable.
- A string pool exists for String reuse. A String is **final** and **immutable**.

- List is an interface and not a class so It cannot be instantiated.
- An ArrayList does not automatically sort the elements. It simply remembers them in order. Since Java uses zero-based indexes.

- the main benefit of a lambda expression, It allows you to write code that has the execution deferred.

- The <> is known as the diamond operator. 

- The type in the lambda must match the generic declared on the Predicate. While it is common for a Predicate to have a generic type, it is not required. it is treated like a Predicate of type Object if the generic type is missing.

- LocalDateTime and LocalTime, both include the time elements. LocalDate only includes the date portion and not the time portion.

- Java 8 date and time classes are immutable.

- In Java, most things use zero-based indexes, including arrays and a String. Months are an exception to this convention starting     Java 8.

- **Predicate is an interface with one method. The method signature is boolean test(T t).**

- The Period class creates immutable objects and is usually used to add/subtract from a LocalDate or LocalDateTime object. It         allows creating date, week, month, or year periods. Since it cannot be used for time.

- Nanosecond smallest unit you can add to a LocalTime object.

## Questions for practice

- what is the output of the following ?
  ```java
    StringBuilder sb = new StringBuilder("radical").insert(sb.length(), "robots");
    System.out.println(sb);
  ```