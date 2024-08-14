import java.util.ArrayList;

public class DrivingGame {

	private ArrayList<Vehicle> vehicles;
	private ArrayList<Dynamic> workers;
	private Map map;
	int counter = 0;
	int passengerId =1;
	FileManager myFile;

	public DrivingGame(int numOfJunctions, int numOfVehicles) {
		vehicles = new ArrayList<Vehicle>();
		workers = new ArrayList<Dynamic>();
		map = new Map(numOfJunctions, this);
		for (int i = 0; i < numOfVehicles; i++) {
			Vehicle car = new Vehicle(map, (i+1));
			vehicles.add(car);
			workers.add(car);
		}
		myFile = new FileManager("report");
	}
	
	public void play() {
		int i = 0;
		while (!areCarsFinished()) {
			System.out.println("\n" +"Turn " + ++i);
			for(Dynamic worker : workers) {
				worker.work();
			}	
			if (i % 3 == 0) {
				Passenger passenger = new Passenger(map, passengerId++);
				System.out.println(passenger.toString() + " is waiting for vehicle at " + passenger.getPath().get(0) + ", path: "+ passenger.getPath());
			}		
		}
	}

	private boolean areCarsFinished() {
		for (Vehicle car : vehicles) {
			if (!car.isFinished()) {
				return false;
			}
		}
		myFile.closeFile();
		return true;
	}

	public void addDynamicWorker(Dynamic worker) {
		workers.add(worker);
	}
}
