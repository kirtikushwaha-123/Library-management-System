//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.sql.*;
//
//public class DueBook extends JFrame {
//    DefaultTableModel model;
//    JTable booksTable;
//
//    public DueBook() {
//        setTitle("Library Management System - Due Book");
//        setLayout(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int width = screenSize.width;
//        int height = screenSize.height;
//        setSize(width, height);
//
//        ImageIcon image = new ImageIcon("libbb.jpg");
//        Image scaledImage = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
//        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));
//        backgroundLabel.setBounds(0, 0, width, height);
//        backgroundLabel.setLayout(null);
//
//        JPanel panel = new JPanel();
//        panel.setLayout(new BorderLayout());
//        panel.setBackground(new Color(255, 255, 255, 220));
//        panel.setBounds((width - 800) / 2, (height - 600) / 2, 800, 600);
//
//
//
//
//
//
//
//
//        JLabel title = new JLabel("Due Books List", SwingConstants.CENTER);
//        title.setFont(new Font("Arial", Font.BOLD, 25));
//        title.setBounds(330, 20, 200, 30);
//        panel.add(title);
//
//        String[] columns = {"Book ID", "Book Name", "Author", "Student ID", "Student Name", "Due Date"};
//         model = new DefaultTableModel(columns, 0);
//
//
//
//
//        model = new DefaultTableModel(columns, 0) {
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return false;
//            }
//        };
//
//        booksTable = new JTable(model);
//        booksTable.setFont(new Font("Arial", Font.PLAIN, 14));
//        booksTable.setRowHeight(25);
//        booksTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
//
//        JScrollPane scrollPane = new JScrollPane(booksTable);
//        scrollPane.setBounds(50, 70, 700, 420);
//        panel.add(scrollPane);
//
//
//
//
//
//
//        JTable table = new JTable(model);
//        table.setFont(new Font("Arial", Font.PLAIN, 14));
//        table.setRowHeight(25);
//
////        JScrollPane scrollPane = new JScrollPane(table);
////        panel.add(scrollPane, BorderLayout.CENTER);
//
//        // Load data from database
//        try {
//            ConnectionClass connection = new ConnectionClass();
//            String query = "SELECT bookId, bookName, bookAuthor, stdId, stdName, dueDate FROM issuebook"; // adjust table/column names as needed
//            PreparedStatement ps = connection.con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                String bookId = rs.getString("bookId");
//                String bookName = rs.getString("bookName");
//                String bookAuthor = rs.getString("bookAuthor");
//                String stdId = rs.getString("stdId");
//                String stdName = rs.getString("stdName");
//                String dueDate = rs.getString("dueDate");
//
//                model.addRow(new Object[]{bookId, bookName, bookAuthor, stdId, stdName, dueDate});
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
//        }
//
//        // Back button
//        JButton backBtn = new JButton("Back");
//        backBtn.setFont(new Font("Arial", Font.BOLD, 15));
//        backBtn.setBackground(new Color(0, 102, 204));
//        backBtn.setForeground(Color.WHITE);
//        backBtn.addActionListener(ae -> {
//            setVisible(false);
//            new AdminDashboard(); // adjust as needed
//        });
//        panel.add(backBtn, BorderLayout.SOUTH);
//
//        backgroundLabel.add(panel);
//        add(backgroundLabel);
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new DueBook();
//    }
//}



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class DueBook extends JFrame {
    DefaultTableModel model;
    JTable booksTable;

    public DueBook() {
        setTitle("Library Management System - Due Book");
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

        // Panel for content
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(255, 255, 255, 220));
        panel.setBounds((width - 800) / 2, (height - 600) / 2, 800, 600);

        // Title
        JLabel title = new JLabel("Due Books List", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setBounds(250, 20, 300, 40);
        panel.add(title);

        // Table columns
        String[] columns = {"Book ID", "Book Name", "Author", "Student ID", "Student Name","Issued Date", "Return Date"};
        model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        booksTable = new JTable(model);
        booksTable.setFont(new Font("Arial", Font.PLAIN, 14));
        booksTable.setRowHeight(25);
        booksTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(booksTable);
        scrollPane.setBounds(50, 80, 700, 400);
        panel.add(scrollPane);

        // Back button
        JButton backBtn = new JButton("Back");
        backBtn.setFont(new Font("Arial", Font.BOLD, 15));
        backBtn.setBackground(new Color(0, 102, 204));
        backBtn.setForeground(Color.WHITE);
        backBtn.setBounds(350, 500, 100, 30);
        backBtn.addActionListener(ae -> {
            setVisible(false);
//            new AdminDashboard(); // adjust as per your class
        });
        panel.add(backBtn);

        // Fetch data from DB
        try {
            ConnectionClass connection = new ConnectionClass();
//            String query = "SELECT bookId,  stdId,  returnDate FROM issued_book where CURDATE() > returnDate";
            String query = "SELECT ib.bookId, b.bookName, b.bookAuthor, ib.stdId, s.stdName, ib.issuedDate, ib.returnDate\n" +
                    "            FROM issued_book ib\n" +
                    "            JOIN book b ON ib.bookId = b.bookId\n" +
                    "            JOIN student s ON ib.stdId = s.stdId\n" +
                    "            WHERE CURDATE() > ib.returnDate;";



            PreparedStatement ps = connection.con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String bookId = rs.getString("bookId");
                String bookName = rs.getString("bookName");
                String bookAuthor = rs.getString("bookAuthor");
                String stdId = rs.getString("stdId");
                String stdName = rs.getString("stdName");
                String stdIssed=rs.getString("issuedDate");
                String returnDate = rs.getString("returnDate");

                model.addRow(new Object[]{bookId, bookName, bookAuthor, stdId, stdName,stdIssed, returnDate});
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
        }

        backgroundLabel.add(panel);
        add(backgroundLabel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DueBook();
    }
}
