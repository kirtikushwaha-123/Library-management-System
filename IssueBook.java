//
//
//import javax.swing.*;
//        import java.awt.*;
//        import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.*;
//        import java.time.LocalDate;
//
//public class IssueBook extends JFrame {
//    JTextField bookIdField, stdIdField;
////    JDatePickerImpl returnDatePicker;
//
//    public IssueBook() {
//        setTitle("Library Management System - Issue Book");
//        setLayout(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int width = screenSize.width;
//        int height = screenSize.height;
//        setSize(width, height);
//
//        // Background
//        ImageIcon image = new ImageIcon("libbb.jpg");
//        Image scaledImage = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
//        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));
//        backgroundLabel.setBounds(0, 0, width, height);
//        backgroundLabel.setLayout(null);
//
//        // Panel
//        JPanel panel = new JPanel();
//        panel.setLayout(null);
//        panel.setBackground(new Color(255, 255, 255, 220));
//        panel.setBounds((width - 600) / 2, (height - 400) / 2, 800, 600);
//
//        JLabel title = new JLabel("Issue Book", SwingConstants.CENTER);
//        title.setFont(new Font("Arial", Font.BOLD, 25));
//        title.setBounds(200, 20, 200, 30);
//        panel.add(title);
//
//        JLabel bookIdLabel = new JLabel("Book ID:");
//        bookIdLabel.setBounds(100, 80, 100, 25);
//        panel.add(bookIdLabel);
//
//        bookIdField = new JTextField();
//        bookIdField.setBounds(220, 80, 250, 25);
//        panel.add(bookIdField);
//
//        JLabel stdIdLabel = new JLabel("Student ID:");
//        stdIdLabel.setBounds(100, 130, 100, 25);
//        panel.add(stdIdLabel);
//
//        stdIdField = new JTextField();
//        stdIdField.setBounds(220, 130, 250, 25);
//        panel.add(stdIdField);
//
//        JLabel issueLabel = new JLabel("Issued Date (YYYY-MM-DD):");
//        issueLabel.setBounds(100, 180, 200, 25);
//        panel.add(issueLabel);
//
//       JTextField issueField = new JTextField();
//        issueField.setBounds(220, 130, 250, 25);
//        panel.add(issueField);
//
//
//        JLabel returnLabel = new JLabel("Return Date (YYYY-MM-DD):");
//        returnLabel.setBounds(100, 180, 200, 25);
//        panel.add(returnLabel);
//
//        JTextField returnField = new JTextField();
//        returnField.setBounds(220, 130, 250, 25);
//        panel.add(returnField);
//
//
//        JTextField returnDateField = new JTextField();
//        returnDateField.setBounds(300, 180, 170, 25);
//        returnDateField.setEditable(false); // prevent editing
//        returnDateField.setText(LocalDate.now().plusDays(15).toString()); // auto-fill with 15-day return date
//        panel.add(returnDateField);
//
//
//        JButton issueBtn = new JButton("Issue Book");
//        issueBtn.setBounds(220, 240, 150, 30);
//        issueBtn.setBackground(new Color(0, 102, 204));
//        issueBtn.setForeground(Color.WHITE);
//        panel.add(issueBtn);
//
//        issueBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String bookId = bookIdField.getText().trim();
//                String stdId = stdIdField.getText().trim();
//                String returnDateStr = returnDateField.getText().trim();
//
//                if (bookId.isEmpty() || stdId.isEmpty() || returnDateStr.isEmpty()) {
//                    JOptionPane.showMessageDialog(null, "All fields are required!");
//                    return;
//                }
//
//                try {
//                    Date issuedDate = Date.valueOf(LocalDate.now());
//                    Date returnDate = Date.valueOf(returnDateStr);
//
//                    ConnectionClass connection = new ConnectionClass();
//                    String query = "INSERT INTO issued_book (bookId, stdId, issuedDate, returnDate) VALUES (?, ?, ?, ?)";
//                    PreparedStatement ps = connection.con.prepareStatement(query);
//                    ps.setString(1, bookId);
//                    ps.setString(2, stdId);
//                    ps.setDate(3, issuedDate);
//                    ps.setDate(4, returnDate);
//
//                    int result = ps.executeUpdate();
//                    if (result > 0) {
//                        JOptionPane.showMessageDialog(null, "Book issued successfully!");
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Book issue failed.");
//                    }
//                } catch (SQLIntegrityConstraintViolationException ex) {
//                    JOptionPane.showMessageDialog(null, "Invalid Book ID or Student ID.");
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
//                }
//            }
//        });
//
//        JButton backBtn = new JButton("Back");
//        backBtn.setBounds(250, 300, 100, 30);
//        backBtn.setBackground(new Color(0, 102, 204));
//        backBtn.setForeground(Color.WHITE);
//        backBtn.addActionListener(ae -> {
//            setVisible(false);
//            new AdminDashboard(); // Adjust based on your app
//        });
//        panel.add(backBtn);
//
//        backgroundLabel.add(panel);
//        add(backgroundLabel);
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new IssueBook();
//    }
//}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;

