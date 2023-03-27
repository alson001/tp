package seedu.recipe.storage;


import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
public class ExportManager {

    private final Path recipeBookFilePath = Paths.get("data", "recipebook.json");

    public ExportManager() {
    }

    public void execute() throws IOException {
        JFileChooser chooser = createFile();
        int result = chooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            writeToFile(chooser);
        }
    }

    public JFileChooser createFile() {
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "/Downloads");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON files", "json");
        chooser.setFileFilter(filter);
        return chooser;
    }

    public void writeToFile(JFileChooser chooser) throws IOException {
        FileReader fr = new FileReader(recipeBookFilePath.toFile());
        FileWriter fw = new FileWriter(chooser.getSelectedFile()+".json");
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
