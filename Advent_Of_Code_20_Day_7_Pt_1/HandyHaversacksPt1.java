import java.util.*;

public class HandyHaversacksPt1 {
    public static String inputString = """

    """; // Insert your puzzle input between the triple quotes

    public static String[] separatedBagRules(String inputString) {
        String[] bagRulesArray = inputString.split("\n", 0);
        
        return bagRulesArray;
    }

    public static ArrayList<BagRelationships> buildBagArrayList(String[] bagRulesArray) {
        ArrayList<BagRelationships> bagArrayList = new ArrayList<BagRelationships>();

        for (int i = 0; i < bagRulesArray.length; ++i) {
            BagRelationships newBag = new BagRelationships(bagRulesArray[i]);
            bagArrayList.add(newBag);
        }

        return bagArrayList;
    }

    public static int numContainShinyGold(ArrayList<BagRelationships> bagArrayList) {
        HashSet<String> containers = new HashSet<String>();
        int count = recursiveContains("shiny gold", bagArrayList, containers).size();
        
        return count;
    }

    public static HashSet<String> recursiveContains(String bagColour, 
    ArrayList<BagRelationships> bagArrayList, HashSet<String> containers) {
        for (int i = 0; i < bagArrayList.size(); ++i) {

            for (int j = 0; j < bagArrayList.get(i).getContainsBags().size(); ++j) {

                if (bagArrayList.get(i).getContainsBags().get(j).equals(bagColour)) {
                    containers.add(bagArrayList.get(i).getBagColour());
                    recursiveContains(bagArrayList.get(i).getBagColour(), bagArrayList, containers);
                }
            }
        }

        return containers;
    }

    public static void main(String[] args) {
        System.out.println(numContainShinyGold(buildBagArrayList(separatedBagRules(inputString))));
    }
}