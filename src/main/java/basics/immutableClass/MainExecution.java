package basics.immutableClass;

/**
 * The MainExecution class demonstrates the usage of the ImmutableClass.
 * It creates an instance of the ImmutableClass and prints its properties to the console.
 */
public class MainExecution {

    /**
     * The entry point of the program.
     *
     * @param args Command-line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Create an instance of ImmutableClass with maxAge of 30 and animalClass as "human"
        ImmutableClass imc = new ImmutableClass(30, "human");

        // Print the animal class and the maximum age to the console
        System.out.println(imc.getAnimalClass());
        System.out.println(imc.getMaxAge());
    }
}