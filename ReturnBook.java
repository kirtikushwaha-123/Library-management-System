import javax.swing.*;
import java.awt.*;

public class ReturnBook extends JFrame {
    ReturnBook()
    {
        setTitle("Library Management System");
        setLayout(null);

        // Fullscreen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Background image
        ImageIcon image = new ImageIcon("libbb.jpg");
        Image scaledImage = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));
        backgroundLabel.setBounds(0, 0, width, height);
        add(backgroundLabel);

        // Panel to hold form fields
        JPanel stdPanel = new JPanel();
        stdPanel.setLayout(null);
        stdPanel.setBackground(new Color(255, 255, 255, 220));
        stdPanel.setBounds((width - 800) / 2, (height - 600) / 2, 800, 500);

        // Title
        JLabel title = new JLabel("Return Book", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setBounds(100, 20, 400, 35);
        stdPanel.add(title);

        // Student ID
        JLabel stdIdLabel = new JLabel("Student ID:");
        stdIdLabel.setFont(new Font("Arial", Font.BOLD, 15));
        stdIdLabel.setBounds(50, 100, 150, 30);
        stdPanel.add(stdIdLabel);

        JTextField stdIdField = new JTextField();
        stdIdField.setFont(new Font("Arial", Font.PLAIN, 15));
        stdIdField.setBounds(220, 100, 300, 30);
        stdPanel.add(stdIdField);

        // Student Name
        JLabel stdNameLabel = new JLabel("Student Name:");
        stdNameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        stdNameLabel.setBounds(50, 140, 150, 30);
        stdPanel.add(stdNameLabel);

        JTextField stdNameField = new JTextField();
        stdNameField.setFont(new Font("Arial", Font.PLAIN, 15));
        stdNameField.setBounds(220, 140, 300, 30);
        stdPanel.add(stdNameField);


        // Add panel on background
        backgroundLabel.add(stdPanel);
        add(backgroundLabel);

        setVisible(true);

    }


    public static void main(String[] args) {
        new ReturnBook();
    }
}
