
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.*;

public class StudentDashboard extends JFrame {
    private CardLayout cards;
    private JPanel mainPanel;
//    private JTextField studentIdField, penaltyField;
    ConnectionClass connectionClass = new ConnectionClass();
    private String userName_id;

    public StudentDashboard(String userName_id) {
        this.userName_id = userName_id;
        initUI();
    }

    public void initUI() {
        setTitle("Library Management System");
        setLayout(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon image = new ImageIcon("libbb.jpg");
        Image scaledImage = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));
        backgroundLabel.setBounds(0, 0, width, height);
        add(backgroundLabel);

        JPanel sideBar = new JPanel();
        sideBar.setLayout(null);
        sideBar.setBackground(new Color(46, 58, 89));
        int sideW = 250, sideH = 600;
        int x1 = (width - sideW) / 2 - 350;
        int y1 = (height - sideH) / 2;
        sideBar.setBounds(x1, y1, sideW, sideH);

        JLabel sidebarTitle = new JLabel("Dashboard", SwingConstants.CENTER);
        sidebarTitle.setFont(new Font("Arial", Font.BOLD, 20));
        sidebarTitle.setForeground(Color.WHITE);
        sidebarTitle.setBounds(20, 20, 210, 40);
        sideBar.add(sidebarTitle);

        cards = new CardLayout();
        mainPanel = new JPanel(cards);
        int panelW = 900, panelH = 600;
        int x2 = x1 + sideW, y2 = y1;
        mainPanel.setBounds(x2, y2, panelW, panelH);

        String[] items = {"Information", "Search Book", "Issued Book", "Book Renewal","Overdue Books" ,"Penalty"};

