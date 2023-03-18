package seedu.recipe.model.recipe;

<<<<<<< HEAD
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.recipe.testutil.Assert.assertThrows;
=======
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import seedu.recipe.model.recipe.exceptions.DuplicateRecipeException;
import seedu.recipe.model.recipe.exceptions.RecipeNotFoundException;
import seedu.recipe.model.tag.Tag;
import static seedu.recipe.testutil.Assert.assertThrows;
import static seedu.recipe.testutil.TypicalRecipes.CACIO_E_PEPE;
import static seedu.recipe.testutil.TypicalRecipes.MASALA_DOSA;

import seedu.recipe.testutil.RecipeBuilder;
>>>>>>> upstream/mvp

public class UniqueRecipeListTest {

    private final UniqueRecipeList uniqueRecipeList = new UniqueRecipeList();

    @Test
    public void contains_nullRecipe_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueRecipeList.contains(null));
    }
<<<<<<< HEAD
//
//    @Test
//    public void contains_recipeNotInList_returnsFalse() {
//        assertFalse(uniqueRecipeList.contains(ALICE));
//    }

    @Test
    public void contains_recipeInList_returnsTrue() {
//        uniqueRecipeList.add(ALICE);
//        assertTrue(uniqueRecipeList.contains(ALICE));
=======

    @Test
    public void contains_recipeNotInList_returnsFalse() {
        assertFalse(uniqueRecipeList.contains(CACIO_E_PEPE));
    }

    @Test
    public void contains_recipeInList_returnsTrue() {
        uniqueRecipeList.add(CACIO_E_PEPE);
        assertTrue(uniqueRecipeList.contains(CACIO_E_PEPE));
>>>>>>> upstream/mvp
    }

    @Test
    public void contains_recipeWithSameIdentityFieldsInList_returnsTrue() {
<<<<<<< HEAD
//        uniqueRecipeList.add(ALICE);
//        Recipe editedAlice = new RecipeBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
//                .build();
//        assertTrue(uniqueRecipeList.contains(editedAlice));
=======
        uniqueRecipeList.add(CACIO_E_PEPE);
        Recipe editedCacioEPepe = new RecipeBuilder(CACIO_E_PEPE).build();
        editedCacioEPepe.setTags(new Tag("Fusion"));
        assertTrue(uniqueRecipeList.contains(editedCacioEPepe));
>>>>>>> upstream/mvp
    }

    @Test
    public void add_nullRecipe_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueRecipeList.add(null));
    }

    @Test
    public void add_duplicateRecipe_throwsDuplicateRecipeException() {
<<<<<<< HEAD
//        uniqueRecipeList.add(ALICE);
//        assertThrows(DuplicateRecipeException.class, () -> uniqueRecipeList.add(ALICE));
=======
        uniqueRecipeList.add(CACIO_E_PEPE);
        assertThrows(DuplicateRecipeException.class, () -> uniqueRecipeList.add(CACIO_E_PEPE));
>>>>>>> upstream/mvp
    }

    @Test
    public void setRecipe_nullTargetRecipe_throwsNullPointerException() {
<<<<<<< HEAD
//        assertThrows(NullPointerException.class, () -> uniqueRecipeList.setRecipe(null, ALICE));
=======
        assertThrows(NullPointerException.class, () -> uniqueRecipeList.setRecipe(null, CACIO_E_PEPE));
>>>>>>> upstream/mvp
    }

    @Test
    public void setRecipe_nullEditedRecipe_throwsNullPointerException() {
<<<<<<< HEAD
//        assertThrows(NullPointerException.class, () -> uniqueRecipeList.setRecipe(ALICE, null));
=======
        assertThrows(NullPointerException.class, () -> uniqueRecipeList.setRecipe(CACIO_E_PEPE, null));
>>>>>>> upstream/mvp
    }

    @Test
    public void setRecipe_targetRecipeNotInList_throwsRecipeNotFoundException() {
<<<<<<< HEAD
//        assertThrows(RecipeNotFoundException.class, () -> uniqueRecipeList.setRecipe(ALICE, ALICE));
=======
        assertThrows(RecipeNotFoundException.class, () -> uniqueRecipeList.setRecipe(CACIO_E_PEPE, CACIO_E_PEPE));
>>>>>>> upstream/mvp
    }

    @Test
    public void setRecipe_editedRecipeIsSameRecipe_success() {
<<<<<<< HEAD
//        uniqueRecipeList.add(ALICE);
//        uniqueRecipeList.setRecipe(ALICE, ALICE);
//        UniqueRecipeList expectedUniqueRecipeList = new UniqueRecipeList();
//        expectedUniqueRecipeList.add(ALICE);
//        assertEquals(expectedUniqueRecipeList, uniqueRecipeList);
=======
        uniqueRecipeList.add(CACIO_E_PEPE);
        uniqueRecipeList.setRecipe(CACIO_E_PEPE, CACIO_E_PEPE);
        UniqueRecipeList expectedUniqueRecipeList = new UniqueRecipeList();
        expectedUniqueRecipeList.add(CACIO_E_PEPE);
        assertEquals(expectedUniqueRecipeList, uniqueRecipeList);
>>>>>>> upstream/mvp
    }

    @Test
    public void setRecipe_editedRecipeHasSameIdentity_success() {
<<<<<<< HEAD
//        uniqueRecipeList.add(ALICE);
//        Recipe editedAlice = new RecipeBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
//                .build();
//        uniqueRecipeList.setRecipe(ALICE, editedAlice);
        UniqueRecipeList expectedUniqueRecipeList = new UniqueRecipeList();
//        expectedUniqueRecipeList.add(editedAlice);
=======
        uniqueRecipeList.add(CACIO_E_PEPE);
        Recipe editedCacioEPepe = new RecipeBuilder(CACIO_E_PEPE).build();
        editedCacioEPepe.setTags(new Tag("Pasta"));
        editedCacioEPepe.setIngredients(new Ingredient("3 rashes bacon"));

        uniqueRecipeList.setRecipe(CACIO_E_PEPE, editedCacioEPepe);
        UniqueRecipeList expectedUniqueRecipeList = new UniqueRecipeList();
        expectedUniqueRecipeList.add(editedCacioEPepe);
>>>>>>> upstream/mvp
        assertEquals(expectedUniqueRecipeList, uniqueRecipeList);
    }

    @Test
    public void setRecipe_editedRecipeHasDifferentIdentity_success() {
<<<<<<< HEAD
//        uniqueRecipeList.add(ALICE);
//        uniqueRecipeList.setRecipe(ALICE, BOB);
//        UniqueRecipeList expectedUniqueRecipeList = new UniqueRecipeList();
//        expectedUniqueRecipeList.add(BOB);
//        assertEquals(expectedUniqueRecipeList, uniqueRecipeList);
=======
        uniqueRecipeList.add(CACIO_E_PEPE);
        uniqueRecipeList.setRecipe(CACIO_E_PEPE, MASALA_DOSA);
        UniqueRecipeList expectedUniqueRecipeList = new UniqueRecipeList();
        expectedUniqueRecipeList.add(MASALA_DOSA);
        assertEquals(expectedUniqueRecipeList, uniqueRecipeList);
>>>>>>> upstream/mvp
    }

    @Test
    public void setRecipe_editedRecipeHasNonUniqueIdentity_throwsDuplicateRecipeException() {
<<<<<<< HEAD
//        uniqueRecipeList.add(ALICE);
//        uniqueRecipeList.add(BOB);
//        assertThrows(DuplicateRecipeException.class, () -> uniqueRecipeList.setRecipe(ALICE, BOB));
=======
        uniqueRecipeList.add(CACIO_E_PEPE);
        uniqueRecipeList.add(MASALA_DOSA);
        assertThrows(DuplicateRecipeException.class, () -> uniqueRecipeList.setRecipe(CACIO_E_PEPE, MASALA_DOSA));
>>>>>>> upstream/mvp
    }

    @Test
    public void remove_nullRecipe_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueRecipeList.remove(null));
    }

    @Test
    public void remove_recipeDoesNotExist_throwsRecipeNotFoundException() {
<<<<<<< HEAD
//        assertThrows(RecipeNotFoundException.class, () -> uniqueRecipeList.remove(ALICE));
=======
        assertThrows(RecipeNotFoundException.class, () -> uniqueRecipeList.remove(CACIO_E_PEPE));
>>>>>>> upstream/mvp
    }

    @Test
    public void remove_existingRecipe_removesRecipe() {
<<<<<<< HEAD
//        uniqueRecipeList.add(ALICE);
//        uniqueRecipeList.remove(ALICE);
//        UniqueRecipeList expectedUniqueRecipeList = new UniqueRecipeList();
//        assertEquals(expectedUniqueRecipeList, uniqueRecipeList);
=======
        uniqueRecipeList.add(CACIO_E_PEPE);
        uniqueRecipeList.remove(CACIO_E_PEPE);
        UniqueRecipeList expectedUniqueRecipeList = new UniqueRecipeList();
        assertEquals(expectedUniqueRecipeList, uniqueRecipeList);
>>>>>>> upstream/mvp
    }

    @Test
    public void setRecipes_nullUniqueRecipeList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueRecipeList.setRecipes((UniqueRecipeList) null));
    }

    @Test
    public void setRecipes_uniqueRecipeList_replacesOwnListWithProvidedUniqueRecipeList() {
<<<<<<< HEAD
//        uniqueRecipeList.add(ALICE);
//        UniqueRecipeList expectedUniqueRecipeList = new UniqueRecipeList();
//        expectedUniqueRecipeList.add(BOB);
//        uniqueRecipeList.setRecipes(expectedUniqueRecipeList);
//        assertEquals(expectedUniqueRecipeList, uniqueRecipeList);
=======
        uniqueRecipeList.add(CACIO_E_PEPE);
        UniqueRecipeList expectedUniqueRecipeList = new UniqueRecipeList();
        expectedUniqueRecipeList.add(MASALA_DOSA);
        uniqueRecipeList.setRecipes(expectedUniqueRecipeList);
        assertEquals(expectedUniqueRecipeList, uniqueRecipeList);
>>>>>>> upstream/mvp
    }

    @Test
    public void setRecipes_nullList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueRecipeList.setRecipes((List<Recipe>) null));
    }

    @Test
    public void setRecipes_list_replacesOwnListWithProvidedList() {
<<<<<<< HEAD
//        uniqueRecipeList.add(ALICE);
//        List<Recipe> recipeList = Collections.singletonList(BOB);
//        uniqueRecipeList.setRecipes(recipeList);
//        UniqueRecipeList expectedUniqueRecipeList = new UniqueRecipeList();
//        expectedUniqueRecipeList.add(BOB);
//        assertEquals(expectedUniqueRecipeList, uniqueRecipeList);
=======
        uniqueRecipeList.add(CACIO_E_PEPE);
        List<Recipe> recipeList = Collections.singletonList(MASALA_DOSA);
        uniqueRecipeList.setRecipes(recipeList);
        UniqueRecipeList expectedUniqueRecipeList = new UniqueRecipeList();
        expectedUniqueRecipeList.add(MASALA_DOSA);
        assertEquals(expectedUniqueRecipeList, uniqueRecipeList);
>>>>>>> upstream/mvp

    }

    @Test
    public void setRecipes_listWithDuplicateRecipes_throwsDuplicateRecipeException() {
<<<<<<< HEAD
//        List<Recipe> listWithDuplicateRecipes = Arrays.asList(ALICE, ALICE);
//        assertThrows(DuplicateRecipeException.class, () -> uniqueRecipeList.setRecipes(listWithDuplicateRecipes));
=======
        List<Recipe> listWithDuplicateRecipes = Arrays.asList(CACIO_E_PEPE, CACIO_E_PEPE);
        assertThrows(DuplicateRecipeException.class, () -> uniqueRecipeList.setRecipes(listWithDuplicateRecipes));
>>>>>>> upstream/mvp
    }

    @Test
    public void asUnmodifiableObservableList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, ()
            -> uniqueRecipeList.asUnmodifiableObservableList().remove(0));
    }

    @Test
    public void testIterator() {
        uniqueRecipeList.add(CACIO_E_PEPE);
        uniqueRecipeList.add(MASALA_DOSA);
        Iterator<Recipe> iterator = uniqueRecipeList.iterator();
        assertEquals(CACIO_E_PEPE, iterator.next());
        assertEquals(MASALA_DOSA, iterator.next());
    }
}
