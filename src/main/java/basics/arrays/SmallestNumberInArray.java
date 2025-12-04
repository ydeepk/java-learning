package basics.arrays;

import java.util.OptionalInt;

public class SmallestNumberInArray {

    // Improved method signature with OptionalInt return type for better handling of empty arrays
    public static OptionalInt findSmallestNumber(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty.");
        }

        int currentSmallestNumber = Integer.MAX_VALUE;

        for (int num : array) {
            currentSmallestNumber = Math.min(currentSmallestNumber, num);
        }

        return OptionalInt.of(currentSmallestNumber);  // Return the smallest number in an Optional
    }

    public static void main(String[] args) {
        // Example arrays to test
        int[] array1 = {45, 99, 2, 32, 65, 1, 2};
        int[] array2 = {23, 4, 66, 51, 11, 4, 2};
        int[] array3 = {0, 2, 3, 5, 6};

        // Handle OptionalInt result and print it
        findSmallestNumber(array1).ifPresent(smallest -> System.out.println("Smallest in array1: " + smallest));
        findSmallestNumber(array2).ifPresent(smallest -> System.out.println("Smallest in array2: " + smallest));
        findSmallestNumber(array3).ifPresent(smallest -> System.out.println("Smallest in array3: " + smallest));
    }
}
