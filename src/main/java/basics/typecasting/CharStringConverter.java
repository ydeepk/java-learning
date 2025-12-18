package basics.typecasting;

import java.util.Arrays;

/**
 * Demonstrates conversion between char and String in Java.
 */
public class CharStringConverter {

    public static void main(String[] args) {
        char character = 'Z';
        String name = "Deepak";

        printCharAsString(character);
        printStringAsCharArray(name);
    }

    /**
     * Converts a char to a String and prints it.
     *
     * @param character the character to convert
     */
    private static void printCharAsString(char character) {
        String result = String.valueOf(character);
        String result2 = Character.toString(character);
        System.out.println(result);
        System.out.println(result2);
    }

    /**
     * Converts a String to a char array and prints it.
     *
     * @param text the string to convert
     */
    private static void printStringAsCharArray(String text) {
        char[] characters = text.toCharArray();
        System.out.println(Arrays.toString(characters));
    }
}
