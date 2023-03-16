package seedu.recipe.model.recipe;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.recipe.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class IngredientTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
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
        assertFalse(Ingredient.isValidIngredient("")); // empty string
        assertFalse(Ingredient.isValidIngredient(" ")); // spaces only
        assertFalse(Ingredient.isValidIngredient("93121534")); // numbers
        assertFalse(Ingredient.isValidIngredient("9011p041")); // numbers within alphabets

        // valid ingredient
        assertTrue(Ingredient.isValidIngredient("salt")); // non-numeric
        assertTrue(Ingredient.isValidIngredient("fish oil")); // spaces within ingredients
        assertTrue(Ingredient.isValidIngredient("Salt")); // Caps
    }
}
