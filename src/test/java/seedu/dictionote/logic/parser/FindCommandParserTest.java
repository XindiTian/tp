<<<<<<< HEAD:src/test/java/seedu/dicitonote/logic/parser/FindCommandParserTest.java
package seedu.dicitonote.logic.parser;

import static seedu.dicitonote.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.dicitonote.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.dicitonote.logic.parser.CommandParserTestUtil.assertParseSuccess;
=======
package seedu.dictionote.logic.parser;

import static seedu.dictionote.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.dictionote.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.dictionote.logic.parser.CommandParserTestUtil.assertParseSuccess;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/logic/parser/FindCommandParserTest.java

import java.util.Arrays;

import org.junit.jupiter.api.Test;

<<<<<<< HEAD:src/test/java/seedu/dicitonote/logic/parser/FindCommandParserTest.java
import seedu.dicitonote.logic.commands.FindCommand;
import seedu.dicitonote.model.person.NameContainsKeywordsPredicate;
=======
import seedu.dictionote.logic.commands.FindCommand;
import seedu.dictionote.model.contact.NameContainsKeywordsPredicate;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/logic/parser/FindCommandParserTest.java

public class FindCommandParserTest {

    private FindCommandParser parser = new FindCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindCommand() {
        // no leading and trailing whitespaces
        FindCommand expectedFindCommand =
                new FindCommand(new NameContainsKeywordsPredicate(Arrays.asList("Alice", "Bob")));
        assertParseSuccess(parser, "Alice Bob", expectedFindCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n Alice \n \t Bob  \t", expectedFindCommand);
    }

}
