import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class LoginForm extends JFrame {

    // 1. Components
    private JLabel titleLabel = new JLabel("Login Page");
    private JLabel userLabel = new JLabel("Username:");
    private JTextField usernameField = new JTextField();
    private JLabel passLabel = new JLabel("Password:");
    private JPasswordField passwordField = new JPasswordField();
    private JCheckBox showPassword = new JCheckBox("Show Password"); 
    private JButton loginButton = new JButton("Login");
    private JButton closeButton = new JButton("Close"); 
    
    // Hardcoded credentials as per video logic (for demo)
    private final String CORRECT_USER = "Admin";
    private final String CORRECT_PASS = "12345";

    public LoginForm() {
        // --- UI SETUP (Design and Layout) ---
        setTitle("Login Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Manual Positioning / Null Layout
        setLayout(null); 
        
        // PDF Requirement: Set size and center the window
        setSize(400, 300); 
        setLocationRelativeTo(null); 
        
        // --- 2. Positioning Components (Bounds: x, y, width, height) ---
        
        // Title Label (PDF: Arial, Bold, 24px suggested)
        titleLabel.setBounds(100, 20, 200, 30);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); 
        add(titleLabel);

        // Username Label and Field
        userLabel.setBounds(50, 70, 80, 25);
        add(userLabel);
        usernameField.setBounds(140, 70, 200, 25); // PDF: ~200px width
        // usernameField.setToolTipText("Enter Username"); // Optional Tooltip removed for clean output
        add(usernameField);

        // Password Label and Field
        passLabel.setBounds(50, 110, 80, 25);
        add(passLabel);
        passwordField.setBounds(140, 110, 200, 25); // PDF: ~200px width
        // passwordField.setToolTipText("Enter Password"); // Optional Tooltip removed for clean output
        add(passwordField);

        // Show Password Checkbox (Video feature)
        showPassword.setBounds(140, 140, 150, 25);
        add(showPassword);
        
        // Buttons
        loginButton.setBounds(140, 190, 90, 30);
        add(loginButton);
        closeButton.setBounds(250, 190, 90, 30);
        add(closeButton);

        // --- 3. Adding Logic (Action Listeners) ---
        
        // A. Login Button Logic (Video feature)
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = usernameField.getText();
                String pass = new String(passwordField.getPassword()); 
                
                // Authentication logic
                if (user.equals(CORRECT_USER) && pass.equals(CORRECT_PASS)) { 
                    // Success: Close login form and open Homepage
                    dispose(); 
                    new Homepage().setVisible(true); 
                } else {
                    // Failure: Show error message
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // B. Show Password Checkbox Logic (Video feature)
        showPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Toggle visibility: 0 means show, '*' means hide
                if (showPassword.isSelected()) {
                    passwordField.setEchoChar((char) 0); 
                } else {
                    passwordField.setEchoChar('*'); 
                }
            }
        });

        // C. Close Button Logic (Video feature)
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show a confirmation dialog
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to close the application?", "Confirm Close", JOptionPane.YES_NO_OPTION);
                
                if (a == JOptionPane.YES_OPTION) { // YES_OPTION returns 0
                    System.exit(0); 
                }
            }
        });
        
        setVisible(true); // Make the window visible
    }
}