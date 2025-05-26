package org.example.passwordmanagerapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ManagerController {
    @FXML private TextField websiteField;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private ListView<PasswordEntry> passwordList;
    @FXML private Button generateButton;

    private ObservableList<PasswordEntry> entries;

    @FXML
    public void initialize() {
        entries = FXCollections.observableArrayList(DatabaseService.loadPasswords());


        passwordList.setItems(entries);
        passwordList.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(PasswordEntry item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.toString());
            }
        });
    }

    @FXML
    public void onSaveClick() {
        PasswordEntry entry = new PasswordEntry(
                websiteField.getText(),
                usernameField.getText(),
                PasswordUtil.encrypt(passwordField.getText())
        );
        DatabaseService.savePassword(entry);
        entries.add(entry);

        websiteField.clear();
        usernameField.clear();
        passwordField.clear();
    }

    @FXML
    public void onGenerateClick() {
        passwordField.setText(PasswordUtil.generatePassword(12));
    }

    @FXML
    public void onDecryptClick() {
        PasswordEntry selected = passwordList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            String decrypted = PasswordUtil.decrypt(selected.getEncryptedPassword());
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Пароль: " + decrypted);
            alert.setHeaderText("Расшифрованный пароль");
            alert.showAndWait();
        }
    }
}