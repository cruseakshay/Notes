class StreamofPrimitives {
    // Java 8 offers a possibility to create streams out of three primitive types: int, long and double. 

    // IntStream, LongStream, DoubleStream.

    public static void main(String[] args) {
        // range(int startInclusive, int endExclusive)
        IntStream intStream = IntStream.range(1, 3);
        // rangeClosed(int startInclusive, int endInclusive) 
        LongStream longStream = LongStream.rangeClosed(1, 3);
    }
}