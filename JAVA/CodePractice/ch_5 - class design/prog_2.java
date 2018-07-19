interface Nocturnal {
    default boolean isBlind(){return true;}
  }
public class Owl implements Nocturnal{
      public boolean isBlind(){return false;}
      public static void main(String[] args) {
        Nocturnal nocturnal = (Nocturnal) new Owl();
        System.out.println(nocturnal.isBlind());
      }
  }