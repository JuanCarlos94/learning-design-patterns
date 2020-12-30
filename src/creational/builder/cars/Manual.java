package creational.builder.cars;

import creational.builder.components.Engine;
import creational.builder.components.GPSNavigator;
import creational.builder.components.Transmission;
import creational.builder.components.TripComputer;

public class Manual {

    private final CarType type;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private final GPSNavigator gpsNavigator;
    private final TripComputer tripComputer;

    public Manual(CarType type, int seats, Engine engine, Transmission transmission, GPSNavigator gpsNavigator, TripComputer tripComputer) {
        this.type = type;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.gpsNavigator = gpsNavigator;
        this.tripComputer = tripComputer;
    }

    public String print(){
        String info = "";
        info += "Type of car: " + type + "\n";
        info += "Count of seats: " + seats + "\n";
        info += "Engine: volume - " + engine.getVolume() + "; mileage - " + engine.getMileage() + "\n";
        info += "Transmission: " + transmission + "\n";
        if(this.tripComputer != null){
            info += "Trip computer: Functional\n";
        } else {
            info += "Trip computer: N/A\n";
        }
        if(this.gpsNavigator != null){
            info += "GPS Navigator: Functional\n";
        } else {
            info += "GPS Navigator: N/A\n";
        }
        return info;
    }
}
