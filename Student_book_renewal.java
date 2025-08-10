//
//import javax.swing.*;
//import java.awt.*;
//
//public class Student_book_renewal extends JFrame {
//    private JTextField studentIdField, studentNameField, bookIdField,bookDueField;
//
//    public Student_book_renewal() {
//        setTitle("Library Management System - Book Renewal");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Set full screen
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        setSize(screenSize.width, screenSize.height);
//        setLayout(null);
//
//        // Background Image
//        ImageIcon image = new ImageIcon("libbb.jpg");
//        Image scaledImage = image.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
//        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));
//        backgroundLabel.setBounds(0, 0, screenSize.width, screenSize.height);
//        add(backgroundLabel);
//
//        // Main panel
//        JPanel renewalBook = new JPanel();
//        renewalBook.setLayout(null);
//        renewalBook.setBackground(new Color(255, 255, 255, 220));
//
//        int panelHeight = 600;
//        int panelWidth = 800;
//        int y = (screenSize.height - panelHeight) / 2;
//        int x = (screenSize.width - panelWidth) / 2;
//        renewalBook.setBounds(x, y, panelWidth, panelHeight);
//
//        // Title
//        JLabel title = new JLabel("Books Renewal");
//        title.setFont(new Font("Arial", Font.BOLD, 24));
//        title.setBounds(300, 20, 250, 30);
//        renewalBook.add(title);
//
//        // Student ID
//        JLabel studentIdLabel = new JLabel("Student ID:");
//        studentIdLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        studentIdLabel.setBounds(100, 80, 150, 30);
//        renewalBook.add(studentIdLabel);
//
//        studentIdField = new JTextField();
//        studentIdField.setBounds(300, 80, 300, 30);
//        studentIdField.setEditable(false); // Change to true if you want manual input
//        renewalBook.add(studentIdField);
//
//        // Student Name
//        JLabel studentNameLabel = new JLabel("Student Name:");
//        studentNameLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        studentNameLabel.setBounds(100, 130, 150, 30);
//        renewalBook.add(studentNameLabel);
//
//        studentNameField = new JTextField();
//        studentNameField.setBounds(300, 130, 300, 30);
//        studentNameField.setEditable(false);
//        renewalBook.add(studentNameField);
//
//        // Book ID
//        JLabel bookDueLabel = new JLabel("Deu Dare:");
//        bookDueLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        bookDueLabel.setBounds(100, 180, 150, 30);
//        renewalBook.add(bookDueLabel);
//
//        bookDueField = new JTextField();
//        bookDueField.setBounds(300, 180, 300, 30);
//        renewalBook.add(bookDueField);
//
//        // Book ID
//        JLabel bookIdLabel = new JLabel("Book ID:");
//        bookIdLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        bookIdLabel.setBounds(100, 180, 150, 30);
//        renewalBook.add(bookIdLabel);
//
//        bookIdField = new JTextField();
//        bookIdField.setBounds(300, 180, 300, 30);
//        renewalBook.add(bookIdField);
//
//        // Renewal Button
//        JButton renewalBtn = new JButton("Renewal Book");
//        renewalBtn.setBounds(300, 520, 150, 40);
//        renewalBtn.setBackground(new Color(70, 130, 180));
//        renewalBtn.setForeground(Color.WHITE);
//        renewalBook.add(renewalBtn);
//
//        // Add main panel to background
//        backgroundLabel.add(renewalBook);
//
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new Student_book_renewal();
//    }
//}

import javax.swing.*;
import java.awt.*;

public class Student_book_renewal extends JFrame {
    private JTextField studentIdField, studentNameField, bookIdField;
    private JTextField oldDueDateField, newDueDateField;

    public Student_book_renewal() {
        setTitle("Library Management System - Book Renewal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set full screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setLayout(null);

        // Background Image
        ImageIcon image = new ImageIcon("libbb.jpg");
        Image scaledImage = image.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));
        backgroundLabel.setBounds(0, 0, screenSize.width, screenSize.height);
        add(backgroundLabel);

        // Main panel
        JPanel renewalBook = new JPanel();
        renewalBook.setLayout(null);
        renewalBook.setBackground(new Color(255, 255, 255, 220));

        int panelHeight = 600;
        int panelWidth = 800;
        int y = (screenSize.height - panelHeight) / 2;
        int x = (screenSize.width - panelWidth) / 2;
        renewalBook.setBounds(x, y, panelWidth, panelHeight);

        // Title
        JLabel title = new JLabel("Books Renewal");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(300, 20, 250, 30);
        renewalBook.add(title);

        // Student ID
        JLabel studentIdLabel = new JLabel("Student ID:");
        studentIdLabel.setFont(new Font("Arial", Font.BOLD, 18));
        studentIdLabel.setBounds(100, 80, 150, 30);
        renewalBook.add(studentIdLabel);

        studentIdField = new JTextField();
        studentIdField.setBounds(300, 80, 300, 30);
        studentIdField.setEditable(false);
        renewalBook.add(studentIdField);

        // Student Name
        JLabel studentNameLabel = new JLabel("Student Name:");
        studentNameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        studentNameLabel.setBounds(100, 130, 150, 30);
        renewalBook.add(studentNameLabel);

        studentNameField = new JTextField();
        studentNameField.setBounds(300, 130, 300, 30);
        studentNameField.setEditable(false);
        renewalBook.add(studentNameField);

        // Book ID
        JLabel bookIdLabel = new JLabel("Book ID:");
        bookIdLabel.setFont(new Font("Arial", Font.BOLD, 18));
        bookIdLabel.setBounds(100, 180, 150, 30);
        renewalBook.add(bookIdLabel);

        bookIdField = new JTextField();
        bookIdField.setBounds(300, 180, 300, 30);
        renewalBook.add(bookIdField);

        // Old Due Date
        JLabel oldDueDateLabel = new JLabel("Old Due Date:");
        oldDueDateLabel.setFont(new Font("Arial", Font.BOLD, 18));
        oldDueDateLabel.setBounds(100, 230, 150, 30);
        renewalBook.add(oldDueDateLabel);

        oldDueDateField = new JTextField();
        oldDueDateField.setBounds(300, 230, 300, 30);
        oldDueDateField.setEditable(false);
        renewalBook.add(oldDueDateField);

        // New Due Date
        JLabel newDueDateLabel = new JLabel("New Due Date:");
        newDueDateLabel.setFont(new Font("Arial", Font.BOLD, 18));
        newDueDateLabel.setBounds(100, 280, 150, 30);
        renewalBook.add(newDueDateLabel);

        newDueDateField = new JTextField();
        newDueDateField.setBounds(300, 280, 300, 30);
        renewalBook.add(newDueDateField);

        // Renewal Button
        JButton renewalBtn = new JButton("Renew Book");
        renewalBtn.setBounds(300, 520, 150, 40);
        renewalBtn.setBackground(new Color(70, 130, 180));
        renewalBtn.setForeground(Color.WHITE);
        renewalBook.add(renewalBtn);

        // Add panel to background
        backgroundLabel.add(renewalBook);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Student_book_renewal();
    }
}
