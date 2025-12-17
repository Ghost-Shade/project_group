package project_group;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CourseDBManager {
    private Connection conn;
    
    public CourseDBManager() {
        conn = DBConnection.getConnection();
    }
    
    // Get all courses
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses WHERE is_published = TRUE ORDER BY created_at DESC";
        
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Course course = new Course(
                    rs.getInt("course_id"),
                    rs.getString("course_code"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("category"),
                    rs.getString("difficulty_level"),
                    rs.getDouble("duration_hours"),
                    rs.getString("instructor_name")
                );
                courses.add(course);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error loading courses: " + e.getMessage(), 
                "Database Error", 
                JOptionPane.ERROR_MESSAGE);
        }
        return courses;
    }
    
    // Get courses by category
    public List<Course> getCoursesByCategory(String category) {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses WHERE category = ? AND is_published = TRUE";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, category);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Course course = new Course(
                    rs.getInt("course_id"),
                    rs.getString("course_code"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("category"),
                    rs.getString("difficulty_level"),
                    rs.getDouble("duration_hours"),
                    rs.getString("instructor_name")
                );
                courses.add(course);
            }
        } catch (SQLException e) {
            System.err.println("Error getting courses by category: " + e.getMessage());
        }
        return courses;
    }
    
    // Get course by ID
    public Course getCourseById(int courseId) {
        String sql = "SELECT * FROM courses WHERE course_id = ?";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, courseId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new Course(
                    rs.getInt("course_id"),
                    rs.getString("course_code"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("category"),
                    rs.getString("difficulty_level"),
                    rs.getDouble("duration_hours"),
                    rs.getString("instructor_name")
                );
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error loading course: " + e.getMessage(), 
                "Database Error", 
                JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    // Get modules for a course
    public List<Module> getCourseModules(int courseId) {
        List<Module> modules = new ArrayList<>();
        String sql = "SELECT * FROM modules WHERE course_id = ? ORDER BY module_order";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, courseId);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Module module = new Module(
                    rs.getInt("module_id"),
                    rs.getInt("course_id"),
                    rs.getInt("module_order"),
                    rs.getString("title"),
                    rs.getString("content_type"),
                    rs.getString("content"),
                    rs.getString("video_url"),
                    rs.getInt("estimated_time_minutes")
                );
                modules.add(module);
            }
        } catch (SQLException e) {
            System.err.println("Error getting modules: " + e.getMessage());
        }
        return modules;
    }
    
    // Enroll user in course
    public boolean enrollUserInCourse(int userId, int courseId) {
        // Check if already enrolled
        if (isUserEnrolled(userId, courseId)) {
            JOptionPane.showMessageDialog(null, 
                "You are already enrolled in this course!", 
                "Already Enrolled", 
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        String sql = "INSERT INTO user_enrollments (user_id, course_id) VALUES (?, ?)";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, courseId);
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                // Add enrollment points
                addUserPoints(userId, "course_enrollment", 50, "Enrolled in course");
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error enrolling in course: " + e.getMessage(), 
                "Enrollment Failed", 
                JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    // Check if user is enrolled in course
    public boolean isUserEnrolled(int userId, int courseId) {
        String sql = "SELECT * FROM user_enrollments WHERE user_id = ? AND course_id = ?";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, courseId);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Error checking enrollment: " + e.getMessage());
            return false;
        }
    }
    
    // Get user enrolled courses
    public List<UserEnrollment> getUserEnrollments(int userId) {
        List<UserEnrollment> enrollments = new ArrayList<>();
        String sql = "SELECT ue.*, c.title, c.category, c.difficulty_level " +
                     "FROM user_enrollments ue " +
                     "JOIN courses c ON ue.course_id = c.course_id " +
                     "WHERE ue.user_id = ? ORDER BY ue.enrollment_date DESC";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                UserEnrollment enrollment = new UserEnrollment(
                    rs.getInt("enrollment_id"),
                    rs.getInt("user_id"),
                    rs.getInt("course_id"),
                    rs.getString("title"),
                    rs.getString("category"),
                    rs.getString("difficulty_level"),
                    rs.getDouble("progress_percentage"),
                    rs.getString("status")
                );
                enrollments.add(enrollment);
            }
        } catch (SQLException e) {
            System.err.println("Error getting user enrollments: " + e.getMessage());
        }
        return enrollments;
    }
    
    // Update user progress
    public boolean updateUserProgress(int userId, int moduleId, int courseId, double score, int timeSpent) {
        String sql = "INSERT INTO user_progress (user_id, module_id, course_id, score, time_spent_minutes) " +
                     "VALUES (?, ?, ?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE " +
                     "score = GREATEST(score, VALUES(score)), " +
                     "time_spent_minutes = time_spent_minutes + VALUES(time_spent_minutes), " +
                     "attempts = attempts + 1";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, moduleId);
            pstmt.setInt(3, courseId);
            pstmt.setDouble(4, score);
            pstmt.setInt(5, timeSpent);
            
            int rowsAffected = pstmt.executeUpdate();
            
            // Update overall course progress
            updateCourseProgress(userId, courseId);
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error updating progress: " + e.getMessage());
            return false;
        }
    }
    
    // Update overall course progress
    private void updateCourseProgress(int userId, int courseId) {
        String sql = "UPDATE user_enrollments ue " +
                     "SET progress_percentage = (" +
                     "  SELECT COALESCE(AVG(CASE WHEN up.completed_at IS NOT NULL THEN 100 ELSE 0 END), 0) " +
                     "  FROM modules m " +
                     "  LEFT JOIN user_progress up ON m.module_id = up.module_id AND up.user_id = ? " +
                     "  WHERE m.course_id = ?" +
                     ") " +
                     "WHERE ue.user_id = ? AND ue.course_id = ?";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, courseId);
            pstmt.setInt(3, userId);
            pstmt.setInt(4, courseId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating course progress: " + e.getMessage());
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
    
    // Get user points total
    public int getUserTotalPoints(int userId) {
        String sql = "SELECT SUM(points) as total_points FROM user_points WHERE user_id = ?";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("total_points");
            }
        } catch (SQLException e) {
            System.err.println("Error getting user points: " + e.getMessage());
        }
        return 0;
    }
    
    // Data classes
    public static class Course {
        private int courseId;
        private String courseCode;
        private String title;
        private String description;
        private String category;
        private String difficultyLevel;
        private double durationHours;
        private String instructorName;
        
        public Course(int courseId, String courseCode, String title, String description, 
                     String category, String difficultyLevel, double durationHours, String instructorName) {
            this.courseId = courseId;
            this.courseCode = courseCode;
            this.title = title;
            this.description = description;
            this.category = category;
            this.difficultyLevel = difficultyLevel;
            this.durationHours = durationHours;
            this.instructorName = instructorName;
        }
        
        // Getters
        public int getCourseId() { return courseId; }
        public String getCourseCode() { return courseCode; }
        public String getTitle() { return title; }
        public String getDescription() { return description; }
        public String getCategory() { return category; }
        public String getDifficultyLevel() { return difficultyLevel; }
        public double getDurationHours() { return durationHours; }
        public String getInstructorName() { return instructorName; }
    }
    
    public static class Module {
        private int moduleId;
        private int courseId;
        private int moduleOrder;
        private String title;
        private String contentType;
        private String content;
        private String videoUrl;
        private int estimatedTimeMinutes;
        
        public Module(int moduleId, int courseId, int moduleOrder, String title, 
                     String contentType, String content, String videoUrl, int estimatedTimeMinutes) {
            this.moduleId = moduleId;
            this.courseId = courseId;
            this.moduleOrder = moduleOrder;
            this.title = title;
            this.contentType = contentType;
            this.content = content;
            this.videoUrl = videoUrl;
            this.estimatedTimeMinutes = estimatedTimeMinutes;
        }
        
        // Getters
        public int getModuleId() { return moduleId; }
        public int getCourseId() { return courseId; }
        public int getModuleOrder() { return moduleOrder; }
        public String getTitle() { return title; }
        public String getContentType() { return contentType; }
        public String getContent() { return content; }
        public String getVideoUrl() { return videoUrl; }
        public int getEstimatedTimeMinutes() { return estimatedTimeMinutes; }
    }
    
    public static class UserEnrollment {
        private int enrollmentId;
        private int userId;
        private int courseId;
        private String courseTitle;
        private String category;
        private String difficultyLevel;
        private double progressPercentage;
        private String status;
        
        public UserEnrollment(int enrollmentId, int userId, int courseId, String courseTitle, 
                             String category, String difficultyLevel, double progressPercentage, String status) {
            this.enrollmentId = enrollmentId;
            this.userId = userId;
            this.courseId = courseId;
            this.courseTitle = courseTitle;
            this.category = category;
            this.difficultyLevel = difficultyLevel;
            this.progressPercentage = progressPercentage;
            this.status = status;
        }
        
        // Getters
        public int getEnrollmentId() { return enrollmentId; }
        public int getUserId() { return userId; }
        public int getCourseId() { return courseId; }
        public String getCourseTitle() { return courseTitle; }
        public String getCategory() { return category; }
        public String getDifficultyLevel() { return difficultyLevel; }
        public double getProgressPercentage() { return progressPercentage; }
        public String getStatus() { return status; }
    }
}