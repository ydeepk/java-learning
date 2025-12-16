package basics.accessModifiers_B;

import basics.accessModifiers_A.Car;

public class SuperCar extends Car {

    public int x = 10;

    public void display() {
        System.out.print(speed);
    }


    public static void main(String[] args) {


    Car c = new Car();
    SuperCar superCar = new SuperCar();

    System.out.println(superCar.speed);
    System.out.print(c.x);

    }

}
