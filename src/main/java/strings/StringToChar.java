package strings;

import utilities.ExcelUtils;

import java.util.Arrays;

/**
 * Demonstrates how to convert a {@link String} into a character array.
 *
 * <p>This example uses {@link String#toCharArray()} and shows how to:
 * <ul>
 *   <li>Access an individual character</li>
 *   <li>Print the entire character array</li>
 * </ul>
 */
public class StringToChar {

    /**
     * Entry point of the program.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Input string to be converted into a character array
        String input = "Deepak";

        // Converts the string into a char array
        char[] characters = input.toCharArray();

        // Prints the first character of the array
        System.out.println(characters[0]);

        // Prints the entire character array in a readable format
        System.out.println(Arrays.toString(characters));

        ExcelUtils.readExcelFile();
    }
}