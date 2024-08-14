
import java.util.ArrayList;

public class Passenger {
	private ArrayList<Road> path;
	int id;

	
	public Passenger(Map map,int id) {
		path = map.calcPath();
		start();
		this.id = id;
	}
	
	private void start() {
		Junction j = path.get(0).getStart();
		j.addPessenger(this);
	}

	public ArrayList<Road> getPath() {
		return path;
	}
	
	@Override
	public String toString() {
		return "Passenger " + this.id;
	}

}
