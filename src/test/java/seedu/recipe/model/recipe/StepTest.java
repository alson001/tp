package seedu.recipe.model.recipe;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.recipe.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class StepTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Step(null));
    }

    @Test
    public void constructor_invalidStep_throwsIllegalArgumentException() {
        String invalidStep = "";
        assertThrows(IllegalArgumentException.class, () -> new Step(invalidStep));
    }

    @Test
    public void isValidStep() {
        // null step
        assertThrows(NullPointerException.class, () -> Step.isValidStep(null));

        // invalid step
        assertFalse(Step.isValidStep("")); // empty string
        assertFalse(Step.isValidStep(" ")); // spaces only
        assertFalse(Step.isValidStep("^")); // only non-alphanumeric characters
        assertFalse(Step.isValidStep("543")); // only numbers


        // valid step
        assertTrue(Step.isValidStep("mix")); // non-numeric
        assertTrue(Step.isValidStep("Mix")); // Caps
        assertTrue(Step.isValidStep("Add the curry powder, cumin, coriander and"
                + " cayenne pepper (if using)")); // non-alphanumeric characters
        assertTrue(Step.isValidStep("Add the curry powder, cumin, coriander, turmeric, "
                + "and cayenne pepper (if using) and stir to coat the chicken and onion "
                + "mixture.")); // long steps
        assertTrue(Step.isValidStep("Pour 2litres of milk")); // numbers within alphabet
    }
}
