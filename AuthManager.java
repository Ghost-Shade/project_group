package project_group;

import java.io.*;
import java.util.HashMap;

public class AuthManager {
    private static final String USER_FILE = "users.dat";
    private HashMap<String, User> users;
    
    public AuthManager() {
        users = new HashMap<>();
        loadUsers();
    }
    
    private void loadUsers() {
        try {
            File file = new File(USER_FILE);
            if (file.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                users = (HashMap<String, User>) ois.readObject();
                ois.close();
            }
        } catch (Exception e) {
            users = new HashMap<>();
            // Add default admin user
            register("admin", "admin123", "Administrator", "admin@company.com");
        }
    }
    
    private void saveUsers() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_FILE));
            oos.writeObject(users);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean register(String username, String password, String fullName, String email) {
        if (users.containsKey(username)) {
            return false; // Username already exists
        }
        
        User newUser = new User(username, password, fullName, email);
        users.put(username, newUser);
        saveUsers();
        return true;
    }
    
    public User login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
    
    // Inner User class
    public static class User implements Serializable {
        private String username;
        private String password;
        private String fullName;
        private String email;
        
        public User(String username, String password, String fullName, String email) {
            this.username = username;
            this.password = password;
            this.fullName = fullName;
            this.email = email;
        }
        
        public String getUsername() { return username; }
        public String getPassword() { return password; }
        public String getFullName() { return fullName; }
        public String getEmail() { return email; }
    }
}