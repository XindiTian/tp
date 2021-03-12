<<<<<<< HEAD:src/test/java/seedu/dicitonote/logic/commands/ListCommandTest.java
package seedu.dicitonote.logic.commands;

import static seedu.dicitonote.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.dicitonote.logic.commands.CommandTestUtil.showPersonAtIndex;
import static seedu.dicitonote.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.dicitonote.testutil.TypicalPersons.getTypicalAddressBook;
=======
package seedu.dictionote.logic.commands;

import static seedu.dictionote.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.dictionote.logic.commands.CommandTestUtil.showContactAtIndex;
import static seedu.dictionote.testutil.TypicalContacts.getTypicalAddressBook;
import static seedu.dictionote.testutil.TypicalIndexes.INDEX_FIRST_CONTACT;
import static seedu.dictionote.testutil.TypicalNotes.getTypicalNoteBook;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/logic/commands/ListCommandTest.java

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

<<<<<<< HEAD:src/test/java/seedu/dicitonote/logic/commands/ListCommandTest.java
import seedu.dicitonote.model.Model;
import seedu.dicitonote.model.ModelManager;
import seedu.dicitonote.model.UserPrefs;
=======
import seedu.dictionote.model.Model;
import seedu.dictionote.model.ModelManager;
import seedu.dictionote.model.UserPrefs;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/logic/commands/ListCommandTest.java

/**
 * Contains integration tests (interaction with the Model) and unit tests for ListCommand.
 */
public class ListCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs(), getTypicalNoteBook());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs(), getTypicalNoteBook());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new ListCommand(), model, ListCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_listIsFiltered_showsEverything() {
        showContactAtIndex(model, INDEX_FIRST_CONTACT);
        assertCommandSuccess(new ListCommand(), model, ListCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
