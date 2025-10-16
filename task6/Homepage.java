import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Homepage extends JFrame {

    private Image backgroundImage;
    // NOTE: 'images.jpeg' is used here; ensure this file is present in your 'images' folder.
    private final String IMAGE_PATH = "images/images.jpeg"; 
    
    public Homepage() {
        setTitle("Welcome Home");
        // Adjusted size to 500x500 to fit all 6 buttons cleanly
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500); 
        setLocationRelativeTo(null); 
        
        // --- 1. Background Image Setup ---
        try {
            backgroundImage = ImageIO.read(new File(IMAGE_PATH)); 
        } catch (IOException e) {
            System.err.println("Homepage background image not found at: " + IMAGE_PATH);
        }

        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this); 
                }
            }
        };
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // --- 2. UI Components (All 6 Buttons) ---
        
        JLabel titleLabel = new JLabel("Welcome to the Homepage");
        titleLabel.setBounds(100, 30, 300, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.YELLOW); 
        contentPane.add(titleLabel);

        // Declare all 6 buttons
        JButton viewProfileButton = new JButton("View Profile");
        JButton settingsButton = new JButton("Settings");
        JButton logoutButton = new JButton("Logout"); 
        
        // --- TASK 6 NEW BUTTON ---
        JButton billingButton = new JButton("Billing / Generate Bill"); 
        
        // --- TASK 5 NAVIGATION BUTTONS ---
        JButton addBuyerButton = new JButton("Add New Buyer");
        JButton deleteBuyerButton = new JButton("Delete Buyer"); 
        
        // Positioning (Arranged Vertically, separated by 150px width, 40px height)
        int btnWidth = 150;
        int xPos = 175;
        
        viewProfileButton.setBounds(xPos, 90, btnWidth, 35);
        settingsButton.setBounds(xPos, 140, btnWidth, 35);
        
        // Task 6 Billing Button
        billingButton.setBounds(xPos, 190, btnWidth, 35); 
        
        logoutButton.setBounds(xPos, 240, btnWidth, 35); 
        
        // Task 5 Buttons
        addBuyerButton.setBounds(xPos, 290, btnWidth, 35); 
        deleteBuyerButton.setBounds(xPos, 340, btnWidth, 35); 

        contentPane.add(viewProfileButton);
        contentPane.add(settingsButton);
        contentPane.add(logoutButton);
        contentPane.add(billingButton); 
        contentPane.add(addBuyerButton);
        contentPane.add(deleteBuyerButton);

        // --- 3. Action Listeners (All Tasks) ---
        
        // Task 6: Billing Navigation
        billingButton.addActionListener(e -> {
            new Billing().setVisible(true); // Opens the new Billing Form
        });

        // Task 4: Logout Logic
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(Homepage.this, "Do you really want to log out?", "Confirm Logout", JOptionPane.YES_NO_OPTION);
                if (a == JOptionPane.YES_OPTION) { 
                    dispose(); 
                    // Assumes LoginForm is in the same package
                    new LoginForm().setVisible(true); 
                }
            }
        });
        
        // Task 5: Add Buyer Navigation
        addBuyerButton.addActionListener(e -> new AddBuyer().setVisible(true));

        // Task 5: Delete Buyer Navigation
        deleteBuyerButton.addActionListener(e -> new DeleteBuyer().setVisible(true));

        viewProfileButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Opening View Profile Page...", "Navigation", JOptionPane.INFORMATION_MESSAGE));
        settingsButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Opening Settings Page...", "Navigation", JOptionPane.INFORMATION_MESSAGE));


        setVisible(true);
    }
}