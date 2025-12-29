
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
        
        
        setSize(500, 800);
        setLocationRelativeTo(null);
        
        // Main panel with CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(new Color(0, 102, 255));
        
        
        loginPanel = new LoginPanel();
        signupPanel = new SignupPanel();
        
        // navigation callbacks
        loginPanel.setOnLoginSuccess(() -> openMainApplication());
        loginPanel.setOnShowSignup(() -> switchToSignup());
        
        signupPanel.setOnSignupSuccess(() -> switchToLogin());
        signupPanel.setOnShowLogin(() -> switchToLogin());
        
        // Add panels to CardLayout
        mainPanel.add(loginPanel, "Login");
        mainPanel.add(signupPanel, "Signup");
        
        add(mainPanel);
        
        // Start with login panel always
        
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
        // Set system look and feel default Genrrated code by Netbeans
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
