import java.time.Duration;

class ImpDuration {
    // Duration roughly works the same way as Period, except it is used with objects that have time.
    public static void main(String[] args) {
        // toString(): Duration is outputted beginning with PT(like Period of Time). 

        // Duration is stored in hours, minutes, and seconds.

        Duration daily = Duration.ofDays(1);
        System.out.println(daily); // PT24H

        Duration hourly = Duration.ofHours(1); 
        System.out.println(hourly); // PT1H

        Duration everyMinute = Duration.ofMinutes(1);
        System.out.println(everyMinute); // PT1M

        Duration everyTenSec = Duration.ofSeconds(10);
        System.out.println(everyTenSec); // PT10S

        Duration everyMilliSec = Duration.ofMillis(1);
        System.out.println(everyMilliSec); // PT0.001S Note this one is Fractional

        Duration everyNanoSec = Duration.ofNanos(1);
        System.out.println(everyNanoSec); // PT0.000000001T

        //[NOTE] Duration doesn’t have a constructor that takes multiple units like Period does.

        // Duration includes another more generic factory method. It takes a number and a TemporalUnit.
        // TemporalUnit is an interface. At the moment, there is only one implementation named ChronoUnit.

        
    }
}