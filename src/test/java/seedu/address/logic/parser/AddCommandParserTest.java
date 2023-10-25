package seedu.address.logic.parser;

//import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
//import static seedu.address.logic.commands.CommandTestUtil.ADDRESS_DESC_AMY;
//import static seedu.address.logic.commands.CommandTestUtil.ADDRESS_DESC_BOB;
//import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_AMY;
//import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_BOB;
//import static seedu.address.logic.commands.CommandTestUtil.INVALID_ADDRESS_DESC;
//import static seedu.address.logic.commands.CommandTestUtil.INVALID_EMAIL_DESC;
//import static seedu.address.logic.commands.CommandTestUtil.INVALID_NAME_DESC;
//import static seedu.address.logic.commands.CommandTestUtil.INVALID_PHONE_DESC;
//import static seedu.address.logic.commands.CommandTestUtil.INVALID_TAG_DESC;
//import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_AMY;
//import static seedu.address.logic.commands.CommandTestUtil.PHONE_DESC_AMY;
//import static seedu.address.logic.commands.CommandTestUtil.PHONE_DESC_BOB;
//import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_NON_EMPTY;
//import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
//import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_FRIEND;
//import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_HUSBAND;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
//import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
//import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
//import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
//import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
//import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
//import static seedu.address.logic.commands.CommandTestUtil.CONTACT_DESC_CHARLIE_EMAIL;
//import static seedu.address.logic.commands.CommandTestUtil.CONTACT_DESC_CHARLIE_EMAIL;
import static seedu.address.logic.commands.CommandTestUtil.CONTACT_DESC_CHARLIE_EMAIL;
import static seedu.address.logic.commands.CommandTestUtil.CONTACT_DESC_CHARLIE_PHONE;
import static seedu.address.logic.commands.CommandTestUtil.CONTACT_DESC_CHARLIE_TELE;
import static seedu.address.logic.commands.CommandTestUtil.COURSE_DESC_1;
import static seedu.address.logic.commands.CommandTestUtil.COURSE_DESC_2;
import static seedu.address.logic.commands.CommandTestUtil.COURSE_DESC_3;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_CHARLIE;
import static seedu.address.logic.commands.CommandTestUtil.ROLE_DESC_STUDENT;
import static seedu.address.logic.commands.CommandTestUtil.ROLE_DESC_TA;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_CONTACT_CHARLIE;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_CONTACT_CHARLIE;
import static seedu.address.logic.commands.CommandTestUtil.TUTORIAL_DESC_1;
import static seedu.address.logic.commands.CommandTestUtil.TUTORIAL_DESC_2;
import static seedu.address.logic.commands.CommandTestUtil.TUTORIAL_DESC_3;
import static seedu.address.logic.commands.CommandTestUtil.VALID_COURSE_1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_COURSE_2;
import static seedu.address.logic.commands.CommandTestUtil.VALID_COURSE_3;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_CONTACT_CHARLIE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_CHARLIE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_CONTACT_CHARLIE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ROLE_STUDENT;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ROLE_TA;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TELE_CONTACT_CHARLIE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TUTORIAL_1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TUTORIAL_2;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TUTORIAL_3;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalPersons.CHARLIE;
//import static seedu.address.testutil.TypicalPersons.AMY;
//import static seedu.address.testutil.TypicalPersons.BOB;

import org.junit.jupiter.api.Test;

//import seedu.address.logic.Messages;
import seedu.address.logic.commands.AddCommand;
//import seedu.address.model.person.Address;
//import seedu.address.model.person.Email;
//import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
//import seedu.address.model.person.Phone;
//import seedu.address.model.tag.Tag;
import seedu.address.testutil.PersonBuilder;

