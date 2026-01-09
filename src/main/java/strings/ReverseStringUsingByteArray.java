package strings;

public class ReverseStringUsingByteArray {

    public static void main(String[] args) {
        String input = "Deepak";
        byte[] byteArr = input.getBytes();
        byte[] result = new byte[byteArr.length];

        for(int i = 0; i < byteArr.length; i++) {
            result[i] = byteArr[byteArr.length-1-i];
        }

        String reversedStr = new String(result);
        System.out.println(reversedStr);
    }
}
