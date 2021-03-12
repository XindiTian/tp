<<<<<<< HEAD:src/test/java/seedu/dicitonote/logic/parser/CommandParserTestUtil.java
package seedu.dicitonote.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import seedu.dicitonote.logic.commands.Command;
import seedu.dicitonote.logic.parser.exceptions.ParseException;
=======
package seedu.dictionote.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import seedu.dictionote.logic.commands.Command;
import seedu.dictionote.logic.parser.exceptions.ParseException;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/logic/parser/CommandParserTestUtil.java

/**
 * Contains helper methods for testing command parsers.
 */
public class CommandParserTestUtil {

    /**
     * Asserts that the parsing of {@code userInput} by {@code parser} is successful and the command created
     * equals to {@code expectedCommand}.
     */
    public static void assertParseSuccess(Parser parser, String userInput, Command expectedCommand) {
        try {
            Command command = parser.parse(userInput);
            assertEquals(expectedCommand, command);
        } catch (ParseException pe) {
            throw new IllegalArgumentException("Invalid userInput.", pe);
        }
    }

    /**
     * Asserts that the parsing of {@code userInput} by {@code parser} is unsuccessful and the error message
     * equals to {@code expectedMessage}.
     */
    public static void assertParseFailure(Parser parser, String userInput, String expectedMessage) {
        try {
            parser.parse(userInput);
            throw new AssertionError("The expected ParseException was not thrown.");
        } catch (ParseException pe) {
            assertEquals(expectedMessage, pe.getMessage());
        }
    }
}
