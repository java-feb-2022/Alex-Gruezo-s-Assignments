import java.util.ArrayList;



public class TestPuzzleJava {

    public static void main(String[] args) {


		System.out.println("\n----- Ten Rolls -----");
		PuzzleJava generator = new PuzzleJava();
		ArrayList<Integer> randomRolls = generator.getTenRolls();
		System.out.println(randomRolls);
		
		// getRandomLetter Test
		System.out.println("\n----- Random Letter -----");
		String letter = generator.getRandomLetter();
		System.out.println(letter);

		// generatePassword Test
		System.out.println("\n----- Random Password -----");
		String password = generator.generatePassword();
		System.out.println(password);

		// getNewPasswordSet Test
		System.out.println("\n----- New Password Set -----");
		ArrayList<String> newPassword = generator.getNewPasswordSet(5);
		System.out.println(newPassword);

		// shuffleArray Test
		System.out.println("\n----- Shuffle Array Test -----");
		ArrayList<Object> shuffle = new ArrayList<Object>();
		shuffle.add(5);
		shuffle.add("Java");
		shuffle.add(8);
		shuffle.add("Python");
		// shuffle.add(22);
		ArrayList<Object> newList = generator.shuffleArray(shuffle);
		System.out.println(newList);
		
	}
}
