import javax.swing.*;
import java.awt.*;

public class Homepage extends JFrame {
    public Homepage() {
        setTitle("Welcome Home");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the new window
        
        JLabel welcomeLabel = new JLabel("Successfully Logged In! Welcome to the Home Page.");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        add(welcomeLabel, BorderLayout.CENTER); 
    }
}