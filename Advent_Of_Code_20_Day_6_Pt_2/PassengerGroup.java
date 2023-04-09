import java.util.*;

public class PassengerGroup {
    private int peopleInGroup;
    private HashMap<String, Integer> occurances = new HashMap<String, Integer>();
    
    
    public PassengerGroup(String groupString) {
        String[] tempArray = groupString.split("\n", 0);
        peopleInGroup = tempArray.length;
        
        for (int i = 0; i < tempArray.length; ++i) {

            for (int j = 0; j < tempArray[i].length(); ++j) {

                if (occurances.containsKey(tempArray[i].substring(j, j + 1))) {
                    occurances.put(tempArray[i].substring(j, j + 1), 
                    occurances.get(tempArray[i].substring(j, j + 1)) + 1);
                }
                else {
                    occurances.put(tempArray[i].substring(j, j + 1), 1);
                }
            }
        }
    }

    public int getPeopleInGroup() {
        return this.peopleInGroup;
    }

    public HashMap<String, Integer> getOccurances() {
        return this.occurances;
    }
}
