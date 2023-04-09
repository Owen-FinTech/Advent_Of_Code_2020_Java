public class BinaryBoardingPt1 {
    public static String inputString = """
        
    """; // Insert your puzzle input between the triple quotes

    public static int getMaxID(String inputString) {
        String[] input = inputString.split("\n", 0);
        int maxID = 0;
        
        for (int i = 0; i < input.length; ++i) {
            int seatID = 0;
            int row = 0;
            int rowLowerBound = 0;
            int rowUpperBound = 127;
            int col = 0;
            int colLowerBound = 0;
            int colUpperBound = 7;
            
            for (int j = 0; j < 6; ++j) {
                if (input[i].substring(j, j + 1).equals("F")) {
                    rowUpperBound = (int)Math.floor((rowUpperBound - rowLowerBound) / 2.0) + rowLowerBound;
                }
                else if (input[i].substring(j, j + 1).equals("B")) {
                    rowLowerBound = (int)Math.ceil((rowUpperBound - rowLowerBound) / 2.0) + rowLowerBound;
                }
            }

            if (input[i].substring(6, 7).equals("F")) {
                row = rowLowerBound;
            }
            else if (input[i].substring(6, 7).equals("B")) {
                row = rowUpperBound;
            }

            for (int j = 7; j < 9; ++j) {
                if (input[i].substring(j, j + 1).equals("L")) {
                    colUpperBound = (int)Math.floor((colUpperBound - colLowerBound) / 2.0) + colLowerBound;
                }
                else if (input[i].substring(j, j + 1).equals("R")) {
                    colLowerBound = (int)Math.ceil((colUpperBound - colLowerBound) / 2.0) + colLowerBound;
                }
            }

            if (input[i].substring(9).equals("L")) {
                col = colLowerBound;
            }
            else if (input[i].substring(9).equals("R")) {
                col = colUpperBound;
            }

            seatID = row * 8 + col;

            if (seatID > maxID) {
                maxID = seatID;
            }
        }

        return maxID;
    }


    public static void main(String[] args) {
        System.out.println(getMaxID(inputString));

    }
}