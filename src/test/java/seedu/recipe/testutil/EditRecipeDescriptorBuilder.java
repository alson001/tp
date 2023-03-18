package seedu.recipe.testutil;

import seedu.recipe.logic.commands.EditCommand;
import seedu.recipe.logic.commands.EditCommand.EditRecipeDescriptor;
<<<<<<< HEAD
import seedu.recipe.model.recipe.Ingredient;
=======
>>>>>>> upstream/mvp
import seedu.recipe.model.recipe.Name;
import seedu.recipe.model.recipe.Recipe;
import seedu.recipe.model.recipe.RecipeDuration;
import seedu.recipe.model.recipe.RecipePortion;
import seedu.recipe.model.recipe.Step;
import seedu.recipe.model.tag.Tag;

<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> upstream/mvp
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A utility class to help with building EditRecipeDescriptor objects.
 */
public class EditRecipeDescriptorBuilder {

    private EditCommand.EditRecipeDescriptor descriptor;

    public EditRecipeDescriptorBuilder() {
        descriptor = new EditCommand.EditRecipeDescriptor();
    }

    public EditRecipeDescriptorBuilder(EditCommand.EditRecipeDescriptor descriptor) {
        this.descriptor = new EditCommand.EditRecipeDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditRecipeDescriptor} with fields containing {@code recipe}'s details
     */
    public EditRecipeDescriptorBuilder(Recipe recipe) {
        descriptor = new EditRecipeDescriptor();
        descriptor.setName(recipe.getName());
<<<<<<< HEAD
        descriptor.setPortion(recipe.getPortion());
        descriptor.setDuration(recipe.getDuration());
=======
//        descriptor.setPhone(recipe.getIngredient());
//        descriptor.setEmail(recipe.getEmail());
//        descriptor.setAddress(recipe.getAddress());
>>>>>>> upstream/mvp
        descriptor.setTags(recipe.getTags());
        descriptor.setIngredients(recipe.getIngredients());
        descriptor.setSteps(recipe.getSteps());
    }

    /**
     * Sets the {@code Name} of the {@code EditRecipeDescriptor} that we are building.
     */
    public EditRecipeDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
<<<<<<< HEAD
     * Sets the {@code Portion} of the {@code EditRecipeDescriptor} that we are building.
     */
    public EditRecipeDescriptorBuilder withPortion(String portion) {
        descriptor.setPortion(RecipePortion.of(portion));
=======
     * Sets the {@code Ingredient} of the {@code EditRecipeDescriptor} that we are building.
     */
    public EditRecipeDescriptorBuilder withPhone(String phone) {
//        descriptor.setPhone(new Ingredient(phone));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditRecipeDescriptor} that we are building.
     */
    public EditRecipeDescriptorBuilder withEmail(String email) {
//        descriptor.setEmail(new Email(email));
>>>>>>> upstream/mvp
        return this;
    }

    /**
     * Sets the {@code RecipeDuration} of the {@code EditRecipeDescriptor} that we are building.
     */
<<<<<<< HEAD
    public EditRecipeDescriptorBuilder withDuration(String duration) {
        descriptor.setDuration(RecipeDuration.of(duration));
=======
    public EditRecipeDescriptorBuilder withAddress(String address) {
//        descriptor.setAddress(new Address(address));
>>>>>>> upstream/mvp
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditRecipeDescriptor}
     * that we are building.
     */
    public EditRecipeDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    /**
     * Sets the {@code Ingredients} of the {@code EditRecipeDescriptor} that we are building.
     */
    public EditRecipeDescriptorBuilder withIngredients(String... ingredients) {
        List<Ingredient> ingredientList = Stream.of(ingredients).map(Ingredient::new).collect(Collectors.toList());
        descriptor.setIngredients(ingredientList);
        return this;
    }

    /**
     * Sets the {@code Steps} of the {@code EditRecipeDescriptor} that we are building.
     */
    public EditRecipeDescriptorBuilder withSteps(String... steps) {
        List<Step> stepList = Stream.of(steps).map(Step::new).collect(Collectors.toList());
        descriptor.setSteps(stepList);
        return this;
    }


    public EditCommand.EditRecipeDescriptor build() {
        return descriptor;
    }
}
