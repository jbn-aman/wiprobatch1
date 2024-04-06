public abstract class AbstractManufacturer {
    private String name;
    private String modelName;
    private String type;

    public AbstractManufacturer(String name, String modelName, String type) {
        this.name = name;
        this.modelName = modelName;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getModelName() {
        return modelName;
    }

    public String getType() {
        return type;
    }

    public abstract String getManufacturerInformation();
}

public class Car extends AbstractManufacturer implements Vehicle {
    public Car(String name, String modelName, String type) {
        super(name, modelName, type);
    }

    @Override
    public int maxSpeed(String type) {
        switch (type.toLowerCase()) {
            case "sports":
                return 250;
            case "sedan":
                return 190;
            default:
                return 0;
        }
    }

    @Override
    public String getManufacturerInformation() {
        return "Car{Manufacturer name:'" + getName() + "', Model Name:'" + getModelName() + "', Type:'" + getType() + "'}";
    }
}

public class Bike extends AbstractManufacturer implements Vehicle {
    public Bike(String name, String modelName, String type) {
        super(name, modelName, type);
    }

    @Override
    public int maxSpeed(String type) {
        switch (type.toLowerCase()) {
            case "sports":
                return 300;
            case "cruiser":
                return 170;
            default:
                return 0;
        }
    }

    @Override
    public String getManufacturerInformation() {
        return "Bike{Manufacturer name:'" + getName() + "', Model Name:'" + getModelName() + "', Type:'" + getType() + "'}";
    }
}

public interface Vehicle {
    int maxSpeed(String type);
}

public class VehicleService {
    public Car createCar(String name, String modelName, String type) {
        return new Car(name, modelName, type);
    }

    public Bike createBike(String name, String modelName, String type) {
        return new Bike(name, modelName, type);
    }

    public int compareMaxSpeed(Vehicle first, Vehicle second) {
        int speed1 = first.maxSpeed("sports");
        int speed2 = second.maxSpeed("sports");

        return Integer.compare(speed1, speed2);
    }
}
