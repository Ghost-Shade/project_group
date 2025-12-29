
/*
    GROUP NAME: LOUCIOUS
UNIT: OBJECT ORIENTED PROGRAMMING II
DATE: 19/12/2025

MEMBERS:

JAMSON ANJERA:            CCS/00039/024
JOHNSTON ODHIAMBO :       CCT/00012/024
JUNE JEPKOSGEI RUTO :     ESC/00389/024
ALPHONCE KIOKO:           CCT/00070/024

*/

/*
        PLEASE NOTE THAT!!!
INORDER FOR THE APPLICATION TO RUN THERE MUST EXIST A DATABASE IN THE LOCAL MACHINE.
I HAVE INCLUDED THE DATABASE MODIFICATION QUERIES IN A FOLDER KNOWN AS "database".
YOU CAN USE THOSE QUERIES TO CREATE A DATABASE.
AGAIN INORDER TO RUN THE APPLICATION YOU MUST START WITH THE AuthFrame.java FILE and Log in BEFORE PROCEEDING.


*/

package project_group;

import java.awt.*;
import javax.swing.*;

public class ProgressAnalyticsPanels extends JPanel {
    
    public ProgressAnalyticsPanels() {
        initComponents();
    }
    
    
    private void initComponents() {
    setLayout(new BorderLayout());
    setBackground(new Color(245, 245, 245));
    
    // Sidebar
    JPanel sidebar = createSidebar();
    
    // Main content - 
    JPanel mainContent = new JPanel();
    mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
    mainContent.setBackground(new Color(245, 245, 245));
    mainContent.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    
    // Add all cards
    mainContent.add(createCard("📈 Your Learning Progress", createWelcomeContent()));
    mainContent.add(Box.createVerticalStrut(15));
    mainContent.add(createCard("📊 Key Metrics", createMetricsContent()));
    mainContent.add(Box.createVerticalStrut(15));
    mainContent.add(createCard("📅 Weekly Progress", createProgressContent()));
    mainContent.add(Box.createVerticalStrut(15));
    mainContent.add(createCard("🎯 Skills Development", createSkillsContent()));
    mainContent.add(Box.createVerticalStrut(15));
    mainContent.add(createCard("📚 Course Progress", createCoursesContent()));
    mainContent.add(Box.createVerticalStrut(15));
    mainContent.add(createCard("🔥 Learning Consistency", createConsistencyContent()));
    
    // Add flexible space
    mainContent.add(Box.createVerticalGlue());
    
    // Wrap in JScrollPane 
    JScrollPane scrollPane = new JScrollPane(mainContent);
    scrollPane.setBorder(null);
    scrollPane.getVerticalScrollBar().setUnitIncrement(16);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    add(sidebar, BorderLayout.WEST);
    add(scrollPane, BorderLayout.CENTER);
}
    
//    private void initComponents() {
//        setLayout(new BorderLayout());
//        setBackground(new Color(245, 245, 245));
//        
//        // Create sidebar
//        JPanel sidebar = createSidebar();
//        
//        // Create main content with cards
//        JPanel mainContent = createMainContent();
//        JScrollPane scrollPane = new JScrollPane(mainContent);
//        scrollPane.setBorder(null);
//        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
//        
//        add(sidebar, BorderLayout.WEST);
//        add(scrollPane, BorderLayout.CENTER);
//    }
    
