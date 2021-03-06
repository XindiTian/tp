<<<<<<< HEAD:src/test/java/seedu/dicitonote/logic/commands/EditPersonDescriptorTest.java
package seedu.dicitonote.logic.commands;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.dicitonote.logic.commands.CommandTestUtil.DESC_AMY;
import static seedu.dicitonote.logic.commands.CommandTestUtil.DESC_BOB;
import static seedu.dicitonote.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.dicitonote.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.dicitonote.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.dicitonote.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.dicitonote.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import org.junit.jupiter.api.Test;

import seedu.dicitonote.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.dicitonote.testutil.EditPersonDescriptorBuilder;
=======
package seedu.dictionote.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static seedu.dictionote.logic.commands.CommandTestUtil.DESC_AMY;
import static seedu.dictionote.logic.commands.CommandTestUtil.DESC_BOB;
import static seedu.dictionote.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.dictionote.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.dictionote.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.dictionote.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.dictionote.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import seedu.dictionote.logic.commands.EditContactCommand.EditPersonDescriptor;
import seedu.dictionote.testutil.EditPersonDescriptorBuilder;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/logic/commands/EditContactDescriptorTest.java

public class EditContactDescriptorTest {

    @Test
    public void equals() {
        // same values -> returns true
        EditPersonDescriptor descriptorWithSameValues = new EditPersonDescriptor(DESC_AMY);
        assertTrue(DESC_AMY.equals(descriptorWithSameValues));

        // same object -> returns true
        assertTrue(DESC_AMY.equals(DESC_AMY));

        // null -> returns false
        assertFalse(DESC_AMY.equals(null));

        // different types -> returns false
        assertFalse(DESC_AMY.equals(5));

        // different values -> returns false
        assertFalse(DESC_AMY.equals(DESC_BOB));

        // different name -> returns false
        EditPersonDescriptor editedAmy = new EditPersonDescriptorBuilder(DESC_AMY).withName(VALID_NAME_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different phone -> returns false
        editedAmy = new EditPersonDescriptorBuilder(DESC_AMY).withPhone(VALID_PHONE_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different email -> returns false
        editedAmy = new EditPersonDescriptorBuilder(DESC_AMY).withEmail(VALID_EMAIL_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

<<<<<<< HEAD:src/test/java/seedu/dicitonote/logic/commands/EditPersonDescriptorTest.java
        // different dicitonote -> returns false
=======
        // different dictionote -> returns false
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/logic/commands/EditContactDescriptorTest.java
        editedAmy = new EditPersonDescriptorBuilder(DESC_AMY).withAddress(VALID_ADDRESS_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different tags -> returns false
        editedAmy = new EditPersonDescriptorBuilder(DESC_AMY).withTags(VALID_TAG_HUSBAND).build();
        assertFalse(DESC_AMY.equals(editedAmy));
    }
}
