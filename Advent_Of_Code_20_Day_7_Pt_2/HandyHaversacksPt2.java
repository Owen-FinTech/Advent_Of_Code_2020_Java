import java.util.*;

public class HandyHaversacksPt2 {
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

    public static int numBagsTargetBagContains(ArrayList<BagRelationships> bagArrayList, String targetBag) {
        int numBags = 0;

        for (int i = 0; i < bagArrayList.size(); ++i) {

            if (bagArrayList.get(i).getBagColour().equals(targetBag)) {

                for (int j = 0; j < bagArrayList.size(); ++j) {

                    if (bagArrayList.get(i).getContainsBags().containsKey(bagArrayList.get(j).getBagColour())) {
                        Integer tempValue = bagArrayList.get(i).getContainsBags().get(bagArrayList.get(j).getBagColour());
                        numBags += tempValue;
                        numBags += tempValue * numBagsTargetBagContains(bagArrayList, bagArrayList.get(j).getBagColour());
                    }
                }
            }
        }

        return numBags;
    }

    public static void main(String[] args) {
        System.out.println(numBagsTargetBagContains(buildBagArrayList(separatedBagRules(inputString)), "shiny gold"));
    }
}