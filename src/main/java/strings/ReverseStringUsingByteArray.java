package strings;

/**
 * Demonstrates how to reverse a String using a byte array.
 * This approach works correctly for basic ASCII characters.
 */
public class ReverseStringUsingByteArray {

    public static void main(String[] args) {

        // Input string to be reversed
        String inputString = "Deepak";

        // Convert the string into a byte array
        byte[] originalBytes = inputString.getBytes();

        // Create a new byte array to store reversed bytes
        byte[] reversedBytes = new byte[originalBytes.length];

        // Reverse the byte array by copying from the end to the beginning
        for (int index = 0; index < originalBytes.length; index++) {
            reversedBytes[index] = originalBytes[originalBytes.length - 1 - index];
        }

        // Convert the reversed byte array back into a String
        String reversedString = new String(reversedBytes);

        // Print the reversed string
        System.out.println(reversedString);
    }
}