//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.PreparedStatement;
//
//public class StudentRegistration extends JFrame {
//
//    StudentRegistration() {
//        setTitle("Library Management System - Student Registration");
//        setLayout(null);
//
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int width = screenSize.width;
//        int height = screenSize.height;
//        setSize(width, height);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Background image
//        ImageIcon image = new ImageIcon("libbb.jpg"); // make sure this image exists
//        Image scaledImage = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
//        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));
//        backgroundLabel.setBounds(0, 0, width, height);
//        backgroundLabel.setLayout(null);
//
//        // Panel to hold form fields
//        JPanel stdPanel = new JPanel();
//        stdPanel.setLayout(null);
//        stdPanel.setBackground(new Color(255, 255, 255, 220));
//        stdPanel.setBounds((width - 600) / 2, (height - 600) / 2, 600, 500);
//
//        // Title
//        JLabel title = new JLabel("Student Registration", SwingConstants.CENTER);
//        title.setFont(new Font("Arial", Font.BOLD, 25));
//        title.setBounds(100, 20, 400, 35);
//        stdPanel.add(title);
//
//        // Student ID
//        JLabel stdIdLabel = new JLabel("Student ID:");
//        stdIdLabel.setFont(new Font("Arial", Font.BOLD, 15));
//        stdIdLabel.setBounds(50, 100, 150, 30);
//        stdPanel.add(stdIdLabel);
//
//        JTextField stdIdField = new JTextField();
//        stdIdField.setFont(new Font("Arial", Font.PLAIN, 15));
//        stdIdField.setBounds(220, 100, 300, 30);
//        stdPanel.add(stdIdField);
//
//        // Student Name
//        JLabel stdNameLabel = new JLabel("Student Name:");
//        stdNameLabel.setFont(new Font("Arial", Font.BOLD, 15));
//        stdNameLabel.setBounds(50, 140, 150, 30);
//        stdPanel.add(stdNameLabel);
//
//        JTextField stdNameField = new JTextField();
//        stdNameField.setFont(new Font("Arial", Font.PLAIN, 15));
//        stdNameField.setBounds(220, 140, 300, 30);
//        stdPanel.add(stdNameField);
//
//        // Course
//        JLabel courseLabel = new JLabel("Course:");
//        courseLabel.setFont(new Font("Arial", Font.BOLD, 15));
//        courseLabel.setBounds(50, 180, 150, 30);
//        stdPanel.add(courseLabel);
//
//        Choice courseField = new Choice();
//        courseField.add("B Tech");
//        courseField.add("MBA");
//        courseField.add("MCA");
//        courseField.add("LLB");
//        courseField.add("BCA");
//        courseField.setFont(new Font("Arial", Font.PLAIN, 15));
//        courseField.setBounds(220, 180, 300, 30);
//        stdPanel.add(courseField);
//
//        // Semester
//        JLabel semesterLabel = new JLabel("Semester:");
//        semesterLabel.setFont(new Font("Arial", Font.BOLD, 15));
//        semesterLabel.setBounds(50, 220, 150, 30);
//        stdPanel.add(semesterLabel);
//
//        Choice semesterField = new Choice();
//        semesterField.add("1st");
//        semesterField.add("2nd");
//        semesterField.add("3rd");
//        semesterField.add("4th");
//        semesterField.add("5th");
//        semesterField.add("6th");
//        semesterField.setFont(new Font("Arial", Font.PLAIN, 15));
//        semesterField.setBounds(220, 220, 300, 30);
//        stdPanel.add(semesterField);
//
//        // Mobile number
//        JLabel mobileLabel = new JLabel("Mobile No.:");
//        mobileLabel.setFont(new Font("Arial", Font.BOLD, 15));
//        mobileLabel.setBounds(50, 260, 150, 30);
//        stdPanel.add(mobileLabel);
//
//        JTextField mobileField = new JTextField();
//        mobileField.setFont(new Font("Arial", Font.PLAIN, 15));
//        mobileField.setBounds(220, 260, 300, 30);
//        stdPanel.add(mobileField);
//
//        // Email
//        JLabel emailLabel = new JLabel("Email:");
//        emailLabel.setFont(new Font("Arial", Font.BOLD, 15));
//        emailLabel.setBounds(50, 300, 150, 30);
//        stdPanel.add(emailLabel);
//
//        JTextField emailField = new JTextField();
//        emailField.setFont(new Font("Arial", Font.PLAIN, 15));
//        emailField.setBounds(220, 300, 300, 30);
//        stdPanel.add(emailField);
//
//        // Buttons (No action listeners added yet)
//        JButton backBtn = new JButton("Back");
//        backBtn.setFont(new Font("Arial", Font.BOLD, 15));
//        backBtn.setBackground(new Color(0, 102, 204));
//        backBtn.setForeground(Color.WHITE);
//        backBtn.setBounds(100, 370, 120, 40);
//        stdPanel.add(backBtn);
//
//        JButton resetBtn = new JButton("Reset");
//        resetBtn.setFont(new Font("Arial", Font.BOLD, 15));
//        resetBtn.setBackground(new Color(255, 153, 0));
//        resetBtn.setForeground(Color.WHITE);
//        resetBtn.setBounds(240, 370, 120, 40);
//        stdPanel.add(resetBtn);
//
//        JButton submitBtn = new JButton("Submit");
//        submitBtn.setFont(new Font("Arial", Font.BOLD, 15));
//        submitBtn.setBackground(new Color(0, 153, 76));
//        submitBtn.setForeground(Color.WHITE);
//        submitBtn.setBounds(380, 370, 120, 40);
//        stdPanel.add(submitBtn);
//
//
//        // action on reset button
//        resetBtn.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                stdIdField.setText("");
//                stdNameField.setText("");
//                mobileField.setText("");
//                emailField.setText("");
//
////                courseField.setDropTarget();
//
//            }
//        });
//
//        //action on submit button
//        submitBtn.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String idFeild=stdIdField.getText();
//                String nameFeild=stdNameField.getText();
//                String mobileFeild=mobileField.getText();
//                String emailFeild=emailField.getText();
//                String semFeild=semesterField.getSelectedItem();
//                String course=courseField.getSelectedItem();
//                if(idFeild.isEmpty() || nameFeild.isEmpty() || mobileFeild.isEmpty() || emailFeild.isEmpty() || semFeild.isEmpty()|| course.isEmpty())
//                {
//                    JOptionPane.showMessageDialog(StudentRegistration.this,"Please fill the all fields");
////                    JOptionPane.showMessageDialog();
//                }else
//                {
//                    ConnectionClass connection=new ConnectionClass();
//                    try{
//                        String query ="Insert Into student (stdId,stdName,stdcourse,stdsem,stdmobile,stdemail) values(?,?,?,?,?,?)";
//                        PreparedStatement ps=connection.con.prepareStatement(query);
//                        ps.setString(1,idFeild);
//                        ps.setString(2,nameFeild);
//                        ps.setString(3,course);
//                        ps.setString(4,semFeild);
//                        ps.setString(5,mobileFeild);
//                        ps.setString(6,emailFeild);
//
//                        int rows = ps.executeUpdate();
//                        if (rows > 0) {
//                            JOptionPane.showMessageDialog(StudentRegistration.this, "Student Information added successfully!");
//                            // Optionally: clear the form fields
//                            stdIdField.setText("");
//                            stdNameField.setText("");
//                            mobileField.setText("");
//                            emailField.setText("");
//
//                        } else {
//                            JOptionPane.showMessageDialog(StudentRegistration.this, "Failed to add Student Information.");
//                        }
//
//                    }
//                    catch (Exception ex)
//                    {
//                        ex.printStackTrace();
//                        JOptionPane.showMessageDialog(StudentRegistration.this, "Database error: " + ex.getMessage());
//
//                    }
////                    JOptionPane.showMessageDialog(StudentRegistration.this, "Account created successfully!");
//                }
//
//            }
//        });
//
//        // action on back button
//        backBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setVisible(false);
//                new AdminDashboard();
//
//            }
//        });
//
//
//        // Add panel on background
//        backgroundLabel.add(stdPanel);
//        add(backgroundLabel);
//
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new StudentRegistration();
//    }
//}



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;

