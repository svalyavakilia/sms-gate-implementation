package implementation;

import java.util.Set;

public class SMSGate {
    private static final int MAXIMUM_MESSAGE_LENGTH = 160;
    private static final String DOTS = "...";
    private static final Set<Character> SPECIAL_CHARACTERS = Set.of(
        '(', ')', '{', '}', '[', ']', '^', '\\'
    );

    public String formatMessage(final String originalMessage) {
        final int omLength = originalMessage.length();
        final StringBuilder fmBuilder = new StringBuilder();
        int i = 0, fmActualLength = 0;
        char cc;
        while ((i < omLength) && (fmActualLength <= MAXIMUM_MESSAGE_LENGTH)) {
            fmBuilder.append(cc = originalMessage.charAt((i)++));
            fmActualLength += (SPECIAL_CHARACTERS.contains(cc)) ? 2: 1;
        }
        if (fmActualLength > MAXIMUM_MESSAGE_LENGTH) {
            while (fmActualLength > (MAXIMUM_MESSAGE_LENGTH - DOTS.length())) {
                cc = fmBuilder.charAt(fmBuilder.length() - 1);
                fmBuilder.deleteCharAt(fmBuilder.length() - 1);
                fmActualLength -= (SPECIAL_CHARACTERS.contains(cc)) ? 2: 1;
            }
            fmBuilder.append(DOTS);
        }
        return fmBuilder.toString();
    }
}