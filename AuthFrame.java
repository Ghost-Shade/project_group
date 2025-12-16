package project_group;

import java.awt.*;
import javax.swing.*;

public class AuthFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private LoginPanel loginPanel;
    private SignupPanel signupPanel;
    
    public AuthFrame() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("ETES - Employee Training System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        // Set window size
        setSize(500, 700);
        setLocationRelativeTo(null); // Center on screen
        
        // Main panel with CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(new Color(0, 102, 255));
        
        // Create panels
        loginPanel = new LoginPanel();
        signupPanel = new SignupPanel();
        
        // Set up navigation callbacks
        loginPanel.setOnLoginSuccess(() -> openMainApplication());
        loginPanel.setOnShowSignup(() -> switchToSignup());
        
        signupPanel.setOnSignupSuccess(() -> switchToLogin());
        signupPanel.setOnShowLogin(() -> switchToLogin());
        
        // Add panels to CardLayout
        mainPanel.add(loginPanel, "Login");
        mainPanel.add(signupPanel, "Signup");
        
        add(mainPanel);
        
        // Start with login panel
        cardLayout.show(mainPanel, "Login");
    }
    
    private void switchToSignup() {
        cardLayout.show(mainPanel, "Signup");
    }
    
    private void switchToLogin() {
        cardLayout.show(mainPanel, "Login");
    }
    
    private void openMainApplication() {
        // Open the main application
        Main_Page mainPage = new Main_Page();
        mainPage.setVisible(true);
        
        // Close this authentication frame
        dispose();
    }
    
    public static void main(String[] args) {
        // Set system look and feel
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
//            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        // Run the authentication frame
        SwingUtilities.invokeLater(() -> {
            new AuthFrame().setVisible(true);
        });
    }
}
