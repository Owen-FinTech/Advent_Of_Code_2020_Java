public class PasswordParameters {
    private int firstOccurance;
    private int secondOccurance;
    private char occuringCharacter;
    private String password;
    private boolean isValid;
    private int hyphenIndex = 0;
    private int spaceCount = 0;

    public PasswordParameters (String passwordParametersString) {
        for (int i = 0; i < passwordParametersString.length(); ++i) {
            if (passwordParametersString.charAt(i) == '-') {
                firstOccurance = Integer.parseInt(passwordParametersString.substring(0, i));
                hyphenIndex = i;
            } else if ((passwordParametersString.charAt(i) == ' ') && (spaceCount == 0)) {
                secondOccurance = Integer.parseInt(passwordParametersString.substring(hyphenIndex + 1, i));
                ++spaceCount;
            } else if ((passwordParametersString.charAt(i) == ' ') && (spaceCount == 1)) {
                occuringCharacter = passwordParametersString.charAt(i - 2);
                password = passwordParametersString.substring(i + 1);
                ++spaceCount;
            }
        }
    }

    public boolean calculateIsValid () {
        if (((password.charAt(firstOccurance - 1) == occuringCharacter) && 
            (password.charAt(secondOccurance - 1) != occuringCharacter)) || 
            ((password.charAt(firstOccurance - 1) != occuringCharacter) && 
            (password.charAt(secondOccurance - 1) == occuringCharacter))) {
            isValid = true;
        } 
        else {
            isValid = false;
        }

        return isValid;
    }
}
