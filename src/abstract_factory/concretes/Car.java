package abstract_factory.concretes;

import abstract_factory.intefaces.Engine;
import abstract_factory.intefaces.Wheel;

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
