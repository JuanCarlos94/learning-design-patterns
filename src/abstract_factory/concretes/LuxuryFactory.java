package abstract_factory.concretes;

import abstract_factory.intefaces.CarFactory;
import abstract_factory.intefaces.Engine;

public class LuxuryFactory implements CarFactory {

    @Override
    public String createName() {
        return "Luxury car";
    }

    @Override
    public Engine createEngine() {
        Engine v8 = new EngineV8();
        v8.name = "v8";
        return v8;
    }

    @Override
    public WheelBlack createWheel() {
        WheelBlack continental = new WheelBlack();
        continental.name = "Continental";
        return continental;
    }
}
