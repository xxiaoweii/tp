package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Course;
import seedu.address.model.person.Tutorial;

/**
 * Jackson-friendly version of {@link Tutorial}.
 */
class JsonAdaptedTutorial {

    private final String courseName;
    private final String tutorialName;

    /**
     * Constructs a {@code JsonAdaptedTutorial} with the given {@code courseName} and {@code tutorialName}. Course will be linked when
     * converting to a modelType.
     */
    @JsonCreator
    public JsonAdaptedTutorial(String courseName, String tutorialName) {
        this.courseName = courseName;
        this.tutorialName = tutorialName;
    }

    /**
     * Converts a given {@code Tutorial} into this class for Jackson use. Course will be linked when converting
     * to a modelType.
     */
    public JsonAdaptedTutorial(Tutorial source) {
        courseName = source.course.courseName;
        tutorialName = source.tutorialName;
    }

    public String getCourseName() {
        return courseName;
    }

    @JsonValue
    public String getTutorialName() {
        return tutorialName;
    }

    /**
     * Converts this Jackson-friendly adapted tutorial object into the model's {@code Tutorial} object.
     * This requires a reference to an already-converted course to maintain a reference.
     *
     * @param course the course to refer to.
     * @throws IllegalValueException if there were any data constraints violated in the adapted tutorial.
     */
    public Tutorial toModelType(Course course) throws IllegalValueException {
        if (!Tutorial.isValidTutorialString(tutorialName)) {
            throw new IllegalValueException(Tutorial.MESSAGE_CONSTRAINTS);
        }
        return new Tutorial(course, tutorialName);
    }

}
