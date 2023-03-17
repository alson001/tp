package seedu.recipe.model.recipe;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.recipe.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.recipe.model.tag.Tag;
import seedu.recipe.testutil.RecipeBuilder;

import java.util.Set;

import static seedu.recipe.testutil.TypicalRecipes.BLUEBERRY_PANCAKES;
import static seedu.recipe.testutil.TypicalRecipes.CACIO_E_PEPE;
import static seedu.recipe.testutil.TypicalRecipes.FISH_AND_CHIPS;
import static seedu.recipe.testutil.TypicalRecipes.GRILLED_CHEESE;
import static seedu.recipe.testutil.TypicalRecipes.MASALA_DOSA;

public class RecipeTest {
    // Varying fields
    private static final Recipe FISH_AND_CHIPS_DIFF_PORTION = new RecipeBuilder(
            FISH_AND_CHIPS.getName(), MASALA_DOSA.getPortion(),
            FISH_AND_CHIPS.getDuration(), FISH_AND_CHIPS.getTags(),
            FISH_AND_CHIPS.getIngredients(), FISH_AND_CHIPS.getSteps()).build();

    private static final Recipe FISH_AND_CHIPS_DIFF_DURATION = new RecipeBuilder(
            FISH_AND_CHIPS.getName(), FISH_AND_CHIPS.getPortion(),
            BLUEBERRY_PANCAKES.getDuration(), FISH_AND_CHIPS.getTags(),
            FISH_AND_CHIPS.getIngredients(), FISH_AND_CHIPS.getSteps()).build();

    private static final Recipe FISH_AND_CHIPS_DIFF_TAGS = new RecipeBuilder(
            FISH_AND_CHIPS.getName(), FISH_AND_CHIPS.getPortion(),
            FISH_AND_CHIPS.getDuration(), Set.of(new Tag("fake tag")),
            FISH_AND_CHIPS.getIngredients(), FISH_AND_CHIPS.getSteps()).build();

    private static final Recipe FISH_AND_CHIPS_DIFF_INGREDIENTS = new RecipeBuilder(
            FISH_AND_CHIPS.getName(), FISH_AND_CHIPS.getPortion(),
            FISH_AND_CHIPS.getDuration(), FISH_AND_CHIPS.getTags(),
            MASALA_DOSA.getIngredients(), FISH_AND_CHIPS.getSteps()).build();

    private static final Recipe FISH_AND_CHIPS_DIFF_STEPS = new RecipeBuilder(
            FISH_AND_CHIPS.getName(), FISH_AND_CHIPS.getPortion(),
            FISH_AND_CHIPS.getDuration(), FISH_AND_CHIPS.getTags(),
            FISH_AND_CHIPS.getIngredients(), MASALA_DOSA.getSteps()).build();

    //Name variations
    private static final Recipe DOSA_COPY_DIFF_NAME = new RecipeBuilder(
            new Name("fake dosa"), MASALA_DOSA.getPortion(),
            MASALA_DOSA.getDuration(), MASALA_DOSA.getTags(),
            MASALA_DOSA.getIngredients(), MASALA_DOSA.getSteps()).build();

    private static final Recipe GRILLED_CHEESE_DIFF_CASE = new RecipeBuilder(
            new Name("pan-fried camembert sandwich"), GRILLED_CHEESE.getPortion(),
            GRILLED_CHEESE.getDuration(), GRILLED_CHEESE.getTags(),
            GRILLED_CHEESE.getIngredients(), GRILLED_CHEESE.getSteps()).build();

    private static final Recipe CACIO_TRAILING_SPACE = new RecipeBuilder(
            new Name("Cacio e Pepe "), CACIO_E_PEPE.getPortion(),
            CACIO_E_PEPE.getDuration(), CACIO_E_PEPE.getTags(),
            CACIO_E_PEPE.getIngredients(), CACIO_E_PEPE.getSteps()).build();

    //Deep copying
    private static final Recipe CACIO_DEEP_COPY = new RecipeBuilder(
            CACIO_E_PEPE.getName(), CACIO_E_PEPE.getPortion(),
            CACIO_E_PEPE.getDuration(), CACIO_E_PEPE.getTags(),
            CACIO_E_PEPE.getIngredients(), CACIO_E_PEPE.getSteps()).build();

    /* Possibly invalid test case
    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Recipe recipe = new RecipeBuilder().build();
        assertThrows(UnsupportedOperationException.class, () -> recipe.getTags().remove(0));
    }*/

    @Test
    public void isSameRecipe() {
        // same object -> returns true
        assertTrue(FISH_AND_CHIPS.isSameRecipe(FISH_AND_CHIPS));

        // null -> returns false
        assertFalse(FISH_AND_CHIPS.isSameRecipe(null));

        // same name, some other attributes different -> returns true
        assertFalse(FISH_AND_CHIPS.isSameRecipe(FISH_AND_CHIPS_DIFF_TAGS));

        // different name, all other attributes same -> returns false
        assertFalse(MASALA_DOSA.isSameRecipe(DOSA_COPY_DIFF_NAME));

        // name differs in case, all other attributes same -> returns false
        assertFalse(GRILLED_CHEESE.isSameRecipe(GRILLED_CHEESE_DIFF_CASE));

        // name has trailing spaces, all other attributes same -> returns false
        assertFalse(CACIO_E_PEPE.isSameRecipe(CACIO_TRAILING_SPACE));
    }

    @Test
    public void equals() {
        // same values -> returns true
        assertEquals(CACIO_E_PEPE, CACIO_DEEP_COPY);

        // same object -> returns true
        assertEquals(BLUEBERRY_PANCAKES, BLUEBERRY_PANCAKES);

        // null -> returns false
        assertNotEquals(MASALA_DOSA, null);

        // different type -> returns false
        assertNotEquals(FISH_AND_CHIPS, 2);

        // different recipe -> returns false
        assertNotEquals(MASALA_DOSA, FISH_AND_CHIPS);

        // different name -> returns false
        assertNotEquals(MASALA_DOSA, DOSA_COPY_DIFF_NAME);

        // different portion -> returns false
        assertNotEquals(FISH_AND_CHIPS, FISH_AND_CHIPS_DIFF_PORTION);

        // different duration -> returns false
        assertNotEquals(FISH_AND_CHIPS, FISH_AND_CHIPS_DIFF_DURATION);

        // different tags -> returns false
        assertNotEquals(FISH_AND_CHIPS, FISH_AND_CHIPS_DIFF_TAGS);

        // different ingredients -> returns false
        assertNotEquals(FISH_AND_CHIPS, FISH_AND_CHIPS_DIFF_INGREDIENTS);

        // different steps -> returns false
        assertNotEquals(FISH_AND_CHIPS, FISH_AND_CHIPS_DIFF_STEPS);
    }
}
