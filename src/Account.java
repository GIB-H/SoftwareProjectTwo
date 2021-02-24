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

    public int updateBalance(int amount){
        /*
        A method to increment or decrement the account balance tied with the users account
        This method is called whenever an individual gains points or spends them to update
        their balance.
        */

        return accountBalance + amount;
    }

    public void redeemCode(){
        /*
        SKELETON CODE:

        - Pulls a code from a text box in the GUI

        - Figures out the amount of points to award based on the code
        */

        String code = "EXAMPLE"; // To be updated with the entry in text box instead of null
        int codeValue = 0;       // To be updated with the value of the code instead of 0

        accountBalance = updateBalance(codeValue);
    }
}