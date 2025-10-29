package basics.codingChallenges;

public class ReverseStringUsingStringBuilder {

    public static void main(String[] args) {

        String originalString = "Virat Kholi";

        StringBuilder stringBuilder = new StringBuilder(originalString);

        System.out.println(stringBuilder.reverse().toString());
    }

}
