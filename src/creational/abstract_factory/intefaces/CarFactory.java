package creational.abstract_factory.intefaces;

public interface CarFactory {

    String createName();
    Engine createEngine();
    Wheel createWheel();

}
