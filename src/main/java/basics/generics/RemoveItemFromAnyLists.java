package basics.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to remove an item from any list.
 */
public class RemoveItemFromAnyLists {

    /**
     * Removes all occurrences of the target item from the input list.
     *
     * @param inputList the list from which items need to be removed
     * @param target the item to remove from the list
     * @param <T> the type of elements in the list
     * @return the updated list with the items removed, or the original list if no item was removed
     */
    public static <T> List<T> removeItem(List<T> inputList, T target) {

        // Check if the input list is empty or the target is null
        if (inputList.isEmpty() || target == null) {
            System.out.println("List/target is empty or null");
            return inputList;
        }

        List<T> toRemove = new ArrayList<>();

        // Collect all occurrences of the target element in the list
        for (T element : inputList) {
            if (element.equals(target)) {
                toRemove.add(element);
            }
        }

        // If no matching items were found, return the list as is
        if (toRemove.isEmpty()) {
            System.out.println("No match found for '" + target + "'!");
            return inputList;
        }

        // Remove all collected items from the list
        inputList.removeAll(toRemove);

        // Log the removal of the items
        System.out.println("Removed " + toRemove.size() + " occurrence(s) of '" + target + "'.");

        // Return the updated list
        return inputList;
    }

    /**
     * Main method to demonstrate removing items from different types of lists.
     *
     * @param args the command-line arguments (unused)
     */
    public static void main(String[] args) {

        // Create lists for languages and roll numbers
        List<String> languages = new ArrayList<>();
        List<Integer> rollNumbers = new ArrayList<>();

        // Add items to the languages list
        languages.add("Hindi");
        languages.add("Tamil");
        languages.add("Marathi");
        languages.add("English");

        // Print the original languages list
        System.out.println("Original Language list: " + languages);

        // Add items to the roll numbers list
        rollNumbers.add(9);
        rollNumbers.add(29);
        rollNumbers.add(27);
        rollNumbers.add(21);
        rollNumbers.add(10);
        rollNumbers.add(10);

        // Print the original roll numbers list
        System.out.println("Original Rollnumbers list: " + rollNumbers);

        // Remove "Marathi" from the languages list and print the updated list
        System.out.println("Updated Language list: " + removeItem(languages, "Marathi"));

        // Attempt to remove "Bangla" (which does not exist) from the languages list
        System.out.println("Updated Language list: " + removeItem(languages, "Bangla"));

        // Remove roll number 10 from the roll numbers list and print the updated list
        System.out.println("Updated Rollnumbers list: " + removeItem(rollNumbers, 10));

        // Attempt to remove roll number 14 (which does not exist) from the roll numbers list
        System.out.println("Updated Rollnumbers list: " + removeItem(rollNumbers, 14));

        // Handle the case where null is provided as a target (target is null)
        System.out.println("Updated Rollnumbers list: " + removeItem(rollNumbers, null));
    }
}