package seedu.address.logic.commands;

import seedu.address.model.Model;

/**
 * Format full help instructions for every command for display.
 */
public class HelpCommand extends Command {

    /**
     * Keyword to trigger the help command.
     */
    public static final String COMMAND_WORD = "help";

    /**
     * Usage instructions for the 'help' command.
     */
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORD;

    public static final String ADD_PERSON = "Adding a person: add --name NAME [--role ROLE1, ...]  "
            + "[--contact CONTACT1, ...] [--course COURSECODE1/CLASS1-CLASS2-..., ...]";
    public static final String LIST = "Listing all persons: list";
    public static final String DELETE = "Deleting a profile: delete INDEX";
    public static final String SEARCH_NAME = "Search by name: search NAME";
    public static final String SEARCH_ROLE = "Search by role: search ROLE";
    public static final String SEARCH_COURSE = "Search by course: search COURSE";
    public static final String SEARCH_TUTORIAL = "Search by tutorial class: search TUTORIAL";
    public static final String EDIT_DELETE = "Edit current profile by deleting current information: edit --delete";
    public static final String EDIT_ADD = "Edit current profile by adding new information: edit --add";
    public static final String EDIT_CHANGE = "Edit current profile by changing current information: edit --change";
    public static final String FAV = "Adding profiles to favourites: fav INDEX";


    public static final String SHOWING_HELP_MESSAGE = "Quick Guide: \n"
            + ADD_PERSON + "\n" + LIST + "\n" + DELETE + "\n" + SEARCH_NAME + "\n" + SEARCH_ROLE + "\n"
            + SEARCH_COURSE + "\n" + SEARCH_TUTORIAL + "\n" + EDIT_DELETE + "\n" + EDIT_ADD + "\n"
            + EDIT_CHANGE + "\n" + FAV + "\n" + "Refer to the User Guide for the detailed implementation.";

    /**
     * Executes the HelpCommand to display program usage instructions.
     *
     * @param model The model this command should operate on.
     * @return The CommandResult displaying the program usage instructions.
     */
    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(SHOWING_HELP_MESSAGE, true, false);
    }
}
