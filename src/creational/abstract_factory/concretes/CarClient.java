package creational.abstract_factory.concretes;

import creational.abstract_factory.intefaces.CarFactory;

public class CarClient {

    public static Car makeCar(CarFactory abstractFactory){
        Car car = new Car();
        car.name = abstractFactory.createName();
        car.wheel = abstractFactory.createWheel();
        car.engine = abstractFactory.createEngine();
        return car;
    }

}
