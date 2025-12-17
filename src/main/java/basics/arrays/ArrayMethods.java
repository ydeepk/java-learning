package basics.arrays;

import java.util.Arrays;
import java.util.List;

public class ArrayMethods {

    public static void main(String[] args) {

        Integer[] array1 =  {2,3,4,5,6,5};
        int[] array2 = {1,4,5};

        // demonstration of Arrays.asList() method
        System.out.println("Integer wrapper class: "+ Arrays.asList(array1)); // returns fixed size of an array
        System.out.println("int primitive data type : "+ Arrays.asList(array2)); // memory refernce of the array instead of list content

        // demonstration of sort() method
        Arrays.sort(array1);
        Arrays.sort(array2);

        System.out.println("sorted list: "+Arrays.toString(array1));
        System.out.println("sorted list: "+Arrays.toString(array2));

        // demonstration of binarySearch()
        System.out.println("found at index "+Arrays.binarySearch(array1, 5));
        System.out.println("found at index "+Arrays.binarySearch(array2, 5));

    }
}
