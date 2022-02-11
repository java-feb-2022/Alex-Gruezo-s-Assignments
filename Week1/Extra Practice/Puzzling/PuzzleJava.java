import java.util.ArrayList;
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
}
    
    

    

