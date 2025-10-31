package basics.arrays;

public class LoopThroughArray {

    // Method to demonstrate looping through an integer array
    public static void loopThroughArray() {

        // Declare and initialize an integer array with values
        int[] numbers = {10, 11, 12, 14, 15, 16};

        // Use a standard for loop to iterate through all elements of the array
        for (int i = 0; i < numbers.length; i++) {
            // Print the current element at index 'i'
            System.out.println(numbers[i]);
        }
    }

    // Main method — program execution starts here
    public static void main(String[] args) {

        // Call the method to execute array looping logic
        loopThroughArray();
    }
}
