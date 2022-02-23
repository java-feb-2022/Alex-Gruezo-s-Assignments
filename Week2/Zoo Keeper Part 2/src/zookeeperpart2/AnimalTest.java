package zookeeperpart2;

public class AnimalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gorilla george = new Gorilla(0);
		george.throwSomething();
		george.throwSomething();
		george.throwSomething();
		george.eatBananas();
		george.eatBananas();
		george.climb();
		
		george.displayEnergyLevel();
		
		Bat benny = new Bat(0);
		benny.attackTown();
		benny.attackTown();
		benny.attackTown();
		benny.eatHumans();
		benny.eatHumans();
		benny.fly();
		benny.fly();
		benny.displayEnergyLevel();
		
	}

}
