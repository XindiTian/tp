<<<<<<< HEAD:src/test/java/seedu/dicitonote/logic/parser/DeleteCommandParserTest.java
package seedu.dicitonote.logic.parser;

import static seedu.dicitonote.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.dicitonote.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.dicitonote.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.dicitonote.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.dicitonote.logic.commands.DeleteCommand;
=======
package seedu.dictionote.logic.parser;

import static seedu.dictionote.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.dictionote.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.dictionote.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.dictionote.testutil.TypicalIndexes.INDEX_FIRST_CONTACT;

import org.junit.jupiter.api.Test;

import seedu.dictionote.logic.commands.DeleteContactCommand;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/logic/parser/DeleteContactCommandParserTest.java

/**
 * As we are only doing white-box testing, our test cases do not cover path variations
 * outside of the DeleteCommand code. For example, inputs "1" and "1 abc" take the
 * same path through the DeleteCommand, and therefore we test only one of them.
 * The path variation for those two cases occur inside the ParserUtil, and
 * therefore should be covered by the ParserUtilTest.
 */
public class DeleteContactCommandParserTest {

    private DeleteCommandParser parser = new DeleteCommandParser();

    @Test
    public void parse_validArgs_returnsDeleteCommand() {
        assertParseSuccess(parser, "1", new DeleteContactCommand(INDEX_FIRST_CONTACT));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                DeleteContactCommand.MESSAGE_USAGE));
    }
}
