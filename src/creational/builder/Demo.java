package creational.builder;

import creational.builder.cars.Car;
import creational.builder.cars.Manual;
import creational.builder.director.Director;

public class Demo {

    public static void main(String[] args) {
        Director director = new Director();

        CarBuilder carBuilder = new CarBuilder();
        director.constructSportsCar(carBuilder);

        Car car = carBuilder.getResult();
        System.out.println("Car built:\n" + car.getType());

        CarManualBuilder carManualBuilder = new CarManualBuilder();
        director.constructSportsCar(carManualBuilder);
        Manual carManual = carManualBuilder.getResult();
        System.out.println("\nCar Manual Built: " + carManual.print());
    }

}
