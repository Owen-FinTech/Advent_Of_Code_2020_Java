public class TobogganTrajectory {
    public static String inputString = """
        
    """; // Insert your puzzle input between the triple quotes

    public static char[][] stringTo2DCharArray(String inputString) {
        String[] input = inputString.split("\n", 0);
        char[][] charArray = new char[input.length][input[0].length()];
        
        for (int i = 0; i < input.length; ++i) {
            for (int j = 0; j < input[i].length(); ++j) {
                charArray[i][j] = input[i].charAt(j);
            }
        } 

        return charArray;
    }

    public static int numTreesTraversed(char[][] slopeGrid) {
        int currRow = 1;
        int currCol = 3;
        int treesCount = 0;

        while(currRow < slopeGrid.length) {
            if (slopeGrid[currRow][currCol] == '#') {
                ++treesCount;
            }

            ++currRow;
            currCol = (currCol + 3) % slopeGrid[0].length;
        }

        return treesCount;
    }

    public static void main(String[] args) {
        char[][] slopeGrid = stringTo2DCharArray(inputString);
        System.out.println(numTreesTraversed(slopeGrid));
    }
}