import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectStreamSample {
    public static List<Animal> getAnimals(File dataFile) throws IOException, ClassNotFoundException {
        List<Animal> animals = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
            while(true){
                Object obj = in.readObject();
                if (obj instanceof Animal){
                    animals.add((Animal)obj);
                }
            }
        }
        catch(EOFException e){
            // File end reached.
            // This is one of the few times when it is perfectly acceptable to swallow an exception.
        }
        return animals;
    }
    public static void createAnimalsFile(List<Animal> animals, File dataFile) throws IOException{
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))){
            for (Animal animal: animals) {
                out.writeObject(animal);
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Tiger", 5, 'T'));
        animals.add(new Animal("Penguin", 8, 'P'));

        File datafile = new File("PATH");
        // serializing
        createAnimalsFile(animals, dataFile);

        // deserializing
        System.out.println(getAnimals(dataFile));
    }
}