public class AddCommandParserTest {
    private AddCommandParser parser = new AddCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {

        //        // When only name is provided
        //        Person personWithName = new PersonBuilder().withName(VALID_NAME_CHARLIE).build();
        //        assertParseSuccess(parser, NAME_DESC_CHARLIE, new AddCommand(personWithName));
        //
        //        // Name and one role
        //        Person personWithOneRole = new PersonBuilder(CHARLIE).withRoles(VALID_ROLE_TA).build();
        //        assertParseSuccess(parser, NAME_DESC_CHARLIE + ROLE_DESC_TA,
        //                new AddCommand(personWithOneRole));
        //
        //        // Name and multiple roles
        //        Person personWithManyRoles = new PersonBuilder(CHARLIE).withRoles(VALID_ROLE_TA, VALID_ROLE_STUDENT).build();
        //        assertParseSuccess(parser, NAME_DESC_CHARLIE + ROLE_DESC_TA + ROLE_DESC_STUDENT,
        //                new AddCommand(personWithManyRoles));
        //
        //        // Name and one contact
        //        Person personWithOneContact = new PersonBuilder(CHARLIE).withContacts(VALID_PHONE_CONTACT_CHARLIE).build();
        //        assertParseSuccess(parser, NAME_DESC_CHARLIE + CONTACT_DESC_CHARLIE_PHONE,
        //                new AddCommand(personWithOneContact));
        //
        //        // Name and many contacts
        //        Person personWithManyContacts = new PersonBuilder(CHARLIE)
        //                .withContacts(VALID_EMAIL_CONTACT_CHARLIE, VALID_PHONE_CONTACT_CHARLIE).build();
        //        String userInput1 = NAME_DESC_CHARLIE + CONTACT_DESC_CHARLIE_PHONE + CONTACT_DESC_CHARLIE_EMAIL;
        //        assertParseSuccess(parser, userInput1, new AddCommand(personWithManyContacts));
        //
        //        // Name and many roles and many contacts
        //        Person manyRolesAndManyContacts = new PersonBuilder(CHARLIE)
        //                .withRoles(VALID_ROLE_TA, VALID_ROLE_STUDENT)
        //                .withContacts(VALID_EMAIL_CONTACT_CHARLIE, VALID_PHONE_CONTACT_CHARLIE, VALID_TELE_CONTACT_CHARLIE)
        //                .build();
        //        String userInput2 = NAME_DESC_CHARLIE
        //                + ROLE_DESC_TA + ROLE_DESC_STUDENT
        //                + CONTACT_DESC_CHARLIE_PHONE + CONTACT_DESC_CHARLIE_EMAIL + CONTACT_DESC_CHARLIE_TELE;
        //        assertParseSuccess(parser, userInput2, new AddCommand(manyRolesAndManyContacts));

        // Name and a course
        Person personWithOneCourse = new PersonBuilder(CHARLIE).withCourses(VALID_COURSE_1).build();
        assertParseSuccess(parser, NAME_DESC_CHARLIE + COURSE_DESC_1,
                new AddCommand(personWithOneCourse));

        //        // Name and many courses
        //        Person personWithManyCourses = new PersonBuilder(CHARLIE)
        //                .withCourses(VALID_COURSE_1, VALID_COURSE_2, VALID_COURSE_3).build();
        //        assertParseSuccess(parser, NAME_DESC_CHARLIE + COURSE_DESC_1 + COURSE_DESC_2 + COURSE_DESC_3,
        //                new AddCommand(personWithManyCourses));
        //
        //        // Name and one tutorial
        //        Person personWithOneTutorial = new PersonBuilder(CHARLIE)
        //                .withCourses(VALID_COURSE_1)
        //                .withTutorials(VALID_TUTORIAL_1).build();
        //        assertParseSuccess(parser, NAME_DESC_CHARLIE + COURSE_DESC_1 + TUTORIAL_DESC_1,
        //                new AddCommand(personWithOneTutorial));
        //
        //        // Name and many tutorials
        //        Person personWithManyTutorials = new PersonBuilder(CHARLIE)
        //                .withCourses(VALID_COURSE_1, VALID_COURSE_2, VALID_COURSE_3)
        //                .withTutorials(VALID_TUTORIAL_1, VALID_TUTORIAL_2, VALID_TUTORIAL_3).build();
        //        String userInput3 = NAME_DESC_CHARLIE
        //                + COURSE_DESC_1 + COURSE_DESC_2 + COURSE_DESC_3
        //                + TUTORIAL_DESC_1 + TUTORIAL_DESC_2 + TUTORIAL_DESC_3;
        //        assertParseSuccess(parser, userInput3,
        //                new AddCommand(personWithManyTutorials));
    }

