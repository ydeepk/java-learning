package strings;

public class ReverseStringUsingCharAt {

    /**
     * Reverses a given string by iterating through characters
     * using charAt() and prepending each character.
     *
     * Trade-off:
     * String concatenation inside a loop creates many temporary
     * String objects due to immutability. Not optimal for large inputs.
     */
    public void reverseStringCharAt(String string) {

        String reverseStr = ""; // Stores the reversed result

        for (int i = 0; i < string.length(); i++) {
            reverseStr = string.charAt(i) + reverseStr; // Prepending creates reverse order
        }

        System.out.println(reverseStr); // Outputs the reversed string
    }


    /**
     * Reverses a given string by converting it into a character array
     * and prepending each character to a result string.
     *
     * Trade-off:
     * Same performance limitation as above due to repeated concatenation.
     */
    public  void reverseStrToCharArray(String string) {

        String reversedStr = ""; // Stores the reversed result
        char[] charArray = string.toCharArray(); // Convert input into a char array

        for (int i = 0; i < charArray.length; i++) {
            reversedStr = charArray[i] + reversedStr; // Prepend characters to reverse
        }

        System.out.println(reversedStr); // Outputs the reversed string
    }


    /**
     * Entry point to test both reversal methods.
     */
    public static void main(String[] args) {

        ReverseStringUsingCharAt reverseStr = new ReverseStringUsingCharAt(); // Object creation

        reverseStr.reverseStringCharAt("Arun");     // Calling method using charAt approach
        reverseStr.reverseStrToCharArray("Deepak"); // Calling method using char array approach

    }

}
