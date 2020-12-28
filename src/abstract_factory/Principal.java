package abstract_factory;

import abstract_factory.concretes.Car;
import abstract_factory.concretes.CarClient;
import abstract_factory.concretes.LuxuryFactory;
import abstract_factory.concretes.SimpleCarFactory;

public class Principal {
    public static void main(String[] args) {
        Car luxuryCar = CarClient.makeCar(new LuxuryFactory());
        System.out.println(luxuryCar.toString());

        Car simpleCar = CarClient.makeCar(new SimpleCarFactory());
        System.out.println(simpleCar.toString());
    }
}
