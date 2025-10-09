import javax.swing.SwingUtilities;

public class MainApp {
    public static void main(String[] args) {
        // Use SwingUtilities to launch the GUI on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginForm(); 
            }
        });
    }
}