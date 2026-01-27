package basics.arrays;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {

    public static void main(String[] args) {
        String input = "stress";
        Map<Character, Integer> frequency = new HashMap<>();
        // get frequency
        for(char c: input.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c,0)+1);
        }
        // find the first element has occurrence of 1.
        for(char c: input.toCharArray()) {
            if(frequency.get(c) == 1) {
                System.out.println("We found the winner");
                break;
            }
        }
    }
}
