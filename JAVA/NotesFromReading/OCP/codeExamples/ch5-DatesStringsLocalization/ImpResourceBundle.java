import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

class ImpResourceBundle{
    public static void main(String[] args) {
        Locale us = new Locale.Builder().setLanguage("en").setRegion("US").build();
        Locale france = new Locale("fr", "FR");

        printProperties(us);
        System.out.println();
        printProperties(france);

        //Iterating over all the key/value pairs of ResourceBundle
        ResourceBundle rs = ResourceBundle.getBundle("Zoo", us);
        Set<String> keys =  rs.keySet();

        keys.stream().map(k -> k + " " + rs.getString(k)).forEach(System.out::println);
    }

    public static void printProperties(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale);

        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("open"));
    }
}