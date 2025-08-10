//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.sql.*;
//
//public class AllBooksInLibrary extends JFrame {
//
//    public AllBooksInLibrary() {
//        setTitle("Library Management System - All Books");
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//        // Full screen
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        setSize(screenSize.width, screenSize.height);
//        setLayout(null);
//
//        // Background image
//        ImageIcon image = new ImageIcon("libbb.jpg"); // Ensure this file exists in your project
//        Image scaledImage = image.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
//        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));
//        backgroundLabel.setBounds(0, 0, screenSize.width, screenSize.height);
//        backgroundLabel.setLayout(null);
//        add(backgroundLabel);
//
//        // Main panel
//        JPanel allBookDetails = new JPanel();
//        allBookDetails.setLayout(null);
//        allBookDetails.setBackground(new Color(255, 255, 255, 230));
//
//        int panelWidth = 800;
//        int panelHeight = 600;
//        int x = (screenSize.width - panelWidth) / 2;
//        int y = (screenSize.height - panelHeight) / 2;
//        allBookDetails.setBounds(x, y, panelWidth, panelHeight);
//
//        // Title label
//        JLabel title = new JLabel("All Books");
//        title.setFont(new Font("Arial", Font.BOLD, 24));
//        title.setBounds(330, 20, 200, 30);
//        allBookDetails.add(title);
//
//        // Table setup
//        String[] column = {"Id", "Name", "Author", "Publisher", "Year", "Quantity", "Available"};
//        DefaultTableModel model = new DefaultTableModel(column, 0) {
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return false;
//            }
//        };
//
//        JTable booksTable = new JTable(model);
//        booksTable.setFont(new Font("Arial", Font.PLAIN, 14));
//        booksTable.setRowHeight(25);
//        booksTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
//
//        JScrollPane scrollPane = new JScrollPane(booksTable);
//        scrollPane.setBounds(50, 70, 700, 420);
//        allBookDetails.add(scrollPane);
//
//        // Back button
//        JButton backBtn = new JButton("Back");
//        backBtn.setFont(new Font("Arial", Font.BOLD, 16));
//        backBtn.setBounds(200, 510, 120, 35); // Positioned to the left
//        backBtn.setBackground(new Color(0, 153, 76));
//        backBtn.setForeground(Color.WHITE);
//        backBtn.addActionListener((ActionEvent e) -> dispose());
//        allBookDetails.add(backBtn);
//
//        // Update button
//        JButton update_btn = new JButton("Update Details");
//        update_btn.setFont(new Font("Arial", Font.BOLD, 16));
//        update_btn.setBounds(480, 510, 160, 35); // Positioned to the right
//        update_btn.setBackground(new Color(0, 102, 204));
//        update_btn.setForeground(Color.WHITE);
//        update_btn.addActionListener((ActionEvent e) -> {
//            // You can replace this with actual update window navigation
//            JOptionPane.showMessageDialog(this, "Update functionality to be implemented.");
//        });
//        allBookDetails.add(update_btn);
//
//        // Add panel to background
//        backgroundLabel.add(allBookDetails);
//
//        // Fetch and populate data in a new thread
//        new Thread(() -> {
//            try {
//                ConnectionClass con = new ConnectionClass();
//                String query = "SELECT * FROM Book";
//                PreparedStatement ps = con.con.prepareStatement(query);
//                ResultSet rs = ps.executeQuery();
//
//                while (rs.next()) {
//                    int id = rs.getInt("bookId");
//                    String name = rs.getString("bookName");
//                    String author = rs.getString("bookAuthor");
//                    String publisher = rs.getString("bookPublisher");
//                    int year = rs.getInt("year");
//                    int quantity = rs.getInt("quantity");
//                    boolean available = rs.getBoolean("available");
//
//                    model.addRow(new Object[]{id, name, author, publisher, year, quantity, available});
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                SwingUtilities.invokeLater(() -> {
//                    JOptionPane.showMessageDialog(this, "Error fetching data from database: " + e.getMessage());
//                });
//            }
//        }).start();
//
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new AllBooksInLibrary();
//    }
//}


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class AllBooksInLibrary extends JFrame {

    DefaultTableModel model;
    JTable booksTable;

    // Fields for inline editing
    private JTextField idField, nameField, authorField, publisherField, yearField, quantityField;
    private JRadioButton yesBtn, noBtn;
    private ButtonGroup availabilityGroup;
    private JButton saveBtn, cancelBtn;

    public AllBooksInLibrary() {
        setTitle("Library Management System - All Books");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setLayout(null);

        ImageIcon image = new ImageIcon("libbb.jpg");
        Image scaledImage = image.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));
        backgroundLabel.setBounds(0, 0, screenSize.width, screenSize.height);
        backgroundLabel.setLayout(null);
        add(backgroundLabel);

        JPanel allBookDetails = new JPanel();
        allBookDetails.setLayout(null);
        allBookDetails.setBackground(new Color(255, 255, 255, 230));



        int panelWidth = 800;
        int panelHeight = 600;  // made it taller for update panel
        int x = (screenSize.width - panelWidth) / 2;
        int y = (screenSize.height - panelHeight) / 2;
        allBookDetails.setBounds(x, y, panelWidth, panelHeight);

        JLabel title = new JLabel("All Books");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(330, 20, 200, 30);
        allBookDetails.add(title);

        String[] column = {"Id", "Name", "Author", "Publisher", "Year", "Quantity"};
        model = new DefaultTableModel(column, 0) {
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
        scrollPane.setBounds(50, 70, 700, 420);
        allBookDetails.add(scrollPane);

        JButton backBtn = new JButton("Back");
        backBtn.setFont(new Font("Arial", Font.BOLD, 16));
        backBtn.setBounds(200, 510, 120, 35);
        backBtn.setBackground(new Color(0, 153, 76));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener((ActionEvent e) -> dispose());
        allBookDetails.add(backBtn);

        JButton update_btn = new JButton("Update Details");
        update_btn.setFont(new Font("Arial", Font.BOLD, 16));
        update_btn.setBounds(480, 510, 160, 35);
        update_btn.setBackground(new Color(0, 102, 204));
        update_btn.setForeground(Color.WHITE);
        allBookDetails.add(update_btn);

        // Action for Update Details button: show update panel filled with selected row data
//        update_btn.addActionListener(e -> {
//            int selectedRow = booksTable.getSelectedRow();
//            if (selectedRow == -1) {
//                JOptionPane.showMessageDialog(this, "Please select a book to update.");
//                return;
//            }
//
//            // Fill fields with selected book data
//            idField.setText(model.getValueAt(selectedRow, 0).toString());
//            nameField.setText(model.getValueAt(selectedRow, 1).toString());
//            authorField.setText(model.getValueAt(selectedRow, 2).toString());
//            publisherField.setText(model.getValueAt(selectedRow, 3).toString());
//            yearField.setText(model.getValueAt(selectedRow, 4).toString());
//            quantityField.setText(model.getValueAt(selectedRow, 5).toString());
//
//            String id = idField.getText().trim();
//        String name = nameField.getText().trim();
//        String author = authorField.getText().trim();
//        String publisher = publisherField.getText().trim();
//        String yearStr = yearField.getText().trim();
//        String quantityStr = quantityField.getText().trim();
//        String available1 = yesBtn.isSelected() ? "YES" : "NO";
//            int year = Integer.parseInt(yearStr);
//            int quantity = Integer.parseInt(quantityStr);
//
//
//            String available = model.getValueAt(selectedRow, 6).toString();
//            if ("true".equalsIgnoreCase(available) || "YES".equalsIgnoreCase(available)) {
//                yesBtn.setSelected(true);
//            } else {
//                noBtn.setSelected(true);
//            }
//            new UpdateBook(id,name,author,publisher,year,quantity,available1);
//
////            updatePanel.setVisible(true);
//        });

        update_btn.addActionListener(e -> {
            int selectedRow = booksTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a book to update.");
                return;
            }

            // Extract all the selected book's details
            String id =  model.getValueAt(selectedRow, 0).toString();
            String name = model.getValueAt(selectedRow, 1).toString();
            String author = model.getValueAt(selectedRow, 2).toString();
            String publisher = model.getValueAt(selectedRow, 3).toString();
            String  year =  model.getValueAt(selectedRow, 4).toString();
            String  quantity =  model.getValueAt(selectedRow, 5).toString();

            String available = "false";
            Object availObj = model.getValueAt(selectedRow, 6);
            if (availObj instanceof Boolean) {
                available = availObj.toString(); // Convert Boolean to String "true" or "false"
            } else {
                // if stored as string "YES" or "NO"
//                String availStr = availObj.toString();
//                if (availStr.equalsIgnoreCase("yes") || availStr.equalsIgnoreCase("true")) {
//                    available = "true";
//                } else {
//                    available = "false";
//                }
            }


            // Open UpdateBook window
            new UpdateBook( id, name, author, publisher, year, quantity);
        });

        // Load data
        loadBooks();

        backgroundLabel.add(allBookDetails);

        setVisible(true);
    }


    private void loadBooks() {
        model.setRowCount(0);
        new Thread(() -> {
            try {
                ConnectionClass con = new ConnectionClass();
                String query = "SELECT * FROM Book";
                PreparedStatement ps = con.con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("bookId");
                    String name = rs.getString("bookName");
                    String author = rs.getString("bookAuthor");
                    String publisher = rs.getString("bookPublisher");
                    int year = rs.getInt("yaer");
                    int quantity = rs.getInt("quantity");
//                    boolean available = rs.getBoolean("available");

                    SwingUtilities.invokeLater(() -> model.addRow(new Object[]{id, name, author, publisher, year, quantity}));
                }
            } catch (Exception e) {
                e.printStackTrace();
                SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(this, "Error loading books: " + e.getMessage()));
            }
        }).start();
    }

    private void refreshTable() {
        loadBooks();
    }

    public static void main(String[] args) {
        new AllBooksInLibrary();
    }
}

