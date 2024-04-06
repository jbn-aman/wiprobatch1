
public class VehicleService {
	public Car createCar(String name, String modelName, String type) {
		return new Car(name, modelName, type);
	}

	public Bike createBike(String name, String modelName, String type) {
		return new Bike(name, modelName, type);
	}

	public int compareMaxSpeed(Vehicle first, Vehicle second) {
		if (first.maxSpeed("sports") > 0 && second.maxSpeed("sports") > 0) {
			if (first.maxSpeed("sports") == second.maxSpeed("sports")) {
				return 0;
			}
			return Math.max(first.maxSpeed("sports"), second.maxSpeed("sports"));
		}
		return -1;
	}
}
