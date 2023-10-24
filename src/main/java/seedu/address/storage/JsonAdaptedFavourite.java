package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Favourite;

/**
 * Jackson-friendly version of {@link Favourite}.
 */
public class JsonAdaptedFavourite {

    private final boolean favourite;

    /**
     * Constructs a {@code JsonAdaptedFavourite} with the given {@code favourite}.
     */
    @JsonCreator
    public JsonAdaptedFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    /**
     * Converts a given {@code Favourite} into this class for Jackson use.
     */
    public JsonAdaptedFavourite(Favourite source) {
        favourite = source.isFavourite;
    }

    @JsonValue
    public boolean getFavourite() {
        return favourite;
    }

    /**
     * Converts this Jackson-friendly adapted favourite object into the model's {@code Favourite} object.
     * @return
     * @throws IllegalValueException if there were any data constraints violated in the adapted favourite.
     */
    public Favourite toModelType() throws IllegalValueException {
        if (!Favourite.isValidFavourite(String.valueOf(favourite))) {
            throw new IllegalValueException(Favourite.MESSAGE_CONSTRAINTS);
        }
        return new Favourite(favourite);
    }

}
