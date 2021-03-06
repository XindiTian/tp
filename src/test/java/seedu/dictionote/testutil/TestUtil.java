<<<<<<< HEAD:src/test/java/seedu/dicitonote/testutil/TestUtil.java
package seedu.dicitonote.testutil;
=======
package seedu.dictionote.testutil;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/testutil/TestUtil.java

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

<<<<<<< HEAD:src/test/java/seedu/dicitonote/testutil/TestUtil.java
import seedu.dicitonote.commons.core.index.Index;
import seedu.dicitonote.model.Model;
import seedu.dicitonote.model.person.Person;
=======
import seedu.dictionote.commons.core.index.Index;
import seedu.dictionote.model.Model;
import seedu.dictionote.model.contact.Contact;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/testutil/TestUtil.java

/**
 * A utility class for test cases.
 */
public class TestUtil {

    /**
     * Folder used for temp files created during testing. Ignored by Git.
     */
    private static final Path SANDBOX_FOLDER = Paths.get("src", "test", "data", "sandbox");

    /**
     * Appends {@code fileName} to the sandbox folder path and returns the resulting path.
     * Creates the sandbox folder if it doesn't exist.
     */
    public static Path getFilePathInSandboxFolder(String fileName) {
        try {
            Files.createDirectories(SANDBOX_FOLDER);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return SANDBOX_FOLDER.resolve(fileName);
    }

    /**
     * Returns the middle index of the contact in the {@code model}'s contact list.
     */
    public static Index getMidIndex(Model model) {
        return Index.fromOneBased(model.getFilteredContactList().size() / 2);
    }

    /**
     * Returns the last index of the contact in the {@code model}'s contact list.
     */
    public static Index getLastIndex(Model model) {
        return Index.fromOneBased(model.getFilteredContactList().size());
    }

    /**
     * Returns the contact in the {@code model}'s contact list at {@code index}.
     */
    public static Contact getPerson(Model model, Index index) {
        return model.getFilteredContactList().get(index.getZeroBased());
    }
}
