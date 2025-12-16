package basics.initializerBlocks;

public class BreakItBetter {

    /**
     * Instance initializer block.
     * This block is executed before the constructor each time an object is created.
     * The order of the block inside the class does not affect the execution order,
     * as it is always executed before the constructor.
     */
    {
        boolean flag;
        flag = true;
        System.out.println("This is the initializer block: " + flag);
    }

    /**
     * Default constructor.
     * This constructor is invoked when an object of this class is created
     * using the default constructor (no arguments).
     */
    public BreakItBetter() {
        System.out.println("Constructor 1 executed");
    }

    /**
     * Constructor with an integer parameter.
     * This constructor is invoked when an object of this class is created
     * with an integer argument.
     *
     * @param x The integer value passed to the constructor.
     */
    public BreakItBetter(int x) {
        System.out.println("Constructor 2 executed with value: " + x);
    }

    public static void main(String[] args) {
        BreakItBetter bib1, bib2;

        // Create an object using the default constructor
        bib1 = new BreakItBetter();

        // Create an object using the constructor with an integer parameter
        bib2 = new BreakItBetter(2);
    }
}