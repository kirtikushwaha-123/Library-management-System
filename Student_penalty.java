////public class Student_penalty {
////
////}
//
//
//
//import javax.swing.*;
//        import java.awt.*;
//        import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Student_penalty extends JFrame {
//    private JTextField studentIdField, penaltyField;
//
//    public Student_penalty() {
//        setTitle("Library Management System - Student Penalty");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Full screen
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
//        JPanel panel = new JPanel();
//        panel.setLayout(null);
//        panel.setBackground(new Color(255, 255, 255, 220));
//        int panelHeight = 300;
//        int panelWidth = 600;
//        int y = (screenSize.height - panelHeight) / 2;
//        int x = (screenSize.width - panelWidth) / 2;
//        panel.setBounds(x, y, panelWidth, panelHeight);
//
//        // Title
//        JLabel titleLabel = new JLabel("Student Penalty");
//        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
//        titleLabel.setBounds(200, 20, 250, 30);
//        panel.add(titleLabel);
//
//        // Student ID
//        JLabel idLabel = new JLabel("Student ID:");
//        idLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        idLabel.setBounds(80, 80, 150, 30);
//        panel.add(idLabel);
//
//        studentIdField = new JTextField();
//        studentIdField.setBounds(220, 80, 250, 30);
//        panel.add(studentIdField);
//
//        // Penalty
//        JLabel penaltyLabel = new JLabel("Total Penalty:");
//        penaltyLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        penaltyLabel.setBounds(80, 130, 150, 30);
//        panel.add(penaltyLabel);
//
//        penaltyField = new JTextField();
//        penaltyField.setBounds(220, 130, 250, 30);
//        penaltyField.setEditable(false);
//        panel.add(penaltyField);
//
//        // Button
//        JButton fetchBtn = new JButton("Fetch Penalty");
//        fetchBtn.setBounds(220, 190, 150, 40);
//        fetchBtn.setBackground(new Color(70, 130, 180));
//        fetchBtn.setForeground(Color.WHITE);
//        panel.add(fetchBtn);
//
//        // Button Logic
//        fetchBtn.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String studentId = studentIdField.getText().trim();
//                if (!studentId.isEmpty()) {
//                    // TODO: Replace with DB query logic
//                    // Simulate penalty
//                    penaltyField.setText("₹150"); // Sample penalty
//                } else {
//                    JOptionPane.showMessageDialog(null, "Please enter a valid Student ID");
//                }
//            }
//        });
//
//        backgroundLabel.add(panel);
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new Student_penalty();
//    }
//}
//