public class StudentRegistration extends JFrame {

    StudentRegistration() {
        setTitle("Library Management System - Student Registration");
        setLayout(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Background image
        ImageIcon image = new ImageIcon("libbb.jpg"); // make sure this image exists
        Image scaledImage = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));
        backgroundLabel.setBounds(0, 0, width, height);
        backgroundLabel.setLayout(null);

        // Panel to hold form fields
        JPanel stdPanel = new JPanel();
        stdPanel.setLayout(null);
        stdPanel.setBackground(new Color(255, 255, 255, 220));
        stdPanel.setBounds((width - 600) / 2, (height - 600) / 2, 600, 500);

        // Title
        JLabel title = new JLabel("Student Registration", SwingConstants.CENTER);
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

        // Course
        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setFont(new Font("Arial", Font.BOLD, 15));
        courseLabel.setBounds(50, 180, 150, 30);
        stdPanel.add(courseLabel);

        Choice courseField = new Choice();
        courseField.add("B Tech");
        courseField.add("MBA");
        courseField.add("MCA");
        courseField.add("LLB");
        courseField.add("BCA");
        courseField.setFont(new Font("Arial", Font.PLAIN, 15));
        courseField.setBounds(220, 180, 300, 30);
        stdPanel.add(courseField);

        // Semester
        JLabel semesterLabel = new JLabel("Semester:");
        semesterLabel.setFont(new Font("Arial", Font.BOLD, 15));
        semesterLabel.setBounds(50, 220, 150, 30);
        stdPanel.add(semesterLabel);

