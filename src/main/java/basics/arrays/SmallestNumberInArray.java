package basics.arrays;

public class SmallestNumberInArray {

    public static void findSmallestNumber (int[] array) {

        int smallestNumber;
        smallestNumber = Integer.MAX_VALUE;

        for(int num: array) {
            smallestNumber = Math.min(smallestNumber, num);
        }

        System.out.println(smallestNumber);

    }


    public static void main(String[] args) {

        int[] array= {45,99,2,32,65,1,2};

        int array2[] = {23,4,66,51,11,4,2};

        findSmallestNumber(array);

        findSmallestNumber(array2);

        findSmallestNumber(new int[]{0,2,3,5,6});

    }
}
