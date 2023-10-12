package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidRoleType(String)}
 */
public class Role {

    public enum RoleType {
        Student,
        TA,
        Professor
    }

    public static final String MESSAGE_CONSTRAINTS = "Roles must take one of the roleTypes: student, ta, or professor.";

    /*
     * The Role must be either one of Student, TA or Professor. It is optional to capitalize the first letter (or both
     * letters, in the case of TA) in the String.
     */
    public static final String VALIDATION_REGEX = "^(student|ta|professor)$";

    public final RoleType roleType;

    /**
     * Retrieves the corresponding RoleType from the String input.
     */
    public static RoleType toRoleType(String roleString) {
        checkArgument(isValidRoleType(roleString), MESSAGE_CONSTRAINTS);
        return RoleType.valueOf(roleString);
    }

    /**
     * Constructs a {@code Role}.
     *
     * @param roleString A valid role string.
     */
    public Role(String roleString) {
        requireNonNull(roleString);
        checkArgument(isValidRoleType(roleString), MESSAGE_CONSTRAINTS);
        roleType = toRoleType(roleString);
    }

    /**
     * Returns true if a given string is a valid role.
     */
    public static boolean isValidRoleType(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return roleType.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Role)) {
            return false;
        }

        Role otherRole = (Role) other;
        return roleType.equals(otherRole.roleType);
    }

    @Override
    public int hashCode() {
        return roleType.hashCode();
    }
}
