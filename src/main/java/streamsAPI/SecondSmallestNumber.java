package streamsAPI;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class SecondSmallestNumber {

    public static void main(String[] args) {

        /*
        * Given an array of integers,
        * find the second smallest number. (Example: [5, 2, 9, 1, 3] -> The second smallest is 2)
        * */

        int[] numberList = {5, 2, 9, 1, 3};

        OptionalInt secondSmallestNumber = Arrays.stream(numberList)
                .sorted()
                .distinct()
                .skip(1)
                .findFirst();

        System.out.println(secondSmallestNumber);
    }
}
