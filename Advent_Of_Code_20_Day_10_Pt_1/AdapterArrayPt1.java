import java.util.ArrayList;

public class AdapterArrayPt1 {
    public static String inputString = """

    """; // Insert your puzzle inputs between the triple quotes

    public static ArrayList<Integer> buildArrayList(String inputString) {
        ArrayList<Integer> numberArrayList = new ArrayList<Integer>();
        String[] numberArrayAsStrings = inputString.split("\n", 0);

        for (int i = 0; i < numberArrayAsStrings.length; ++i) {
            numberArrayList.add(Integer.parseInt(numberArrayAsStrings[i]));
        }

        return numberArrayList;
    }

    public static Integer calculateJoltDifference(ArrayList<Integer> numberArrayList) {
        Integer currentJolt = 0;
        Integer oneJoltDiffCount = 0;
        Integer threeJoltDiffCount = 1;

        for (int i = 0; i < numberArrayList.size(); ++i) {
            ArrayList<Integer> joltCandidates = new ArrayList<Integer>();
            
            for (int j = 0; j < numberArrayList.size(); ++j) {
                if ((numberArrayList.get(j) - currentJolt == 1)) {
                    joltCandidates.add(numberArrayList.get(j));
                } 
                else if ((numberArrayList.get(j) - currentJolt == 2)) {
                    joltCandidates.add(numberArrayList.get(j));
                }
                else if ((numberArrayList.get(j) - currentJolt == 3)) {
                    joltCandidates.add(numberArrayList.get(j));
                }
            }

            Integer minJolt = joltCandidates.get(0);

            for (int j = 0; j < joltCandidates.size(); ++j) {
                if (joltCandidates.get(j) < minJolt) {
                    minJolt = joltCandidates.get(j);
                }
            }
            
            if (minJolt - currentJolt == 1) {
                oneJoltDiffCount += 1;
            }
            else if (minJolt - currentJolt == 3) {
                threeJoltDiffCount += 1;
            }

            currentJolt = minJolt;

        } 

        return oneJoltDiffCount * threeJoltDiffCount;
    }

    public static void main(String[] args) {

        System.out.println(calculateJoltDifference(buildArrayList(inputString)));

    }
}