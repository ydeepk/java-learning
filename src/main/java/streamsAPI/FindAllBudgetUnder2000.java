package streamsAPI;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

public class FindAllBudgetUnder2000 {

    public static void main(String[] args) {

        List<String> priceTags = List.of("$34","$2001","$1999","$24","$10");
        // Write the stream starting from priceTags.stream()...
        boolean isBudgetMet = priceTags
                .stream()
                .map(price -> price.replace("$"," ").trim())
                .mapToInt(Integer::parseInt)
                .allMatch(price -> price < 2000);

        System.out.println(isBudgetMet);
    }
}
