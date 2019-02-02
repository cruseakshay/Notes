import java.io.Serializable;

public class AnimalSerialized implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private char type;
    public AnimalSerialized(String name, int age, char type){
        this.name = name;
        this.age = age;
        this.type = type;
    }
    public String getName() {
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public char getType(){
        return this.type;
    }
    @Override
    public String toString(){
        return "Animal name[" + name + ", age=" + age + ", type=" + type + "]";
    }
}