// critical to understanding Virtual methods.

//What does the following print?
abstract class Animal {
    public void careFor() {
        play();
    }

    public void play() {
        System.out.println("pet animal");
    }
}

class Lion extends Animal {
    public void play() {
        System.out.println("toss in meat");
    }
}

public class Ch1_VirtualMethods {
    public static void main(String... args) {
        Animal animal = new Lion();
        animal.careFor();
    }
}