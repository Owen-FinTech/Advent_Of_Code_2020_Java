public class PasswordParameters {
    private int minOccurances;
    private int maxOccurances;
    private char occuringCharacter;
    private String password;
    private boolean isValid;
    private int hyphenIndex = 0;
    private int spaceCount = 0;

    public PasswordParameters (String passwordParametersString) {
        for (int i = 0; i < passwordParametersString.length(); ++i) {
            if (passwordParametersString.charAt(i) == '-') {
                minOccurances = Integer.parseInt(passwordParametersString.substring(0, i));
                hyphenIndex = i;
            } else if ((passwordParametersString.charAt(i) == ' ') && (spaceCount == 0)) {
                maxOccurances = Integer.parseInt(passwordParametersString.substring(hyphenIndex + 1, i));
                ++spaceCount;
            } else if ((passwordParametersString.charAt(i) == ' ') && (spaceCount == 1)) {
                occuringCharacter = passwordParametersString.charAt(i - 2);
                password = passwordParametersString.substring(i + 1);
                ++spaceCount;
            }
        }
    }

    public boolean calculateIsValid () {
        int charCount = 0;

        for (int i = 0; i < password.length(); ++i) {
            if (password.charAt(i) == occuringCharacter) {
                ++charCount;
            }
        }

        if ((charCount >= minOccurances) && (charCount <= maxOccurances)) {
            isValid = true;
        }
        else {
            isValid = false;
        }

        return isValid;
    }
}
