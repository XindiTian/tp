<<<<<<< HEAD:src/test/java/seedu/dicitonote/logic/commands/HelpCommandTest.java
package seedu.dicitonote.logic.commands;

import static seedu.dicitonote.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.dicitonote.logic.commands.HelpCommand.SHOWING_HELP_MESSAGE;

import org.junit.jupiter.api.Test;

import seedu.dicitonote.model.Model;
import seedu.dicitonote.model.ModelManager;
=======
package seedu.dictionote.logic.commands;

import static seedu.dictionote.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.dictionote.logic.commands.HelpCommand.SHOWING_HELP_MESSAGE;

import org.junit.jupiter.api.Test;

import seedu.dictionote.logic.commands.enums.UiAction;
import seedu.dictionote.model.Model;
import seedu.dictionote.model.ModelManager;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/logic/commands/HelpCommandTest.java

public class HelpCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @Test
    public void execute_help_success() {
        CommandResult expectedCommandResult = new CommandResult(SHOWING_HELP_MESSAGE, UiAction.HELP);
        assertCommandSuccess(new HelpCommand(), model, expectedCommandResult, expectedModel);
    }
}
