import java.util.ArrayList;
import java.util.Random;

public class Vehicle implements Dynamic {
	

	private double speed;
	private ArrayList<Road> path;
	private int index;
	private Road currentRoad;
	private double distanceTraveled;
	public int counter = 0;
	private boolean finished = false;
	private Passenger passenger;
	int carID;
	  
	
	public Vehicle(Map map, int id) {
		Random r = new Random();
		speed = r.nextInt(91) +30;
		path = map.calcPath();
		index = 0;
		distanceTraveled = 0;
		currentRoad = path.get(index);
		carID = id;
		System.out.println("creating " + this +"," +  "speed: " + getSpeed()+ "," + " path: " + path);
	}

	public void move() {
		if (index == path.size()) {
			System.out.println(this + " arrived to it's destination:" + currentRoad.getEnd());
			dropOfPassenger();
		} else {
			distanceTraveled = distanceTraveled + speed;
			nextRoad();
		}
	}
	
	private void nextRoad() {
		if ( distanceTraveled > currentRoad.getLength()) {
			addPaseenger();
			if ((currentRoad.getEnd().getCurrentGreen() == null) || (currentRoad == currentRoad.getEnd().getCurrentGreen())) {
				distanceTraveled = distanceTraveled - currentRoad.getLength();
				index++;
				if (index == path.size()) {
					System.out.println(this + " arrived to it's destination:" + currentRoad.getEnd());
					finished = true;
				} else {
					currentRoad = path.get(index);
					nextRoad();		
				}
			} else {
				System.out.println(this + " is waiting for green light on " + getCurrentRoad().getEnd());
				distanceTraveled = currentRoad.getLength();
			}
		} else {
			System.out.println(this + " is moving on the " + getCurrentRoad());
		}
	}
	
	private void addPaseenger() {
		if (passenger != null) {
			return;
		}
		Junction current = currentRoad.getEnd();
		passenger = current.getPassenger();
		if (passenger != null) {
			passengerAdded();
		}
		
		
	}
	
	private void passengerAdded() {
		System.out.println(this + " is collecting " + passenger.toString() + " at " + getCurrentRoad().getEnd() );
		path = passenger.getPath();
		index = 0;
		distanceTraveled = 0;
		currentRoad = path.get(index);	
	}

	public boolean isFinished() { 
		return finished;
	}
	
	public Road getCurrentRoad() {
		return currentRoad;
	}
	
	public void dropOfPassenger() {
		if ( passenger != null) {
			System.out.println(passenger.toString() + " arrived to it's destination with " + this);
			FileManager.writeToFile(passenger, this);
			passenger = null;
		}
	}
	
	@Override
	public String toString() {
		return "Vehicle " + this.carID;
	}

	@Override
	public void work() {
		move();
	}
	
	public double getSpeed() {
		return speed;
	}
}
