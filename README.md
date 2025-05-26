````markdown
# 🔐 JavaFX Password Manager

A simple and secure Password Manager desktop application built with JavaFX. It allows users to store, encrypt, view, and manage passwords. Data is stored in a PostgreSQL database.

## ✨ Features

- Master password login
- AES Base64 password encryption/decryption
- Add, display, and delete password entries
- Random password generator
- PostgreSQL database integration for persistence
- JavaFX GUI

## 🛠 Technologies

- Java 17+
- JavaFX
- PostgreSQL
- JDBC
- GSON (for optional local JSON fallback)
- IntelliJ IDEA (recommended)

````

### 2. Setup PostgreSQL Database

1. Open PostgreSQL and run:

```sql
CREATE DATABASE password_manager;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    master_password TEXT NOT NULL
);

CREATE TABLE passwords (
    id SERIAL PRIMARY KEY,
    website TEXT,
    username TEXT,
    encrypted_password TEXT
);
```

2. Insert a default master password:

```sql
INSERT INTO users (master_password) VALUES ('1234'); -- Later, replace with hash
```

### 3. Update Database Credentials

In DatabaseService.java, set your database URL, username, and password:

```java
String url = "jdbc:postgresql://localhost:5432/password";
String user = "your_username";
String pass = "your_password";
```

## 📸 Screenshots
Login View  

![image](https://github.com/user-attachments/assets/b0f705fe-63c2-46cd-832b-55589c57d103)


Manager View 

![image](https://github.com/user-attachments/assets/cbd04431-68d0-42df-8956-796afcaa2b30)

## ✅ Future Improvements

* Use hashed master passwords with bcrypt
* Add user registration and multiple user support
* Search/filter password entries
* Dark mode theme

```
