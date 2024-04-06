
public class Main {
	public static void main(String[] args) {
		VehicleService service = new VehicleService();
		Car sportsCar = service.createCar("Ferrari", "Ferrari 488", "sports");
		Bike sportsBike = service.createBike("Ducati", "Ducati Panigale", "sports");

		System.out.println(sportsCar.getManufacturerInformation());
		System.out.println(sportsBike.getManufacturerInformation());

		int maxSpeedComparison = service.compareMaxSpeed(sportsCar, sportsBike);
		if (maxSpeedComparison == 0) {
			System.out.println("The maximum speeds of the car and bike are equal.");
		} else if (maxSpeedComparison > 0) {
			System.out
					.println("The maximum speed of the car is greater than the bike: " + maxSpeedComparison + " km/h");
		} else {
			System.out.println(
					"The maximum speed of the bike is greater than the car: " + (-maxSpeedComparison) + " km/h");
		}
	}
}
