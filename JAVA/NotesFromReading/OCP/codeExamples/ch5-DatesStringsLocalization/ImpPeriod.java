import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

class ImpPeriod{
    public static void main(String[] args) {
        // 5 ways to create a Period class:
        Period annually = Period.ofYears(1);

        Period monthly = Period.ofMonths(1);

        Period biWeekly = Period.ofWeeks(2);

        Period everyOtherDay = Period.ofDays(2);

        //Custom
        Period everyYearAndAWeek = Period.of(1, 0, 7); // Y, M, D

        //toString of Period class:
        System.out.println(annually);
        System.out.println(monthly);
        System.out.println(biWeekly);

        // Useage:
        LocalDate startPoint = LocalDate.of(2010, Month.JANUARY, 12);

        System.out.println("Added a Year: " + startPoint.plus(annually));

        System.out.println("Added a Month: " + startPoint.plus(monthly));

        System.out.println("Added 2 weeks: " + startPoint.plus(biWeekly));

        System.out.println("Added 2 days: " + startPoint.plus(everyOtherDay));

        System.out.println("Added aYearAndAWeek: " + startPoint.plus(everyYearAndAWeek));

        // You cannot chain methods when creating a Period. [IMP]
        // Only the last method is used in case of chaining because the Period of methods are static methods.

        Period tricky = Period.ofYears(1).ofWeeks(1); // Note swiggly lines.
        
        System.out.println(tricky); // Note the output.

        // Above code is equivalent to:
        Period p = Period.ofYears(1);
        p = Period.ofWeeks(1);
        
        System.out.println(p);
    }
}