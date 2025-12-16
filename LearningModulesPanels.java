package project_group;

import java.awt.*;
import javax.swing.*;

public class LearningModulesPanels extends JPanel {
    private Main_Page mainPage;
    
    // Constructor
    public LearningModulesPanels() {
        initComponents();
    }
    
    
    private void initComponents() {
    setLayout(new BorderLayout());
    setBackground(new Color(245, 245, 245));
    
    // Header panel
    JPanel headerPanel = createHeaderPanel();
    
    // Main content panel - use BoxLayout like SettingsPanel
    JPanel mainContent = new JPanel();
    mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
    mainContent.setBackground(new Color(245, 245, 245));
    
    // Add modules
    ModuleCard[] modules = {
        new ModuleCard("Java Programming Fundamentals", 
                      "Learn core Java concepts including OOP, data structures, and basic algorithms.",
                      "Technical Skills", "Beginner", 3, 4.2, true),
        // ... add all modules
    };
    
    for (ModuleCard module : modules) {
        mainContent.add(module);
        mainContent.add(Box.createVerticalStrut(15));
    }
    
    // Add flexible space at bottom
    mainContent.add(Box.createVerticalGlue());
    
    // Wrap in JScrollPane EXACTLY like SettingsPanel
    JScrollPane scrollPane = new JScrollPane(mainContent);
    scrollPane.setBorder(null);
    scrollPane.getVerticalScrollBar().setUnitIncrement(16);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    add(headerPanel, BorderLayout.NORTH);
    add(scrollPane, BorderLayout.CENTER);
}

// setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
//    private void initComponents() {
//        setLayout(new BorderLayout());
//        setBackground(new Color(245, 245, 245));
//        
//        // Create header with search and filters
//        JPanel headerPanel = createHeaderPanel();
//        
//        // Create main content area with module cards
//        JPanel contentPanel = createContentPanel();
//        JScrollPane scrollPane = new JScrollPane(contentPanel);
//        scrollPane.setBorder(null);
//        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        
//        
//        add(headerPanel, BorderLayout.NORTH);
//        add(scrollPane, BorderLayout.CENTER);
//    }
    
    private JPanel createHeaderPanel() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(245, 245, 245));
        header.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Search field
        JTextField searchField = new JTextField("Search modules...");
        searchField.setPreferredSize(new Dimension(300, 30));
        
        // Filter panel
        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        filterPanel.setBackground(new Color(245, 245, 245));
        
        String[] categories = {"All Categories", "Technical Skills", "Leadership", "Communication"};
        String[] levels = {"All Levels", "Beginner", "Intermediate", "Advanced"};
        
        JComboBox<String> categoryCombo = new JComboBox<>(categories);
        JComboBox<String> levelCombo = new JComboBox<>(levels);
        
        filterPanel.add(new JLabel("Filter:"));
        filterPanel.add(categoryCombo);
        filterPanel.add(levelCombo);
        
        // Sort buttons
        JPanel sortPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        sortPanel.setBackground(new Color(245, 245, 245));
        
        JButton newestBtn = new JButton("Newest First");
        JButton popularBtn = new JButton("Most Popular");
        
        sortPanel.add(newestBtn);
        sortPanel.add(popularBtn);
        
        header.add(searchField, BorderLayout.WEST);
        header.add(filterPanel, BorderLayout.CENTER);
        header.add(sortPanel, BorderLayout.EAST);
        
        return header;
    }
    
    private JPanel createContentPanel() {
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(new Color(245, 245, 245));
        content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Create sample modules
        ModuleCard[] modules = {
            new ModuleCard("Java Programming Fundamentals", 
                          "Learn core Java concepts including OOP, data structures, and basic algorithms.",
                          "Technical Skills", "Beginner", 3, 4.2, true),
            new ModuleCard("Effective Communication", 
                          "Master professional communication skills for workplace success.",
                          "Communication", "Intermediate", 2, 4.5, false),
            new ModuleCard("Project Management Basics", 
                          "Essential project management principles and methodologies.",
                          "Leadership", "Beginner", 4, 4.0, true),
            new ModuleCard("Advanced Data Analysis", 
                          "Learn advanced techniques for data analysis and visualization.",
                          "Technical Skills", "Advanced", 5, 4.7, false),
            new ModuleCard("Team Leadership", 
                          "Develop leadership skills to manage and motivate teams effectively.",
                          "Leadership", "Intermediate", 3, 4.3, true)
        };
        
        for (ModuleCard module : modules) {
            content.add(module);
            content.add(Box.createVerticalStrut(15));
        }
        
        return content;
    }
    
    public void setMainPage(Main_Page mainPage) {
        this.mainPage = mainPage;
    }
    
    // Inner class for module cards
    private class ModuleCard extends JPanel {
        private JButton actionButton;
        
        public ModuleCard(String title, String description, String category, 
                         String level, int hours, double rating, boolean enrolled) {
            setLayout(new BorderLayout());
            setBackground(Color.WHITE);
            setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
            ));
            setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
            
            // Left side: Title and description
            JPanel leftPanel = new JPanel(new BorderLayout());
            leftPanel.setBackground(Color.WHITE);
            
            JLabel titleLabel = new JLabel(title);
            titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
            titleLabel.setForeground(new Color(44, 62, 80));
            
            JTextArea descArea = new JTextArea(description);
            descArea.setFont(new Font("Segoe UI", Font.PLAIN, 11));
            descArea.setForeground(new Color(127, 140, 141));
            descArea.setLineWrap(true);
            descArea.setWrapStyleWord(true);
            descArea.setEditable(false);
            descArea.setBackground(Color.WHITE);
            descArea.setRows(2);
            
            leftPanel.add(titleLabel, BorderLayout.NORTH);
            leftPanel.add(descArea, BorderLayout.CENTER);
            
            // Right side: Metadata and action button
            JPanel rightPanel = new JPanel();
            rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
            rightPanel.setBackground(Color.WHITE);
            
            // Rating
            JLabel ratingLabel = new JLabel("★ " + rating);
            ratingLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            
            // Duration and level
            JLabel metaLabel = new JLabel("⏱ " + hours + " hours | 📊 " + level);
            metaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
            
            // Action button
            if (enrolled) {
                actionButton = new JButton("▶ Resume");
                actionButton.setBackground(new Color(52, 152, 219));
            } else {
                actionButton = new JButton("Start");
                actionButton.setBackground(new Color(39, 174, 96));
            }
            actionButton.setForeground(Color.WHITE);
            actionButton.setFocusPainted(false);
            actionButton.setMaximumSize(new Dimension(100, 30));
            
            // Add action listener to button
            actionButton.addActionListener(e -> {
                if (mainPage != null) {
                    mainPage.showModulePlayer();
                }
            });
            
            rightPanel.add(ratingLabel);
            rightPanel.add(Box.createVerticalStrut(5));
            rightPanel.add(metaLabel);
            rightPanel.add(Box.createVerticalStrut(10));
            rightPanel.add(actionButton);
            rightPanel.add(Box.createVerticalGlue());
            
            add(leftPanel, BorderLayout.CENTER);
            add(rightPanel, BorderLayout.EAST);
        }
    }
}
