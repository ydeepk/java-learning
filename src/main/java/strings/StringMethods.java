package strings;

public class StringMethods {

    // declare String two separate methods
    String justStr = "Just";
    String justStrUsingNew = new String("Just");

    String meStr = "me";

    String justMeStr = justStr+meStr;
    String justmeStr = justStrUsingNew.concat(meStr);
    String joinJustAndMe = String.join(" ",justStr, meStr);

    int justMeStrLength = justMeStr.length();
    char mChar = justmeStr.charAt(6);
    String ustMeSubstr = justMeStr.substring(1,5);
    boolean checkIfEqualStr = justStr.equals(justStrUsingNew);
    //String containsMe = justMeStr.contains("me");

    // compareTo() why use it ?

    String justMeUpperCase = justMeStr.toUpperCase();
    String justMeLowerCase = justmeStr.toLowerCase();

    String trimJustMeStr = "  Just Me  ";
    String replaceCharWithAnotherChar = justmeStr.replace("M", " m");

    String formatStr = String.format(justStr+" %s", "me");

    // escape characters \, \t "tab", \n "new line"
    String escapeQuotes = "Hello  \"me\" amazing";  // here "\" tells string to escape quotes and treat them as a part of string

    // string pool and string pool constant

    public static void main(String[] args) {

    }
}
