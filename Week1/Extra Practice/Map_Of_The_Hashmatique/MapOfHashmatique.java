import java.util.HashMap;
import java.util.Set;

public class MapOfHashmatique {

    public static void main(String[] args) {
        
        HashMap<String, String> trackList = new HashMap<String, String>();

        trackList.put("First Song", "Here are the first set of lyrics");
        trackList.put("Second Song", "Here are the second set of lyrics");
        trackList.put("Third Song", "Here are the third set of lyrics");
        trackList.put("Fourth Song", "Here are the fourth set of lyrics");

        String song = trackList.get("First Song");
        System.out.println(song+"\n");


        Set <String> Lyrics = trackList.keySet();
        for (String Track : Lyrics) {
            System.out.println(Track +": " + trackList.get(Track));
        }

    }


}