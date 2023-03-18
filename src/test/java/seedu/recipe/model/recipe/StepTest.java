package seedu.recipe.model.recipe;

<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.recipe.logic.commands.CommandTestUtil.VALID_NAME_FISH;
import static seedu.recipe.logic.commands.CommandTestUtil.VALID_STEP_CHICKEN;
import static seedu.recipe.logic.commands.CommandTestUtil.VALID_STEP_FISH;
import static seedu.recipe.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class StepTest {
=======
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.recipe.testutil.Assert.assertThrows;


public class StepTest {
    private static final String EMPTY = "";
    private static final String WHITESPACE = " ";
    private static final String ONE_NUMBER = "123";
    private static final String ONE_DECIMAL = "123.456";
    private static final String ONE_WORD = "Prepare";
    private static final String ONE_NUMBER_CONCAT = "300ml";
    private static final String ONE_TOKEN_CONCAT_SYMBOL = "Filling:";
    private static final String SOLO_SPECIAL_CHARS = ",.";
    private static final String ABUSE_START = "z,a;";
    private static final String SPECIAL_CHAR = "Now take ^ and do that.";

    private static final String ABUSE_START_MULTI = "z,a; Test";
    private static final String STEP_NUM_TOKEN = "1.2. Heat the pan.";
    private static final String STEP_NUM_TOKEN_COLON = "1034.232: Heat the pan.";
    private static final String DECIMAL_CONCAT_MULTI = "1.5oz. of water should be sufficient.";
    private static final String MIN_LENGTH_TOKEN = "Heat, serve.";
    private static final String MULTI_TOKEN = "Heat the oil on a frying pan. When ready, crack an egg into the pan.";
    private static final String MULTI_TOKEN_PAREN = "You may wish to cover the tray (to prevent moisture from escaping)";
    private static final String MULTI_TOKEN_DECIMAL_RANGE = "Leave in the oven for 3-3.5 hours.";

>>>>>>> upstream/mvp
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Step(null));
    }

    @Test
<<<<<<< HEAD
    public void constructor_invalidStep_throwsIllegalArgumentException() {
        String invalidStep = "";
        assertThrows(IllegalArgumentException.class, () -> new Step(invalidStep));
    }

    @Test
=======
>>>>>>> upstream/mvp
    public void isValidStep() {
        // null step
        assertThrows(NullPointerException.class, () -> Step.isValidStep(null));

<<<<<<< HEAD
        // invalid step
        assertFalse(Step.isValidStep("")); // empty string
        assertFalse(Step.isValidStep(" ")); // spaces only


        // valid step
        assertTrue(Step.isValidStep("^")); // only non-alphanumeric characters
        assertTrue(Step.isValidStep("543")); // only numbers
        assertTrue(Step.isValidStep("mix")); // non-numeric
        assertTrue(Step.isValidStep("Mix")); // Caps
        assertTrue(Step.isValidStep("Add the curry powder, cumin, coriander and"
                + " cayenne pepper if using")); // non-alphanumeric characters
        assertTrue(Step.isValidStep("Add the curry powder, cumin, coriander, turmeric, "
                + "and cayenne pepper (if using) and stir to coat the chicken and onion "
                + "mixture.")); // long steps
        assertTrue(Step.isValidStep("Pour 2 litres of milk")); // numbers within alphabet
    }

    public void equals() {
        Step fish = new Step(VALID_STEP_FISH);
        Step chicken = new Step(VALID_STEP_CHICKEN);
        assertEquals(fish, new Step(VALID_NAME_FISH));
        assertNotEquals(fish, chicken);
    }

    @Test
    public void testString() {
        Step chicken = new Step(VALID_STEP_CHICKEN);
        assertEquals(VALID_STEP_CHICKEN, chicken.toString());
=======
        //invalid
        assertFalse(Step.isValidStep(EMPTY));
        assertFalse(Step.isValidStep(WHITESPACE));
        assertFalse(Step.isValidStep(ONE_NUMBER));
        assertFalse(Step.isValidStep(ONE_DECIMAL));
        assertFalse(Step.isValidStep(ONE_WORD));
        assertFalse(Step.isValidStep(ONE_NUMBER_CONCAT));
        assertFalse(Step.isValidStep(EMPTY));
        assertFalse(Step.isValidStep(EMPTY));
        assertFalse(Step.isValidStep(EMPTY));
        assertFalse(Step.isValidStep(ONE_TOKEN_CONCAT_SYMBOL));
        assertFalse(Step.isValidStep(SOLO_SPECIAL_CHARS));
        assertFalse(Step.isValidStep(ABUSE_START));
        assertFalse(Step.isValidStep(SPECIAL_CHAR));

        //valid
        assertTrue(Step.isValidStep(ABUSE_START_MULTI));
        assertTrue(Step.isValidStep(STEP_NUM_TOKEN));
        assertTrue(Step.isValidStep(STEP_NUM_TOKEN_COLON));
        assertTrue(Step.isValidStep(DECIMAL_CONCAT_MULTI));
        assertTrue(Step.isValidStep(MIN_LENGTH_TOKEN));
        assertTrue(Step.isValidStep(MULTI_TOKEN));
        assertTrue(Step.isValidStep(MULTI_TOKEN_PAREN));
        assertTrue(Step.isValidStep(MULTI_TOKEN_DECIMAL_RANGE));
    }

    @Test
    public void constructor_invalidStep_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Step(SPECIAL_CHAR));
    }

    @Test
    public void test_toString() {
        assertEquals(MULTI_TOKEN_PAREN, new Step(MULTI_TOKEN_PAREN).toString());
    }

    @Test
    public void test_equals() {
        //Referential Equality
        Step test = new Step(MULTI_TOKEN_PAREN);
        assertEquals(test, test);

        //Same name
        assertNotEquals(test, new Step(MULTI_TOKEN_PAREN));

        //Diff name
        assertNotEquals(new Step(MULTI_TOKEN_PAREN), new Step(MULTI_TOKEN_DECIMAL_RANGE));

        //Diff type
        assertNotEquals(new Step(MULTI_TOKEN), 2);

        //null
        assertNotEquals(new Step(MULTI_TOKEN), null);
    }

    @Test
    public void test_hashCode() {
        assertEquals(MULTI_TOKEN_PAREN.hashCode(), new Step(MULTI_TOKEN_PAREN).hashCode());
>>>>>>> upstream/mvp
    }
}
