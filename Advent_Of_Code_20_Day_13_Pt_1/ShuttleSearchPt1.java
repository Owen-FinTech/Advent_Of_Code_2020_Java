import java.util.*;

public class ShuttleSearchPt1 {
    public static String inputString = """
    
    """; // Insert your puzzle inputs between the triple quotes

    public static ArrayList<Integer> buildArrayList(String inputString) {
        ArrayList<Integer> numberArrayList = new ArrayList<Integer>();
        String[] firstArrayAsStrings = inputString.split("\n", 0);

        numberArrayList.add(Integer.parseInt(firstArrayAsStrings[0]));
        String[] secondArrayAsStrings = firstArrayAsStrings[1].split(",", 0);

        for (int i = 0; i < secondArrayAsStrings.length; ++i) {
            if (!secondArrayAsStrings[i].equals("x")) {
                numberArrayList.add(Integer.parseInt(secondArrayAsStrings[i]));
            }
        }
        return numberArrayList;
    }

    public static Integer calculateEarliestBus(ArrayList<Integer> numberArrayList) {
        ArrayList<Integer> waitTimes = new ArrayList<Integer>();
        waitTimes.add(0);

        for (int i = 1; i < numberArrayList.size(); ++i) {
            waitTimes.add(numberArrayList.get(i) - (numberArrayList.get(0) % numberArrayList.get(i)));
        }

        Integer minWaitTime = waitTimes.get(1);
        Integer minWaitTimeIndex = 1;

        for (int i = 1; i < waitTimes.size(); ++i) {
            if (waitTimes.get(i) < minWaitTime) {
                minWaitTime = waitTimes.get(i);
                minWaitTimeIndex = i;
            }
        }
        return numberArrayList.get(minWaitTimeIndex) * waitTimes.get(minWaitTimeIndex);
    }

    public static void main(String[] args) {
        System.out.println(calculateEarliestBus(buildArrayList(inputString)));
    }
}