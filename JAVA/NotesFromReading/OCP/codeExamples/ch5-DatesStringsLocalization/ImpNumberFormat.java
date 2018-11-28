import java.text.NumberFormat;
import java.util.Locale;

class ImpNumberFormat{
    public static void main(String[] args) {
        // 1. create a NumberFormat object requiered.
        // 2. Use parse() or format() as per use case. format() to turn a number into a String. parse() to turn a String into a number

        // The format classes are not thread-safe.

        // Formatting a Number.
        int attendeesPerYear = 3_200_000;
        int attendeesPerMonth = attendeesPerYear / 12;

        NumberFormat us = NumberFormat.getInstance(Locale.US);
        System.out.println(us.format(attendeesPerMonth));

        NumberFormat g = NumberFormat.getInstance(Locale.GERMANY);
        System.out.println(g.format(attendeesPerMonth));

        NumberFormat ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
        System.out.println(ca.format(attendeesPerMonth));
    }
}