package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.AMY;
import static seedu.address.testutil.TypicalPersons.BOB;
import static seedu.address.testutil.TypicalPersons.CHARLIE;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.testutil.PersonBuilder;

public class FavListCommandTest {
    private Model model;
    private Model expectedModel;
    private Model dummyModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        dummyModel = new ModelManager();
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new FavListCommand(), dummyModel, FavListCommand.MESSAGE_SUCCESS);
    }

    @Test
    public void execute_emptyPersonList_success() {
        Model model = new ModelManager();
        CommandResult result = new FavListCommand().execute(model);
        assertEquals(FavListCommand.MESSAGE_SUCCESS, result.getFeedbackToUser());
    }

    @Test
    public void execute_onePersonInList_success() {
        Model model = new ModelManager();
        model.addPerson(new PersonBuilder(BOB).build());
        CommandResult result = new FavListCommand().execute(model);
        String expectedOutput = "You have 1 favourited person in your list.\n";
        assertEquals(expectedOutput, result.getFeedbackToUser());
    }

    @Test
    public void execute_onePersonInList_failure() {
        Model model = new ModelManager();
        model.addPerson(new PersonBuilder(CHARLIE).build());
        CommandResult result = new FavListCommand().execute(model);
        String expectedOutput = "You have 0 favourited persons in your list.\n";
        assertEquals(expectedOutput, result.getFeedbackToUser());
    }

    @Test
    public void execute_multiplePeopleInList_success() {
        Model model = new ModelManager();
        model.addPerson(AMY);
        model.addPerson(BOB);
        CommandResult result = new FavListCommand().execute(model);
        String expectedOutput = "You have 1 favourited person in your list.\n";
        assertEquals(expectedOutput, result.getFeedbackToUser());
    }

}





