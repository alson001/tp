package seedu.recipe.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.recipe.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.recipe.commons.core.GuiSettings;
import seedu.recipe.logic.commands.exceptions.CommandException;
import seedu.recipe.model.ReadOnlyRecipeBook;
import seedu.recipe.model.RecipeBook;
import seedu.recipe.model.Model;
import seedu.recipe.model.ReadOnlyUserPrefs;
import seedu.recipe.model.recipe.Recipe;
import seedu.recipe.testutil.PersonBuilder;

public class AddCommandTest {

    @Test
    public void constructor_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddCommand(null));
    }

    @Test
    public void execute_personAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingPersonAdded modelStub = new ModelStubAcceptingPersonAdded();
        Recipe validRecipe = new PersonBuilder().build();

        CommandResult commandResult = new AddCommand(validRecipe).execute(modelStub);

        assertEquals(String.format(AddCommand.MESSAGE_SUCCESS, validRecipe), commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validRecipe), modelStub.personsAdded);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Recipe validRecipe = new PersonBuilder().build();
        AddCommand addCommand = new AddCommand(validRecipe);
        ModelStub modelStub = new ModelStubWithPerson(validRecipe);

        assertThrows(CommandException.class, AddCommand.MESSAGE_DUPLICATE_PERSON, () -> addCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Recipe alice = new PersonBuilder().withName("Alice").build();
        Recipe bob = new PersonBuilder().withName("Bob").build();
        AddCommand addAliceCommand = new AddCommand(alice);
        AddCommand addBobCommand = new AddCommand(bob);

        // same object -> returns true
        assertTrue(addAliceCommand.equals(addAliceCommand));

        // same values -> returns true
        AddCommand addAliceCommandCopy = new AddCommand(alice);
        assertTrue(addAliceCommand.equals(addAliceCommandCopy));

        // different types -> returns false
        assertFalse(addAliceCommand.equals(1));

        // null -> returns false
        assertFalse(addAliceCommand.equals(null));

        // different recipe -> returns false
        assertFalse(addAliceCommand.equals(addBobCommand));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getRecipeBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setRecipeBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addRecipe(Recipe recipe) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setRecipeBook(ReadOnlyRecipeBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyRecipeBook getRecipeBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasRecipe(Recipe recipe) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteRecipe(Recipe target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setRecipe(Recipe target, Recipe editedRecipe) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Recipe> getFilteredRecipeList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredRecipeList(Predicate<Recipe> predicate) {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single recipe.
     */
    private class ModelStubWithPerson extends ModelStub {
        private final Recipe recipe;

        ModelStubWithPerson(Recipe recipe) {
            requireNonNull(recipe);
            this.recipe = recipe;
        }

        @Override
        public boolean hasRecipe(Recipe recipe) {
            requireNonNull(recipe);
            return this.recipe.isSameRecipe(recipe);
        }
    }

    /**
     * A Model stub that always accept the recipe being added.
     */
    private class ModelStubAcceptingPersonAdded extends ModelStub {
        final ArrayList<Recipe> personsAdded = new ArrayList<>();

        @Override
        public boolean hasRecipe(Recipe recipe) {
            requireNonNull(recipe);
            return personsAdded.stream().anyMatch(recipe::isSameRecipe);
        }

        @Override
        public void addRecipe(Recipe recipe) {
            requireNonNull(recipe);
            personsAdded.add(recipe);
        }

        @Override
        public ReadOnlyRecipeBook getRecipeBook() {
            return new RecipeBook();
        }
    }

}
