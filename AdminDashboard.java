import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboard extends JFrame {
    private CardLayout cards;
    private JPanel mainPanel;

    public AdminDashboard() {
        setTitle("Library Management System");
        setLayout(null);

        // Fullscreen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Background image
        ImageIcon image = new ImageIcon("libbb.jpg");
        Image scaledImage = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));
        backgroundLabel.setBounds(0, 0, width, height);
        add(backgroundLabel);

        // Sidebar
        JPanel sideBar = new JPanel();
        sideBar.setLayout(null);
        sideBar.setBackground(new Color(46, 58, 89));
        int sideW = 200, sideH = 600;
        int x1 = (width - sideW) / 2 - 350;
        int y1 = (height - sideH) / 2;
        sideBar.setBounds(x1, y1, sideW, sideH);

        // Main Panel
        cards = new CardLayout();
        mainPanel = new JPanel(cards);
        int panelW = 900, panelH = 600;
        int x2 = x1 + sideW, y2 = y1;
        mainPanel.setBounds(x2, y2, panelW, panelH);

        // Sidebar title
        JLabel sidebarTitle = new JLabel("Admin", SwingConstants.CENTER);
        sidebarTitle.setFont(new Font("Arial", Font.BOLD, 20));
        sidebarTitle.setForeground(Color.WHITE);
        sidebarTitle.setBounds(20, 20, 160, 40);
        sideBar.add(sidebarTitle);

        String[] items = {"Dashboard", "Manage Book", "Manage Users", "Issue Book", "Reports"};
        for (int i = 0; i < items.length; i++) {
            String name = items[i];

            if (name.equals("Dashboard")) {
                JPanel dashboardPanel = new JPanel();
                dashboardPanel.setLayout(null);
                dashboardPanel.setOpaque(false);

                String[] titles = {"Total Students", "Total Books", "Issued Books", "Due Books"};
                Color[] colors = {
                        new Color(255, 102, 102),
                        new Color(102, 178, 255),
                        new Color(102, 255, 178),
                        new Color(255, 178, 102)
                };

                // Loop for creating 4 buttons
                for (int j = 0; j < titles.length; j++) {
                    JPanel box = new JPanel();
                    box.setBounds(50 + j * 210, 100, 200, 130);
                    box.setLayout(new BorderLayout());

                    Button btn = new Button(titles[j]);
                    btn.setBackground(colors[j]);
                    btn.setFont(new Font("Arial", Font.BOLD, 18));
                    box.add(btn, BorderLayout.CENTER);

                    int index = j;
                    btn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            new Thread(() -> {
//                                try {
                                //    Thread.sleep(1500); // Simulate loading delay
                                    SwingUtilities.invokeLater(() -> {
                                        switch (index) {
                                            case 0 -> new StudentInformation();
                                            case 1, 3 -> new AllBooksInLibrary();
                                            case 2 -> new IssuedBook();
                                        }
                                    });
//                                }
//                                catch (InterruptedException ex) {
//                                    ex.printStackTrace();
//                                }
                            }).start();
                        }
                    });

                    dashboardPanel.add(box);
                }

                mainPanel.add(dashboardPanel, name);

            } else if (name.equals("Manage Book")) {
                JPanel manageBookPanel = new JPanel();
                manageBookPanel.setLayout(null);
                manageBookPanel.setOpaque(false);

                JButton totalBookBtn = new JButton("Total Book");
                totalBookBtn.setBounds(100, 100, 250, 100);
                totalBookBtn.setFont(new Font("Arial", Font.BOLD, 20));
                manageBookPanel.add(totalBookBtn);

                JButton updateBookBtn = new JButton("Update Book Details");
                updateBookBtn.setBounds(100, 220, 250, 100); // moved below
                updateBookBtn.setFont(new Font("Arial", Font.BOLD, 20));
                manageBookPanel.add(updateBookBtn);

                JButton overdueBookBtn = new JButton("Overdue Book");
                overdueBookBtn.setBounds(100, 340, 250, 100); // moved below
                overdueBookBtn.setFont(new Font("Arial", Font.BOLD, 20));
                manageBookPanel.add(overdueBookBtn);

                JButton addBookBtn = new JButton("Add Book");
                addBookBtn.setBounds(450, 100, 250, 100);
                addBookBtn.setFont(new Font("Arial", Font.BOLD, 20));
                manageBookPanel.add(addBookBtn);

                JButton deleteBookBtn = new JButton("Delete Book");
                deleteBookBtn.setBounds(450, 220, 250, 100);
                deleteBookBtn.setFont(new Font("Arial", Font.BOLD, 20));
                manageBookPanel.add(deleteBookBtn);

                JButton issuedBookBtn = new JButton("Issued Book");
                issuedBookBtn.setBounds(450, 340, 250, 100);
                issuedBookBtn.setFont(new Font("Arial", Font.BOLD, 20));
                manageBookPanel.add(issuedBookBtn);



                mainPanel.add(manageBookPanel, name);

            } else if (name.equals("Manage Users")) {
                JPanel manageUserPanel = new JPanel();
                manageUserPanel.setLayout(null);
                manageUserPanel.setOpaque(false);

                JButton stdInfoBtn = new JButton("Student Information");
                stdInfoBtn.setBounds(100, 100, 250, 100);
                stdInfoBtn.setFont(new Font("Arial", Font.BOLD, 20));
                manageUserPanel.add(stdInfoBtn);

                JButton stdResBtn = new JButton("Student Registration");
                stdResBtn.setBounds(100, 220, 250, 100);
                stdResBtn.setFont(new Font("Arial", Font.BOLD, 20));
                manageUserPanel.add(stdResBtn);

                JButton updStdBtn = new JButton("Update Student Details");
                updStdBtn.setBounds(100, 340, 250, 100);
                updStdBtn.setFont(new Font("Arial", Font.BOLD, 20));
                manageUserPanel.add(updStdBtn);

                JButton delStdBtn = new JButton("Delete Student");
                delStdBtn.setBounds(450, 100, 250, 100);
                delStdBtn.setFont(new Font("Arial", Font.BOLD, 20));
                manageUserPanel.add(delStdBtn);

                JButton InviStdBtn = new JButton("Student Details");
                InviStdBtn.setBounds(450, 220, 250, 100);
                InviStdBtn.setFont(new Font("Arial", Font.BOLD, 20));
                manageUserPanel.add(InviStdBtn);

                mainPanel.add(manageUserPanel, name);

            } else {
                JPanel contentPanel = new JPanel(new BorderLayout());
                contentPanel.setOpaque(false);
                JLabel contentLabel = new JLabel(name + " Content Area", SwingConstants.CENTER);
                contentLabel.setFont(new Font("Arial", Font.BOLD, 24));
                contentPanel.add(contentLabel, BorderLayout.CENTER);

                mainPanel.add(contentPanel, name);
            }

            // Sidebar Buttons
            JButton btn = new JButton(name);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.setForeground(Color.WHITE);
            btn.setBackground(new Color(46, 58, 89));
            btn.setBorderPainted(false);
            btn.setFocusPainted(false);
            btn.setBounds(20, 80 + i * 60, 160, 40);
            btn.addActionListener(e -> cards.show(mainPanel, name));
            sideBar.add(btn);
        }

        backgroundLabel.add(sideBar);
        backgroundLabel.add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AdminDashboard::new);
    }
}
