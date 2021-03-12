<<<<<<< HEAD:src/test/java/seedu/dicitonote/logic/commands/FindCommandTest.java
package seedu.dicitonote.logic.commands;
=======
package seedu.dictionote.logic.commands;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/logic/commands/FindCommandTest.java

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
<<<<<<< HEAD:src/test/java/seedu/dicitonote/logic/commands/FindCommandTest.java
import static seedu.dicitonote.commons.core.Messages.MESSAGE_PERSONS_LISTED_OVERVIEW;
import static seedu.dicitonote.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.dicitonote.testutil.TypicalPersons.CARL;
import static seedu.dicitonote.testutil.TypicalPersons.ELLE;
import static seedu.dicitonote.testutil.TypicalPersons.FIONA;
import static seedu.dicitonote.testutil.TypicalPersons.getTypicalAddressBook;
=======
import static seedu.dictionote.commons.core.Messages.MESSAGE_PERSONS_LISTED_OVERVIEW;
import static seedu.dictionote.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.dictionote.testutil.TypicalContacts.CARL;
import static seedu.dictionote.testutil.TypicalContacts.ELLE;
import static seedu.dictionote.testutil.TypicalContacts.FIONA;
import static seedu.dictionote.testutil.TypicalContacts.getTypicalAddressBook;
import static seedu.dictionote.testutil.TypicalNotes.getTypicalNoteBook;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/logic/commands/FindCommandTest.java

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

<<<<<<< HEAD:src/test/java/seedu/dicitonote/logic/commands/FindCommandTest.java
import seedu.dicitonote.model.Model;
import seedu.dicitonote.model.ModelManager;
import seedu.dicitonote.model.UserPrefs;
import seedu.dicitonote.model.person.NameContainsKeywordsPredicate;
=======
import seedu.dictionote.model.Model;
import seedu.dictionote.model.ModelManager;
import seedu.dictionote.model.UserPrefs;
import seedu.dictionote.model.contact.NameContainsKeywordsPredicate;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/logic/commands/FindCommandTest.java

/**
 * Contains integration tests (interaction with the Model) for {@code FindCommand}.
 */
public class FindCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs(), getTypicalNoteBook());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs(), getTypicalNoteBook());

    @Test
    public void equals() {
        NameContainsKeywordsPredicate firstPredicate =
                new NameContainsKeywordsPredicate(Collections.singletonList("first"));
        NameContainsKeywordsPredicate secondPredicate =
                new NameContainsKeywordsPredicate(Collections.singletonList("second"));

        FindCommand findFirstCommand = new FindCommand(firstPredicate);
        FindCommand findSecondCommand = new FindCommand(secondPredicate);

        // same object -> returns true
        assertTrue(findFirstCommand.equals(findFirstCommand));

        // same values -> returns true
        FindCommand findFirstCommandCopy = new FindCommand(firstPredicate);
        assertTrue(findFirstCommand.equals(findFirstCommandCopy));

        // different types -> returns false
        assertFalse(findFirstCommand.equals(1));

        // null -> returns false
        assertFalse(findFirstCommand.equals(null));

        // different contact -> returns false
        assertFalse(findFirstCommand.equals(findSecondCommand));
    }

    @Test
    public void execute_zeroKeywords_noPersonFound() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 0);
        NameContainsKeywordsPredicate predicate = preparePredicate(" ");
        FindCommand command = new FindCommand(predicate);
        expectedModel.updateFilteredContactList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Collections.emptyList(), model.getFilteredContactList());
    }

    @Test
    public void execute_multipleKeywords_multiplePersonsFound() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 3);
        NameContainsKeywordsPredicate predicate = preparePredicate("Kurz Elle Kunz");
        FindCommand command = new FindCommand(predicate);
        expectedModel.updateFilteredContactList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(CARL, ELLE, FIONA), model.getFilteredContactList());
    }

    /**
     * Parses {@code userInput} into a {@code NameContainsKeywordsPredicate}.
     */
    private NameContainsKeywordsPredicate preparePredicate(String userInput) {
        return new NameContainsKeywordsPredicate(Arrays.asList(userInput.split("\\s+")));
    }
}
