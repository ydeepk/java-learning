package basics.lists;

import java.util.ArrayList;
import java.util.List;

public class RemoveElementFromLists {

    public static void main(String[] args) {

        List<String> language = new ArrayList<>();

        language.add("Hindi");
        language.add("Bhojpuri");
        language.add("English");
        language.add("Marathi");

        System.out.println("Languages in the list: "+language);

        String removedLang = language.remove(3);

        System.out.println("Removed language: "+removedLang);
        System.out.println("Language list after removing an element: "+language);

    }

}
