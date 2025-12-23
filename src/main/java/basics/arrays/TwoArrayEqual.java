package basics.arrays;

import java.util.Arrays;

public class TwoArrayEqual {

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 3, 5};
        int[] arr2 = {5, 3, 2, 6};

        System.out.println("Are these arrays equal?: " + areArraysEqual(arr1, arr2));
    }

    /**
     * Compares two arrays for equality by sorting them and checking if they are equal.
     * First checks if the arrays are the same length. If not, returns false immediately.
     *
     * @param arr1 the first array to compare
     * @param arr2 the second array to compare
     * @return true if the arrays are equal (same length, same elements in same order), false otherwise
     */
    private static boolean areArraysEqual(int[] arr1, int[] arr2) {
        // If the arrays are not the same length, they can't be equal
        if (arr1.length != arr2.length) {
            return false;
        }

        // Sort both arrays and check if they are equal
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}