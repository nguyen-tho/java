import java.util.StringTokenizer;

public class SerialNumber {
    private String first; // First group of characters
    private String second; // Second group of characters
    private String third; // Third group of characters
    private boolean valid; // Flag indicating validity

    public SerialNumber(String sn) {
        // Create a StringTokenizer and initialize it with
        // a trimmed copy of sn.

        StringTokenizer st = new StringTokenizer(sn.trim(), "-");

        // Tokenize and validate.

        if (st.countTokens() != 3)
            valid = false;
        else {
            first = st.nextToken();
            second = st.nextToken();
            third = st.nextToken();
            validate();
        }

    }

    public boolean isValid() {
        return valid;
    }

    private void validate() {
        if (isFirstGroupValid() && isSecondGroupValid() && isThirdGroupValid())
            valid = true;
        else
            valid = false;
    }

    private boolean isFirstGroupValid() {
        boolean groupGood = true; // Flag
        int i = 0; // Loop control variable

        // Check the length of the group.
        if (first.length() != 5)
            groupGood = false;

        // See if each character is a letter.
        while (groupGood && i < first.length()) {
            if (!Character.isLetter(first.charAt(i)))
                groupGood = false;
            i++;
        }

        return groupGood;
    }

    private boolean isSecondGroupValid() {
        boolean groupGood = true; // Flag
        int i = 0; // Loop control variable

        // Check the length of the group.
        if (second.length() != 4)
            groupGood = false;

        // See if each character is a digit.
        while (groupGood && i < second.length()) {
            if (!Character.isDigit(second.charAt(i)))
                groupGood = false;
            i++;
        }

        return groupGood;
    }

    private boolean isThirdGroupValid() {
        boolean groupGood = true;
        int i = 0;

        if (third.length() != 4)
            groupGood = false;

        while (groupGood && i < third.length()) {
            if (!Character.isLetter(third.charAt(i)))
                groupGood = false;
            i++;
        }

        return groupGood;
    }
}