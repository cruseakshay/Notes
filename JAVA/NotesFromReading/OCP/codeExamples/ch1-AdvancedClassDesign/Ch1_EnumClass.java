// simple enum declaration outside of the class
/*
public enum Season {
WINTER, SPRING, SUMMER, FALL
}
*/
public class Ch1_EnumClass{

    // simple enum declaration inside of the class
    public enum Season {
    WINTER, SPRING, SUMMER, FALL
    }
    Season s = Season.WINTER;
    System.out.println(Season.WINTER); // prints WINTER
    System.out.println(s == Season.SUMMER); // returns true

    // enhanced for loop on enum: name() and ordinal() methods used
    for(Season season: Season.values()) {
        System.out.println(season.name() + " " + season.ordinal());
    }

    Season s1 = Season.valueOf("SUMMER"); // SUMMER : use of valueOf() method

    //Using Enums in Switch Statements
    Season summer = Season.SUMMER;
    switch (summer) {
        case WINTER: // notice the case stmt 
        System.out.println("Get out the sled!");
        break;
        case SUMMER:
        System.out.println("Time for the pool!");
        break;
        default:
        System.out.println("Is it summer yet?");
    }

    public enum Season1 {
        WINTER {
        public void printHours() { System. out .println("9am-3pm"); }
        },
        SPRING {
        public void printHours() { System. out .println("9am-5pm"); }
        },
        SUMMER {
        public void printHours() { System. out .println("9am-7pm"); }
        },
        FALL {
        public void printHours() { System. out .println("9am-5pm"); }
        }; // NOTICE: semicolon
        public abstract void printHours(); // this is a abstract method declared by enum, which has to be overriden by every value.
    }
    public enum Season3 {
        WINTER {
        public void printHours() { System.out.println("short hours"); }
        },
        SUMMER {
        public void printHours() { System.out.println("long hours"); }
        },
        SPRING, FALL; // NOTICE: semicolon
        public void printHours() { System.out.println("default hours"); } // this is a default method declared by enum, which need not be overriden by every value.
    }
}