package seedu.recipe.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.recipe.commons.exceptions.IllegalValueException;
import seedu.recipe.model.recipe.*;
import seedu.recipe.model.tag.Tag;

/**
 * Jackson-friendly version of {@link Recipe}.
 */
class JsonAdaptedRecipe {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Recipe's %s field is missing!";

    private Optional<RecipePortion> portion = Optional.empty();
    private Optional<RecipeDuration> duration = Optional.empty();
    private Optional<Set<Tag>> tags = Optional.empty();
    private Optional<List<Ingredient>> ingredients = Optional.empty();
    private Optional<List<Step>> steps = Optional.empty();

    private final String name;
    private final String phone;
    private final String email;
    private final String address;
    private final List<JsonAdaptedTag> tagged = new ArrayList<>();
    private final String step;
    /**
     * Constructs a {@code JsonAdaptedRecipe} with the given recipe details.
     */
    @JsonCreator
    public JsonAdaptedRecipe(@JsonProperty("name") String name, @JsonProperty("phone") String phone,
            @JsonProperty("email") String email, @JsonProperty("address") String address,
            @JsonProperty("tagged") List<JsonAdaptedTag> tagged, @JsonProperty("step") String step) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        if (tagged != null) {
            this.tagged.addAll(tagged);
        }
        this.step = step;
    }

    /**
     * Converts a given {@code Recipe} into this class for Jackson use.
     */
    public JsonAdaptedRecipe(Recipe source) {
        name = source.getName().recipeName;
        phone = source.getIngredient().value;
        email = source.getEmail().value;
        address = source.getAddress().value;
        tagged.addAll(source.getTags().stream()
                .map(JsonAdaptedTag::new)
                .collect(Collectors.toList()));
        step = source.getStep().description;
    }

    /**
     * Converts this Jackson-friendly adapted recipe object into the model's {@code Recipe} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted recipe.
     */
    public Recipe toModelType() throws IllegalValueException {
        final List<Tag> recipeTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tagged) {
            recipeTags.add(tag.toModelType());
        }

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (phone == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Ingredient.class.getSimpleName()));
        }
        if (!Ingredient.isValidIngredient(phone)) {
            throw new IllegalValueException(Ingredient.MESSAGE_CONSTRAINTS);
        }
        final Ingredient modelIngredient = new Ingredient(phone);

        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
        }
        if (!Email.isValidEmail(email)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(email);

        if (address == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName()));
        }
        if (!Address.isValidAddress(address)) {
            throw new IllegalValueException(Address.MESSAGE_CONSTRAINTS);
        }
        final Address modelAddress = new Address(address);

        if (step == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Step.class.getSimpleName()));
        }
        if (!Step.isValidStep(step)) {
            throw new IllegalValueException(Step.MESSAGE_CONSTRAINTS);
        }
        final Step modelStep = new Step(step);

        final Set<Tag> modelTags = new HashSet<>(recipeTags);
        return new Recipe(modelName, modelIngredient, modelEmail, modelAddress, modelTags, modelStep);
    }

}
