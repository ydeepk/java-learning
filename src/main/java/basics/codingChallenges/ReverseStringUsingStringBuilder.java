package basics.codingChallenges;

public class ReverseStringUsingStringBuilder {

    public static void main(String[] args) {

        String originalString = "Virat Kholi"; // Input string to be reversed

        // StringBuilder is mutable and optimized for frequent modifications
        StringBuilder stringBuilder = new StringBuilder(originalString);

        // Uses the built-in reverse() method that performs efficient in-place reversal
        System.out.println(stringBuilder.reverse().toString());
        // toString() converts the StringBuilder back to a String for output
    }
}
