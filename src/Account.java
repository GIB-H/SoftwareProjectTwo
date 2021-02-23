public class Account {
    // Creates Account Instance Variables
    String accountUsername;
    String firstName;
    String lastName;
    String emailAddress;
    int accountBalance;
    int privilegeLevel; // 0 = regular user | 1 = premium user | 2 = admin user

    // Account Constructor
    Account(String accountUsername, String firstName,String lastName, String emailAddress, int accountBalance, int privilegeLevel){
        // Sets string attributes
        this.accountUsername = accountUsername;
        this.firstName = firstName;
        this.lastName  = lastName;
        this.emailAddress = emailAddress;
        // Sets integer attributes
        this.accountBalance = accountBalance;
        this.privilegeLevel = privilegeLevel;
    }
}