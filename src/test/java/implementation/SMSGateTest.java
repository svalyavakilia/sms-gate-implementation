package implementation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SMSGateTest {
    private final SMSGate smsGate = new SMSGate();

    @Test
    public void testFormatMessageForMaximumLengthWithOnlyRegularCharacters() {
        // given (arrange, having)
        final String originalMessage = "Java".repeat(40);

        // when (act, if)
        final String formattedMessage = smsGate.formatMessage(originalMessage);

        // then (assert, then)
        assertThat(formattedMessage).isEqualTo(originalMessage);
    }
}