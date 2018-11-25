import java.util.Locale;

class ImpLocale {
    public static void main(String[] args) {
        // getting current Locale of the user.
        Locale currLocale = Locale.getDefault();
        System.out.println(currLocale); // en_IN [lower case language code + underscore + uppercase country code]
    }
}