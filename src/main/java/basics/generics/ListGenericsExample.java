package basics.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * This class demonstrates the usage of generics with lists in Java.
 * It shows how to add elements to a list and retrieve them.
 */
public class ListGenericsExample {

    public static void main(String[] args) {
        // Create a new ArrayList to store strings
        List<String> myList = new ArrayList<>();

        // Adding strings to the list
        myList.add("Deepak");
        myList.add("Aysuh");

        // There is no addFirst() method in the List interface; you should use an alternative.
        // You can use add(0, "Priyanka") to add at the beginning of the list.
        myList.addFirst("Priyanka");

        // This line is invalid, as the list is of type String, but you're trying to add an Integer (20).
        // It should be removed or replaced with an appropriate String value.
        //myList.add(4, 20); // Invalid, 20 is not a String.

        // Print out the first three elements of the list
        System.out.println(myList.get(0) + " " + myList.get(1) + " " + myList.get(2));
    }
}
