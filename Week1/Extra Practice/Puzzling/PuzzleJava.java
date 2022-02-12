import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class PuzzleJava {

    Random rand = new Random();

    public ArrayList<Integer> getTenRolls() {

        ArrayList<Integer>randomRoll = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            randomRoll.add(rand.nextInt(20) + 1);
        }

        return randomRoll;

    }

    public String getRandomLetter() {

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] alphabetArray = new String[26];
        for (int i = 0; i < 26; i++) {
            alphabetArray[i] = String.valueOf(alphabet.charAt(i));
        }

        return alphabetArray[rand.nextInt(26)];

    }

    public String generatePassword(){

        String password = "";
        for (int i = 0; i < 8; i++) {
            password = password + getRandomLetter();
        }

        return password;

    }

    public ArrayList<String> getNewPasswordSet (int length) {

        ArrayList<String> newPassword = new ArrayList<String>();
        for (int i = 0; i < length; i++) {
            newPassword.add(generatePassword());
        }

        return newPassword;



    }

    // SENSEI BONUS

    public ArrayList<Object> shuffleArray (ArrayList<Object> array) {

        
        // ArrayList<Integer> newArray = new ArrayList<Integer>();
        if (array.size() > 2) {
            for (int i = 0; i < array.size(); i++) {

                int index = rand.nextInt(array.size()-1);
                Object x = array.get(index);
                array.set(index, array.get((array.size()-1) - index));
                array.set(((array.size()-1) - index), x);
                int index2 = rand.nextInt(array.size()-2);
                Object y = array.get(index2);
                array.set(index2, array.get((array.size()-2) - index2));
                array.set(((array.size()-2) - index2), y);
                
            }
        }
        

        else {

            System.out.println("Array must have at least 3 elements");

        }
        
        return array;

        // Random r = new Random();
		// for(int i = 0; i < arr.length/2; i++) {
		// 	Object temp = arr[i];
		// 	int randomIdx = r.nextInt(arr.length - i) + i;
		// 	arr[i] = arr[randomIdx];
		// 	arr[randomIdx] = temp;

        


    }
    
}
    
    

    

