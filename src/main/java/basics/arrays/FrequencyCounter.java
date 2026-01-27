package basics.arrays;

import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter {

    public static void main(String[] args) {

        int[] arr = {1, 3, 2, 1, 4, 1};

        int counter = 0;
        Map<Integer, Integer> countFrequency = new HashMap<>();

        while(arr.length > counter) {
            countFrequency.put(arr[counter], countFrequency.getOrDefault(arr[counter], 0)+1);
            counter++;
        }

        System.out.println(countFrequency);
    }
}
