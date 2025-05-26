package org.example.passwordmanagerapp;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StorageService {
    private static final String FILE_PATH = "data/passwords.json";
    private static final Gson gson = new Gson();

    public static List<PasswordEntry> loadPasswords() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) return new ArrayList<>();
            FileReader reader = new FileReader(file);
            return gson.fromJson(reader, new TypeToken<List<PasswordEntry>>(){}.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void savePasswords(List<PasswordEntry> passwords) {
        try {
            File file = new File(FILE_PATH);
            file.getParentFile().mkdirs();
            FileWriter writer = new FileWriter(file);
            gson.toJson(passwords, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}