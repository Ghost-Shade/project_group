
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

public class SignupPanel extends JPanel {
    private JTextField txtFullName;
    private JTextField txtEmail;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JPasswordField txtConfirmPassword;
    private JButton btnSignup;
    private JButton btnLogin;
    private Runnable onSignupSuccess;
    private Runnable onShowLogin;
    
    public SignupPanel() {
        initComponents();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(new Color(0, 102, 255));
        
        // Main container
        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
        mainContainer.setBackground(new Color(0, 102, 255));
        mainContainer.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        
        // Logo/Title
        JLabel lblLogo = new JLabel("🏢 ETES");
        lblLogo.setFont(new Font("Segoe UI", Font.BOLD, 36));
        lblLogo.setForeground(Color.WHITE);
        lblLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel lblSubtitle = new JLabel("Create Your Account");
        lblSubtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitle.setForeground(new Color(200, 230, 255));
        lblSubtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Signup Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(new Color(255, 255, 255, 200));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        formPanel.setMaximumSize(new Dimension(450, 500));
        
        JLabel lblTitle = new JLabel("Join ETES Today");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setForeground(new Color(0, 102, 255));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //  form fields with labels
        JPanel[] fieldPanels = new JPanel[5];
        String[] labels = {"👤 Full Name", "📧 Email", "👤 Username", "🔒 Password", "🔒 Confirm Password"};
        JTextField[] fields = new JTextField[5];
        
        for (int i = 0; i < 5; i++) {
            fieldPanels[i] = new JPanel(new BorderLayout(10, 0));
            fieldPanels[i].setBackground(new Color(255, 255, 255, 0));
            if (i > 0) {
                fieldPanels[i].setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
            }
            
            JLabel label = new JLabel(labels[i]);
            label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            
            if (i == 3 || i == 4) {
                // Password fields
                JPasswordField passwordField = new JPasswordField();
                passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                passwordField.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(200, 200, 200)),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)
                ));
                
                if (i == 3) txtPassword = passwordField;
                else txtConfirmPassword = passwordField;
                
                fieldPanels[i].add(label, BorderLayout.NORTH);
                fieldPanels[i].add(passwordField, BorderLayout.CENTER);
            } else {
                // Text fields
                JTextField textField = new JTextField();
                textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                textField.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(200, 200, 200)),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)
                ));
                
                if (i == 0) txtFullName = textField;
                else if (i == 1) txtEmail = textField;
                else if (i == 2) txtUsername = textField;
                
                fieldPanels[i].add(label, BorderLayout.NORTH);
                fieldPanels[i].add(textField, BorderLayout.CENTER);
            }
        }
        
        // Signup button
        btnSignup = new JButton("Create Account");
        btnSignup.setBackground(new Color(0, 102, 102));
        btnSignup.setForeground(Color.WHITE);
        btnSignup.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnSignup.setBorder(BorderFactory.createEmptyBorder(12, 0, 12, 0));
        btnSignup.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSignup.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        btnSignup.addActionListener(e -> performSignup());
        
        // Login
        JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        loginPanel.setBackground(new Color(255, 255, 255, 0));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        
        JLabel lblHaveAccount = new JLabel("Already have an account?");
        lblHaveAccount.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnLogin.setForeground(new Color(0, 102, 255));
        btnLogin.setBorderPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.addActionListener(e -> {
            if (onShowLogin != null){ onShowLogin.run();}
        });
        
        loginPanel.add(lblHaveAccount);
        loginPanel.add(btnLogin);
        
        // Adding to form panel
        formPanel.add(lblTitle);
        formPanel.add(Box.createVerticalStrut(25));
        for (JPanel fieldPanel : fieldPanels) {
            formPanel.add(fieldPanel);
        }
        formPanel.add(Box.createVerticalStrut(25));
        formPanel.add(btnSignup);
        formPanel.add(loginPanel);
        
        // Adding to main container
        mainContainer.add(lblLogo);
        mainContainer.add(Box.createVerticalStrut(10));
        mainContainer.add(lblSubtitle);
        mainContainer.add(Box.createVerticalStrut(30));
        mainContainer.add(formPanel);
        
        add(mainContainer, BorderLayout.CENTER);
    }
    
    private void performSignup() {
        String fullName = txtFullName.getText().trim();
        String email = txtEmail.getText().trim();
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());
        String confirmPassword = new String(txtConfirmPassword.getPassword());
        
        // Validation
        if (fullName.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please fill in all fields", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, 
                "Passwords do not match", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (password.length() < 6) {
            JOptionPane.showMessageDialog(this, 
                "Password must be at least 6 characters long", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Email validation 
        if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(this, 
                "Please enter a valid email address", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        AuthDBManager auth = new AuthDBManager();
        boolean success = auth.register(username, password, fullName, email, "", "");
        
        if (success) {
            JOptionPane.showMessageDialog(this, 
                "Account created successfully! You can now login.", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
            
            if (onSignupSuccess != null) {
                onSignupSuccess.run();
            }
        } else {
            JOptionPane.showMessageDialog(this, 
                "Username already exists. Please choose another one.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void setOnSignupSuccess(Runnable onSignupSuccess) {
        this.onSignupSuccess = onSignupSuccess;
    }
    
    public void setOnShowLogin(Runnable onShowLogin) {
        this.onShowLogin = onShowLogin;
    }
}
