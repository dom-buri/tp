package seedu.address.model.event;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Event's description in EventWise.
 * Guarantees: immutable; is valid as declared in {@link #isValidDesc(String)}
 */
public class Description {

    public static final String MESSAGE_CONSTRAINTS =
            "Event description should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String eventDesc;

    /**
     * Constructs a {@code Description}.
     *
     * @param desc A valid description.
     */
    public Description(String desc) {
        requireNonNull(desc);
        checkArgument(isValidDesc(desc), MESSAGE_CONSTRAINTS);
        eventDesc = desc;
    }

    /**
     * Returns true if a given string is a valid description.
     */
    public static boolean isValidDesc(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return eventDesc;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Description)) {
            return false;
        }

        Description otherName = (Description) other;
        return eventDesc.equals(otherName.eventDesc);
    }

    @Override
    public int hashCode() {
        return eventDesc.hashCode();
    }

}
