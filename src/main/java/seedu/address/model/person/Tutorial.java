package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Tutorial in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidTutorialName(String)}
 */
public class Tutorial {

    public static final String MESSAGE_CONSTRAINTS = "Tutorials should be written in the format COURSECODE/TUTORIAL";
    public static final String INVALID_COURSE_MESSAGE = "Given course's name (%s) does not match Tutorial's course name (%s).";
    
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
     * @param tutorialName A valid tutorial name.
     */
    public Tutorial(Course course, String tutorialString) {
        requireNonNull(tutorialString);
        checkArgument(isValidTutorialString(tutorialString), MESSAGE_CONSTRAINTS);

        String[] tutorialStringSplit = Tutorial.splitCourseTutorialName(tutorialString);

        assert course.courseName.equals(tutorialStringSplit[0]) : 
            String.format(Tutorial.INVALID_COURSE_MESSAGE, course.courseName, tutorialStringSplit[0]);

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
     * Returns an array splitting the a tutorial string by the slash. Typically, this returns a two-element array,
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
