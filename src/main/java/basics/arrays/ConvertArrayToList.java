package basics.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ConvertArrayToList {

    public static void main(String[] args) {
        Integer[] intArr = {1,3,45,65,7,98};
        String[] strArr = {"Java","Hello","world"};

        ArrayList<Integer> newArrayList = new ArrayList<>();

        for(int element: intArr) {
            newArrayList.add(element);
        }

        System.out.println(newArrayList);

        ArrayList<String> newStringArr = new ArrayList<>(Arrays.asList(strArr));

        System.out.println(newStringArr);

    }
}
