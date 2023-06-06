package com.polezhaiev.notes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addNoteButton;

    @FXML
    void initialize() {
       addNoteButton.setOnAction(a ->{
           try {
               addNoteButton.getScene().getWindow().hide();

               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(getClass().getResource("note-window.fxml"));
               loader.load();

               Parent child = loader.getRoot();
               Stage stage = new Stage();
               stage.setScene(new Scene(child));
               stage.show();

           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       });

    }

}
