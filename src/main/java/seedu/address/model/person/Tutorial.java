package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.Optional;
import java.util.Set;

/**
 * Represents a Tutorial in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidTutorialString(String)}
 */
public class Tutorial {

    public static final String MESSAGE_CONSTRAINTS = "Tutorials should be written in the format COURSECODE/TUTORIAL";
    public static final String INVALID_COURSE_MESSAGE =
        "Given course's name (%s) does not match Tutorial's course name (%s).";

    // Matches a single character, any number of characters, a slash, a single character, then any number of characters.
    public static final String VALIDATION_REGEX = "[^\\s].*\\/[^\\s].*";

    // A tutorial String is in the format of courseName + COURSE_TUTORIAL_DELIMITER + tutorialName.
    // This is a constant representing that delimiter.
    public static final String COURSE_TUTORIAL_DELIMITER = "/";

    public final Course course;
    public final String tutorialName;

    /**
     * Constructs a {@code Tutorial}.
     *
     * @param course A valid course.
     * @param tutorialString A valid tutorial name.
     */
    public Tutorial(Course course, String tutorialString) {
        requireNonNull(tutorialString);
        checkArgument(isValidTutorialString(tutorialString), MESSAGE_CONSTRAINTS);

        String[] tutorialStringSplit = Tutorial.splitCourseTutorialName(tutorialString);
        String tutorialCourseName = tutorialStringSplit[0];

        assert course.courseName.equals(tutorialCourseName) : String.format(
                Tutorial.INVALID_COURSE_MESSAGE, course.courseName, tutorialStringSplit[0]
                );

        this.course = course;
        this.tutorialName = tutorialStringSplit[1];
    }

    /**
     * Returns true if a given string is a valid tutorial name.
     */
    public static boolean isValidTutorialString(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns an array splitting the tutorial string by the slash. Typically, this returns a two-element array,
     * the first element (index 0) being the course name, while the second element (index 1) is the tutorial name.
     */
    public static String[] splitCourseTutorialName(String tutorialString) {
        if (!Tutorial.isValidTutorialString(tutorialString)) {
            return new String[0];
        }

        String[] tutorialStringSplit = tutorialString.split(COURSE_TUTORIAL_DELIMITER);
        return tutorialStringSplit;
    }

    /**
     * Given a set of courses, finds the course matching the course name given by the tutoralString.
     *
     * @param courses        the Set of Courses to look through.
     * @param courseTutorialString the string representing the course and tutorial names,
     *                       separated by COURSE_TUTORIAL_DELIMITER.
     * @return               an Optional containing the Course that may (or may not) be found in the Set.
     */
    public static Optional<Course> findMatchingCourse(Set<Course> courses, String courseTutorialString) {
        String[] courseTutorialName = splitCourseTutorialName(courseTutorialString);

        if (courseTutorialName.length != 2) {
            // Invalid input courseTutorialString.
            return Optional.empty();
        }

        String relevantCourseName = courseTutorialName[0];

        Course relevantCourse = null;

        for (Course course : courses) {
            if (course.getCourseName().equals(relevantCourseName)) {
                relevantCourse = new Course(course.getCourseName());
                break;
            }
        }
        return Optional.ofNullable(relevantCourse);
    }

    /**
     * Returns the course name followed by this tutorial's name, separated by the delimiter.
     */
    public String getFullTutorialString() {
        return course.courseName + Tutorial.COURSE_TUTORIAL_DELIMITER + tutorialName;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Tutorial)) {
            return false;
        }

        Tutorial otherTutorial = (Tutorial) other;
        return tutorialName.equals(otherTutorial.tutorialName) && course.equals(otherTutorial.course);
    }

    @Override
    public int hashCode() {
        return tutorialName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return course.toString() + "/" + tutorialName;
    }

}
