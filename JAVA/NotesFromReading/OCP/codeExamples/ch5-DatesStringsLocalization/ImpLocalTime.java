import java.time.LocalTime;

class ImpLocalTime{
    public static void main(String[] args) {
        // static methods
        System.out.println(LocalTime.of(6, 15)); // hour, minutes
        System.out.println(LocalTime.of(6, 15, 30)); // hour, minutes, seconds
        System.out.println(LocalTime.of(6, 15, 30, 200)); // hour, minutes, seconds, nanosec
    }
}