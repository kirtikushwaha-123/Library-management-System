//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.PreparedStatement;
//
//public class SignUp extends JFrame {
//    SignUp() {
//        setTitle("Library Management System");
//        setLayout(null);
//
//        // Full screen settings
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int width = screenSize.width;
//        int height = screenSize.height;
//        setSize(width, height);
//
//        // Background image
//        ImageIcon image = new ImageIcon("libbb.jpg");
//        Image scaledImage = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
//        ImageIcon fullScreenIcon = new ImageIcon(scaledImage);
//        JLabel backgroundLabel = new JLabel(fullScreenIcon);
//        backgroundLabel.setBounds(0, 0, width, height);
//
//        // Panel to hold form fields
//        JPanel formPanel = new JPanel();
//        formPanel.setLayout(null);
////        sideBar.setLayout(null);
//       formPanel.setBackground(new Color(255,255,255,220));
////        formPanel.setOpaque(false);
//        formPanel.setBounds((width - 500) / 2, height / 4 - 50, 500, 400);
//
//        // Title
//        JLabel title = new JLabel("Create Account", SwingConstants.CENTER);
//        title.setFont(new Font("Arial", Font.BOLD, 30));
//        title.setForeground(Color.black);
//        title.setBounds(100, 10, 300, 40);
//        formPanel.add(title);
//
//        // Name
//        JLabel nameLabel = new JLabel("Name:");
//        nameLabel.setBounds(50, 70, 100, 30);
//        nameLabel.setForeground(Color.black);
//        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
//        formPanel.add(nameLabel);
//
//        JTextField nameField = new JTextField();
//        nameField.setBounds(180, 70, 250, 30);
//        nameField.setFont(new Font("Arial", Font.PLAIN, 20));
//        formPanel.add(nameField);
//
//        // User ID
//        JLabel userIdLabel = new JLabel("User ID:");
//        userIdLabel.setBounds(50, 120, 100, 30);
//        userIdLabel.setForeground(Color.black);
//        userIdLabel.setFont(new Font("Arial", Font.BOLD, 20));
//        formPanel.add(userIdLabel);
//
//        JTextField userIdField = new JTextField();
//        userIdField.setBounds(180, 120, 250, 30);
//        userIdField.setFont(new Font("Arial", Font.PLAIN, 20));
//        formPanel.add(userIdField);
//
//        // Password
//        JLabel passLabel = new JLabel("Password:");
//        passLabel.setBounds(50, 170, 120, 30);
//        passLabel.setFont(new Font("Arial", Font.BOLD, 20));
//        passLabel.setForeground(Color.black);
//        formPanel.add(passLabel);
//
//        JPasswordField passField = new JPasswordField();
//        passField.setBounds(180, 170, 250, 30);
//        passField.setFont(new Font("Arial", Font.PLAIN, 20));
//        formPanel.add(passField);
//
//        // Sign Up button
//        JButton signUpBtn = new JButton("Sign Up");
//        signUpBtn.setBounds(80, 250, 150, 40);
//        signUpBtn.setBackground(new Color(255, 102, 0));
//        signUpBtn.setForeground(Color.black);
//        formPanel.add(signUpBtn);
//
//        // Login button
//        JButton loginBtn = new JButton("Login");
//        loginBtn.setBounds(270, 250, 150, 40);
//        loginBtn.setBackground(new Color(0, 102, 255));
//        loginBtn.setForeground(Color.black);
//        formPanel.add(loginBtn);
//
//        // Sign Up action
//        signUpBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String name = nameField.getText();
//                String userId = userIdField.getText();
//                String password = new String(passField.getPassword());
//
//                if (name.isEmpty() || userId.isEmpty() || password.isEmpty()) {
//                    JOptionPane.showMessageDialog(SignUp.this, "Please fill all fields!");
//                    return;
//                } else {
////                    new Thread(()->{
//                        ConnectionClass connection = new ConnectionClass();
//
//                        try {
//                            String query = "INSERT INTO signUp (name, userId, password) VALUES (?, ?, ?)";
//                            PreparedStatement ps = connection.con.prepareStatement(query);
//                            ps.setString(1, name);
//                            ps.setString(2, userId);
//                            ps.setString(3, password);
//
//                            int rows = ps.executeUpdate();
//                            if (rows > 0) {
//                                JOptionPane.showMessageDialog(SignUp.this, "Account created successfully!");
//                            } else {
//                                JOptionPane.showMessageDialog(SignUp.this, "Failed to create account.");
//                            }
//                        } catch (Exception ex) {
////                            SwingUtilities.invokeLater(()->{
////                                loginBtn.setEnabled(true);
//////                                loginBtn.setText("Add Book");
////                               // JOptionPane.showMessageDialog(SignUp.this, "Database error: " + ex.getMessage());
////                                ex.printStackTrace();
////
////                            });
//                            ex.printStackTrace();
//                            JOptionPane.showMessageDialog(SignUp.this, "Database error: " + ex.getMessage());
//                        }
//
////                    });
////                            .start();
//
//                }
//            }
//        });
//
//        loginBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setVisible(false);// hide current sign up page
//                new Login();
//            }
//        });
//
//        backgroundLabel.add(formPanel);
//        add(backgroundLabel);
//
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new SignUp();
//    }
//}
//


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class SignUp extends JFrame {
    SignUp() {
        setTitle("Library Management System");
        setLayout(null);

        // Full screen settings
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setSize(width, height);

        // Background image
        ImageIcon image = new ImageIcon("libbb.jpg");
        Image scaledImage = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon fullScreenIcon = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(fullScreenIcon);
        backgroundLabel.setBounds(0, 0, width, height);

        // Panel to hold form fields
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(new Color(255, 255, 255, 220));
        formPanel.setBounds((width - 500) / 2, height / 4 - 50, 500, 400);

        // Title
        JLabel title = new JLabel("Create Account", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.black);
        title.setBounds(100, 10, 300, 40);
        formPanel.add(title);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 70, 100, 30);
        nameLabel.setForeground(Color.black);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        formPanel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(180, 70, 250, 30);
        nameField.setFont(new Font("Arial", Font.PLAIN, 20));
        formPanel.add(nameField);

        // User ID
        JLabel userIdLabel = new JLabel("User ID:");
        userIdLabel.setBounds(50, 120, 100, 30);
        userIdLabel.setForeground(Color.black);
        userIdLabel.setFont(new Font("Arial", Font.BOLD, 20));
        formPanel.add(userIdLabel);

        JTextField userIdField = new JTextField();
        userIdField.setBounds(180, 120, 250, 30);
        userIdField.setFont(new Font("Arial", Font.PLAIN, 20));
        formPanel.add(userIdField);

        // Password
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 170, 120, 30);
        passLabel.setFont(new Font("Arial", Font.BOLD, 20));
        passLabel.setForeground(Color.black);
        formPanel.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(180, 170, 250, 30);
        passField.setFont(new Font("Arial", Font.PLAIN, 20));
        formPanel.add(passField);

        // Sign Up button
        JButton signUpBtn = new JButton("Sign Up");
        signUpBtn.setBounds(80, 250, 150, 40);
        signUpBtn.setBackground(new Color(255, 102, 0));
        signUpBtn.setForeground(Color.black);
        formPanel.add(signUpBtn);

        // Login button
        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(270, 250, 150, 40);
        loginBtn.setBackground(new Color(0, 102, 255));
        loginBtn.setForeground(Color.black);
        formPanel.add(loginBtn);

        // Sign Up action without multithreading
        signUpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String userId = userIdField.getText();
                String password = new String(passField.getPassword());

                if (name.isEmpty() || userId.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(SignUp.this, "Please fill all fields!");
                    return;
                } else {
                    ConnectionClass connection = new ConnectionClass();
                    try {
                        String query = "INSERT INTO SignUp (name, userId, password) VALUES (?, ?, ?)";
                        PreparedStatement ps = connection.con.prepareStatement(query);
                        ps.setString(1, name);
                        ps.setString(2, userId);
                        ps.setString(3, password);

                        int rows = ps.executeUpdate();
                        if (rows > 0) {
                            JOptionPane.showMessageDialog(SignUp.this, "Account created successfully!");
                        } else {
                            JOptionPane.showMessageDialog(SignUp.this, "Failed to create account.");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(SignUp.this, "Database error:dffdddh " + ex.getMessage());
                    }
                }
            }
        });

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Hide sign-up window
                new Login();
            }
        });

        backgroundLabel.add(formPanel);
        add(backgroundLabel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
