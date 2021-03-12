<<<<<<< HEAD:src/test/java/seedu/dicitonote/model/person/AddressTest.java
package seedu.dicitonote.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.dicitonote.testutil.Assert.assertThrows;
=======
package seedu.dictionote.model.contact;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.dictionote.testutil.Assert.assertThrows;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/model/contact/AddressTest.java

import org.junit.jupiter.api.Test;

public class AddressTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Address(null));
    }

    @Test
    public void constructor_invalidAddress_throwsIllegalArgumentException() {
        String invalidAddress = "";
        assertThrows(IllegalArgumentException.class, () -> new Address(invalidAddress));
    }

    @Test
    public void isValidAddress() {
<<<<<<< HEAD:src/test/java/seedu/dicitonote/model/person/AddressTest.java
        // null dicitonote
=======
        // null dictionote
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/model/contact/AddressTest.java
        assertThrows(NullPointerException.class, () -> Address.isValidAddress(null));

        // invalid addresses
        assertFalse(Address.isValidAddress("")); // empty string
        assertFalse(Address.isValidAddress(" ")); // spaces only

        // valid addresses
        assertTrue(Address.isValidAddress("Blk 456, Den Road, #01-355"));
        assertTrue(Address.isValidAddress("-")); // one character
<<<<<<< HEAD:src/test/java/seedu/dicitonote/model/person/AddressTest.java
        assertTrue(Address.isValidAddress("Leng Inc; 1234 Market St; San Francisco CA 2349879; USA")); // long dicitonote
=======
        // long dictionote
        assertTrue(Address.isValidAddress("Leng Inc; 1234 Market St; San Francisco CA 2349879; USA"));

>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/model/contact/AddressTest.java
    }
}
