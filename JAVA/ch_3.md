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