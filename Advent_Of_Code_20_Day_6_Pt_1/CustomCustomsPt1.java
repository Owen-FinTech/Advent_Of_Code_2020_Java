public class CustomCustomsPt1 {
    public static String inputString = """

    """; // Insert your puzzle input between the triple quotes

    public static String[] separatedGroups(String inputString) {
        String[] separatedArray = inputString.split("\n\n", 0);

        return separatedArray; 
    }

    public static int sumUniqueLetters(String[] separatedArray) {
        int uniqueLetters = 0;

        for (int i = 0; i < separatedArray.length; ++i) {
            String tempString = "";
            
            for (int j = 0; j < separatedArray[i].length(); ++j) {
                
                if ((tempString.indexOf(separatedArray[i].substring(j, j + 1)) == -1) &&
                (!separatedArray[i].substring(j, j + 1).equals("\n"))) {
                    tempString += separatedArray[i].substring(j, j + 1);
                }
            }

            uniqueLetters += tempString.length();
        }

        return uniqueLetters;
    }

    public static void main(String[] args) {
        System.out.println(sumUniqueLetters(separatedGroups(inputString)));
    }
}