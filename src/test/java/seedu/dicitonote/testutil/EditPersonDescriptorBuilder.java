<<<<<<< HEAD:src/test/java/seedu/dicitonote/testutil/EditPersonDescriptorBuilder.java
package seedu.dicitonote.testutil;
=======
package seedu.dictionote.testutil;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/testutil/EditPersonDescriptorBuilder.java

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.dicitonote.model.person.Address;
import seedu.dicitonote.model.person.Email;
import seedu.dicitonote.model.person.Name;
import seedu.dicitonote.model.person.Person;
import seedu.dicitonote.model.person.Phone;
import seedu.dicitonote.model.tag.Tag;
import seedu.dictionote.logic.commands.EditContactCommand.EditContactDescriptor;
import seedu.dictionote.model.contact.Address;
import seedu.dictionote.model.contact.Contact;
import seedu.dictionote.model.contact.Email;
import seedu.dictionote.model.contact.Name;
import seedu.dictionote.model.contact.Phone;
import seedu.dictionote.model.tag.Tag;


/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditContactDescriptorBuilder {

    private EditContactDescriptor descriptor;

    public EditContactDescriptorBuilder() {
        descriptor = new EditContactDescriptor();
    }

    public EditContactDescriptorBuilder(EditContactDescriptor descriptor) {
        this.descriptor = new EditContactDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code contact}'s details
     */
    public EditContactDescriptorBuilder(Contact contact) {
        descriptor = new EditContactDescriptor();
        descriptor.setName(contact.getName());
        descriptor.setPhone(contact.getPhone());
        descriptor.setEmail(contact.getEmail());
        descriptor.setAddress(contact.getAddress());
        descriptor.setTags(contact.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withPhone(String phone) {
        descriptor.setPhone(new Phone(phone));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withAddress(String address) {
        descriptor.setAddress(new Address(address));
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditPersonDescriptor}
     * that we are building.
     */
    public EditPersonDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    public EditContactDescriptor build() {
        return descriptor;
    }
}
