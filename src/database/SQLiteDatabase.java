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

    public static boolean verifyLogin(String accountUsername, String accountPassword) {
        Connection conn = connect();
        String SQL = "SELECT * FROM LoginInfo WHERE Username = ? AND Password = ? OR (Username IS NULL AND Password IS NULL)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, accountUsername);
            pstmt.setString(2, accountPassword);
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
    public static boolean CheckUserName(String accountUsername){
        Connection conn = connect();
        String SQL = "SELECT * FROM LoginInfo WHERE Username = ?OR (Username IS NULL)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, accountUsername);
            ResultSet result = pstmt.executeQuery();

            if(result.next()){
                System.out.println("Username is already used");
                conn.close();
                return false;


            } else {
                System.out.println("Username isnt used");
                conn.close();
                return true;
            }
        }
        catch(Exception e){
            System.out.println("accountUsername isnt used");
            return true;
        }

    }

    public static void insertRecords(String accountUsername, String accountPassword, String emailAddress, String firstName, String lastName) {
        Connection conn = connect();
        try {
            String SQL = "INSERT INTO LoginInfo(Username,Password,EmailAddress,FirstName,LastName) VALUES(?,?,?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(SQL);
            // we don't need to set the ID as it has been defined in the database to auto-increment and as not null
            // we use prepared statements instead of regular statements because the statement needs to accept parameters like the username
            pstmt.setString(1, accountUsername);
            System.out.println("Your username is " + accountUsername + ".");
            pstmt.setString(2, accountPassword);
            System.out.println("You are a free member. Subscribe and become a premium user for lots of great discounts and offers!");
            pstmt.setString(3, emailAddress);
            pstmt.setString(4, firstName);
            pstmt.setString(5, lastName);
            System.out.println("Your name is " + firstName + " " + lastName);
            pstmt.executeUpdate();
            conn.close();
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

    public static int accountBalance(String accountUsername) {
        // establish database connection
        Connection conn = connect();
        // initialise balance variable
        int accountBalance = 0;
        try {
            // search for balance in user record
            String SQL = "SELECT Balance FROM LoginInfo WHERE Username = " + "'" + accountUsername + "'";
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

    public static String accountFirstName(String accountUsername) {
        // establish database connection
        Connection conn = connect();
        // initialise first name variable
        String firstName = "";
        try {
            // search for firstname in user record
            String SQL = "SELECT FirstName FROM LoginInfo WHERE Username = " + "'" + accountUsername + "'";
            //
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            ResultSet result = pstmt.executeQuery();
            firstName = result.getString("FirstName");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return firstName;
    }

    public static String accountSecondName(String accountUsername) {
        // establish database connection
        Connection conn = connect();
        // initialise second name variable
        String secondName = "";
        try {
            // search for firstname in user record
            String SQL = "SELECT LastName FROM LoginInfo WHERE Username = " + "'" + accountUsername + "'";
            //
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            ResultSet result = pstmt.executeQuery();
            secondName = result.getString("LastName");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return secondName;
    }

    public static String accountEmailAddress(String accountUsername) {
        // establish database connection
        Connection conn = connect();
        // initialise email address variable
        String emailAddress = "";
        try {
            // search for firstname in user record
            String SQL = "SELECT EmailAddress FROM LoginInfo WHERE Username = " + "'" + accountUsername + "'";
            //
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            ResultSet result = pstmt.executeQuery();
            emailAddress = result.getString("EmailAddress");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return emailAddress;
    }

    public static int privilegeLevel(String accountUsername) {
        // establish database connection
        Connection conn = connect();
        // initialise privilege level variable
        int privilegeLevel = 0;
        try {
            // search for balance in user record
            String SQL = "SELECT PrivilegeLevel FROM LoginInfo WHERE Username = " + "'" + accountUsername + "'";
            //
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            ResultSet result = pstmt.executeQuery();
            privilegeLevel = result.getInt("PrivilegeLevel");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return privilegeLevel;
    }

    public static void UpdatePassword(String username, String newpassword){
        String SQL = "UPDATE LoginInfo SET Password = ? WHERE Username = '" + username + "'";

        try(Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            // set parameters
            pstmt.setString(1, newpassword);
            System.out.println(username);
            System.out.println(newpassword);
            // save changes
            pstmt.executeUpdate();
            conn.close();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateRecord(String accountUsername, String accountPassword, int privLvl) {
        String SQL = "UPDATE LoginInfo SET Username = ?, Password = ?, PrivilegeLevel = ?";
        try(Connection conn = connect();
        PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            // set parameters
            pstmt.setString(1, accountUsername);
            pstmt.setString(2, accountPassword);
            pstmt.setInt(3, privLvl);
            // save changes
            pstmt.executeUpdate();
            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteRecord(String accountUsername) {
        String SQL = "DELETE FROM LoginInfo WHERE Username = ?";
        Connection conn = connect();

        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, accountUsername);
            pstmt.executeUpdate();
            System.out.println("User deleted");
            conn.close();
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
