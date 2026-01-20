package basics.classAndObjects;

public class Car extends Vehicle {

    private final String model;

    /*
    * The "Constructor & Super" Gauntlet
Interviewer: "I see you know methods. Now, let's see how you handle data initialization."
The Scenario: A Vehicle has a brand. A Car is a Vehicle but also has a modelName.

Your Challenge:
Create a Vehicle class with a constructor that sets the brand.
Create a Car class that extends Vehicle.
The Car constructor must take both brand and modelName.
Use the super keyword to pass the brand up to the Parent.
Add a method showDetails() in Car that prints both.
* */


        Car(String brand, String model) {
            super(brand);
            this.model = model;
        }


        public void showDetails() {
            System.out.println(brand+" : "+model);
        }



}

