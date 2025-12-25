package collections.hashmap;

import java.util.HashMap;
import java.util.Map;

public class LoopThroughHashMap {

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

        // Loop through the HashMap using keySet() to get keys
        for (String country : capitalCity.keySet()) {
            System.out.println("Country: " + country + " and its capital city: " + capitalCity.get(country));
        }

        // Loop through the HashMap using values() to get the values
        for (String capital : capitalCity.values()) {
            System.out.println("Capital city: " + capital);
        }
    }
}