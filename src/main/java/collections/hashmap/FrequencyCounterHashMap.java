package collections.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Demonstrates counting the frequency of integers in an array.
 */
public class FrequencyCounterHashMap {

    public static void main(String[] args) {
        int[] array = {10, 1, 23, 23, 1, 1, 1, 10, 4, 45, 45};

        System.out.println(countFrequency(array));
    }

    /**
     * Counts the frequency of each integer in the given array.
     *
     * Each inner list contains exactly two elements:
     * - Index 0: the number
     * - Index 1: the frequency of that number
     *
     * @param array the input array of integers
     * @return a list of [number, frequency] pairs
     */
    private static List<List<Integer>> countFrequency(int[] array) {
        // Map to store each number and its frequency
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Result list to store [number, frequency] pairs
        List<List<Integer>> result = new ArrayList<>();

        // Count frequencies
        for (int element : array) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        // Convert map entries into list format
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            List<Integer> pair = new ArrayList<>();
            pair.add(entry.getKey());
            pair.add(entry.getValue());
            result.add(pair);
        }

        return result;
    }
}