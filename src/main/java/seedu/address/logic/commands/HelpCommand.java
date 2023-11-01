package seedu.address.logic.commands;

import seedu.address.model.Model;

/**
 * Format full help instructions for every command for display.
 */
public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORD;
    public static final String ADD_PERSON = "Adding a person: add --name NAME [--role ROLE1, ...]  "
            + "[--contact CONTACT1, ...] [--course COURSECODE1/CLASS1-CLASS2-..., ...]";
    public static final String LIST = "Listing all persons: list";
    public static final String DELETE = "Deleting a profile: delete INDEX";
    public static final String SEARCH = "Searching for profiles: search KEYWORD";
    public static final String FAV = "Adding profiles to favourites: fav INDEX";


    public static final String SHOWING_HELP_MESSAGE = "Quick Guide: \n"
            + ADD_PERSON + "\n" + LIST + "\n" + DELETE + "\n" + SEARCH + "\n" + FAV + "\n"
            + "Refer to the User Guide for the detailed implementation.";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(SHOWING_HELP_MESSAGE, true, false);
    }
}
