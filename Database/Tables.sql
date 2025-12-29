-- Create database
CREATE DATABASE IF NOT EXISTS etes_db;
USE etes_db;

-- Users table
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    department VARCHAR(50),
    job_title VARCHAR(50),
    profile_picture VARCHAR(255),
    date_joined TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_login TIMESTAMP,
    is_active BOOLEAN DEFAULT TRUE
);

-- Courses table
CREATE TABLE courses (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_code VARCHAR(20) UNIQUE NOT NULL,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    category VARCHAR(50),
    difficulty_level ENUM('Beginner', 'Intermediate', 'Advanced') DEFAULT 'Beginner',
    duration_hours DECIMAL(5,2) DEFAULT 0,
    instructor_name VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_published BOOLEAN DEFAULT TRUE
);

-- Modules table (sub-sections of courses)
CREATE TABLE modules (
    module_id INT PRIMARY KEY AUTO_INCREMENT,
    course_id INT,
    module_order INT,
    title VARCHAR(200) NOT NULL,
    content_type ENUM('text', 'video', 'quiz', 'assignment') DEFAULT 'text',
    content TEXT,
    video_url VARCHAR(255),
    estimated_time_minutes INT DEFAULT 30,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

-- User enrollments
CREATE TABLE user_enrollments (
    enrollment_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    course_id INT,
    enrollment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    completion_date TIMESTAMP NULL,
    progress_percentage DECIMAL(5,2) DEFAULT 0,
    current_module_id INT NULL,
    status ENUM('enrolled', 'in_progress', 'completed', 'dropped') DEFAULT 'enrolled',
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

-- User progress tracking
CREATE TABLE user_progress (
    progress_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    module_id INT,
    course_id INT,
    started_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    completed_at TIMESTAMP NULL,
    score DECIMAL(5,2) NULL,
    time_spent_minutes INT DEFAULT 0,
    attempts INT DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (module_id) REFERENCES modules(module_id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

-- Leaderboard points
CREATE TABLE user_points (
    points_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    points_type ENUM('course_completion', 'quiz_score', 'consistency', 'achievement') NOT NULL,
    points INT DEFAULT 0,
    description VARCHAR(200),
    earned_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- User achievements/badges
CREATE TABLE user_achievements (
    achievement_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    achievement_type VARCHAR(50) NOT NULL,
    badge_name VARCHAR(100),
    earned_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

Insert sample data
INSERT INTO users (username, password_hash, full_name, email, department, job_title) VALUES
('admin', 'admin123', 'System Administrator', 'admin@company.com', 'IT', 'System Admin'),
('john.doe', 'password123', 'John Doe', 'john.doe@company.com', 'Engineering', 'Software Developer'),
('sarah.j', 'password123', 'Sarah Johnson', 'sarah.j@company.com', 'Marketing', 'Marketing Manager');

 INSERT INTO courses (course_code, title, description, category, difficulty_level, duration_hours, instructor_name) VALUES
('JAVA101', 'Java Programming Fundamentals', 'Learn core Java concepts including OOP, data structures, and basic algorithms.', 'Technical Skills', 'Beginner', 3.0, 'Prof. James Wilson'),
('COMM201', 'Effective Communication', 'Master professional communication skills for workplace success.', 'Communication', 'Intermediate', 2.0, 'Dr. Emily Brown'),
('PM301', 'Project Management Basics', 'Essential project management principles and methodologies.', 'Leadership', 'Beginner', 4.0, 'Alex Rodriguez');

INSERT INTO modules (course_id, module_order, title, content_type, content, estimated_time_minutes) VALUES
(1, 1, 'Introduction to Java', 'text', 'Java is a high-level, class-based, object-oriented programming language...', 30),
(1, 2, 'Variables and Data Types', 'text', 'Variables are containers for storing data values. In Java, there are different types...', 45),
(1, 3, 'Control Flow Statements', 'text', 'Control flow statements regulate the order in which statements are executed...', 40),
(2, 1, 'Verbal Communication', 'text', 'Effective verbal communication involves speaking clearly and concisely...', 30),
(2, 2, 'Non-Verbal Communication', 'text', 'Non-verbal cues include body language, facial expressions, and gestures...', 35);

INSERT INTO user_enrollments (user_id, course_id, progress_percentage, status) VALUES
(2, 1, 65.00, 'in_progress'),
(2, 2, 30.00, 'in_progress'),
(3, 2, 85.00, 'in_progress'),
(3, 3, 0.00, 'enrolled');