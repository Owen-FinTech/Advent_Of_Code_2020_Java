import java.util.*;

public class BagRelationships {
    String bagColour;
    HashMap<String, Integer> containsBags = new HashMap<String, Integer>();

    public BagRelationships(String bagRules) {
        String[] tempArray = bagRules.split(" ", 0);
        bagColour = tempArray[0] + " " + tempArray[1];

        for (int i = 3; i < tempArray.length; ++i) {
            if (tempArray[i].length() > 3) {

                if (tempArray[i].substring(0, 3).equals("bag") &&
                !tempArray[i - 2].equals("no")) {
                    containsBags.put(tempArray[i - 2] + " " + tempArray[i - 1], Integer.parseInt(tempArray[i - 3]));
                }
            } 
            else if (tempArray[i].equals("bag")) {
                containsBags.put(tempArray[i - 2] + " " + tempArray[i - 1], Integer.parseInt(tempArray[i - 3]));
            }  
        }
    }

    public String getBagColour() {
        return this.bagColour;
    }

    public HashMap<String, Integer> getContainsBags() {
        return this.containsBags;
    }
}
