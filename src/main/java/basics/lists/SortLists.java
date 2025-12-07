package basics.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class SortLists {

    public static void main(String[] args) {

        List<String> cars = new ArrayList<>();

        cars.add("BMW");
        cars.add("Alpha Romeo");
        cars.add("Aston Martin");
        cars.add("Escalade");
        cars.add("Daewo");
        cars.add("GM");
        cars.add("Jaguar");
        cars.add("Java");
        cars.add("Land Rover");
        cars.add("Mercedes");
        cars.add("Nissan");
        cars.add("Lamborghini");
        cars.add("Ferrari");
        cars.add("Audi");
        cars.add("Citrogen");
        cars.add("Defender");
        cars.add("Toyota");
        cars.add("Suzuki");

        System.out.println(cars);

        Collections.sort(cars);
        System.out.println(cars);
    }
}
