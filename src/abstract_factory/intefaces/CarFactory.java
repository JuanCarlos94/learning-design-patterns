package abstract_factory.intefaces;

import abstract_factory.intefaces.Engine;
import abstract_factory.intefaces.Wheel;

public interface CarFactory {

    String createName();
    Engine createEngine();
    Wheel createWheel();

}
