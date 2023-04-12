import java.util.*;

public class BagRelationships {
    String bagColour;
    ArrayList<String> containsBags = new ArrayList<String>();

    public BagRelationships(String bagRules) {
        String[] tempArray = bagRules.split(" ", 0);
        bagColour = tempArray[0] + " " + tempArray[1];

        for (int i = 3; i < tempArray.length; ++i) {
            if (tempArray[i].length() > 3) {

                if (tempArray[i].substring(0, 3).equals("bag")) {
                    containsBags.add(tempArray[i - 2] + " " + tempArray[i - 1]);
                }
            } 
            else if (tempArray[i].equals("bag")) {
                containsBags.add(tempArray[i - 2] + " " + tempArray[i - 1]);
            }  
        }
    }

    public String getBagColour() {
        return this.bagColour;
    }

    public ArrayList<String> getContainsBags() {
        return this.containsBags;
    }
}
