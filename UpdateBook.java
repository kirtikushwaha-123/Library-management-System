//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.PreparedStatement;
//
//public class UpdateBook extends JFrame {
//    UpdateBook(String   idField,String nameField,String authorField,String publisherField,String yearField,String quantityField,String ava) {
//        setTitle("Library Management System");
//        setLayout(null);
//
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int width = screenSize.width;
//        int height = screenSize.height;
//        setSize(width, height);
//
//        ImageIcon image = new ImageIcon("libbb.jpg");
//        Image scaledImage = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
//        ImageIcon fullScreenIcon = new ImageIcon(scaledImage);
//        JLabel backgroundLabel = new JLabel(fullScreenIcon);
//        backgroundLabel.setBounds(0, 0, width, height);
//        add(backgroundLabel);
//
//        JPanel updateBook = new JPanel();
//        updateBook.setLayout(null);
//        updateBook.setBackground(new Color(255, 255, 255, 220));
//        int panelHeight = 600;
//        int panelWidth = 800;
//        int y = (height - panelHeight) / 2;
//        int x = (width - panelWidth) / 2;
//        updateBook.setBounds(x, y, panelWidth, panelHeight);
//
//        JLabel title = new JLabel("Update Book Info");
//        title.setFont(new Font("Arial", Font.BOLD, 30));
//        title.setBounds(270, 20, 300, 40);
//        updateBook.add(title);
//
//        JLabel bookId =new JLabel("Book ID : ");
//        bookId.setFont(new Font("Arial", Font.BOLD, 18));
//        bookId.setBounds(100, 90, 150, 30);
//        updateBook.add(bookId);
//
//        JTextField idfield=new JTextField(idField);
//        idfield.setBounds(300, 90, 300, 30);
//        updateBook.add(idfield);
//        idfield.setEditable(false);
//
//
//
//
//        JLabel nameLabel = new JLabel("Book Name:");
//        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        nameLabel.setBounds(100, 140, 150, 30);
//        updateBook.add(nameLabel);
//
//        JTextField nameField1 = new JTextField(nameField);
//        nameField1.setBounds(300, 140, 300, 30);
//        updateBook.add(nameField1);
//
//        JLabel authorLabel = new JLabel("Author:");
//        authorLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        authorLabel.setBounds(100, 190, 150, 30);
//        updateBook.add(authorLabel);
//
//        JTextField authorField1 = new JTextField(authorField);
//        authorField1.setBounds(300, 190, 300, 30);
//        updateBook.add(authorField1);
//
//        JLabel publisherLabel = new JLabel("Publisher:");
//        publisherLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        publisherLabel.setBounds(100, 240, 150, 30);
//        updateBook.add(publisherLabel);
//
//        JTextField publisherField1 = new JTextField(publisherField);
//        publisherField1.setBounds(300, 240, 300, 30);
//        updateBook.add(publisherField1);
//
//        JLabel yearLabel = new JLabel("Published Year:");
//        yearLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        yearLabel.setBounds(100, 290, 150, 30);
//        updateBook.add(yearLabel);
//
//        JTextField yearField1 = new JTextField(yearField);
//        yearField1.setBounds(300, 290, 300, 30);
//        updateBook.add(yearField1);
//
//        JLabel quantityLabel = new JLabel("Quantity:");
//        quantityLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        quantityLabel.setBounds(100, 340, 150, 30);
//        updateBook.add(quantityLabel);
//
//        JTextField quantityField1 = new JTextField(quantityField);
//        quantityField1.setBounds(300, 340, 300, 30);
//        updateBook.add(quantityField1);
//
//        JLabel availableLabel = new JLabel("Available:");
//        availableLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        availableLabel.setBounds(100, 390, 150, 30);
//        updateBook.add(availableLabel);
//
//        JRadioButton yesBtn = new JRadioButton("Yes");
//        JRadioButton noBtn = new JRadioButton("No");
//        yesBtn.setBounds(300, 390, 70, 30);
//        noBtn.setBounds(380, 390, 70, 30);
//        yesBtn.setBackground(new Color(255, 255, 255, 220));
//        noBtn.setBackground(new Color(255, 255, 255, 220));
//        ButtonGroup availabilityGroup = new ButtonGroup();
//        availabilityGroup.add(yesBtn);
//        availabilityGroup.add(noBtn);
//        updateBook.add(yesBtn);
//        updateBook.add(noBtn);
//        if(ava =="true")
//        {
//            yesBtn.setSelected(true);
//        }
//        else{
//            noBtn.setSelected(true);
//        }
//
//        JButton updateButton = new JButton("Update Book");
//        updateButton.setBounds(190, 450, 150, 40);
//        updateButton.setBackground(new Color(0, 102, 255));
//        updateButton.setForeground(Color.WHITE);
//        updateBook.add(updateButton);
//
//        //  back button
//
//        JButton backButton = new JButton("Back");
//        backButton.setBounds(390, 450, 150, 40);
//        backButton.setBackground(new Color(255, 102, 0));
//        backButton.setForeground(Color.WHITE);
//        updateBook.add(backButton);
//
//
//        updateButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String name = nameField1.getText();
//                String author = authorField1.getText();
//                String publisher = publisherField1.getText();
//                String pubYear = yearField1.getText();
//                String quantity = quantityField1.getText();
//                String available = yesBtn.isSelected() ? "YES" : (noBtn.isSelected() ? "NO" : "Not Selected");
//
//                if (name.isEmpty() || author.isEmpty() || publisher.isEmpty() || pubYear.isEmpty() || quantity.isEmpty() || available.equals("Not Selected")) {
//                    JOptionPane.showMessageDialog(UpdateBook.this, "Please fill all fields and select availability!");
//                } else {
//                    // TODO: Add DB update logic here
//
////                    ConnectionClass connection=new ConnectionClass();
//                    try {
//                        ConnectionClass connection = new ConnectionClass();
//
//                        String query = "UPDATE book SET bookName = ?, bookAuthor = ?, bookPublisher = ?, year = ?, quantity = ?, available = ? WHERE bookId = ?";
//                        PreparedStatement ps = connection.con.prepareStatement(query);
//
//                        ps.setString(1, name);
//                        ps.setString(2, author);
//                        ps.setString(3, publisher);
//                        ps.setString(4, pubYear);
//                        ps.setString(5, quantity);
//                        ps.setString(6, ava);
//                        ps.setInt(7, id); // bookId for WHERE clause
//
//                        int rows = ps.executeUpdate();
//
//                        SwingUtilities.invokeLater(() -> {
//                            if (rows > 0) {
//                                JOptionPane.showMessageDialog(UpdateBook.this, "Book updated successfully!");
//                                updateBook.setEnabled(false);
//                            } else {
//                                JOptionPane.showMessageDialog(UpdateBook.this, "Failed to update book.");
//                            }
//                        });
//
//                    } catch (Exception ex) {
//                        SwingUtilities.invokeLater(() -> {
//                            updateBook.setEnabled(true);
//                            JOptionPane.showMessageDialog(UpdateBook.this, "Database error: " + ex.getMessage());
//                        });
//                        ex.printStackTrace();
//                    }
//
//
//                });
//
//        backButton.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
////                new AdminDashboard();
////                setVisible(false);
//            }
//
//        });
//
//        backgroundLabel.add(updateBook);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
////        new UpdateBook();
//    }
//}


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class UpdateBook extends JFrame {
    UpdateBook(String idField, String nameField, String authorField, String publisherField, String yearField, String quantityField) {
        setTitle("Library Management System");
        setLayout(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setSize(width, height);

        ImageIcon image = new ImageIcon("libbb.jpg");
        Image scaledImage = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon fullScreenIcon = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(fullScreenIcon);
        backgroundLabel.setBounds(0, 0, width, height);
        add(backgroundLabel);

        JPanel updateBook = new JPanel();
        updateBook.setLayout(null);
        updateBook.setBackground(new Color(255, 255, 255, 220));
        int panelHeight = 600;
        int panelWidth = 800;
        int y = (height - panelHeight) / 2;
        int x = (width - panelWidth) / 2;
        updateBook.setBounds(x, y, panelWidth, panelHeight);

        JLabel title = new JLabel("Update Book Info");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setBounds(270, 20, 300, 40);
        updateBook.add(title);

        JLabel bookId = new JLabel("Book ID : ");
        bookId.setFont(new Font("Arial", Font.BOLD, 18));
        bookId.setBounds(100, 90, 150, 30);
        updateBook.add(bookId);

        JTextField idfield = new JTextField(idField);
        idfield.setBounds(300, 90, 300, 30);
        updateBook.add(idfield);
        idfield.setEditable(false);

        JLabel nameLabel = new JLabel("Book Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setBounds(100, 140, 150, 30);
        updateBook.add(nameLabel);

        JTextField nameField1 = new JTextField(nameField);
        nameField1.setBounds(300, 140, 300, 30);
        updateBook.add(nameField1);

        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setFont(new Font("Arial", Font.BOLD, 18));
        authorLabel.setBounds(100, 190, 150, 30);
        updateBook.add(authorLabel);

        JTextField authorField1 = new JTextField(authorField);
        authorField1.setBounds(300, 190, 300, 30);
        updateBook.add(authorField1);

        JLabel publisherLabel = new JLabel("Publisher:");
        publisherLabel.setFont(new Font("Arial", Font.BOLD, 18));
        publisherLabel.setBounds(100, 240, 150, 30);
        updateBook.add(publisherLabel);

        JTextField publisherField1 = new JTextField(publisherField);
        publisherField1.setBounds(300, 240, 300, 30);
        updateBook.add(publisherField1);

        JLabel yearLabel = new JLabel("Published Year:");
        yearLabel.setFont(new Font("Arial", Font.BOLD, 18));
        yearLabel.setBounds(100, 290, 150, 30);
        updateBook.add(yearLabel);

        JTextField yearField1 = new JTextField(yearField);
        yearField1.setBounds(300, 290, 300, 30);
        updateBook.add(yearField1);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setFont(new Font("Arial", Font.BOLD, 18));
        quantityLabel.setBounds(100, 340, 150, 30);
        updateBook.add(quantityLabel);

        JTextField quantityField1 = new JTextField(quantityField);
        quantityField1.setBounds(300, 340, 300, 30);
        updateBook.add(quantityField1);


        JButton updateButton = new JButton("Update Book");
        updateButton.setBounds(190, 450, 150, 40);
        updateButton.setBackground(new Color(0, 102, 255));
        updateButton.setForeground(Color.WHITE);
        updateBook.add(updateButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(390, 450, 150, 40);
        backButton.setBackground(new Color(255, 102, 0));
        backButton.setForeground(Color.WHITE);
        updateBook.add(backButton);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField1.getText();
                String author = authorField1.getText();
                String publisher = publisherField1.getText();
                String pubYear = yearField1.getText();
                String quantity = quantityField1.getText();
//                String available = yesBtn.isSelected() ? "YES" : (noBtn.isSelected() ? "NO" : "Not Selected");

                if (name.isEmpty() || author.isEmpty() || publisher.isEmpty() || pubYear.isEmpty() || quantity.isEmpty() ) {
                    JOptionPane.showMessageDialog(UpdateBook.this, "Please fill all fields and select availability!");
                } else {
                    try {
                        ConnectionClass connection = new ConnectionClass();
                        String query = "UPDATE book SET bookName = ?, bookAuthor = ?, bookPublisher = ?, yaer = ?, quantity = ? WHERE bookId = ?";
                        PreparedStatement ps = connection.con.prepareStatement(query);
                        ps.setString(1, name);
                        ps.setString(2, author);
                        ps.setString(3, publisher);
                        ps.setString(4, pubYear);
                        ps.setString(5, quantity);
//                        ps.setString(6, available);
                        int id = Integer.parseInt(idfield.getText());
                        ps.setInt(6, id);

                        int rows = ps.executeUpdate();

                        SwingUtilities.invokeLater(() -> {
                            if (rows > 0) {
                                JOptionPane.showMessageDialog(UpdateBook.this, "Book updated successfully!");
                                updateBook.setEnabled(false);
                            } else {
                                JOptionPane.showMessageDialog(UpdateBook.this, "Failed to update book.");
                            }
                        });

                    } catch (Exception ex) {
                        SwingUtilities.invokeLater(() -> {
                            updateBook.setEnabled(true);
                            JOptionPane.showMessageDialog(UpdateBook.this, "Database error: " + ex.getMessage());
                        });
                        ex.printStackTrace();
                    }
                }
            }
        });

        backButton.addActionListener(e -> dispose());

        backgroundLabel.add(updateBook);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
         new UpdateBook("1", "Book Name", "Author", "Publisher", "2023", "10");
    }
}
