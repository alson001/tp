package seedu.recipe.model.recipe;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.recipe.logic.commands.CommandTestUtil.*;
import static seedu.recipe.testutil.Assert.assertThrows;
import static seedu.recipe.testutil.TypicalRecipes.CACIO_NAME;

import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Name(null));
    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        String invalidName = "";
        assertThrows(IllegalArgumentException.class, () -> new Name(invalidName));
    }

    @Test
    public void isValidName() {
        // null name
        assertThrows(NullPointerException.class, () -> Name.isValidName(null));

        // invalid name
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
    }
}
