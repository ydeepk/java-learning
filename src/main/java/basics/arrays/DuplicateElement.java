package basics.arrays;

import java.util.Arrays;

/**
 * A class that demonstrates checking and printing duplicate elements in an array.
 *
 * <p>This class contains a method to identify duplicate elements in an integer array.
 * It compares each element in the array with every other element, and prints the duplicates.
 * The duplicates are then stored in a temporary array, and a trimmed version of this array is displayed.
 */
public class DuplicateElement {

    /**
     * Main method that executes the program.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Sample array containing integers with potential duplicates
        int[] arr = {2, 1, 0, 9, 4, 2, 1};

        // Call the method to check for duplicates
        checkDuplicateElement(arr);
    }

    /**
     * Checks and prints duplicate elements in the given array.
     *
     * <p>This method compares each element of the array with every other element,
     * prints duplicates, and stores them in a temporary array. Finally, it trims
     * the array to remove unused spaces and prints the final result.
     *
     * @param arr The array of integers to check for duplicates
     */
    private static void checkDuplicateElement(int[] arr) {
        // Temporary array to store duplicates
        int tempIndex = 0;
        int[] tempArr = new int[arr.length];

        // Outer loop to go through each element in the array
        for (int i = 0; i < arr.length; i++) {
            // Inner loop to compare the current element with every other element
            for (int j = 0; j < arr.length; j++) {
                // Check for duplicates, but skip the same element (i != j)
                if (arr[i] == arr[j] && i != j) {
                    // Print the duplicate element and its index
                    System.out.println(arr[i] + " matches " + arr[j] + " at index: " + j);

                    // Store the duplicate element in the temporary array
                    tempArr[tempIndex] = arr[j];
                    tempIndex++;  // Increment the index for tempArr
                }
            }
        }

        // Trim the temporary array to the actual number of duplicates found
        int[] trimmedArr = Arrays.copyOf(tempArr, tempIndex);

        // Print the trimmed array with only the duplicate elements
        System.out.println("Duplicates found: " + Arrays.toString(trimmedArr));
    }
}