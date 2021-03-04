package user;

public class PremiumUser extends Account {
    PremiumUser(String accountUsername, String firstName,String lastName, String emailAddress, int accountBalance, int privilegeLevel){
        super(accountUsername,firstName,lastName,emailAddress,accountBalance,privilegeLevel);
    }
}
