import java.math.BigInteger;
import java.util.ArrayList;

public class EncodingErrorPt1 {
    public static String inputString = """
  
    """; // Insert your puzzle inputs between the triple quotes

    public static ArrayList<BigInteger> buildArrayList(String inputString) {
        ArrayList<BigInteger> numberArrayList = new ArrayList<BigInteger>();
        String[] numberArrayAsStrings = inputString.split("\n", 0);
        
        for (int i = 0; i < numberArrayAsStrings.length; ++i) {
            numberArrayList.add(BigInteger.valueOf(Long.parseLong(numberArrayAsStrings[i])));
        }

        return numberArrayList;
    } 

    public static BigInteger findInvalidNumber(ArrayList<BigInteger> numberArrayList, Integer preambleLength) {
        BigInteger invalidNumber = null;

        while (invalidNumber == null) {
            Integer startPoint = 0;

            for (int i = (preambleLength + startPoint); i < numberArrayList.size(); ++i) {
                Integer validCount = 0;
                 
                for (int j = startPoint; j < (preambleLength + startPoint); ++j) {
                    for (int k = startPoint; k < (preambleLength + startPoint); ++k) {
                        if ((numberArrayList.get(j).add(numberArrayList.get(k)).equals(numberArrayList.get(i))) 
                        && !(numberArrayList.get(j).equals(numberArrayList.get(k)))) {
                            validCount += 1;
                        }
                    }
                }

                if (validCount == 0) {
                    invalidNumber = numberArrayList.get(i);
                }
                startPoint += 1;
            }
        }
        return invalidNumber;

    }

    public static void main(String[] args) {
        
        System.out.println(findInvalidNumber(buildArrayList(inputString), 25));
       
    }

}