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

        // Useage:
        
    }
}