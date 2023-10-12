package seedu.address.model.util;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
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
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(new Course("CS1101"));
        courseList.add(new Course("CS2100"));
        courseList.add(new Course("CS2106"));
        courseList.add(new Course("CS2101"));
        courseList.add(new Course("CS2103T"));
        courseList.add(new Course("CS2109S"));
        Iterator<Course> courseListIterator = courseList.iterator();

        ArrayList<Tutorial> tutorialList = new ArrayList<>();
        tutorialList.add(new Tutorial(courseList.get(0), courseList.get(0).courseName + "/T03E"));
        tutorialList.add(new Tutorial(courseList.get(1), courseList.get(1).courseName + "/B32"));
        tutorialList.add(new Tutorial(courseList.get(2), courseList.get(2).courseName + "/T04"));
        tutorialList.add(new Tutorial(courseList.get(3), courseList.get(3).courseName + "/G06"));
        tutorialList.add(new Tutorial(courseList.get(4), courseList.get(4).courseName + "/F08"));
        tutorialList.add(new Tutorial(courseList.get(5), courseList.get(5).courseName + "/T31"));
        Iterator<Tutorial> tutorialListIterator = tutorialList.iterator();

        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                getRolesSet("Student"),
                getContactSet("alexyeoh@example.com"),
                getCourseSet(courseListIterator.next()),
                getTutorialSet(tutorialListIterator.next()),
                new Address("Blk 30 Geylang Street 29, #06-40"),
                getTagSet("friends")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                getRolesSet("TA"),
                getContactSet("berniceyu@example.com"),
                getCourseSet(courseListIterator.next()),
                getTutorialSet(tutorialListIterator.next()),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                getTagSet("colleagues", "friends")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                getRolesSet("Professor"),
                getContactSet("charlotte@example.com"),
                getCourseSet(courseListIterator.next()),
                getTutorialSet(tutorialListIterator.next()),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                getTagSet("neighbours")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                getRolesSet("Student"),
                getContactSet("lidavid@example.com"),
                getCourseSet(courseListIterator.next()),
                getTutorialSet(tutorialListIterator.next()),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                getTagSet("family")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                getRolesSet("TA"),
                getContactSet("irfan@example.com"),
                getCourseSet(courseListIterator.next()),
                getTutorialSet(tutorialListIterator.next()),
                new Address("Blk 47 Tampines Street 20, #17-35"),
                getTagSet("classmates")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                getRolesSet("Professor"),
                getContactSet("royb@example.com"),
                getCourseSet(courseListIterator.next()),
                getTutorialSet(tutorialListIterator.next()),
                new Address("Blk 45 Aljunied Street 85, #11-31"),
                getTagSet("colleagues"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a role set containing the list of strings given.
     */
    public static Set<Role> getRolesSet(String... strings) {
        return Arrays.stream(strings)
                .map(Role::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a contact set containing the list of strings given.
     */
    public static Set<Contact> getContactSet(String... strings) {
        return Arrays.stream(strings)
                .map(Contact::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a course set containing the courses given.
     */
    public static Set<Course> getCourseSet(Course... courses) {
        return Arrays.stream(courses)
            .collect(Collectors.toSet());
    }

    /**
     * Returns a course set containing the courses given.
     */
    public static Set<Tutorial> getTutorialSet(Tutorial... tutorials) {
        return Arrays.stream(tutorials)
            .collect(Collectors.toSet());
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
