package database;
import java.util.Scanner;

public class SQLiteDatabaseMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                What would you like to do?
                1. Create Account
                2. Delete Account""");
        switch (input.nextInt()) {
            case 1 -> createUser();
            case 2 -> deleteUser();
        }
    }

    public static void createUser() {
        System.out.println("Welcome!");
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
        SQLiteDatabase.insertRecords(username, password, emailAddress, firstName, lastName);
    }

    public static void deleteUser() {
        System.out.println("Enter your username to delete your account.");
        Scanner input = new Scanner(System.in);
        String password = input.next();
        SQLiteDatabase.deleteRecord(password);
    }
}
