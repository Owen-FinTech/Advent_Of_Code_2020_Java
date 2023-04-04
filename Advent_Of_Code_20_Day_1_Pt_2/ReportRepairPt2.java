public class ReportRepairPt2 {
    public static String inputString = """
   
    """; // Insert your puzzle input between the triple quotes

    public static int[] createIntArray(String inputString) {
        String[] arrayOfStrings = inputString.split("\n", 0);
        int[] intArray = new int[arrayOfStrings.length];

        for (int i = 0; i < arrayOfStrings.length; ++i) {
            intArray[i] = Integer.parseInt(arrayOfStrings[i]);
        }

        return intArray;
    }

    public static int findProductOfSum(int[] intArray) {
        int result = -1;
        for (int i = 0; i < intArray.length; ++i) {
            for (int j = 0; j < intArray.length; ++j) {
                for (int k = 0; k < intArray.length; ++k) {
                    if ((intArray[i] + intArray[j] + intArray[k] == 2020)) {
                        result = intArray[i] * intArray[j] * intArray[k];
                        break;
                    }
                }
                if (result > 0) {
                    break;
                }
            }
            if (result > 0) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findProductOfSum(createIntArray(inputString)));

    }
}