package basics.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.exit;

/*
 * Coding exercise (JAVA-Generics): Write a Java program to create a generic method that takes a list of any type
 * and returns it as a new list with the elements in reverse order.
 * Source: https://www.w3resource.com/java-exercises/generic/index.php
 */
public class ReverseGenericList {

    /**
     * Reverses a given list and returns a new list with the elements in reverse order.
     *
     * @param <T> The type of elements in the list.
     * @param inputList The list to be reversed.
     * @return A new list containing the elements of the input list in reverse order.
     */
    public static <T> List<T> reverseAnyList(List<T> inputList) {

        if(inputList.isEmpty() || inputList == null) {
            System.out.println("List is empty or null");
            return inputList;
        }

        if(inputList.size() == 1) {
            System.out.println("List contains only 1 element.");
        }

        // Create a new ArrayList to avoid modifying the original list
        List<T> reversedList = new ArrayList<>(inputList);

        // Reverse the list in place
        Collections.reverse(reversedList);

        // Return the reversed list
        return reversedList;
    }

    /**
     * Main method to demonstrate the functionality of reversing different types of lists.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Create an ArrayList of Integer type and populate it with sample data
        List<Integer> myIntList = new ArrayList<>();
        myIntList.add(1);
        myIntList.add(4);
        myIntList.add(2);
        myIntList.add(8);
        myIntList.add(9);
        myIntList.add(10);

        // Create an ArrayList of Integer type and populate it with sample data
        List<Integer> mySecondIntList = new ArrayList<>();
        mySecondIntList.add(1);

        // Create an ArrayList of Double type and populate it with sample data
        List<Double> myDoubleList = new ArrayList<>();
        myDoubleList.add(11.9);
        myDoubleList.add(4.1);
        myDoubleList.add(2.2);
        myDoubleList.add(8.0);
        myDoubleList.add(9.2);
        myDoubleList.add(10.8);

        // Create an ArrayList of String type and populate it with sample data
        List<String> myStringList = new ArrayList<>();
        myStringList.add("Deepak");
        myStringList.add(" Priyanka ");
        myStringList.add("@");
        myStringList.add("Ayush");

        List<String> mySecondStringList = new ArrayList<>();

        // Print the original list and its reversed version for Integer list
        System.out.println("Input list is: " + myIntList + " and its Reverse list is : " + reverseAnyList(myIntList));

        // Print the original list and its reversed version for Second Integer list
        System.out.println("Input list for Second Integer list is: " + mySecondIntList + " and its Reverse list is : " + reverseAnyList(mySecondIntList));

        // Print the original list and its reversed version for Double list
        System.out.println("Input list is: " + myDoubleList + " and its Reverse list is : " + reverseAnyList(myDoubleList));

        // Print the original list and its reversed version for String list
        System.out.println("Input list is: " + myStringList + " and its Reverse list is : " + reverseAnyList(myStringList));

        // Print the original list and its reversed version for Second String list
        System.out.println("Input list for second String list is: " + mySecondStringList + " and its Reverse list is : " + reverseAnyList(mySecondStringList));
    }
}
