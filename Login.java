import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame {
    public String userName_id;
    Login() {
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

        // Center panel
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(new Color(255, 255, 255, 220));

        int panelWidth = 500;
        int panelHeight = 400;
        int x = (width - panelWidth) / 2;
        int y = (height - panelHeight) / 2;
        loginPanel.setBounds(x, y, panelWidth, panelHeight);

        // Title
        JLabel title = new JLabel("Login", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.black);
        title.setBounds(120, 20, 300, 40);
        loginPanel.add(title);

        // Username
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 80, 120, 30);
        userLabel.setFont(new Font("Arial", Font.BOLD, 20));
        loginPanel.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(180, 80, 250, 30);
        userField.setFont(new Font("Arial", Font.PLAIN, 20));
        loginPanel.add(userField);

        // Password
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 130, 120, 30);
        passLabel.setFont(new Font("Arial", Font.BOLD, 20));
        loginPanel.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(180, 130, 250, 30);
        passField.setFont(new Font("Arial", Font.PLAIN, 20));
        loginPanel.add(passField);


        // sign up button
        JButton signUpBtn = new JButton("Sign Up");
        signUpBtn.setBounds(40, 200, 120, 40);
        signUpBtn.setBackground(new Color(0, 102, 255));
        signUpBtn.setForeground(Color.WHITE);
        loginPanel.add(signUpBtn);

        // Login button
        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(180, 200, 120, 40);
        loginBtn.setBackground(new Color(0, 153, 76));
        loginBtn.setForeground(Color.WHITE);
        loginPanel.add(loginBtn);

        // Reset button
        JButton resetBtn = new JButton("Reset");
        resetBtn.setBounds(320, 200, 120, 40);
        resetBtn.setBackground(new Color(255, 102, 0));
        resetBtn.setForeground(Color.WHITE);
        loginPanel.add(resetBtn);


        // action for signUp
        signUpBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                new SignUp();
            }


        });

        // Action for Login
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userName_id = userField.getText();

                String pass = new String(passField.getPassword());

                if (userName_id.isEmpty() || pass.isEmpty()) {
                    JOptionPane.showMessageDialog(Login.this, "Please fill all fields!");
                    return;
                }

                ConnectionClass connection = new ConnectionClass();
                try {
                    String query = "SELECT * FROM signUp WHERE userId = ? AND password = ?";
                    PreparedStatement ps = connection.con.prepareStatement(query);
                    ps.setString(1, userName_id);
                    ps.setString(2, pass);

                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(Login.this, "Login Successful!");
                        dispose();
//                        System.out.println(userName_id);
                        new StudentDashboard(userName_id);
                        // You can open Dashboard here
                    } else {
                        JOptionPane.showMessageDialog(Login.this, "Invalid Username or Password!");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(Login.this, "Database Error: " + ex.getMessage());
                }
            }
        });

        // Action for Reset
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userField.setText("");
                passField.setText("");
            }
        });

        backgroundLabel.add(loginPanel);
        add(backgroundLabel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public static void main(String[] args) {

        new Login();
    }
}

