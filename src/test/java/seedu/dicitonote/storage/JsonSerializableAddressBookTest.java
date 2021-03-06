<<<<<<< HEAD:src/test/java/seedu/dicitonote/storage/JsonSerializableAddressBookTest.java
package seedu.dicitonote.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.dicitonote.testutil.Assert.assertThrows;
=======
package seedu.dictionote.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.dictionote.testutil.Assert.assertThrows;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/storage/JsonSerializableAddressBookTest.java

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

<<<<<<< HEAD:src/test/java/seedu/dicitonote/storage/JsonSerializableAddressBookTest.java
import seedu.dicitonote.commons.exceptions.IllegalValueException;
import seedu.dicitonote.commons.util.JsonUtil;
import seedu.dicitonote.model.AddressBook;
import seedu.dicitonote.testutil.TypicalPersons;
=======
import seedu.dictionote.commons.exceptions.IllegalValueException;
import seedu.dictionote.commons.util.JsonUtil;
import seedu.dictionote.model.AddressBook;
import seedu.dictionote.testutil.TypicalContacts;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/storage/JsonSerializableAddressBookTest.java

public class JsonSerializableAddressBookTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializableAddressBookTest");
    private static final Path TYPICAL_PERSONS_FILE = TEST_DATA_FOLDER.resolve("typicalPersonsAddressBook.json");
    private static final Path INVALID_PERSON_FILE = TEST_DATA_FOLDER.resolve("invalidPersonAddressBook.json");
    private static final Path DUPLICATE_PERSON_FILE = TEST_DATA_FOLDER.resolve("duplicatePersonAddressBook.json");

    @Test
    public void toModelType_typicalPersonsFile_success() throws Exception {
        JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(TYPICAL_PERSONS_FILE,
                JsonSerializableAddressBook.class).get();
        AddressBook addressBookFromFile = dataFromFile.toModelType();
        AddressBook typicalPersonsAddressBook = TypicalContacts.getTypicalAddressBook();
        assertEquals(addressBookFromFile, typicalPersonsAddressBook);
    }

    @Test
    public void toModelType_invalidPersonFile_throwsIllegalValueException() throws Exception {
        JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(INVALID_PERSON_FILE,
                JsonSerializableAddressBook.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }

    @Test
    public void toModelType_duplicatePersons_throwsIllegalValueException() throws Exception {
        JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(DUPLICATE_PERSON_FILE,
                JsonSerializableAddressBook.class).get();
        assertThrows(IllegalValueException.class, JsonSerializableAddressBook.MESSAGE_DUPLICATE_PERSON,
                dataFromFile::toModelType);
    }

}
