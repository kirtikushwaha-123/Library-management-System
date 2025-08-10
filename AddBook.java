import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class AddBook extends JFrame {

    public AddBook() {
        setTitle("Library Management System");
        setLayout(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setSize(width, height);

        ImageIcon image = new ImageIcon("libbb.jpg");
        Image scaledImage = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));
        backgroundLabel.setBounds(0, 0, width, height);
        add(backgroundLabel);

        JPanel addBook = new JPanel(null);
        addBook.setBackground(new Color(255, 255, 255, 220));
        int panelWidth = 800, panelHeight = 600;
        addBook.setBounds((width - panelWidth) / 2, (height - panelHeight) / 2, panelWidth, panelHeight);

        JLabel title = new JLabel("Add New Book");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setBounds(270, 20, 300, 40);
        addBook.add(title);

        JLabel[] labels = {
                new JLabel("Book ID:"), new JLabel("Book Name:"), new JLabel("Author:"),
                new JLabel("Publisher:"), new JLabel("Published Year:"), new JLabel("Quantity:")
        };

        int y = 80;
        for (JLabel label : labels) {
            label.setFont(new Font("Arial", Font.BOLD, 18));
            label.setBounds(100, y, 150, 30);
            addBook.add(label);
            y += 50;
        }

        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField authorField = new JTextField();
        JTextField publisherField = new JTextField();
        JTextField yearField = new JTextField();
        JTextField quantityField = new JTextField();

        JTextField[] fields = {idField, nameField, authorField, publisherField, yearField, quantityField};
        y = 80;
        for (JTextField field : fields) {
            field.setBounds(300, y, 300, 30);
            addBook.add(field);
            y += 50;
        }

        JButton addButton = new JButton("Add Book");
        JButton resetButton = new JButton("Reset");
        JButton backButton = new JButton("Back");

        addButton.setBounds(160, 460, 140, 40);
        resetButton.setBounds(320, 460, 140, 40);
        backButton.setBounds(480, 460, 140, 40);

        addButton.setBackground(new Color(0, 102, 255));
        resetButton.setBackground(new Color(255, 102, 102));
        backButton.setBackground(new Color(255, 102, 0));

        addButton.setForeground(Color.WHITE);
        resetButton.setForeground(Color.WHITE);
        backButton.setForeground(Color.WHITE);

        addBook.add(addButton);
        addBook.add(resetButton);
        addBook.add(backButton);

        backgroundLabel.add(addBook);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        addButton.addActionListener(e -> {
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String author = authorField.getText().trim();
            String publisher = publisherField.getText().trim();
            String pubYear = yearField.getText().trim();
            String copies = quantityField.getText().trim();
//            String ava = yesBtn.isSelected() ? "YES" : (noBtn.isSelected() ? "NO" : "Not Selected");

            // VALIDATIONS
            if (id.isEmpty() || name.isEmpty() || author.isEmpty() || publisher.isEmpty()
                    || pubYear.isEmpty() || copies.isEmpty() ) {
                JOptionPane.showMessageDialog(AddBook.this, "Please fill all fields and select availability!");
                return;
            }

            if (!id.matches("[a-zA-Z0-9]+")) {
                JOptionPane.showMessageDialog(AddBook.this, "Book ID must be alphanumeric with no spaces.");
                return;
            }

//            if (!name.matches("[\\w\\s]+")) {
//                JOptionPane.showMessageDialog(AddBook.this, "Book Name must only contain letters, digits, and spaces.");
//                return;
//            }

            if (!author.matches("[a-zA-Z\\s]+")) {
                JOptionPane.showMessageDialog(AddBook.this, "Author name must contain only letters and spaces.");
                return;
            }

            if (!publisher.matches("[\\w\\s]+")) {
                JOptionPane.showMessageDialog(AddBook.this, "Publisher name must only contain letters, digits, and spaces.");
                return;
            }

            if (!pubYear.matches("\\d{4}")) {
                JOptionPane.showMessageDialog(AddBook.this, "Published Year must be a 4-digit year.");
                return;
            }

            int yearInt=Integer.parseInt(pubYear);
            int currentYear=java.time.Year.now().getValue();
            if(currentYear<yearInt)
            {
                JOptionPane.showMessageDialog(AddBook.this, "Published Year cannot be greater than the current year (" + currentYear + ").");
                return;
            }

            if (!copies.matches("\\d+") || Integer.parseInt(copies) <= 0) {
                JOptionPane.showMessageDialog(AddBook.this, "Quantity must be a positive number.");
                return;
            }

            // INSERT TO DATABASE
            new Thread(() -> {
                try {
                    ConnectionClass connection = new ConnectionClass();
                    String query = "INSERT INTO book (bookId, bookName, bookAuthor, bookPublisher, yaer, quantity) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement ps = connection.con.prepareStatement(query);
                    ps.setString(1, id);
                    ps.setString(2, name);
                    ps.setString(3, author);
                    ps.setString(4, publisher);
                    ps.setString(5, pubYear);
                    ps.setString(6, copies);
//                    ps.setString(7, ava);

                    int rows = ps.executeUpdate();
                    SwingUtilities.invokeLater(() -> {
                        if (rows > 0) {
                            JOptionPane.showMessageDialog(AddBook.this, "Book added successfully!");
                            idField.setText("");
                            nameField.setText("");
                            authorField.setText("");
                            publisherField.setText("");
                            yearField.setText("");
                            quantityField.setText("");
//                            availabilityGroup.clearSelection();
                        } else {
                            JOptionPane.showMessageDialog(AddBook.this, "Failed to add book.");
                        }
                    });
                } catch (Exception ex) {
                    SwingUtilities.invokeLater(() -> {
                        addButton.setEnabled(true);
                        JOptionPane.showMessageDialog(AddBook.this, "Database error: " + ex.getMessage());
                        ex.printStackTrace();
                    });
                }
            }).start();
        });

        resetButton.addActionListener(e -> {
            idField.setText("");
            nameField.setText("");
            authorField.setText("");
            publisherField.setText("");
            yearField.setText("");
            quantityField.setText("");
//            availabilityGroup.clearSelection();
        });

        backButton.addActionListener(e -> {
//            new AdminDashboard();
            setVisible(false);
        });
    }

    public static void main(String[] args) {
        new AddBook();
    }
}
