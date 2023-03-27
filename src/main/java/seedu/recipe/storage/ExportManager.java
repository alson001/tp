package seedu.recipe.storage;


import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
public class ExportManager {

    private final Path recipeBookFilePath = Paths.get("data", "recipebook.json");

    private boolean hasJsonExtension;

    public ExportManager() {
        hasJsonExtension = false;
    }

    public void execute() throws IOException {
        JFileChooser fileChooser = createFile();
        // change the icon and dialog title
        JFrame jFrame = setIcon();
        fileChooser.setDialogTitle("Export RecipeBook");
        int result = fileChooser.showSaveDialog(jFrame);

        if (result == JFileChooser.APPROVE_OPTION) {
            // Check if file exists already
            if (exists(fileChooser)) {
                String selectedFile = fileChooser.getSelectedFile().getName();
                int response = JOptionPane.showConfirmDialog(null,
                        String.format("The file %s already exists. Do you want to overwrite it?", selectedFile),
                        "Confirm Overwrite",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                if (response == JOptionPane.NO_OPTION) {
                    return;
                }
            }
            writeToFile(fileChooser);
        }
        jFrame.dispose();
    }

    protected static JFrame setIcon() {
        // Set a custom icon for the JFileChooser
        File iconFile = new File("src/main/resources/images/recipebook_icon1.png");
        JFrame jFrame = new JFrame();
        if (iconFile.exists()) {
            ImageIcon icon = new ImageIcon(iconFile.getAbsolutePath());
            Image image = icon.getImage();

            jFrame.setIconImage(image);
            jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jFrame.setLocationByPlatform(true);
            jFrame.pack();
        }
        return jFrame;
    }

    public JFileChooser createFile() {
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home") + "/Downloads");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON files", "json");
        fileChooser.setFileFilter(filter);
        return fileChooser;
    }

    public boolean exists(JFileChooser chooser) {
        File selectedFile = chooser.getSelectedFile();
        String filePath = selectedFile.getAbsolutePath();
        if (!filePath.endsWith(".json")) {
            filePath += ".json";
        } else {
            hasJsonExtension = true;
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
        if (hasJsonExtension) {
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
