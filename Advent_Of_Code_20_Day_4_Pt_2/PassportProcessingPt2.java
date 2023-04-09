import java.util.ArrayList;

public class PassportProcessingPt2 {
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

        for (int i = 0; i < passportArrayList.size(); ++i) {
            int validFields = 0;

            if ((passportArrayList.get(i).getHashMap().size() >= 7) && (passportArrayList.get(i).getHashMap().size() <= 8)) {
                
                if ((passportArrayList.get(i).getHashMap().get("byr") != null) &&
                    (passportArrayList.get(i).getHashMap().get("byr").length() == 4) &&
                    (Integer.parseInt(passportArrayList.get(i).getHashMap().get("byr")) >= 1920) &&
                    (Integer.parseInt(passportArrayList.get(i).getHashMap().get("byr")) <= 2002)) {
                    ++validFields;
                }

                if ((passportArrayList.get(i).getHashMap().get("iyr") != null) &&
                    (passportArrayList.get(i).getHashMap().get("iyr").length() == 4) &&
                    (Integer.parseInt(passportArrayList.get(i).getHashMap().get("iyr")) >= 2010) &&
                    (Integer.parseInt(passportArrayList.get(i).getHashMap().get("iyr")) <= 2020)) {
                    ++validFields;
                }

                if ((passportArrayList.get(i).getHashMap().get("eyr") != null) &&
                    (passportArrayList.get(i).getHashMap().get("eyr").length() == 4) &&
                    (Integer.parseInt(passportArrayList.get(i).getHashMap().get("eyr")) >= 2020) &&
                    (Integer.parseInt(passportArrayList.get(i).getHashMap().get("eyr")) <= 2030)) {
                    ++validFields;
                }

                if ((passportArrayList.get(i).getHashMap().get("hgt") != null) && 
                    (passportArrayList.get(i).getHashMap().get("hgt").substring(
                    passportArrayList.get(i).getHashMap().get("hgt").length() - 2).equals("cm"))) {
                    if ((Integer.parseInt(passportArrayList.get(i).getHashMap().get("hgt").substring(0, 
                        passportArrayList.get(i).getHashMap().get("hgt").length() - 2)) >= 150) &&
                        (Integer.parseInt(passportArrayList.get(i).getHashMap().get("hgt").substring(0, 
                        passportArrayList.get(i).getHashMap().get("hgt").length() - 2)) <= 193)) {
                        ++validFields;
                    }
                }
                else if ((passportArrayList.get(i).getHashMap().get("hgt") != null) && 
                    (passportArrayList.get(i).getHashMap().get("hgt").substring(
                    passportArrayList.get(i).getHashMap().get("hgt").length() - 2).equals("in"))) {
                    if ((Integer.parseInt(passportArrayList.get(i).getHashMap().get("hgt").substring(0, 
                        passportArrayList.get(i).getHashMap().get("hgt").length() - 2)) >= 59) &&
                        (Integer.parseInt(passportArrayList.get(i).getHashMap().get("hgt").substring(0, 
                        passportArrayList.get(i).getHashMap().get("hgt").length() - 2)) <= 76)) {
                        ++validFields;
                    }
                }

                if ((passportArrayList.get(i).getHashMap().get("hcl") != null) && 
                    (passportArrayList.get(i).getHashMap().get("hcl").length() == 7)) {
                    int validChar = 0;

                    if (passportArrayList.get(i).getHashMap().get("hcl").charAt(0) == '#') {
                        ++validChar;
                    }

                    for (int j = 1; j < passportArrayList.get(i).getHashMap().get("hcl").length(); ++j) {
                        if (((passportArrayList.get(i).getHashMap().get("hcl").substring(j,
                            j + 1).compareTo("0") >= 0) &&
                            (passportArrayList.get(i).getHashMap().get("hcl").substring(j,
                            j + 1).compareTo("9") <= 0)) ||
                            ((passportArrayList.get(i).getHashMap().get("hcl").substring(j,
                            j + 1).compareTo("a") >= 0) &&
                            (passportArrayList.get(i).getHashMap().get("hcl").substring(j,
                            j + 1).compareTo("f") <= 0))) {
                            ++validChar;
                        }
                    }

                    if (validChar == 7) {
                        ++validFields;
                    }
                }

                if ((passportArrayList.get(i).getHashMap().get("ecl") != null) &&
                    ((passportArrayList.get(i).getHashMap().get("ecl").equals("amb")) ||
                    (passportArrayList.get(i).getHashMap().get("ecl").equals("blu")) ||
                    (passportArrayList.get(i).getHashMap().get("ecl").equals("brn")) ||
                    (passportArrayList.get(i).getHashMap().get("ecl").equals("gry")) ||
                    (passportArrayList.get(i).getHashMap().get("ecl").equals("grn")) ||
                    (passportArrayList.get(i).getHashMap().get("ecl").equals("hzl")) ||
                    (passportArrayList.get(i).getHashMap().get("ecl").equals("oth")))) {
                    ++validFields;
                }

                if ((passportArrayList.get(i).getHashMap().get("pid") != null) &&
                    (passportArrayList.get(i).getHashMap().get("pid").length() == 9)) {
                    int validNum = 0;

                    for (int j = 0; j < passportArrayList.get(i).getHashMap().get("pid").length(); ++j) {
                        if ((Integer.parseInt(passportArrayList.get(i).getHashMap().get("pid").substring(j, j + 1)) >= 0) && 
                            (Integer.parseInt(passportArrayList.get(i).getHashMap().get("pid").substring(j, j + 1)) <= 9)) {
                            ++validNum;
                        }
                    }

                    if (validNum == 9) {
                        ++validFields;
                    }
                } 

                if (validFields == 7) {
                    ++validCount;
                }
            }
        }

        return validCount;
    }

    public static void main(String[] args) {
        System.out.println(numOfValidPassports(buildPassportObjects(inputString)));
    }
}