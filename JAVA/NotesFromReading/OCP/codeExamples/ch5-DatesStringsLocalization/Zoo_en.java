import java.util.ListResourceBundle;

public class Zoo_en extends ListResourceBundle {
    // two main advantages of using a Java class instead of a property file
    // 1. Values can be Java Objects other than String.
    // 2. Values can be created at for a Property at Runtime. [V.Imp]
    
    protected Object[][] getContent() {
        return new Object[][]{
            {"hello", "Hello"},
            {"open", "The zoo is open"}
        };
    }
}