import java.util.*;
import java.lang.Math;

public class RainRiskPt2 {
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
        Integer wayPointVert = 1;
        Integer wayPointHoriz = 10;
        
        for (int i = 0; i < actionsArrayList.size(); ++i) {
            if (actionsArrayList.get(i).substring(0, 1).equals("N")) {
                wayPointVert += Integer.parseInt(actionsArrayList.get(i).substring(1));
            }
            else if (actionsArrayList.get(i).substring(0, 1).equals("S")) {
                wayPointVert -= Integer.parseInt(actionsArrayList.get(i).substring(1));
            }
            else if (actionsArrayList.get(i).substring(0, 1).equals("E")) {
                wayPointHoriz += Integer.parseInt(actionsArrayList.get(i).substring(1));
            }
            else if (actionsArrayList.get(i).substring(0, 1).equals("W")) {
                wayPointHoriz -= Integer.parseInt(actionsArrayList.get(i).substring(1));
            }
            else if (actionsArrayList.get(i).substring(0, 1).equals("R")) {
                Integer wayPointHorizTemp = wayPointHoriz;

                if ((Integer.parseInt(actionsArrayList.get(i).substring(1)) / 90) == 1) { 
                    wayPointHoriz = wayPointVert;
                    wayPointVert = -wayPointHorizTemp;
                }
                else if ((Integer.parseInt(actionsArrayList.get(i).substring(1)) / 90) == 2) {
                    wayPointHoriz = -wayPointHoriz;
                    wayPointVert = -wayPointVert;
                }
                else if ((Integer.parseInt(actionsArrayList.get(i).substring(1)) / 90) == 3) {
                    wayPointHoriz = -wayPointVert;
                    wayPointVert = wayPointHorizTemp;
                }
            }
            else if (actionsArrayList.get(i).substring(0, 1).equals("L")) {
                Integer wayPointHorizTemp = wayPointHoriz;

                if ((Integer.parseInt(actionsArrayList.get(i).substring(1)) / 90) == 1) { 
                    wayPointHoriz = -wayPointVert;
                    wayPointVert = wayPointHorizTemp;
                }
                else if ((Integer.parseInt(actionsArrayList.get(i).substring(1)) / 90) == 2) {
                    wayPointHoriz = -wayPointHoriz;
                    wayPointVert = -wayPointVert;
                }
                else if ((Integer.parseInt(actionsArrayList.get(i).substring(1)) / 90) == 3) {
                    wayPointHoriz = wayPointVert;
                    wayPointVert = -wayPointHorizTemp;
                }
            }
            else if (actionsArrayList.get(i).substring(0, 1).equals("F")) {
                currHoriz += Integer.parseInt(actionsArrayList.get(i).substring(1)) * wayPointHoriz;
                currVert += Integer.parseInt(actionsArrayList.get(i).substring(1)) * wayPointVert;

            }
        }
        return Math.abs(currVert) + Math.abs(currHoriz);
    }

    public static void main(String[] args) {
        System.out.println(findManhattanDist(buildArrayList(inputString)));
    }   
}