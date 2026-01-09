package strings;

/**
 * Demonstrates commonly used String methods in Java and
 * highlights different ways to create and manipulate strings.
 */
public class StringMethods {

    public static void main(String[] args) {

        // Creating String using string literal (stored in String pool)
        String literalString = "Just";

        // Creating String using 'new' keyword (stored in heap memory)
        String objectString = new String("Just");

        // Both strings contain the same value but may have different references
        System.out.println(literalString + " & " + objectString);

        // Another string to concatenate
        String suffix = "me";

        // Concatenation using + operator
        String concatenatedUsingPlus = literalString + suffix;
        System.out.println(concatenatedUsingPlus);

        // Concatenation using concat() method
        String concatenatedUsingConcat = objectString.concat(suffix);
        System.out.println(concatenatedUsingConcat);

        // Joining strings using a delimiter
        String joinedWithSpace = String.join(" ", literalString, suffix);
        System.out.println(joinedWithSpace);

        // Getting length of the string
        int concatenatedLength = concatenatedUsingPlus.length();
        System.out.println(concatenatedLength);

        // Accessing a character at a specific index
        char characterAtIndex = concatenatedUsingConcat.charAt(6);
        System.out.println(characterAtIndex);

        // Extracting a substring (start index inclusive, end index exclusive)
        String substringValue = concatenatedUsingPlus.substring(1, 5);
        System.out.println(substringValue);

        // Comparing string values (not references)
        boolean areStringsEqual = literalString.equals(objectString);
        System.out.println(areStringsEqual);

        // Converting string to uppercase
        String upperCaseString = concatenatedUsingPlus.toUpperCase();

        // Converting string to lowercase
        String lowerCaseString = concatenatedUsingConcat.toLowerCase();
        System.out.println(lowerCaseString + " & " + upperCaseString);

        // String with leading and trailing spaces
        String stringWithSpaces = "  Just Me  ";
        System.out.println(stringWithSpaces);

        // Removing leading and trailing spaces
        String trimmedString = stringWithSpaces.trim();
        System.out.println(trimmedString);

        // Replacing characters in a string
        String replacedString = concatenatedUsingConcat.replace("M", " m");
        System.out.println(replacedString);

        // Formatting string using placeholders
        String formattedString = String.format("%s me", literalString);
        System.out.println(formattedString);

        // Demonstrating escape characters \, \t, \n
        // \" is used to include double quotes inside the string
        String escapedQuotes = "Hello \"me\" amazing";
        System.out.println(escapedQuotes);

        // Notes:
        // Strings in Java are immutable
        // String literals are stored in the String pool
        // equals() compares content, not memory location
    }
}