
public class Road {
	private Junction start;
	private Junction end;
	private double length;
	
	public Junction getStart() {
		return start;
	}
	
	public Junction getEnd() {
		return end;
	}


	public double getLength() {
		return length;
	}

	public Road(Junction start, Junction end) {
		this.start = start;
		this.end = end;
		checkRoad();
		length = this.start.calcDistance(this.end);
		start.addExitingRoads(this);
		end.addEnteringRoads(this);
		
		System.out.println("Creating " + this + ", length: " + length);
	}
	
	private void checkRoad() {
		if (this.start == this.end) {
			 this.end = new Junction();
			 System.out.println("Road can not connect a junction to itself, the end junction has been \r\n"
			 		+ "replaced with Junction " + end.getJuncNum());
		}
	}

	@Override
	public String toString() {
		return "Road from Junction " + start.getJuncNum() + " to Junction " + end.getJuncNum();
	}
}
