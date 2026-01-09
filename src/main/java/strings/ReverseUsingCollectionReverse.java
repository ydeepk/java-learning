package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Demonstrates how to reverse a String using Collections.reverse().
 */
public class ReverseUsingCollectionReverse {

    public static void main(String[] args) {

        // Input string to be reversed
        String inputString = "This is string";

        // Convert the string to a character array
        char[] characterArray = inputString.toCharArray();

        // Create a mutable list to store characters
        List<Character> characterList = new ArrayList<>();

        // Add each character from the array to the list
        for (char character : characterArray) {
            characterList.add(character);
        }

        // Reverse the list of characters in-place
        Collections.reverse(characterList);

        // Use StringBuilder for efficient string construction
        StringBuilder reversedStringBuilder = new StringBuilder();

        // Append each reversed character to the StringBuilder
        for (char character : characterList) {
            reversedStringBuilder.append(character);
        }

        // Convert StringBuilder to String and print the result
        String reversedString = reversedStringBuilder.toString();
        System.out.println("New reversed string -> " + reversedString);
    }
}