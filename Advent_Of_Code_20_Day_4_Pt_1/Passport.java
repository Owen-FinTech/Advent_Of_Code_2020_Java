public class Passport {
    private String[] separatedFields;

    public Passport(String unseparatedPassportFields) {
        unseparatedPassportFields = unseparatedPassportFields.replace('\n', ' ');
        separatedFields = unseparatedPassportFields.split(" ", 0); 
    }

    public String[] getSeparatedFields() {
        return this.separatedFields;
    }
}
