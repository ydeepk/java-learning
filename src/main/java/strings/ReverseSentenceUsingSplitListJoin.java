package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Utility program to reverse the order of words in a sentence.
 *
 * Example:
 * Input : "This is my sentence"
 * Output: "sentence my is This"
 */
public class ReverseSentenceUsingSplitListJoin {

    /**
     * Program entry point.
     * Splits the input sentence into words, reverses the word order,
     * and prints the reversed sentence.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {

        // Input sentence to reverse (word order).
        String inputSentence = "This is my sentence";

        // Split the sentence into words using a space delimiter.
        String[] words = inputSentence.split(" ");

        // Convert array to list so it can be reversed using Collections.reverse().
        List<String> wordList = new ArrayList<>(Arrays.asList(words));

        // Reverse the order of words.
        Collections.reverse(wordList);

        // Join words back into a single sentence with spaces.
        String reversedSentence = String.join(" ", wordList);

        // Print final output (trim is safe if input has extra spaces).
        System.out.println(reversedSentence.trim());
    }
}