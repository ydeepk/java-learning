package basics.generics;

import java.util.Arrays;

/**
 * This class contains a utility method to compare two arrays of generic type.
 * The arrays are compared element by element.
 */
public class CompareTwoArrays {

    /**
     * Compares two arrays of the same generic type.
     *
     * @param <T> The type of elements in the arrays.
     * @param firstArr The first array to compare.
     * @param secondArr The second array to compare.
     * @return true if both arrays are identical in length and content, false otherwise.
     * @throws RuntimeException if any of the arrays is null.
     */
    public static <T> boolean compareArray(T[] firstArr, T[] secondArr) {
        // Handle null arrays
        if (firstArr == null || secondArr == null) {
            throw new RuntimeException("Input array cannot be null.");
        }

        // If lengths are different, arrays are not equal
        if (firstArr.length != secondArr.length) {
            return false;
        }

        // Compare the elements one by one
        for (int i = 0; i < firstArr.length; i++) {
            if (!firstArr[i].equals(secondArr[i])) {  // Use .equals() for object comparison
                return false;
            }
        }

        // Arrays match
        return true;
    }

    /**
     * Main method to demonstrate array comparison.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Example arrays
        Integer[] arr1 = {1, 4, 2, 8, 3, 9};
        Integer[] arr2 = {1, 4, 2, 8, 3, 9};
        Integer[] arr3 = {9, 7, 3, 2, 4};
        Integer[] arr7 = null;

        String[] arr4 = {"Java", "World"};
        String[] arr5 = {"Deepak", "World"};
        String[] arr6 = {"Java", "World"};

        // Print arrays for reference
        System.out.println("array 1: " + Arrays.toString(arr1));
        System.out.println("array 2: " + Arrays.toString(arr2));
        System.out.println("array 3: " + Arrays.toString(arr3));
        System.out.println("array 4: " + Arrays.toString(arr4));
        System.out.println("array 5: " + Arrays.toString(arr5));
        System.out.println("array 6: " + Arrays.toString(arr6));

        // Check if arrays are equal and print the result
        try {
            System.out.println("arr1 & arr2 match? " + compareArray(arr1, arr2));
            System.out.println("arr1 & arr3 match? " + compareArray(arr1, arr3));
            System.out.println("arr1 & arr7 match? " + compareArray(arr1, arr7)); // Testing null array
            System.out.println("arr4 & arr5 match? " + compareArray(arr4, arr5));
            System.out.println("arr4 & arr6 match? " + compareArray(arr4, arr6));
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