public class IssueBook extends JFrame {
    JTextField bookIdField, stdIdField;

    public IssueBook() {
        setTitle("Library Management System - Issue Book");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setSize(width, height);

        // Background image
        ImageIcon image = new ImageIcon("libbb.jpg");
        Image scaledImage = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));
        backgroundLabel.setBounds(0, 0, width, height);
        backgroundLabel.setLayout(null);

        // Panel setup
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(255, 255, 255, 220));
        panel.setBounds((width - 800) / 2, (height - 600) / 2, 800, 600);

        JLabel title = new JLabel("Issue Book", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setBounds(300, 20, 200, 30);
        panel.add(title);

        JLabel bookIdLabel = new JLabel("Book ID:");
        bookIdLabel.setBounds(100, 80, 150, 25);
        panel.add(bookIdLabel);

        bookIdField = new JTextField();
        bookIdField.setBounds(300, 80, 300, 25);
        panel.add(bookIdField);

        JLabel stdIdLabel = new JLabel("Student ID:");
        stdIdLabel.setBounds(100, 130, 150, 25);
        panel.add(stdIdLabel);

        stdIdField = new JTextField();
        stdIdField.setBounds(300, 130, 300, 25);
        panel.add(stdIdField);

        JLabel issueLabel = new JLabel("Issued Date (YYYY-MM-DD):");
        issueLabel.setBounds(100, 180, 200, 25);
        panel.add(issueLabel);

//        JTextField issueField = new JTextField(LocalDate.now().toString());
        JTextField issueField = new JTextField();
        issueField.setBounds(300, 180, 300, 25);
        issueField.setEditable(false);
        issueField.setText("2025-04-2");
        panel.add(issueField);

        JLabel returnLabel = new JLabel("Return Date (YYYY-MM-DD):");
        returnLabel.setBounds(100, 230, 200, 25);
        panel.add(returnLabel);

        JTextField returnDateField = new JTextField();
//        JTextField returnDateField = new JTextField(LocalDate.now().plusDays(15).toString());
        returnDateField.setBounds(300, 230, 300, 25);
        returnDateField.setEditable(false);
        returnDateField.setText("2025-04-12");
        panel.add(returnDateField);

        JButton issueBtn = new JButton("Issue Book");
        issueBtn.setBounds(300, 300, 150, 30);
        issueBtn.setBackground(new Color(0, 102, 204));
        issueBtn.setForeground(Color.WHITE);
        panel.add(issueBtn);

        issueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookId = bookIdField.getText().trim();
                String stdId = stdIdField.getText().trim();
                String issuedDateStr = issueField.getText().trim();
                String returnDateStr = returnDateField.getText().trim();

                if (bookId.isEmpty() || stdId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Book ID and Student ID are required!");
                    return;
                }

                try {
                    Date issuedDate = Date.valueOf(issuedDateStr);
                    Date returnDate = Date.valueOf(returnDateStr);

                    ConnectionClass connection = new ConnectionClass();
                    String query = "INSERT INTO issued_book (bookId, stdId, issuedDate, returnDate) VALUES (?, ?, ?, ?)";
                    PreparedStatement ps = connection.con.prepareStatement(query);
                    ps.setString(1, bookId);
                    ps.setString(2, stdId);
                    ps.setDate(3, issuedDate);
                    ps.setDate(4, returnDate);

                    int result = ps.executeUpdate();
                    if (result > 0) {
                        JOptionPane.showMessageDialog(null, "Book issued successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Book issue failed.");
                    }
                }
//                catch (SQLIntegrityConstraintViolationException ex) {
//                    JOptionPane.showMessageDialog(null, "Invalid Book ID or Student ID.");
//                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(470, 300, 100, 30);
        backBtn.setBackground(new Color(0, 102, 204));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(ae -> {
            setVisible(false);
            new AdminDashboard(); // Replace with your actual dashboard class
        });
        panel.add(backBtn);

        backgroundLabel.add(panel);
        add(backgroundLabel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new IssueBook();
    }
}
