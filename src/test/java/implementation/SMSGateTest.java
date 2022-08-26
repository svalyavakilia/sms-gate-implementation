package implementation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class SmsGateTest {
    private final SmsGate smsGate = new SmsGate();

    @Test
    public void
    testFormatMessageMaximumLengthMessageWithOnlyRegularCharacters() {
        // given (arrange, having)
        final String originalMessage = "Java".repeat(40);

        // when (act, if)
        final String formattedMessage = smsGate.formatMessage(originalMessage);

        // then (assert, then)
        assertThat(formattedMessage).isEqualTo(originalMessage);
    }

    @Test
    public void testFormatMessageLongerMessageWithOnlyRegularCharacters() {
        // given (arrange, having)
        final String originalMessage = "abc".repeat(54);

        // when (act, if)
        final String formattedMessage = smsGate.formatMessage(originalMessage);

        // then (assert, then)
        assertThat(formattedMessage).isEqualTo("abc".repeat(52) + "a...");
    }

    @Test
    public void testFormatMessageMaximumLengthMessageWithSpecialCharacters() {
        // given (arrange, having)
        final String originalMessage = "<>".repeat(72) + "(){}[]^\\";

        // when (act, if)
        final String formattedMessage = smsGate.formatMessage(originalMessage);

        // then (assert, then)
        assertThat(formattedMessage).isEqualTo(originalMessage);
    }

    @Test
    public void testFormatMessageLongerMessageWithSpecialCharacters() {
        // given (arrange, having)
        final String originalMessage = "<>".repeat(76) + "&[]||||";

        // when (act, if)
        final String formattedMessage = smsGate.formatMessage(originalMessage);

        // then (assert, then)
        assertThat(formattedMessage).isEqualTo("<>".repeat(76) + "&[]...");
    }

    @Test
    public void
    testFormatMessageLongerMessageWithSpecialCharacterToBeTheLastDeleted() {
        // given (arrange, having)
        final String originalMessage = "<>".repeat(77) + "();;;";

        // when (act, if)
        final String formattedMessage = smsGate.formatMessage(originalMessage);

        // then (assert, then)
        assertThat(formattedMessage).isEqualTo("<>".repeat(77) + "(...");
    }

    @Test
    public void testFormatMessageMessageReferencesEmptyString() {
        // given (arrange, having)
        final String originalMessage = "";

        // when (act, if)
        final String formattedMessage = smsGate.formatMessage(originalMessage);

        // then (assert, then)
        assertThat(formattedMessage).isEmpty();
    }

    @Test
    public void testFormatMessageMessageReferencesNull() {
        // given (arrange, having)
        final String originalMessage = null;

        // when (act, if)
        // in this case, this part is merged with the following one

        // then (assert, then)
        assertThatThrownBy(() -> smsGate.formatMessage(originalMessage))
            .isExactlyInstanceOf(NullPointerException.class);
    }
}