package com.polezhaiev.notes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.polezhaiev.notes.repo.Repo;
import com.polezhaiev.notes.repo.RepoInFile;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NoteWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backToMainWindowButton;

    @FXML
    private TextField noteTitleId;
    @FXML
    private TextArea noteTextId;

    @FXML
    void initialize() {
        Repo repoInFile = new RepoInFile();
        backToMainWindowButton.setOnAction(a -> {
            try {
                repoInFile.writeNote(noteTitleId.getText(), noteTextId.getText());

                backToMainWindowButton.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("notes-view.fxml"));
                loader.load();

                Parent parent = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(parent));
                stage.show();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
