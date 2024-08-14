
public abstract class Trafficlights implements Dynamic{
	
	protected int delay;
	protected int turns = 0;
	
	protected Junction myJunction;
	protected Road currentGreen;
	
	public abstract void changeLight();
	
	public abstract void check();
	
	public Road getCurrentGreen() {
		return currentGreen;
	}	
}
