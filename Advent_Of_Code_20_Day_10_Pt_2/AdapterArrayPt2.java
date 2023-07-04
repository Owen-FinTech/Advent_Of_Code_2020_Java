import java.math.BigInteger;
import java.util.*;

public class AdapterArrayPt2 {
    public static String inputString = """

    """; // Insert your puzzle inputs between the triple quotes

    public static ArrayList<Integer> buildArrayList(String inputString) {
        ArrayList<Integer> numberArrayList = new ArrayList<Integer>();
        String[] numberArrayAsStrings = inputString.split("\n", 0);
        numberArrayList.add(0);

        for (int i = 0; i < numberArrayAsStrings.length; ++i) {
            numberArrayList.add(Integer.parseInt(numberArrayAsStrings[i]));
        }

        ArrayList<Integer> sortedArrayList = new ArrayList<Integer>();
        Integer prevMin = -1;
        for (int i = 0; i < numberArrayList.size(); ++i) {
            Integer minInt = 10000;
            for (int j = 0; j < numberArrayList.size(); ++j) {
                if (numberArrayList.get(j) < minInt && numberArrayList.get(j) > prevMin) {
                    
                    minInt = numberArrayList.get(j);
                }
            }
            sortedArrayList.add(minInt);
            prevMin = minInt;
        }

        return sortedArrayList;
    }

    public static BigInteger calculateJoltArrangements(ArrayList<Integer> sortedArrayList) {
        Integer previousExit = -1;
        ArrayList<ArrayList<Integer>> entranceExitGroupings = new ArrayList<ArrayList<Integer>>();

        while (previousExit < sortedArrayList.get(sortedArrayList.size() - 1)) {
            ArrayList<Integer> entranceExitGrouping = new ArrayList<Integer>();

            for (int i = 0; i < sortedArrayList.size(); ++i) {
                if (sortedArrayList.get(i) >= previousExit && sortedArrayList.get(i) <= previousExit + 2) {
                    entranceExitGrouping.add(sortedArrayList.get(i));
                    previousExit = sortedArrayList.get(i);
                } 
                else if (sortedArrayList.get(i) >= previousExit) {
                    previousExit = sortedArrayList.get(i);
                    break;
                }
            }

            entranceExitGroupings.add(entranceExitGrouping);

        }
        BigInteger totalArrangements = BigInteger.valueOf(1);

        for (int i = 0; i < entranceExitGroupings.size(); ++i) {
            HashMap<Integer, Integer> splitCount = new HashMap<Integer, Integer>();

            for (int j = 0; j < entranceExitGroupings.get(i).size(); ++j) {
                splitCount.put(entranceExitGroupings.get(i).get(j), 1);
            }

            for (int j = 0; j < entranceExitGroupings.get(i).size(); ++j) {
                if (splitCount.containsKey(entranceExitGroupings.get(i).get(j) + 3)) {
                    splitCount.replace(entranceExitGroupings.get(i).get(j) + 1, 
                    splitCount.get(entranceExitGroupings.get(i).get(j) + 1) + 
                    splitCount.get(entranceExitGroupings.get(i).get(j)));
                    splitCount.replace(entranceExitGroupings.get(i).get(j) + 2, 
                    splitCount.get(entranceExitGroupings.get(i).get(j) + 2) + 
                    splitCount.get(entranceExitGroupings.get(i).get(j)));
                    splitCount.replace(entranceExitGroupings.get(i).get(j) + 3, 
                    splitCount.get(entranceExitGroupings.get(i).get(j) + 3) + 
                    splitCount.get(entranceExitGroupings.get(i).get(j)));
                }
                else if (splitCount.containsKey(entranceExitGroupings.get(i).get(j) + 2)) {
                    splitCount.replace(entranceExitGroupings.get(i).get(j) + 1, 
                    splitCount.get(entranceExitGroupings.get(i).get(j) + 1) + 
                    splitCount.get(entranceExitGroupings.get(i).get(j)));
                    splitCount.replace(entranceExitGroupings.get(i).get(j) + 2, 
                    splitCount.get(entranceExitGroupings.get(i).get(j) + 2) + 
                    splitCount.get(entranceExitGroupings.get(i).get(j)));
                } 
            }

            totalArrangements = totalArrangements.multiply(BigInteger.valueOf(splitCount.get(
                entranceExitGroupings.get(i).get(entranceExitGroupings.get(i).size() - 1))));

        }

        return totalArrangements;
    }


    public static void main(String[] args) {

        System.out.println(calculateJoltArrangements(buildArrayList(inputString)));

    }
}