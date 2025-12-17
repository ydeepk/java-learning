package basics.arrays;

import java.util.*;

/**
 * This class demonstrates how to find duplicate elements in an array using both HashSet and ArrayList.
 *
 * <p>The method `checkDuplicateElements` identifies duplicates in an integer array and stores them
 * in two collections: a HashSet (for unique duplicates) and an ArrayList (for all duplicates).
 */
public class FindDuplicateUsingSet {

    /**
     * Checks for duplicate elements in the given array and stores them in two collections.
     *
     * @param array the array to check for duplicates
     */
    public static void checkDuplicateElements(int[] array) {
        // Set to track elements that have been seen
        Set<Integer> seen = new HashSet<>();

        // List to store all duplicate elements (including multiple occurrences)
        List<Integer> duplicate = new ArrayList<>();

        // Set to store unique duplicate elements (ensures each duplicate is added once)
        Set<Integer> duplicate1 = new HashSet<>();

        // Loop through each element in the array
        for (int i = 0; i < array.length; i++) {
            // If the element is already in the 'seen' set, it's a duplicate
            if (!seen.add(array[i])) {
                // Add the duplicate to both collections
                duplicate.add(array[i]);     // Add to ArrayList (all duplicates)
                duplicate1.add(array[i]);    // Add to HashSet (unique duplicates)
            }
        }

        // Output the results using ArrayList (may contain duplicates) and HashSet (unique duplicates)
        System.out.println("Duplicate elements found using ArrayList: " + duplicate);
        System.out.println("Duplicate elements found using HashSet (unique duplicates): " + duplicate1);
    }

    /**
     * Main method to execute the duplicate detection logic.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Example array with duplicates
        int[] arr = {1, 4, 3, 4, 4, 5, 10, 19, 10, 1};

        // Check for duplicates in the array
        checkDuplicateElements(arr);
    }
}