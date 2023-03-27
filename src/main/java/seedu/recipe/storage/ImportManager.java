package seedu.recipe.storage;

import javafx.collections.ObservableList;
import seedu.recipe.commons.exceptions.DataConversionException;
import seedu.recipe.commons.exceptions.IllegalValueException;
import seedu.recipe.model.ReadOnlyRecipeBook;
import seedu.recipe.model.recipe.Recipe;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ImportManager {

    public ImportManager() {
    }

    public ObservableList<Recipe> execute() throws IOException, DataConversionException, IllegalValueException {
        File importedFile = this.selectFile();
        if (!importedFile.exists()) {
            return null;
        }
        ObservableList<Recipe> importedRecipes = importRecipes(importedFile);
        return importedRecipes;
    }

    public File selectFile() throws IOException {
        // Create a file chooser that opens at the Downloads folder
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home") + "/Downloads");

        // Set filter to only show JSON files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON Files", "json");
        fileChooser.setFileFilter(filter);

        // Show the file chooser dialog and get the result
        int result = fileChooser.showOpenDialog(null);

        File selectedFile;
        if (result == JFileChooser.APPROVE_OPTION) {
            // User selected a file, get the file object
            selectedFile = fileChooser.getSelectedFile();
            // Check if the file is a JSON file
            if (!selectedFile.getName().endsWith(".json")) {
                System.out.println("Selected file is not a JSON file.");
                return null;
            }
        } else {
            // User canceled the file chooser dialog
            System.out.println("No file selected.");
            return null;
        }
        return selectedFile;
    }

    public ObservableList<Recipe> importRecipes(File selectedFile) throws DataConversionException {
        Path filePath = selectedFile.toPath();
        System.out.println("Selected file: " + filePath.toString());

        JsonRecipeBookStorage importedStorage = new JsonRecipeBookStorage((filePath));
        Optional<ReadOnlyRecipeBook> importedRecipeBook;
        try {
            importedRecipeBook = importedStorage.readRecipeBook();
        } catch (DataConversionException e) {
            throw e;
        }
        return importedRecipeBook.get().getRecipeList();
    }

    public static void main(String[] args) throws IOException, IllegalValueException {
        ImportManager importManager = new ImportManager();
        try {
            ObservableList<Recipe> importedRecipes = importManager.execute();
            for (Recipe recipe : importedRecipes) {
                System.out.println("Recipe: " + recipe.toString());
            }
        } catch (DataConversionException e) {
            throw new RuntimeException(e);
        }
    }
}
