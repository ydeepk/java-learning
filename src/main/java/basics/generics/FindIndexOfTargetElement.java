package basics.generics;

import java.util.List;

/*
 * Coding exercise (JAVA-Generics): Write a Java program to create a generic method that takes a list of any type
 * and a target element. It returns the index of the first occurrence of the target element in the list.
 * Return -1 if the target element cannot be found.
 * Source: https://www.w3resource.com/java-exercises/generic/index.php
 */
public class FindIndexOfTargetElement {

    /**
     * Finds the index of the first occurrence of the target element in the list.
     *
     * @param <T> The type of the elements in the list.
     * @param inputList The list to search in.
     * @param target The element to find in the list.
     * @return The index of the first occurrence of the target element, or -1 if not found.
     */
    public static <T> int firstOccurrence(List<T> inputList, T target) {

        // Check if the list is not null, not empty, and the target is not null
        if (inputList != null && !inputList.isEmpty() && target != null) {
            return inputList.indexOf(target); // Return the index of the first occurrence
        }

        // If any of the conditions are violated, return -1
        return -1;
    }

    public static void main(String[] args) {

        // Integer list and target element
        List<Integer> myIntList = List.of(1, 4, 2, 8, 9, 10);
        int targetInt = 2;

        // Double list and target element
        List<Double> myDoubleList = List.of(11.9, 4.1, 2.2, 8.0, 9.2, 10.8);
        double targetDouble = 4.1;

        // Call the firstOccurrence method for Integer list
        System.out.println(targetInt + " element found at index: " + firstOccurrence(myIntList, targetInt));

        // Call the firstOccurrence method for Double list
        System.out.println(targetDouble + " element found at index: " + firstOccurrence(myDoubleList, targetDouble));
    }
}
