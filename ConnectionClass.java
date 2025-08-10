import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionClass {
    Connection con;

    public ConnectionClass() {
        try {
            final String url = "jdbc:mysql://localhost:3306/library";  // Make sure your DB name is correct
            final String root = "root";
            final String password = "1234";

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, root, password);
            System.out.println("Database connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConnectionClass con=new ConnectionClass();
    }

//    jdbc:mysql://localhost:3306/?user=root

    // Method to insert a user (optional, as you had it earlier)
//    public void insertUser(String name, String userId, String password, String gender, String role) {
//        try {
//            String query = "INSERT INTO user (name, userId, password, gender, role) VALUES (?, ?, ?, ?, ?)";
//            PreparedStatement pstmt = con.prepareStatement(query);
//            pstmt.setString(1, name);
//            pstmt.setString(2, userId);
//            pstmt.setString(3, password);
//            pstmt.setString(4, gender);
//            pstmt.setString(5, role.toLowerCase());
//
//            int rowsInserted = pstmt.executeUpdate();
//            if (rowsInserted > 0) {
//                System.out.println("User inserted successfully!");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    // ✅ Method to delete book by ID
    public boolean deleteBookById(String bookId) {
        try {
            String query = "DELETE FROM books WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, bookId);
            int result = pstmt.executeUpdate();
            return result > 0; // true if deletion successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
