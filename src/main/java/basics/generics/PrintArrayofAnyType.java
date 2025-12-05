package basics.generics;

/**
 * The {@code PrintArrayofAnyType} class demonstrates the usage of generics by printing arrays of different types.
 * It contains a generic method {@code printArray} to print arrays of any object type.
 */
public class PrintArrayofAnyType {

    /**
     * Prints the elements of the provided array.
     * The method is generic and can print arrays of any type.
     *
     * @param <T> the type of the elements in the input array
     * @param inputArr the array whose elements are to be printed
     */
    public static <T> void printArray(T[] inputArr) {
        // Iterate over each element in the array and print it
        for (T element : inputArr) {
            System.out.print(element + " ");
        }
        // Print a newline after the array elements for better formatting
        System.out.println();
    }

    /**
     * The main method demonstrates the usage of the {@code printArray} method by passing
     * arrays of different types (Integer, Double, and Character).
     *
     * @param args command-line arguments (not used in this example)
     */
    public static void main(String[] args) {
        // Create arrays of different types to test the generic printArray method
        Integer[] intArr = {1, 4, 2, 7, 56};  // Integer array
        Double[] doubleArr = {34.2, 12.4, 45.6, 36.2};  // Double array
        Character[] charArr = {'H', 'E', 'L', 'L', 'O'};  // Character array

        // Print the elements of each array with a description before each one
        System.out.println("Integer array contains.");
        printArray(intArr);  // Print Integer array

        System.out.println("Double array contains.");
        printArray(doubleArr);  // Print Double array

        System.out.println("Character array contains.");
        printArray(charArr);  // Print Character array
    }
}
