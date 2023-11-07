package seedu.address.logic.parser;

import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_CHARLIE;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_COURSE_DESC;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindCourseCommand;
import seedu.address.model.person.Course;
import seedu.address.model.person.CourseContainsKeywordsPredicate;

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
