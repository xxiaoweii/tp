package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Person}'s {@code Role} matches any of the keywords given.
 */
public class RoleContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public RoleContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        // Use flatMap to stream all the role types from the Set<RoleType>
        return person.getRoles().stream()
                .flatMap(role -> role.getRoleType().stream())
                .map(Enum::toString) // Convert role types to strings
                .anyMatch(roleType -> keywords.stream()
                        .anyMatch(keyword -> keyword.equalsIgnoreCase(roleType)));
    }


    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof RoleContainsKeywordsPredicate)) {
            return false;
        }

        RoleContainsKeywordsPredicate otherRoleContainsKeywordsPredicate = (RoleContainsKeywordsPredicate) other;
        return keywords.equals(otherRoleContainsKeywordsPredicate.keywords);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}
