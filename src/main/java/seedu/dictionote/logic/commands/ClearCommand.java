package seedu.dictionote.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.dictionote.model.AddressBook;
import seedu.dictionote.model.Model;

/**
 * Clears the dicitonote book.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Address book has been cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setAddressBook(new AddressBook());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
