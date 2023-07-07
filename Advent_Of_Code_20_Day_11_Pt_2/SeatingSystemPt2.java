import java.util.*;

public class SeatingSystemPt2 {

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
                    
                    if (!seatingArrayList.get(i).get(j).equals(".")) {
                        boolean empty = true;
                        Integer localOccupiedCount = 0;
                        
                        Integer north = 0;

                        while (i - 1 - north >= 0) {
                            if (!seatingArrayList.get(i - 1 - north).get(j).equals(".")) {
                                if (seatingArrayList.get(i - 1 - north).get(j).equals("#")) {
                                    empty = false;
                                    localOccupiedCount += 1;
                                }                                
                                break;
                            }
                            north += 1;
                        }

                        Integer northEast = 0;

                        while (i - 1 - northEast >= 0 && j + 1 + northEast <= seatingArrayList.get(i).size() - 1) {
                            if (!seatingArrayList.get(i - 1 - northEast).get(j + 1 + northEast).equals(".")) {
                                if (seatingArrayList.get(i - 1 - northEast).get(j + 1 + northEast).equals("#")) {
                                    empty = false;
                                    localOccupiedCount += 1;
                                }                                
                                break;
                            }
                            northEast += 1;
                        }

                        Integer east = 0;

                        while (j + 1 + east <= seatingArrayList.get(i).size() - 1) {
                            if (!seatingArrayList.get(i).get(j + 1 + east).equals(".")) {
                                if (seatingArrayList.get(i).get(j + 1 + east).equals("#")) {
                                    empty = false;
                                    localOccupiedCount += 1;
                                }                                
                                break;
                            }
                            east += 1;
                        }

                        Integer southEast = 0;

                        while (i + 1 + southEast <= seatingArrayList.size() - 1 && j + 1 + southEast <= seatingArrayList.get(i).size() - 1) {
                            if (!seatingArrayList.get(i + 1 + southEast).get(j + 1 + southEast).equals(".")) {
                                if (seatingArrayList.get(i + 1 + southEast).get(j + 1 + southEast).equals("#")) {
                                    empty = false;
                                    localOccupiedCount += 1;
                                }                                
                                break;
                            }
                            southEast += 1;
                        }

                        Integer south = 0;

                        while (i + 1 + south <= seatingArrayList.size() - 1) {
                            if (!seatingArrayList.get(i + 1 + south).get(j).equals(".")) {
                                if (seatingArrayList.get(i + 1 + south).get(j).equals("#")) {
                                    empty = false;
                                    localOccupiedCount += 1;
                                }                                
                                break;
                            }
                            south += 1;
                        }

                        Integer southWest = 0;

                        while (i + 1 + southWest <= seatingArrayList.size() - 1 && j - 1 - southWest >= 0) {
                            if (!seatingArrayList.get(i + 1 + southWest).get(j - 1 - southWest).equals(".")) {
                                if (seatingArrayList.get(i + 1 + southWest).get(j - 1 - southWest).equals("#")) {
                                    empty = false;
                                    localOccupiedCount += 1;
                                }                                
                                break;
                            }
                            southWest += 1;
                        }

                        Integer west = 0;

                        while (j - 1 - west >= 0) {
                            if (!seatingArrayList.get(i).get(j - 1 - west).equals(".")) {
                                if (seatingArrayList.get(i).get(j - 1 - west).equals("#")) {
                                    empty = false;
                                    localOccupiedCount += 1;
                                }                                
                                break;
                            }
                            west += 1;
                        }

                        Integer northWest = 0;

                        while (i - 1 - northWest >= 0 && j - 1 - northWest >= 0) {
                            if (!seatingArrayList.get(i - 1 - northWest).get(j - 1 - northWest).equals(".")) {
                                if (seatingArrayList.get(i - 1 - northWest).get(j - 1 - northWest).equals("#")) {
                                    empty = false;
                                    localOccupiedCount += 1;
                                }                                
                                break;
                            }
                            northWest += 1;
                        }

                        if (seatingArrayList.get(i).get(j).equals("L") && empty) {
                            copyOfSeatingArrayList.get(i).set(j, "#");
                            addCount += 1;
                        }

                        if (seatingArrayList.get(i).get(j).equals("#") && localOccupiedCount >= 5) {
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