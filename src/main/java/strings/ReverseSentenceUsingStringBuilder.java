package strings;

import java.util.Scanner;

/**
 * Reads a sentence from the user and reverses the order of words
 * using a StringBuilder.
 *
 * Example:
 * Input : "This is a test"
 * Output: "test a is This"
 */
public class ReverseSentenceUsingStringBuilder {

    /**
     * Program entry point.
     * Reads input from standard input (console), reverses word order,
     * and prints the output.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {

        // Read input sentence from user.
        Scanner scanner = new Scanner(System.in);
        String inputSentence = scanner.nextLine();
        scanner.close();

        // Split sentence into words using space as delimiter.
        String[] words = inputSentence.split(" ");

        // StringBuilder is used for efficient string construction.
        StringBuilder reversedSentenceBuilder = new StringBuilder();

        // Append words in reverse order.
        for (int i = words.length - 1; i >= 0; i--) {

            // Append the current word.
            reversedSentenceBuilder.append(words[i]);

            // Add space only between words (avoids extra trailing space).
            if (i != 0) {
                reversedSentenceBuilder.append(" ");
            }
        }

        // Print the reversed sentence.
        System.out.println(reversedSentenceBuilder.toString());
    }
}