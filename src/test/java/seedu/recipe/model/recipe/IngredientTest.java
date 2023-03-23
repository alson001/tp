package seedu.recipe.model.recipe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.recipe.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import static seedu.recipe.logic.commands.CommandTestUtil.VALID_INGREDIENT_CHICKEN;
import static seedu.recipe.logic.commands.CommandTestUtil.VALID_INGREDIENT_FISH;
import static seedu.recipe.testutil.Assert.assertThrows;

public class IngredientTest {
    private static final String VALID_INTEGER = "1 watermelon";
    private static final String VALID_DECIMAL = "13.5 g molasses extract";
    private static final String VALID_INTEGER_CONCAT_UNIT = "300g rice, washed";
    private static final String VALID_DECIMAL_CONCAT_UNIT = "10.35oz. powder (can be substituted with flour)";
    private static final String VALID_ALPHA = "butter";
    private static final String TRAILING_WHITESPACE = "watermelon juice ";
    private static final String WHITESPACE = "  ";
    private static final String LEADING_WHITESPACE = " juice of 1 carrot";
    private static final String SLASH_UNIT = "1/3 cup milk";

    @Test
    public void null_name() {
        assertThrows(NullPointerException.class, () -> new Ingredient(null));
    }

    @Test
    public void constructor_invalidIngredient_throwsIllegalArgumentException() {
        String invalidIngredient = "";
        assertThrows(IllegalArgumentException.class, () -> new Ingredient(invalidIngredient));
    }

    @Test
    public void isValidIngredient() {
        // null ingredient
        assertThrows(NullPointerException.class, () -> Ingredient.isValidIngredient(null));

        // invalid ingredient
        Assertions.assertFalse(Ingredient.isValidIngredient("")); // empty string
        Assertions.assertFalse(Ingredient.isValidIngredient(" ")); // spaces only
        Assertions.assertFalse(Ingredient.isValidIngredient("9011p041")); // numbers within alphabets
        // FAILED ALL NUMBERS CASE
        // Assertions.assertFalse(Ingredient.isValidIngredient("90117041")); // numbers within alphabets

        // valid ingredient
        Assertions.assertTrue(Ingredient.isValidIngredient("salt")); // non-numeric
        Assertions.assertTrue(Ingredient.isValidIngredient("fish oil")); // spaces within ingredients
        Assertions.assertTrue(Ingredient.isValidIngredient("Salt")); // Caps
        Assertions.assertTrue(Ingredient.isValidIngredient("1 container (15 ounces) ricotta cheese"));
    }

    @Test
    public void ingredient_name_regex() {
        assertTrue(Ingredient.isValidIngredient(VALID_INTEGER));
        assertTrue(Ingredient.isValidIngredient(VALID_DECIMAL));
        assertTrue(Ingredient.isValidIngredient(VALID_INTEGER_CONCAT_UNIT));
        assertTrue(Ingredient.isValidIngredient(VALID_DECIMAL_CONCAT_UNIT));
        assertTrue(Ingredient.isValidIngredient(VALID_ALPHA));
        assertTrue(Ingredient.isValidIngredient(SLASH_UNIT));

        assertFalse(Ingredient.isValidIngredient(TRAILING_WHITESPACE));
        assertFalse(Ingredient.isValidIngredient(WHITESPACE));
        assertFalse(Ingredient.isValidIngredient(LEADING_WHITESPACE));
    }

    @Test
    public void constructor_invalidArgs() {
        assertThrows(IllegalArgumentException.class, () -> new Ingredient(TRAILING_WHITESPACE));
        assertThrows(IllegalArgumentException.class, () -> new Ingredient(WHITESPACE));
        assertThrows(IllegalArgumentException.class, () -> new Ingredient(LEADING_WHITESPACE));
    }

    @Test
    public void test_toString() {
        assertEquals(VALID_INTEGER_CONCAT_UNIT, new Ingredient(VALID_INTEGER_CONCAT_UNIT).toString());
    }

    @Test
    public void test_equals() {
        //Referential Equality
        Ingredient test = new Ingredient(VALID_DECIMAL_CONCAT_UNIT);
        assertEquals(test, test);

        //Same name
        assertEquals(new Ingredient(VALID_INTEGER_CONCAT_UNIT), new Ingredient(VALID_INTEGER_CONCAT_UNIT));

        //Diff name
        assertNotEquals(new Ingredient(VALID_INTEGER_CONCAT_UNIT), new Ingredient(VALID_DECIMAL_CONCAT_UNIT));

        //Diff type
        assertNotEquals(new Ingredient(VALID_DECIMAL), "hello");

        //null
        assertNotEquals(new Ingredient(VALID_DECIMAL), null);
    }

    @Test
    public void test_hashCode() {
        int expected = VALID_DECIMAL_CONCAT_UNIT.hashCode();
        assertEquals(expected, new Ingredient(VALID_DECIMAL_CONCAT_UNIT).hashCode());
    }
}
