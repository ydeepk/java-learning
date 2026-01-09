package strings;

/**
 * Demonstrates how to reverse a String using recursion.
 */
public class ReverseStringUsingRecursion {

    public static void main(String[] args) {

        // Input string to reverse
        String input = "meta";

        // Reverse the string using recursion
        String reversed = reverseString(input);

        // Print the reversed string
        System.out.println("Reversed string -> " + reversed);
    }

    /**
     * Recursively reverses the given string.
     *
     * @param input the string to reverse
     * @return the reversed string
     */
    private static String reverseString(String input) {

        // Base case: empty string or single character
        if (input == null || input.length() <= 1) {
            return input;
        }

        // Recursive case:
        // Reverse the substring starting from index 1
        // and append the first character at the end
        return reverseString(input.substring(1)) + input.charAt(0);
    }
}