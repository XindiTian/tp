package seedu.dictionote.logic.parser;

import static seedu.dictionote.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.dictionote.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.dictionote.logic.commands.AddContactCommand;
import seedu.dictionote.logic.commands.AddNoteCommand;
import seedu.dictionote.logic.commands.ClearCommand;
import seedu.dictionote.logic.commands.CloseCommand;
import seedu.dictionote.logic.commands.Command;
import seedu.dictionote.logic.commands.DeleteContactCommand;
import seedu.dictionote.logic.commands.DeleteNoteCommand;
import seedu.dictionote.logic.commands.EditContactCommand;
import seedu.dictionote.logic.commands.ExitCommand;
import seedu.dictionote.logic.commands.FindCommand;
import seedu.dictionote.logic.commands.HelpCommand;
import seedu.dictionote.logic.commands.ListCommand;
import seedu.dictionote.logic.commands.OpenCommand;
import seedu.dictionote.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class DictionoteParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddContactCommand.COMMAND_WORD:
            return new AddContactCommandParser().parse(arguments);

        case AddNoteCommand.COMMAND_WORD:
            return new AddNoteCommandParser().parse(arguments);

        case EditContactCommand.COMMAND_WORD:
            return new EditContactCommandParser().parse(arguments);

        case DeleteContactCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case DeleteNoteCommand.COMMAND_WORD:
            return new DeleteNoteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case OpenCommand.COMMAND_WORD:
            return new OpenCommandParser().parse(arguments);

        case CloseCommand.COMMAND_WORD:
            return new CloseCommandParser().parse(arguments);

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}