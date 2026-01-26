package streamsAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortListUsingStream {

    public static void main(String[] args) {


        List<String> priceList = List.of("$40","$12","$35","$200");// new ArrayList<>(Arrays.asList("$40","$12","$35","$200"));

        List<Double> originalList = priceList.stream()
                .map(text ->text.replace("$",""))
                .map(text->Double.parseDouble(text))
                .sorted()
                .collect(Collectors.toList());

        List<Double> sortedList = originalList.stream()
                .sorted()
                .collect(Collectors.toList());

        if(originalList.equals(sortedList)) {
            System.out.println("True");
            System.out.println(originalList);
        } else {
            System.out.println("False");
        }
    }
}
