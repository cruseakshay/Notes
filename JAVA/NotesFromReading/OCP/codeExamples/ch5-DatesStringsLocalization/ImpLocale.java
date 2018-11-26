import java.util.Locale;

class ImpLocale {
    public static void main(String[] args) {
        // getting current Locale of the user.
        Locale currLocale = Locale.getDefault();
        System.out.println(currLocale); // en_IN [lower case language code + underscore + uppercase country code]

        // Note: Unerscore and country code are optional, valid Locale can be only a language.

        // 3 Main ways of creating a Locale.

        // 1. Using constants from the class.
        System.out.println(Locale.GERMAN);  // Just the language.
        System.out.println(Locale.GERMANY); // Note the difference. Lang + CCode

        // 2, 3. Using constructors.
        System.out.println(new Locale("fr")); // only Lang
        System.out.println(new Locale("hi", "IN")); // Lang + CCode

        // Using builder pattern to create Locale
        Locale l1 = new Locale.Builder().setLanguage("en").setRegion("US").build();
        System.out.println("Created with Builder: "+l1);

        // Using different locale other than current one
        Locale frLocale = new Locale("fr");
        Locale.setDefault(frLocale);
        System.out.println(Locale.getDefault());
    }
}