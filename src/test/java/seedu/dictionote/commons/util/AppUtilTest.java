<<<<<<< HEAD:src/test/java/seedu/dicitonote/commons/util/AppUtilTest.java
package seedu.dicitonote.commons.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static seedu.dicitonote.testutil.Assert.assertThrows;
=======
package seedu.dictionote.commons.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static seedu.dictionote.testutil.Assert.assertThrows;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/commons/util/AppUtilTest.java

import org.junit.jupiter.api.Test;

public class AppUtilTest {

    @Test
    public void getImage_exitingImage() {
        assertNotNull(AppUtil.getImage("/images/address_book_32.png"));
    }

    @Test
    public void getImage_nullGiven_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> AppUtil.getImage(null));
    }

    @Test
    public void checkArgument_true_nothingHappens() {
        AppUtil.checkArgument(true);
        AppUtil.checkArgument(true, "");
    }

    @Test
    public void checkArgument_falseWithoutErrorMessage_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> AppUtil.checkArgument(false));
    }

    @Test
    public void checkArgument_falseWithErrorMessage_throwsIllegalArgumentException() {
        String errorMessage = "error message";
        assertThrows(IllegalArgumentException.class, errorMessage, () -> AppUtil.checkArgument(false, errorMessage));
    }
}
