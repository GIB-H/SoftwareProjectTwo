package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDatabaseConnection {

    public static void main(String[] args) {
        Connection conn = connect();
    }

    private static Connection connect() {
        Connection conn = null;
        try {
            String fileName = "C:\\Users\\redwa\\IdeaProjects\\SoftwareProjectTwo\\login_info.db";
            String url = "jdbc:sqlite" + fileName;
            conn = DriverManager.getConnection(url);
            System.out.println("Database connection successful!");
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return conn;
    }
}
