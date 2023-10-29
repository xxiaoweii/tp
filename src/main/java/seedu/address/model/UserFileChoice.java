package seedu.address.model;


/**
 * Represents the user's choice for file storage.
 */
public enum UserFileChoice {
    USE_EXISTING_FILE("Use existing file"),
    CREATE_NEW_FILE("Create new file");

    private final String choice;

    UserFileChoice(String choice) {
        this.choice = choice;
    }
    @Override
    public String toString() {
        return choice;
    }
}
