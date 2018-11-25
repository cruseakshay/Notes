import java.util.Locale;
import java.util.ResourceBundle;

class ImpResourceBundle{
    public static void main(String[] args) {
        Locale us = new Locale.Builder().setLanguage("en").setRegion("US").build();
        Locale france = new Locale("fr", "FR");

        printProperties(us);
        System.out.println();
        printProperties(france);
    }

    public static void printProperties(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale);

        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("open"));
    }
}