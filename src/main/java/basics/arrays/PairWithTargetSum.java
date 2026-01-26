package basics.arrays;

public class PairWithTargetSum {

    // int[] numbers = {2, 7, 11, 15}; int target = 9;

    public static void main(String[] args) {

        int[] numbers = {2, 7, 11, 15};

        int target = 9;
        int left = 0;
        int right = numbers.length - 1;

        while(left < right) {
            int sum = numbers[left]+numbers[right];

            if(sum == target) {
                System.out.println(" found target for the "+numbers[left]+" & "+numbers[right]);
                return;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }

        }

    }
}
