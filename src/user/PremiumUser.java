package user;

public class PremiumUser extends Account {
    PremiumUser(String accountUsername, String firstName,String secondName, String emailAddress, int accountBalance, int privilegeLevel, String password){
        super(accountUsername,firstName,secondName,emailAddress,accountBalance,privilegeLevel, password);
    }
}
