import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterSample{
    public static void main(String[] args) throws IOException{
        File source = new File("PATH");
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(sorce)))){
            out.print("Today's weather is: "); // print with String
            out.println("sunny !"); // println with String
            out.print("Today's temperature at the zoo is: ");
            out.print(1/3.0); // print with primitive
            out.println('C'); // println with primitive
            out.format("It has rained 10.12 inches this year"); // format with String
            out.println(); // println for new line
            out.printf("It may rain 21.2 more inches this year"); // printf with string
        } 
    }
}