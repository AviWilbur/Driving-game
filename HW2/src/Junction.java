import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Junction extends Point {

	private static int counter = 1;
	private int junc_num;
	private boolean SET_JUNC;
	private Trafficlights tl = null;
	private ArrayList<Road> enteringRoads = new ArrayList<Road>();
	private ArrayList<Road> exitingRoads = new ArrayList<Road>();
	Queue<Passenger> Q = new ArrayDeque<>();


	public Junction() {
		super();
		System.out.println(" at " + super.toString());
	}

	public Junction(int x,int y) {
		super();
	}

	private int getjunc() {
		if(!SET_JUNC) {
			junc_num = counter++;
			SET_JUNC = true;
		}
		return junc_num;
	}

	public void setTrafficlights(Trafficlights tl) {
		this.tl = tl;
	}

	public int getJuncNum() {
		return junc_num;
	}

	public void addEnteringRoads(Road x) {
		enteringRoads.add(x);
	}

	public void addExitingRoads(Road x) {
		exitingRoads.add(x);
	}

	public ArrayList<Road> getExitingRoads() {
		return exitingRoads;
	}

	public ArrayList<Road> getEnteringRoads() {
		return enteringRoads;
	}	

	public Road getCurrentGreen() {
		if (tl != null) {
			return tl.currentGreen;
		}
		return null;
	}

	@Override
	public String toString() {
		return "Junction "+ getjunc();
	}

	public void addPessenger(Passenger passenger) {
		Q.add(passenger);	
	}

	public Passenger getPassenger() {
		return Q.poll();
	}
}
