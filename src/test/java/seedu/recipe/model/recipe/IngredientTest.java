package seedu.recipe.model.recipe;

import org.junit.jupiter.api.Assertions;
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

        // valid ingredient
        Assertions.assertTrue(Ingredient.isValidIngredient("salt")); // non-numeric
        Assertions.assertTrue(Ingredient.isValidIngredient("fish oil")); // spaces within ingredients
        Assertions.assertTrue(Ingredient.isValidIngredient("Salt")); // Caps
        Assertions.assertTrue(Ingredient.isValidIngredient("1 container (15 ounces) ricotta cheese"));
    }

    @Test
    public void equals() {
        Ingredient fish = new Ingredient(VALID_INGREDIENT_FISH);
        Ingredient chicken = new Ingredient(VALID_INGREDIENT_CHICKEN);
        Assertions.assertEquals(fish, new Ingredient(VALID_INGREDIENT_FISH));
        Assertions.assertNotEquals(fish, chicken);
    }

    @Test
    public void ingredient_name_regex() {
        Assertions.assertTrue(Ingredient.isValidIngredient(VALID_INTEGER));
        Assertions.assertTrue(Ingredient.isValidIngredient(VALID_DECIMAL));
        Assertions.assertTrue(Ingredient.isValidIngredient(VALID_INTEGER_CONCAT_UNIT));
        Assertions.assertTrue(Ingredient.isValidIngredient(VALID_DECIMAL_CONCAT_UNIT));
        Assertions.assertTrue(Ingredient.isValidIngredient(VALID_ALPHA));
        Assertions.assertFalse(Ingredient.isValidIngredient(TRAILING_WHITESPACE));
        Assertions.assertFalse(Ingredient.isValidIngredient(WHITESPACE));
        Assertions.assertFalse(Ingredient.isValidIngredient(LEADING_WHITESPACE));
    }

    @Test
    public void constructor_invalidArgs() {
        assertThrows(IllegalArgumentException.class, () -> new Ingredient(TRAILING_WHITESPACE));
        assertThrows(IllegalArgumentException.class, () -> new Ingredient(WHITESPACE));
        assertThrows(IllegalArgumentException.class, () -> new Ingredient(LEADING_WHITESPACE));
    }

    @Test
    public void test_toString() {
        Ingredient chicken = new Ingredient(VALID_INGREDIENT_CHICKEN);
        Assertions.assertEquals(VALID_INGREDIENT_CHICKEN, chicken.toString());
        Assertions.assertEquals(VALID_INTEGER_CONCAT_UNIT, new Ingredient(VALID_INTEGER_CONCAT_UNIT).toString());
    }

    @Test
    public void test_equals() {
        //Referential Equality
        Ingredient test = new Ingredient(VALID_DECIMAL_CONCAT_UNIT);
        Assertions.assertEquals(test, test);

        //Same name
        Assertions.assertEquals(new Ingredient(VALID_INTEGER_CONCAT_UNIT), new Ingredient(VALID_INTEGER_CONCAT_UNIT));

        //Diff name
        Assertions.assertNotEquals(new Ingredient(VALID_INTEGER_CONCAT_UNIT), new Ingredient(VALID_DECIMAL_CONCAT_UNIT));

        //Diff type
        Assertions.assertNotEquals(new Ingredient(VALID_DECIMAL), "hello");

        //null
        Assertions.assertNotEquals(new Ingredient(VALID_DECIMAL), null);
    }

    @Test
    public void test_hashCode() {
        int expected = VALID_DECIMAL_CONCAT_UNIT.hashCode();
        Assertions.assertEquals(expected, new Ingredient(VALID_DECIMAL_CONCAT_UNIT).hashCode());
    }
}