    /*
    @Test
    public void parse_repeatedNonTagValue_failure() {
        String validExpectedPersonString = NAME_DESC_BOB + PHONE_DESC_BOB + EMAIL_DESC_BOB
                + ADDRESS_DESC_BOB + TAG_DESC_FRIEND;

        // multiple names
        assertParseFailure(parser, NAME_DESC_AMY + validExpectedPersonString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_NAME));

        // multiple phones
        assertParseFailure(parser, PHONE_DESC_AMY + validExpectedPersonString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_PHONE));

        // multiple emails
        assertParseFailure(parser, EMAIL_DESC_AMY + validExpectedPersonString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_EMAIL));

        // multiple addresses
        assertParseFailure(parser, ADDRESS_DESC_AMY + validExpectedPersonString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_ADDRESS));

        // multiple fields repeated
        assertParseFailure(parser,
                validExpectedPersonString + PHONE_DESC_AMY + EMAIL_DESC_AMY + NAME_DESC_AMY + ADDRESS_DESC_AMY
                        + validExpectedPersonString,
                Messages.getErrorMessageForDuplicatePrefixes(
                      PREFIX_NAME, PREFIX_ADDRESS, PREFIX_EMAIL, PREFIX_PHONE));

        // invalid value followed by valid value

        // invalid name
        assertParseFailure(parser, INVALID_NAME_DESC + validExpectedPersonString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_NAME));

        // invalid email
        assertParseFailure(parser, INVALID_EMAIL_DESC + validExpectedPersonString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_EMAIL));

        // invalid phone
        assertParseFailure(parser, INVALID_PHONE_DESC + validExpectedPersonString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_PHONE));

        // invalid address
        assertParseFailure(parser, INVALID_ADDRESS_DESC + validExpectedPersonString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_ADDRESS));

        // valid value followed by invalid value

        // invalid name
        assertParseFailure(parser, validExpectedPersonString + INVALID_NAME_DESC,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_NAME));

        // invalid email
        assertParseFailure(parser, validExpectedPersonString + INVALID_EMAIL_DESC,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_EMAIL));

        // invalid phone
        assertParseFailure(parser, validExpectedPersonString + INVALID_PHONE_DESC,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_PHONE));

        // invalid address
        assertParseFailure(parser, validExpectedPersonString + INVALID_ADDRESS_DESC,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_ADDRESS));
    }

    @Test
    public void parse_optionalFieldsMissing_success() {
        // zero tags
        Person expectedPerson = new PersonBuilder(AMY).withTags().build();
        assertParseSuccess(parser, NAME_DESC_AMY + PHONE_DESC_AMY + EMAIL_DESC_AMY + ADDRESS_DESC_AMY,
                new AddCommand(expectedPerson));
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE);

        // missing name prefix
        assertParseFailure(parser, VALID_NAME_BOB + PHONE_DESC_BOB + EMAIL_DESC_BOB + ADDRESS_DESC_BOB,
                expectedMessage);

        // missing phone prefix
        assertParseFailure(parser, NAME_DESC_BOB + VALID_PHONE_BOB + EMAIL_DESC_BOB + ADDRESS_DESC_BOB,
                expectedMessage);

        // missing email prefix
        assertParseFailure(parser, NAME_DESC_BOB + PHONE_DESC_BOB + VALID_EMAIL_BOB + ADDRESS_DESC_BOB,
                expectedMessage);

        // missing address prefix
        assertParseFailure(parser, NAME_DESC_BOB + PHONE_DESC_BOB + EMAIL_DESC_BOB + VALID_ADDRESS_BOB,
                expectedMessage);

        // all prefixes missing
        assertParseFailure(parser, VALID_NAME_BOB + VALID_PHONE_BOB + VALID_EMAIL_BOB + VALID_ADDRESS_BOB,
                expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        // invalid name
        assertParseFailure(parser, INVALID_NAME_DESC + PHONE_DESC_BOB + EMAIL_DESC_BOB + ADDRESS_DESC_BOB
                + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, Name.MESSAGE_CONSTRAINTS);

        // invalid phone
        assertParseFailure(parser, NAME_DESC_BOB + INVALID_PHONE_DESC + EMAIL_DESC_BOB + ADDRESS_DESC_BOB
                + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, Phone.MESSAGE_CONSTRAINTS);

        // invalid email
        assertParseFailure(parser, NAME_DESC_BOB + PHONE_DESC_BOB + INVALID_EMAIL_DESC + ADDRESS_DESC_BOB
                + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, Email.MESSAGE_CONSTRAINTS);

        // invalid address
        assertParseFailure(parser, NAME_DESC_BOB + PHONE_DESC_BOB + EMAIL_DESC_BOB + INVALID_ADDRESS_DESC
                + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, Address.MESSAGE_CONSTRAINTS);

        // invalid tag
        assertParseFailure(parser, NAME_DESC_BOB + PHONE_DESC_BOB + EMAIL_DESC_BOB + ADDRESS_DESC_BOB
                + INVALID_TAG_DESC + VALID_TAG_FRIEND, Tag.MESSAGE_CONSTRAINTS);

        // two invalid values, only first invalid value reported
        assertParseFailure(parser, INVALID_NAME_DESC + PHONE_DESC_BOB + EMAIL_DESC_BOB + INVALID_ADDRESS_DESC,
                Name.MESSAGE_CONSTRAINTS);

        // non-empty preamble
        assertParseFailure(parser, PREAMBLE_NON_EMPTY + NAME_DESC_BOB + PHONE_DESC_BOB + EMAIL_DESC_BOB
                + ADDRESS_DESC_BOB + TAG_DESC_HUSBAND + TAG_DESC_FRIEND,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
    }
     */
}
