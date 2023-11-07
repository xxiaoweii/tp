package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.*;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindCourseCommand;
import seedu.address.logic.commands.FindRoleCommand;
import seedu.address.model.person.Course;
import seedu.address.model.person.CourseContainsKeywordsPredicate;
import seedu.address.model.person.Role;

public class FindCourseCommandParserTest {

    private FindCourseCommandParser parser = new FindCourseCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "  ",
                String.format(Course.MESSAGE_CONSTRAINTS));
    }

    @Test
    public void parse_validArgs_returnsFindCourseCommand() {
        // no leading and trailing whitespaces
        FindCourseCommand expectedFindCourseCommand =
                new FindCourseCommand(new CourseContainsKeywordsPredicate(Arrays.asList("CS2103T")));
        assertParseSuccess(parser, "CS2103T", expectedFindCourseCommand);

    }

    @Test
    public void parse_invalidValue_failure() {
        // invalid course
        assertParseFailure(parser, NAME_DESC_CHARLIE + INVALID_COURSE_DESC, Course.MESSAGE_CONSTRAINTS);
    }

}
