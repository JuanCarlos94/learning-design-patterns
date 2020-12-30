package creational.abstract_factory;

import creational.abstract_factory.concretes.Car;
import creational.abstract_factory.concretes.CarClient;
import creational.abstract_factory.concretes.LuxuryFactory;
import creational.abstract_factory.concretes.SimpleCarFactory;

public class Principal {
    public static void main(String[] args) {
        Car luxuryCar = CarClient.makeCar(new LuxuryFactory());
        System.out.println(luxuryCar.toString());

        Car simpleCar = CarClient.makeCar(new SimpleCarFactory());
        System.out.println(simpleCar.toString());
    }
}
