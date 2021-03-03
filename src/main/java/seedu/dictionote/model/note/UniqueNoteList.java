package seedu.dictionote.model.note;

import static java.util.Objects.requireNonNull;
import static seedu.dictionote.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.dictionote.model.note.Note;
import seedu.dictionote.model.person.exceptions.DuplicatePersonException;

/**
 * A list of notes that enforces uniqueness between its elements and does not allow nulls.
 * A note is considered unique by comparing using {@code Note#isSameNote(Note)}. As such, adding and updating of
 * notes uses Note#isSameNote(Note) for equality so as to ensure that the note being added or updated is
 * unique in terms of identity in the UniqueNoteList. However, the removal of a note uses Note#equals(Object) so
 * as to ensure that the person with exactly the same fields will be removed.
 *
 * Supports a minimal set of list operations.
 *
 * @see Note#isSameNote(Note)
 */
public class UniqueNoteList implements Iterable<Note> {

    private final ObservableList<Note> internalList = FXCollections.observableArrayList();
    private final ObservableList<Note> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    /**
     * Returns true if the list contains an equivalent note as the given argument.
     */
    public boolean contains(Note toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameNote);
    }

    /**
     * Adds a note to the list.
     * The note must not already exist in the list.
     */
    public void add(Note toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicatePersonException();
        }
        internalList.add(toAdd);
    }

    /**
     * Replaces the note {@code target} in the list with {@code editedPerson}.
     * {@code target} must exist in the list.
     * The note identity of {@code editedNote} must not be the same as another existing note in the list.
     */
//    public void setPerson(Person target, Person editedPerson) {
//        requireAllNonNull(target, editedPerson);
//
//        int index = internalList.indexOf(target);
//        if (index == -1) {
//            throw new PersonNotFoundException();
//        }
//
//        if (!target.isSamePerson(editedPerson) && contains(editedPerson)) {
//            throw new DuplicatePersonException();
//        }
//
//        internalList.set(index, editedPerson);
//    }

    /**
     * Removes the equivalent person from the list.
     * The person must exist in the list.
     */
//    public void remove(Person toRemove) {
//        requireNonNull(toRemove);
//        if (!internalList.remove(toRemove)) {
//            throw new PersonNotFoundException();
//        }
//    }
//
//    public void setPersons(UniquePersonList replacement) {
//        requireNonNull(replacement);
//        internalList.setAll(replacement.internalList);
//    }

    /**
     * Replaces the contents of this list with {@code notes}.
     * {@code notes} must not contain duplicate persons.
     */
    public void setNotes(List<Note> notes) {
        requireAllNonNull(notes);
        if (!notesAreUnique(notes)) {
            throw new DuplicatePersonException();
        }

        internalList.setAll(notes);
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<Note> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<Note> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniqueNoteList // instanceof handles nulls
                && internalList.equals(((UniqueNoteList) other).internalList));
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

    /**
     * Returns true if {@code notes} contains only unique notes.
     */
    private boolean notesAreUnique(List<Note> notes) {
        for (int i = 0; i < notes.size() - 1; i++) {
            for (int j = i + 1; j < notes.size(); j++) {
                if (notes.get(i).isSameNote(notes.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
