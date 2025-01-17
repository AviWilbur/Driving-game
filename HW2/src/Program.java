//The driving game simulates a system where vehicles navigate a map, following a series of roads and interacting with traffic lights and 
//passengers. The Vehicle class represents each car, moving along a path generated by the Map class, which connects junctions with roads and
//assigns random traffic lights to control flow. As vehicles travel, they may pick up passengers waiting at junctions and drop them off at
//their destinations, with the passenger's journey being logged by the FileManager. Traffic lights, managed by classes like RandomTrafficlights,
//change randomly, affecting whether vehicles can proceed or must wait. The game progresses in turns, with vehicles and traffic lights acting
//as dynamic entities that perform actions each turn. The simulation continues until all vehicles have completed their paths, 
//ensuring efficient and coordinated movement across the map.

public class Program {

	public static void main(String[] args) {
		
		DrivingGame game=new DrivingGame(10, 5);
		game.play();
	}
}
