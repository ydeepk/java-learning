package basics.codingChallenges;

public class ReverseStringUsingCharAt {

    public static void main(String[] args) {

        String originalStr = "Deepak";
        String reverseStr = "";

         for (int i = 0; i < originalStr.length(); i++) {
            reverseStr = originalStr.charAt(i) + reverseStr;
        }

         System.out.println(reverseStr);

    }

}
