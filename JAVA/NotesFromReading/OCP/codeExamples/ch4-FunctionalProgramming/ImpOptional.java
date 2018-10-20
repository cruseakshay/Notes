import java.util.Optional;

class ImpOptional{
    // Also check out.
    // https://www.baeldung.com/java-optional

    // a method which return Optional type of Double
    public static Optional<Double> average(int... scores) {
        if (scores.length == 0) {
            return Optional.empty(); // it represents the absence of value. here when no scores are passed to average.
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return Optional.of((double)sum / scores.length); // when scores are present then return a value of type double-> Double in Optional.
    }

    public static void main(String[] args) {
        System.out.println(average()); // no values to average over.
        System.out.println(average(90, 100));

        // how to get value out of returned Optional.
        Optional<Double> opt = average(90, 100);

        // check if the value is present and then get the value: SAFE
        if (opt.isPresent()) {
            System.out.println(opt.get()); // if try to get the value directly, when Optional is empty. it will throw an exception.{java.util.NoSuchElementExcetion}
        }
    }
}