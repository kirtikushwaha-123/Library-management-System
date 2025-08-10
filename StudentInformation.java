import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//
public class StudentInformation extends JFrame {
    StudentInformation() {
        setTitle("Library Management System ");
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


        JPanel studentDetails = new JPanel();
        studentDetails.setLayout(null);
        studentDetails.setBackground(new Color(255, 255, 255, 220));

        int panelHeight = 600;
        int panelWidth = 800;
        int y = (screenSize.height - panelHeight) / 2;
        int x = (screenSize.width - panelWidth) / 2;
        studentDetails.setBounds(x, y, panelWidth, panelHeight);

        // Title
        JLabel title = new JLabel("Student Information");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(310, 20, 250, 30);
        studentDetails.add(title);


        String[] column = {"Id", "Name", "Course", "Semester", "Mobile Number", "Email ID"};
        DefaultTableModel model = new DefaultTableModel(column, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        // back button
        JButton backBtn = new JButton("Back");
        backBtn.setFont(new Font("Arial", Font.BOLD, 16));
        backBtn.setBounds(200, 510, 120, 35);
        backBtn.setBackground(new Color(0, 153, 76));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener((ActionEvent e) -> dispose());
        studentDetails.add(backBtn);


        // update student details button
        JButton updateBtn = new JButton("Update Details");
        updateBtn.setFont(new Font("Arial", Font.BOLD, 16));
        updateBtn.setBounds(480, 510, 160, 35);
        updateBtn.setBackground(new Color(0, 153, 76));
        updateBtn.setForeground(Color.WHITE);
        updateBtn.addActionListener((ActionEvent e) -> dispose());
        studentDetails.add(updateBtn);


        JTable BooksTable = new JTable(model);
        BooksTable.setFont(new Font("Arial", Font.PLAIN, 14));
        BooksTable.setRowHeight(25);
        BooksTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(BooksTable);
        scrollPane.setBounds(50, 90, 700, 400);
        studentDetails.add(scrollPane);

        new Thread(() -> {
            // fetching the data
            try {
                ConnectionClass con = new ConnectionClass();
                String query = "SELECT * FROM student";
                PreparedStatement ps = con.con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("stdId");
                    String name = rs.getString("stdName");
                    String course = rs.getString("stdcourse");
                    String sem = rs.getString("stdsem");
                    String mobile = rs.getString("stdmobile");
                    String email = rs.getString("stdemail");

                    model.addRow(new Object[]{id, name, course, sem, mobile, email});
                }

            } catch (Exception e) {
                e.printStackTrace();
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(this, "Error fetching data from database: " + e.getMessage());
                });
//                JOptionPane.showMessageDialog(this, "Error fetching data from database."+e.getMessage());
            }

        }).start();


        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = BooksTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(StudentInformation.this, "Please select a book to update.");
                    return;
                }

                // Extract all the selected book's details
                String id = model.getValueAt(selectedRow, 0).toString();
                String name = model.getValueAt(selectedRow, 1).toString();
                String course = model.getValueAt(selectedRow, 2).toString();
                String semester = model.getValueAt(selectedRow, 3).toString();
                String mobileNumber = model.getValueAt(selectedRow, 4).toString();
                String emailId = model.getValueAt(selectedRow, 5).toString();
//

                // Open UpdateBook window
                new StudentUpdateDetails( id, name, course, semester, mobileNumber, emailId);
            }
        });


        backgroundLabel.add(studentDetails);
        add(backgroundLabel);


        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentInformation();
    }
}
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//public class StudentInformation extends JFrame {
//    StudentInformation() {
//        setTitle("Library Management System");
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
//        // Student Details Panel
//        JPanel studentDetails = new JPanel(null);
//        studentDetails.setBackground(new Color(255, 255, 255, 220));
//
//        int panelHeight = 600;
//        int panelWidth = 800;
//        int y = (screenSize.height - panelHeight) / 2;
//        int x = (screenSize.width - panelWidth) / 2;
//        studentDetails.setBounds(x, y, panelWidth, panelHeight);
//
//        // Title
//        JLabel title = new JLabel("Student Information");
//        title.setFont(new Font("Arial", Font.BOLD, 24));
//        title.setBounds(270, 20, 300, 30);
//        studentDetails.add(title);
//
//        // Table setup
//        String[] column = {"Id", "Name", "Gender"};
//        DefaultTableModel model = new DefaultTableModel(column, 0) {
//            public boolean isCellEditable(int row, int column) {
//                return false;
//            }
//        };
//
//        JTable studentTable = new JTable(model);
//        studentTable.setFont(new Font("Arial", Font.PLAIN, 14));
//        studentTable.setRowHeight(25);
//        studentTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
//        JScrollPane scrollPane = new JScrollPane(studentTable);
//        scrollPane.setBounds(50, 90, 700, 400);
//        studentDetails.add(scrollPane);
//
//        // Back Button
//        JButton backBtn = new JButton("Back");
//        backBtn.setFont(new Font("Arial", Font.BOLD, 16));
//        backBtn.setBounds(350, 510, 100, 35);
//        backBtn.setBackground(new Color(0, 153, 76));
//        backBtn.setForeground(Color.WHITE);
//        backBtn.addActionListener((ActionEvent e) -> dispose());
//        studentDetails.add(backBtn);
//
//        // Fetch data without thread (or you can add it inside a thread if needed)
//        try {
//            ConnectionClass con = new ConnectionClass();
//            String query = "SELECT * FROM student";
//            PreparedStatement ps = con.con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                int id = rs.getInt("studentId");
//                String name = rs.getString("studentName");
//                String gender = rs.getString("gender");
//                model.addRow(new Object[]{id, name, gender});
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage());
//        }
//
//        backgroundLabel.add(studentDetails);
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new StudentInformation();
//    }
//}
