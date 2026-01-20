package basics.classAndObjects;

/*
* class Alpha {
    static { System.out.println("1: Alpha Static"); }
    { System.out.println("2: Alpha Instance"); }
    Alpha() { System.out.println("3: Alpha Constructor"); }
}

class Beta extends Alpha {
    static { System.out.println("4: Beta Static"); }
    { System.out.println("5: Beta Instance"); }
    Beta() {
        super();
        System.out.println("6: Beta Constructor");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Start ---");
        new Beta();
        System.out.println("--- End ---");
    }
}
* */
public class GrandFinale {
/*
    Out put will be as below
            --- Start ---
            4: Beta Static
            5: Beta Instance
            1: Alpha Static
            2: Alpha Instance
            3: Alpha Constructor
            6: Beta Constructor
            --- End ---
*/}
