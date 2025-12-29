
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

public class LoginPanel extends JPanel {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnSignup;
    private Runnable onLoginSuccess;
    private Runnable onShowSignup;
    
    public LoginPanel() {
        initComponents();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(new Color(0, 102, 255));
        
        // Main container
        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
        mainContainer.setBackground(new Color(0, 102, 255));
        mainContainer.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        
        // Logo/Title
        JLabel lblLogo = new JLabel("🏢 ETES");
        lblLogo.setFont(new Font("Segoe UI", Font.BOLD, 36));
        lblLogo.setForeground(Color.WHITE);
        lblLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel lblSubtitle = new JLabel("Employee Training & Education System");
        lblSubtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitle.setForeground(new Color(200, 230, 255));
        lblSubtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Login Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(new Color(255, 255, 255, 200)); 
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        formPanel.setMaximumSize(new Dimension(400, 350));
        
        JLabel lblTitle = new JLabel("Login to Your Account");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setForeground(new Color(0, 102, 255));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Username field
        JPanel usernamePanel = new JPanel(new BorderLayout(10, 0));
        usernamePanel.setBackground(new Color(255, 255, 255, 0)); 
        JLabel lblUsername = new JLabel("👤 Username");
        lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtUsername = new JTextField();
        txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtUsername.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        
        usernamePanel.add(lblUsername, BorderLayout.NORTH);
        usernamePanel.add(txtUsername, BorderLayout.CENTER);
        
        // Password field
        JPanel passwordPanel = new JPanel(new BorderLayout(10, 0));
        passwordPanel.setBackground(new Color(255, 255, 255, 0));
        passwordPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        
        JLabel lblPassword = new JLabel("🔒 Password");
        lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPassword.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        
        passwordPanel.add(lblPassword, BorderLayout.NORTH);
        passwordPanel.add(txtPassword, BorderLayout.CENTER);
        
        // Login button
        btnLogin = new JButton("Login");
        btnLogin.setBackground(new Color(0, 102, 102));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLogin.setBorder(BorderFactory.createEmptyBorder(12, 0, 12, 0));
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogin.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        btnLogin.addActionListener(e -> performLogin());
        
        // Forgot password
        JLabel lblForgot = new JLabel("Forgot Password?");
        lblForgot.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblForgot.setForeground(new Color(0, 102, 255));
        lblForgot.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblForgot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        // Signup link
        JPanel signupPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        signupPanel.setBackground(new Color(255, 255, 255, 0));
        signupPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        
        JLabel lblNoAccount = new JLabel("Don't have an account?");
        lblNoAccount.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        btnSignup = new JButton("Sign Up");
        btnSignup.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnSignup.setForeground(new Color(0, 102, 255));
        btnSignup.setBorderPainted(false);
        btnSignup.setContentAreaFilled(false);
        btnSignup.addActionListener(e -> {
            if (onShowSignup != null) onShowSignup.run();
        });
        
        signupPanel.add(lblNoAccount);
        signupPanel.add(btnSignup);
        
        // Add components to form panel
        formPanel.add(lblTitle);
        formPanel.add(Box.createVerticalStrut(25));
        formPanel.add(usernamePanel);
        formPanel.add(passwordPanel);
        formPanel.add(Box.createVerticalStrut(25));
        formPanel.add(btnLogin);
        formPanel.add(Box.createVerticalStrut(15));
        formPanel.add(lblForgot);
        formPanel.add(signupPanel);
        
        // Add everything to main container
        mainContainer.add(lblLogo);
        mainContainer.add(Box.createVerticalStrut(10));
        mainContainer.add(lblSubtitle);
        mainContainer.add(Box.createVerticalStrut(40));
        mainContainer.add(formPanel);
        
        add(mainContainer, BorderLayout.CENTER);
    }
    
    private void performLogin() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());
        
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please enter username and password", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        AuthDBManager auth = new AuthDBManager();
        AuthDBManager.User user = auth.login(username, password);
        
        if (user != null) {
            if (onLoginSuccess != null) {
                onLoginSuccess.run();
            }
        } else {
            JOptionPane.showMessageDialog(this, 
                "Invalid username or password", 
                "Login Failed", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void setOnLoginSuccess(Runnable onLoginSuccess) {
        this.onLoginSuccess = onLoginSuccess;
    }
    
    public void setOnShowSignup(Runnable onShowSignup) {
        this.onShowSignup = onShowSignup;
    }
}
