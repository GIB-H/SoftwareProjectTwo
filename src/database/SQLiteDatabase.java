package database;

import java.sql.*;
import java.util.ArrayList;

public class SQLiteDatabase {
    public static Connection connect() {
        Connection conn = null;
        try {
            // database parameters
            String fileName = "src/database/login_info.db";
            // connection string
            String url = "jdbc:sqlite:" + fileName;
            // create database connection
            conn = DriverManager.getConnection(url);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static boolean verifyLogin(String username, String password) {
        Connection conn = connect();
        String SQL = "SELECT * FROM LoginInfo WHERE Username = ? AND Password = ? OR (Username IS NULL AND Password IS NULL)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet result = pstmt.executeQuery();

            if(result.next()){
                System.out.println("Username & Password are correct");
                conn.close();
                return true;

            } else {
                System.out.println("Username & Password are incorrect");
                return false;
            }
        }
        catch(Exception e){
            System.out.println("Not Logged in");
            return false;
        }


    }
    public static boolean CheckUserName(String username){
        Connection conn = connect();
        String SQL = "SELECT * FROM LoginInfo WHERE Username = ?OR (Username IS NULL)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, username);
            ResultSet result = pstmt.executeQuery();

            if(result.next()){
                System.out.println("Username is already used");
                return false;


            } else {
                System.out.println("Username isnt used");
                return true;
            }
        }
        catch(Exception e){
            System.out.println("username isnt used");
            return true;
        }

    }

    public static void insertRecords(String username, String password, String emailAddress, String firstName, String lastName) {
        Connection conn = connect();
        try {
            String SQL = "INSERT INTO LoginInfo(Username,Password,EmailAddress,FirstName,LastName) VALUES(?,?,?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(SQL);
            // we don't need to set the ID as it has been defined in the database to auto-increment and as not null
            // we use prepared statements instead of regular statements because the statement needs to accept parameters like the username
            pstmt.setString(1, username);
            System.out.println("Your username is " + username + ".");
            pstmt.setString(2, password);
            System.out.println("You are a free member. Subscribe and become a premium user for lots of great discounts and offers!");
            pstmt.setString(3, emailAddress);
            pstmt.setString(4, firstName);
            pstmt.setString(5, lastName);
            System.out.println("Your name is " + firstName + " " + lastName);
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

    public static int accountBalance(String username) {
        // establish database connection
        Connection conn = connect();
        // initialise balance variable
        int accountBalance = 0;
        try {
            // search for balance in user record
            String SQL = "SELECT Balance FROM LoginInfo WHERE Username = " + "'" + username + "'";
            //
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            ResultSet result = pstmt.executeQuery();
            accountBalance = result.getInt("Balance");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return accountBalance;
    }

    public void queryRecords(String username, String password) {
        Connection conn = connect();
        // declare an array list to store the search results
        ArrayList<ArrayList<Object>> data;
        try {
            String SQL = "SELECT Username, Password, PrivilegeLevel FROM LoginInfo WHERE Username = ?";
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
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

    public static void deleteRecord(String username) {
        String SQL = "DELETE FROM LoginInfo WHERE Username = ?";
        Connection conn = connect();

        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, username);
            pstmt.executeUpdate();
            System.out.println("user.User deleted.");
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
