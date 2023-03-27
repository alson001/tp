package seedu.recipe.storage;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
public class ExportManager {

    private final Path recipeBookFilePath = Paths.get("data", "recipebook.json");

    private boolean isOverwrite;

    public ExportManager() {
        this.isOverwrite = false;
    }

    public void execute() throws IOException {
        JFileChooser chooser = createFile();
        int result = chooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            if (exists(chooser)) {
                int response = JOptionPane.showConfirmDialog(null,
                        "The file " + chooser.getSelectedFile().getName() + " already exists. " +
                                "Do you want to overwrite it?",
                        "Confirm Overwrite",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                if (response == JOptionPane.NO_OPTION) {
                    return;
                }
                isOverwrite = true;
            }
            writeToFile(chooser);
        }
    }

    public JFileChooser createFile() {
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "/Downloads");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON files", "json");
        chooser.setFileFilter(filter);
        return chooser;
    }

    public boolean exists(JFileChooser chooser) {
        File selectedFile = chooser.getSelectedFile();
        String filePath = selectedFile.getAbsolutePath();
        if (!filePath.endsWith(".json")) {
            filePath += ".json";
        }
        File file = new File(filePath);
        if (file.exists()) {
            return true;
        }
        return false;
    }


    public void writeToFile(JFileChooser chooser) throws IOException {
        FileReader fr = new FileReader(recipeBookFilePath.toFile());
        FileWriter fw;
        if (isOverwrite) {
            fw = new FileWriter(chooser.getSelectedFile());
        } else {
            fw = new FileWriter(chooser.getSelectedFile()+".json");
        }
        try (BufferedReader reader = new BufferedReader(fr)) {
            String line;
            while ((line = reader.readLine()) != null) {
                fw.write(line);
                fw.write(System.lineSeparator()); // add line separator
            }
        }
        fr.close();
        fw.close();
    }

    public static void main(String[] args) throws IOException {
        ExportManager exportManager = new ExportManager();
        exportManager.execute();
    }
}
