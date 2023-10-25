package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Course in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidCourseName(String)}
 */
public class Course {

    public static final String MESSAGE_CONSTRAINTS = "INVALID COURSE FORMAT!"
        + "\n COURSE CODE SHOULD BE IN THE FOLLOWING FORMAT: ";
    public static final String VALIDATION_REGEX = "^[A-Za-z]{2,3}\\d{4}[A-Za-z]?$";

    public final String courseName;

    /**
     * Constructs a {@code Course}.
     *
     * @param courseName A valid course name.
     */
    public Course(String courseName) {
        requireNonNull(courseName);
        String[] splitCourseAndTutorial = splitCourseName(courseName);
        String courseCode = splitCourseAndTutorial[0];
        checkArgument(isValidCourseName(courseCode), MESSAGE_CONSTRAINTS);
        this.courseName = courseName;
    }

    /**
     * Returns true if a given string is a valid course name.
     */
    public static boolean isValidCourseName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public String getCourseName() {
        String[] splitCourse = splitCourseName(courseName);
        return splitCourse[0];
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Course)) {
            return false;
        }

        Course otherCourse = (Course) other;
        return courseName.equals(otherCourse.courseName);
    }

    @Override
    public int hashCode() {
        return courseName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return courseName.toString();
    }

    public static String[] splitCourseName(String courseName) {
        return courseName.split("/");
    }
}
