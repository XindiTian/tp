package seedu.dictionote.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.dictionote.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.dictionote.commons.core.GuiSettings;
import seedu.dictionote.model.Model;
import seedu.dictionote.model.NoteBook;
import seedu.dictionote.model.ReadOnlyAddressBook;
import seedu.dictionote.model.ReadOnlyNoteBook;
import seedu.dictionote.model.ReadOnlyUserPrefs;
import seedu.dictionote.model.contact.Contact;
import seedu.dictionote.model.note.Note;
import seedu.dictionote.testutil.NoteBuilder;

public class AddNoteCommandTest {

    @Test
    public void constructor_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddNoteCommand(null));
    }

    @Test
    public void execute_noteAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingNoteAdded modelStub = new ModelStubAcceptingNoteAdded();
        Note validNote = new NoteBuilder().build();

        CommandResult commandResult = new AddNoteCommand(validNote).execute(modelStub);

        assertEquals(Arrays.asList(validNote), modelStub.noteAdded);
    }

    @Test
    public void equals() {
        Note note = new NoteBuilder(new Note("2103")).build();
        Note otherNote = new NoteBuilder(new Note("cs2103T")).build();
        AddNoteCommand addNoteCommand = new AddNoteCommand(note);
        AddNoteCommand addOtherNoteCommand = new AddNoteCommand(otherNote);

        // same object -> returns true
        assertTrue(addNoteCommand.equals(addNoteCommand));

        // same values -> returns true
        AddNoteCommand addNoteCommandCopy = new AddNoteCommand(note);
        assertTrue(addNoteCommand.equals(addNoteCommandCopy));

        // different types -> returns false
        assertFalse(addNoteCommand.equals(1));

        // null -> returns false
        assertFalse(addNoteCommand.equals(null));

        // different contact -> returns false
        assertFalse(addNoteCommand.equals(addOtherNoteCommand));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getAddressBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addContact(Contact contact) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBook(ReadOnlyAddressBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getNoteBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasContact(Contact contact) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteContact(Contact target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPerson(Contact target, Contact editedContact) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setNoteBookFilePath(Path path) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Contact> getFilteredContactList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredContactList(Predicate<Contact> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredNoteList(Predicate<Note> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyNoteBook getNoteBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasNote(Note note) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addNote(Note note) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteNote(Note note) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Note> getFilteredNoteList() {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single contact.
     */
    private class ModelStubWithNote extends ModelStub {
        private final Note note;

        ModelStubWithNote(Note note) {
            requireNonNull(note);
            this.note = note;
        }

        @Override
        public boolean hasNote(Note note) {
            requireNonNull(note);
            return this.note.isSameNote(note);
        }
    }

    /**
     * A Model stub that always accept the note being added.
     */
    private class ModelStubAcceptingNoteAdded extends ModelStub {
        final ArrayList<Note> noteAdded = new ArrayList<>();

        @Override
        public boolean hasNote(Note note) {
            requireNonNull(note);
            return noteAdded.stream().anyMatch(note::isSameNote);
        }

        @Override
        public void addNote(Note note) {
            requireNonNull(note);
            noteAdded.add(note);
        }

        @Override
        public ReadOnlyNoteBook getNoteBook() {
            return new NoteBook();
        }
    }

}
