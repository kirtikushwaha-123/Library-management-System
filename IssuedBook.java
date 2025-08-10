import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class IssuedBook extends JFrame {
    DefaultTableModel model;
    JTable booksTable;

    public IssuedBook() {
        setTitle("Library Management System - Issued Books");
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
        JLabel title = new JLabel("Issued Books List", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setBounds(250, 20, 300, 40);
        panel.add(title);

        // Table columns
        String[] columns = {"Book ID", "Book Name", "Author", "Student ID", "Student Name", "Issue Date", "Due Date"};
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
        backBtn.setBounds(250, 500, 100, 30);
        backBtn.addActionListener(ae -> {
            setVisible(false);
            new AdminDashboard(); // adjust as per your app
        });
        panel.add(backBtn);

        // particular student issued book
        JButton StdIssue=new JButton("Student Issued Book");
        StdIssue.setFont(new Font("Arial", Font.BOLD, 15));
        StdIssue.setBackground(new Color(0, 102, 204));
        StdIssue.setForeground(Color.WHITE);
        StdIssue.setBounds(450, 500, 200, 30);
        StdIssue.addActionListener(ae -> {
            setVisible(false);
            new IssuedDetails();
        });
        panel.add(StdIssue);

        // Fetch data from DB
        try {
            ConnectionClass connection = new ConnectionClass();
            String query =  "SELECT ib.bookId, b.bookName, b.bookAuthor, ib.stdId, s.stdName, ib.issuedDate, ib.returnDate\n" +
                    "            FROM issued_book ib\n" +
                    "            JOIN book b ON ib.bookId = b.bookId\n" +
                    "            JOIN student s ON ib.stdId = s.stdId\n" +
                    "            ;";
            PreparedStatement ps = connection.con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String bookId = rs.getString("bookId");
                String bookName = rs.getString("bookName");
                String bookAuthor = rs.getString("bookAuthor");
                String stdId = rs.getString("stdId");
                String stdName = rs.getString("stdName");
                String issueDate = rs.getString("issuedDate");
                String dueDate = rs.getString("returnDate");

                model.addRow(new Object[]{bookId, bookName, bookAuthor, stdId, stdName, issueDate, dueDate});
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
        new IssuedBook();
    }
}
