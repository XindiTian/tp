<<<<<<< HEAD:src/test/java/seedu/dicitonote/model/UserPrefsTest.java
package seedu.dicitonote.model;

import static seedu.dicitonote.testutil.Assert.assertThrows;
=======
package seedu.dictionote.model;

import static seedu.dictionote.testutil.Assert.assertThrows;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/model/UserPrefsTest.java

import org.junit.jupiter.api.Test;

public class UserPrefsTest {

    @Test
    public void setGuiSettings_nullGuiSettings_throwsNullPointerException() {
        UserPrefs userPref = new UserPrefs();
        assertThrows(NullPointerException.class, () -> userPref.setGuiSettings(null));
    }

    @Test
    public void setAddressBookFilePath_nullPath_throwsNullPointerException() {
        UserPrefs userPrefs = new UserPrefs();
        assertThrows(NullPointerException.class, () -> userPrefs.setAddressBookFilePath(null));
    }

}
