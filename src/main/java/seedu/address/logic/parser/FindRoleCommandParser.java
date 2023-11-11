package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import seedu.address.logic.commands.FindRoleCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Role;
import seedu.address.model.person.RoleContainsKeywordsPredicate;

/**
 * Parses the FindRoleCommand
 */
public class FindRoleCommandParser implements Parser<FindRoleCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the FindRoleCommand
     * and returns a FindRoleCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindRoleCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindRoleCommand.MESSAGE_USAGE));
        }

        if (!checkValidRoles(trimmedArgs)) {
            throw new ParseException(Role.MESSAGE_CONSTRAINTS);
        }

        String[] roleKeywords = trimmedArgs.split(Role.PARSE_ROLE_DELIMITER);

        return new FindRoleCommand(new RoleContainsKeywordsPredicate(Arrays.asList(roleKeywords)));
    }

    /**
     * Returns whether the roles provided are valid roles.
     */
    private boolean checkValidRoles(String args) {
        try {
            Set<Role> roles = ParserUtil.parseRoles(Collections.singleton(args));
            return roles.size() > 0;
        } catch (ParseException e) {
            return false;
        }
    }
}
