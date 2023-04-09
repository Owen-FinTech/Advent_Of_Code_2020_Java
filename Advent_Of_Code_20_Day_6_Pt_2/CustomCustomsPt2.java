import java.util.*;

public class CustomCustomsPt2 {
    public static String inputString = """
    
    """; // Insert your puzzle input between the triple quotes

    public static String[] separatedGroupStrings(String inputString) {
        String[] separatedArray = inputString.split("\n\n", 0);

        return separatedArray; 
    }

    public static ArrayList<PassengerGroup> buildArrayList(String[] separatedArray) {
        ArrayList<PassengerGroup> groupArrayList = new ArrayList<PassengerGroup>();

        for (int i = 0; i < separatedArray.length; ++i) {
            PassengerGroup newGroup = new PassengerGroup(separatedArray[i]);
            groupArrayList.add(newGroup);
        }

        return groupArrayList;
    }

    public static int findYesEveryone(ArrayList<PassengerGroup> groupArrayList) {
        int count = 0;

        for (int i = 0; i < groupArrayList.size(); ++i) {
            Set<String> keys = groupArrayList.get(i).getOccurances().keySet();
            Iterator<String> key = keys.iterator();

            while(key.hasNext()) {
                if (groupArrayList.get(i).getOccurances().get(key.next()) == 
                groupArrayList.get(i).getPeopleInGroup()) {
                    ++count;
                } 
            }  
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(findYesEveryone(buildArrayList(separatedGroupStrings(inputString))));

    }
}