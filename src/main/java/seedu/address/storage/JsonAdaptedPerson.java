package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Contact;
import seedu.address.model.person.Course;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Role;
import seedu.address.model.person.Tutorial;
import seedu.address.model.tag.Tag;

/**
 * Jackson-friendly version of {@link Person}.
 */
class JsonAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field is missing!";

    private final String name;
    private final String phone;
    private final String email;
    private final List<JsonAdaptedRole> roles = new ArrayList<>();
    private final List<JsonAdaptedContact> contacts = new ArrayList<>();
    private final List<JsonAdaptedCourse> courses = new ArrayList<>();
    private final List<JsonAdaptedTutorial> tutorials = new ArrayList<>();
    private final String address;
    private final List<JsonAdaptedTag> tags = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("name") String name, @JsonProperty("phone") String phone,
            @JsonProperty("email") String email,
            @JsonProperty("roles") List<JsonAdaptedRole> roles,
            @JsonProperty("contacts") List<JsonAdaptedContact> contacts,
            @JsonProperty("courses") List<JsonAdaptedCourse> courses,
            @JsonProperty("tutorials") List<JsonAdaptedTutorial> tutorials,
            @JsonProperty("address") String address,
            @JsonProperty("tags") List<JsonAdaptedTag> tags) {
        this.name = name;
        this.phone = phone;
        this.email = email;

        if (roles != null) {
            this.roles.addAll(roles);
        }
        if (contacts != null) {
            this.contacts.addAll(contacts);
        }
        if (courses != null) {
            this.courses.addAll(courses);
        }
        if (tutorials != null) {
            this.tutorials.addAll(tutorials);
        }

        this.address = address;
        if (tags != null) {
            this.tags.addAll(tags);
        }
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedPerson(Person source) {
        name = source.getName().fullName;
        phone = source.getPhone().value;
        email = source.getEmail().value;
        roles.addAll(source.getRoles().stream()
                .map(JsonAdaptedRole::new)
                .collect(Collectors.toList()));
        contacts.addAll(source.getContacts().stream()
                .map(JsonAdaptedContact::new)
                .collect(Collectors.toList()));
        courses.addAll(source.getCourses().stream()
                .map(JsonAdaptedCourse::new)
                .collect(Collectors.toList()));
        tutorials.addAll(source.getTutorials().stream()
                .map(JsonAdaptedTutorial::new)
                .collect(Collectors.toList()));

        address = source.getAddress().value;
        tags.addAll(source.getTags().stream()
                .map(JsonAdaptedTag::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Person toModelType() throws IllegalValueException {
        final List<Role> personRoles = new ArrayList<>();
        for (JsonAdaptedRole role : roles) {
            personRoles.add(role.toModelType());
        }

        final List<Contact> personContacts = new ArrayList<>();
        for (JsonAdaptedContact contact : contacts) {
            personContacts.add(contact.toModelType());
        }

        final List<Course> personCourses = new ArrayList<>();
        for (JsonAdaptedCourse course : courses) {
            personCourses.add(course.toModelType());
        }

        final List<Tutorial> personTutorials = new ArrayList<>();
        for (JsonAdaptedTutorial tutorial : tutorials) {
            // Get the course that is relevant to this tutorial.
            String[] courseTutorialName = Tutorial.splitCourseTutorialName(tutorial.getTutorialString());
            String courseName = courseTutorialName[0];

            Course relevantCourse = null;
            for (Course course : personCourses) {
                if (course.courseName == courseName) {
                    relevantCourse = course;
                    break;
                }
            }
            if (relevantCourse != null) {
                personTutorials.add(tutorial.toModelType(relevantCourse));
            }
        }

        final List<Tag> personTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tags) {
            personTags.add(tag.toModelType());
        }

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (phone == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        }
        if (!Phone.isValidPhone(phone)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Phone modelPhone = new Phone(phone);

        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
        }
        if (!Email.isValidEmail(email)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(email);

        final Set<Role> modelRoles = new HashSet<>(personRoles);
        final Set<Contact> modelContacts = new HashSet<>(personContacts);
        final Set<Course> modelCourses = new HashSet<>(personCourses);
        final Set<Tutorial> modelTutorials = new HashSet<>(personTutorials);

        if (address == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName()));
        }
        if (!Address.isValidAddress(address)) {
            throw new IllegalValueException(Address.MESSAGE_CONSTRAINTS);
        }
        final Address modelAddress = new Address(address);

        final Set<Tag> modelTags = new HashSet<>(personTags);
        return new Person(modelName, modelPhone, modelEmail, modelRoles, modelContacts, modelCourses, modelTutorials, modelAddress, modelTags);
    }

}