        for (int i = 0; i < items.length; i++) {
            String name = items[i];

            if (name.equals("Information")) {
                JPanel infoPanel = new JPanel();
                infoPanel.setLayout(null);
                infoPanel.setOpaque(false);

                JPanel detailPanel = new JPanel();
                detailPanel.setLayout(null);
                detailPanel.setOpaque(false);
                detailPanel.setBounds(50, 50, 700, 400);

                JLabel yourId = new JLabel("Your ID:");
                yourId.setFont(new Font("Arial", Font.BOLD, 20));
                yourId.setBounds(50, 20, 150, 30);
                detailPanel.add(yourId);

                TextField yourIdField = new TextField();
                yourIdField.setBounds(220, 20, 300, 30);
                yourIdField.setEditable(false);
                detailPanel.add(yourIdField);

                JLabel yourCourse = new JLabel("Course:");
                yourCourse.setFont(new Font("Arial", Font.BOLD, 20));
                yourCourse.setBounds(50, 70, 150, 30);
                detailPanel.add(yourCourse);

                TextField yourCourseField = new TextField();
                yourCourseField.setBounds(220, 70, 300, 30);
                yourCourseField.setEditable(false);
                detailPanel.add(yourCourseField);

                JLabel yourSemester = new JLabel("Your Semester:");
                yourSemester.setFont(new Font("Arial", Font.BOLD, 20));
                yourSemester.setBounds(50, 120, 150, 30);
                detailPanel.add(yourSemester);

                TextField semesterField = new TextField();
                semesterField.setBounds(220, 120, 300, 30);
                semesterField.setEditable(false);
                detailPanel.add(semesterField);

                JLabel yourMobileNumber = new JLabel("Your Mobile:");
                yourMobileNumber.setFont(new Font("Arial", Font.BOLD, 20));
                yourMobileNumber.setBounds(50, 170, 150, 30);
                detailPanel.add(yourMobileNumber);

                TextField mobileField = new TextField();
                mobileField.setBounds(220, 170, 300, 30);
                mobileField.setEditable(false);
                detailPanel.add(mobileField);

                JLabel yourEmail = new JLabel("Your Email:");
                yourEmail.setFont(new Font("Arial", Font.BOLD, 20));
                yourEmail.setBounds(50, 220, 150, 30);
                detailPanel.add(yourEmail);

                TextField emailField = new TextField();
                emailField.setBounds(220, 220, 300, 30);
                emailField.setEditable(false);
                detailPanel.add(emailField);

                try {
                    String query = "SELECT * FROM student WHERE stdId = ?";
                    PreparedStatement ps = connectionClass.con.prepareStatement(query);
                    ps.setString(1, userName_id.trim());
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        String studentName = rs.getString("stdName");

                        yourIdField.setText(rs.getString("stdId"));
                        yourCourseField.setText(rs.getString("stdcourse"));
                        semesterField.setText(rs.getString("stdsem"));
                        mobileField.setText(rs.getString("stdmobile"));
                        emailField.setText(rs.getString("stdemail"));

                        JLabel nameLabel = new JLabel("Welcome Back, " + studentName);
                        nameLabel.setFont(new Font("Arial", Font.BOLD, 24));
                        nameLabel.setBounds(50, 10, 500, 30);

                        SwingUtilities.invokeLater(() -> {
                            infoPanel.add(nameLabel);
                            infoPanel.revalidate();
                            infoPanel.repaint();
                        });
                    } else {
                        System.out.println("No student found with ID: " + userName_id);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                infoPanel.add(detailPanel);
                mainPanel.add(infoPanel, name);


            }
            else if(name.equals("Search Book")){
                JPanel searchPanel = new JPanel();
                searchPanel.setLayout(null);
                searchPanel.setOpaque(false);

                JLabel title = new JLabel("Search Book");
                title.setFont(new Font("Arial", Font.BOLD, 22));
                title.setBounds(280, 20, 200, 30);
                searchPanel.add(title);

                JLabel searchLabel = new JLabel("Enter Book Name:");
                searchLabel.setFont(new Font("Arial", Font.PLAIN, 18));
                searchLabel.setBounds(100, 80, 150, 30);
                searchPanel.add(searchLabel);

                JTextField searchField = new JTextField();
                searchField.setBounds(260, 80, 300, 30);
                searchPanel.add(searchField);

                JButton searchBtn = new JButton("Search");
                searchBtn.setBounds(580, 80, 100, 30);
                searchPanel.add(searchBtn);

                // Table
                String[] cols = {"Book ID", "Name", "Author", "Publisher", "Year", "Quantity"};
                DefaultTableModel searchModel = new DefaultTableModel(cols, 0);
                JTable bookTable = new JTable(searchModel);
                bookTable.setRowHeight(25);
                JScrollPane scroll = new JScrollPane(bookTable);
                scroll.setBounds(100, 140, 600, 300);
                searchPanel.add(scroll);

                // Search Action
                searchBtn.addActionListener(e -> {
                    String searchText = searchField.getText().trim();
                    searchModel.setRowCount(0); // clear table before search

                    if (searchText.isEmpty()) {
                        JOptionPane.showMessageDialog(StudentDashboard.this, "Please enter a book name.");
                    } else {
                        try {
                            String q = "SELECT * FROM book WHERE bookName LIKE ?";
                            PreparedStatement ps = connectionClass.con.prepareStatement(q);
                            ps.setString(1, "%" + searchText + "%");
                            ResultSet rs = ps.executeQuery();
                            boolean found = false;

                            while (rs.next()) {
                                found = true;
                                Object[] row = {
                                        rs.getString("bookId"),
                                        rs.getString("bookName"),
                                        rs.getString("bookAuthor"),
                                        rs.getString("bookPublisher"),
                                        rs.getString("yaer"),
                                        rs.getInt("quantity")
                                };
                                searchModel.addRow(row);
                            }

                            if (!found) {
                                JOptionPane.showMessageDialog(StudentDashboard.this, "No books found with that name.");
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(StudentDashboard.this, "Database Error: " + ex.getMessage());
                        }
                    }
                });

                mainPanel.add(searchPanel, name);
            }
            else if(name.equals("Overdue Book")) {
                JPanel overduePanel = new JPanel();
                overduePanel.setLayout(null);
                overduePanel.setOpaque(false);

                JLabel titleLabel = new JLabel("Overdue Books");
                titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
                titleLabel.setBounds(250, 20, 300, 30);
                overduePanel.add(titleLabel);

                // Table for overdue books
                String[] columnNames = {"Student ID", "Student Name", "Book ID", "Book Name", "Issue Date", "Due Date"};
                DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                JTable overdueTable = new JTable(model);
                overdueTable.setRowHeight(25);
                overdueTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

                JScrollPane scrollPane = new JScrollPane(overdueTable);
                scrollPane.setBounds(50, 80, 700, 350);
                overduePanel.add(scrollPane);

                try {
                    String query = "SELECT ib.stdId, s.stdName, ib.bookId, b.bookName, ib.issuedDate, ib.returnDate " +
                            "FROM issued_book ib " +
                            "JOIN student s ON ib.stdId = s.stdId " +
                            "JOIN book b ON ib.bookId = b.bookId " +
                            "WHERE ib.returnDate < CURDATE()";

                    PreparedStatement ps = connectionClass.con.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        String stdId = rs.getString("stdId");
                        String stdName = rs.getString("stdName");
                        String bookId = rs.getString("bookId");
                        String bookName = rs.getString("bookName");
                        String issueDate = rs.getString("issuedDate");
                        String dueDate = rs.getString("returnDate");

                        model.addRow(new Object[]{stdId, stdName, bookId, bookName, issueDate, dueDate});
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
                }

                mainPanel.add(overduePanel, name);
            }


            else if (name.equals("Issued Book")) {
                JPanel infoPanel = new JPanel();
                infoPanel.setLayout(null);
                infoPanel.setOpaque(false);

                JPanel detailPanel = new JPanel();
                detailPanel.setLayout(null);
                detailPanel.setOpaque(false);
                detailPanel.setBounds(50, 50, 800, 500);

                JLabel yourId = new JLabel("Your ID:");
                yourId.setFont(new Font("Arial", Font.BOLD, 20));
                yourId.setBounds(50, 20, 150, 30);
                detailPanel.add(yourId);

                TextField yourIdField = new TextField();
                yourIdField.setBounds(220, 20, 300, 30);
                yourIdField.setEditable(false);
                yourIdField.setText(userName_id);
                detailPanel.add(yourIdField);

//                JLabel yourName = new JLabel("Your Name:");
//                yourName.setFont(new Font("Arial", Font.BOLD, 20));
//                yourName.setBounds(50, 70, 150, 30);
//                detailPanel.add(yourName);
//
//                TextField nameField = new TextField();
//                nameField.setBounds(220, 70, 300, 30);
//                nameField.setEditable(false);
//                detailPanel.add(nameField);

                JTable issuedBooksTable = new JTable();
                String[] columnNames = {"Book ID", "Book Name", "Author", "Publisher", "Issue Date", "Due Date"};
                DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                issuedBooksTable.setModel(model);

                JScrollPane scrollPane = new JScrollPane(issuedBooksTable);
                scrollPane.setBounds(50, 100, 700, 300);
                detailPanel.add(scrollPane);

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

                infoPanel.add(detailPanel);
                mainPanel.add(infoPanel, name);

            }
            else if (name.equals("Book Renewal")) {
                JPanel infoPanel = new JPanel(null);
                infoPanel.setOpaque(false);

                JLabel yourId = new JLabel("Student ID:");
                yourId.setFont(new Font("Arial", Font.BOLD, 18));
                yourId.setBounds(50, 50, 100, 30);
                infoPanel.add(yourId);

                JTextField yourIdField = new JTextField(userName_id);
                yourIdField.setBounds(180, 50, 200, 30);
                yourIdField.setEditable(false);
                infoPanel.add(yourIdField);

                JLabel bookId = new JLabel("Book ID:");
                bookId.setFont(new Font("Arial", Font.BOLD, 18));
                bookId.setBounds(300, 50, 100, 30);
                infoPanel.add(bookId);

                JTextField bookIdField = new JTextField();
                bookIdField.setBounds(250, 100, 300, 30);
                infoPanel.add(bookIdField);

                JLabel oldDue = new JLabel("Old Due Date:");
                oldDue.setFont(new Font("Arial", Font.BOLD, 18));
                oldDue.setBounds(100, 150, 150, 30);
                infoPanel.add(oldDue);

                JTextField oldDueField = new JTextField();
                oldDueField.setBounds(250, 150, 300, 30);
                oldDueField.setEditable(false);
                infoPanel.add(oldDueField);

                JLabel newDue = new JLabel("New Due Date:");
                newDue.setFont(new Font("Arial", Font.BOLD, 18));
                newDue.setBounds(100, 200, 150, 30);
                infoPanel.add(newDue);

                JTextField newDueField = new JTextField();
                newDueField.setBounds(250, 200, 300, 30);
                infoPanel.add(newDueField);

                JButton renewBtn = new JButton("Renew Book");
                renewBtn.setBounds(250, 250, 150, 40);
                renewBtn.setBackground(new Color(46, 139, 87));
                renewBtn.setForeground(Color.WHITE);
                infoPanel.add(renewBtn);

// Add table of issued books
                String[] columnNames = {"Book ID", "Book Name", "Author", "Student ID", "Student Name", "Issue Date", "Due Date"};
                DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                JTable issuedBooksTable = new JTable(model);
                JScrollPane scrollPane = new JScrollPane(issuedBooksTable);
                scrollPane.setBounds(50, 300, 700, 200);
                infoPanel.add(scrollPane);

// Fill table with data from DB
                try {
                    ConnectionClass connection = new ConnectionClass();
                    String query = "SELECT ib.bookId, b.bookName, b.bookAuthor, ib.stdId, s.stdName, ib.issuedDate, ib.returnDate " +
                            "FROM issued_book ib " +
                            "JOIN book b ON ib.bookId = b.bookId " +
                            "JOIN student s ON ib.stdId = s.stdId";
                    PreparedStatement ps = connection.con.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        String bookid = rs.getString("bookId");
                        String bookName = rs.getString("bookName");
                        String bookAuthor = rs.getString("bookAuthor");
                        String stdId = rs.getString("stdId");
                        String stdName = rs.getString("stdName");
                        String issueDate = rs.getString("issuedDate");
                        String dueDate = rs.getString("returnDate");


                        model.addRow(new Object[]{bookid, bookName, bookAuthor, stdId, stdName, issueDate, dueDate});
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
                }

// Auto-fill Old Due Date when Book ID loses focus
                bookIdField.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        String bookId = bookIdField.getText().trim();
                        try {
                            ConnectionClass connection = new ConnectionClass();
                            String query = "SELECT returnDate FROM issued_book WHERE bookId = ? AND stdId = ?";
                            PreparedStatement pst = connection.con.prepareStatement(query);
                            pst.setString(1, bookId);
                            pst.setString(2, userName_id);
                            ResultSet rs = pst.executeQuery();

                            if (rs.next()) {
                                oldDueField.setText(rs.getString("returnDate"));
                            } else {
                                oldDueField.setText("");
                                JOptionPane.showMessageDialog(null, "No such issued book found for this student.");
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });

// Renew button logic
                renewBtn.addActionListener(e -> {
                    String bookid = bookIdField.getText().trim();
                    String newDueDate = newDueField.getText().trim();

                    try {
                        ConnectionClass connection = new ConnectionClass();
                        String updateQuery = "UPDATE issued_book SET returnDate = ? WHERE bookId = ? AND stdId = ?";
                        PreparedStatement pst = connection.con.prepareStatement(updateQuery);
                        pst.setString(1, newDueDate);
                        pst.setString(2, bookid);
                        pst.setString(3, userName_id);

                        int rows = pst.executeUpdate();
                        if (rows > 0) {
                            JOptionPane.showMessageDialog(null, "Book due date renewed successfully!");
                            oldDueField.setText(newDueDate);

                        } else {
                            JOptionPane.showMessageDialog(null, "Update failed. Please check Book ID.");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                    }
                });
                mainPanel.add(infoPanel);

            }
            else if (name.equals("Penalty")) {
                JPanel panel = new JPanel(null);
                panel.setOpaque(false);

                JLabel titleLabel = new JLabel("Student Penalty");
                titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
                titleLabel.setBounds(200, 20, 250, 30);
                panel.add(titleLabel);

                JLabel idLabel = new JLabel("Student ID:");
                idLabel.setFont(new Font("Arial", Font.BOLD, 18));
                idLabel.setBounds(80, 80, 150, 30);
                panel.add(idLabel);

                JTextField studentIdField = new JTextField();
                studentIdField.setBounds(220, 80, 250, 30);
                studentIdField.setText(userName_id);
                panel.add(studentIdField);

                JLabel penaltyLabel = new JLabel("Total Penalty:");
                penaltyLabel.setFont(new Font("Arial", Font.BOLD, 18));
                penaltyLabel.setBounds(80, 130, 150, 30);
                panel.add(penaltyLabel);

                JTextField penaltyField = new JTextField();
                penaltyField.setBounds(220, 130, 250, 30);
                penaltyField.setEditable(false);
                panel.add(penaltyField);

                JButton fetchBtn = new JButton("Fetch Penalty");
                fetchBtn.setBounds(220, 190, 150, 40);
                fetchBtn.setBackground(new Color(70, 130, 180));
                fetchBtn.setForeground(Color.WHITE);
                panel.add(fetchBtn);

                fetchBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String studentId = studentIdField.getText().trim();
                        // TODO: Replace with real DB query logic
                        penaltyField.setText("₹150");
                    }
                });

                mainPanel.add(panel, name);
            }

            // Sidebar button
            JButton btn = new JButton(name);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.setForeground(Color.WHITE);
            btn.setBackground(new Color(46, 58, 89));
            btn.setBounds(20, 80 + i * 60, 210, 40);
            btn.setFocusPainted(false);
            btn.addActionListener(e -> cards.show(mainPanel, name));
            sideBar.add(btn);
        }

        backgroundLabel.add(sideBar);
        backgroundLabel.add(mainPanel);
        cards.show(mainPanel, "Information");

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentDashboard("2314"));
    }
}
