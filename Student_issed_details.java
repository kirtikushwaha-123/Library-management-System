import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student_issed_details extends JFrame {
    private JTextField idField, nameField;
    private JTable issuedBooksTable;

    public Student_issed_details() {
        setTitle("Library Management System - Issued Book");
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

        // Main panel
        JPanel issuedBook = new JPanel();
        issuedBook.setLayout(null);
        issuedBook.setBackground(new Color(255, 255, 255, 220));

        int panelHeight = 600;
        int panelWidth = 800;
        int y = (screenSize.height - panelHeight) / 2;
        int x = (screenSize.width - panelWidth) / 2;
        issuedBook.setBounds(x, y, panelWidth, panelHeight);

        // Title
        JLabel title = new JLabel("Total Issued Books");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(290, 20, 250, 30);
        issuedBook.add(title);

        // Student ID
        JLabel bookidLabel = new JLabel("Student ID:");
        bookidLabel.setFont(new Font("Arial", Font.BOLD, 18));
        bookidLabel.setBounds(100, 80, 150, 30);
        issuedBook.add(bookidLabel);

        idField = new JTextField();
        idField.setBounds(300, 80, 300, 30);
        idField.setEditable(false);
        issuedBook.add(idField);

        // Student Name
        JLabel nameLabel = new JLabel("Student Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setBounds(100, 130, 150, 30);
        issuedBook.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(300, 130, 300, 30);
        nameField.setEditable(false);
        issuedBook.add(nameField);

        // Table for issued books
        String[] columnNames = {"Book ID", "Book Name", "Author", "Publisher", "Issue Date", "Due Date"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        issuedBooksTable = new JTable(model);
        issuedBooksTable.setFont(new Font("Arial", Font.PLAIN, 14));
        issuedBooksTable.setRowHeight(25);
        issuedBooksTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(issuedBooksTable);
        scrollPane.setBounds(50, 200, 700, 300);
        issuedBook.add(scrollPane);

        // Fetch button
        JButton fetchBtn = new JButton("Fetch Books");
        fetchBtn.setBounds(300, 520, 150, 40);
        fetchBtn.setBackground(new Color(70, 130, 180));
        fetchBtn.setForeground(Color.WHITE);
        fetchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchIssuedBooks();
            }
        });
        issuedBook.add(fetchBtn);

        backgroundLabel.add(issuedBook);
        setVisible(true);
    }

    private void fetchIssuedBooks() {
        // In a real application, this would connect to a database
        // Here's a simulation with sample data

        String studentId = idField.getText().trim();

        if (studentId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Student ID");
            return;
        }

        // Simulate fetching student name
        nameField.setText("John Doe (ID: " + studentId + ")");

        // Clear previous data
        DefaultTableModel model = (DefaultTableModel) issuedBooksTable.getModel();
        model.setRowCount(0);


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new IssuedDetails();
            }
        });
    }
}