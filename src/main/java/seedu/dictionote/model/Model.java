package seedu.dictionote.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.dictionote.commons.core.GuiSettings;
import seedu.dictionote.model.contact.Person;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' dictionote book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' dictionote book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces dictionote book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /** Returns the AddressBook */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns true if a contact with the same identity as {@code contact} exists in the dictionote book.
     */
    boolean hasPerson(Person person);

    /**
     * Deletes the given contact.
     * The contact must exist in the dictionote book.
     */
    void deletePerson(Person target);

    /**
     * Deletes the given note.
     * The note must exist in the dictionote book.
     */
    void deleteNote(Note target);

    /**
     * Adds the given contact.
     * {@code contact} must not already exist in the dictionote book.
     */
    void addPerson(Person person);

    /**
     * Replaces the given contact {@code target} with {@code editedPerson}.
     * {@code target} must exist in the dictionote book.
     * The contact identity of {@code editedPerson} must not be the same as
     * another existing contact in the dictionote book.
     */
    void setPerson(Person target, Person editedPerson);

    /** Returns an unmodifiable view of the filtered contact list */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Updates the filter of the filtered contact list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */

    void updateFilteredContactList(Predicate<Contact> predicate);

    /**
     * Updates the filter of the filtered note list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredNoteList(Predicate<Note> predicate);

}
