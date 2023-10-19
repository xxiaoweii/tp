package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.person.Contact;
import seedu.address.model.person.Course;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Role;
import seedu.address.model.person.Tutorial;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_ROLE = "Student";
    public static final String DEFAULT_CONTACT = "amy@gmail.com";
    public static final Course DEFAULT_COURSE = new Course("CS2103T");
    public static final Tutorial DEFAULT_TUTORIAL = new Tutorial(DEFAULT_COURSE, "F08");

    private Name name;
    private Set<Role> roles;
    private Set<Contact> contacts;
    private Set<Course> courses;
    private Set<Tutorial> tutorials;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        roles = new HashSet<>();
        contacts = new HashSet<>();
        courses = new HashSet<>();
        tutorials = new HashSet<>();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        roles = new HashSet<>(personToCopy.getRoles());
        contacts = new HashSet<>(personToCopy.getContacts());
        courses = new HashSet<>(personToCopy.getCourses());
        tutorials = new HashSet<>(personToCopy.getTutorials());
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code roles} into a {@code Set<Role>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withRoles(String... roles) {
        this.roles = SampleDataUtil.getRolesSet(roles);
        return this;
    }

    /**
     * Parses the {@code contacts} into a {@code Set<Contact>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withContacts(String... contacts) {
        this.contacts = SampleDataUtil.getContactSet(contacts);
        return this;
    }

    /**
     * Parses the {@code courses} into a {@code Set<Course>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withCourses(Course... courses) {
        this.courses = SampleDataUtil.getCourseSet(courses);
        return this;
    }

    /**
     * Parses the {@code tutorials} into a {@code Set<Tutorial>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTutorials(Tutorial... tutorials) {
        this.tutorials = SampleDataUtil.getTutorialSet(tutorials);
        return this;
    }

    public Person build() {
        return new Person(name, roles, contacts, courses, tutorials);
    }

}
