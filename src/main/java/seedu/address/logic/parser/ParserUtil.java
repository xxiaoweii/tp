package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Contact;
import seedu.address.model.person.Course;
import seedu.address.model.person.Name;
import seedu.address.model.person.Role;
import seedu.address.model.person.Tutorial;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String role} into a {@code Role}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code role} is invalid.
     */
    public static Role parseRole(String role) throws ParseException {
        requireNonNull(role);
        String trimmedRole = role.trim();
        if (!Role.isValidRoleType(trimmedRole)) {
            throw new ParseException(Role.MESSAGE_CONSTRAINTS);
        }
        return new Role(trimmedRole);
    }

    /**
     * Parses {@code Collection<String> roles} into a {@code Set<Role>}.
     */
    public static Set<Role> parseRoles(Collection<String> roles) throws ParseException {
        requireNonNull(roles);
        final Set<Role> roleSet = new HashSet<>();
        for (String roleName : roles) {
            roleSet.add(parseRole(roleName));
        }
        return roleSet;
    }

    /**
     * Parses a {@code String contact} into a {@code Contact}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code contact} is invalid.
     */
    public static Contact parseContact(String contact) throws ParseException {
        requireNonNull(contact);
        String trimmedContact = contact.trim();
        if (!Contact.isValidContactName(trimmedContact)) {
            throw new ParseException(Contact.MESSAGE_CONSTRAINTS);
        }
        return new Contact(trimmedContact);
    }

    /**
     * Parses {@code Collection<String> contacts} into a {@code Set<Contact>}.
     */
    public static Set<Contact> parseContacts(Collection<String> contacts) throws ParseException {
        requireNonNull(contacts);
        final Set<Contact> contactSet = new HashSet<>();
        for (String contactName : contacts) {
            contactSet.add(parseContact(contactName));
        }
        return contactSet;
    }

    /**
     * Parses a {@code String course} into a {@code Course}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code course} is invalid.
     */
    public static Course parseCourse(String course) throws ParseException {
        requireNonNull(course);
        String trimmedCourse = course.trim();
        if (!Course.isValidCourseName(trimmedCourse)) {
            throw new ParseException(Course.MESSAGE_CONSTRAINTS);
        }
        return new Course(trimmedCourse);
    }

    /**
     * Parses {@code Collection<String> courses} into a {@code Set<Course>}.
     */
    public static Set<Course> parseCourses(Collection<String> courses) throws ParseException {
        requireNonNull(courses);
        final Set<Course> courseSet = new HashSet<>();
        for (String courseName : courses) {
            courseSet.add(parseCourse(courseName));
        }
        return courseSet;
    }

    /**
     * Parses a {@code String tutorial} into a {@code Tutorial}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tutorial} is invalid.
     */
    public static Tutorial parseTutorial(Set<Course> courseList, String tutorial) throws ParseException {
        requireNonNull(tutorial);
        String trimmedTutorial = tutorial.trim();
        if (!Tutorial.isValidTutorialString(trimmedTutorial)) {
            throw new ParseException(Tutorial.MESSAGE_CONSTRAINTS);
        }

        Course relevantCourse = null;
        String[] courseTutorialName = Tutorial.splitCourseTutorialName(trimmedTutorial);
        if (courseTutorialName == null || courseTutorialName.length <= 0) {
            throw new ParseException(Tutorial.MESSAGE_CONSTRAINTS);
        }

        for (Course course : courseList) {
            if (course.courseName == courseTutorialName[0]) {
                relevantCourse = course;
            }
        }
        if (relevantCourse == null) {
            String givenCoursesString = courseList.stream()
                .map((course) -> course.courseName)
                .reduce(
                        "", (current, next) -> current + next.toString() + " "
                       );
            givenCoursesString = String.format("[ %s]", givenCoursesString);
            throw new ParseException(String.format(
                        Tutorial.INVALID_COURSE_MESSAGE, courseTutorialName[0], givenCoursesString
                        ));
        }

        return new Tutorial(relevantCourse, trimmedTutorial);
    }

    /**
     * Parses {@code Collection<String> tutorials} into a {@code Set<Tutorial>}.
     */
    public static Set<Tutorial> parseTutorials(Set<Course> courseList,
            Collection<String> tutorials) throws ParseException {
        requireNonNull(tutorials);
        final Set<Tutorial> tutorialSet = new HashSet<>();
        for (String tutorialName : tutorials) {
            tutorialSet.add(parseTutorial(courseList, tutorialName));
        }
        return tutorialSet;
    }
}
