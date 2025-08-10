//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.*;
//
//public class DeleteBook extends JFrame {
//    private JTextField tf;
//    private DefaultTableModel model;
//    private JTable booksTable;
//
//    DeleteBook() {
//        setTitle("Library Management System - Delete Book");
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        setSize(screenSize.width, screenSize.height);
//        setLayout(null);
//
//        // Background image
//        ImageIcon image = new ImageIcon("libbb.jpg");
//        Image scaledImage = image.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
//        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));
//        backgroundLabel.setBounds(0, 0, screenSize.width, screenSize.height);
//        backgroundLabel.setLayout(null);
//        add(backgroundLabel);
//
//        // Main panel
//        JPanel deleteBook = new JPanel();
//        deleteBook.setLayout(null);
//        deleteBook.setBackground(new Color(255, 255, 255, 230));
//        deleteBook.setBounds((screenSize.width - 800) / 2, (screenSize.height - 600) / 2, 800, 600);
//
//        JLabel title = new JLabel("Delete Books");
//        title.setFont(new Font("Arial", Font.BOLD, 24));
//        title.setBounds(320, 25, 200, 30);
//        deleteBook.add(title);
//
//        // Search label
//        JLabel searchLabel = new JLabel("Book ID:");
//        searchLabel.setFont(new Font("Arial", Font.BOLD, 16));
//        searchLabel.setBounds(250, 80, 100, 30);
//        deleteBook.add(searchLabel);
//
//        // Text field for ID
//        tf = new JTextField();
//        tf.setFont(new Font("Arial", Font.PLAIN, 16));
//        tf.setBounds(350, 80, 150, 30);
//        deleteBook.add(tf);
//
//        // Delete button
//        JButton deleteBtn = new JButton("Delete Book");
//        deleteBtn.setFont(new Font("Arial", Font.BOLD, 16));
//        deleteBtn.setBounds(370, 520, 160, 35);
//        deleteBtn.setBackground(new Color(0, 153, 76));
//        deleteBtn.setForeground(Color.WHITE);
//        deleteBook.add(deleteBtn);
//
//        // Table
//        String[] column = {"Id", "Name", "Author", "Publisher", "Year", "Quantity", "Available"};
//        model = new DefaultTableModel(column, 0) {
//            public boolean isCellEditable(int row, int column) {
//                return false;
//            }
//        };
//
//        booksTable = new JTable(model);
//        booksTable.setFont(new Font("Arial", Font.PLAIN, 14));
//        booksTable.setRowHeight(25);
//        booksTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
//        JScrollPane scrollPane = new JScrollPane(booksTable);
//        scrollPane.setBounds(50, 140, 700, 350);
//        deleteBook.add(scrollPane);
//
//        // Back button
//        JButton backBtn = new JButton("Back");
//        backBtn.setFont(new Font("Arial", Font.BOLD, 16));
//        backBtn.setBounds(250, 520, 100, 35);
//        backBtn.setBackground(new Color(0, 153, 76));
//        backBtn.setForeground(Color.WHITE);
//        deleteBook.add(backBtn);
//
//        // Add panel to background
//        backgroundLabel.add(deleteBook);
//
//        // Back action
//        backBtn.addActionListener(e -> dispose());
//
//        // Delete action
//        deleteBtn.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String idText = tf.getText().trim();
//                if (idText.isEmpty()) {
//                    JOptionPane.showMessageDialog(DeleteBook.this, "Please enter a Book ID.");
//                    return;
//                }
//
//                try {
//                    int bookId = Integer.parseInt(idText);
//                    ConnectionClass con = new ConnectionClass();
//                    String query = "DELETE FROM Book WHERE bookId = ?";
//                    PreparedStatement ps = con.con.prepareStatement(query);
//                    ps.setInt(1, bookId);
//
//                    int rowsAffected = ps.executeUpdate();
//
//                    if (rowsAffected > 0) {
//                        JOptionPane.showMessageDialog(DeleteBook.this, "Book deleted successfully.");
//                        tf.setText("");
//                        fetchData(); // Refresh table
//                    } else {
//                        JOptionPane.showMessageDialog(DeleteBook.this, "Book not found.");
//                    }
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                    JOptionPane.showMessageDialog(DeleteBook.this, "Error: " + ex.getMessage());
//                }
//            }
//        });
//
//        // Load books initially (in a separate thread)
//        new Thread(this::fetchData).start();
//
//        setVisible(true);
//    }
//
//    // Fetch data method
//    private void fetchData() {
//        try {
//            ConnectionClass con = new ConnectionClass();
//            String query = "SELECT * FROM Book";
//            PreparedStatement ps = con.con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//
//            SwingUtilities.invokeLater(() -> {
//                model.setRowCount(0); // Clear previous data
//                try {
//                    while (rs.next()) {
//                        int id = rs.getInt("bookId");
//                        String name = rs.getString("bookName");
//                        String author = rs.getString("bookAuthor");
//                        String publisher = rs.getString("bookPublisher");
//                        int year = rs.getInt("year");
//                        int quantity = rs.getInt("quantity");
//                        boolean available = rs.getBoolean("available");
//                        model.addRow(new Object[]{id, name, author, publisher, year, quantity, available});
//                    }
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            });
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage());
//        }
//    }
//
//    public static void main(String[] args) {
//        new DeleteBook();
//    }
//}
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DeleteBook extends JFrame {
    private JTextField tf;
    private DefaultTableModel model;
    private JTable booksTable;

    DeleteBook() {
        setTitle("Library Management System - Delete Book");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setLayout(null);

        // Background image
        ImageIcon image = new ImageIcon("libbb.jpg");
        Image scaledImage = image.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));
        backgroundLabel.setBounds(0, 0, screenSize.width, screenSize.height);
        backgroundLabel.setLayout(null);
        add(backgroundLabel);

        // Main panel
        JPanel deleteBook = new JPanel();
        deleteBook.setLayout(null);
        deleteBook.setBackground(new Color(255, 255, 255, 230));
        deleteBook.setBounds((screenSize.width - 800) / 2, (screenSize.height - 600) / 2, 800, 600);

        JLabel title = new JLabel("Delete Books");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(320, 25, 200, 30);
        deleteBook.add(title);

        // Search label
        JLabel searchLabel = new JLabel("Book ID:");
        searchLabel.setFont(new Font("Arial", Font.BOLD, 16));
        searchLabel.setBounds(250, 80, 100, 30);
        deleteBook.add(searchLabel);

        // Text field for ID
        tf = new JTextField();
        tf.setFont(new Font("Arial", Font.PLAIN, 16));
        tf.setBounds(350, 80, 150, 30);
        deleteBook.add(tf);

        // Table
        String[] column = {"Id", "Name", "Author", "Publisher", "Year", "Quantity", "Available"};
        model = new DefaultTableModel(column, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        booksTable = new JTable(model);
        booksTable.setFont(new Font("Arial", Font.PLAIN, 14));
        booksTable.setRowHeight(25);
        booksTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(booksTable);
        scrollPane.setBounds(50, 140, 700, 350);
        deleteBook.add(scrollPane);

        // Delete button
        JButton deleteBtn = new JButton("Delete Book");
        deleteBtn.setFont(new Font("Arial", Font.BOLD, 16));
        deleteBtn.setBounds(370, 520, 160, 35);
        deleteBtn.setBackground(new Color(0, 153, 76));
        deleteBtn.setForeground(Color.WHITE);
        deleteBook.add(deleteBtn);

        // Refresh button
        JButton refreshBtn = new JButton("Refresh");
        refreshBtn.setFont(new Font("Arial", Font.BOLD, 16));
        refreshBtn.setBounds(540, 520, 120, 35);
        refreshBtn.setBackground(new Color(0, 102, 204));
        refreshBtn.setForeground(Color.WHITE);
        deleteBook.add(refreshBtn);

        // Back button
        JButton backBtn = new JButton("Back");
        backBtn.setFont(new Font("Arial", Font.BOLD, 16));
        backBtn.setBounds(250, 520, 100, 35);
        backBtn.setBackground(new Color(0, 153, 76));
        backBtn.setForeground(Color.WHITE);
        deleteBook.add(backBtn);

        // Add panel to background
        backgroundLabel.add(deleteBook);

        // Back action
        backBtn.addActionListener(e -> dispose());

        // Refresh action
        refreshBtn.addActionListener(e -> fetchData());

        // Delete action
        deleteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idText = tf.getText().trim();
                if (idText.isEmpty()) {
                    JOptionPane.showMessageDialog(DeleteBook.this, "Please enter a Book ID.");
                    return;
                }

                int bookId;
                try {
                    bookId = Integer.parseInt(idText);
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(DeleteBook.this, "Please enter a valid numeric Book ID.");
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(DeleteBook.this,
                        "Are you sure you want to delete the book with ID " + bookId + "?",
                        "Confirm Deletion", JOptionPane.YES_NO_OPTION);

                if (confirm != JOptionPane.YES_OPTION) {
                    return;
                }

                try {
                    ConnectionClass con = new ConnectionClass();
                    String query = "DELETE FROM Book WHERE bookId = ?";
                    PreparedStatement ps = con.con.prepareStatement(query);
                    ps.setInt(1, bookId);

                    int rowsAffected = ps.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(DeleteBook.this, "Book deleted successfully.");
                        tf.setText("");
                        fetchData(); // Refresh table
                    } else {
                        JOptionPane.showMessageDialog(DeleteBook.this, "Book not found.");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(DeleteBook.this, "Error: " + ex.getMessage());
                }
            }
        });

        // Load books initially (in a separate thread)
        new Thread(this::fetchData).start();

        setVisible(true);
    }

    // Fetch data method
    private void fetchData() {
        try {
            ConnectionClass con = new ConnectionClass();
            String query = "SELECT * FROM Book";
            PreparedStatement ps = con.con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            SwingUtilities.invokeLater(() -> {
                model.setRowCount(0); // Clear previous data
                try {
                    while (rs.next()) {
                        int id = rs.getInt("bookId");
                        String name = rs.getString("bookName");
                        String author = rs.getString("bookAuthor");
                        String publisher = rs.getString("bookPublisher");
                        int year = rs.getInt("yaer");
                        int quantity = rs.getInt("quantity");
//                        boolean available = rs.getBoolean("available");
                        model.addRow(new Object[]{id, name, author, publisher, year, quantity});
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new DeleteBook();
    }
}
