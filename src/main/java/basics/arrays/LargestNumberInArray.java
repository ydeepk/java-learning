package basics.arrays;

public class LargestNumberInArray {

    // Method to find the largest number in an integer array
    public static void findLargestNumber() {

        // Initialize an integer array with sample values
        int[] number = {2, 4, 10, 8, 1};

        // Assume the first element is the largest initially
        int largest = number[0];

        // Loop starts from index 1 since index 0 is already assigned
        for (int i = 1; i < number.length; i++) {

            // Compare each element with the current largest value
            if (number[i] > largest) {
                // Update 'largest' if a bigger number is found
                largest = number[i];
            }
        }

        // Print the final largest number found in the array
        System.out.println("Largest number found in array: " + largest);
    }

    // Main method — program execution starts here
    public static void main(String[] args) {

        // Call the method to execute the logic
        findLargestNumber();
    }
}
