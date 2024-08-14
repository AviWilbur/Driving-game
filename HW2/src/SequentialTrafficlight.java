import java.util.Random;

public class SequentialTrafficlight extends Trafficlights {
	
	private int delay;
	private int turns = 0;
	
	private Junction myJunction;
	private int index=0;

	
	public SequentialTrafficlight(Junction j) {
		Random r = new Random();
		delay = r.nextInt(3)+2;
		myJunction = j;
		changeLight();
	}
	
	public void changeLight() {
		currentGreen = myJunction.getEnteringRoads().get(index);	
		index++;
		if (index==myJunction.getEnteringRoads().size()) {
			index = 0;
		}
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
		return "SequentialTrafficLights Junction " + myJunction.getJuncNum() +", delay= " + delay + ": green light on " + currentGreen;
	}

	@Override
	public void work() {
		check();
	}
}