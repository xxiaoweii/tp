package seedu.address.ui;

import java.io.File;

import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileExplorerWindow extends UiPart<Stage> {

    private static final String PROMPT_MESSAGE = "Which file do you want to load from: ";
    private static final String FXML = "FileExplorer.fxml";
    private Label fileChoice;
    private Text selectedFileText;

    public FileExplorerWindow(Stage root) {
        super(FXML, root);
        fileChoice.setText(PROMPT_MESSAGE);
    }

    public FileExplorerWindow() {
        this(new Stage());
    }

    private void openFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

        File selectedFile = fileChooser.showOpenDialog(getRoot());
        if (selectedFile != null) {
            selectedFileText.setText("Selected File: " + selectedFile.getAbsolutePath());
        } else {
            selectedFileText.setText("No file selected");
        }
    }
}
