/*
class Animal{}
class Cow extends Animal{
    protected addHey(){}
}
class Bird extends Animal{
    protected addSeed(){}
}
class Lion extends Animal{
    protected addMeat(){}
}
public class Ch1_VirtualMethodInvoke{
    //Method definition without Virtual Method Invocation
    public void feedAnimal(Animal animal) { 
        if (animal instanceof Cow) {
            ((Cow)animal).addHey();
        } else if(animal instanceof Bird){
            ((Bird)animal).addSeed();
        } else if(animal instanceof Lion){
            ((Lion)animal).addMeat();
        } else {
            throw new RuntimeException("Unsupported Animal");
        }
    }
}
*/

// For Virtual method invocation 

// make Animal class abstract to force subclasses to implement abstract methods.
abstract class Animal{
    public abstract void feed();
}

class Cow extends Animal{
    // overriden method calls respective feeding mechanism
    public void feed(){ 
        addHey();
    }
    protected addHey(){}
}
class Bird extends Animal{
    // overriden method calls respective feeding mechanism
    public void feed(){ 
        addSeed();
    }
    protected addSeed(){}
}
class Lion extends Animal{
    // overriden method calls respective feeding mechanism
    public void feed(){ 
        addMeat();
    }
    protected addMeat(){}
}
public class Ch1_VirtualMethodInvoke{
    //Method definition with Virtual Method Invocation
    public void feedAnimal(Animal animal) { 
        //This approach has a huge advantage.
        animal.feed(); // as method call get DELEGATES to the class‐specific method
    }
    /* 
    * Note: Java lookes at the actual type of animal at runtime and calls feed() on that.
    *       this technique is called virtual method invocation.
    */
}