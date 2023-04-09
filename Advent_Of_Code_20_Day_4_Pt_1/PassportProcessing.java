import java.util.ArrayList;

public class PassportProcessing {
    public static String inputString = """
        
    """; // Insert your puzzle input between the triple quotes

    public static ArrayList<Passport> buildPassportObjects(String inputString) {
        String[] firstArray = inputString.split("\n\n", 0);
        ArrayList<Passport> passportArrayList = new ArrayList<Passport>();

        for (int i = 0; i < firstArray.length; ++i) {
            Passport currPassport = new Passport(firstArray[i]);
            passportArrayList.add(currPassport);
        }

        return passportArrayList;
    }

    public static int numOfValidPassports(ArrayList<Passport> passportArrayList) {
        int validCount = 0;
        String[] requiredFields = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};

        for (int i = 0; i < passportArrayList.size(); ++i) {
            int fieldCount = 0;

            for (int j = 0; j < passportArrayList.get(i).getSeparatedFields().length; ++j) {

                for (int k = 0; k < requiredFields.length; ++k) {

                    if (passportArrayList.get(i).getSeparatedFields()[j].substring(0, 3).equals(requiredFields[k])) {
                        ++fieldCount;
                    }
                }
            }

            if (fieldCount >= 7) {
                ++validCount;
            }
        }

        return validCount;
    }

    public static void main(String[] args) {
        ArrayList<Passport> passports = buildPassportObjects(inputString);

        System.out.println(numOfValidPassports(passports));
    }
}