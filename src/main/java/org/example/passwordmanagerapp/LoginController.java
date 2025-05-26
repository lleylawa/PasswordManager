package org.example.passwordmanagerapp;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class LoginController {
    @FXML
    private PasswordField masterPasswordField;

    private static final String MASTER_PASSWORD = "1234"; // замените на хэш в будущем

    @FXML
    protected void onLoginClick() throws Exception {
        String input = masterPasswordField.getText();
        if (MASTER_PASSWORD.equals(input)) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("manager-view.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) masterPasswordField.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Password Manager");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Неверный мастер-пароль.");
            alert.showAndWait();
        }
    }
}