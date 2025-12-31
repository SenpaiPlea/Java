package partArrayDemo;

import java.util.Iterator;

public class PartArrayDemo {

	private Tamagotchi[] pets;
	private int maxNumbOfPets;
	public PartArrayDemo(int maxNumbOfPets) {
		this.maxNumbOfPets = maxNumbOfPets;
		pets = new Tamagotchi[maxNumbOfPets]); 
	}
	public void add(Tamagotchi newPet) {
		for (int i = 0; i<pets.length; i++) {
			if(pets[i])
		}
	}
	public void allSpeak() {
		for (Tamagotchi tamagotchi : pets) {
			tamagotchi.speak();
		}
	}
	
	
	public static void main(String[] args) {
		// 

		PartArrayDemo myPets = new PartArrayDemo(5);
		
	}

}
