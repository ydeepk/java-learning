package collections.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Demonstrates basic HashMap operations such as put, get, remove, and clear.
 */
public final class HashMapMethods {

    private HashMapMethods() {
        // Prevent instantiation.
    }

    public static void main(String[] args) {

        // Create a new map to store country-capital pairs.
        Map<String, String> capitalCity = new HashMap<>();

        // Add keys and values: country and capital city.
        capitalCity.put("India", "Mumbai");
        capitalCity.put("England", "London");
        capitalCity.put("USA", "Washington");
        capitalCity.put("China", "DC");
        capitalCity.put("China", "Beijing"); // Value is overwritten if key is repeated.
        capitalCity.put("Canada", "Toronto");

        // Print the entire map and its size.
        System.out.println(
                "Capital city initial list: " + capitalCity + " with its size " + capitalCity.size());

        // Access an item using get().
        System.out.println(
                "Associated value for key 'India': " + capitalCity.get("India"));

        // Remove an item using remove().
        capitalCity.remove("England");

        // Print the updated map.
        System.out.println("After removing England from the list: " + capitalCity);

        // Remove all items using clear().
        capitalCity.clear();

        // Print the final map.
        System.out.println("After removing all items from the list: " + capitalCity);
    }
}