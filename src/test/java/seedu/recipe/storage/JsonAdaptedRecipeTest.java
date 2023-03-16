package seedu.recipe.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.recipe.storage.JsonAdaptedRecipe.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.recipe.testutil.Assert.assertThrows;
import static seedu.recipe.testutil.TypicalRecipes.BENSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.recipe.commons.exceptions.IllegalValueException;
import seedu.recipe.model.recipe.Address;
import seedu.recipe.model.recipe.Email;
import seedu.recipe.model.recipe.Ingredient;
import seedu.recipe.model.recipe.Name;

public class JsonAdaptedRecipeTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_ADDRESS = " ";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_TAG = "#friend";

    private static final String VALID_NAME = BENSON.getName().toString();
    private static final String VALID_PHONE = BENSON.getIngredient().toString();
    private static final String VALID_EMAIL = BENSON.getEmail().toString();
    private static final String VALID_ADDRESS = BENSON.getAddress().toString();
    private static final List<JsonAdaptedTag> VALID_TAGS = BENSON.getTags().stream()
            .map(JsonAdaptedTag::new)
            .collect(Collectors.toList());

//    @Test
//    public void toModelType_validRecipeDetails_returnsRecipe() throws Exception {
//        JsonAdaptedRecipe recipe = new JsonAdaptedRecipe(BENSON);
//        assertEquals(BENSON, recipe.toModelType());
//    }
//
//    @Test
//    public void toModelType_invalidName_throwsIllegalValueException() {
//        JsonAdaptedRecipe recipe =
//                new JsonAdaptedRecipe(INVALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS, VALID_TAGS);
//        String expectedMessage = Name.MESSAGE_CONSTRAINTS;
//        assertThrows(IllegalValueException.class, expectedMessage, recipe::toModelType);
//    }
//
//    @Test
//    public void toModelType_nullName_throwsIllegalValueException() {
//        JsonAdaptedRecipe recipe = new JsonAdaptedRecipe(null, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS, VALID_TAGS);
//        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
//        assertThrows(IllegalValueException.class, expectedMessage, recipe::toModelType);
//    }
//
//    @Test
//    public void toModelType_invalidPhone_throwsIllegalValueException() {
//        JsonAdaptedRecipe recipe =
//                new JsonAdaptedRecipe(VALID_NAME, INVALID_PHONE, VALID_EMAIL, VALID_ADDRESS, VALID_TAGS);
//        String expectedMessage = Ingredient.MESSAGE_CONSTRAINTS;
//        assertThrows(IllegalValueException.class, expectedMessage, recipe::toModelType);
//    }
//
//    @Test
//    public void toModelType_nullPhone_throwsIllegalValueException() {
//        JsonAdaptedRecipe recipe = new JsonAdaptedRecipe(VALID_NAME, null, VALID_EMAIL, VALID_ADDRESS, VALID_TAGS);
//        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Ingredient.class.getSimpleName());
//        assertThrows(IllegalValueException.class, expectedMessage, recipe::toModelType);
//    }
//
//    @Test
//    public void toModelType_invalidEmail_throwsIllegalValueException() {
//        JsonAdaptedRecipe recipe =
//                new JsonAdaptedRecipe(VALID_NAME, VALID_PHONE, INVALID_EMAIL, VALID_ADDRESS, VALID_TAGS);
//        String expectedMessage = Email.MESSAGE_CONSTRAINTS;
//        assertThrows(IllegalValueException.class, expectedMessage, recipe::toModelType);
//    }
//
//    @Test
//    public void toModelType_nullEmail_throwsIllegalValueException() {
//        JsonAdaptedRecipe recipe = new JsonAdaptedRecipe(VALID_NAME, VALID_PHONE, null, VALID_ADDRESS, VALID_TAGS);
//        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName());
//        assertThrows(IllegalValueException.class, expectedMessage, recipe::toModelType);
//    }
//
//    @Test
//    public void toModelType_invalidAddress_throwsIllegalValueException() {
//        JsonAdaptedRecipe recipe =
//                new JsonAdaptedRecipe(VALID_NAME, VALID_PHONE, VALID_EMAIL, INVALID_ADDRESS, VALID_TAGS);
//        String expectedMessage = Address.MESSAGE_CONSTRAINTS;
//        assertThrows(IllegalValueException.class, expectedMessage, recipe::toModelType);
//    }
//
//    @Test
//    public void toModelType_nullAddress_throwsIllegalValueException() {
//        JsonAdaptedRecipe recipe = new JsonAdaptedRecipe(VALID_NAME, VALID_PHONE, VALID_EMAIL, null, VALID_TAGS);
//        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName());
//        assertThrows(IllegalValueException.class, expectedMessage, recipe::toModelType);
//    }
//
//    @Test
//    public void toModelType_invalidTags_throwsIllegalValueException() {
//        List<JsonAdaptedTag> invalidTags = new ArrayList<>(VALID_TAGS);
//        invalidTags.add(new JsonAdaptedTag(INVALID_TAG));
//        JsonAdaptedRecipe recipe =
//                new JsonAdaptedRecipe(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS, invalidTags);
//        assertThrows(IllegalValueException.class, recipe::toModelType);
//    }

}