    private JPanel createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(52, 73, 94));
        sidebar.setPreferredSize(new Dimension(220, getHeight()));
        sidebar.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
        
        // User profile
        AuthDBManager.User currentUser = AuthDBManager.getCurrentUser();
        JLabel userLabel = new JLabel("👤 "+currentUser.getFullName());
        userLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        userLabel.setForeground(Color.WHITE);
        userLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel roleLabel = new JLabel("Software Developer");
        roleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        roleLabel.setForeground(new Color(236, 240, 241));
        roleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Stats
        JLabel timeLabel = new JLabel("🕒 24h Learning Time");
        timeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel coursesLabel = new JLabel("✅ 8 Courses Completed");
        coursesLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        coursesLabel.setForeground(Color.WHITE);
        coursesLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Time filter
        JComboBox<String> timeFilter = new JComboBox<>(new String[]{"Last 30 Days", "Last 90 Days", "All Time"});
        timeFilter.setMaximumSize(new Dimension(180, 30));
        timeFilter.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Export button
        JButton exportBtn = new JButton("📊 Export Report");
        exportBtn.setBackground(new Color(52, 152, 219));
        exportBtn.setForeground(Color.WHITE);
        exportBtn.setMaximumSize(new Dimension(180, 35));
        exportBtn.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Add components
        sidebar.add(userLabel);
        sidebar.add(Box.createVerticalStrut(5));
        sidebar.add(roleLabel);
        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(timeLabel);
        sidebar.add(Box.createVerticalStrut(5));
        sidebar.add(coursesLabel);
        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(new JLabel("Time Period:"));
        sidebar.add(Box.createVerticalStrut(5));
        sidebar.add(timeFilter);
        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(exportBtn);
        sidebar.add(Box.createVerticalGlue());
        
        return sidebar;
    }
    
    private JPanel createMainContent() {
        JPanel mainContent = new JPanel();
        mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
        mainContent.setBackground(new Color(245, 245, 245));
        mainContent.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Welcome card
        mainContent.add(createCard("📈 Your Learning Progress", createWelcomeContent()));
        mainContent.add(Box.createVerticalStrut(15));
        
        // Metrics card
        mainContent.add(createCard("📊 Key Metrics", createMetricsContent()));
        mainContent.add(Box.createVerticalStrut(15));
        
        // Progress card
        mainContent.add(createCard("📅 Weekly Progress", createProgressContent()));
        mainContent.add(Box.createVerticalStrut(15));
        
        // Skills card
        mainContent.add(createCard("🎯 Skills Development", createSkillsContent()));
        mainContent.add(Box.createVerticalStrut(15));
        
        // Courses card
        mainContent.add(createCard("📚 Course Progress", createCoursesContent()));
        
        return mainContent;
    }
    
    private JComponent createConsistencyContent() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel streakLabel = new JLabel("Current Streak: 12 days 🔥");
        streakLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JLabel longestLabel = new JLabel("Longest Streak: 24 days");
        longestLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        panel.add(streakLabel, BorderLayout.NORTH);
        panel.add(longestLabel, BorderLayout.SOUTH);

        return panel;
}
    
    private JPanel createCard(String title, JComponent content) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.LIGHT_GRAY),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setForeground(new Color(44, 62, 80));
        card.add(titleLabel, BorderLayout.NORTH);
        
        card.add(content, BorderLayout.CENTER);
        return card;
    }
    
    private JComponent createWelcomeContent() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JTextArea welcomeText = new JTextArea(
            "Great work! You're making excellent progress in your learning journey. " +
            "Here's your current status:"
        );
        welcomeText.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        welcomeText.setLineWrap(true);
        welcomeText.setWrapStyleWord(true);
        welcomeText.setEditable(false);
        welcomeText.setBackground(Color.WHITE);
        
        JPanel statsPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        statsPanel.setBackground(Color.WHITE);
        
        String[] stats = {"⏱ 24h 30m", "✅ 8/12 courses", "📊 84% avg"};
        for (String stat : stats) {
            JLabel statLabel = new JLabel(stat, SwingConstants.CENTER);
            statLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
            statsPanel.add(statLabel);
        }
        
        panel.add(welcomeText, BorderLayout.NORTH);
        panel.add(statsPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JComponent createMetricsContent() {
        JPanel panel = new JPanel(new GridLayout(1, 3, 15, 0));
        panel.setBackground(Color.WHITE);
        
        Object[][] metrics = {
            {"Learning Time", "24h 30m", "▲ 15%", Color.BLUE},
            {"Completion Rate", "67%", "▲ 8%", Color.GREEN},
            {"Performance Score", "84%", "▲ 5%", new Color(155, 89, 182)}
        };
        
        for (Object[] metric : metrics) {
            JPanel metricPanel = new JPanel();
            metricPanel.setLayout(new BoxLayout(metricPanel, BoxLayout.Y_AXIS));
            metricPanel.setBackground(Color.WHITE);
            metricPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            metricPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            
            JLabel nameLabel = new JLabel((String) metric[0]);
            nameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            
            JLabel valueLabel = new JLabel((String) metric[1]);
            valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
            valueLabel.setForeground((Color)metric[3]);
            valueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            
            JLabel changeLabel = new JLabel((String) metric[2]);
            changeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
            changeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            
            metricPanel.add(nameLabel);
            metricPanel.add(Box.createVerticalStrut(5));
            metricPanel.add(valueLabel);
            metricPanel.add(Box.createVerticalStrut(5));
            metricPanel.add(changeLabel);
            
            panel.add(metricPanel);
        }
        
        return panel;
    }
    
    private JComponent createProgressContent() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int[] hours = {2, 3, 4, 5, 6, 2, 1};
        
        for (int i = 0; i < days.length; i++) {
            JPanel dayPanel = new JPanel(new BorderLayout());
            dayPanel.setBackground(Color.WHITE);
            
            JLabel dayLabel = new JLabel(days[i] + ":");
            dayLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            dayLabel.setPreferredSize(new Dimension(40, 20));
            
            JProgressBar bar = new JProgressBar(0, 10);
            bar.setValue(hours[i]);
            bar.setString(hours[i] + "h");
            bar.setStringPainted(true);
            bar.setForeground(new Color(52, 152, 219));
            
            dayPanel.add(dayLabel, BorderLayout.WEST);
            dayPanel.add(bar, BorderLayout.CENTER);
            
            panel.add(dayPanel);
            panel.add(Box.createVerticalStrut(5));
        }
        
        JLabel totalLabel = new JLabel("Total: 22h this week ▲ 20% from last week");
        totalLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        totalLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        panel.add(Box.createVerticalStrut(10));
        panel.add(totalLabel);
        
        return panel;
    }
    
    private JComponent createSkillsContent() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        
        String[] skills = {"Java Programming", "Communication", "Leadership", "Problem Solving", "Project Management"};
        int[] levels = {85, 65, 45, 75, 35};
        
        for (int i = 0; i < skills.length; i++) {
            JPanel skillPanel = new JPanel(new BorderLayout());
            skillPanel.setBackground(Color.WHITE);
            
            JLabel skillLabel = new JLabel(skills[i]);
            skillLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            
            JProgressBar bar = new JProgressBar(0, 100);
            bar.setValue(levels[i]);
            bar.setString(levels[i] + "%");
            bar.setStringPainted(true);
            bar.setForeground(new Color(39, 174, 96));
            
            String levelText = "";
            if (levels[i] >= 70) levelText = "Advanced";
            else if (levels[i] >= 40) levelText = "Intermediate";
            else levelText = "Beginner";
            
            JLabel levelLabel = new JLabel(levelText);
            levelLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
            levelLabel.setPreferredSize(new Dimension(80, 20));
            
            skillPanel.add(skillLabel, BorderLayout.WEST);
            skillPanel.add(bar, BorderLayout.CENTER);
            skillPanel.add(levelLabel, BorderLayout.EAST);
            
            panel.add(skillPanel);
            panel.add(Box.createVerticalStrut(8));
        }
        
        return panel;
    }
    
    private JComponent createCoursesContent() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        
        String[] courses = {"Java Basics", "Advanced Java", "Spring Framework", "Microservices", "DevOps"};
        int[] progress = {100, 85, 65, 15, 25};
        
        for (int i = 0; i < courses.length; i++) {
            JPanel coursePanel = new JPanel(new BorderLayout());
            coursePanel.setBackground(Color.WHITE);
            
            JLabel courseLabel = new JLabel(courses[i]);
            courseLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            
            JProgressBar bar = new JProgressBar(0, 100);
            bar.setValue(progress[i]);
            bar.setString(progress[i] + "%");
            bar.setStringPainted(true);
            bar.setForeground(new Color(39, 174, 96));
            
            String status = progress[i] == 100 ? "✅" : "▶";
            JLabel statusLabel = new JLabel(status);
            
            coursePanel.add(courseLabel, BorderLayout.WEST);
            coursePanel.add(bar, BorderLayout.CENTER);
            coursePanel.add(statusLabel, BorderLayout.EAST);
            
            panel.add(coursePanel);
            panel.add(Box.createVerticalStrut(8));
        }
        
        return panel;
    }
}