        Choice semesterField = new Choice();
        semesterField.add("1st");
        semesterField.add("2nd");
        semesterField.add("3rd");
        semesterField.add("4th");
        semesterField.add("5th");
        semesterField.add("6th");
        semesterField.setFont(new Font("Arial", Font.PLAIN, 15));
        semesterField.setBounds(220, 220, 300, 30);
        stdPanel.add(semesterField);

        // Mobile number
        JLabel mobileLabel = new JLabel("Mobile No.:");
        mobileLabel.setFont(new Font("Arial", Font.BOLD, 15));
        mobileLabel.setBounds(50, 260, 150, 30);
        stdPanel.add(mobileLabel);

        JTextField mobileField = new JTextField();
        mobileField.setFont(new Font("Arial", Font.PLAIN, 15));
        mobileField.setBounds(220, 260, 300, 30);
        stdPanel.add(mobileField);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 15));
        emailLabel.setBounds(50, 300, 150, 30);
        stdPanel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setFont(new Font("Arial", Font.PLAIN, 15));
        emailField.setBounds(220, 300, 300, 30);
        stdPanel.add(emailField);

        // Buttons
        JButton backBtn = new JButton("Back");
        backBtn.setFont(new Font("Arial", Font.BOLD, 15));
        backBtn.setBackground(new Color(0, 102, 204));
        backBtn.setForeground(Color.WHITE);
        backBtn.setBounds(100, 370, 120, 40);
        stdPanel.add(backBtn);

        JButton resetBtn = new JButton("Reset");
        resetBtn.setFont(new Font("Arial", Font.BOLD, 15));
        resetBtn.setBackground(new Color(255, 153, 0));
        resetBtn.setForeground(Color.WHITE);
        resetBtn.setBounds(240, 370, 120, 40);
        stdPanel.add(resetBtn);

        JButton submitBtn = new JButton("Submit");
        submitBtn.setFont(new Font("Arial", Font.BOLD, 15));
        submitBtn.setBackground(new Color(0, 153, 76));
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setBounds(380, 370, 120, 40);
        stdPanel.add(submitBtn);

        // Action on reset
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stdIdField.setText("");
                stdNameField.setText("");
                mobileField.setText("");
                emailField.setText("");
            }
        });

        // ✅ Submit with validation
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idFeild = stdIdField.getText();
                String nameFeild = stdNameField.getText();
                String mobileFeild = mobileField.getText();
                String emailFeild = emailField.getText();
                String semFeild = semesterField.getSelectedItem();
                String course = courseField.getSelectedItem();

                if (idFeild.isEmpty() || nameFeild.isEmpty() || mobileFeild.isEmpty() || emailFeild.isEmpty() || semFeild.isEmpty() || course.isEmpty()) {
                    JOptionPane.showMessageDialog(StudentRegistration.this, "Please fill all fields");
                    return;
                }

                if (!mobileFeild.matches("^[6-9]\\d{9}$")) {
                    JOptionPane.showMessageDialog(StudentRegistration.this, "Invalid mobile number! Must be 10 digits and start with 6-9.");
                    return;
                }

                if (!emailFeild.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    JOptionPane.showMessageDialog(StudentRegistration.this, "Invalid email address!");
                    return;
                }

                ConnectionClass connection = new ConnectionClass();
                try {
                    String query = "Insert Into student (stdId,stdName,stdcourse,stdsem,stdmobile,stdemail) values(?,?,?,?,?,?)";
                    PreparedStatement ps = connection.con.prepareStatement(query);
                    ps.setString(1, idFeild);
                    ps.setString(2, nameFeild);
                    ps.setString(3, course);
                    ps.setString(4, semFeild);
                    ps.setString(5, mobileFeild);
                    ps.setString(6, emailFeild);

                    int rows = ps.executeUpdate();
                    if (rows > 0) {
                        JOptionPane.showMessageDialog(StudentRegistration.this, "Student Information added successfully!");
                        stdIdField.setText("");
                        stdNameField.setText("");
                        mobileField.setText("");
                        emailField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(StudentRegistration.this, "Failed to add Student Information.");
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(StudentRegistration.this, "Database error: " + ex.getMessage());
                }
            }
        });

        // Back button action
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AdminDashboard(); // assuming AdminDashboard class exists
            }
        });

        // Add panel to background
        backgroundLabel.add(stdPanel);
        add(backgroundLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}
