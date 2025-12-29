
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

public class SettingsPanels extends JPanel {
    
    public SettingsPanels() {
        initComponents();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 245, 245));
        
        //  header
        JPanel headerPanel = createHeader();
        
        //  main content
        JPanel mainContent = createMainContent();
        JScrollPane scrollPane = new JScrollPane(mainContent);
        
        add(headerPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(245, 245, 245));
        header.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JLabel titleLabel = new JLabel("⚙️ Settings");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setForeground(new Color(44, 62, 80));
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonPanel.setBackground(new Color(245, 245, 245));
        
        JButton saveBtn = new JButton("Save Changes");
        saveBtn.setBackground(new Color(39, 174, 96));
        saveBtn.setForeground(Color.WHITE);
        
        JButton resetBtn = new JButton("Reset to Defaults");
        resetBtn.setBackground(new Color(149, 165, 166));
        resetBtn.setForeground(Color.WHITE);
        
        buttonPanel.add(saveBtn);
        buttonPanel.add(resetBtn);
        
        header.add(titleLabel, BorderLayout.WEST);
        header.add(buttonPanel, BorderLayout.EAST);
        
        return header;
    }
    
    private JPanel createMainContent() {
        JPanel mainContent = new JPanel();
        mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
        mainContent.setBackground(new Color(245, 245, 245));
        mainContent.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));
        
        // Adding settings cards
        mainContent.add(createProfileCard());
        mainContent.add(Box.createVerticalStrut(15));
        mainContent.add(createSecurityCard());
        mainContent.add(Box.createVerticalStrut(15));
        mainContent.add(createNotificationsCard());
        mainContent.add(Box.createVerticalStrut(15));
        mainContent.add(createLearningPrefsCard());
        mainContent.add(Box.createVerticalStrut(15));
        mainContent.add(createDisplayCard());
        mainContent.add(Box.createVerticalStrut(15));
        mainContent.add(createPrivacyCard());
        mainContent.add(Box.createVerticalStrut(15));
        mainContent.add(createSystemCard());
        
        return mainContent;
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
    
    private JPanel createProfileCard() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBackground(Color.WHITE);
        
        // Form fields
        panel.add(new JLabel("Full Name:"));
        JTextField nameField = new JTextField("John Doe");
        panel.add(nameField);
        
        panel.add(new JLabel("Email:"));
        JTextField emailField = new JTextField("john.doe@company.com");
        panel.add(emailField);
        
        panel.add(new JLabel("Employee ID:"));
        JTextField idField = new JTextField("EMP-12345");
        panel.add(idField);
        
        panel.add(new JLabel("Department:"));
        JComboBox<String> deptCombo = new JComboBox<>(new String[]{"Engineering", "Marketing", "Sales", "HR", "Finance"});
        panel.add(deptCombo);
        
        panel.add(new JLabel("Job Title:"));
        JTextField titleField = new JTextField("Software Developer");
        panel.add(titleField);
        
        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.WHITE);
        JButton uploadBtn = new JButton("Upload Profile Picture");
        JButton removeBtn = new JButton("Remove Current");
        buttonPanel.add(uploadBtn);
        buttonPanel.add(removeBtn);
        
        JPanel updatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        updatePanel.setBackground(Color.WHITE);
        JButton updateBtn = new JButton("Update Profile");
        updateBtn.setBackground(new Color(52, 152, 219));
        updateBtn.setForeground(Color.WHITE);
        updatePanel.add(updateBtn);
        
        JPanel container = new JPanel(new BorderLayout());
        container.setBackground(Color.WHITE);
        container.add(panel, BorderLayout.CENTER);
        container.add(buttonPanel, BorderLayout.SOUTH);
        container.add(updatePanel, BorderLayout.AFTER_LAST_LINE);
        
        return createCard("👤 Profile Information", container);
    }
    
    private JPanel createSecurityCard() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        
        // Current password
        JPanel currentPanel = new JPanel(new BorderLayout());
        currentPanel.setBackground(Color.WHITE);
        currentPanel.add(new JLabel("Current Password:"), BorderLayout.WEST);
        JPasswordField currentPass = new JPasswordField();
        currentPass.setPreferredSize(new Dimension(200, 25));
        currentPanel.add(currentPass, BorderLayout.EAST);
        
        // New password
        JPanel newPanel = new JPanel(new BorderLayout());
        newPanel.setBackground(Color.WHITE);
        newPanel.add(new JLabel("New Password:"), BorderLayout.WEST);
        JPasswordField newPass = new JPasswordField();
        newPass.setPreferredSize(new Dimension(200, 25));
        newPanel.add(newPass, BorderLayout.EAST);
        
        // Confirm password
        JPanel confirmPanel = new JPanel(new BorderLayout());
        confirmPanel.setBackground(Color.WHITE);
        confirmPanel.add(new JLabel("Confirm Password:"), BorderLayout.WEST);
        JPasswordField confirmPass = new JPasswordField();
        confirmPass.setPreferredSize(new Dimension(200, 25));
        confirmPanel.add(confirmPass, BorderLayout.EAST);
        
        // Password strength
        JProgressBar strengthBar = new JProgressBar(0, 100);
        strengthBar.setValue(75);
        strengthBar.setString("Strong");
        strengthBar.setStringPainted(true);
        strengthBar.setForeground(new Color(39, 174, 96));
        
        // Change password button
        JButton changePassBtn = new JButton("Change Password");
        changePassBtn.setBackground(new Color(52, 152, 219));
        changePassBtn.setForeground(Color.WHITE);
        changePassBtn.setMaximumSize(new Dimension(150, 35));
        changePassBtn.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // 2FA
        JPanel twoFAPanel = new JPanel(new BorderLayout());
        twoFAPanel.setBackground(Color.WHITE);
        twoFAPanel.add(new JLabel("Two-Factor Authentication:"), BorderLayout.WEST);
        JComboBox<String> twoFACombo = new JComboBox<>(new String[]{"Enable 2FA", "Disable 2FA"});
        twoFACombo.setPreferredSize(new Dimension(150, 25));
        twoFAPanel.add(twoFACombo, BorderLayout.EAST);
        
        JCheckBox require2FA = new JCheckBox("Require 2FA for login");
        
        panel.add(currentPanel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(newPanel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(confirmPanel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(strengthBar);
        panel.add(Box.createVerticalStrut(15));
        panel.add(changePassBtn);
        panel.add(Box.createVerticalStrut(15));
        panel.add(twoFAPanel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(require2FA);
        
        return createCard("🔒 Account Security", panel);
    }
    
    private JPanel createNotificationsCard() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        
        JLabel emailLabel = new JLabel("Email Notifications:");
        emailLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        JCheckBox email1 = new JCheckBox("Course assignments and updates", true);
        JCheckBox email2 = new JCheckBox("Deadline reminders", true);
        JCheckBox email3 = new JCheckBox("Weekly progress reports");
        JCheckBox email4 = new JCheckBox("New course announcements");
        
        JLabel pushLabel = new JLabel("Push Notifications:");
        pushLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        pushLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        
        JCheckBox push1 = new JCheckBox("Overdue assignments", true);
        JCheckBox push2 = new JCheckBox("Achievement unlocks", true);
        JCheckBox push3 = new JCheckBox("Leaderboard updates");
        
        JPanel frequencyPanel = new JPanel(new BorderLayout());
        frequencyPanel.setBackground(Color.WHITE);
        frequencyPanel.add(new JLabel("Frequency:"), BorderLayout.WEST);
        JComboBox<String> freqCombo = new JComboBox<>(new String[]{"Daily digest", "Weekly summary", "Real-time"});
        freqCombo.setPreferredSize(new Dimension(150, 25));
        frequencyPanel.add(freqCombo, BorderLayout.EAST);
        
        panel.add(emailLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(email1);
        panel.add(email2);
        panel.add(email3);
        panel.add(email4);
        panel.add(pushLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(push1);
        panel.add(push2);
        panel.add(push3);
        panel.add(Box.createVerticalStrut(15));
        panel.add(frequencyPanel);
        
        return createCard("📢 Notification Settings", panel);
    }
    
    private JPanel createLearningPrefsCard() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        
        JPanel defaultViewPanel = new JPanel(new BorderLayout());
        defaultViewPanel.setBackground(Color.WHITE);
        defaultViewPanel.add(new JLabel("Default View:"), BorderLayout.WEST);
        JComboBox<String> viewCombo = new JComboBox<>(new String[]{"Dashboard", "Learning Modules", "Progress"});
        viewCombo.setPreferredSize(new Dimension(150, 25));
        defaultViewPanel.add(viewCombo, BorderLayout.EAST);
        
        JPanel autoPlayPanel = new JPanel(new BorderLayout());
        autoPlayPanel.setBackground(Color.WHITE);
        autoPlayPanel.add(new JLabel("Auto-play videos:"), BorderLayout.WEST);
        JComboBox<String> autoPlayCombo = new JComboBox<>(new String[]{"No", "Yes"});
        autoPlayCombo.setPreferredSize(new Dimension(150, 25));
        autoPlayPanel.add(autoPlayCombo, BorderLayout.EAST);
        
        JPanel offlinePanel = new JPanel(new BorderLayout());
        offlinePanel.setBackground(Color.WHITE);
        offlinePanel.add(new JLabel("Download for offline use:"), BorderLayout.WEST);
        JComboBox<String> offlineCombo = new JComboBox<>(new String[]{"Yes", "No"});
        offlineCombo.setPreferredSize(new Dimension(150, 25));
        offlinePanel.add(offlineCombo, BorderLayout.EAST);
        
        JPanel goalPanel = new JPanel(new BorderLayout());
        goalPanel.setBackground(Color.WHITE);
        goalPanel.add(new JLabel("Daily Learning Goal:"), BorderLayout.WEST);
        JComboBox<String> goalCombo = new JComboBox<>(new String[]{"30 minutes", "60 minutes", "90 minutes", "2 hours"});
        goalCombo.setPreferredSize(new Dimension(150, 25));
        goalPanel.add(goalCombo, BorderLayout.EAST);
        
        JPanel targetPanel = new JPanel(new BorderLayout());
        targetPanel.setBackground(Color.WHITE);
        targetPanel.add(new JLabel("Weekly Target:"), BorderLayout.WEST);
        JComboBox<String> targetCombo = new JComboBox<>(new String[]{"3 hours", "5 hours", "7 hours", "10 hours"});
        targetCombo.setPreferredSize(new Dimension(150, 25));
        targetPanel.add(targetCombo, BorderLayout.EAST);
        
        JLabel contentLabel = new JLabel("Preferred Content Types:");
        contentLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        contentLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        
        JCheckBox type1 = new JCheckBox("Video lessons", true);
        JCheckBox type2 = new JCheckBox("Text-based", true);
        JCheckBox type3 = new JCheckBox("Interactive", true);
        JCheckBox type4 = new JCheckBox("Audio-only");
        
        panel.add(defaultViewPanel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(autoPlayPanel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(offlinePanel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(goalPanel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(targetPanel);
        panel.add(Box.createVerticalStrut(15));
        panel.add(contentLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(type1);
        panel.add(type2);
        panel.add(type3);
        panel.add(type4);
        
        return createCard("🎯 Learning Preferences", panel);
    }
    
    private JPanel createDisplayCard() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        
        JPanel themePanel = new JPanel(new BorderLayout());
        themePanel.setBackground(Color.WHITE);
        themePanel.add(new JLabel("Theme:"), BorderLayout.WEST);
        JComboBox<String> themeCombo = new JComboBox<>(new String[]{"Light", "Dark", "System Default"});
        themeCombo.setPreferredSize(new Dimension(150, 25));
        themePanel.add(themeCombo, BorderLayout.EAST);
        
        JPanel fontPanel = new JPanel(new BorderLayout());
        fontPanel.setBackground(Color.WHITE);
        fontPanel.add(new JLabel("Font Size:"), BorderLayout.WEST);
        JComboBox<String> fontCombo = new JComboBox<>(new String[]{"Small", "Medium", "Large"});
        fontCombo.setPreferredSize(new Dimension(150, 25));
        fontPanel.add(fontCombo, BorderLayout.EAST);
        
        JPanel langPanel = new JPanel(new BorderLayout());
        langPanel.setBackground(Color.WHITE);
        langPanel.add(new JLabel("Language:"), BorderLayout.WEST);
        JComboBox<String> langCombo = new JComboBox<>(new String[]{"English", "Spanish", "French", "German"});
        langCombo.setPreferredSize(new Dimension(150, 25));
        langPanel.add(langCombo, BorderLayout.EAST);
        
        JLabel optionsLabel = new JLabel("Display Options:");
        optionsLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        optionsLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        
        JCheckBox option1 = new JCheckBox("Enable high contrast mode");
        JCheckBox option2 = new JCheckBox("Reduce animations");
        JCheckBox option3 = new JCheckBox("Show detailed progress metrics");
        
        JLabel previewLabel = new JLabel("Preview:");
        previewLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        previewLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        
        JTextArea previewArea = new JTextArea("Sample text in selected theme");
        previewArea.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        previewArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        previewArea.setEditable(false);
        previewArea.setBackground(new Color(240, 240, 240));
        
        panel.add(themePanel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(fontPanel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(langPanel);
        panel.add(Box.createVerticalStrut(15));
        panel.add(optionsLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(option1);
        panel.add(option2);
        panel.add(option3);
        panel.add(Box.createVerticalStrut(15));
        panel.add(previewLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(previewArea);
        
        return createCard("🎨 Display & Theme", panel);
    }
    
    private JPanel createPrivacyCard() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        
        JPanel visibilityPanel = new JPanel(new BorderLayout());
        visibilityPanel.setBackground(Color.WHITE);
        visibilityPanel.add(new JLabel("Profile Visibility:"), BorderLayout.WEST);
        JComboBox<String> visibilityCombo = new JComboBox<>(new String[]{"Team Members", "Managers Only", "Private"});
        visibilityCombo.setPreferredSize(new Dimension(150, 25));
        visibilityPanel.add(visibilityCombo, BorderLayout.EAST);
        
        JCheckBox showProgress = new JCheckBox("Show my progress to others");
        JCheckBox includeLeaderboard = new JCheckBox("Include me in leaderboard", true);
        JCheckBox allowManagers = new JCheckBox("Allow managers to see my detailed progress", true);
        
        JLabel dataLabel = new JLabel("Data Retention:");
        dataLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        dataLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        
        JCheckBox autoDelete = new JCheckBox("Auto-delete completed courses after 1 year");
        JCheckBox exportMonthly = new JCheckBox("Export my data monthly");
        
        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        actionPanel.setBackground(Color.WHITE);
        JButton exportBtn = new JButton("Export All My Data");
        exportBtn.setBackground(new Color(52, 152, 219));
        exportBtn.setForeground(Color.WHITE);
        
        JButton deleteBtn = new JButton("Delete Learning History");
        deleteBtn.setBackground(new Color(231, 76, 60));
        deleteBtn.setForeground(Color.WHITE);
        
        actionPanel.add(exportBtn);
        actionPanel.add(deleteBtn);
        
        panel.add(visibilityPanel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(showProgress);
        panel.add(includeLeaderboard);
        panel.add(allowManagers);
        panel.add(Box.createVerticalStrut(15));
        panel.add(dataLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(autoDelete);
        panel.add(exportMonthly);
        panel.add(Box.createVerticalStrut(15));
        panel.add(actionPanel);
        
        return createCard("🔐 Privacy & Data", panel);
    }
    
    private JPanel createSystemCard() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        
        JLabel versionLabel = new JLabel("ETES Version: 2.1.0");
        JLabel updateLabel = new JLabel("Last Updated: October 15, 2023");
        JLabel dataLabel = new JLabel("Data Usage: 245 MB");
        
        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        actionPanel.setBackground(Color.WHITE);
        JButton checkUpdateBtn = new JButton("Check for Updates");
        JButton clearCacheBtn = new JButton("Clear Cache");
        checkUpdateBtn.setBackground(new Color(52, 152, 219));
        checkUpdateBtn.setForeground(Color.WHITE);
        clearCacheBtn.setBackground(new Color(149, 165, 166));
        clearCacheBtn.setForeground(Color.WHITE);
        actionPanel.add(checkUpdateBtn);
        actionPanel.add(clearCacheBtn);
        
        JPanel linkPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        linkPanel.setBackground(Color.WHITE);
        JButton termsBtn = new JButton("View Terms of Service");
        JButton privacyBtn = new JButton("Privacy Policy");
        JButton contactBtn = new JButton("Contact Support");
        JButton feedbackBtn = new JButton("Submit Feedback");
        
        termsBtn.setBorderPainted(false);
        privacyBtn.setBorderPainted(false);
        contactBtn.setBorderPainted(false);
        feedbackBtn.setBorderPainted(false);
        
        linkPanel.add(termsBtn);
        linkPanel.add(privacyBtn);
        linkPanel.add(contactBtn);
        linkPanel.add(feedbackBtn);
        
        JLabel copyrightLabel = new JLabel("© 2023 ETES - Employee Training & Education System");
        copyrightLabel.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        copyrightLabel.setForeground(Color.GRAY);
        copyrightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        panel.add(versionLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(updateLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(dataLabel);
        panel.add(Box.createVerticalStrut(15));
        panel.add(actionPanel);
        panel.add(Box.createVerticalStrut(15));
        panel.add(linkPanel);
        panel.add(Box.createVerticalStrut(15));
        panel.add(copyrightLabel);
        
        return createCard("ℹ️ System & About", panel);
    }
}