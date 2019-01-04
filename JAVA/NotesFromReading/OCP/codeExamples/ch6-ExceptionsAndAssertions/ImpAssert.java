class ImpAssert{
    public static void main(String[] args) {
        /**
         * When an assert statement has two expressions, the second expression must return a value. 
         */

        // Find the assert stament that doesnt return value.
        int j = 9;
        assert(++j>7):"Error";
        assert(j==12):j;
        assert(++j>8):System.out.println(j);
        assert(j==12):new ImpAssert();
    }
}