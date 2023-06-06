module com.example.notes {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.polezhaiev.notes;
    opens com.polezhaiev.notes to javafx.fxml;
    exports com.polezhaiev.notes.repo;
    opens com.polezhaiev.notes.repo to javafx.fxml;

}