package basics.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {

    public static void main(String[] args) {


        List<Integer> intList = new ArrayList<>();

        intList.add(32);
        printList(intList);
    }

    private static void printList(List<?> list) {
        System.out.println(list);
    }
}
