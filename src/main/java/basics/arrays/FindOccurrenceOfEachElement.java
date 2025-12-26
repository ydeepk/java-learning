package basics.arrays;

public class FindOccurrenceOfEachElement {

    /**
     * algo
     * I'll take first element and store it.
     * Then I'll compare it with all the elements present in array and increment the counter each time I find the occurrence.
     * I'll print as soon as the current loop is completed.
     * */

    private static void findOccurence(int[] arr) {

        int[] tempArr = new int[arr.length];
        int counter = 0;

        for(int i = 0; i < arr.length; i++) {
            if(i == 0) {
                tempArr[i] = arr[0];
                counter++;
                break;
            }

            if(arr[i] == arr[++i]) {

            }
        }

    }

    public static void main(String[] args) {

        int[] arr = {3,5,6,9,9,2,3,3,5};

        findOccurence(arr);

    }


}
