package project_group;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import javax.swing.JOptionPane;

public class AuthDBManager {
    private Connection conn;
    private static User currentUser = null;
    
    public AuthDBManager() {
        conn = DBConnection.getConnection();
    }
    
    // Hash password using SHA-256
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            return password; // Fallback (not secure)
        }
    }
    
    // Register new user
    public boolean register(String username, String password, String fullName, String email, 
                           String department, String jobTitle) {
        String hashedPassword = hashPassword(password);
        
        String sql = "INSERT INTO users (username, password_hash, full_name, email, department, job_title) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, hashedPassword);
            pstmt.setString(3, fullName);
            pstmt.setString(4, email);
            pstmt.setString(5, department);
            pstmt.setString(6, jobTitle);
            
            int rowsAffected = pstmt.executeUpdate();
            
            // Add welcome achievement
            if (rowsAffected > 0) {
                addUserAchievement(getUserId(username), "welcome", "New Learner Badge");
                addUserPoints(getUserId(username), "achievement", 100, "Account creation bonus");
            }
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(null, 
                    "Username or email already exists!", 
                    "Registration Failed", 
                    JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, 
                    "Database error: " + e.getMessage(), 
                    "Registration Failed", 
                    JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
    }
    
    // Login user
    public User login(String username, String password) {
        String hashedPassword = hashPassword(password);
        
        String sql = "SELECT * FROM users WHERE username = ? AND password_hash = ? AND is_active = TRUE";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, hashedPassword);
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                // Update last login
                updateLastLogin(rs.getInt("user_id"));
                
                // Create user object
                User user = new User(
                    rs.getInt("user_id"),
                    rs.getString("username"),
                    rs.getString("full_name"),
                    rs.getString("email"),
                    rs.getString("department"),
                    rs.getString("job_title"),
                    rs.getString("profile_picture")
                );
                
                currentUser = user;
                return user;
            } else {
                JOptionPane.showMessageDialog(null, 
                    "Invalid username or password!", 
                    "Login Failed", 
                    JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Database error: " + e.getMessage(), 
                "Login Error", 
                JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    // Update last login timestamp
    private void updateLastLogin(int userId) {
        String sql = "UPDATE users SET last_login = CURRENT_TIMESTAMP WHERE user_id = ?";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating last login: " + e.getMessage());
        }
    }
    
    // Get user ID by username
    private int getUserId(String username) {
        String sql = "SELECT user_id FROM users WHERE username = ?";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("user_id");
            }
        } catch (SQLException e) {
            System.err.println("Error getting user ID: " + e.getMessage());
        }
        return -1;
    }
    
    // Add user achievement
    private void addUserAchievement(int userId, String type, String badgeName) {
        String sql = "INSERT INTO user_achievements (user_id, achievement_type, badge_name) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setString(2, type);
            pstmt.setString(3, badgeName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error adding achievement: " + e.getMessage());
        }
    }
    
    // Add user points
    private void addUserPoints(int userId, String type, int points, String description) {
        String sql = "INSERT INTO user_points (user_id, points_type, points, description) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setString(2, type);
            pstmt.setInt(3, points);
            pstmt.setString(4, description);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error adding points: " + e.getMessage());
        }
    }
    
    // Get current logged-in user
    public static User getCurrentUser() {
        return currentUser;
    }
    
    // Logout
    public static void logout() {
        currentUser = null;
    }
    
    // User class
    public static class User {
        private int userId;
        private String username;
        private String fullName;
        private String email;
        private String department;
        private String jobTitle;
        private String profilePicture;
        
        public User(int userId, String username, String fullName, String email, 
                   String department, String jobTitle, String profilePicture) {
            this.userId = userId;
            this.username = username;
            this.fullName = fullName;
            this.email = email;
            this.department = department;
            this.jobTitle = jobTitle;
            this.profilePicture = profilePicture;
        }
        
        public int getUserId() { return userId; }
        public String getUsername() { return username; }
        public String getFullName() { return fullName; }
        public String getEmail() { return email; }
        public String getDepartment() { return department; }
        public String getJobTitle() { return jobTitle; }
        public String getProfilePicture() { return profilePicture; }
    }
}