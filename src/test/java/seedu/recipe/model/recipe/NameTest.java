package seedu.recipe.model.recipe;

import static org.junit.jupiter.api.Assertions.*;
<<<<<<< HEAD
import static seedu.recipe.logic.commands.CommandTestUtil.*;
=======
>>>>>>> upstream/mvp
import static seedu.recipe.testutil.Assert.assertThrows;
import static seedu.recipe.testutil.TypicalRecipes.CACIO_NAME;

import org.junit.jupiter.api.Test;

public class NameTest {
    private static final String EMPTY = "";
    private static final String WHITESPACE = " ";
    private static final String NON_VALID_CHAR_SOLO = "^";
    private static final String NON_VALID_CHAR = "Oven-roasted chicken*";
    private static final String NUMBER_ONLY = "7896";
    private static final String HYPHEN_ONLY = "- New Recipe";
    private static final String ONE_TOKEN_ALPHA = "lasagna";
    private static final String MULTI_TOKEN_ALPHA = "pan fried beef slices";
    private static final String SINGLE_NUMBER_LEADING = "5 minute stew";
    private static final String NUMBER_CONCAT_ALPHA = "5-minute stew";
    private static final String ALPHA_CONCAT_ALPHA = "Pan-fried steak";
    private static final String CAPITAL_LETTERS = "Beef Stroganoff";
    private static final String LONG_TOKEN = "Mozzarella Sandwich with pesto aioli and oven-roasted beef";

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Name(null));
    }

    @Test
    public void isValidName() {
        // null name
        assertThrows(NullPointerException.class, () -> Name.isValidName(null));

        // invalid name
<<<<<<< HEAD
        assertFalse(Name.isValidName("")); // empty string
        assertFalse(Name.isValidName(" ")); // spaces
        assertFalse(Name.isValidName("^")); // only non-alphanumeric characters
        assertFalse(Name.isValidName("lasagna*")); // contains non-alphanumeric characters

        // valid name
        assertTrue(Name.isValidName("curry chicken")); // alphabets only
        assertTrue(Name.isValidName("12345")); // numbers only
        assertTrue(Name.isValidName("Curry Chicken")); // with capital letters
        assertTrue(Name.isValidName("3D Dog Cake")); // alphanumeric characters
        assertTrue(Name.isValidName("Chargrilled Mackerel With Sweet And Sour Beetroot")); // long names;
        assertTrue(Name.isValidName("Cacio e Pepe"));
    }

    @Test
    public void equals() {
        Name fish = new Name(VALID_NAME_FISH);
        Name chicken = new Name(VALID_NAME_CHICKEN);
        assertEquals(fish, new Name(VALID_NAME_FISH));
        assertNotEquals(fish, chicken);
        Name cacio = new Name("Cacio e Pepe");
        assertEquals(new Name("Cacio e Pepe"), cacio);
        assertEquals(new Name("Cacio e Pepe"), CACIO_NAME);
    }

    @Test
    public void testString() {
        Name chicken = new Name(VALID_NAME_CHICKEN);
        assertEquals(VALID_NAME_CHICKEN, chicken.toString());
=======
        assertFalse(Name.isValidName(EMPTY));
        assertFalse(Name.isValidName(WHITESPACE));
        assertFalse(Name.isValidName(NON_VALID_CHAR_SOLO));
        assertFalse(Name.isValidName(NON_VALID_CHAR));
        assertFalse(Name.isValidName(NUMBER_ONLY));
        assertFalse(Name.isValidName(HYPHEN_ONLY));

        // valid name
        assertTrue(Name.isValidName(ONE_TOKEN_ALPHA));
        assertTrue(Name.isValidName(MULTI_TOKEN_ALPHA));
        assertTrue(Name.isValidName(SINGLE_NUMBER_LEADING));
        assertTrue(Name.isValidName(NUMBER_CONCAT_ALPHA));
        assertTrue(Name.isValidName(ALPHA_CONCAT_ALPHA));
        assertTrue(Name.isValidName(CAPITAL_LETTERS));
        assertTrue(Name.isValidName(LONG_TOKEN));
    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Name(EMPTY));
    }

    @Test
    public void test_toString() {
        assertEquals(LONG_TOKEN, new Name(LONG_TOKEN).toString());
    }

    @Test
    public void test_equals() {
        //Referential Equality
        Name test = new Name(LONG_TOKEN);
        assertEquals(test, test);

        //Same name
        assertEquals(new Name(LONG_TOKEN), new Name(LONG_TOKEN));

        //Diff name
        assertNotEquals(new Name(LONG_TOKEN), new Name(ONE_TOKEN_ALPHA));

        //Diff type
        assertNotEquals(new Name(LONG_TOKEN), "hello");

        //null
        assertNotEquals(new Name(LONG_TOKEN), null);
    }

    @Test
    public void test_hashCode() {
        int expected = LONG_TOKEN.hashCode();
        assertEquals(expected, new Name(LONG_TOKEN).hashCode());
>>>>>>> upstream/mvp
    }
}
