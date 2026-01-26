package strings;

import java.util.Arrays;

public class CheckAnagram {

    public static void main(String[] args) {

        // listen and Silent
        String input1 = "listen";
        String input2 = "silent";

        char[] firstArr = input1.toCharArray();
        char[] secondArr = input2.toCharArray();

        System.out.println(isAnagram(firstArr, secondArr));
    }

    private static boolean isAnagram(char[] firstArr, char[] secondArr) {

        if(firstArr.length != secondArr.length) {
            System.out.println("length is not same, anagram not possible");
            return false;
        }


            Arrays.sort(firstArr);
            Arrays.sort(secondArr);

            return Arrays.equals(firstArr,secondArr);

    }
}
