package database;

import java.sql.*;
import java.util.ArrayList;

public class SQLiteDatabase {

    public static void main(String[] args) {

    }

    public static Connection connect() {
        Connection conn = null;
        try {
            // database parameters
            String fileName = "C:/Users/redwa/Documents/Uni Work/Software Projects/SoftwareProjectTwo/src/login_info.db";
            // connection string
            String url = "jdbc:sqlite:" + fileName;
            // create database connection
            conn = DriverManager.getConnection(url);
            System.out.println("Database connection successful!");
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insertRecords() {
        Connection conn = connect();
        try {
            String username = "rossedwards";
            String password = "ross";
            int privLvl = 0;
            String SQL = "INSERT INTO LoginInfo(Username,Password,PrivilegeLevel) VALUES(?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(SQL);
            // we don't need to set the ID as it has been defined in the database to auto-increment and as not null
            // we use prepared statements instead of regular statements because the statement needs to accept parameters like the username
            pstmt.setString(1, username);
            System.out.println("username added");
            pstmt.setString(2, password);
            System.out.println("password added");
            pstmt.setInt(3, privLvl);
            System.out.println("privilege level added");
            pstmt.executeUpdate();
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

    public void queryRecords(String username, String password, int privLvl) {
        Connection conn = connect();
        // declare an array list to store the search results
        ArrayList<ArrayList<Object>> data;
        try {
            String SQL = "SELECT Username, Password, PrivilegeLevel FROM LoginInfo WHERE Username = ?";
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.setInt(3,privLvl);
            data = new ArrayList<>();
            ResultSet result = pstmt.executeQuery();
            {
                // loop through the search results
                while(result.next()) {
                    result.getString("Username");
                    result.getString("Password");
                    result.getString("PrivilegeLevel");

                    ArrayList<Object> record = new ArrayList<>();
                    record.add(username);
                    record.add(password);
                    record.add(privLvl);
                    data.add(record);
                }
            }
            printData(data);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateRecord(int ID, String username, String password, int privLvl) {
        String SQL = "UPDATE LoginInfo SET Username = ?, Password = ?, PrivilegeLevel = ? WHERE ID = ?";
        try(Connection conn = connect();
        PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            // set parameters
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setInt(3, privLvl);
            pstmt.setInt(4, ID);
            // save changes
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteRecord(int ID) {
        String SQL = "DELETE FROM LoginInfo WHERE ID = ?";
        Connection conn = connect();

        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, ID);
            pstmt.executeUpdate();
            System.out.println("User deleted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void printData(ArrayList<ArrayList<Object>> data) {
        for (ArrayList<Object> datum : data) {
            for (Object o : datum) {
                System.out.print(o);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
