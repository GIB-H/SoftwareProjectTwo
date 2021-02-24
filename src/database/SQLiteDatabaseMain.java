package database;
import java.util.Scanner;

public class SQLiteDatabaseMain {

    public static void main(String[] args) {
        createUser();
        deleteUser();
    }

    public static void createUser() {
        System.out.println("Welcome!");
        SQLiteDatabase app = new SQLiteDatabase();
        Scanner input = new Scanner(System.in);
        System.out.println("Username? ");
        String username = input.next();
        System.out.println("Password? ");
        String password = input.next();
        System.out.println("Email Address?");
        String emailAddress = input.next();
        System.out.println("First Name?");
        String firstName = input.next();
        System.out.println("Last Name?");
        String lastName = input.next();
        app.insertRecords(username, password, emailAddress, firstName, lastName);
    }

    public static void deleteUser() {
        System.out.println("Enter your username to delete your account.");
        SQLiteDatabase app = new SQLiteDatabase();
        Scanner input = new Scanner(System.in);
        String username = input.next();
        app.deleteRecord(username);
    }
}
