package seedu.address.logic.commands;

import java.util.HashSet;
import java.util.Set;

public class CommandKeyword {

    public static final String addKeyword = "add";
    public static final String clearKeyword = "clear";
    public static final String deleteKeyword = "delete";
    public static final String editKeyword = "edit";
    public static final String exitKeyword = "exit";
    public static final String favCommand = "fav";
    public static final String unfavCommand = "unfav";
    public static final String findCommand = "search";
    public static final String findCourseCommand = "searchcourse";
    public static final String findRoleCommand = "searchrole";
    public static final String findTutorialCommand = "searchtutorial";
    public static final String listCommand = "list";
    public static final String helpCommand = "help";
    private Set<String> validCommands;

    public CommandKeyword() {
        validCommands = new HashSet<>();

        validCommands.add(addKeyword);
        validCommands.add(clearKeyword);
        validCommands.add(deleteKeyword);
        validCommands.add(editKeyword);
        validCommands.add(exitKeyword);
        validCommands.add(favCommand);
        validCommands.add(unfavCommand);
        validCommands.add(findCommand);
        validCommands.add(findCourseCommand);
        validCommands.add(findRoleCommand);
        validCommands.add(findTutorialCommand);
        validCommands.add(listCommand);
        validCommands.add(helpCommand);
    }

    public boolean isValidKeyword(String input) {
        return validCommands.contains(input);
    }

    public Set<String> getValidCommands() {
        return validCommands;
    }
}