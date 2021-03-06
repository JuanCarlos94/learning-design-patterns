package creational.abstract_factory.concretes;

import creational.abstract_factory.intefaces.CarFactory;
import creational.abstract_factory.intefaces.Engine;
import creational.abstract_factory.intefaces.Wheel;

public class SimpleCarFactory implements CarFactory {

    @Override
    public String createName() {
        return "Simple car";
    }

    @Override
    public Engine createEngine() {
        Engine onePointZero = new Engine10();
        onePointZero.name = "1.0";
        return onePointZero;
    }

    @Override
    public Wheel createWheel() {
        Wheel pirelli = new WheelGrey();
        pirelli.name = "Pirelli";
        return pirelli;
    }
}
