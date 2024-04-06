
public class Bike extends AbstractManufacturer implements Vehicle {
    public Bike(String name, String modelName, String bikeType) {
        super(name, modelName, bikeType);
    }

    @Override
    public int maxSpeed(String bikeType) {
        if (bikeType.equals("sports")) {
            return 300;
        } else if (bikeType.equals("cruiser")) {
            return 170;
        } else {
            return 0;
        }
    }

    @Override
    public String getManufacturerInformation() {
        return String.format("Bike{Manufacturer name:'%s',Model Name:'%s',Type:'%s'}", getName(), getModelName(), getType());
    }
}
