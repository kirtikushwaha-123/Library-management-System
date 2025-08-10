//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.PreparedStatement;
//
//public class StudentUpdateDetails extends JFrame {
//    StudentUpdateDetails(String id,String name,String course,String semester,String mobileNumber,String emailId)
//    {
//        setTitle("Library Management System");
//        setLayout(null);
//
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int width = screenSize.width;
//        int height = screenSize.height;
//        setSize(width, height);
//
//        ImageIcon image = new ImageIcon("libbb.jpg");
//        Image scaledImage = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
//        ImageIcon fullScreenIcon = new ImageIcon(scaledImage);
//        JLabel backgroundLabel = new JLabel(fullScreenIcon);
//        backgroundLabel.setBounds(0, 0, width, height);
//        add(backgroundLabel);
//
//        JPanel updateStdDetails = new JPanel();
//        updateStdDetails.setLayout(null);
//        updateStdDetails.setBackground(new Color(255, 255, 255, 220));
//        int panelHeight = 600;
//        int panelWidth = 800;
//        int y = (height - panelHeight) / 2;
//        int x = (width - panelWidth) / 2;
//        updateStdDetails.setBounds(x, y, panelWidth, panelHeight);
//
//        JLabel title = new JLabel("Update Student Info");
//        title.setFont(new Font("Arial", Font.BOLD, 30));
//        title.setBounds(270, 20, 300, 40);
//        updateStdDetails.add(title);
//
//        JLabel studentID = new JLabel("Student ID : ");
//        studentID.setFont(new Font("Arial", Font.BOLD, 18));
//        studentID.setBounds(100, 90, 150, 30);
//        updateStdDetails.add(studentID);
//
//        JTextField idfield = new JTextField(id);
//        idfield.setBounds(300, 90, 300, 30);
//        updateStdDetails.add(idfield);
//        idfield.setEditable(false);
//
//        JLabel nameLabel = new JLabel("Student Name:");
//        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        nameLabel.setBounds(100, 140, 150, 30);
//        updateStdDetails.add(nameLabel);
//
//        JTextField nameField1 = new JTextField(name);
//        nameField1.setBounds(300, 140, 300, 30);
//        updateStdDetails.add(nameField1);
//
//        JLabel authorLabel = new JLabel("Course :");
//        authorLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        authorLabel.setBounds(100, 190, 150, 30);
//        updateStdDetails.add(authorLabel);
//
//        JTextField authorField1 = new JTextField(course);
//        authorField1.setBounds(300, 190, 300, 30);
//        updateStdDetails.add(authorField1);
//
//        JLabel publisherLabel = new JLabel("Semester :");
//        publisherLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        publisherLabel.setBounds(100, 240, 150, 30);
//        updateStdDetails.add(publisherLabel);
//
//        JTextField publisherField1 = new JTextField(semester);
//        publisherField1.setBounds(300, 240, 300, 30);
//        updateStdDetails.add(publisherField1);
//
//        JLabel yearLabel = new JLabel("Mobile Number :");
//        yearLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        yearLabel.setBounds(100, 290, 150, 30);
//        updateStdDetails.add(yearLabel);
//
//        JTextField yearField1 = new JTextField(mobileNumber);
//        yearField1.setBounds(300, 290, 300, 30);
//        updateStdDetails.add(yearField1);
//
//        JLabel quantityLabel = new JLabel("Email ID :");
//        quantityLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        quantityLabel.setBounds(100, 340, 150, 30);
//        updateStdDetails.add(quantityLabel);
//
//        JTextField quantityField1 = new JTextField(emailId);
//        quantityField1.setBounds(300, 340, 300, 30);
//        updateStdDetails.add(quantityField1);
//
////        JLabel availableLabel = new JLabel("Available:");
////        availableLabel.setFont(new Font("Arial", Font.BOLD, 18));
////        availableLabel.setBounds(100, 390, 150, 30);
////        updateStdDetails.add(availableLabel);
////
////        JRadioButton yesBtn = new JRadioButton("Yes");
////        JRadioButton noBtn = new JRadioButton("No");
////        yesBtn.setBounds(300, 390, 70, 30);
////        noBtn.setBounds(380, 390, 70, 30);
////        yesBtn.setBackground(new Color(255, 255, 255, 220));
////        noBtn.setBackground(new Color(255, 255, 255, 220));
////        ButtonGroup availabilityGroup = new ButtonGroup();
////        availabilityGroup.add(yesBtn);
////        availabilityGroup.add(noBtn);
////        updateStdDetails.add(yesBtn);
////        updateStdDetails.add(noBtn);
//
////        if (ava.equalsIgnoreCase("true") || ava.equalsIgnoreCase("yes")) {
////            yesBtn.setSelected(true);
////        } else {
////            noBtn.setSelected(true);
////        }
//
//        JButton updateButton = new JButton("Update Information");
//        updateButton.setBounds(190, 450, 150, 40);
//        updateButton.setBackground(new Color(0, 102, 255));
//        updateButton.setForeground(Color.WHITE);
//        updateStdDetails.add(updateButton);
//
//        JButton backButton = new JButton("Back");
//        backButton.setBounds(390, 450, 150, 40);
//        backButton.setBackground(new Color(255, 102, 0));
//        backButton.setForeground(Color.WHITE);
//        updateStdDetails.add(backButton);
//
//        updateButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String name = nameField1.getText();
//                String author = authorField1.getText();
//                String publisher = publisherField1.getText();
//                String pubYear = yearField1.getText();
//                String quantity = quantityField1.getText();
////                String available = yesBtn.isSelected() ? "YES" : (noBtn.isSelected() ? "NO" : "Not Selected");
//
//                if (name.isEmpty() || author.isEmpty() || publisher.isEmpty() || pubYear.isEmpty() || quantity.isEmpty() ) {
//                    JOptionPane.showMessageDialog(StudentUpdateDetails.this, "Please fill all fields and select availability!");
//                } else {
//                    try {
//                        ConnectionClass connection = new ConnectionClass();
//                        String query = "UPDATE student SET stdName = ?, stdcourse = ?, stdsem = ?, stdmobile = ?, stdemail = ? WHERE stdId = ?";
//                        PreparedStatement ps = connection.con.prepareStatement(query);
//                        ps.setString(1, name);
//                        ps.setString(2, author);
//                        ps.setString(3, publisher);
//                        ps.setString(4, pubYear);
//                        ps.setString(5, quantity);
////                        ps.setString(6, available);
//                        int id = Integer.parseInt(idfield.getText());
//                        ps.setInt(7, id);
//
//                        int rows = ps.executeUpdate();
//
//                        SwingUtilities.invokeLater(() -> {
//                            if (rows > 0) {
//                                JOptionPane.showMessageDialog(StudentUpdateDetails.this, "Book updated successfully!");
//                                updateStdDetails.setEnabled(false);
//                            } else {
//                                JOptionPane.showMessageDialog(StudentUpdateDetails.this, "Failed to update book.");
//                            }
//                        });
//
//                    } catch (Exception ex) {
//                        SwingUtilities.invokeLater(() -> {
//                            updateStdDetails.setEnabled(true);
//                            JOptionPane.showMessageDialog(StudentUpdateDetails.this, "Database error: " + ex.getMessage());
//                        });
//                        ex.printStackTrace();
//                    }
//                }
//            }
//        });
//
//        backButton.addActionListener(e -> dispose());
//
//        backgroundLabel.add(updateStdDetails);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//    }
//    public static void main(String[] args) {
//
//    }
//}


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class StudentUpdateDetails extends JFrame {
    public StudentUpdateDetails(String id, String name, String course, String semester, String mobileNumber, String emailId) {
        setTitle("Library Management System");
        setLayout(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setSize(width, height);

        ImageIcon image = new ImageIcon("libbb.jpg");
        Image scaledImage = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon fullScreenIcon = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(fullScreenIcon);
        backgroundLabel.setBounds(0, 0, width, height);
        add(backgroundLabel);

        JPanel updateStdDetails = new JPanel();
        updateStdDetails.setLayout(null);
        updateStdDetails.setBackground(new Color(255, 255, 255, 220));
        int panelHeight = 600;
        int panelWidth = 800;
        int y = (height - panelHeight) / 2;
        int x = (width - panelWidth) / 2;
        updateStdDetails.setBounds(x, y, panelWidth, panelHeight);

        JLabel title = new JLabel("Update Student Info");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setBounds(270, 20, 300, 40);
        updateStdDetails.add(title);

        JLabel studentID = new JLabel("Student ID : ");
        studentID.setFont(new Font("Arial", Font.BOLD, 18));
        studentID.setBounds(100, 90, 150, 30);
        updateStdDetails.add(studentID);

        JTextField idField = new JTextField(id);
        idField.setBounds(300, 90, 300, 30);
        updateStdDetails.add(idField);
        idField.setEditable(false);

        JLabel nameLabel = new JLabel("Student Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setBounds(100, 140, 150, 30);
        updateStdDetails.add(nameLabel);

        JTextField nameField = new JTextField(name);
        nameField.setBounds(300, 140, 300, 30);
        updateStdDetails.add(nameField);

        JLabel courseLabel = new JLabel("Course :");
        courseLabel.setFont(new Font("Arial", Font.BOLD, 18));
        courseLabel.setBounds(100, 190, 150, 30);
        updateStdDetails.add(courseLabel);

        JTextField courseField = new JTextField(course);
        courseField.setBounds(300, 190, 300, 30);
        updateStdDetails.add(courseField);

        JLabel semLabel = new JLabel("Semester :");
        semLabel.setFont(new Font("Arial", Font.BOLD, 18));
        semLabel.setBounds(100, 240, 150, 30);
        updateStdDetails.add(semLabel);

        JTextField semField = new JTextField(semester);
        semField.setBounds(300, 240, 300, 30);
        updateStdDetails.add(semField);

        JLabel mobileLabel = new JLabel("Mobile Number :");
        mobileLabel.setFont(new Font("Arial", Font.BOLD, 18));
        mobileLabel.setBounds(100, 290, 150, 30);
        updateStdDetails.add(mobileLabel);

        JTextField mobileField = new JTextField(mobileNumber);
        mobileField.setBounds(300, 290, 300, 30);
        updateStdDetails.add(mobileField);

        JLabel emailLabel = new JLabel("Email ID :");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 18));
        emailLabel.setBounds(100, 340, 150, 30);
        updateStdDetails.add(emailLabel);

        JTextField emailField = new JTextField(emailId);
        emailField.setBounds(300, 340, 300, 30);
        updateStdDetails.add(emailField);

        JButton updateButton = new JButton("Update Information");
        updateButton.setBounds(190, 450, 150, 40);
        updateButton.setBackground(new Color(0, 102, 255));
        updateButton.setForeground(Color.WHITE);
        updateStdDetails.add(updateButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(390, 450, 150, 40);
        backButton.setBackground(new Color(255, 102, 0));
        backButton.setForeground(Color.WHITE);
        updateStdDetails.add(backButton);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String updatedName = nameField.getText();
                String updatedCourse = courseField.getText();
                String updatedSem = semField.getText();
                String updatedMobile = mobileField.getText();
                String updatedEmail = emailField.getText();

                if (updatedName.isEmpty() || updatedCourse.isEmpty() || updatedSem.isEmpty() || updatedMobile.isEmpty() || updatedEmail.isEmpty()) {
                    JOptionPane.showMessageDialog(StudentUpdateDetails.this, "Please fill all fields!");
                } else {
                    try {
                        ConnectionClass connection = new ConnectionClass();
                        String query = "UPDATE student SET stdName = ?, stdcourse = ?, stdsem = ?, stdmobile = ?, stdemail = ? WHERE stdId = ?";
                        PreparedStatement ps = connection.con.prepareStatement(query);
                        ps.setString(1, updatedName);
                        ps.setString(2, updatedCourse);
                        ps.setString(3, updatedSem);
                        ps.setString(4, updatedMobile);
                        ps.setString(5, updatedEmail);
                        ps.setString(6, idField.getText());

                        int rows = ps.executeUpdate();

                        if (rows > 0) {
                            JOptionPane.showMessageDialog(StudentUpdateDetails.this, "Student info updated successfully!");
                        } else {
                            JOptionPane.showMessageDialog(StudentUpdateDetails.this, "Failed to update student info.");
                        }

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(StudentUpdateDetails.this, "Database error: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                }
            }
        });

        backButton.addActionListener(e -> dispose());

        backgroundLabel.add(updateStdDetails);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Test launch (sample data)
//        new StudentUpdateDetails("101", "Amit", "BCA", "6", "9876543210", "amit@example.com");
    }
}
