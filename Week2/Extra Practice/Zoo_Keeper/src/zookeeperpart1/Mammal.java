package zookeeperpart1;

public class Mammal {
	
	int energyLevel = 100;
	
	public Mammal() {
		
	}
	

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public int displayEnergyLevel() {
		System.out.println("Energy level: " + this.energyLevel);
		return this.energyLevel;
	}
	

}
