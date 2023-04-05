import java.math.BigInteger;

public class TobogganTrajectoryPt2 {
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

    public static int numTreesTraversed(char[][] slopeGrid, int horizontalAmount, int verticalAmount) {
        int currRow = verticalAmount;
        int currCol = horizontalAmount;
        int treesCount = 0;

        while(currRow < slopeGrid.length) {
            if (slopeGrid[currRow][currCol] == '#') {
                ++treesCount;
            }

            currRow += verticalAmount;
            currCol = (currCol + horizontalAmount) % slopeGrid[0].length;
        }

        return treesCount;
    }

    public static void main(String[] args) {
        char[][] slopeGrid = stringTo2DCharArray(inputString);
        BigInteger firstSlope = BigInteger.valueOf(numTreesTraversed(slopeGrid, 1, 1));
        BigInteger secondSlope = BigInteger.valueOf(numTreesTraversed(slopeGrid, 3, 1));
        BigInteger thirdSlope = BigInteger.valueOf(numTreesTraversed(slopeGrid, 5, 1));
        BigInteger forthSlope = BigInteger.valueOf(numTreesTraversed(slopeGrid, 7, 1));
        BigInteger fifthSlope = BigInteger.valueOf(numTreesTraversed(slopeGrid, 1, 2));

        BigInteger result;
        result = firstSlope.multiply(secondSlope);
        result = result.multiply(thirdSlope);
        result = result.multiply(forthSlope);
        result = result.multiply(fifthSlope);
        System.out.println(result);
                            
    }
}