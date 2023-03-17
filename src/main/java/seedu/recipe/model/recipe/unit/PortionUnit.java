package seedu.recipe.model.recipe.unit;

import seedu.recipe.model.recipe.Step;

public class PortionUnit extends Unit{

    public PortionUnit(String unit) {
        super(unit);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PortionUnit // instanceof handles nulls
                && unit.equals(((PortionUnit) other).unit)); // state check
    }
}

