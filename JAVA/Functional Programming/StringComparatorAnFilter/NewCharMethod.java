package StringComparatorAnFilter;
class NewCharMethod {
    public static void main(String[] args) {
        /**
         *  The chars() method is a new one in the String class from the CharSequence interface.
         *  It's useful for fluently iterating over the String's characters and apply an operation on the individual characters. 
         */
        final String str = "w00t";
        str.chars().forEach(System.out::println); // Note: chars() returns IntStream.
    }
}