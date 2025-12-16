package project_group;

import java.awt.*;
import javax.swing.*;

public class DashboardPanels extends JPanel {
    
    // Constructor
    public DashboardPanels() {
        initComponents();
        
    }

    private void initComponents() {
    setLayout(new BorderLayout());
    setBackground(new Color(245, 245, 245));
    
    // Create main panel that will hold ALL cards
    JPanel cardsContainer = new JPanel();
    cardsContainer.setLayout(new BoxLayout(cardsContainer, BoxLayout.Y_AXIS));
    cardsContainer.setBackground(new Color(245, 245, 245));
    
    // Create a panel for the 2x3 grid of cards
    JPanel gridPanel = new JPanel(new GridLayout(2, 3, 15, 15));
    gridPanel.setBackground(new Color(245, 245, 245));
    gridPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    
    // Create 6 cards - REMOVE ALL setMaximumSize calls!
    gridPanel.add(createCard("Your Learning Path", createLearningPathContent()));
    gridPanel.add(createCard("Recommended for You", createRecommendationsContent()));
    gridPanel.add(createCard("Recent Activity", createRecentActivityContent()));
    gridPanel.add(createCard("Your Achievements", createAchievementsContent()));
    gridPanel.add(createCard("Team Overview", createTeamOverviewContent()));
    gridPanel.add(createCard("Quick Actions", createQuickActionsContent()));
    
    // Add grid panel to container
    cardsContainer.add(gridPanel);
    
    // Add flexible space at bottom
    cardsContainer.add(Box.createVerticalGlue());
    
    // Wrap in JScrollPane EXACTLY like SettingsPanel
    JScrollPane scrollPane = new JScrollPane(cardsContainer);
    scrollPane.setBorder(null);
    scrollPane.getVerticalScrollBar().setUnitIncrement(16);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    add(scrollPane, BorderLayout.CENTER);
}
    
//    private void initComponents() {
//        setLayout(new BorderLayout());
//        setBackground(new Color(245, 245, 245));
//        
//        // Main content panel with 2x3 grid of cards
//        JPanel mainPanel = new JPanel(new GridLayout(2, 3, 15, 15));
//        mainPanel.setBackground(new Color(245, 245, 245));
//        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
//        
//        // Create 6 cards
//        mainPanel.add(createCard("Your Learning Path", createLearningPathContent()));
//        mainPanel.add(createCard("Recommended for You", createRecommendationsContent()));
//        mainPanel.add(createCard("Recent Activity", createRecentActivityContent()));
//        mainPanel.add(createCard("Your Achievements", createAchievementsContent()));
//        mainPanel.add(createCard("Team Overview", createTeamOverviewContent()));
//        mainPanel.add(createCard("Quick Actions", createQuickActionsContent()));
//        
//        
//        
//        JScrollPane scrollPane = new JScrollPane(mainPanel);
//        scrollPane.setBorder(null); // Remove the default border
//        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Smoother scrolling
//        
//        add(scrollPane, BorderLayout.CENTER);
//    }
    
    private JPanel createCard(String title, JComponent content) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.LIGHT_GRAY),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setForeground(new Color(44, 62, 80));
        card.add(titleLabel, BorderLayout.NORTH);
        
        card.add(content, BorderLayout.CENTER);
        return card;
    }
    
    private JComponent createLearningPathContent() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(65);
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(39, 174, 96));
        progressBar.setString("65% Complete");
        
        JLabel currentModule = new JLabel("Current Module: Advanced Communication Skills");
        currentModule.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        JButton resumeButton = new JButton("Resume Learning");
        resumeButton.setBackground(new Color(52, 152, 219));
        resumeButton.setForeground(Color.WHITE);
        resumeButton.setFocusPainted(false);
        
        panel.add(progressBar, BorderLayout.NORTH);
        panel.add(currentModule, BorderLayout.CENTER);
        panel.add(resumeButton, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JComponent createRecommendationsContent() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        String[] recommendations = {
            "Leadership Fundamentals (High Priority)",
            "Python for Data Analysis (Medium Priority)",
            "Project Management (Related to your role)"
        };
        
        for (String rec : recommendations) {
            JLabel label = new JLabel("• " + rec);
            label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            if (rec.contains("High Priority")) {
                label.setForeground(new Color(231, 76, 60));
            } else if (rec.contains("Medium Priority")) {
                label.setForeground(new Color(243, 156, 18));
            } else {
                label.setForeground(new Color(52, 152, 219));
            }
            panel.add(label);
            panel.add(Box.createVerticalStrut(5));
        }
        
        return panel;
    }
    
    private JComponent createRecentActivityContent() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        String[] activities = {
            "✓ Completed: Workplace Ethics Quiz - Score 95%",
            "▶ Started: Compliance Training Module",
            "⚠ Overdue: Security Awareness - 2 days late"
        };
        
        for (String activity : activities) {
            JLabel label = new JLabel(activity);
            label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            if (activity.contains("Overdue")) {
                label.setForeground(new Color(231, 76, 60));
                label.setFont(new Font("Segoe UI", Font.BOLD, 12));
            } else if (activity.contains("Started")) {
                label.setForeground(new Color(52, 152, 219));
            }
            panel.add(label);
            panel.add(Box.createVerticalStrut(5));
        }
        
        return panel;
    }
    
    private JComponent createAchievementsContent() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        
        JLabel badges = new JLabel("🏆 3 Badges Earned");
        badges.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        JLabel points = new JLabel("⭐ Points: 1,250");
        points.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        JLabel rank = new JLabel("📊 Rank: 15th on Leaderboard");
        rank.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        content.add(badges);
        content.add(Box.createVerticalStrut(5));
        content.add(points);
        content.add(Box.createVerticalStrut(5));
        content.add(rank);
        
        panel.add(content, BorderLayout.CENTER);
        return panel;
    }
    
    private JComponent createTeamOverviewContent() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        
        JLabel completion = new JLabel("Department Completion: 78%");
        completion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        JProgressBar teamProgress = new JProgressBar(0, 100);
        teamProgress.setValue(78);
        teamProgress.setForeground(new Color(39, 174, 96));
        teamProgress.setMaximumSize(new Dimension(Integer.MAX_VALUE, 10));
        
        JLabel avgScore = new JLabel("Average Quiz Score: 84%");
        avgScore.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        content.add(completion);
        content.add(Box.createVerticalStrut(5));
        content.add(teamProgress);
        content.add(Box.createVerticalStrut(10));
        content.add(avgScore);
        
        panel.add(content, BorderLayout.CENTER);
        return panel;
    }
    
    private JComponent createQuickActionsContent() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JButton findModule = new JButton("🔍 Find a Module");
        findModule.setBackground(new Color(52, 152, 219));
        findModule.setForeground(Color.WHITE);
        findModule.setAlignmentX(Component.LEFT_ALIGNMENT);
        findModule.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        
        JButton setGoal = new JButton("🎯 Set a Goal");
        setGoal.setBackground(new Color(39, 174, 96));
        setGoal.setForeground(Color.WHITE);
        setGoal.setAlignmentX(Component.LEFT_ALIGNMENT);
        setGoal.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        
        panel.add(findModule);
        panel.add(Box.createVerticalStrut(10));
        panel.add(setGoal);
        
        return panel;
    }
}
