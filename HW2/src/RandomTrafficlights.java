import java.util.Random;

public class RandomTrafficlights extends Trafficlights {
	
	public RandomTrafficlights(Junction j) {
		Random r = new Random();
		delay = r.nextInt(3)+2;
		
		myJunction = j;
		changeLight();
	}
	
	public void changeLight() {
		Random r = new Random();
		int index = r.nextInt(myJunction.getEnteringRoads().size());
		currentGreen = myJunction.getEnteringRoads().get(index);
		System.out.println(this);
	}
	
	public void check() {
		turns++;
		if (turns % delay == 0) {
			changeLight();
		}
	}
	
	@Override
	public String toString() {
		return "Random TrafficLights Junction " + myJunction.getJuncNum() +", delay= " + delay + ": green light on " + currentGreen;
	}

	@Override
	public void work() {
		check();
	}	
}
