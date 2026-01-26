package basics.arrays;

import java.util.Arrays;

public class SwapArrayElements {

    public static void main(String[] args){

        int[] inputArr = {1, 2, 3, 4, 5};

        int left = 0;
        int right = inputArr.length-1;

        while (left < right) {

            int temp = inputArr[right];
            inputArr[right] = inputArr[left];
            inputArr[left] = temp;

            System.out.println(inputArr[left] +" is swapped with "+ inputArr[right]);

            left++;
            right--;
        }

        System.out.println("reversed array with 0(1) constant is "+ Arrays.toString(inputArr));
    }
}
