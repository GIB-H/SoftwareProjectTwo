package user;

import database.SQLiteDatabase;
import encryption.Encrypt;
import sample.Controller;

public class Account {
    /*
    The user.Account superclass is the parent for the user.AdminUser, user.PremiumUser and user.User
    classes that all extend it and add varying functionality depending on the
    priority level of the user. By default, a user will get a conversion of their
    spent money into points for the system.

    However, a premium user will have a bonus modifier to their method of generating
    points as well as access to extra features.

    An Admin will have access to special commands and an additional administration
    interface that allows them to perform purchase simulations etc.
    */

    // Creates user.Account Instance Variables
    String accountUsername;
    String firstName;
    String secondName;
    String emailAddress;
    int accountBalance;
    int privilegeLevel; // 0 = regular user | 1 = premium user | 2 = admin user
    String password;

    // user.Account Class Constructor
    public Account(String accountUsername, String firstName, String secondName, String emailAddress, int accountBalance, int privilegeLevel, String password){
        // Sets string attributes
        Encrypt encrypt = new Encrypt();

        this.accountUsername = accountUsername;
        this.firstName = encrypt.decryptData(firstName);
        this.secondName = encrypt.decryptData(secondName);
        this.emailAddress = emailAddress;
        this.password = password;
        // Sets integer attributes
        this.accountBalance = accountBalance;
        this.privilegeLevel = privilegeLevel;
    }

    public int updateBalance(int amount){
        /*
        A method to increment or decrement the account balance tied with the users account
        This method is called whenever an individual gains points or spends them to update
        their balance. Used within the simPurchase method.
        */

        SQLiteDatabase.accountBalance(accountUsername);

        // CODE TO UPDATE THE DATABASE WITH THE

        return accountBalance + amount;
    }

    public void simPurchase(int purchaseValue){
        /*
        A method that will take in a value and simulate the process of a purchase being made
        this purchase may be made via a card payment etc, this is just an abstraction of that
        so that a users account and point balance can be made dynamic.
        */

        int userBalance = 0;                     // PULLS USER BALANCE FROM DB (NEEDS CODING)
        accountBalance = updateBalance(purchaseValue /100); // Increases the user's balance by 1/100th of the irl purchase
    }

    public String getAccountUsername() {
        return accountUsername;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public int getPrivilegeLevel() {
        return privilegeLevel;
    }

    public String getPassword() {
        return password;
    }

    public void setPrivilegeLevel(int privilegeLevel) {
        this.privilegeLevel = privilegeLevel;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}