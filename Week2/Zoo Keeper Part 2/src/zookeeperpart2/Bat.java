package zookeeperpart2;

public class Bat extends Mammal {

	public Bat (int energyLevel) {
		super(300);
	}
	
	public void fly() {
		System.out.println("Whooosh!");
		this.energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("So... Well never mind");
		this.energyLevel -= 25;
	}
	
	public void attackTown() {
		System.out.println("AAAAHHHHH!!!");
		this.energyLevel -= 100;
		
	}
}
