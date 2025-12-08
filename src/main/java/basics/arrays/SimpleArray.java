package basics.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleArray {

    public static void main(String[] args) {

        Integer[] arr = new Integer[] {3,4,3};


        arr[1] = 2;

        System.out.println(arr[0]);

        List<Integer> newArray = new ArrayList<>(Arrays.asList(arr));

        System.out.println(newArray);
    }

}
