package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

/**
 * Unfavourites a person identified using it's displayed index from the address book.
 */
public class UnfavouriteCommand extends Command {

    public static final String COMMAND_WORD = "unfav";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Unfavourites the person identified by the index number used in the displayed person list. \n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + " Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_UNFAVOURITE_PERSON_SUCCESS = "Unfavourited Person: %1$s";

    private final Index targetIndex;

    public UnfavouriteCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToUnfavourite = lastShownList.get(targetIndex.getZeroBased());
        model.unfavouritePerson(personToUnfavourite);
        model.setPerson(personToUnfavourite, personToUnfavourite);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(String.format(MESSAGE_UNFAVOURITE_PERSON_SUCCESS,
                Messages.format(personToUnfavourite)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof UnfavouriteCommand)) {
            return false;
        }

        UnfavouriteCommand otherUnfavouriteCommand = (UnfavouriteCommand) other;
        return targetIndex.equals(otherUnfavouriteCommand.targetIndex);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetIndex", targetIndex)
                .toString();
    }

}
