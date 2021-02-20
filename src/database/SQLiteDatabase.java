package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLiteDatabase {

    public static void main(String[] args) {
        Connection conn = connect();

        try {
            String username = "rossedwards";
            String password = "ross";
            int privLvl = 0;
            String SQL = "INSERT INTO LoginInfo(Username,Password,PrivilegeLevel) VALUES(?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, username);
            System.out.println("username added");
            pstmt.setString(2, password);
            System.out.println("password added");
            pstmt.setInt(3, privLvl);
            System.out.println("privilege level added");
        } catch (SQLException e) {
             System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static Connection connect() {
        Connection conn = null;
        try {
            String fileName = "login_info.db";
            String url = "jdbc:sqlite:" + fileName;
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
