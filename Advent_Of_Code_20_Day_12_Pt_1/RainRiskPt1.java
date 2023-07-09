import java.util.*;
import java.lang.Math;

public class RainRiskPt1 {
    public static String inputString = """

    """; // Insert your puzzle inputs between the triple quotes

    public static ArrayList<String> buildArrayList(String inputString) {
        ArrayList<String> actionsArrayList = new ArrayList<String>();
        String[] arrayAsStrings = inputString.split("\n", 0);

        for (int i = 0; i < arrayAsStrings.length; ++i) {
            actionsArrayList.add(arrayAsStrings[i]);
        }
        return actionsArrayList;
    }

    public static Integer findManhattanDist(ArrayList<String> actionsArrayList) {
        Integer currVert = 0;
        Integer currHoriz = 0;
        Integer currDir = 0;
        
        for (int i = 0; i < actionsArrayList.size(); ++i) {
            if (actionsArrayList.get(i).substring(0, 1).equals("N")) {
                currVert += Integer.parseInt(actionsArrayList.get(i).substring(1));
            }
            else if (actionsArrayList.get(i).substring(0, 1).equals("S")) {
                currVert -= Integer.parseInt(actionsArrayList.get(i).substring(1));
            }
            else if (actionsArrayList.get(i).substring(0, 1).equals("E")) {
                currHoriz += Integer.parseInt(actionsArrayList.get(i).substring(1));
            }
            else if (actionsArrayList.get(i).substring(0, 1).equals("W")) {
                currHoriz -= Integer.parseInt(actionsArrayList.get(i).substring(1));
            }
            else if (actionsArrayList.get(i).substring(0, 1).equals("R")) {
                currDir = (currDir + (Integer.parseInt(actionsArrayList.get(i).substring(1)) / 90)) % 4;
            }
            else if (actionsArrayList.get(i).substring(0, 1).equals("L")) {
                currDir = (currDir + (4 - (Integer.parseInt(actionsArrayList.get(i).substring(1)) / 90))) % 4;
            }
            else if (actionsArrayList.get(i).substring(0, 1).equals("F")) {
                if (currDir == 0) {
                    currHoriz += Integer.parseInt(actionsArrayList.get(i).substring(1));
                }
                else if (currDir == 1) {
                    currVert -= Integer.parseInt(actionsArrayList.get(i).substring(1));
                }
                else if (currDir == 2) {
                    currHoriz -= Integer.parseInt(actionsArrayList.get(i).substring(1));
                }
                else if (currDir == 3) {
                    currVert += Integer.parseInt(actionsArrayList.get(i).substring(1));
                }
            }
        }
        return Math.abs(currVert) + Math.abs(currHoriz);
    }

    public static void main(String[] args) {
        System.out.println(findManhattanDist(buildArrayList(inputString)));
    }   
}