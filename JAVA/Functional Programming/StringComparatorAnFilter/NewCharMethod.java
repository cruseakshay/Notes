class NewCharMethod {
    private static void printChar(int aChar) {
        // conv int to char.
        System.out.println((char)(aChar));
    }
    public static void main(String[] args) {
        /**
         *  The chars() method is a new one in the String class from the CharSequence interface.
         *  It's useful for fluently iterating over the String's characters and apply an operation on the individual characters. 
         */
        final String str = "w00t";
        str.chars().forEach(System.out::println); // Note: chars() returns IntStream.

        // filter out only digits from the string. Using Lambdas.
        str.chars().filter(ch -> Character.isDigit(ch)).forEach(ch -> printChar(ch));

        // Using method reference.
        str.chars().filter(Character::isDigit).forEach(NewCharMethod::pr);
    }
}