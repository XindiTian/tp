<<<<<<< HEAD:src/test/java/seedu/dicitonote/testutil/AddressBookBuilder.java
package seedu.dicitonote.testutil;

import seedu.dicitonote.model.AddressBook;
import seedu.dicitonote.model.person.Person;
=======
package seedu.dictionote.testutil;

import seedu.dictionote.model.AddressBook;
import seedu.dictionote.model.contact.Contact;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/testutil/AddressBookBuilder.java

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withPerson("John", "Doe").build();}
 */
public class AddressBookBuilder {

    private AddressBook addressBook;

    public AddressBookBuilder() {
        addressBook = new AddressBook();
    }

    public AddressBookBuilder(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Adds a new {@code Person} to the {@code AddressBook} that we are building.
     */
    public AddressBookBuilder withContact(Contact contact) {
        addressBook.addContact(contact);
        return this;
    }

    public AddressBook build() {
        return addressBook;
    }
}
