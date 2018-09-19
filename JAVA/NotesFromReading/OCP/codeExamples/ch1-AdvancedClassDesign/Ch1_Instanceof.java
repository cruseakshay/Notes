class HeavyAnimals{}
class Hippo extends HeavyAnimals{}
class Elephant extends HeavyAnimals{}

public class Ch1_Instanceof {
    public static void main(String[] args) {
        HeavyAnimals hippo = new Hippo();
        
        boolean b1 = hippo instanceof Hippo; //true
        boolean b2 = hippo instanceof HeavyAnimals; //true
        boolean b3 = hippo instanceof Elephant; //false

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        // instanceof when Object class is involved.
        HeavyAnimals hippo1 = new Hippo();
        boolean b4 = hippo1 instanceof Object; //true

        HeavyAnimals nullHippo = null;
        boolean b5 = nullHippo instanceof Object; //false

        System.out.println(b4);
        System.out.println(b5);
    }
}
