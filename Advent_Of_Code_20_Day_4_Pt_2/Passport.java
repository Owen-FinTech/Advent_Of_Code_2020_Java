import java.util.HashMap;

public class Passport {
    private String[] separatedFields;
    private HashMap<String, String> separatedFieldsHashMap = new HashMap<String, String>();

    public Passport(String unseparatedPassportFields) {
        unseparatedPassportFields = unseparatedPassportFields.replace('\n', ' ');
        separatedFields = unseparatedPassportFields.split(" ", 0); 

        for (int i = 0; i < separatedFields.length; ++i) {
            separatedFieldsHashMap.put(separatedFields[i].substring(0, 3), separatedFields[i].substring(4)); 
        }
    }

    public HashMap<String, String> getHashMap() {
        return this.separatedFieldsHashMap;
    }
}
