import java.util.*;

public class SeatingSystemPt1 {

    public static String inputString = """

    """; // Insert your puzzle inputs between the triple quotes

    public static ArrayList<ArrayList<String>> buildArrayList(String inputString) {
        ArrayList<ArrayList<String>> seatingArrayList = new ArrayList<ArrayList<String>>();
        String[] rowArrayAsStrings = inputString.split("\n", 0);

        for (int i = 0; i < rowArrayAsStrings.length; ++i) {
            ArrayList<String> rowArrayList = new ArrayList<String>();

            for (int j = 0; j < rowArrayAsStrings[i].length(); ++j) {
                rowArrayList.add(String.valueOf(rowArrayAsStrings[i].charAt(j)));   
            }
            seatingArrayList.add(rowArrayList);
        }
        return seatingArrayList;
    }

    public static Integer countOccupiedSeatsStabilized(ArrayList<ArrayList<String>> seatingArrayList) {
        boolean notStabilized = true;
        ArrayList<ArrayList<String>> copyOfSeatingArrayList = new ArrayList<ArrayList<String>>();
        Integer occupiedCount = 0;

        for (int i = 0; i < seatingArrayList.size(); ++i) {
                ArrayList<String> rowToCopy = new ArrayList<String>();

                for (int j = 0; j < seatingArrayList.get(i).size(); ++j) {
                    rowToCopy.add(seatingArrayList.get(i).get(j));
                }

                copyOfSeatingArrayList.add(rowToCopy);
            }

        while (notStabilized) {
            Integer addCount = 0;

            for (int i = 0; i < seatingArrayList.size(); ++i) {

                for (int j = 0; j < seatingArrayList.get(i).size(); ++j) {

                    if (seatingArrayList.get(i).get(j).equals("L")) { 

                        if (i == 0 && j == 0) {
                            if ((seatingArrayList.get(i).get(j + 1).equals("L") || 
                            seatingArrayList.get(i).get(j + 1).equals(".")) &&
                            (seatingArrayList.get(i + 1).get(j).equals("L") || 
                            seatingArrayList.get(i + 1).get(j).equals(".")) && 
                            (seatingArrayList.get(i + 1).get(j + 1).equals("L") || 
                            seatingArrayList.get(i + 1).get(j + 1).equals("."))) {

                                copyOfSeatingArrayList.get(i).set(j, "#");
                                addCount += 1;
                            }
                        }
                        else if (i == 0 && j == seatingArrayList.get(i).size() - 1) {
                            if ((seatingArrayList.get(i).get(j - 1).equals("L") || 
                            seatingArrayList.get(i).get(j - 1).equals(".")) &&
                            (seatingArrayList.get(i + 1).get(j).equals("L") || 
                            seatingArrayList.get(i + 1).get(j).equals(".")) && 
                            (seatingArrayList.get(i + 1).get(j - 1).equals("L") || 
                            seatingArrayList.get(i + 1).get(j - 1).equals("."))) {

                                copyOfSeatingArrayList.get(i).set(j, "#");
                                addCount += 1;
                            }
                        }
                        else if (i == seatingArrayList.size() - 1 && j == 0) {
                            if ((seatingArrayList.get(i).get(j + 1).equals("L") || 
                            seatingArrayList.get(i).get(j + 1).equals(".")) &&
                            (seatingArrayList.get(i - 1).get(j).equals("L") || 
                            seatingArrayList.get(i - 1).get(j).equals(".")) && 
                            (seatingArrayList.get(i - 1).get(j + 1).equals("L") || 
                            seatingArrayList.get(i - 1).get(j + 1).equals("."))) {

                                copyOfSeatingArrayList.get(i).set(j, "#");
                                addCount += 1;
                            }
                        }
                        else if (i == seatingArrayList.size() - 1 && j == seatingArrayList.get(i).size() - 1) {
                            if ((seatingArrayList.get(i).get(j - 1).equals("L") || 
                            seatingArrayList.get(i).get(j - 1).equals(".")) &&
                            (seatingArrayList.get(i - 1).get(j).equals("L") || 
                            seatingArrayList.get(i - 1).get(j).equals(".")) && 
                            (seatingArrayList.get(i - 1).get(j - 1).equals("L") || 
                            seatingArrayList.get(i - 1).get(j - 1).equals("."))) {

                                copyOfSeatingArrayList.get(i).set(j, "#");
                                addCount += 1;
                            }
                        }
                        else if (i == 0) {
                            if ((seatingArrayList.get(i).get(j + 1).equals("L") || 
                            seatingArrayList.get(i).get(j + 1).equals(".")) &&
                            (seatingArrayList.get(i + 1).get(j + 1).equals("L") || 
                            seatingArrayList.get(i + 1).get(j + 1).equals(".")) && 
                            (seatingArrayList.get(i + 1).get(j).equals("L") || 
                            seatingArrayList.get(i + 1).get(j).equals(".")) && 
                            (seatingArrayList.get(i + 1).get(j - 1).equals("L") || 
                            seatingArrayList.get(i + 1).get(j - 1).equals(".")) && 
                            (seatingArrayList.get(i).get(j - 1).equals("L") || 
                            seatingArrayList.get(i).get(j - 1).equals("."))) {

                                copyOfSeatingArrayList.get(i).set(j, "#");
                                addCount += 1;
                            }
                        }
                        else if (i == seatingArrayList.size() - 1) {
                            if ((seatingArrayList.get(i).get(j + 1).equals("L") || 
                            seatingArrayList.get(i).get(j + 1).equals(".")) &&
                            (seatingArrayList.get(i - 1).get(j + 1).equals("L") || 
                            seatingArrayList.get(i - 1).get(j + 1).equals(".")) && 
                            (seatingArrayList.get(i - 1).get(j).equals("L") || 
                            seatingArrayList.get(i - 1).get(j).equals(".")) && 
                            (seatingArrayList.get(i - 1).get(j - 1).equals("L") || 
                            seatingArrayList.get(i - 1).get(j - 1).equals(".")) && 
                            (seatingArrayList.get(i).get(j - 1).equals("L") || 
                            seatingArrayList.get(i).get(j - 1).equals("."))) {

                                copyOfSeatingArrayList.get(i).set(j, "#");
                                addCount += 1;
                            }
                        }
                        else if (j == 0) {
                            if ((seatingArrayList.get(i - 1).get(j).equals("L") || 
                            seatingArrayList.get(i - 1).get(j).equals(".")) &&
                            (seatingArrayList.get(i - 1).get(j + 1).equals("L") || 
                            seatingArrayList.get(i - 1).get(j + 1).equals(".")) && 
                            (seatingArrayList.get(i).get(j + 1).equals("L") || 
                            seatingArrayList.get(i).get(j + 1).equals(".")) && 
                            (seatingArrayList.get(i + 1).get(j + 1).equals("L") || 
                            seatingArrayList.get(i + 1).get(j + 1).equals(".")) && 
                            (seatingArrayList.get(i + 1).get(j).equals("L") || 
                            seatingArrayList.get(i + 1).get(j).equals("."))) {

                                copyOfSeatingArrayList.get(i).set(j, "#");
                                addCount += 1;
                            }
                        }
                        else if (j == seatingArrayList.get(i).size() - 1) {
                            if ((seatingArrayList.get(i - 1).get(j).equals("L") || 
                            seatingArrayList.get(i - 1).get(j).equals(".")) &&
                            (seatingArrayList.get(i - 1).get(j - 1).equals("L") || 
                            seatingArrayList.get(i - 1).get(j - 1).equals(".")) && 
                            (seatingArrayList.get(i).get(j - 1).equals("L") || 
                            seatingArrayList.get(i).get(j - 1).equals(".")) && 
                            (seatingArrayList.get(i + 1).get(j - 1).equals("L") || 
                            seatingArrayList.get(i + 1).get(j - 1).equals(".")) && 
                            (seatingArrayList.get(i + 1).get(j).equals("L") || 
                            seatingArrayList.get(i + 1).get(j).equals("."))) {

                                copyOfSeatingArrayList.get(i).set(j, "#");
                                addCount += 1;
                            }
                        }
                        else {
                            if ((seatingArrayList.get(i - 1).get(j).equals("L") || 
                            seatingArrayList.get(i - 1).get(j).equals(".")) &&
                            (seatingArrayList.get(i - 1).get(j - 1).equals("L") || 
                            seatingArrayList.get(i - 1).get(j - 1).equals(".")) && 
                            (seatingArrayList.get(i).get(j - 1).equals("L") || 
                            seatingArrayList.get(i).get(j - 1).equals(".")) && 
                            (seatingArrayList.get(i + 1).get(j - 1).equals("L") || 
                            seatingArrayList.get(i + 1).get(j - 1).equals(".")) && 
                            (seatingArrayList.get(i + 1).get(j).equals("L") || 
                            seatingArrayList.get(i + 1).get(j).equals(".")) && 
                            (seatingArrayList.get(i + 1).get(j + 1).equals("L") || 
                            seatingArrayList.get(i + 1).get(j + 1).equals(".")) && 
                            (seatingArrayList.get(i).get(j + 1).equals("L") || 
                            seatingArrayList.get(i).get(j + 1).equals(".")) && 
                            (seatingArrayList.get(i - 1).get(j + 1).equals("L") || 
                            seatingArrayList.get(i - 1).get(j + 1).equals("."))) {

                                copyOfSeatingArrayList.get(i).set(j, "#");
                                addCount += 1;
                            }
                        }
                    }
                    else if (seatingArrayList.get(i).get(j).equals("#")) {
                        Integer adjCount = 0;

                        if (i != 0) {
                            if (seatingArrayList.get(i - 1).get(j).equals("#")) {
                                adjCount += 1;
                            }
                        }

                        if (i != 0 && j != seatingArrayList.get(i).size() - 1) {
                            if (seatingArrayList.get(i - 1).get(j + 1).equals("#")) {
                                adjCount += 1;
                            }
                        }

                        if (j != seatingArrayList.get(i).size() - 1) {
                            if (seatingArrayList.get(i).get(j + 1).equals("#")) {
                                adjCount += 1;
                            }
                        }

                        if (i != seatingArrayList.size() - 1 && j != seatingArrayList.get(i).size() - 1) {
                            if (seatingArrayList.get(i + 1).get(j + 1).equals("#")) {
                                adjCount += 1;
                            }
                        }

                        if (i != seatingArrayList.size() - 1) {
                            if (seatingArrayList.get(i + 1).get(j).equals("#")) {
                                adjCount += 1;
                            }
                        }

                        if (i != seatingArrayList.size() - 1 && j != 0) {
                            if (seatingArrayList.get(i + 1).get(j - 1).equals("#")) {
                                adjCount += 1;
                            }
                        }

                        if (j != 0) {
                            if (seatingArrayList.get(i).get(j - 1).equals("#")) {
                                adjCount += 1;
                            }
                        }

                        if (i != 0 && j != 0) {
                            if (seatingArrayList.get(i - 1).get(j - 1).equals("#")) {
                                adjCount += 1;
                            }
                        }

                        if (adjCount >= 4) {
                            copyOfSeatingArrayList.get(i).set(j, "L");
                            addCount += 1;
                        }
                    }
                }
            }

            if (addCount == 0) {
                notStabilized = false;
            }

            for (int i = 0; i < copyOfSeatingArrayList.size(); ++i) {
                ArrayList<String> rowToCopy = new ArrayList<String>();

                for (int j = 0; j < copyOfSeatingArrayList.get(i).size(); ++j) {
                    rowToCopy.add(copyOfSeatingArrayList.get(i).get(j));
                }

                seatingArrayList.set(i, rowToCopy);
            }
        }

        for (int i = 0; i < copyOfSeatingArrayList.size(); ++i) {

            for (int j = 0; j < copyOfSeatingArrayList.get(i).size(); ++j) {
                if (copyOfSeatingArrayList.get(i).get(j).equals("#")) {
                    occupiedCount += 1;
                }
            }
        }
        return occupiedCount;       
    }

    public static void main(String[] args) {

        System.out.println(countOccupiedSeatsStabilized(buildArrayList(inputString)));

    }
}