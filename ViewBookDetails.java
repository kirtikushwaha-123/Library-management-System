//
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//public class ViewBookDetails extends JFrame {
//
//    public ViewBookDetails() {
//        setTitle("Library Management System");
//        setLayout(null);
//
//        // Full screen size
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int width = screenSize.width;
//        int height = screenSize.height;
//        setSize(width, height);
//
//        // Background Image
//        ImageIcon image = new ImageIcon("libbb.jpg");
//        Image scaledImage = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
//        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));
//        backgroundLabel.setBounds(0, 0, width, height);
//        add(backgroundLabel);
//
//        // Form Panel
//        JPanel formPanel = new JPanel(null);
//        formPanel.setBackground(new Color(255, 255, 255, 220));
//        int panelWidth = 800, panelHeight = 600;
//        formPanel.setBounds((width - panelWidth) / 2, (height - panelHeight) / 2, panelWidth, panelHeight);
//
//        // Title
//        JLabel title = new JLabel("Manage Books");
//        title.setFont(new Font("Arial", Font.BOLD, 30));
//        title.setBounds((panelWidth - 300) / 2, 20, 300, 40);
//        title.setHorizontalAlignment(SwingConstants.CENTER);
//        formPanel.add(title);
//
//        // Buttons
//        JButton addBook = new JButton("Add Book");
//        JButton updateBook = new JButton("Update Book");
//        JButton deleteBook = new JButton("Delete Book");
//        JButton viewBooks = new JButton("View All Books");
//        JButton viewBooksDetails = new JButton("View Book Details");
//        JButton updateQuantity = new JButton("Update Quantity");
//        JButton backButton = new JButton("Back");
//
//        // Button Coordinates (2 Columns, 3 Rows)
//        int btnWidth = 240, btnHeight = 70;
//        int x1 = 100, x2 = 460;
//        int y1 = 100, y2 = 190, y3 = 280;
//
//        addBook.setBounds(x1, y1, btnWidth, btnHeight);
//        addBook.setBackground(new Color(19,153,12));
//        addBook.setFont(new Font("Arial", Font.BOLD,20));
//
//        updateBook.setBounds(x2, y1, btnWidth, btnHeight);
//        updateBook.setBackground(new Color(19,153,12));
//        updateBook.setFont(new Font("Arial", Font.BOLD,20));
//
//        deleteBook.setBounds(x1, y2, btnWidth, btnHeight);
//        deleteBook.setBackground(new Color(19,153,12));
//        deleteBook.setFont(new Font("Arial", Font.BOLD,20));
//
//        viewBooks.setBounds(x2, y2, btnWidth, btnHeight);
//        viewBooks.setBackground(new Color(19,153,12));
//        viewBooks.setFont(new Font("Arial", Font.BOLD,20));
//
//        viewBooksDetails.setBounds(x1, y3, btnWidth, btnHeight);
//        viewBooksDetails.setBackground(new Color(19,153,12));
//        viewBooksDetails.setFont(new Font("Arial", Font.BOLD,20));
//
//        updateQuantity.setBounds(x2, y3, btnWidth, btnHeight);
//        updateQuantity.setBackground(new Color(19,153,12));
//        updateQuantity.setFont(new Font("Arial", Font.BOLD,20));
//
//        backButton.setBounds((panelWidth - 140) / 2, 480, 140, 40);
//        backButton.setBackground(new Color(255, 102, 0));
//        backButton.setForeground(Color.WHITE);
//
//        // Add buttons to panel
//        formPanel.add(addBook);
//        formPanel.add(updateBook);
//        formPanel.add(deleteBook);
//        formPanel.add(viewBooks);
//        formPanel.add(viewBooksDetails);
//        formPanel.add(updateQuantity);
//        formPanel.add(backButton);
//
//
//        // Add form panel to background
//        backgroundLabel.add(formPanel);
//
//        addBook.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                new AddBook();
//
//            }
//        });
//
//
//        deleteBook.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                new DeleteBook();
//
//            }
//        });
//
//
//        updateBook.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
////                new UpdateBook();
//
//            }
//        });
//
//        viewBooks.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                new AllBooksInLibrary();
//
//            }
//        });
//
//
//
//
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//
//        // Back Button Action
//        backButton.addActionListener(e -> {
//            new AdminDashboard();
//            setVisible(false);
//        });
//    }
//
//    public static void main(String[] args) {
//        new ViewBookDetails();
//    }
//}
