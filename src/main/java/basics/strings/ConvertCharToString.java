package basics.strings;

/**
 * Demonstrates different ways to convert a character array into a {@link String}.
 *
 * <p>This example shows two common approaches:
 * <ul>
 *   <li>Using {@link String#valueOf(char[])}</li>
 *   <li>Using the {@link String} constructor</li>
 * </ul>
 */
public class ConvertCharToString {

    /**
     * Entry point of the program.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Character array containing vowels
        char[] chars = {'a', 'i', 'e', 'o', 'u'};

        // Converts char array to String using String.valueOf()
        String stringFromValueOf = String.valueOf(chars);

        // Converts char array to String using String constructor
        String stringFromConstructor = new String(chars);

        // Prints the string created using the constructor
        System.out.println(stringFromConstructor);

        // Prints the string created using String.valueOf()
        System.out.println(stringFromValueOf);
    }
}