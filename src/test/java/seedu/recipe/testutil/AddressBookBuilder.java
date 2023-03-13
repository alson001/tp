package seedu.recipe.testutil;

import seedu.recipe.model.RecipeBook;
import seedu.recipe.model.recipe.Recipe;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code RecipeBook ab = new AddressBookBuilder().withPerson("John", "Doe").build();}
 */
public class AddressBookBuilder {

    private RecipeBook recipeBook;

    public AddressBookBuilder() {
        recipeBook = new RecipeBook();
    }

    public AddressBookBuilder(RecipeBook recipeBook) {
        this.recipeBook = recipeBook;
    }

    /**
     * Adds a new {@code Recipe} to the {@code RecipeBook} that we are building.
     */
    public AddressBookBuilder withPerson(Recipe recipe) {
        recipeBook.addRecipe(recipe);
        return this;
    }

    public RecipeBook build() {
        return recipeBook;
    }
}
