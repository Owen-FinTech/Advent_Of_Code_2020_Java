public class PasswordPhilosophyPt2 {
    public static String inputString = """
        
    """; // Insert your puzzle input between the triple quotes

    public static String[] splitStringIntoArray (String inputString) {
        String[] stringArray = inputString.split("\n", 0);
        return stringArray;
    }

    public static int getValidCount(String[] passwordStringArray) {
        int validCount = 0;

        for (int i = 0; i < passwordStringArray.length; ++i) {
            PasswordParameters currPassword = new PasswordParameters(passwordStringArray[i]);
            if (currPassword.calculateIsValid()) {
                ++validCount;
            }
        }

        return validCount;
    }

    public static void main(String[] args) {
        String [] passwordStringArray = splitStringIntoArray(inputString);
        
        System.out.println(getValidCount(passwordStringArray));
    }
}