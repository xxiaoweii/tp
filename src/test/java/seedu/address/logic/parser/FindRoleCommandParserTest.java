package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.*;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindRoleCommand;
import seedu.address.model.person.Name;
import seedu.address.model.person.Role;
import seedu.address.model.person.RoleContainsKeywordsPredicate;

public class FindRoleCommandParserTest {

    private FindRoleCommandParser parser = new FindRoleCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindRoleCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindRoleCommand() {
        // no leading and trailing whitespaces
        FindRoleCommand expectedFindRoleCommand =
                new FindRoleCommand(new RoleContainsKeywordsPredicate(Arrays.asList("TA")));
        assertParseSuccess(parser, "TA", expectedFindRoleCommand);

    }

    @Test
    public void parse_invalidValue_failure() {
        // invalid role
        assertParseFailure(parser, NAME_DESC_CHARLIE + INVALID_ROLE_DESC, Role.MESSAGE_CONSTRAINTS);
    }

}
