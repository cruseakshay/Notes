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