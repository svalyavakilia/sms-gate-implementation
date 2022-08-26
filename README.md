# SMS gate 💬

This is my implementation of an SMS gate, which transforms messages
before they are sent to the receiver.

My program is a tradeoff between the readability and shortness
as I wanted my implementation to be very concise but still understandable.

The implementation has a 100% code coverage.
However, you might (and actually, should) add your own
test cases and make sure the program works as it is intended to.

---

### Requirements

Assuming, that every character has a length of **1**
(apart from characters
*'('*, *')'*, *'{'*, *'}'*, *'['*, *']'*, *'^'*, *'\\'*
\- they have a length of **2**):

(1) if your message is not longer than 160 symbols,
then it is directly sent as it is;

(2) if your message is longer than 160 characters,
then it should be truncated, and to the end of the message, *"..."*
is appended (message with dots added in the end should together fit
in length of 160);

(3) if we truncate the message, then the whole characters are deleted
(e.g., if our message does not fit exactly on the character *'('*,
we delete it entirely, not a half of it somehow).

---

Hope you like it.
