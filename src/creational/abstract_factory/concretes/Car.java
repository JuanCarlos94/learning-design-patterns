package creational.abstract_factory.concretes;

import creational.abstract_factory.intefaces.Engine;
import creational.abstract_factory.intefaces.Wheel;

public class Car {

    public String name;

    public Wheel wheel;

    public Engine engine;

    @Override
    public String toString() {
        return this.name + ": {" +
                "wheel=" + wheel.name +
                ", engine=" + engine.name +
                '}';
    }
}
