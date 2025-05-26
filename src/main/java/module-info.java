module org.example.passwordmanagerapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.sql;


    opens org.example.passwordmanagerapp to javafx.fxml;
    exports org.example.passwordmanagerapp;
}