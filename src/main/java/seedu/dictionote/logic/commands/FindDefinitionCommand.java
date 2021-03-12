package seedu.dictionote.logic.commands;


public class FindDefinitionCommand extends Command {
    public static final String COMMAND_WORD = "finddef";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds the definition of the keyword "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " alice bob charlie";
}