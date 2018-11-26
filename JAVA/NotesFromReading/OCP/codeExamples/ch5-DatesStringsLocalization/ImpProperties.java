import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

class ImpProperties{
    public static void main(String[] args) {
        // Converting from ResourceBundle to Properties class.
        Locale us = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("Zoo", us);

        Properties prop = new Properties();
        //Put all the key/ value pairs from ResourceBundle into Properties.
        rb.keySet().stream().forEach(k -> prop.put(k, rb.getString(k)));

        System.out.println(prop.getProperty("hello")); // key is present so returns respective value.
        System.out.println(prop.getProperty("Welcome")); // returns NULL as key is not present.
        System.out.println(prop.getProperty("Welcome", "Default")); // returns Default as key is not present.
    }
}